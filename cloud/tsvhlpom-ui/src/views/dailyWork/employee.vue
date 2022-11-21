<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true">
      <el-form-item label="项目组" prop="emp_team">
        <el-select v-model="queryParams.emp_team" placeholder="请选择项目组" clearable size="small" filterable>
          <el-option
            v-for="dict in dict.type.sys_dailywork_empteam"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="员工姓名" prop="emp_name">
        <el-input
          v-model="queryParams.emp_name"
          placeholder="请输入员工名称"
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
      <br>
    </el-form>
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['dailywork:employee:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['dailywork:employee:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['dailywork:employee:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['dailywork:employee:upload']"
        >导入</el-button>
      </el-col>
      <!--<el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['dailywork:employee:export']"
        >导出</el-button>
      </el-col>-->
    </el-row>
    <el-table v-loading="loading" :data="employeeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="项目组" align="center" prop="emp_team">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.emp_team" :options="dict.type.sys_dailywork_empteam"></dict-tag>
          <!--<el-select v-model="scope.row.emp_team"  clearable size="small" disabled>
            <el-option
              v-for="dict in dict.type.sys_dailywork_empteam"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>-->
        </template>
      </el-table-column>
      <el-table-column label="员工姓名" align="center" prop="emp_name"/>
      <el-table-column label="项目组类别" align="center" prop="team_type">

        <template slot-scope="scope">
          <dict-tag :value="scope.row.team_type" :options="dict.type.sys_dailywork_empteam_type"></dict-tag>
          <!--<el-select v-model=""  clearable size="small" disabled>
            <el-option
              v-for="dict in "
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>-->
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['taishanpic:dailywork:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['taishanpic:dailywork:remove']"
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

    <!-- 添加或修改角色配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="项目组" prop="emp_team">
          <el-select v-model="form.emp_team" placeholder="请选择项目组" clearable size="small" filterable>
            <el-option
              v-for="dict in dict.type.sys_dailywork_empteam"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="员工工号" prop="emp_id">
          <el-input v-model="form.emp_id" placeholder="请输入员工工号" />
        </el-form-item>
        <el-form-item label="员工姓名" prop="emp_name">
          <el-input v-model="form.emp_name" placeholder="请输入员工姓名" />
        </el-form-item>
        <el-form-item label="项目组类别" prop="emp_team">
          <el-select v-model="form.team_type" placeholder="请选择项目组类别" clearable size="small" filterable>
            <el-option
              v-for="dict in dict.type.sys_dailywork_empteam_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 员工信息导入对话框 -->
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
          <el-link type="info" style="font-size:12px" @click="importTemplate">下载模板</el-link>
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
import {deleteEmployee, listEmployee,updateEmployee,saveEmployee,getEmployee} from "@/api/dailywork/employee";

export default {
  name: "employee",
  dicts: ['sys_dailywork_empteam','sys_dailywork_empteam_type'],
  data() {
    return {
      // 部门列表
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
      // 总条数
      total: 0,
      // 员工信息
      employeeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示弹出层（数据权限）
      openDataPopup: false,
      // 节假日日期
      dayDate: "",

      // 表单参数
      form: {},

      // 表单校验
      rules: {
        emp_id:{ required: true, message: "员工工号不能为空", trigger: "blur" },
        emp_name:{ required: true, message: "员工姓名不能为空", trigger: "blur" },
        emp_team:{ required: true, message: "项目组不能为空", trigger: "blur" },
        team_type:{ required: true, message: "项目组类别不能为空", trigger: "blur" },
      },

      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        emp_team: undefined,
        emp_name: undefined,
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
        url: process.env.VUE_APP_BASE_API + "/dailywork/employee/importData"
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询已输入假日列表 */
    getList() {
      this.loading = true;
      listEmployee(this.queryParams).then(
        response => {
          this.employeeList = response.rows;
          this.total = response.total;
          this.loading = false;
        }
      );
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        pkid: null,
        emp_id: null,
        emp_name: null,
        emp_team: null,
        team_type: null,
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
      this.ids = selection.map(item => item.pkid)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      /*      this.getMenuTreeselect();*/
      this.open = true;
      this.title = "添加节假日";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const pkid = row.pkid || this.ids
      getEmployee(pkid).then(response=>{
        this.form = response.data;
        this.open = true;
        this.title = "修改员工信息";
      })
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.pkid != null) {
            updateEmployee(this.form).then(response => {
              if (response.code === 200) {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              } else {
                this.$modal.msgError(response.msg);
              }
            });
          } else {
            saveEmployee(this.form).then(response => {
              if (response.code === 200) {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              } else {
                this.$modal.msgError(response.msg);
              }
            });
          }
        }
      });
    },

    /** 删除按钮操作 */
    handleDelete(row) {
      const pkIds = row.pkid || this.ids;
      this.$confirm('是否确认删除员工信息?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return deleteEmployee(pkIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('dailywork/employee/exportEmployee', {
        ...this.queryParams
      }, `员工信息信息导出_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "员工信息导入";
      this.upload.open = true;

    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('dailywork/employee/importTemplate', {
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

<style scoped>

</style>
