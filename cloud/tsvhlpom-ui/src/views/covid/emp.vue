<template>
  <div class="app-container">

    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="120px">
      <el-form-item label="总公司/分公司" prop="c_parent_dept">
        <el-select v-model="queryParams.c_parent_dept" clearable placeholder="请选择" @change="getRole($event)" :disabled="parentDeptFlag">
          <el-option
            v-for="item in selectData1"
            :key="item.value"
            :label="item.text"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="总部部门/各机构" prop="c_dept">
        <el-select v-model="queryParams.c_dept" filterable clearable
                   placeholder="请输入查询内容" :loading="loading" :disabled="deptFlag">
          <el-option
            v-for="item in selectData2"
            :key="item.value"
            :label="item.text"
            :value="item.value"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="姓名" prop="c_name">
        <el-input
          v-model="queryParams.c_name"
          placeholder="请输入姓名"
          clearable
          size="small"
          style="width: 240px"
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
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="empList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" ></el-table-column>
      <el-table-column label="总公司/分公司" align="center" prop="c_parent_dept" >
        <template slot-scope="scope">
          {{getParentDeptName(scope.row)}}
        </template>
      </el-table-column>
      <el-table-column label="总部部门/各机构" align="center" prop="c_dept" >
        <template slot-scope="scope">
          {{getDeptName(scope.row)}}
        </template>
      </el-table-column>
      <el-table-column label="姓名" align="center" prop="c_name" />
      <el-table-column label="身份证号" align="center" prop="c_id_no" />
      <el-table-column label="手机号" align="center" prop="c_phone" />
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
        <el-form-item label="总公司/分公司" prop="c_parent_dept">
          <el-select v-model="form.c_parent_dept" clearable placeholder="请选择" @change="getRole($event)">
            <el-option
              v-for="item in selectData1"
              :key="item.value"
              :label="item.text"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="总部部门/各机构" prop="c_dept">
          <el-select v-model="form.c_dept" filterable
                     placeholder="请输入查询内容" :loading="loading" >
            <el-option
              v-for="item in selectData2"
              :key="item.value"
              :label="item.text"
              :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="姓名" prop="c_name">
          <el-input v-model="form.c_name" placeholder="请输入姓名"/>
        </el-form-item>
        <el-form-item label="身份证号" prop="c_id_no">
          <el-input v-model="form.c_id_no" placeholder="请输入车架号"/>
        </el-form-item>
        <el-form-item label="手机号" prop="c_phone">
          <el-input v-model="form.c_phone" placeholder="请输入手机号" />
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
          <el-checkbox v-model="upload.updateSupport" />是否更新已经存在的数据
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
import SelectDept from "@/components/SelectDept";
import '@riophae/vue-treeselect/dist/vue-treeselect.css'
import {getToken} from "@/utils/auth";
import {getEmplyeeList,saveEmplyee,updateEmplyee,deleteEmplyee,getEmplyee,} from "@/api/covid/emp";


export default {
  name: "covid_emp",
  components: {Treeselect
  },
  data() {
    return {
      parentDeptFlag:false,
      deptFlag:false,
      selectData2:[],
      selectData1: SelectDept,
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
      empList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        c_parent_dept: undefined,
        c_dept: undefined,
        c_name: undefined,
        c_id_no: undefined,
        c_phone: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        c_parent_dept:{ required: true, message: "请选择机构", trigger: "blur" },
        c_dept:{ required: true, message: "请选择机构", trigger: "blur" },
        c_name:{ required: true, message: "姓名不能为空", trigger: "blur" },
        c_id_no:{ required: true, message: "身份证号不能为空", trigger: "blur" },
        c_phone:{ required: true, message: "手机号不能为空", trigger: "blur" },
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
        url: process.env.VUE_APP_BASE_API + "/covid/covid_emp/importData"
      },
    };
  },
  created() {
    //console.log("vip index create")
    /* this.queryParams.deptid = this.$store.state.user.deptid;
     this.getDicts("t_sys_user_sex").then(response => {
       this.sexOptions = response.data;
     });*/
    let loginUser = this.$store.state.user.loginUser;
    this.resetForm("queryForm");

    if (loginUser.remark == 'com') {
      this.getRole(loginUser.dept.deptId+"");
      this.queryParams.c_parent_dept = loginUser.dept.deptId+'';
      this.parentDeptFlag = true;
    }
    if (loginUser.remark == 'dept') {
      this.getRole(loginUser.dept.parentId+"");
      this.queryParams.c_parent_dept = loginUser.dept.parentId+"";
      this.queryParams.c_dept = loginUser.dept.deptId+"";
      this.parentDeptFlag = true;
      this.deptFlag = true;
    }
    //this.getTreeselect();
  },
  methods: {
    getParentDeptName(row){
      for(let val of SelectDept){
        if(row.c_parent_dept === val.value){
          return val.text;
        }
      }
    },
    getDeptName(row){
      for(let val of SelectDept){
        if(row.c_parent_dept === val.value){
          for(let sonval of val.children){
            if(sonval.value === row.c_dept){
              return  sonval.text;
            }
          }
        }
      }
    },
    getRole (prov) {
      console.log(prov);
      let roles = [];
      this.selectData2= [];
      this.queryParams.c_dept='';
      for (let val of SelectDept) {
        if (prov===val.value) {
          roles = val.children;
        }
        this.selectData2 = roles;
      }
    },
    setDeptName(dept,form){
      form.deptname = dept.label;
    },
    /** 查询部门下拉树结构 */
    getTreeselect() {
      this.queryParams.deptId = this.queryParams.deptid;

    },
    getList() {
      this.loading = true;
      getEmplyeeList(this.queryParams).then(response => {
        this.empList = response.rows;

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
        c_parent_dept: null,
        c_dpet: null,
        c_name: null,
        c_id_no: null,
        c_phone: null,
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
      this.title = "员工信息新增";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const pkid = row.c_pk_id || this.ids;
      getEmplyee(pkid).then(response =>{
        this.form = response.data;
        this.open = true;
        this.title = "员工信息修改";
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.c_pk_id != null) {
            updateEmplyee(this.form).then(response =>{
              this.$modal.msgSuccess("更新成功");
              this.open = false;
              this.getList();
            })
          } else {
            saveEmplyee(this.form).then(response => {
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
      const pkids = row.c_pk_id || this.ids;
      this.$confirm('是否确认删除选中的数据?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return deleteEmplyee(pkids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('covid/covid_emp/exportEmp', {
        ...this.queryParams
      }, `员工信息导出_${new Date().getTime()}.xlsx`)
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
      this.upload.title = "员工信息导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('covid/covid_emp/importTemplate', {
        ...this.queryParams
      }, `员工模板_${new Date().getTime()}.xlsx`)
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
