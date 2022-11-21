<template>
  <div class="app-container">

    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="150px">
      <el-form-item label="会议室名称" prop="meetingRoom_name">
        <el-select v-model="queryParams.meetingRoom_name" placeholder="请选择会议室" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_meetRoomList"
            :key="dict.label"
            :label="dict.label"
            :value="dict.label"
          />
        </el-select>
<!--        <el-input
          v-model="queryParams.meetingRoom_name"
          placeholder="请输入会议室名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />-->
      </el-form-item>
      <el-form-item label="部门名称" prop="dept_name">
        <el-input
          v-model="queryParams.dept_name"
          placeholder="请输入部门名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批状态" prop="sp_status">
        <el-select v-model="queryParams.sp_status" placeholder="请选择审批状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_meeting_sp_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
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

    <el-table v-loading="loading" :data="meetingBookList">
      <!-- <el-table-column type="selection" width="55" align="center" />-->
      <el-table-column label="部门" align="center" prop="dept_name" />
      <el-table-column label="申请人" align="center" prop="applyer_Name" >
        <template slot-scope="scope">
          <span v-if="scope.row.applyer_Name">{{scope.row.applyer_Name}}</span>
          <span v-else>{{scope.row.applyer_id}}</span>
        </template>
      </el-table-column>
      <el-table-column label="会议室名称" align="center" prop="meetingRoom_name" />
      <el-table-column label="会议时间" align="center" prop="meet_Time" />
      <el-table-column label="会议用品" align="center" prop="meeting_use" />
      <el-table-column label="审批状态" align="center" prop="sp_status" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_meeting_sp_status" :value="scope.row.sp_status"></dict-tag>
        </template>
      </el-table-column>
<!--      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['proddata:abstract:update']"
          >修改</el-button>
          &lt;!&ndash;<el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['proddata:basConfig:delete']"
          >删除</el-button>&ndash;&gt;
        </template>
      </el-table-column>-->
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
  name: "meetingbook",
  dicts: ['sys_meeting_sp_status','sys_meetRoomList'],
  data() {
    return {
      meetingRoomList: [],
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
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        meetingRoom_name: undefined,
        dept_name: undefined,
        sp_status: undefined
      },
      // 表单参数
      form: {},
      /*// 表单校验
      rules: {
        c_conf_group:{ required: true, message: "c_conf_group不能为空", trigger: "blur" },
        c_conf_id:{ required: true, message: "c_conf_id不能为空", trigger: "blur" },
        c_conf_nme:{ required: true, message: "c_conf_nme不能为空", trigger: "blur" },
        c_conf_value:{ required: true, message: "c_conf_value不能为空", trigger: "blur" },
      },*/
    };
  },
  created() {
    this.getList();
    //this.getRoom();
  },
  mounted() {
    //定时刷新页面
    if(this.timer){
      clearInterval(this.timer);
    }else{
      this.timer = setInterval( () =>{
        this.getList();
      },60000);
    }
  },
  destroyed() {
    clearInterval(this.timer);
  },
  methods: {
    getRoom(){
      return request({
        url: '/meetingpreset/meetingBook/getMeetRoomList',
        method: 'get'
      }).then(response =>{
        this.meetingRoomList = response;
      });
    },
    getList() {
      this.loading = true;
      return request({
        url: '/meetingpreset/meetingBook/showInfo',
        method: 'get',
        params: this.queryParams
      }).then(response =>{
        this.meetingBookList = response.rows;
        this.total = response.total;
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
      this.resetForm("queryForm");
      this.handleQuery();
    },
  }
};
</script>
