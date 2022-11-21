<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true">
      <el-form-item label="重点客户名称" prop="c_sp_cust_nme">
        <el-input
          v-model="queryParams.c_sp_cust_nme"
          placeholder="请输入重点客户名称"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="c_nme">
        <el-input
          v-model="queryParams.c_nme"
          placeholder="请输入姓名"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="行驶证车主" prop="c_reg_owner">
        <el-input
          v-model="queryParams.c_reg_owner"
          placeholder="请输入行驶证车主"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车牌号" prop="c_plate_no">
      <el-input
        v-model="queryParams.c_plate_no"
        placeholder="请输入车牌号"
        clearable
        size="small"
        style="width: 240px"
        @keyup.enter.native="handleQuery"
      />
    </el-form-item>
<!--      <el-form-item label="车架号" prop="c_frm_no">
        <el-input
          v-model="queryParams.c_frm_no"
          placeholder="请输入车架号"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发动机号" prop="c_eng_no">
        <el-input
          v-model="queryParams.c_eng_no"
          placeholder="请输入发动机号"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="保险起期范围" prop="t_insrnc_bgn_tm">
        <el-date-picker
          v-model="bgnDateRange"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>-->
      <el-form-item label="创建日期范围" prop="t_create_date">
        <el-date-picker
          v-model="crtDateRange"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="回访状态" prop="c_visit_statusList">
        <el-select v-model="queryParams.c_visit_statusList" multiple clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_cargroup_visitType"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="报价状态" prop="c_price_status">
        <el-input
          v-model="queryParams.c_price_status"
          placeholder="请输入报价状态"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="距保险止期（天）">
        <el-input
          v-model="queryParams.c_start_date"
          clearable
          size="small"
          style="width:100px"
          @keyup.enter.native="handleQuery"
        />
        至
        <el-input
          v-model="queryParams.c_end_date"
          clearable
          size="small"
          style="width: 100px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="手机号" prop="c_mobile">
        <el-input
          v-model="queryParams.c_mobile"
          placeholder="请输入手机号"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="部门" prop="c_person_dept">
        <el-input
          v-model="queryParams.c_person_dept"
          placeholder="请输入部门"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="维护人" prop="c_person_name">
        <el-input
          v-model="queryParams.c_person_name"
          placeholder="请输入维护人"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="服务标志" prop="c_person_flag">
        <el-input
          v-model="queryParams.c_person_flag"
          placeholder="请输入服务标志"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否回访成功" prop="c_visitOrPrice">
        <el-select v-model="queryParams.c_visitOrPrice" clearable size="small">
          <el-option
            v-for="dict in flagList"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="企微客户" prop="c_is_wxfriend">
        <el-select v-model="queryParams.c_is_wxfriend" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="客户类型" prop="c_cus_typ">
        <el-select v-model="queryParams.c_cus_typ" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_cargroup_custTpyList"
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
      <br>
    </el-form>
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['taishanpic:visit:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['taishanpic:visit:update']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['taishanpic:visit:delete']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['taishanpic:visit:export']"
        >导出</el-button>
      </el-col>
<!--      <el-col :span="1.5">
        <el-button
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['taishanpic:visit:updatevisit']"
        >更新回访状态</el-button>
      </el-col>-->
    </el-row>
    <el-table v-loading="loading" width="180%" :data="customersList" @selection-change="handleSelectionChange" highlight-current-row>
      <el-table-column type="selection" width="55" align="center" >
      <!--<el-table-column label="重点客户标识编码" align="center" prop="c_sp_cust_id" width="200">-->
        <!--<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_sp_cust_id" aria-required="true"></el-input>
          </template>
          <span v-else>{{scope.row.c_sp_cust_id}}</span>
        </template>-->
      </el-table-column>
      <el-table-column label="重点客户名称" align="center" prop="c_sp_cust_nme" width="200">
        <!--<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_sp_cust_nme" aria-required="true"></el-input>
          </template>
          <span v-else>{{scope.row.c_sp_cust_nme}}</span>
        </template>-->
      </el-table-column>
      <el-table-column label="姓名" align="center" prop="c_nme"width="80" >
        <!--<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_nme" aria-required="true"></el-input>
          </template>
          <span v-else>{{scope.row.c_nme}}</span>
        </template>-->
      </el-table-column>
      <el-table-column label="手机号" align="center" prop="c_mobile" width="120">
        <!--<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_mobile" aria-required="true"></el-input>
          </template>
          <span v-else>{{scope.row.c_mobile}}</span>
        </template>-->
      </el-table-column>
      <el-table-column label="行驶证车主" align="center" prop="c_reg_owner" width="90">
        <!--<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_reg_owner" aria-required="true"></el-input>
          </template>
          <span v-else>{{scope.row.c_reg_owner}}</span>
        </template>-->
      </el-table-column>
      <el-table-column label="车牌号" align="center" prop="c_plate_no" width="100">
        <template slot-scope="scope">
          <!--<template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_plate_no"></el-input>
          </template>-->
          <span style="color: blue" @click="showVisitList(scope.row.c_pk_id)" >{{scope.row.c_plate_no}}</span>
        </template>
      </el-table-column>
     <!-- <el-table-column label="初登日期" align="center" prop="c_fst_reg_ym" width="100">
        &lt;!&ndash;<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-date-picker
              v-model="scope.row.c_fst_reg_ym"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="请选择时间"
            ></el-date-picker>
          </template>
          <span v-else>{{scope.row.c_fst_reg_ym}}</span>
        </template>&ndash;&gt;
      </el-table-column>-->
<!--      <el-table-column label="厂牌型号" align="center" prop="c_model_nme" width="200">
        &lt;!&ndash;<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_model_nme"></el-input>
          </template>
          <span v-else>{{scope.row.c_model_nme}}</span>
        </template>&ndash;&gt;
      </el-table-column>
     &lt;!&ndash; <el-table-column label="行驶总里程" align="center" prop="c_travel_mile" width="100">
        &lt;!&ndash;<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_travel_mile"></el-input>
          </template>
          <span v-else>{{scope.row.c_travel_mile}}</span>
        </template>&ndash;&gt;
      </el-table-column>&ndash;&gt;
      <el-table-column label="保险起期" align="center" prop="t_insrnc_bgn_tm" width="100">
       &lt;!&ndash; <template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-date-picker
              v-model="scope.row.t_insrnc_bgn_tm"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="请选择时间"
            ></el-date-picker>
          </template>
          <span v-else>{{scope.row.t_insrnc_bgn_tm}}</span>
        </template>&ndash;&gt;
      </el-table-column>
      <el-table-column label="车架号" align="center" prop="c_frm_no" width="200">
        &lt;!&ndash;<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_frm_no"></el-input>
          </template>
          <span v-else>{{scope.row.c_frm_no}}</span>
        </template>&ndash;&gt;
      </el-table-column>-->
<!--      <el-table-column label="发动机号" align="center" prop="c_eng_no" width="150">
        &lt;!&ndash;<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_eng_no"></el-input>
          </template>
          <span v-else>{{scope.row.c_eng_no}}</span>
        </template>&ndash;&gt;
      </el-table-column>-->
      <el-table-column label="创建日期" align="center" prop="t_create_date" width="100">
        <!--<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-date-picker
              v-model="scope.row.t_create_date"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="请选择时间"
            ></el-date-picker>
          </template>
          <span v-else>{{scope.row.t_create_date}}</span>
        </template>-->
      </el-table-column>
      <el-table-column label="回访状态" align="center" prop="c_visit_status" width="180">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.c_visit_status" :options="dict.type.sys_cargroup_visitType"></dict-tag>
        </template>
        <!--<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-select v-model="scope.row.c_visit_status"  clearable size="small">
            <el-option
              v-for="dict in dict.type.sys_cargroup_visitType"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
            </el-select>
          </template>
          <template v-if="!scope.row.edit">
            <dict-tag :value="scope.row.c_visit_status" :options="dict.type.sys_cargroup_visitType"></dict-tag>
          </template>
        </template>-->
      </el-table-column>
      <el-table-column label="企微客户" align="center" prop="c_is_wxfriend" width="150">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.c_is_wxfriend" :options="dict.type.sys_yes_no"></dict-tag>
        </template>
      </el-table-column>
      <el-table-column label="客户类型" align="center" prop="c_cus_typ" width="150">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.c_cus_typ" :options="dict.type.sys_cargroup_custTpyList"></dict-tag>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="c_remark" width="180" show-overflow-tooltip>

      </el-table-column>
      <el-table-column label="回访人员" align="center" prop="c_visit_emp" width="150">
        <!--<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_visit_emp"></el-input>
          </template>
          <span v-else>{{scope.row.c_visit_emp}}</span>
        </template>-->
      </el-table-column>
      <el-table-column label="回访时间" align="center" prop="c_visit_Tm" width="100">
        <!--<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-date-picker
              v-model="scope.row.c_visit_Tm"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="请选择时间"
            ></el-date-picker>
          </template>
          <span v-else>{{scope.row.c_visit_Tm}}</span>
        </template>-->
      </el-table-column>
      <el-table-column label="是否回访成功" prop="c_is_visit" width="100">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.c_is_visit" :options="dict.type.sys_yes_no"></dict-tag>
        </template>

      </el-table-column>
      <el-table-column label="保险到期时间" align="center" prop="c_visit_Tm" width="100">
        <template slot-scope="scope">
          <span>{{transTime(scope.row)}}</span>
        </template>
      </el-table-column>
      <el-table-column label="距保险止期（天）" align="center" prop="c_visit_Tm" width="100">
        <template slot-scope="scope">
          <span>{{difTime(scope.row)}}</span>
        </template>
      </el-table-column>
      <el-table-column label="续保客户" align="center" prop="c_is_renew" width="100">
        <template slot-scope="scope">
          <dict-tag :value="scope.row.c_is_renew" :options="dict.type.sys_yes_no"></dict-tag>
        </template>
      </el-table-column>
      <el-table-column v-if="isShowPrice"   label="报价状态" align="center" prop="c_price_status" width="200">
        <!--<template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-input v-model="scope.row.c_price_status"></el-input>
          </template>
          <span v-else>{{scope.row.c_price_status}}</span>
        </template>-->
       <!-- <template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-select v-model="scope.row.c_price_status"  clearable size="small">
              <el-option
                v-for="dict in dict.type.sys_cargroup_priceType"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              />
            </el-select>
          </template>
          <template v-if="!scope.row.edit">
            <dict-tag :value="scope.row.c_price_status" :options="dict.type.sys_cargroup_priceType"></dict-tag>
          </template>
        </template>-->
      </el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="250">
        <template slot-scope="scope">
          <el-button v-if="!scope.row.edit" icon="el-icon-edit" type="primary"  circle  @click="handlePrice(scope.row)" v-hasPermi="['taishanpic:visit:price']">报价</el-button>
          <el-button v-if="!scope.row.edit" icon="el-icon-edit" type="warning"  circle  @click="handleUpdate(scope.row,true)" v-hasPermi="['taishanpic:visit:update']">回访</el-button>
          <el-button v-if="!scope.row.edit" icon="el-icon-delete" type="danger"circle  @click="handleDelete(scope.row)" v-hasPermi="['taishanpic:visit:delete']">删除</el-button>
<!--          <el-button v-if="scope.row.edit" icon="el-icon-check" type="primary"   @click="handleVisitUpdate(scope.row)" circle></el-button>
          <el-button v-if="scope.row.edit" icon="el-icon-close" type="primary"  @click="handleDeleteItem(scope.row,scope.$index)" circle></el-button>-->
        </template>
        <!--<template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['taishanpic:dailywork:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['taishanpic:dailywork:remove']"
          >删除</el-button>
        </template>-->
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!--回访信息详情 -->
    <el-dialog :title="visittitle" :visible.sync="visitopen" width="800px" append-to-body>
      <el-table :data="visitList" width="80%">
        <el-table-column type="index"></el-table-column>
        <el-table-column label="回访状态" align="center" prop="c_visit_status">
          <template slot-scope="scope">
            <dict-tag :value="scope.row.c_visit_status" :options="dict.type.sys_cargroup_visitType"></dict-tag>
          </template>
        </el-table-column>
        <el-table-column label="回访人员" align="center" prop="c_visit_emp"></el-table-column>
        <el-table-column label="回访时间" align="center" prop="c_visit_Tm"></el-table-column>
        <el-table-column label="备注" align="center" prop="c_remark" show-overflow-tooltip></el-table-column>
      </el-table>
    </el-dialog>

    <!--    报价form-->
    <el-dialog :title="price.title" :visible.sync="price.open"  width="1150px"  append-to-body :before-close="confirmDialog">
      <cargroup_price-form :form="price.form"></cargroup_price-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitPriceForm">确 定</el-button>
        <el-button @click="cancelPrice">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 新增form-->
    <el-dialog :title="title" :visible.sync="open" width="800px"  append-to-body>
      <el-form ref="form" :model="form" :rules="rules" :inline="true" label-position="rigth" label-width="150px">
        <el-row>
          <el-form-item label="重点客户标识编码" prop="c_sp_cust_id">
            <el-autocomplete
              v-model="form.c_sp_cust_id"
              :fetch-suggestions="querySearchAsync"
              placeholder="请输入内容"
              @select="handleSelect"
            ></el-autocomplete>
            {{form.c_sp_cust_nme}}
            <!--          <el-input v-model="form.c_sp_cust_id" placeholder="请输入重点客户标识编码"  aria-required="true"/>-->
          </el-form-item>
        </el-row>
        <el-form-item label="姓名" prop="c_nme" aria-required="true">
          <el-input v-model="form.c_nme" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="手机号" prop="c_mobile" aria-required="true">
          <el-input v-model="form.c_mobile" placeholder="请输入手机号" />
        </el-form-item>

        <el-form-item label="行驶证车主" prop="c_reg_owner" aria-required="true">
          <el-input v-model="form.c_reg_owner" placeholder="请输入行驶证车主" />
        </el-form-item>
        <el-form-item label="车牌号" prop="c_plate_no">
          <el-input v-model="form.c_plate_no" placeholder="请输入车牌号" />
        </el-form-item>
        <!--<el-form-item label="初登日期" prop="c_fst_reg_ym">
          <el-date-picker
            v-model="form.c_fst_reg_ym"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择时间"
          ></el-date-picker>
        </el-form-item>-->
        <el-form-item label="厂牌型号" prop="c_model_nme">
          <el-input v-model="form.c_model_nme" placeholder="请输入厂牌型号" />
        </el-form-item>
        <!--<el-form-item label="行驶里程数" prop="c_travel_mile">
          <el-input v-model="form.c_travel_mile" placeholder="请输入行驶里程数" />
        </el-form-item>-->
        <el-form-item label="保险起期" prop="t_insrnc_bgn_tm" aria-required="true">
          <el-date-picker
            v-model="form.t_insrnc_bgn_tm"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择时间"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="车架号" prop="c_frm_no">
          <el-input v-model="form.c_frm_no" placeholder="请输入车架号" />
        </el-form-item>
        <el-form-item label="发动机号" prop="c_eng_no">
          <el-input v-model="form.c_eng_no" placeholder="请输入发动机号" />
        </el-form-item>
        <el-form-item label="回访状态" prop="c_visit_status">
          <el-select v-model="form.c_visit_status"  clearable size="small">
            <el-option
              v-for="dict in dict.type.sys_cargroup_visitType"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="回访人员" prop="c_visit_emp">
          <el-input v-model="form.c_visit_emp" placeholder="请输入回访人员" />
        </el-form-item>
        <el-form-item v-if="form.c_visit_status == '4'" label="未回访成功原因" prop="c_is_notsuccess">
          <el-select  v-model="form.c_is_notsuccess"  clearable size="small">
            <el-option
              v-for="dict in dict.type.sys_cargroup_isnotsuccess"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="客户类型" prop="c_cus_typ">
          <el-select v-model="form.c_cus_typ"  clearable size="small">
            <el-option
              v-for="dict in dict.type.sys_cargroup_custTpyList"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item v-if="form.c_cus_typ != '2'" label="客户描述" prop="c_cus_typDesc">
          <el-input type="textarea" style="width: 500px" v-model="form.c_cus_typDesc" show-word-limit maxlength ='500' placeholder="请输入客户描述" />
        </el-form-item>

        <el-row>
          <el-form-item label="企微客户">
            <el-radio v-model="form.c_is_wxfriend" label="N">否</el-radio>
            <el-radio v-model="form.c_is_wxfriend" label="Y">是</el-radio>
          </el-form-item>
          <el-form-item label="备注" prop="c_remark">
            <el-input type="textarea" style="width: 500px" v-model="form.c_remark" show-word-limit maxlength ='500' placeholder="请输入备注" />
          </el-form-item>
        </el-row>

<!--        <el-form-item label="回访时间" prop="c_visit_Tm">
          <el-date-picker
            v-model="form.c_visit_Tm"
            type="date" placeholder="选择日期"
            value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-form-item>-->
      </el-form>
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
<!--          <el-checkbox v-model="upload.updateSupport" />是否更新已经存在的用户数据-->
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
  import {getBaseCustomersList,updateCustomers,showVisitList,saveCustomers,getCustomers,deleteCustomers,updateVisit,getSpCust} from "../../api/cargroup/cargroup";
  import {addDateRange} from "../../utils/ruoyi";
  import Cargroup_priceForm from '@/views/cargroup/priceForm'
  import { save,price } from '@/api/cargroup/price'
  import moment from 'moment'
  import Dept from '@/constant/dept'
  import { authRole } from '@/plugins/auth'

  export default {
    name: "Cargroup",
    components: { Cargroup_priceForm,moment },
    dicts: ['sys_cargroup_visitType','sys_yes_no','sys_cargroup_isnotsuccess','sys_cargroup_custTpyList'],
    data() {
      return {
        isShowPrice: false,
        dep: Dept,
        flagList:[
          {label:'是',value:'Y'},
          {label:'否',value:'N'},
          {label:'空白',value:'NONE'},
        ],
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
          url: process.env.VUE_APP_BASE_API + "/cargroup/customers/updateVisitInfoByExport"
        },
        //起保日期
        bgnDateRange:[],
        //创建日期
        crtDateRange:[],
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
        // 员工信息
        customersList: [],
        visitList: [],
        // 弹出层标题
        title: "",
        visitFlag: false,
        visittitle: "",
        // 是否显示弹出层
        open: false,
        visitopen: false,
        // 是否显示弹出层（数据权限）
        openDataPopup: false,

        // 表单参数
        form: {},
        price:{
          title:'',
          open: false,
          form:{},
        },
        // 表单校验
        rules: {
          c_sp_cust_id:{ required: true, message: "重点客户表示编码不能为空", trigger: "blur" },
          c_nme:{ required: true, message: "姓名不能为空", trigger: "blur" },
          c_mobile:{ required: true, message: "手机号不能为空", trigger: "blur" },
          c_reg_owner:{ required: true, message: "行驶证车主不能为空", trigger: "blur" },
          t_insrnc_bgn_tm:{ required: true, message: "保险起期不能为空", trigger: "blur" },
        },

        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          c_sp_cust_nme: undefined,
          c_nme: undefined,
          c_reg_owner: undefined,
          c_plate_no: undefined,
          c_frm_no: undefined,
          c_eng_no: undefined,
          c_price_status: undefined,
          c_start_date: undefined,
          c_end_date: undefined,
          c_visit_statusList: undefined,
          c_person_dept: undefined,
          c_person_name: undefined,
          c_person_flag: undefined,
          c_visitOrPrice: undefined,
        },
      };
    },
    created() {

      for(let item of this.dep){
        if(item.local == this.$store.state.user.loginUser.deptId){
          this.queryParams.c_dept_cde = item.pcis;
        }
      }
      this.queryParams.c_person_flag = '总公司';
      this.getList();

      if( authRole("cargroup_showPrice")){
        this.isShowPrice = true;
      }else{
        this.isShowPrice = false;
      }
    },
    methods: {
      confirmDialog(){
        this.$confirm(
          '是否确认关闭此窗口?', "警告", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning"
          }
        ).then(
          this.cancelPrice
        ).catch(()=>{
          console.log("aaaa")
        });
      },
      querySearchAsync(queryString, cb) {
          getSpCust(queryString).then(res =>{
            console.log(res);
              cb(res.data);
          });
      },
      handleSelect(item){
        this.form.c_sp_cust_id = item.name;
        this.form.c_sp_cust_nme = item.value;
      },
      transTime(row){
        return moment(row.t_insrnc_bgn_tm).format("MM月DD日");
      },
      difTime(row){

        let m1 = moment(row.t_insrnc_bgn_tm).format("MM-DD");
        let m2 = moment(new Date()).format("MM-DD");
        return moment(m1).diff(moment(m2),'days');
      },

      cancelPrice(){
        this.price.open = false;
        this.resetPrice();
      },
      resetPrice() {
        this.price.form = {
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
          c_is_notsuccess: undefined,
          c_remark: undefined,

        };
        this.resetForm("priceForm");
      },
      submitPriceForm(){
        save(this.price.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.price.open = false;
          this.getList();
        })
      },
      handlePrice(row){
        price(row).then(res =>{
          this.price.form = res.data;
          this.price.open=true;
          let date = new Date();
          let month = date.getMonth()+1;
          let day = date.getFullYear()+"-"+month+"-"+date.getDate();
          if(!this.price.form.price_date){
            this.price.form.price_date = day;
          }
          //初始化 出单员
          if(!this.price.form.make_name){
            this.price.form.make_name = this.$store.state.user.loginUser.nickName;
          }
          //this.price.form.customer_id = row.c_pk_id;
        });

      },
      showVisitList(c_id){
        this.visitList = [];
        showVisitList(c_id).then(res=>{
          this.visitopen = true;
          this.visittitle="回访详情";
          this.visitList = res;
        })
      },
      handleEditItem(scope){
        scope.row.edit= !scope.row.edit;
      },
      //删除列
      handleDeleteItem(row,index){
        row.edit = ! row.edit;
        this.getList();
      },
      handleVisitUpdate(row) {
        updateVisit(row).then(response => {
          if (response.code === 200) {
            this.$modal.msgSuccess("修改成功");
            this.getList();
          } else {
            this.$modal.msgError(response.msg);
          }
        });
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      /** 查询已输入假日列表 */
      getList() {
        this.loading = true;
        addDateRange(this.queryParams,this.bgnDateRange,'insrnac');
        addDateRange(this.queryParams,this.crtDateRange,'create');
        getBaseCustomersList(this.queryParams).then(
          response => {

            this.customersList = response.rows;
            this.total = response.total;
            this.loading = false;
          }
        );
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.bgnDateRange=[];
        this.crtDateRange=[];
        this.queryParams.c_start_date = undefined;
        this.queryParams.c_end_date = undefined;
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.c_pk_id)
        this.single = selection.length!=1
        this.multiple = !selection.length
      },
      reset() {
        this.form = {
          c_pk_id: null,
          c_sp_cust_id: null,
          c_sp_cust_nme: null,
          c_nme: null,
          c_mobile: null,
          c_reg_owner: null,
          c_plate_no: null,
          c_fst_reg_ym: null,
          c_model_nme: null,
          c_travel_mile: null,
          t_insrnc_bgn_tm: null,
          c_frm_no: null,
          c_eng_no: null,
          t_create_date: null,
          c_visit_status: null,
          c_visit_emp: null,
          c_visit_Tm: null,
          c_price_status: null,
          c_cus_typ: null,
          c_is_wxfriend: null,
          c_cus_typDesc: null,
        };
        this.resetForm("form");
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.form.c_cus_typ = '2';
        this.form.c_is_wxfriend = 'N';
        this.open = true;
        this.title = "添加重点客户";
      },
      // 修改按钮操作
      handleUpdate(row,flag) {
        this.reset();
        const c_pk_id = row.c_pk_id || this.ids
        getCustomers(c_pk_id).then(response=>{
          if(!response.data.c_cus_typ){
            response.data.c_cus_typ = '2';
          }
          if(!response.data.c_is_wxfriend){
            response.data.c_is_wxfriend = 'N';
          }
          this.form = response.data;

          if(!this.form.c_visit_emp){
            this.form.c_visit_emp = this.$store.state.user.loginUser.nickName;
          }
          /*if(typeof(this.form.c_cus_typ) == 'undefined'){
            this.form.c_cus_typ = '2';
          }*/
          this.visitFlag = flag;
          this.open = true;
          this.title = "修改重点客户信息";
        })
      },
      /** 提交按钮 */
      submitForm: function() {
        this.$refs["form"].validate(valid => {
          if (valid) {

            if(this.form.c_frm_no == null && this.form.c_plate_no == null){
              this.$alert("车架号、车牌号不能同时为空");
              return;
            }
            if (this.form.c_pk_id != null) {
              if(!this.form.c_visit_status){
                this.$alert("请选择回访状态");
                return;
              }
              updateCustomers(this.form).then(response => {
                if (response.code === 200) {
                  this.$modal.msgSuccess("修改成功");
                  this.open = false;
                  this.getList();
                } else {
                  this.$modal.msgError(response.msg);
                }
              });
            } else {
              saveCustomers(this.form).then(response => {
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
        const pkIds = row.c_pk_id || this.ids;
        this.$confirm('是否确认删除员工信息?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return deleteCustomers(pkIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(function() {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('cargroup/customers/exportCustomers', {
          ...this.queryParams
        }, `重点客户信息导出_${new Date().getTime()}.xlsx`)
      },
      /** 导入按钮操作 */
      handleImport() {
        this.upload.title = "更新回访状态";
        this.upload.open = true;

      },
      /** 下载模板操作 */
      importTemplate() {
        this.download('cargroup/customers/importTemplate', {
          ...this.queryParams
        }, `回访状态模板_${new Date().getTime()}.xlsx`)
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
