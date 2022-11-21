<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :rules = "queryRules" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="主键" prop="c_app_no">
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
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleImport"
          v-hasPermi="['proddata:webAppVhl:import']"
        >导入</el-button>
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

    <el-table v-loading="loading" :data="webAppVhlList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="c_app_no" />
      <el-table-column label="c_model_enery_type" align="center" prop="c_model_enery_type" />
      <el-table-column label="c_print_usagecde" align="center" prop="c_print_usagecde" />
      <el-table-column label="c_print_usagecde_flag" align="center" prop="c_print_usagecde_flag" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['proddata:webAppVhl:update']"
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
        <el-form-item label="主键" prop="c_app_no">
          <el-input disabled v-model="form.c_app_no" placeholder="c_app_no" />
        </el-form-item>
        <el-form-item label="c_model_enery_type" prop="c_model_enery_type">
          <el-input v-model="form.c_model_enery_type" placeholder="请输入c_model_enery_type" />
        </el-form-item>
        <el-form-item label="c_print_usagecde" prop="c_print_usagecde">
          <el-input v-model="form.c_print_usagecde" placeholder="请输入c_print_usagecde" />
        </el-form-item>
        <el-form-item label="c_print_usagecde_flag" prop="c_print_usagecde_flag">
          <el-input v-model="form.c_print_usagecde_flag" placeholder="请输入c_print_usagecde_flag" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">修改能源类型</el-button>
        <el-button type="primary" @click="submitPrintForm">修改使用性质</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px">
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">
          将文件拖到此处，或
          <em>点击上传</em>
        </div>
        <div class="el-upload__tip" slot="tip">
          <el-checkbox v-model="upload.updateSupport" />是否更新已经存在的用户数据
          &nbsp;&nbsp;
          <el-link type="info" style="font-size:12px;color:blue" @click="importTemplate">下载模板</el-link>
        </div>
        <div class="el-upload__tip" style="color:red" slot="tip">提示：仅允许导入“xls”或“xlsx”格式文件！</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

import '@riophae/vue-treeselect/dist/vue-treeselect.css'
import {getAppVhl, update, getList, updatePrint} from '@/api/proddata/webAppVhl'
import {getToken} from "@/utils/auth";

export default {
  name: "webAppVhl",
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
      webAppVhlList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        c_app_no: undefined,
      },
      // 表单参数
      form: {},
      queryRules: {
        c_app_no:{ required: true, message: "c_app_no不能为空", trigger: "blur" },
        //c_model_enery_type:{ required: true, message: "c_model_enery_type不能为空", trigger: "blur" },
      },
      // 表单校验
      rules: {
        /*c_salesman_name:{ required: true, message: "c_conf_group不能为空", trigger: "blur" },
        c_cert_salesman_num:{ required: false, message: "c_conf_id不能为空", trigger: "blur" },
        c_certificate_name:{ required: false, message: "c_conf_nme不能为空", trigger: "blur" },
        c_certificate_phone:{ required: false, message: "c_conf_value不能为空", trigger: "blur" },*/
      },
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/proddata/webAppVhl/importData"
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
        this.webAppVhlList = response.rows;
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
        c_model_enery_type: null,
        c_print_usagecde: null,
        c_print_usagecde_flag: null,
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
      this.ids = selection.map(item => item.c_app_no)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "web_app_vhl新增";
    },
    handleUpdatePrint(){

    },
    /** 修改按钮操作 */
    handleUpdate(row) {

      this.reset();
      const c_app_no = row.c_app_no || this.ids
      getAppVhl(c_app_no).then(response =>{
        this.form = response.data;
        this.open = true;
        this.title = "修改";
      })

    },
    submitPrintForm(){
      updatePrint(this.form).then(response =>{
        this.$modal.msgSuccess("更新成功");
        this.open = false;
        //this.getList();
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
          /*if (this.form.c_app_no != null) {
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
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "江苏燃料种类excel批量更新";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('proddata/webAppVhl/importTemplate', {
        ...this.queryParams
      }, `江苏燃料种类模板_${new Date().getTime()}.xlsx`)
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert(response.msg, "导入结果", { dangerouslyUseHTMLString: true });
      //this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    },
    /** 删除按钮操作 */
    /*handleDelete(row) {
      const c_pk_ids = row.c_app_no || this.ids;
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
