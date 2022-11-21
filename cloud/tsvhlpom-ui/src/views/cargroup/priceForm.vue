<template>
  <div class="app-container">
    <el-form ref="priceForm" :inline="true" :model="form" :rules="rules"
             label-width="200px" size="small">
      <el-row :gutter="30" class="mb8">
        <el-col :span="5">
          <el-form-item label="算价日期" prop="price_date">
            <el-date-picker
              v-model="form.price_date"
              type="date" placeholder="选择日期"
              value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="部门" prop="dept_name">
            <el-input v-model="form.dept_name" placeholder="请输入部门" />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="form.name" placeholder="请输入姓名" />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="重点客户标识" prop="sp_cust_name">
            <el-input v-model="form.sp_cust_name" placeholder="请输入姓名" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30" class="mb8">
        <el-col :span="5">
          <el-form-item label="车牌号" prop="plate_no">
            <el-input v-model="form.plate_no" placeholder="请输入车牌号" @change="setPalteRate"/>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="被保险人" prop="insured_name">
            <el-input v-model="form.insured_name" placeholder="请输入被保险人" />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="联系电话" prop="phone_no">
            <el-input v-model="form.phone_no" placeholder="请输入联系电话" />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="出单机构" prop="make_dept">
            <el-input v-model="form.make_dept" placeholder="请输入出单机构" @change="setRate"/>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30" class="mb8">
        <el-col :span="5">
          <el-form-item label="是否新能源" prop="isNewEnery">
            <el-select v-model="form.isNewEnery" placeholder="请选择" @change="setRate">
              <el-option
                v-for="dict in dict.type.sys_yes_no"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="是否过户" prop="isChange">
            <el-select v-model="form.isChange" placeholder="请选择" @change="setRate">
              <el-option
                v-for="dict in dict.type.sys_yes_no"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="是否投保交强" prop="isCli">
            <el-select v-model="form.isCli" placeholder="请选择" @change="setRate();setCarLoss()">
              <el-option
                v-for="dict in dict.type.sys_yes_no"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="是否投保商业" prop="isVi">
            <el-select v-model="form.isVi" placeholder="请选择" @change="setRate();setCarLoss()">
              <el-option
                v-for="dict in dict.type.sys_yes_no"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30" class="mb8">
        <el-col :span="5">
          <el-form-item label="是否投保车损" prop="isCarLoss">
            <el-select v-model="form.isCarLoss" placeholder="请选择" @change="setRate">
              <el-option
                v-for="dict in dict.type.sys_yes_no"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>


      <el-divider>交强险保费</el-divider>
      <el-row :gutter="30" class="mb8">
        <el-col :span="5">
          <el-form-item label="保费" prop="jq_fee">
            <el-input v-model="form.jq_fee" placeholder="请输入保费" @change="setJQAmount()"/>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="费用率" prop="jq_rate">
            <el-input v-model="form.jq_rate" placeholder="请输入费用率" @change="setJQAmount()"/>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="费用额" prop="jq_amount">
            <el-input v-model="form.jq_amount" placeholder="请输入费用额" />
          </el-form-item>
        </el-col>
      </el-row>

      <el-divider>商业险保费</el-divider>
      <el-row :gutter="30" class="mb8">
        <el-col :span="5">
          <el-form-item label="初始定价系数" prop="price_first_rate">
            <el-input v-model="form.price_first_rate" placeholder="请输入初始定价系数" @change="setFinalRate()"/>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="费折定价系数" prop="price_fee_rate">
            <el-input v-model="form.price_fee_rate" placeholder="请输入费折定价系数" @change="setFinalRate()"/>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="人工系数调节" prop="price_charge_rate">
            <el-input v-model="form.price_charge_rate" placeholder="请输入人工系数调节" @change="setFinalRate()" />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="出单定价系数" prop="price_final_rate">
            <el-input v-model="form.price_final_rate" placeholder="请输入出单定价系数" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30" class="mb8">
        <el-col :span="5">
          <el-form-item label="初始保费" prop="sy_first_fee">
            <el-input v-model="form.sy_first_fee" placeholder="请输入初始保费" @change="setSYAmount();setFinalFee();setFeeNotax()"/>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="费用率" prop="sy_fee_rate">
            <el-input v-model="form.sy_fee_rate" placeholder="请输入费用率" @change="setSYAmount()"/>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="费用额" prop="sy_amount">
            <el-input v-model="form.sy_amount" placeholder="请输入费用额" />
          </el-form-item>
        </el-col>
        <el-col :span="5"></el-col>
      </el-row>
      <el-row :gutter="30" class="mb8">
        <el-col :span="5">
          <el-form-item label="费折后保费" prop="sy_after_fee">
            <el-input v-model="form.sy_after_fee" placeholder="请输入费折后保费" @change="setFinalFee();setFeeNotax()"/>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="人工系数调节保费" prop="sy_charge_fee">
            <el-input v-model="form.sy_charge_fee" placeholder="请输入人工系数调节保费" @change="setFinalFee();setFeeNotax()"/>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="出单保费" prop="sy_final_fee">
            <el-input v-model="form.sy_final_fee" placeholder="请输入出单保费" />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="非车险保费" prop="nocar_price">
            <el-input v-model="form.nocar_price" placeholder="请输入非车险保费" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-divider></el-divider>
      <el-row :gutter="30" class="mb8">
        <el-col :span="5">
          <el-form-item label="可用最大费用额" prop="avalid_amount">
            <el-input v-model="form.avalid_amount" placeholder="请输入可用最大费用额" />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="剩余费用额（不扣税）" prop="last_fee_NoTax">
            <el-input v-model="form.last_fee_NoTax" placeholder="请输入剩余费用额（不扣税）" @change="setLastFeeTax()"/>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="剩余费用额（扣税）" prop="last_fee_Tax">
            <el-input v-model="form.last_fee_Tax" placeholder="请输入剩余费用额（扣税）" />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="合计保费" prop="total_fee">
            <el-input v-model="form.total_fee" placeholder="请输入合计保费" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="30" class="mb8">
        <el-col :span="5">
          <el-form-item label="出单员" prop="make_name">
            <el-input v-model="form.make_name" placeholder="请输入出单员" />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item v-if="isShowPrice" label="报价状态" prop="c_price_status">
            <el-input v-model="form.c_price_status" placeholder="请输入报价状态" />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="备注" prop="c_remark">
            <el-input type="textarea"  style="width: 400px" show-word-limit maxlength ='500' v-model="form.c_remark" placeholder="请输入备注" />
          </el-form-item>
        </el-col>

      </el-row>
    </el-form>
  </div>
