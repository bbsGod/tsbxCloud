<template>
  <div class="app-container">

    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="系统代码" prop="c_from_code">
        <el-input
          v-model="queryParams.c_from_code"
          placeholder="请输入系统代码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="系统名称" prop="c_info">
        <el-input
          v-model="queryParams.c_info"
          placeholder="请输入系统名称"
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

    <el-table v-loading="loading" :data="tblPasswordList">
      <el-table-column label="系统代码" align="center" prop="c_from_code" />
      <el-table-column label="系统名称" align="center" prop="c_info" />
      <el-table-column label="密码" align="center" prop="c_password" />
      <el-table-column label="创建时间" align="center" prop="t_crt_time" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['proddata:tblPassword:update']"
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
        <el-form-item label="系统旧代码" prop="c_from_code_old">
          <el-input  v-model="form.c_from_code_old" placeholder="请输入保单号" />
        </el-form-item>
        <el-form-item label="系统新代码" prop="c_from_code">
          <el-input  v-model="form.c_from_code" placeholder="请输入保单号" />
        </el-form-item>
        <el-form-item label="密码" prop="c_password">
          <el-input v-model="form.c_password" placeholder="请输入c_status" />
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
import {getTblPasswordList, update} from '@/api/proddata/tblPassword'

export default {
  name: "tblPassword",
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
      tblPasswordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        c_from_code: undefined,
        c_info: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        c_from_code:{ required: true, message: "新代码不能为空", trigger: "blur" },
        c_from_code_old:{ required: true, message: "老代码不能为空", trigger: "blur" },
        c_password:{ required: true, message: "密码不能为空", trigger: "blur" },
      },
    };
  },
  methods: {
    getList() {
      this.loading = true;
      if(this.queryParams.c_from_code == '' || typeof(this.queryParams.c_from_code) == 'undefined' ){
        this.loading = false;
        this.$message.error("系统代码不能为空！")
        return ;
      } else {
        getTblPasswordList(this.queryParams).then(response => {
          this.tblPasswordList = response.rows;
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
        c_from_code: null,
        c_from_code_old: null,
        c_password: null,
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
      this.form.c_from_code_old = row.c_from_code;
      this.form.c_from_code = row.c_from_code;
      this.form.c_password = row.c_password;
      this.open = true;
      this.title = "typt.tbl_password状态修改";
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          update(this.form).then(response =>{
            this.$modal.msgSuccess("更新成功");
            this.open = false;
            this.queryParams.c_from_code = this.form.c_from_code
            this.getList();
          })

        }
      });
    },
  }
};
</script>
