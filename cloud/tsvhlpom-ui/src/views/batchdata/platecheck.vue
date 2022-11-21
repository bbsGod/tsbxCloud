<template>
  <div class="app-container">

    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="数据日期" prop="month">
        <el-date-picker
          v-model="queryParams.month"
          type="month"
          value-format="yyyy-MM"
          placeholder="Pick a month"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">查询</el-button>
        <el-button type="success" icon="el-icon-refresh" size="mini" @click="handleGenCheckData">生成数据</el-button>
      </el-form-item>
    </el-form>

    <el-table v-loading="loading" :data="platecheckList">
      <el-table-column label="月份" align="center" prop="month" />
      <el-table-column label="zip文件状态" align="center" prop="zipStatus" >
        <template slot-scope="scope">
          <span v-if="scope.row.zipStatus == ''">未处理</span>
          <span v-if="scope.row.zipStatus == '1'">处理中</span>
          <span v-if="scope.row.zipStatus == '2'">处理完毕</span>
        </template>
      </el-table-column>
      <!--<el-table-column label="csv文件状态" align="center" prop="csvStatus" >
        <template slot-scope="scope">
          <span v-if="scope.row.csvStatus == ''">未处理</span>
          <span v-if="scope.row.csvStatus == '1'">处理中</span>
          <span v-if="scope.row.csvStatus == '2'">处理完毕</span>
        </template>
      </el-table-column>-->
      <el-table-column label="错误状态" align="center" prop="errStatus">
        <template slot-scope="scope">
          <span v-if="scope.row.errStatus == ''">无记录</span>
          <span v-if="scope.row.errStatus == '1'">有异常</span>
          <span v-if="scope.row.errStatus == '2'">无异常</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!--<el-button
            :disabled = "scope.row.csvStatus != '2'"
            size="mini"
            type="text"
            icon="el-icon-show"
            @click="handleShowErrMsg(scope.row)"
            v-hasPermi="['batchdata:gbMonthData:showErrMsg']"
          >错误信息</el-button>-->
          <el-button
            size="mini"
            type="text"
            icon="el-icon-download"
            @click="handleDownload(scope.row)"
            v-hasPermi="['batchdata:plateCheck:download']"
          >下载</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['batchdata:plateCheck:delete']"
          >删除</el-button>
          <!--<el-button
            size="mini"
            type="text"
            icon="el-icon-insert"
            @click="handleReCreateCSV(scope.row)"
            v-hasPermi="['taishanpic:vip:delete']"
          >重新生成cdv</el-button>-->
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

import {getPalteCheckList,deleteCheckData,genCheckData} from "@/api/batchdata/plateCheck";

export default {
  name: "vpdc",
  data() {
    return {
      // 遮罩层
      loading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 人文关怀表格数据
      platecheckList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        month: undefined,
      },
    };
  },
  created() {
    /*let date = new Date();
    //date.setMonth(new Date().getMonth() -1);

    this.queryParams.month = date.getFullYear()+'-'+date.getMonth();*/
    this.getList();

  },
  methods: {
    /** 查询人文关怀列表 */
    getList() {
      this.loading = true;
      getPalteCheckList(this.queryParams.month).then(response => {
        this.platecheckList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
    },
    handleDownload(row){
      this.download('/batchdata/vpdc/download?month='+row.month, {}, row.month+`对账文件.zip`)
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    handleGenCheckData(){
      if(this.queryParams.month == null){
        this.$message({ message: '请选择数据日期', type: 'error' });
        return ;
      }
      genCheckData({month:this.queryParams.month}).then(
        this.$message("数据生成较慢请2个小时后重新查询")
      )

    },
    /** 删除按钮操作 */
    handleDelete(row) {
      this.$confirm('是否确认删除'+row.month+'的对账数据?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return deleteCheckData({month:row.month});
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      })
    },
  }
};
</script>
