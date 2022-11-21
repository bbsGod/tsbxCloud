<template>
  <div class="app-container">

    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="150px">
      <el-form-item label="车牌号" prop="plate_no">
        <el-input
          v-model="queryParams.plate_no"
          placeholder="请输入车牌号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="被保险人" prop="insured_name">
        <el-input
          v-model="queryParams.insured_name"
          placeholder="请输入被保险人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="phone_no">
        <el-input
          v-model="queryParams.phone_no"
          placeholder="请输入手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="报价状态" prop="c_price_status">
        <el-input
          v-model="queryParams.c_price_status"
          placeholder="请输入报价状态"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出单员" prop="make_name">
        <el-input
          v-model="queryParams.make_name"
          placeholder="请输入出单员"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
      <el-row>
        <el-form-item label="算价日期"  required>
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
          <el-button type="primary" icon="el-icon-refresh" size="mini" @click="handleUpdateStatus">更新报价状态</el-button>
        </el-form-item>
      </el-row>
    </el-form>

    <el-row :gutter="10" class="mb8">
<!--      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
        >新增</el-button>
      </el-col>-->
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

    <el-table v-loading="loading" :data="priceList" height="600px" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" fixed/>
      <el-table-column type="index" fixed></el-table-column>
      <el-table-column label="算价日期" align="center" prop="price_date" fixed></el-table-column>
      <el-table-column label="部门" align="center" prop="dept_name" fixed/>
      <el-table-column label="姓名" align="center" prop="name" fixed/>
      <el-table-column label="重点客户标识" align="center" prop="sp_cust_name" fixed/>
      <el-table-column label="车牌" align="center" prop="plate_no" fixed />
      <el-table-column label="被保险人" align="center" prop="insured_name" fixed/>
      <el-table-column label="联系电话" align="center" prop="phone_no" fixed/>
      <el-table-column label="出单机构" align="center" prop="make_dept" fixed/>
      <el-table-column label="是否新能源" align="center" prop="isNewEnery">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.isNewEnery" :options="dict.type.sys_yes_no"></dict-tag>
        </template>
      </el-table-column>
      <el-table-column label="是否过户车" align="center" prop="isChange">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.isChange" :options="dict.type.sys_yes_no"></dict-tag>
        </template>
      </el-table-column>
      <el-table-column label="是否投保交强险" align="center" prop="isCli">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.isCli" :options="dict.type.sys_yes_no"></dict-tag>
        </template>
      </el-table-column>
      <el-table-column label="是否投保商业险" align="center" prop="isVi">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.isVi" :options="dict.type.sys_yes_no"></dict-tag>
        </template>
      </el-table-column>
      <el-table-column label="是否投保车损" align="center" prop="isCarLoss">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.isCarLoss" :options="dict.type.sys_yes_no"></dict-tag>
        </template>
      </el-table-column>
      <el-table-column label="初始定价系数" align="center" prop="price_first_rate" >
        <template slot-scope="scope">
          <span v-if="scope.row.price_first_rate!=null">{{scope.row.price_first_rate}}</span>
          <span v-else>/</span>
        </template>

      </el-table-column>
      <el-table-column label="费折定价系数" align="center" prop="price_fee_rate" >
        <template slot-scope="scope">
          <span v-if="scope.row.price_fee_rate!=null">{{scope.row.price_fee_rate}}</span>
          <span v-else>/</span>
        </template>
      </el-table-column>
      <el-table-column label="人工系数调整" align="center" prop="price_charge_rate" >
        <template slot-scope="scope">
          <span v-if="scope.row.price_charge_rate!=null">{{scope.row.price_charge_rate}}</span>
          <span v-else>/</span>
        </template>
      </el-table-column>
      <el-table-column label="出单定价系数" align="center" prop="price_final_rate" >
        <template slot-scope="scope">
          <span v-if="scope.row.price_final_rate!=null">{{scope.row.price_final_rate}}</span>
          <span v-else>/</span>
        </template>
      </el-table-column>
      <el-table-column label="交强险保费" align="center">
        <el-table-column label="保费" align="center" prop="jq_fee" >
          <template slot-scope="scope">
            <span v-if="scope.row.jq_fee!=null">{{scope.row.jq_fee}}</span>
            <span v-else>/</span>
          </template>
        </el-table-column>
        <el-table-column label="费用率" align="center" prop="jq_rate" >
          <template slot-scope="scope">
            <span v-if="scope.row.jq_rate!=null">{{scope.row.jq_rate}}</span>
            <span v-else>/</span>
          </template>
        </el-table-column>
        <el-table-column label="费用额" align="center" prop="jq_amount" >
          <template slot-scope="scope">
            <span v-if="scope.row.jq_amount!=null">{{scope.row.jq_amount}}</span>
            <span v-else>/</span>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="商业险保费" align="center">
        <el-table-column label="初始保费" align="center" prop="sy_first_fee" >
          <template slot-scope="scope">
            <span v-if="scope.row.sy_first_fee!=null">{{scope.row.sy_first_fee}}</span>
            <span v-else>/</span>
          </template>
        </el-table-column>
        <el-table-column label="费用率" align="center" prop="sy_fee_rate" >
          <template slot-scope="scope">
            <span v-if="scope.row.sy_fee_rate!=null">{{scope.row.sy_fee_rate}}</span>
            <span v-else>/</span>
          </template>
        </el-table-column>
        <el-table-column label="费用额" align="center" prop="sy_amount" >
          <template slot-scope="scope">
            <span v-if="scope.row.sy_amount!=null">{{scope.row.sy_amount}}</span>
            <span v-else>/</span>
          </template>
        </el-table-column>
        <el-table-column label="费折后保费" align="center" prop="sy_after_fee" >
          <template slot-scope="scope">
            <span v-if="scope.row.sy_after_fee!=null">{{scope.row.sy_after_fee}}</span>
            <span v-else>/</span>
          </template>
        </el-table-column>
        <el-table-column label="人工系数调节保费" align="center" prop="sy_charge_fee" >
          <template slot-scope="scope">
            <span v-if="scope.row.sy_charge_fee!=null">{{scope.row.sy_charge_fee}}</span>
            <span v-else>/</span>
          </template>
        </el-table-column>
        <el-table-column label="出单保费" align="center" prop="sy_final_fee" >
          <template slot-scope="scope">
            <span v-if="scope.row.sy_final_fee!=null">{{scope.row.sy_final_fee}}</span>
            <span v-else>/</span>
          </template>
        </el-table-column>
      </el-table-column>

        <el-table-column label="可用最大费用额" align="center" prop="avalid_amount" >
          <template slot-scope="scope">
            <span v-if="scope.row.avalid_amount!=null">{{scope.row.avalid_amount}}</span>
            <span v-else>/</span>
          </template>
        </el-table-column>
        <el-table-column label="剩余费用额（不扣税）" align="center" prop="last_fee_NoTax" >
          <template slot-scope="scope">
            <span v-if="scope.row.last_fee_NoTax !=null">{{scope.row.last_fee_NoTax}}</span>
            <span v-else>/</span>
          </template>
        </el-table-column>
      <el-table-column label="剩余费用额（扣税）" align="center" prop="last_fee_Tax" >
        <template slot-scope="scope">
          <span v-if="scope.row.last_fee_Tax !=null">{{scope.row.last_fee_Tax}}</span>
          <span v-else>/</span>
        </template>
      </el-table-column>
      <el-table-column label="合计保费" align="center" prop="total_fee" >
        <template slot-scope="scope">
          <span v-if="scope.row.total_fee !=null">{{scope.row.total_fee}}</span>
          <span v-else>/</span>
        </template>
      </el-table-column>
      <el-table-column label="出单员" align="center" prop="make_name" >
        <template slot-scope="scope">
          <span v-if="scope.row.make_name!=null">{{scope.row.make_name}}</span>
          <span v-else>/</span>
        </template>
      </el-table-column>
      <el-table-column label="报价状态" align="center" prop="c_price_status" >
        <template slot-scope="scope">
          <span v-if="scope.row.c_price_status!=null">{{scope.row.c_price_status}}</span>
          <span v-else>/</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="c_remark">
        <template slot-scope="scope">
          <span v-if="scope.row.c_remark!=null">{{scope.row.c_remark}}</span>
          <span v-else>/</span>
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" fixed="right">
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
    <el-dialog :title="title" :visible.sync="open"  width="1150px" append-to-body :before-close="confirmDialog">
      <priceForm :form="form"></priceForm>
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
import {getBasePriceList,getPriceById,save,update,delPrice,updatePriceStatus} from '@/api/cargroup/price'
import priceForm from '@/views/cargroup/priceForm'
import { saveVip, updateVip } from '@/api/vip/vip'
export default {
  name: "Cargroup_price",
  components: {priceForm},
  dicts: ['sys_yes_no'],

  data() {
    return {
      dateRange:[],
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
      priceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      updateFlag: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        plate_no: undefined,
        insured_name: undefined,
        phone_no: undefined,
        c_price_status: undefined,
        make_name: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {

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
        url: process.env.VUE_APP_BASE_API + "/cargroup/basePrice/importData"
      },
    };
  },
  created() {
    const now = new Date().getFullYear() + '-' + (new Date().getMonth()+1) + '-' +new Date().getDate();
    this.dateRange = [now,now];
    this.getList();
  },

  methods: {
    handleUpdateStatus(){
      if(this.dateRange ==null || this.dateRange.length == 0 || this.dateRange == undefined || this.dateRange == []){
        this.$message({type:'error',message:'请选择报价日期'});
        return ;
      }
      this.$refs["queryForm"].validate(valid => {
        if (valid) {
          this.loading = true;
          updatePriceStatus(this.addDateRange(this.queryParams,this.dateRange,'price')).then(response => {
            this.$modal.msgSuccess("更新状态成功");
            this.loading = false;
            this.getList();
          });
        }
      });
    },
    getList() {
      this.loading = true;
      getBasePriceList(this.addDateRange(this.queryParams,this.dateRange,'price')).then(response => {
        this.priceList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    confirmDialog(){
      this.$confirm(
        '是否确认关闭此窗口?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }
      ).then(
        this.cancel
      ).catch(()=>{
        console.log("aaaa")
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
        pk_id: undefined,
        price_date: undefined,
        dept_name: undefined,
        name: undefined,
        sp_cust_name: undefined,
        plate_no: undefined,
        insured_name: undefined,
        phone_no: undefined,
        make_dept: undefined,
        isNewEnery: undefined,
        isChange: undefined,
        isCli: undefined,
        isVi: undefined,
        isCarLoss: undefined,
        price_first_rate: undefined,
        price_fee_rate: undefined,
        price_charge_rate: undefined,
        price_final_rate: undefined,
        jq_fee: undefined,
        jq_rate: undefined,
        jq_amount: undefined,
        sy_first_fee: undefined,
        sy_fee_rate: undefined,
        sy_amount: undefined,
        sy_after_fee: undefined,
        sy_charge_fee: undefined,
        sy_final_fee: undefined,
        avalid_amount: undefined,
        last_fee_NoTax: undefined,
        last_fee_Tax: undefined,
        total_fee: undefined,
        make_name: undefined,
        c_price_status: undefined,
      };
      this.resetForm("priceForm");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.dateRange =[];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.pk_id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.updateFlag = false;
      this.open = true;
      this.reset();
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const pk_id = row.pk_id || this.ids
      getPriceById(pk_id).then(response =>{
        this.form = response.data;
        let date = new Date();
        let month = date.getMonth()+1;
        let day = date.getFullYear()+"-"+month+"-"+date.getDate();
        if(!this.form.price_date){
          this.form.price_date = day;
        }
        //初始化 出单员
        if(!this.form.make_name){
          this.form.make_name = this.$store.state.user.loginUser.nickName;
        }
        this.open = true;
        this.updateFlag = true;
        this.title = "清单信息修改";
      })
    },
    /** 提交按钮 */
    submitForm() {
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
    },

    /** 删除按钮操作 */
    handleDelete(row) {
      const pkids = row.pk_id || this.ids;
      this.$confirm('是否确认删除选中的数据?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delPrice(pkids);
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
      this.download('cargroup/basePrice/importTemplate', {
        ...this.queryParams
      }, `报表清单导入模板_${new Date().getTime()}.xlsx`)
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
    /** 导出按钮操作 */
    handleExport() {
      this.download('cargroup/basePrice/exportPrice', {
        ...this.addDateRange(this.queryParams,this.dateRange,'price')
      }, `报表清单导出_${new Date().getTime()}.xlsx`)
    },
  }
};
</script>
