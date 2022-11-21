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
        <el-button type="success" icon="el-icon-refresh" size="mini" @click="handleInitGbData">数据初始化</el-button>
      </el-form-item>
    </el-form>

    <el-table v-loading="loading" :data="gbdataList">
      <el-table-column label="月份" align="center" prop="month" />
      <el-table-column label="中间表数据状态" align="center" prop="middleDataStatus" >
        <template slot-scope="scope">
          <span v-if="scope.row.middleDataStatus == ''">未处理</span>
          <span v-if="scope.row.middleDataStatus == '1'">处理中</span>
          <span v-if="scope.row.middleDataStatus == '2'">处理完毕</span>
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
          <span v-if="scope.row.csvStatus == ''">无记录</span>
          <span v-if="scope.row.csvStatus == '1'">有异常</span>
          <span v-if="scope.row.csvStatus == '2'">无异常</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
          :disabled = "scope.row.csvStatus != '2'"
            size="mini"
            type="text"
            icon="el-icon-show"
            @click="handleShowErrMsg(scope.row)"
            v-hasPermi="['batchdata:gbMonthData:showErrMsg']"
          >错误信息</el-button>
          <!--<el-button
            size="mini"
            type="text"
            icon="el-icon-download"
            @click="handleDownload(scope.row)"
            v-hasPermi="['taishanpic:vip:delete']"
          >下载</el-button>-->
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['batchdata:gbMonthData:delete']"
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

    <!-- 添加或修改人文关怀对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-button type="primary" size="small" @click="handleDownLoadErrMsg">下载</el-button>
      <el-button type="primary" size="small" @click="cancel">关闭</el-button>
      <br>{{errMsg}}
    </el-dialog>
  </div>
</template>

<script>

import {getGbdataList, handleInitData, deleteGbData, getErrMsg,downLoadErrMsg} from "@/api/batchdata/gbdata";

export default {
  name: "gbdata",
  data() {
    return {
      errMsg: '',
      dialog_month: '',
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
      gbdataList: [],
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
      getGbdataList(this.queryParams.month).then(response => {
        this.gbdataList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.dialog_month = '';
      this.open = false;
    },
    handleDownLoadErrMsg(){
      this.download('/batchdata/gbMonthData/downLoadErrMsg?month='+this.dialog_month, {}, this.dialog_month+`光博异常数据.txt`)
      /*downLoadErrMsg({month:this.dialog_month}).then(data =>{
        console.log(data);
      });*/
      this.cancel();
    },
    handleShowErrMsg(row){
      this.dialog_month = '';
      getErrMsg({month:row.month}).then(data =>{
        this.open = true;
        this.errMsg = data;
        this.dialog_month = row.month;
      });
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    handleInitGbData(){
      if(this.queryParams.month == null){
        this.$message({ message: '请选择数据日期', type: 'error' });
        return ;
      }
      handleInitData({month:this.queryParams.month});
      this.$message("数据生成较慢请2个小时后重新查询");
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },




    /** 删除按钮操作 */
    handleDelete(row) {
      this.$confirm('是否确认删除'+row.month+'的数据?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return deleteGbData({month:row.month});
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('vip/vip_main/exportVip', {
        ...this.queryParams
      }, `vip客户信息导出_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "VIP客户信息导入";
      this.upload.open = true;
    },
  }
};
</script>
