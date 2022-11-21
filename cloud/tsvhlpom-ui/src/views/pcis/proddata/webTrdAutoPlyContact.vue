<template>
  <div class="app-container">

    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="联系人姓名" prop="c_contact_nme">
        <el-input
          v-model="queryParams.c_contact_nme"
          placeholder="请输入联系人姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="部门代码" prop="c_dpt_cde">
        <el-input
          v-model="queryParams.c_dpt_cde"
          placeholder="请输入部门代码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="c_phone_no">
        <el-input
          v-model="queryParams.c_phone_no"
          placeholder="请输入手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="c_email">
        <el-input
          v-model="queryParams.c_email"
          placeholder="请输入邮箱"
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
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['proddata:plyContact:save']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['proddata:plyContact:update']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['proddata:plyContact:delete']"
        >删除</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="webTrdAutoPlyContactList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="联系人姓名" align="center" prop="c_contact_nme" />
      <el-table-column label="部门代码" align="center" prop="c_dpt_cde" />
      <el-table-column label="手机号" align="center" prop="c_phone_no" />
      <el-table-column label="邮箱" align="center" prop="c_email" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['proddata:plyContact:update']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['proddata:plyContact:delete']"
          >删除</el-button>
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
        <el-form-item label="联系人姓名" prop="c_contact_nme">
          <el-input v-model="form.c_contact_nme" placeholder="联系人姓名" />
        </el-form-item>
        <el-form-item label="部门代码" prop="c_dpt_cde">
          <el-input v-model="form.c_dpt_cde" placeholder="请输入部门代码" />
        </el-form-item>
        <el-form-item label="手机号" prop="c_phone_no">
          <el-input v-model="form.c_phone_no" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="邮箱" prop="c_email">
          <el-input v-model="form.c_email" placeholder="请输入邮箱" />
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
import {getWebTrdAutoPlyContactList, getWebTrdAutoPlyContact,deletePlyContact,update,save} from '@/api/proddata/webTrdAutoPlyContact'

export default {
  name: "plyContact",
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
      webTrdAutoPlyContactList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        c_contact_nme: undefined,
        c_dpt_cde: undefined,
        c_phone_no: undefined,
        c_email: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        c_contact_nme:{ required: true, message: "联系人名称不能为空", trigger: "blur" },
        c_dpt_cde:{ required: true, message: "部门代码不能为空", trigger: "blur" },
        c_phone_no:{ required: true, message: "手机号不能为空", trigger: "blur" },
        c_email:{ required: true, message: "邮箱不能为空", trigger: "blur" },
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getList() {
      this.loading = true;
      getWebTrdAutoPlyContactList(this.queryParams).then(response => {
        this.webTrdAutoPlyContactList = response.rows;
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
        c_contact_nme: null,
        c_dpt_cde: null,
        c_phone_no: null,
        c_email: null,
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
      this.title = "保单落地失败联系人新增";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const c_pk_id = row.c_pk_id || this.ids
      getWebTrdAutoPlyContact(c_pk_id).then(response =>{
        this.form = response.data;
        this.open = true;
        this.title = "保单落地失败联系人修改";
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.c_pk_id != null) {
            update(this.form).then(response =>{
              this.$modal.msgSuccess("更新成功");
              this.open = false;
              this.getList();
            })
          } else {
            save(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            })
          }

        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const c_pk_ids = row.c_pk_id || this.ids;
      this.$confirm('是否确认删除选中的数据?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return deletePlyContact(c_pk_ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      })
    },
  }
};
</script>
