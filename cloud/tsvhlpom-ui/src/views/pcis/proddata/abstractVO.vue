<template>
  <div class="app-container">

    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" :rules="queryRules" label-width="150px">
      <el-form-item label="选择修改类型" prop="c_type">
        <el-select v-model="queryParams.c_type" placeholder="请选择修改类型" clearable size="small" filterable @change="resetFormAndData()">
          <el-option
            v-for="dict in dict.type.sys_pcis_edit_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
            @change="resetFormAndData"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="投保单号" prop="c_app_no">
        <el-input
          v-model="queryParams.c_app_no"
          placeholder="请输入投保单号"
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
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
        >更新重点客户创建时间</el-button>
      </el-col>
      <!--<el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['proddata:abstractVO:save']"
        >新增</el-button>
      </el-col>-->
     <!-- <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['proddata:abstractVO:update']"
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
          v-hasPermi="['proddata:abstractVO:delete']"
        >删除</el-button>
      </el-col>-->
    </el-row>

    <el-table v-loading="loading" :data="abstractVOList">
     <!-- <el-table-column type="selection" width="55" align="center" />-->
      <el-table-column label="投保单号" align="center" prop="c_app_no" />
      <el-table-column v-if="queryParams.c_type =='0'" label="邮箱" align="center" prop="c_email" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['proddata:abstract:update']"
          >修改</el-button>
          <!--<el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['proddata:basConfig:delete']"
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

    <!-- 添加修改 投被保险人邮箱 -->
    <el-dialog  :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" label-width="150px">
        <el-form-item label="投保单号" prop="c_app_no">
          <el-input v-model="form.c_app_no" placeholder="请输入投保单号" disabled aria-required="true"/>
        </el-form-item>
        <el-form-item v-if="queryParams.c_type == '0'" label="邮箱" prop="c_email">
          <el-input v-model="form.c_email" placeholder="请输入邮箱" aria-required="true" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
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
          <!--          <el-checkbox v-model="upload.updateSupport" />是否更新已经存在的用户数据-->
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
import {getAbstractVOList, updateEmail} from '@/api/proddata/abstractVO'
import { getToken } from '@/utils/auth'

export default {
  name: "abstractVO",
  dicts: ['sys_pcis_edit_type'],
  data() {
    return {
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
        url: process.env.VUE_APP_BASE_API + "/proddata/abstract/updateCreateTimeByExport"
      },
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
      abstractVOList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        c_type: undefined,
        c_app_no: undefined
      },
      // 表单参数
      form: {},
      queryRules: {
        c_type: {required: true, message: "请选择修改类型", trigger: "blur"},
        c_app_no: {required: true, message: "投保单号不能为空", trigger: "blur"},
      },
      /*// 表单校验
      rules: {
        c_conf_group:{ required: true, message: "c_conf_group不能为空", trigger: "blur" },
        c_conf_id:{ required: true, message: "c_conf_id不能为空", trigger: "blur" },
        c_conf_nme:{ required: true, message: "c_conf_nme不能为空", trigger: "blur" },
        c_conf_value:{ required: true, message: "c_conf_value不能为空", trigger: "blur" },
      },*/
    };
  },
  created() {
    //this.getList();
  },
  methods: {
    handleImport() {
      this.upload.title = "更新创建时间";
      this.upload.open = true;

    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('proddata/abstract/importTemplate', {
        ...this.queryParams
      }, `创建时间模板_${new Date().getTime()}.xlsx`)
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
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    },
    resetFormAndData(){
      this.reset();
      this.abstractVOList=[];
    },
    getList() {
      this.loading = true;
      this.$refs["queryForm"].validate(valid =>{
        if(valid){
          getAbstractVOList(this.queryParams).then(response => {
            this.abstractVOList = response.rows;
            this.total = response.total;
            this.loading = false;
          });
        }
        this.loading = false;
      })
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
        c_email: null
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
    /*// 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.c_pk_id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },*/
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.form.c_app_no = row.c_app_no;

      //修改投被保险人邮箱
      if(this.queryParams.c_type == '0'){
        this.open= true;
        this.form.c_email = row.c_email;
        this.title = "投被保险人邮箱修改";
      }
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if(this.queryParams.c_type == '0'){
            updateEmail(this.form).then(response =>{
              this.$modal.msgSuccess("更新成功");
              this.open = false;
              this.getList();
            })
          }
        }
      });
    },
  }
};
</script>
