<template>
  <div class="app-container">
    <el-form :model="queryParams"  ref="queryForm" :inline="true">
      <el-form-item label="项目组" prop="emp_team">
        <el-select v-model="queryParams.emp_team" :disabled="emp_teamReadOnly" placeholder="请选择项目组" clearable size="small" filterable>
          <el-option
            v-for="dict in dict.type.sys_dailywork_empteam"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item  label="时间范围" prop="create_time">
        <el-date-picker
          v-model="dateRange"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        <el-button type="success" icon="el-icon-download" size="mini" @click="handleExport">导出</el-button>
      </el-form-item>
      <br>
    </el-form>

    <el-table v-loading="loading" :data="workList" :span-method="objectSpanMethod" width="100%">

      <el-table-column label="项目组"  align="center" prop="emp_team" width="150px">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_dailywork_empteam" :value="scope.row.emp_team"></dict-tag>
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
      <el-table-column label="时间"  align="center" prop="create_time" width="150px"/>
      <el-table-column label="员工姓名"  align="center" prop="emp_name" width="150px"/>
      <el-table-column label="详细信息" align="center">
          <el-table-column label="类型" prop="work_type" width="150px" align="center">
            <template slot-scope="scope" >
              <dict-tag v-if="scope.row.team_type=='0'" :value="scope.row.work_type" :options="dict.type.sys_dailywork_worktype_1"></dict-tag>
              <dict-tag v-if="scope.row.team_type=='1'" :value="scope.row.work_type" :options="dict.type.sys_dailywork_worktype_2"></dict-tag>
              <!--<el-select v-if="scope.row.team_type=='0'" v-model="scope.row.work_type"  clearable size="small" disabled>
                <el-option
                  v-for="dict in dict.type.sys_dailywork_worktype_1"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                />
              </el-select>
              <el-select v-if="scope.row.team_type=='1'" v-model="scope.row.work_type"  clearable size="small" disabled>
                <el-option
                  v-for="dict in dict.type.sys_dailywork_worktype_2"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                />
              </el-select>-->
            </template>
          </el-table-column>
          <el-table-column label="进度(%)" prop="work_progress" width="150px" align="center"></el-table-column>
          <el-table-column label="工作内容" prop="log_info" align="center"></el-table-column>
          <el-table-column label="附件" prop="log_attachment_path" align="center" width="100px">
            <template slot-scope="scope">
              <el-button v-if="scope.row.log_attachment_path" icon="el-icon-show"
                         size="mini" @click="showAttachment(scope.row)">查看</el-button>
            </template>
          </el-table-column>
      </el-table-column>
    </el-table>

    <!--<pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />-->

    <!-- 添加或修改角色配置对话框 -->
   <!-- <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
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
    </el-dialog>-->

    <!-- 员工信息导入对话框 -->
    <!--<el-dialog :title="upload.title" :visible.sync="upload.open" width="400px">
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
    </el-dialog>-->
  </div>
</template>

<script>
import { exportWorkLog, getEmployeeInfo, getLogAnalysisList } from '@/api/dailywork/worklog'
import {download} from "@/utils/ruoyi";

