<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :rules = "queryRules" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="主键" prop="c_app_no">
        <el-input
          v-model="queryParams.c_pk_id"
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

    <el-table v-loading="loading" :data="webBasNoVhlFeePropConfList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="c_pk_id" />
      <el-table-column label="c_scheme_list" align="center" prop="c_scheme_list" />
      <el-table-column label="c_vhl_typ" align="center" prop="c_vhl_typ" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['proddata:webBasNoVhlFeePropConf:update']"
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
        <el-form-item label="主键" prop="c_pk_id">
          <el-input disabled v-model="form.c_pk_id" placeholder="c_pk_id" />
        </el-form-item>
        <el-form-item label="c_scheme_list" prop="c_scheme_list">
          <el-input v-model="form.c_scheme_list" placeholder="请输入c_scheme_list" />
        </el-form-item>
        <el-form-item label="c_vhl_typ" prop="c_vhl_typ">
          <el-input v-model="form.c_vhl_typ" placeholder="请输入c_vhl_typ" />
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
import {getNoVhlConfig, update,getList} from '@/api/proddata/webBasNoVhlFeePropConf'

export default {
  name: "webBasNoVhlFeePropConf",
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
      webBasNoVhlFeePropConfList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        c_pk_id: undefined,
      },
      // 表单参数
      form: {},
      queryRules: {
        c_pk_id:{ required: true, message: "c_pk_id不能为空", trigger: "blur" },
        c_scheme_list:{ required: true, message: "c_scheme_list不能为空", trigger: "blur" },
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
      getList(this.queryParams).then(response => {
        this.webBasNoVhlFeePropConfList = response.rows;
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
        c_pk_id: null,
        c_scheme_list: null,
        c_vhl_typ: null,
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
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.c_pk_id)
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

      this.reset();
      const c_pk_id = row.c_pk_id || this.ids
      getNoVhlConfig(c_pk_id).then(response =>{
        this.form = response.data;
        this.open = true;
        this.title = "修改";
      })

    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          update(this.form).then(response =>{
            this.$modal.msgSuccess("更新成功");
            this.open = false;
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
