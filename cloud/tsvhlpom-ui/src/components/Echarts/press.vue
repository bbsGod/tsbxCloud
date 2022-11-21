

<template>
  <div :style="{heigh:height,width:width,background:bcbackground}" class="div1">
    <div :style="{heigh:height,background:prebackground}" class="div2"></div>
    <span class="span1">{{presswith+" "+company}}</span>
<!--    <span class="span2">{{max}}/{{total}}GB</span>-->
  </div>
</template>
<style>
  .div1{
    position: relative;
    width: 300px;
    height: 40px;
    background: #cccccc;
    cursor:pointer;
  }
  .div2{
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 40px;
    background: #42b983;
  }
  .span1{
    position: absolute;
    top: 0;
    left: 45%;
    line-height: 45px;
    font-size: 14px;
  }
  .span2{
    position: absolute;
    top: 0;
    right: 0;
    line-height: 45px;
    font-size: 14px;
  }
</style>
<script>
  export default {
    props:{
      company:{
        type:String,
        default:"MB"
      },
      width:{
        type:String,
        default:"100%"
      },
      height:{
        type:String,
        default:"40px"
      },
      fontCenterSize:{
        type:String,
        default:"14px"
      },
      fontrightSize:{
        type:String,
        default:"14px"
      },
      prebackground:{
        type:String,
        default:"#1ab394;"
      },
      bcbackground:{
        type:String,
        default:" #F1F2F5"
      },
      presswith:{
        type:String,
        default:"0"
      },
      total:{
        type:Number,
        default:4
      },
      max:{
        type:Number,
        default:2
      }


    },

    data(){
      return {
        chartColumn: null,
      }
    },
    mounted() {
    },
    methods: {
    }
  }
</script>
