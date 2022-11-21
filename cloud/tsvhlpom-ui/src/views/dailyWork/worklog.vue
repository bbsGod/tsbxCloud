<template>

<div class="common">
  <!--<el-button style="width: 10%" type="primary" @click="handleAdd">写日志</el-button>-->
  <el-container class="app-container">
    <el-main>
      <el-header>
        <el-row>
          <el-col :span="12"><div>时间：{{currentTime}}</div></el-col>
          <el-col :span="12"><div>姓名：{{emp_name}}</div></el-col>
        </el-row>
      </el-header>
      <el-table :data="worklogList" style="width: 100%;">
          <el-table-column prop="log_index" label="序号" type="index" align="center"></el-table-column>
          <!--<el-table-column prop="create_time" label="时间" width="150px"></el-table-column>-->
          <el-table-column prop="work_type" label="类型" width="250px" align="center">
            <template slot-scope="scope">
              <el-select v-if="scope.row.edit" v-model="scope.row.work_type"  clearable aria-required="true">
                <el-option
                  v-for="dict in sys_dailywork_worktype"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                />
              </el-select>
              <dict-tag v-if="!scope.row.edit" :options=sys_dailywork_worktype :value="scope.row.work_type"></dict-tag>
              <!--<el-select v-if="!scope.row.edit" v-model="scope.row.work_type" disabled clearable>
                <el-option
                  v-for="dict in sys_dailywork_worktype"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                />
              </el-select>-->
            </template>
          </el-table-column>
          <el-table-column prop="work_progress" label="进度(%)" width="150px" align="center">
            <template slot-scope="scope">
              <template v-if="scope.row.edit">
                <!--<el-input v-model="scope.row.work_progress" type="number" :max="100" aria-required="true"></el-input>-->
                <el-input-number v-model="scope.row.work_progress" controls-position="right" size="small" :min="0" :max="100"></el-input-number>
              </template>
              <span v-else>{{scope.row.work_progress}}</span>
            </template>
          </el-table-column>
          <el-table-column prop="log_info" label="工作内容" show-overflow-tooltip align="center">
            <template slot-scope="scope">
              <template v-if="scope.row.edit">
                <el-input v-model="scope.row.log_info" aria-required="true"
                          autosize  type="textarea" placeholder="请输工作内容"
                          maxlength ="500" show-word-limit>
                </el-input>
              </template>
              <span v-else>{{scope.row.log_info}}</span>
            </template>
          </el-table-column>
          <el-table-column prop="log_attachment_path" label="附件" width="150px" align="center">
            <template slot-scope="scope">
              <el-button  size="mini" icon="el-icon-upload" type="text"  circle  @click="handleUploadAttchment(scope.row)">上传</el-button>
              <el-button v-if="scope.row.log_attachment_path !=null"  size="mini" icon="el-icon-download" type="text"  circle  @click="handleShowAttchment(scope.row)">下载</el-button>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="150px" align="center">
            <template #header>
              <el-button type="primary" circle @click="addItem()">添加工作内容</el-button>
            </template>
            <template slot-scope="scope">
              <el-button v-if="!scope.row.edit" icon="el-icon-edit" type="primary"  circle  @click="handleEditItem(scope)"></el-button>
              <el-button v-if="!scope.row.edit" icon="el-icon-delete" type="danger"circle  @click="handleDelete(scope.row)"></el-button>
              <el-button v-if="scope.row.edit" icon="el-icon-check" type="primary"   @click="handleSaveOrUpdate(scope.row)" circle></el-button>
              <el-button v-if="scope.row.edit" icon="el-icon-close" type="primary"  @click="handleDeleteItem(scope.row,scope.$index)" circle></el-button>
            </template>
          </el-table-column>
      </el-table>
      <!--<pagination
        v-show="total>0"
        :total="total"
        :page.sync="queryParams.pageNum"
        :limit.sync="queryParams.pageSize"
        @pagination="getList"
      />-->
    </el-main>
  </el-container>

  <!--<el-dialog  :title="title" :visible.sync="open" width="800px" append-to-body>
    <el-form ref="form" :model="form" label-width="100px" :label-position="right">

      <el-form-item label="员工工号" prop="emp_id" style="width: 50%">
        <el-input size="small" v-model="form.emp_id" placeholder="请输入员工工号" aria-required="true"/>
      </el-form-item>
      <el-form-item label="员工姓名" prop="emp_name" style="width: 50%">
        <el-input v-model="form.emp_name" placeholder="请输入员工姓名" aria-required="true"/>
      </el-form-item>
      <el-form-item v-if="true" label="工作类别" prop="c_email">
          <el-select v-model="form.work_type"  clearable size="small">
            <el-option
              v-for="dict in dict.type.sys_dailywork_worktype_1"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
      </el-form-item>
      <el-form-item label="日志" prop="log_info">
        <el-input v-model="form.log_info" type="textarea" placeholder="请输入日志" maxlength ="500" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="进度" prop="work_percent" label-suffix="%" style="width: 40%">

        <el-input v-model="form.work_progress" placeholder="请输入工作进度" aria-required="true">
          <template slot="append">%</template>
        </el-input>
      </el-form-item>
      <el-form-item label="附件">
        <el-button type="primary" @click="handleUploadAttchment">上传附件</el-button>
        {{form.log_attachment_path}}
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submitForm">确 定</el-button>
      <el-button @click="cancel">取 消</el-button>
    </div>
  </el-dialog>-->

  <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px">
    <el-upload
      ref="upload"
      :headers="upload.headers"
      :action="upload.url + '?updateSupport=' + upload.updateSupport"
      :disabled="upload.isUploading"
      :on-progress="handleFileUploadProgress"
      :on-success="handleFileSuccess"
      :auto-upload="false"
      :data="upload.data"
      drag
    >
      <i class="el-icon-upload"></i>
      <div class="el-upload__text">
        将文件拖到此处，或
        <em>点击上传</em>
      </div>

    </el-upload>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submitFileForm">确 定</el-button>
      <el-button @click="upload.open = false">取 消</el-button>
    </div>
  </el-dialog>

  <el-dialog :title=" attchment.title" :visible.sync="attchment.open" width="80%"
             :append-to-body="true">
    <!--<embed :src="attchment.url" style="width: 100%;height: 500px">-->
    <el-image :src="attchment.url" style="width: 100%;height: 500px"></el-image>
  </el-dialog>
