<template>
  <div class="app-container">
    <span>提示：根据机构编码修改web_oth_manager_email的邮箱</span>
    <el-row> </el-row>
    <el-form :model="queryParams" ref="queryForm" :rules = "queryRules" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="机构编码" prop="c_dpt_cde">
        <el-input
          v-model="queryParams.c_dpt_cde"
          placeholder="请输入机构编码"
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

    <el-row :gutter="10" class="mb8">

    </el-row>

    <el-table v-loading="loading" :data="webOthManagerEmailList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="机构编码" align="center" prop="c_dpt_cde" />
      <el-table-column label="邮箱" align="center" prop="c_email" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['prod26:webOthManagerEmail:update']"
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
        <el-form-item label="邮箱" prop="c_email">
          <el-input v-model="form.c_email" placeholder="请输入正确邮箱" />
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
import {getWebOthManagerEmailList,updateWebOthManagerEmail} from '@/api/prod26/webOthManagerEmail'
import {getToken} from "@/utils/auth";

export default {
  name: "webOthManagerEmail",
  data() {
    return {
      webOthManagerEmailList: [],
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
      webAppBaseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        c_dpt_cde: undefined,
        c_email: undefined,
      },
      // 表单参数
      form: {},
      queryRules: {
        c_dpt_cde:{ required: true, message: "机构编码 不能为空", trigger: "blur" },
      },
      // 表单校验
      rules: {
        /*c_salesman_name:{ required: true, message: "c_conf_group不能为空", trigger: "blur" },
        c_cert_salesman_num:{ required: false, message: "c_conf_id不能为空", trigger: "blur" },
        c_certificate_name:{ required: false, message: "c_conf_nme不能为空", trigger: "blur" },
        c_certificate_phone:{ required: false, message: "c_conf_value不能为空", trigger: "blur" },*/
      },
    };
  },
  created() {
    // this.getList();
  },
  methods: {
    getList() {
      this.loading = true;
      getWebOthManagerEmailList(this.queryParams).then(response => {
        this.webOthManagerEmailList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        c_dpt_cde: null,
        c_email: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      if (this.queryParams.c_dpt_cde == '' || typeof(this.queryParams.c_dpt_cde) == 'undefined') {
        this.$message.error("机构编码不能为空");
        return ;
      }
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.c_dpt_cde)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.form.c_dpt_cde = row.c_dpt_cde;
      this.open = true;
      this.title = "WebOthManagerEmail修改";
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateWebOthManagerEmail(this.form).then(response =>{
            this.$modal.msgSuccess("更新成功");
            this.open = false;
            this.queryParams.c_dpt_cde = this.form.c_dpt_cde
            this.getList();
          })
        }
      });
    },
  }
};
</script>
