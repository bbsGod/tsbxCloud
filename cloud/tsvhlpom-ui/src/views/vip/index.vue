<template>
  <div class="app-container">

    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <!--<el-form-item label="所在单位" prop="deptid">
        <treeselect v-model="queryParams.deptid" :options="deptOptions" placeholder="请选择单位" style="width: 200px"/>
      </el-form-item>-->
      <el-row colspan="3">
      <el-form-item label="被保人名称" prop="insuredName">
        <el-input
          v-model="queryParams.insuredName"
          placeholder="请输入被保人名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="证件号码" prop="certifCode">
        <el-input
          v-model="queryParams.certifCode"
          placeholder="请输入证件号码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="phoneNo">
        <el-input
          v-model="queryParams.phoneNo"
          placeholder="请输入手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      </el-row>
      <el-row colspan="3">
      <el-form-item label="车牌号" prop="plateNo">
        <el-input
          v-model="queryParams.plateNo"
          placeholder="请输入车牌号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车架号" prop="frmNo">
        <el-input
          v-model="queryParams.frmNo"
          placeholder="请输入车架号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发动机号" prop="engNo">
        <el-input
          v-model="queryParams.engNo"
          placeholder="请输入发动机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      </el-row>
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
          v-hasPermi="['taishanpic:vip:add']"
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
          v-hasPermi="['taishanpic:vip:edit']"
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
          v-hasPermi="['taishanpic:vip:delete']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['taishanpic:vip:upload']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['taishanpic:vip:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="vipList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="是否已承保" align="center" prop="status" />
      <el-table-column label="被保人名称" align="center" prop="insuredName" />
      <el-table-column label="证件号码" align="center" prop="certifCode" />
      <el-table-column label="手机号" align="center" prop="phoneNo" />
      <el-table-column label="车牌号码" align="center" prop="plateNo" />
      <el-table-column label="车架号" align="center" prop="frmNo" />
      <el-table-column label="发动机号" align="center" prop="engNo" />
<!--      <el-table-column label="创建人" align="center" prop="createBy" />-->
<!--      <el-table-column label="创建时间" align="center" prop="createDate" width="180">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ scope.row.createDate }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="修改人" align="center" prop="updateBy" />-->
<!--      <el-table-column label="修改时间" align="center" prop="updateDate" width="180">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ scope.row.updateDate }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['taishanpic:vip:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['taishanpic:vip:delete']"
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
        <el-form-item label="被保人名称" prop="insuredName">
          <el-input v-model="form.insuredName" placeholder="被保人名称" />
        </el-form-item>
        <el-form-item label="证件号码" prop="certifCode">
          <el-input v-model="form.certifCode" placeholder="请输入证件号码" />
        </el-form-item>
        <el-form-item label="手机号" prop="phoneNo">
          <el-input v-model="form.phoneNo" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="车牌号码" prop="plateNo">
          <el-input v-model="form.plateNo" placeholder="请输入车牌号码" @change="changeValidStatus()"/>
        </el-form-item>
        <el-form-item label="车架号" prop="frmNo">
          <el-input v-model="form.frmNo" placeholder="请输入车架号" @change="changeValidStatus()"/>
        </el-form-item>
        <el-form-item label="发动机号" prop="engNo">
          <el-input v-model="form.engNo" placeholder="请输入发动机号" />
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

import Treeselect from "@riophae/vue-treeselect";
import '@riophae/vue-treeselect/dist/vue-treeselect.css'
import {getToken} from "@/utils/auth";
import { getList, getVIP, saveVip, updateVip, deleteVIP,downloadVIPTemp} from '@/api/vip/vip';
import {download} from '@/utils/request'

export default {
  name: "vip_main",
  components: {Treeselect
  },
  data() {
    return {
      // 部门树选项
      deptOptions: undefined,
      sexOptions: undefined,
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
      vipList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        insuredName: undefined,
        certifCode: undefined,
        phoneNo: undefined,
        plateNo: undefined,
        frmNo: undefined,
        engNo: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        phoneNo:{ required: true, message: "手机号不能为空", trigger: "blur" },
        plateNo:{ required: true, message: "车牌号与车架号不能同时为空", trigger: "blur" },
        frmNo:{ required: true, message: "车牌号与车架号不能同时为空", trigger: "blur" },
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
        url: process.env.VUE_APP_BASE_API + "/vip/vip_main/importData"
      },
    };
  },
  created() {
    //console.log("vip index create")
   /* this.queryParams.deptid = this.$store.state.user.deptid;
    this.getDicts("t_sys_user_sex").then(response => {
      this.sexOptions = response.data;
    });*/
    this.getList();
    //this.getTreeselect();
  },
  methods: {
    setDeptName(dept,form){
      form.deptname = dept.label;
    },
    /** 查询部门下拉树结构 */
    getTreeselect() {
      this.queryParams.deptId = this.queryParams.deptid;

    },
    /** 查询人文关怀列表 */
    getList() {
      this.loading = true;
      getList(this.queryParams).then(response => {
          this.vipList = response.rows;
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
        pkId: null,
        insuredName: null,
        certifCode: null,
        phoneNo: null,
        plateNo: null,
        frmNo: null,
        engNo: null
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
      this.reset();
      this.open = true;
      this.title = "VIP信息新增";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const pkid = row.pkId || this.ids
      getVIP(pkid).then(response =>{
        this.form = response.data;
        this.open = true;
        this.title = "VIP信息修改";
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.pkId != null) {
            updateVip(this.form).then(response =>{
              this.$modal.msgSuccess("更新成功");
              this.open = false;
              this.getList();
            })
          } else {
            saveVip(this.form).then(response => {
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
      const pkids = row.pkId || this.ids;
      this.$confirm('是否确认删除选中的数据?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return deleteVIP(pkids);
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
      this.upload.title = "VIP客户信息导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('vip/vip_main/importTemplate', {
        ...this.queryParams
      }, `vip模板_${new Date().getTime()}.xlsx`)
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
    //控制车牌与车架号任意一个必填
    changeValidStatus(){
      if(this.form.frmNo != "" && this.form.frmNo != null){
        this.rules.plateNo.required = false;
      }else{
        this.rules.plateNo.required = true;
      }
      if(this.form.plateNo != "" && this.form.plateNo != null){
        this.rules.frmNo.required = false;
      }else {
        this.rules.frmNo.required = true;
      }
    }
  }
};
</script>
