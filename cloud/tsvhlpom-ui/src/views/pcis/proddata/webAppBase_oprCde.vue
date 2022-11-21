<template>
  <div class="app-container">
    <span>提示：修改web_app_base的c_opr_cde（操作员代码）字段</span>
    <el-row> </el-row>
    <el-form :model="queryParams" ref="queryForm" :rules = "queryRules" :inline="true" v-show="showSearch" label-width="100px">
        <el-form-item label="申请单号" prop="c_app_no">
          <el-input
            v-model="queryParams.c_app_no"
            placeholder="请输入申请单号"
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
      <!--<el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['proddata:webAppBase:save']"
        >新增</el-button>
      </el-col>-->
      <!--<el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['proddata:webAppBase:update']"
        >修改</el-button>
      </el-col>-->
      <!--<el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['proddata:webAppBase:delete']"
        >删除</el-button>
      </el-col>-->
    </el-row>

    <el-table v-loading="loading" :data="webAppBaseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="申请单号" align="center" prop="c_app_no" />
      <el-table-column label="操作员代码" align="center" prop="c_opr_cde" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['proddata:webAppBase_oprCde:update']"
          >修改</el-button>
          <!--<el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['proddata:webAppBase:delete']"
          >删除</el-button>-->
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
        <el-form-item label="申请单号" prop="c_app_no">
          <el-input disabled v-model="form.c_app_no" placeholder="c_app_no" />
        </el-form-item>
        <el-form-item label="操作员代码" prop="c_opr_cde">
          <el-input v-model="form.c_opr_cde" placeholder="请输入c_opr_cde" />
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
import {getWebAppBaseWithOprCde, updateOprCde} from '@/api/proddata/webAppBase'

export default {
  name: "webAppBase_oprcde",
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
      webAppBaseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        c_ply_no: undefined,
      },
      // 表单参数
      form: {},
      queryRules: {
        c_opr_cde:{ required: true, message: "操作员代码不能为空", trigger: "blur" },
        c_app_no:{ required: true, message: "申请单号不能为空", trigger: "blur" },
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
      getWebAppBaseWithOprCde(this.queryParams.c_app_no).then(response => {
        this.webAppBaseList = response.rows;
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
        c_app_no: null,
        c_opr_cde: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      if (this.queryParams.c_app_no == '' || typeof(this.queryParams.c_app_no) == 'undefined') {
        this.$message.error("申请单号不能为空");
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
      this.ids = selection.map(item => item.c_app_no)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "web_app_base新增";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.$confirm('是否确认修改'+row.c_app_no+'的操作员代码为001310?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return updateOprCde(row.c_app_no);
      }).then(() => {
        this.queryParams.c_app_no = row.c_app_no;
        this.getList();
        this.$modal.msgSuccess("更新成功");
      })

      //const c_ply_no = row.c_ply_no || this.ids
      /*getWebAppBase(c_ply_no).then(response =>{
        this.form = response.data;
        this.open = true;
        this.title = "WebAppBase修改";
      })*/
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateOprCde(this.form).then(response =>{
            this.$modal.msgSuccess("更新成功");
            this.open = false;
            this.queryParams.c_app_no = this.form.c_app_no
            this.getList();
          })
          /*if (this.form.c_pk_id != null) {
            updatewebAppBase(this.form).then(response =>{
              this.$modal.msgSuccess("更新成功");
              this.open = false;
              this.getList();
            })
          } else {
            savewebAppBase(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            })
          }*/

        }
      });
    },
    /** 删除按钮操作 */
    /*handleDelete(row) {
      const c_pk_ids = row.c_pk_id || this.ids;
      this.$confirm('是否确认删除选中的数据?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return deletewebAppBase(c_pk_ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      })
    },*/
  }
};
</script>
