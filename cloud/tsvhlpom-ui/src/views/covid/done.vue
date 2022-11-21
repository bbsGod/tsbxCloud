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
      <el-form-item label="时间" prop="day">
        <el-date-picker
          v-model="queryParams.day"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择时间"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        <el-button type="success" icon="el-icon-download" size="mini" @click="exportUndoEmp">未登记人员详情</el-button>
      </el-form-item>
      <br>
    </el-form>
    <el-table v-loading="loading" :data="doneList">
      <el-table-column label="总公司/分公司" align="center" prop="c_parent_dept"></el-table-column>
      <el-table-column label="总部部门/各机构" align="center" prop="c_dept">
      </el-table-column>
      <el-table-column label="已填写" align="center" prop="c_done"/>
      <el-table-column label="未填写" align="center" prop="c_undone"/>
      <el-table-column label="未填写人员详情" align="center">
        <template slot-scope="scope">
          <el-button size="mini" type="text" @click="showUnDoneDetial(scope.row)">查看</el-button>
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
    <el-dialog title="未填写人员详情" :visible.sync="open" width="500px" append-to-body>
      <ul v-for="data in undoneList">{{data}}</ul>
    </el-dialog>
  </div>
</template>

<script>
import {getDoneResult,getUndoneDetial} from "@/api/covid/covid";
import {getDept, treeselect} from "@/api/system/dept";
import SelectDept from "@/components/SelectDept";
export default {
  name: "doneList",
  dicts: ['sys_covid_color','sys_covid_test_no','sys_covid_test_result'],
  data() {
    return {
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
      doneList: [],
      undoneList:[],
      untotal: 0,
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
        day: undefined,
      },
      selectData2:[],
      selectData1: SelectDept,
      parentDeptFlag:false,
      deptFlag:false,
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
    let date = new Date();
    let month = date.getMonth()+1;
    let day = date.getFullYear()+"-"+month+"-"+date.getDate();
    this.queryParams.day = day;
  },
  methods: {
    showUnDoneDetial(row){
      this.loading = true;
      this.undoneList = [];
      row.day = this.queryParams.day;
      getUndoneDetial(row).then(
        response => {
          this.open = true;
          this.undoneList = response.data;
          this.untotal = response.total;
          this.loading = false;
        }
      ).catch(this.loading = false);
    },
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
      if(typeof(this.queryParams.day) =='undefined' || this.queryParams.day == null || this.queryParams.day == ''){
          this.$message({type:"error",message:'请选择查询时间'});
          this.loading = false;
          return;
      }
      getDoneResult(this.queryParams).then(
        response => {
          this.doneList = response.rows;
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
      this.handleQuery();
    },
    handleExport() {
      if(typeof(this.queryParams.day) =='undefined' || this.queryParams.day == null || this.queryParams.day == ''){
        this.$message({type:"error",message:'请选择查询时间'});
        this.loading = false;
        return;
      }
      this.download('covid/covid/exportDoneList', {
        ...this.queryParams
      }, `打卡信息导出_${new Date().getTime()}.xlsx`)
    },
    exportUndoEmp(){
      if(typeof(this.queryParams.day) =='undefined' || this.queryParams.day == null || this.queryParams.day == ''){
        this.$message({type:"error",message:'请选择查询时间'});
        this.loading = false;
        return;
      }
      this.download('covid/covid/exportUnDoneList', {
        ...this.queryParams
      }, `未登记人员信息导出_${new Date().getTime()}.xlsx`)

    }
  }
};
</script>

<style scoped>

</style>