export default {
  name: "dailywork",
  dicts: ['sys_dailywork_empteam','sys_dailywork_empteam_type','sys_dailywork_worktype_1','sys_dailywork_worktype_2'],
  data() {
    return {
      emp_teamReadOnly: false,
      emp_team_query: undefined,
      dateRange:[],
      //合并单元格
      idArr: [],
      idPos: 0,
      nameArr: [],
      namePos: 0,
      timeArr:[],
      timePos:0,
      // 部门列表
      //deptOptions: undefined,
      //sexOptions: undefined,
      // 遮罩层
      loading: false,
      // 选中数组
      //ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 总条数
      //total: 0,
      // 员工信息
      workList: [],
      // 弹出层标题
     // title: "",
      // 是否显示弹出层
      //open: false,
      // 是否显示弹出层（数据权限）
      //openDataPopup: false,
      // 节假日日期
      //dayDate: "",

      // 表单参数
      //form: {},

      // 表单校验

      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        emp_team: undefined,
        create_time:undefined,
      },

     /* upload: {
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
      },*/
    };
  },
  created() {

    this.getEmpInfo();
    //this.getList();
    let startDate = new Date();
    startDate.setTime((new Date().getTime() - (7*24*60*60*1000)));
    this.dateRange = [startDate,new Date()];
  },
  methods: {
    //获取登录工号员工信息 ，默认项目组，只读
    getEmpInfo(){
      let emp_id = this.$store.state.user.name;
      getEmployeeInfo(emp_id).then(res =>{
       this.emp_team_query = res.data.emp_team;
        this.queryParams.emp_team = res.data.emp_team;
        if(res.data.emp_team != '12'){
          this.emp_teamReadOnly = true;
        }
      })


    },
    /** 查询已输入假日列表 */
    getList() {
      this.loading = true;
      const param = {
        emp_team : this.queryParams.emp_team,
        startDate: undefined,
        endDate: undefined,
      };
      if(this.dateRange.length == 0){
        this.$message.error("请选择时间范围");
        this.loading = false;
        return ;
      }
      if(this.dateRange){
        param.startDate = this.dateRange[0];
        param.endDate = this.dateRange[1];
      }
        getLogAnalysisList(param).then(
        response => {
          console.log(response)
          this.workList = response.data;
          //this.total = response.total;
          this.teaminit();
          this.nameinit();
          this.timeinit();
          this.loading = false;

        }
      );
    },
   /* // 取消按钮
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
    },*/
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.dateRange = [];
      this.resetForm("queryForm");
      this.queryParams.emp_team = this.emp_team_query;
      //this.handleQuery();
    },
   /* // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.pkid)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },*/
    /*/!** 新增按钮操作 *!/
    handleAdd() {
      this.reset();
      /!*      this.getMenuTreeselect();*!/
      this.open = true;
      this.title = "添加节假日";
    },
    /!** 修改按钮操作 *!/
    handleUpdate(row) {
      this.reset();
      const pkid = row.pkid || this.ids
      getEmployee(pkid).then(response=>{
        this.form = response.data;
        this.open = true;
        this.title = "修改员工信息";
      })
    },*/
    /** 提交按钮 */
   /* submitForm: function() {
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
    },*/

    /** 删除按钮操作 */
   /* handleDelete(row) {
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
    },*/
    /** 导出按钮操作 */
    handleExport() {
      const param = {
        emp_team : this.queryParams.emp_team,
        startDate: undefined,
        endDate: undefined,
      };
      if(this.dateRange){
        param.startDate = this.dateRange[0];
        param.endDate = this.dateRange[1];
      }

      this.download('/dailywork/worklog/exportWorkLog', {
        ...param
      }, `日志信息导出_${new Date().getTime()}.xlsx`)


      /*const param = {
        emp_team : this.queryParams.emp_team,
        startDate: undefined,
        endDate: undefined,
      };
      if(this.queryParams.create_time){
        param.startDate = this.queryParams.create_time[0];
        param.endDate = this.queryParams.create_time[1];
      }
      exportWorkLog(param).then(response=>{
        download(response.msg);
      });*/


    },
    /** 导入按钮操作 */
    /*handleImport() {
      this.upload.title = "员工信息导入";
      this.upload.open = true;

    },*/
    /** 下载模板操作 */
    /*importTemplate() {
      this.download('dailywork/employee/importTemplate', {
        ...this.queryParams
      }, `员工模板_${new Date().getTime()}.xlsx`)
    },*/
    // 文件上传中处理
   /* handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },*/
    // 文件上传成功处理
    /*handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert(response.msg, "导入结果", { dangerouslyUseHTMLString: true });
      this.getList();
    },*/
    // 提交上传文件
    /*submitFileForm() {
      this.$refs.upload.submit();
    },*/

    //合并单元格  start
    nameinit() {
      // 首先初始化
      this.nameArr = []
      this.namePos = 0
      for (let i = 0; i < this.workList.length; i++) {
        if (i === 0) {
          this.nameArr.push(1)
          this.namePos = 0
        }
        else {
          if (this.workList[i].emp_name === this.workList[i - 1].emp_name
             && this.workList[i].create_time === this.workList[i - 1].create_time) {
            this.nameArr[this.namePos] += 1
            this.nameArr.push(0)
          } else {
            this.nameArr.push(1)
            this.namePos = i
          }
        }
      }
    },
    // 项目类别
    teaminit() {
      this.idArr = []
      this.idPos = 0
      for (let i = 0; i < this.workList.length; i++) {
        if (i === 0) {
          this.idArr.push(1)
          this.idPos = 0
        }
        else {
          // 用于判断当前项的
          if (this.workList[i].emp_team === this.workList[i - 1].emp_team) {
            this.idArr[this.idPos] += 1
            this.idArr.push(0)
          } else {
            this.idArr.push(1)
            this.idPos = i
          }
        }
      }
    },
    timeinit() {
      this.timeArr = []
      this.timePos = 0
      for (let i = 0; i < this.workList.length; i++) {
        if (i === 0) {
          this.timeArr.push(1)
          this.timePos = 0
        }
        else {
          // 用于判断当前项的
          if (this.workList[i].create_time === this.workList[i - 1].create_time
              && this.workList[i].emp_team === this.workList[i - 1].emp_team) {
            this.timeArr[this.timePos] += 1
            this.timeArr.push(0)
          } else {
            this.timeArr.push(1)
            this.timePos = i
          }
        }
      }
    },
    // 合并的地方也只有两处
    objectSpanMethod({ rowIndex, columnIndex }) {
      if(columnIndex === 0) {
        const row1 = this.idArr[rowIndex]
        const col1 = row1 > 0 ? 1 : 0
        return {
          rowspan: row1,
          colspan: col1
        }
      }
      else if(columnIndex === 2) {
        const row1 = this.nameArr[rowIndex]
        const col1 = row1 > 0 ? 1 : 0
        return {
          rowspan: row1,
          colspan: col1
        }
      }
      else if(columnIndex === 1) {
        const row1 = this.timeArr[rowIndex]
        const col1 = row1 > 0 ? 1 : 0
        return {
          rowspan: row1,
          colspan: col1
        }
      }
    },

    //合并单元格  end
    showAttachment(row){
      let url = row.log_attachment_path;
      let name = "工作日报";
      let suffix = url.substring(url.lastIndexOf("."), url.length);
      const a = document.createElement('a')
      a.setAttribute('download', name + suffix)
      a.setAttribute('target', '_blank')
      a.setAttribute('href', url)
      a.click()
    }
  }
};
</script>

<style scoped>

</style>
