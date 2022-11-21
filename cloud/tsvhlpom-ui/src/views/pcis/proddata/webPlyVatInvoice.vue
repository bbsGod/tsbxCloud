<template>
  <div class="app-container">

    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="保单号" prop="c_ply_no">
        <el-input
          v-model="queryParams.c_ply_no"
          placeholder="请输入保单号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-table v-loading="loading" :data="webPlyVatInvoiceList">
      <el-table-column label="保单号" align="center" prop="c_ply_no" />
      <el-table-column label="状态" align="center" prop="c_status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['proddata:webPlyVatInvoice:update']"
          >修改</el-button>
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
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="150px">
        <el-form-item label="保单号" prop="c_ply_no">
          <el-input disabled v-model="form.c_ply_no" placeholder="请输入保单号" />
        </el-form-item>
        <el-form-item label="状态" prop="c_status">
          <el-input v-model="form.c_status" placeholder="请输入c_status" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

import '@riophae/vue-treeselect/dist/vue-treeselect.css'
import {getVatList, updateStatus} from '@/api/proddata/webPlyVatInvoice'

export default {
  name: "webPlyVatInvoice",
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
      webPlyVatInvoiceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        c_ply_no: undefined,
        c_status: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        c_ply_no:{ required: true, message: "保单号不能为空", trigger: "blur" },
        c_status:{ required: true, message: "状态不能为空", trigger: "blur" },
      },
    };
  },
  methods: {
    getList() {
      this.loading = true;
      if(this.queryParams.c_ply_no == '' || typeof(this.queryParams.c_ply_no) == 'undefined' ){
        this.loading = false;
        this.$message.error("保单号不能为空！")
        return ;
      } else {
        getVatList(this.queryParams).then(response => {
          this.webPlyVatInvoiceList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      }
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        c_ply_no: null,
        c_status: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      //this.handleQuery();
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.form.c_status = row.c_status;
      this.form.c_ply_no = row.c_ply_no;
      this.open = true;
      this.title = "WEB_PLY_VAT_INVOICE状态修改";
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateStatus(this.form).then(response =>{
            this.$modal.msgSuccess("更新成功");
            this.open = false;
            this.queryParams.c_ply_no = this.form.c_ply_no
            this.getList();
          })

        }
      });
    },
  }
};
</script>
