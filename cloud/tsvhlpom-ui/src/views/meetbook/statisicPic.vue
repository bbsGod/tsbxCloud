<template>
  <div class="app-container home p" style="text-align: center">
    <el-container style="height: auto">
      <el-form :model="queryParams" ref="queryForm" :inline="true">
        <el-form-item label="会议开始时间" prop="startDate">
          <el-date-picker
            v-model="startDateRange"
            size="small"
            style="width: 240px"
            value-format="yyyy-MM-dd HH:mm:ss"
            type="daterange"
            range-separator="-"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="会议结束时间" prop="endDate">
          <el-date-picker
            v-model="endDateRange"
            size="small"
            style="width: 240px"
            value-format="yyyy-MM-dd HH:mm:ss"
            type="daterange"
            range-separator="-"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
          ></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
          <el-button icon="el-icon-download" type="success" size="mini" v-print="print">打印</el-button>
        </el-form-item>
        <br>
      </el-form>
      <!--<el-header><p>欢迎使用泰山保险系统</p></el-header>-->
      <el-header></el-header>
      <el-main style="width: 100%;margin:0;padding: 0" id="printHere" popTitle="打印">
        <el-row>
          <el-col :span="6">
            <pie id="1" :text-margin="textMargintop" :f-margin="fMargintop"   width="400px"
                 :height="gaugeheight" :title="title" :data-map="dataMap"></pie>
          </el-col>
          <el-col :span="18">
            <category_meet id="2" :height="linearHeight" :width="linearWith"
                      style="width: 97%;" :title="linearTitle"
                      :rightname="rightname" :x-axis-data1="answer.xAxis"
                      :y-axis-data1="answer.yAxis" :legend="lens"></category_meet>
          </el-col>
        </el-row>



      </el-main>
      <!--<el-footer style="width: 100%;background: #F1F2F5;height: 213px;margin-top: 10px;padding: 0">
        <category id="1" :height="linearHeight1"  :width="linearWith1"
                  style="width: 97%;" :title="linearTitle1"
                  :rightname="rightname1" :x-axis-data1="answer1.xAxis"
                  :y-axis-data1="answer1.yAxis" :legend="lens1"></category>
      </el-footer>-->
    </el-container>
  </div>
</template>

<script>
import category_meet from "@/components/Echarts/category_meet";
import pie from "@/components/Echarts/pie"
import {getAnalyseAnswer} from "@/api/covid_query";
import SelectDept from "@/components/SelectDept";
import request from '@/utils/request'

export default {
  components: {category_meet,pie},
  name: "statisicPic",
  data() {
    return {
      // 版本号
      startDateRange: [],
      endDateRange: [],
      version: "3.2.0",
      selectData2:[],
      selectData1: SelectDept,
      parentDeptFlag:false,
      deptFlag:false,
      queryParams: {
      },
      sumcount:0,
      /**饼图**/
      title:"",
      textMargintop:"20%",
      fMargintop:"80%",
      totalReptime:"50%",
      gaugeheight:"400px",
      dataMap:[],
      /*第一个柱状图*/
      linearHeight: "400px",
      linearWith: "70%",
      linearTitle: "详细信息",
      rightname: "次数",
      lens: [],
      answer: {
        //模拟数据
        xAxis: [""],
        //响应次数
        yAxis: [""],
        repTimes: 0,
      },
      print: {
        id: 'printHere',
        popTitle: '统计分析', // 打印配置页上方的标题
        extraHead: '', // 最上方的头部文字，附加在head标签上的额外标签，使用逗号分割
        preview: false, // 是否启动预览模式，默认是false
        previewTitle: '预览的标题', // 打印预览的标题
        previewPrintBtnLabel: '预览结束，开始打印', // 打印预览的标题下方的按钮文本，点击可进入打印
        zIndex: 20002, // 预览窗口的z-index，默认是20002，最好比默认值更高
        previewBeforeOpenCallback () { console.log('正在加载预览窗口！'); console.log(this.msg, this) }, // 预览窗口打开之前的callback
        previewOpenCallback () { console.log('已经加载完预览窗口，预览打开了！') }, // 预览窗口打开时的callback
        beforeOpenCallback () { console.log('开始打印之前！') }, // 开始打印之前的callback
        openCallback () { console.log('执行打印了！') }, // 调用打印时的callback
        closeCallback () { console.log('关闭了打印工具！') }, // 关闭打印的callback(无法区分确认or取消)
        clickMounted () { console.log('点击v-print绑定的按钮了！') },
        // url: 'http://localhost:8080/', // 打印指定的URL，确保同源策略相同
        // asyncUrl (reslove) {
        //   setTimeout(() => {
        //     reslove('http://localhost:8080/')
        //   }, 2000)
        // },
        standard: '',
        extarCss: ''
      }
    };
  },
  created() {
    this.inits();
    /*let loginUser = this.$store.state.user.loginUser;
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
    //默认时间为当天
    let date = new Date();
    let month = date.getMonth()+1;
    let day = date.getFullYear()+"-"+month+"-"+date.getDate();
    this.queryParams.day = day;
    this.title = loginUser.dept.deptName;
    this.inits(this.queryParams);*/
  },
  methods: {
    /** 重置按钮操作 */
    resetQuery() {
      this.startDateRange = [];
      this.endDateRange = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    handleQuery(){
      this.inits(this.queryParams);
    },
    inits(param) {
      let params = this.addDateRange(this.queryParams,this.startDateRange,'meeting_starttm');
      params = this.addDateRange(params,this.endDateRange,'meeting_endtm');
      return request({
        url: '/meetingpreset/meetingBook/statisticsPic',
        method: 'post',
        params: params.params
      }).then(res2 =>{
        var datas2 = JSON.parse(JSON.stringify(res2));
        if (typeof (datas2) == 'undefined') {
          this.answer = [];
          this.answer1 = [];
        } else {
          this.answer = datas2;
          this.dataMap = datas2.pieMap;
        }
      });
    },
    goTarget(href) {
      window.open(href, "_blank");
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
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 33px;
  color: #030303;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
  canvas{
    width: 200px;
    height: 200px;
  }
}
</style>

