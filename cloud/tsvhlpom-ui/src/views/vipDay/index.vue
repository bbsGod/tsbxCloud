<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true">
      <el-form-item label="节假日首日日期">
        <el-date-picker
          v-model="queryParams.dayDate"
          size="small"
          style="width: 150px"
          value-format="yyyy-MM-dd"
          type="date"
          start-placeholder="首日日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="节假日名称" prop="dayName">
        <el-input
          v-model="queryParams.dayName"
          placeholder="请输入节假日名称"
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
      <el-row>
        <span style="height: max-content;color: #fa0000">节日前一天9点发送节日短信，请在节日前一天9点之前维护信息，节日当天维护的信息不发短信!!!</span>
      </el-row>
      <br>
    </el-form>
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['taishanpic:day:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['taishanpic:day:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['taishanpic:day:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['taishanpic:day:upload']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['taishanpic:day:export']"
        >导出</el-button>
      </el-col>
    </el-row>
    <el-table v-loading="loading" :data="dayList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="节假日名称" align="center" prop="dayName"/>
      <el-table-column label="节假日时间" align="center" prop="dayDate">
        <template slot-scope="scope">
          {{scope.row.dayDate}}
        </template>
      </el-table-column>
      <el-table-column label="祝福标题" align="center" prop="preFixMessage"/>
      <el-table-column label="短信后缀" align="center" prop="surFixMessage" show-overflow-tooltip/>
      <el-table-column label="创建时间" align="center" prop="createDate">
        <template slot-scope="scope">
          {{scope.row.createDate}}
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['taishanpic:day:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['taishanpic:day:remove']"
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
        <el-form-item label="节假日名称" prop="dayName">
          <el-input v-model="form.dayName" placeholder="请输入节假日名称" />
        </el-form-item>
        <el-form-item label="首日日期" prop="dayDate">
          <el-date-picker v-model="form.dayDate" placeholder="请选择假期日期"
                          format="yyyy-MM-dd" value-format="yyyy-MM-dd"/>
        </el-form-item>
        <el-form-item label="祝福标题">
          <el-input v-model="form.preFixMessage" type="textarea" placeholder="请输入祝福标题" maxlength ="500" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="短信后缀">
          <el-input v-model="form.surFixMessage" type="textarea" placeholder="请输入短信后缀" maxlength ="500" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="备注">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 节假日导入对话框 -->
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
import {
  delDay,
  addDay,
  getDay,
  listDay,
  updateDay
} from "@/api/vip/vip_day";
import {getToken} from "@/utils/auth";

export default {
  name: "vip_day",
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
      // 日期表格数据
      dayList: [],
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
        dayName:{ required: true, message: "节假日名称不能为空", trigger: "blur" },
        dayDate:{ required: true, message: "节假日日期不能为空", trigger: "blur" },
      },

      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        dayDate: undefined,
        dayName: undefined,
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
        url: process.env.VUE_APP_BASE_API + "/vip/vip_day/importData"
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
      listDay(this.queryParams).then(
        response => {
          this.dayList = response.rows;
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
        pkId: null,
        dayName: null,
        dayDate: null,
        remark: null,
        preFixMessage: null,
        surFixMessage: null,
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
      const pkId = row.pkId || this.ids
      getDay(pkId).then(response=>{
        this.form = response.data;
        this.open = true;
        this.title = "修改节假日信息";
      })
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.pkId != null) {
            updateDay(this.form).then(response => {
              if (response.code === 200) {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              } else {
                this.$modal.msgError(response.msg);
              }
            });
          } else {
            addDay(this.form).then(response => {
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
      const pkIds = row.pkId || this.ids;
      const dayDates = row.dayDate || this.ids;
      this.$confirm('是否确认删除节假日为"' + dayDates + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delDay(pkIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('vip/vip_day/exportVipDay', {
        ...this.queryParams
      }, `节日信息导出_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "节假日信息导入";
      this.upload.open = true;

    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('vip/vip_day/importTemplate', {
        ...this.queryParams
      }, `节日模板_${new Date().getTime()}.xlsx`)
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