</div>
</template>
<script>
import {
  listWorkLog,
  saveWorkLog,
  updateWorkLog,
  getWorkLog,
  deleteWorkLog,
  showAttchment
} from "@/api/dailywork/worklog";
import {getToken} from "@/utils/auth";
import {formatDate} from "@/utils";
import {getEmployeeInfo} from "@/api/dailywork/worklog";


export default {
  name: "worklog",
  dicts:['sys_dailywork_worktype_1','sys_dailywork_worktype_2'],
  data() {
    return {
      attchment:{
        open:false,
        title:"",
        url:"",
      },
      emp_id:'',
      emp_name:'',
      //项目组类别
      team_type:'',
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      form: {},
      currentTime: undefined,
      worklogList:[],
      sys_dailywork_worktype:[],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        emp_id: undefined,
        create_time: undefined,
      },
      upload: {
        // 是否显示弹出层（用户导入）
        data:'',
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
        url: process.env.VUE_APP_BASE_API + "/dailywork/worklog/uploadFile"
      },
    }
  },
  created() {

    let time = new Date();
    this.currentTime = time.toLocaleDateString();
    console.log(this.$store)
    this.emp_name =  this.$store.state.user.name;
    this.getUserInfo(this.$store.state.user.name);
  },
  methods:{
    //获取员工的工号，名称及项目组分类
    getUserInfo(emp_id){
      getEmployeeInfo(emp_id).then(data =>{
        console.log("data"+data);
        this.team_type = data.data.team_type;
        this.emp_id = data.data.emp_id;
        this.emp_name = data.data.emp_name;
        this.sys_dailywork_worktype = [];
        if(this.team_type == '0'){
          this.sys_dailywork_worktype = this.dict.type.sys_dailywork_worktype_1;
        }else{
          this.sys_dailywork_worktype = this.dict.type.sys_dailywork_worktype_2;
        }
        this.getList();
      })
    },
    handleEditItem(scope){
      scope.row.edit= !scope.row.edit;
    },
    //增加 一列
    addItem() {
      const item = {
        create_time: formatDate(new Date().toString()),
        work_type:'',
        work_progress:'',
        log_info:'',
        edit: true
      };
      let flag = true;
      this.worklogList.forEach(data => {
        if(typeof(data.pkid) == 'undefined'||  data.pkid ==null || data.pkid == ''){
          flag = false;
        }
      });
      if(flag){
        this.worklogList.push(item);
      }
    },
    //删除列
    handleDeleteItem(row,index){
      //如果pkid不空，原有数据，只关闭编辑模式
      if(row.pkid !=null && row.pkid !=''){
        row.edit = ! row.edit;
      }else{
        this.worklogList.splice(index,1);
      }
      this.getList();
    },
    /** 查询已输入假日列表 */
    getList() {
      this.loading = true;
      this.queryParams.emp_id= this.emp_id;
      listWorkLog(this.queryParams).then(
        response => {
          this.worklogList = response.rows;
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
        c_pk_id: null,
        emp_id: null,
        emp_name: null,
        create_time: null,
        work_type: null,
        work_progress: null,
        log_info: null,
        log_attachment_path: null,
      };
      this.resetForm("form");
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "日志新增";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const pkid = row.pkid || this.ids
      getWorkLog(pkid).then(response=>{
        this.form = response.data;
        this.open = true;
        this.title = "日志修改";
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const pkIds = row.pkid || this.ids;
      this.$confirm('是否确认删除日志信息?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return deleteWorkLog(pkIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(function() {});
    },
    /** 提交按钮 */
    handleSaveOrUpdate(row) {
      //校验数据
      if(row.work_type ==null || row.work_type == ''){
        this.$message({ message: '请选择类型', type: 'warning' })
        return ;
      }
      if(row.work_progress ==null || row.work_progress == ''){
        this.$message({ message: '请填写进度', type: 'warning' })
        return ;
      }else{
        if(row.work_progress > 100 || row.work_progress < 0){
          this.$message.error("进度应为0到100数字");
          return ;
        }
      }
      if(row.log_info ==null || row.log_info == ''){
        this.$message({ message: '请填写日志', type: 'warning' })
        return ;
      }
      row.emp_id = this.emp_id;
      row.emp_name = this.emp_name;
      if (row.pkid != null) {
        updateWorkLog(row).then(response => {
          if (response.code === 200) {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          } else {
            this.$modal.msgError(response.msg);
          }
        });
      } else {
        saveWorkLog(row).then(response => {
          if (response.code === 200) {
            this.$modal.msgSuccess("新增成功");
            this.open = false;
            this.getList();
          } else {
            this.$modal.msgError(response.msg);
          }
        });
      }
    },
    handleShowAttchment(row){
      this.attchment.url = "";
      var name = `每日工作附件_${new Date().getTime()}`;
      let url = "";
      url = row.log_attachment_path;
      console.log("url:"+url)
      var suffix = url.substring(url.lastIndexOf("."), url.length);
      if(suffix == '.doc' || suffix == '.docx' || suffix == '.xls' || suffix == '.xlsx' || suffix == '.txt' || suffix == '.pdf' || suffix == '.zip'|| suffix == '.rar'){
        const a = document.createElement('a')
        a.setAttribute('download', name + suffix)
        a.setAttribute('target', '_blank')
        a.setAttribute('href', url)
        a.click()
      }else{
        this.attchment.open = true;
        this.attchment.url = url;
      }

      //window.open(row.log_attachment_path);
      /*const param = {"pkid":row.pkid};
      showAttchment(param).then(data =>{
        this.attchment.open = true;
        let url = window.URL.createObjectURL(data);
        this.attchment.title = '附件查看';
        this.attchment.url = url;
      })*/

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
      /*this.$refs.upload.getCropBlob(data => {
        let formData = new FormData();
        formData.append("attchment", data);
        uploadAvatar(formData).then(response => {
          this.open = false;
          this.options.img = response.imgUrl;
          store.commit('SET_AVATAR', this.options.img);
          this.$modal.msgSuccess("修改成功");
          this.visible = false;
        });
      });*/
      this.$refs.upload.submit();
      this.getList();
    },
    /** 导入按钮操作 */
    handleUploadAttchment(row) {
      if(row.pkid ==null || row.pkid == ''){
        this.$message({ message: '请先保存后再上传附件', type: 'warning' })
      }else{
        this.upload.title = "日志文件上传";
        this.upload.open = true;
        this.upload.data = {pkid:row.pkid};
      }
    },
  }
}
</script>
<style>
.common .el-header,
.common .el-footer {
  /*background-color: #91ffff;*/
  color: #020202;
  text-align: center;
  line-height: 60px;
}
.common .el-main {
  background-color: #f6f2f2;
  color: #8cc8ff;
  text-align: center;
  line-height: 20px;

}
</style>
