<template>
  <div class="app-container">
    <div>
      <el-form :model="formZentao" :inline="true">
        <el-form-item label="产品名称">
          <el-select v-model="formZentao.productId" filterable placeholder="请选择">
            <el-option v-for='item in productList' :key='item.id' :label="item.name" :value="item.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="数据处理开始日期">
          <el-date-picker v-model="formZentao.startDate" type="date" placeholder="选择日期"
                          value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
        <el-form-item label="默认上线时间">
          <el-date-picker v-model="formZentao.onlineDate" type="date" placeholder="选择日期"
                          value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" size="small" icon="el-icon-search" :loading="searchLoading" @click="findDemandList()">查询
          </el-button>
          <el-button type="success" size="small" icon="el-icon-download" @click="exportDemand('old')">导出需求</el-button>
          <el-button type="primary" size="small" icon="el-icon-download" @click="exportDemand('new')">导出需求(新)</el-button>
          <el-button type="warning" size="small" icon="el-icon-download" @click="exportWeekly()">导出周报</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div>
      <el-table :data="list" style="width: 100%" stripe border highlight-current-row height="400">
        <el-table-column label="需求" prop="zid" min-width="80px"/>
        <el-table-column label="产品名称" prop="zpname" width="150px"/>
        <el-table-column label="需求优先级" prop="zpri" width="70px"/>
        <el-table-column label="需求名称" prop="ztitle" width="300px" fixed/>
        <el-table-column label="所属模块" prop="mname" width="80px"/>
        <el-table-column label="需求来源" prop="zsource" width="80px"/>
        <el-table-column label="需求创建" prop="urealname" width="80px"/>
        <el-table-column label="需求指派" prop="u2realname" width="80px"/>
        <el-table-column label="需求阶段" prop="zstage" width="80px"/>
        <el-table-column label="创建时间" prop="zopeneddate" width="100px"/>
        <el-table-column label="预计上线时间" prop="proonlinedate" width="120px"/>
        <el-table-column label="开发开始时间" prop="taskrealst" width="120px"/>
        <el-table-column label="开发完成时间" prop="taskrealed" width="120px"/>
        <el-table-column label="需求验收时间" prop="checkdate" width="120px"/>
        <el-table-column label="需求上线时间" prop="onlinedate" width="120px"/>
        <el-table-column label="备注" prop="remarks" min-width="150px"/>
        <el-table-column width="80px" label="操作" fixed>
          <template slot-scope="scope">
            <el-button type="primary" icon="el-icon-edit" @click.native.prevent="editData(scope.row.zid)"
                       circle></el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog title="需求处理" :visible.sync="dialogFormVisible">
      <el-form :model="demand" style="text-align: center">
        <el-row>
          <el-col>
            <el-form-item label="需求名称" :label-width="formLabelWidth">
              <el-input v-model="demand.ztitle"></el-input>
            </el-form-item>
            <div style="padding-bottom: 20px">
              <span>{{zentaoDemand.ztitle}}</span>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="所属模块" :label-width="formLabelWidth">
              <el-select v-model="demand.mname">
                <el-option label="功能新增" value="功能新增"></el-option>
                <el-option label="功能改造" value="功能改造"></el-option>
                <el-option label="数据提取" value="数据提取"></el-option>
                <el-option label="数据更新" value="数据更新"></el-option>
              </el-select>
            </el-form-item>
            <div style="padding-bottom: 20px">
              <span>{{zentaoDemand.mname}}</span>
            </div>
          </el-col>
          <el-col :span="12">
            <el-form-item label="需求来源需求来源" :label-width="formLabelWidth">
              <el-select v-model="demand.zsource">
                <el-option label="业务要求" value="业务要求"></el-option>
                <el-option label="监管要求" value="监管要求"></el-option>
                <el-option label="第三方对接" value="第三方对接"></el-option>
              </el-select>
            </el-form-item>
            <div style="padding-bottom: 20px">
              <span>{{zentaoDemand.zsource}}</span>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="预计上线时间" :label-width="formLabelWidth">
              <el-date-picker v-model="demand.proonlinedate" type="date" placeholder="选择日期"
                              value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
          </el-col>
          <div style="padding-bottom: 20px">
            <span>{{zentaoDemand.proonlinedate}}</span>
          </div>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="开发开始时间" :label-width="formLabelWidth">
              <el-date-picker v-model="demand.taskrealst" type="date" placeholder="选择日期"
                              value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
            <div style="padding-bottom: 20px">
              <span>{{zentaoDemand.taskrealst}}</span>
            </div>
          </el-col>
          <el-col :span="12">
            <el-form-item label="开发完成时间" :label-width="formLabelWidth">
              <el-date-picker v-model="demand.taskrealed" type="date" placeholder="选择日期"
                              value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
            <div style="padding-bottom: 20px">
              <span>{{zentaoDemand.taskrealed}}</span>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="需求验收时间" :label-width="formLabelWidth">
              <el-date-picker v-model="demand.checkdate" type="date" placeholder="选择日期"
                              value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
            <div style="padding-bottom: 20px">
              <span>{{zentaoDemand.checkdate}}</span>
            </div>
          </el-col>
          <el-col :span="12">
            <el-form-item label="需求上线时间" :label-width="formLabelWidth">
              <el-date-picker v-model="demand.onlinedate" type="date" placeholder="选择日期"
                              value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
            <div style="padding-bottom: 20px">
              <span>{{zentaoDemand.onlinedate}}</span>
            </div>
          </el-col>
        </el-row>
        <el-row>
          <el-col>
            <el-form-item label="备注" :label-width="formLabelWidth">
              <el-input v-model="demand.remarks"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="saveData()">确 定</el-button>
        <el-button @click="dialogFormVisible = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import moment from 'moment'

  import {findDemandById, findDemandList, getProductList, saveDemand} from "@/api/zentao/zentao";

  export default {
    name:'zentao',
    data() {
      return {
        t_today:'',
        formZentao: {
          productId: '',
          startDate: '',
          onlineDate: ''
        },
        productList: [],
        list: [],
        searchLoading: false,
        dialogFormVisible: false,
        demand: {
          zid: '',
          ztitle: '',
          mname: '',
          zsource: '',
          proonlinedate: '',
          taskrealst: '',
          taskrealed: '',
          checkdate: '',
          onlinedate: '',
          remarks: '',
        },
        zentaoDemand: {
          zid: '',
          ztitle: '',
          mname: '',
          zsource: '',
          proonlinedate: '',
          taskrealst: '',
          taskrealed: '',
          checkdate: '',
          onlinedate: '',
          remarks: '',
        },
        formLabelWidth: '140px'
      }
    },
    methods: {
      initDate() {
        let nowDate = new Date();
        let dayWrapper = moment(nowDate);
        dayWrapper.startOf('day');
        this.t_today = dayWrapper.format("YYYY-MM-DD");
        dayWrapper.subtract(7, "day");
        this.formZentao.startDate = dayWrapper.format("YYYY-MM-DD");
      },
      editData(data) {
        findDemandById({zid: data}).then(res =>{
          this.demand = res.demandDTO;
          this.zentaoDemand =  res.demandDO;
          this.demand.zid = this.zentaoDemand.zid;
          this.dialogFormVisible = true;
        });
        /*this.$axios.get('/zentao/demand/findDemandById', {
            params: {zid: data},
          }
        ).then((res) => {
          this.demand = res.data.demandDTO;
          this.zentaoDemand =  res.data.demandDO;
          this.demand.zid = this.zentaoDemand.zid;
          this.dialogFormVisible = true;
        }).catch((error) => {
          console.log("~~~" + error.response.data.data);
          alert("查询失败！");
          this.dialogFormVisible = false;
        });*/
      },
      saveData() {
        this.saveDemand();
      },
      getProduct: function () {
        getProductList().then(res =>{
          this.productList = res;
          this.formZentao.productId = 1;
        });
      },
      findDemandList: function () {

        this.searchLoading = true;
        findDemandList(this.formZentao).then(data =>{
          this.list = data;
          console.log("list"+data);
          this.searchLoading = false;
        }).catch((error) =>{
          this.$message({ message: '查询失败', type: 'error' });
          this.searchLoading = false;
        })
      },
      saveDemand: function () {
        saveDemand(this.demand).then(res =>{
          this.$message({message:'保存成功！',type:'success'})
          this.dialogFormVisible = false;
          this.findDemandList();
        }).catch((error) =>{
          this.dialogFormVisible = false;
          this.$message({message:'保存失败！',type:'error'})
          console.log("demand error"+error);
        })
        /*this.$axios.post('/pomtoolmysql/demand/save', this.demand
        ).then((res) => {
          alert("保存成功！");
          this.dialogFormVisible = false;
          this.findDemandList();
        }).catch((error) => {
          alert("处理失败！");
          console.log("~~~" + error.response.data.data);
        });*/
      },
      exportDemand: function (type) {
        let fileName = ``;
        if(this.formZentao.productId == '1'){
          fileName = `车险需求跟进表${this.t_today}.xls`
        }else{
          fileName = `需求跟进表${this.t_today}.xls`
        }
        this.download('/zentao/demand/exportDemand?productId='+this.formZentao.productId
          +'&startDate='+this.formZentao.startDate+'&onlineDate='+this.formZentao.onlineDate+'&type='+type
          , {}, fileName);
       /* this.$axios.get('/zentao/demand/exportDemand',
          {
            params: {
              productId: this.formZentao.productId,
              startDate: this.formZentao.startDate,
              onlineDate: this.formZentao.onlineDate,
              type: type
            },
            responseType: 'blob'
          })
          .then((res) => {
            const url = window.URL.createObjectURL(new Blob([res.data]));
            const link = document.createElement('a');
            link.href = url;
            let fileName = res.headers['content-disposition'].split('filename=');
            link.setAttribute('download', decodeURIComponent(fileName[1]));
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
            // 释放掉blob对象
            window.URL.revokeObjectURL(url);
          })
          .catch((error) => {
            console.log("~~~" + error.response.data.data);
            var reader = new FileReader();
            reader.readAsText(error.response.data, 'utf-8');
            console.info(reader.result);
          });*/
      },
      exportWeekly: function () {
        this.download('/zentao/demand/exportWeekly?productId='+this.formZentao.productId
          +'&startDate='+this.formZentao.startDate+'&onlineDate='+this.formZentao.onlineDate
          , {}, `周报统计材料${this.t_today}.xls`);
        /*this.$axios.get('/zentao/demand/exportWeekly',
          {
            params: {
              productId: this.formZentao.productId,
              startDate: this.formZentao.startDate,
              onlineDate: this.formZentao.onlineDate
            },
            responseType: 'blob'
          })
          .then((res) => {
            const url = window.URL.createObjectURL(new Blob([res.data]));
            const link = document.createElement('a');
            link.href = url;
            let fileName = res.headers['content-disposition'].split('filename=');
            link.setAttribute('download', decodeURIComponent(fileName[1]));
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
            // 释放掉blob对象
            window.URL.revokeObjectURL(url);
          })
          .catch((error) => {
            console.log("~~~" + error.response.data.data);
            var reader = new FileReader();
            reader.readAsText(error.response.data, 'utf-8');
            console.info(reader.result);
          });*/
      },
    },
    created() {
      this.initDate();
      this.getProduct();
    }
  }
</script>
