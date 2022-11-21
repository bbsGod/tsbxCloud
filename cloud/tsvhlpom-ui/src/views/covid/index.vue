<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true">
      <el-form-item label="总公司/分公司" prop="c_parent_dept">
        <el-select v-model="queryParams.c_parent_dept" clearable placeholder="请选择" @change="getRole($event)" :disabled="parentDeptFlag">
          <el-option
            v-for="item in selectData1"
            :key="item.value"
            :label="item.text"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="总部部门/各机构" prop="c_dept">
        <el-select v-model="queryParams.c_dept" filterable clearable
                   placeholder="请输入查询内容" :loading="loading" :disabled="deptFlag">
          <el-option
            v-for="item in selectData2"
            :key="item.value"
            :label="item.text"
            :value="item.value"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="姓名" prop="c_name">
        <el-input
          v-model="queryParams.c_name"
          placeholder="请输入姓名"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="健康码颜色" prop="c_health_color">
        <el-select v-model="queryParams.c_health_color" placeholder="请选择颜色" clearable size="small" filterable>
          <el-option
            v-for="dict in dict.type.sys_covid_color"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="行程码颜色" prop="c_tour_color">
        <el-select v-model="queryParams.c_tour_color" placeholder="请选择颜色" clearable size="small" filterable>
          <el-option
            v-for="dict in dict.type.sys_covid_color"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item  label="时间范围" prop="create_time">
        <el-date-picker
          v-model="dateRange"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        <el-button type="warning"  plain icon="el-icon-download" size="mini" @click="handleExport">导出</el-button>
      </el-form-item>
      <br>
    </el-form>
    <el-table v-loading="loading" :data="covidList">
      <el-table-column label="总公司/分公司" align="center" prop="c_parent_dept"></el-table-column>
      <el-table-column label="总部部门/各机构" align="center" prop="c_dept">
      </el-table-column>
      <el-table-column label="姓名" align="center" prop="c_name"/>
      <el-table-column label="身份证号" align="center" prop="c_id_no"/>
      <el-table-column label="手机号" align="center" prop="c_phone"/>
      <el-table-column label="健康码颜色" align="center" prop="c_health_color">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.c_health_color" :options="dict.type.sys_covid_color"></dict-tag>
          <el-image v-if="scope.row.c_health_img"
            style="width: 100px; height: 100px"
            :src="scope.row.c_health_img"
            :fit="fit"
            :preview-src-list="[scope.row.c_health_img]"
          >
          </el-image>
        </template>
      </el-table-column>
      <el-table-column label="行程码颜色" align="center" prop="c_tour_color">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.c_tour_color" :options="dict.type.sys_covid_color"></dict-tag>
          <el-image v-if="scope.row.c_tour_img"
            style="width: 100px; height: 100px"
            :src="scope.row.c_tour_img"
            :fit="fit"
            :preview-src-list="[scope.row.c_tour_img]"
          >
          </el-image>
        </template>
      </el-table-column>
      <el-table-column label="核酸检测轮数" align="center" prop="c_test_nos">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_covid_test_no" :value="scope.row.c_test_nos"></dict-tag>
        </template>
      </el-table-column>
      <el-table-column label="核酸检测结果" align="center" prop="c_test_result">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_covid_test_result" :value="scope.row.c_test_result"></dict-tag>
        </template>
      </el-table-column>
      <el-table-column label="核酸检测报告" align="center" prop="c_test_img">
        <template slot-scope="scope">
          <el-button v-if="scope.row.c_test_img" size="mini" @click="handleShowTest(scope.row)">查看报告</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
  </div>
</template>

<script>
import {listCovid} from "@/api/covid/covid";
import {getDept, treeselect} from "@/api/system/dept";
import SelectDept from "@/components/SelectDept";
export default {
  name: "covid",
  dicts: ['sys_covid_color','sys_covid_test_no','sys_covid_test_result'],
  data() {
    return {
      parentDeptFlag:false,
      deptFlag:false,
      dateRange:[],//时间范围
      // 部门列表
      deptOptions: undefined,
      sexOptions: undefined,
      // 遮罩层
      loading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 总条数
      total: 0,
      // 日期表格数据
      covidList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示弹出层（数据权限）
      openDataPopup: false,
      // 节假日日期
      dayDate: "",

      // 表单参数
      form: {},

      // 表单校验
      rules: {},

      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        c_parent_dept: undefined,
        c_dept: undefined,
        c_name: undefined,
        c_health_color: undefined,
        c_tour_color: undefined,
        t_create_tm: undefined,
      },
      selectData2:[],
      selectData1: SelectDept,
    };
  },
  created() {
    let loginUser = this.$store.state.user.loginUser;
    this.resetForm("queryForm");

    if (loginUser.remark == 'com') {
      this.getRole(loginUser.dept.deptId+"");
      this.queryParams.c_parent_dept = loginUser.dept.deptId+'';
      this.parentDeptFlag = true;
    }
    if (loginUser.remark == 'dept') {
      this.getRole(loginUser.dept.parentId+"");
      this.queryParams.c_parent_dept = loginUser.dept.parentId+"";
      this.queryParams.c_dept = loginUser.dept.deptId+"";
      this.parentDeptFlag = true;
      this.deptFlag = true;
    }
  },
  methods: {
    getRole (prov) {
      console.log(prov);
      let roles = [];
      this.selectData2= [];
      this.queryParams.c_dept='';
      for (let val of SelectDept) {
        if (prov===val.value) {
          roles = val.children;
        }
        this.selectData2 = roles;
      }
    },
    /** 查询部门下拉树结构 */
    getTreeselect() {
      treeselect().then(response => {
        this.deptOptions = response.data;
      });
    },
    /** 查询已输入假日列表 */
    getList() {
      this.loading = true;
      listCovid(this.addDateRange(this.queryParams,this.dateRange)).then(
        response => {
          this.covidList = response.rows;
          this.total = response.total;
          this.loading = false;
        }
      );
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.dateRange = [];
      this.handleQuery();
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('covid/covid/exportInfo', {
        ...this.queryParams
      }, `防疫信息导出_${new Date().getTime()}.xlsx`)
    },
    handleShowTest(row){
      var name = `防疫信息_${new Date().getTime()}`;
      let url = "";
      url = row.c_test_img;
      console.log("url:"+url)
      var suffix = url.substring(url.lastIndexOf("."), url.length);
      const a = document.createElement('a')
      a.setAttribute('download', name + suffix)
      a.setAttribute('target', '_blank')
      a.setAttribute('href', url)
      a.click()
    }
  }
};
</script>

<style scoped>

</style>
