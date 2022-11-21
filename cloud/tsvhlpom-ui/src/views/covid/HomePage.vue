<template>
  <div class="app-container home p" style="text-align: center">
    <el-container style="height: auto">
      <el-form :model="queryParams" ref="queryForm" :inline="true">
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
                     placeholder="请输入查询内容" :disabled="deptFlag">
            <el-option
              v-for="item in selectData2"
              :key="item.value"
              :label="item.text"
              :value="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="时间" prop="day">
          <el-date-picker
            v-model="queryParams.day"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择时间"
          ></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        </el-form-item>
        <br>
      </el-form>
      <!--<el-header><p>欢迎使用泰山保险系统</p></el-header>-->
      <el-header><span>{{title}}：{{sumcount}}</span></el-header>
      <el-main style="width: 100%;margin:0;padding: 0">
        <el-row>
          <el-col :span="6">
            <pie id="1" :text-margin="textMargintop" :f-margin="fMargintop"   width="400px"
                 :height="gaugeheight" :title="title" :data-map="dataMap"></pie>
          </el-col>
          <el-col :span="18">
            <category id="2" :height="linearHeight" :width="linearWith"
                      style="width: 97%;" :title="linearTitle"
                      :rightname="rightname" :x-axis-data1="answer.xAxis"
                      :y-axis-data1="answer.yAxis" :y-axis-data2="answer.yAxis2" :y-axis-data3="answer.yAxis3" :legend="lens"></category>
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
import category from "@/components/Echarts/category";
import pie from "@/components/Echarts/pie"
import {getAnalyseAnswer} from "@/api/covid_query";
import SelectDept from "@/components/SelectDept";

export default {
  components: {category,pie},
  name: "HomePage",
  data() {
    return {
      // 版本号
      version: "3.2.0",
      selectData2:[],
      selectData1: SelectDept,
      parentDeptFlag:false,
      deptFlag:false,
      queryParams: {
        c_parent_dept: undefined,
        c_dept: undefined,
        day: undefined,
      },
      sumcount:0,
      /**饼图**/
      title:"",
      textMargintop:"20%",
      fMargintop:"80%",
      totalReptime:"50%",
      gaugeheight:"400px",
      dataMap:[{"name":"已登记正常人数","value":0},{"name":"已登记异常人数","value":0},{"name":"未登记人数","value":0}],
      /*第一个柱状图*/
      linearHeight: "400px",
      linearWith: "70%",
      linearTitle: "详细信息",
      rightname: "人数",
      lens: ['已登记','未登记'],
      answer: {
        //模拟数据
        xAxis: [""],
        //响应次数
        yAxis: [""],
        yAxis2: [""],
        yAxis3: [""],
        repTimes: 0,
      },
      /*第二个柱状图*/
      linearHeight1: "400px",
      linearWith1: "70%",
      linearTitle1: "当天填写人数",
      rightname1: "人数",
      lens1: ['人数'],
      answer1: {
        //模拟数据
        xAxis: ["全司"],
        //响应次数
        yAxis: ["0"],
        repTimes: 0,
      },
    };
  },
  created() {
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
    //默认时间为当天
    let date = new Date();
    let month = date.getMonth()+1;
    let day = date.getFullYear()+"-"+month+"-"+date.getDate();
    this.queryParams.day = day;
    this.title = loginUser.dept.deptName;
    this.inits(this.queryParams);
  },
  methods: {
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    handleQuery(){
      this.inits(this.queryParams);
    },
    inits(param) {
      getAnalyseAnswer(param).then(res2 => {
        var datas2 = JSON.parse(JSON.stringify(res2));
        if (typeof (datas2) == 'undefined') {
          this.answer = [];
          this.answer1 = [];
        } else {
          this.answer = datas2;
          //this.answer1.yAxis = [datas2.sumCount];
          this.sumcount = datas2.sumCount;
          let b = {"name":"未登记人数","value":datas2.pie["未登记人数"],itemStyle:{color:'#38dd88'}};
          let a = {"name":"已登记正常人数","value":datas2.pie["已登记正常人数"],itemStyle:{color:'#3d6af8'}};
          let c = {"name":"已登记异常人数","value":datas2.pie["已登记异常人数"],itemStyle:{color:'#f8b88e'}};
          this.dataMap = [];
          this.dataMap.push(b);
          this.dataMap.push(a);
          this.dataMap.push(c);
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

