<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="150px">

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
    </el-form>

    <el-row :gutter="10" class="mb8">
      <!--<el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['proddata:abstractVO:save']"
        >新增</el-button>
      </el-col>-->
      <!-- <el-col :span="1.5">
         <el-button
           type="success"
           plain
           icon="el-icon-edit"
           size="mini"
           :disabled="single"
           @click="handleUpdate"
           v-hasPermi="['proddata:abstractVO:update']"
         >修改</el-button>
       </el-col>-->
      <!--<el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['proddata:abstractVO:delete']"
        >删除</el-button>
      </el-col>-->
    </el-row>

    <el-table v-loading="loading" :data="meetingBookList" id="printHere">
      <!-- <el-table-column type="selection" width="55" align="center" />-->
      <el-table-column  label="会议室名称" align="center" prop="meetingRoom_name" />
      <el-table-column></el-table-column>
      <el-table-column></el-table-column>

      <el-table-column  label="使用次数" align="center" prop="meet_Time" />
      <el-table-column></el-table-column>
      <el-table-column></el-table-column>
      <el-table-column></el-table-column>
    </el-table>
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
  </div>
</template>

<script>

import '@riophae/vue-treeselect/dist/vue-treeselect.css'
import {getAbstractVOList, updateEmail} from '@/api/proddata/abstractVO'
import request from "@/utils/request";

export default {
  name: "statisicTable",
  dicts: ['sys_meeting_sp_status'],
  data() {
    return {
      startDateRange:[],
      endDateRange:[],
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
      // list
      meetingBookList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {},
      // 表单参数
      form: {},
      /*// 表单校验
      rules: {
        c_conf_group:{ required: true, message: "c_conf_group不能为空", trigger: "blur" },
        c_conf_id:{ required: true, message: "c_conf_id不能为空", trigger: "blur" },
        c_conf_nme:{ required: true, message: "c_conf_nme不能为空", trigger: "blur" },
        c_conf_value:{ required: true, message: "c_conf_value不能为空", trigger: "blur" },
      },*/
      print: {
        id: 'printHere',
        popTitle: '统计分析', // 打印配置页上方的标题
        extraHead: '打印', // 最上方的头部文字，附加在head标签上的额外标签，使用逗号分割
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
    //this.getList();
  },
/*  mounted() {
    //定时刷新页面
    if(this.timer){
      clearInterval(this.timer);
    }else{
      this.timer = setInterval( () =>{
        this.getList();
      },300000);
    }
  },
  destroyed() {
    clearInterval(this.timer);
  },*/
  methods: {
    getList() {
      this.loading = true;
      this.meetingBookList = [];
      let params = this.addDateRange(this.queryParams,this.startDateRange,'meeting_starttm');
      params = this.addDateRange(params,this.endDateRange,'meeting_endtm');
      return request({
        url: '/meetingpreset/meetingBook/statisticsTable',
        method: 'post',
        params: params.params
      }).then(response =>{
        response.data.forEach(map =>{
          let obj = {};
          obj.meetingRoom_name = map.ROOMNAME;
          obj.meet_Time = map.TIMES;
          this.meetingBookList.push(obj);
        });
        /*this.meetingBookList = response.data;
        this.total = response.total;*/
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.startDateRange = [];
      this.endDateRange = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
  }
};
</script>
