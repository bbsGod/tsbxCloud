<template>
  <div class="app-container">

    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="150px">
        <el-form-item label="重点客户标识" prop="sp_id">
          <el-input
            v-model="queryParams.sp_id"
            placeholder="请输入重点客户标识"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="重点客户标识名称" prop="sp_name">
          <el-input
            v-model="queryParams.sp_name"
            placeholder="请输入重点客户标识名称"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input
            v-model="queryParams.name"
            placeholder="请输入姓名"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="部门" prop="dept">
          <el-input
            v-model="queryParams.dept"
            placeholder="请输入部门"
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
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
        >导入</el-button>
      </el-col>
<!--      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
        >导出</el-button>
      </el-col>-->
    </el-row>

    <el-table v-loading="loading" :data="personList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="重点客户标识" align="center" prop="sp_id" />
      <el-table-column label="重点客户标识名称" align="center" prop="sp_name" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="部门" align="center" prop="dept" />
      <el-table-column label="服务标志" align="center" prop="service_flag" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
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
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="重点客户标识" prop="sp_id">
          <el-input v-model="form.sp_id" placeholder="请输入重点客户标识" />
        </el-form-item>
        <el-form-item label="重点客户名称" prop="sp_name">
          <el-input v-model="form.sp_name" placeholder="请输入重点客户名称" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="部门" prop="dept">
          <el-input v-model="form.dept" placeholder="请输入部门"/>
        </el-form-item>
        <el-form-item label="服务标志" prop="service_flag">
          <el-input v-model="form.service_flag" placeholder="请输入服务标志" />
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


import {getToken} from "@/utils/auth";
import {getPersonList,getPersonById,save,update,delPerson} from '@/api/cargroup/person'

export default {
  name: "Cargroup_person",
  components: {},
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
      personList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      updateFlag: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        sp_id: undefined,
        sp_name: undefined,
        name: undefined,
        dept: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        sp_id:{ required: true, message: "不能为空", trigger: "blur" },
        sp_name:{ required: true, message: "不能为空", trigger: "blur" },
        name:{ required: true, message: "不能为空", trigger: "blur" },
        dept:{ required: true, message: "不能为空", trigger: "blur" },
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
        url: process.env.VUE_APP_BASE_API + "/cargroup/basePerson/importData"
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getList() {
      this.loading = true;
      getPersonList(this.queryParams).then(response => {
        this.personList = response.rows;
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
        sp_id: null,
        sp_name: null,
        name: null,
        dept: null,
        service_flag: null,
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
      this.ids = selection.map(item => item.pkId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.updateFlag = false;
      this.reset();
      this.open = true;
      this.title = "清单信息新增";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const sp_id = row.sp_id || this.ids
      getPersonById(sp_id).then(response =>{
        this.form = response.data;
        this.open = true;
        this.updateFlag = true;
        this.title = "清单信息修改";
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.updateFlag) {
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
      const pkids = row.sp_id || this.ids;
      this.$confirm('是否确认删除选中的数据?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delPerson(pkids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    /*handleExport() {
      this.download('cargroup/basePerson/exportVip', {
        ...this.queryParams
      }, `vip客户信息导出_${new Date().getTime()}.xlsx`)
    },*/
    /*    handleExport() {
          this.download('vip/vip_main/exportVip', {
            ...this.queryParams
          }, `vip_${new Date().getTime()}.xlsx`)
          /!*const queryParams = this.queryParams;
          this.$modal.confirm('是否确认导出所有VIP客户信息数据项?').then(function() {
            return exportVip(queryParams);
          }).then(response => {
            this.download(response.msg);
          })*!/
        },*/
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "清单信息导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('cargroup/basePerson/importTemplate', {
        ...this.queryParams
      }, `清单模板_${new Date().getTime()}.xlsx`)
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
  }
};
</script>
