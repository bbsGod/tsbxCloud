<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" :rules="queryRules" label-width="150px">
      <el-form-item label="缴费编码" prop="bizseq">
        <el-input @change="clearRes"
          v-model="queryParams.bizseq"
          placeholder="请输入缴费编码"
          clearable
          size="small"
        />
      </el-form-item>
      <el-button type="primary" icon="el-icon-search" size="mini" @click="handlePay">提交</el-button>
      <el-row>
        <el-form-item label="结果:" prop="res">
          {{queryParams.res}}
<!--          <el-input type="textare" v-model=""></el-input>-->
        </el-form-item>
      </el-row>

    </el-form>
  </div>

</template>
<script>
import request from "@/utils/request";
export default {
  name: 'pay',
  data(){
    return {
      queryParams:{
        bizseq:undefined,
        res:undefined},
      queryRules: {
        bizseq: {required: true, message: "缴费编码不能为空", trigger: "blur"},
      },
    }
  },
  methods:{
    handlePay(){
      this.$refs["queryForm"].validate(valid => {
        if (valid) {
          return request({
            url: '/pay/pay_service/pay?bizseq='+this.queryParams.bizseq,
            method: 'get'
          }).then(res =>{
            this.queryParams.res = res.msg;
          })
        }
      });
    },
    clearRes(){
      this.queryParams.res = undefined;
    }
  }
}
</script>