</template>
<script>

import { authRole } from '@/plugins/auth'

export default {
  name: "cargroup_priceForm",
  dicts: ['sys_yes_no'],
  props: {
    form:{}
  },
  data() {
    return {
      isShowPrice: false,
      sysdate: new Date(),
      // 表单参数

      // 表单校验
      rules: {
        /*sp_id:{ required: true, message: "不能为空", trigger: "blur" },
        sp_name:{ required: true, message: "不能为空", trigger: "blur" },
        name:{ required: true, message: "不能为空", trigger: "blur" },
        dept:{ required: true, message: "不能为空", trigger: "blur" },*/
      },
    }
  },
  created() {
    if( authRole("cargroup_showPrice")){
      this.isShowPrice = true;
    }else{
      this.isShowPrice = false;
    }

  },
  methods: {
    //车牌号变动修改 费率
    setPalteRate(){

      const paltemap = [{'鲁A':'济南'},{'鲁H':'济宁'},{'鲁C':'淄博'},{'鲁P':'聊城'},{'鲁F':'烟台'},{'鲁K':'威海'}
        ,{'鲁E':'东营'},{'鲁J':'泰安'},{'鲁D':'枣庄'},{'鲁M':'滨州'},{'鲁R':'菏泽'},{'鲁L':'日照'}
        ,{'鲁S':'莱芜'},{'鲁N':'德州'},{'鲁Q':'临沂'},{'鲁G':'潍坊'},{'鲁V':'潍坊'},{'鲁Y':'烟台'},{'鲁B':'济南'}];
      paltemap.map(item=>{
        let palte =  this.form.plate_no.substring(0,2);
        if(item[palte] !=undefined){
          console.log(item[palte]);
          this.form.make_dept = item[palte];
          this.setRate();
        }

      });

    },
    //设置出单保费
    setFinalFee(){
      let fee = this.min(this.form.sy_first_fee,this.form.sy_after_fee);
      this.form.sy_final_fee = this.min(fee,this.form.sy_charge_fee);
      this.form.total_fee = this.add(this.form.jq_fee,this.form.sy_final_fee);
    },
    min(first,end){
      if(first ==null || first == ''){
        return end;
      }
      if(end == null || end == ''){
        return  first;
      }
      let fee = parseFloat(first) < parseFloat(end)?first:end;
      return fee;
    },
    add(first,end){
      if(first ==null || first ==''){
        return  end;
      }
      if(end ==null || end ==''){
        return  first;
      }
      return (parseFloat(first)+parseFloat(end)).toFixed(2);
    },
    sub(first,end){

      if(end ==null || end ==''){
        return  first;
      }
      return (parseFloat(first)-parseFloat(end)).toFixed(2);
    },
    //设置剩余费用额
    setFeeNotax(){
      if(this.form.sy_after_fee ==null || this.form.sy_after_fee ==''){
        this.form.last_fee_NoTax =this.form.avalid_amount;
      }else{
        this.form.last_fee_NoTax =this.sub(this.form.avalid_amount,this.sub(this.form.sy_first_fee,this.form.sy_after_fee));
      }
      this.form.last_fee_Tax = (parseFloat(this.form.last_fee_NoTax) *  (1-0.065)).toFixed(2);
    },
    //设置商业费用额
    setSYAmount(){
      this.form.sy_amount = (this.form.sy_first_fee * this.form.sy_fee_rate).toFixed(2);
      this.form.avalid_amount = this.add(this.form.sy_amount,this.form.jq_amount);
      this.setFeeNotax();
    },
    //设置交强 费用额
    setJQAmount(){
      this.form.jq_amount = (this.form.jq_fee * this.form.jq_rate).toFixed(2);
      this.form.avalid_amount = this.add(this.form.jq_amount,this.form.sy_amount,);
      this.setFeeNotax();
      this.form.total_fee = this.add(this.form.jq_fee,this.form.sy_final_fee);
    },
    setLastFeeTax(){
      this.form.last_fee_Tax = (parseFloat(this.form.last_fee_NoTax) *  (1-0.065)).toFixed(2);
    },
    //设置出单定价系数
    setFinalRate(){
      if(this.form.price_first_rate !=null && this.form.price_first_rate !=''){
        this.form.price_first_rate = parseFloat(this.form.price_first_rate);
      }
      if(this.form.price_fee_rate !=null && this.form.price_fee_rate !=''){
        this.form.price_fee_rate = parseFloat(this.form.price_fee_rate);
      }
      if(this.form.price_charge_rate !=null && this.form.price_charge_rate !=''){
        this.form.price_charge_rate = parseFloat(this.form.price_charge_rate);
      }

      let rate = this.min(this.form.price_first_rate,this.form.price_fee_rate);
      this.form.price_final_rate = this.min(rate,this.form.price_charge_rate);
    },
    //设置是否投保车损
    setCarLoss(){
      if(this.form.isVi == "N"){
        this.$set(this.form,'isCarLoss','N');
        this.$set(this.form,'sy_first_fee',null);
        this.$set(this.form,'sy_fee_rate',null);
        this.$set(this.form,'sy_amount',null);
        /*this.form.isCarLoss = "N";
        this.$set(this.form,t,this.form);*/
      }
      if(this.form.isCli=="N"){
        this.$set(this.form,'jq_fee',null);
        this.$set(this.form,'jq_rate',null);
        this.$set(this.form,'jq_amount',null);
      }
      this.setFinalFee();
    },
    //设置交强及商业费用率
    setRate(){
      let jqrate = 0.00;
      let dept = this.form.make_dept;
      if('Y'== this.form.isChange && 'Y'==this.form.isCli && 'Y'==this.form.isVi){
        if("济南" == dept || "济宁" == dept || "淄博" == dept|| "泰安" == dept || "滨州" == dept || "日照" == dept
          || "莱芜" == dept || "德州" == dept || "临沂" == dept || "潍坊" == dept){
          jqrate = 0.12;
        }
        if("聊城" == dept || "烟台" == dept || "东营" == dept || "枣庄" == dept){
          jqrate = 0.1;
        }
        if("菏泽" == dept){
          jqrate = 0.13;
        }
        if("威海" == dept){
          jqrate = 0.08;
        }
      } else if("N" == this.form.isChange  && "Y"==this.form.isCli && "Y"==this.form.isVi){
        if("济南" == dept || "济宁" == dept || "淄博" == dept|| "泰安" == dept || "滨州" == dept || "日照" == dept
          || "莱芜" == dept || "临沂" == dept){
          jqrate = 0.22;
        }
        if("聊城" == dept || "烟台" == dept || "东营" == dept || "枣庄" == dept){
          jqrate = 0.2;
        }
        if("威海" == dept){
          jqrate = 0.18;
        }
        if("菏泽" == dept){
          jqrate = 0.23;
        }
        if("德州" == dept){
          jqrate = 0.28;
        }
        if("潍坊" == dept){
          jqrate = 0.24;
        }
      }else if("Y"==this.form.isCli){
        if("济南" == dept || "聊城" == dept || "东营" == dept|| "枣庄" == dept || "莱芜" == dept ){
          jqrate = 0.2;
        }
        if("济宁" == dept || "淄博" == dept){
          jqrate = 0.22;
        }
        if("烟台" == dept || "威海" == dept || "日照" == dept){
          jqrate = 0.0377;
        }
        if("泰安" == dept){
          jqrate = 0.0677;
        }
        if("滨州" == dept){
          jqrate = 0.1;
        }
        if("菏泽" == dept){
          jqrate = 0.23;
        }
        if("德州" == dept){
          jqrate = 0.28;
        }
        if("临沂" == dept){
          jqrate = 0.25;
        }
        if("潍坊" == dept){
          jqrate = 0.24;
        }
      }else {
        jqrate = 0.00;
      }
      this.form.jq_rate = jqrate;
      //设置商业 费率

      let rate = 0.00;
      if('Y'==this.form.isNewEnery && 'Y'==this.form.isVi){
        rate = 0.0283;
      } else if("Y"==this.form.isChange  && "Y"==this.form.isCli && "Y"==this.form.isVi){
        if("济南" == dept || "济宁" == dept || "淄博" == dept|| "泰安" == dept || "滨州" == dept
          || "日照" == dept || "莱芜" == dept || "德州" == dept || "临沂" == dept || "潍坊" == dept){
          rate = 0.12;
        }
        if("聊城" == dept || "烟台" == dept || "东营" == dept || "枣庄" == dept){
          rate = 0.1;
        }
        if("威海" == dept){
          rate = 0.08;
        }
        if("菏泽" == dept){
          rate = 0.13;
        }
      } else if("N"==this.form.isChange  && "Y"==this.form.isCli && "Y"==this.form.isVi
        && "Y"==this.form.isCarLoss){
        if("威海" == dept || "德州" == dept){
          rate = 0.132;
        }else if("泰安" == dept){
          rate = 0.2;
        }else{
          rate = 0.15;
        }
      } else if("N"==this.form.isChange && "Y"==this.form.isCli && "Y"==this.form.isVi){
        if("聊城" == dept || "烟台" == dept || "东营" == dept || "枣庄" == dept){
          rate = 0.2;
        } else if("威海" == dept){
          rate = 0.18;
        }else if("菏泽" == dept){
          rate = 0.23;
        }else if("潍坊" == dept){
          rate = 0.24;
        }else{
          rate = 0.22;
        }
      }else if("Y"==this.form.isVi){
        if("聊城" == dept || "烟台" == dept || "东营" == dept || "枣庄" == dept){
          rate = 0.1;
        }else if("威海" == dept){
          rate = 0.08;
        }else if("菏泽" == dept){
          rate = 0.13;
        }else{
          rate = 0.12;
        }
      }else {
        rate = 0.00;
      }
     this.form.sy_fee_rate = rate;
      this.setJQAmount();
      this.setSYAmount();
    }
  }
}
</script>
