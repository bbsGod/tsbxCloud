package com.tsvhlpom.compare.controller;

import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.redis.service.RedisService;
import com.tsvhlpom.compare.utils.ComparisonResult;
import oracle.jdbc.driver.OracleDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.*;

@RequestMapping("/compare_new")
@RestController
public class CompareNewController {

    @Autowired
    private RedisService redisService;
    private final static String table = "web_app_base,web_app_applicant,web_app_insured,web_app_vhl,web_app_vhlowner,web_app_vs_tax,web_app_cvrg,web_app_cvrg_prm_coef,web_app_fee,web_app_tgt_obj,web_app_charging_post";
    private final static String table_mu = "web_app_cvrg,web_app_cvrg_prm_coef,web_app_fee,web_app_tgt_obj,web_app_charging_post";
    private final static String ingoColumn="c_app_no,t_crt_tm,t_upd_tm,c_pk_id,c_crt_cde,c_upd_cde,c_ocr_uu_id,c_orig_ply_no,t_app_tm,c_opr_cde,t_udr_tm,c_udr_dpt_cde,c_udr_cde,c_jqx_ply_no,c_cont_flg,c_ap_id,c_issue_src,c_ts_ap_id,c_joint_no";
    @RequestMapping("/compare")
    public AjaxResult compare(String appnos) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        Map<String,List<ComparisonResult>> returnMap = new HashMap<>();
        try{
            //获取单号
            String[] appNoList = appnos.split(",");
            String appNoParam = "";
            for(String appNo:appNoList){
                appNoParam += "'"+ appNo + "',";
            }
            appNoParam = appNoParam.substring(0,appNoParam.length()-1);
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//10.1.3.29:1521/oradb","pcisv6_tsky","pcisv6_tsky_11");
            statement = connection.createStatement();
            //tablelist
            List<String> tableList = Arrays.asList(table.split(","));

            for(String tableName:tableList){
                //获取列名称
                List<Object> column = null;
                if(redisService.getCacheList("column:"+tableName).size() >0){
                    column = redisService.getCacheList("column:"+tableName);
                }else{
                    column  = this.selectDbTableColumnsByName(statement,tableName);
                    redisService.setCacheList("column:"+tableName,column);
                }

                //获取数据库数据
                String sql = "select * from "+tableName+" a where a.c_app_no in("+appNoParam+")";
                ResultSet rs =  statement.executeQuery(sql);
                Map<String,Map> compareMap = new HashMap<>();

                String key = "";
                while (rs.next()){
                    Map<String,Object> rsMap = new HashMap<>();
                    String appNo = rs.getObject("c_app_no").toString();
                    if("web_app_cvrg".equals(tableName) || "web_app_cvrg_prm_coef".equals(tableName)){
                        key = rs.getObject("c_cvrg_no").toString();
                    }else if("web_app_fee".equals(tableName)){
                        key = rs.getObject("c_feetyp_cde").toString();
                    } else if("web_app_tgt_obj".equals(tableName)){
                        key = rs.getObject("c_tgt_obj_txt_fld_1").toString();
                    }
                    for(Object object:column){
                        if(ingoColumn.indexOf(object.toString())< 0){
                            rsMap.put(object.toString(),rs.getObject(object.toString()));
                        }
                    }
                    if(table_mu.indexOf(tableName)> -1){
                        Map<String,Map> subMap = new HashMap<>();
                        subMap.put(key,rsMap);
                        if(compareMap.containsKey(appNo)){
                            compareMap.get(appNo).putAll(subMap);
                        }else{
                            compareMap.put(appNo,subMap);
                        }

                        //compareMap.put(appNo,subMap);
                    }else {
                        compareMap.put(appNo,rsMap);
                    }

                }
                List<ComparisonResult> rsList = new ArrayList<>();
                //比对数据
                if(table_mu.indexOf(tableName)> -1){
                    Map<String,Map> firstMap = compareMap.get(appNoList[0]);
                    Map<String,Map> nextMap = compareMap.get(appNoList[1]);
                    if(firstMap !=null && nextMap!=null){
                        for(Object mapkey:firstMap.keySet().size()>nextMap.keySet().size()?firstMap.keySet():nextMap.keySet()){
                            System.out.println("tableName:"+tableName+mapkey);
                            if(!firstMap.containsKey(mapkey)){
                                throw new Exception("表"+tableName+","+appNoList[0]+"缺少"+mapkey);
                            }
                            if(!nextMap.containsKey(mapkey)){
                                throw new Exception("表"+tableName+","+appNoList[1]+"缺少"+mapkey);
                            }
                            this.doCompare(firstMap.get(mapkey),nextMap.get(mapkey),column,rsList,tableName,returnMap);
                        }
                    }else if((firstMap ==null && nextMap !=null) || (firstMap !=null && nextMap ==null)){
                        throw new Exception("表"+tableName+"缺少数据");
                    }

                }else{
                    Map firstMap = compareMap.get(appNoList[0]);
                    Map nextMap = compareMap.get(appNoList[1]);
                    this.doCompare(firstMap,nextMap,column,rsList,tableName,returnMap);
                }


            }


        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }finally {
            if(statement !=null){
                statement.close();
            }
            if(connection !=null){
                connection.close();
            }
        }
        return AjaxResult.success(returnMap);
    }
    public void doCompare(Map firstMap,Map nextMap,List<Object> column,List<ComparisonResult> rsList,String tableName,Map<String,List<ComparisonResult>> returnMap){
        if(firstMap ==null && nextMap ==null){
            return;
        }
        for(Object object:column){
            ComparisonResult result = new ComparisonResult();
            result.setKey(object.toString());
            if(Objects.nonNull(firstMap.get(object.toString()))
                    &&Objects.isNull(nextMap.get(object.toString()))){
                result.setPrevious(firstMap.get(object.toString()).toString());
                result.setLater(null);
                rsList.add(result);
            } else if(Objects.nonNull(nextMap.get(object.toString()))
                    &&Objects.isNull(firstMap.get(object.toString()))){
                result.setPrevious(null);
                result.setLater(nextMap.get(object.toString()).toString());
                rsList.add(result);
            } else if(Objects.nonNull(nextMap.get(object.toString()))
                    &&Objects.nonNull(firstMap.get(object.toString()))){
                if(!firstMap.get(object.toString()).equals(nextMap.get(object.toString()))){
                    result.setPrevious(firstMap.get(object.toString()).toString());
                    result.setLater(nextMap.get(object.toString()).toString());
                    rsList.add(result);
                }
            }

        }
        returnMap.put(tableName,rsList);
    }
    public List<Object> selectDbTableColumnsByName(Statement statement,String tableName) throws SQLException {
        String sql = "select lower(temp.column_name) as column_name,\n" +
                "                (case when (temp.nullable = 'N'  and  temp.constraint_type != 'P') then '1' else null end) as is_required,\n" +
                "                (case when temp.constraint_type = 'P' then '1' else '0' end) as is_pk,\n" +
                "                temp.column_id as sort,\n" +
                "                temp.comments as column_comment,\n" +
                "                (case when temp.constraint_type = 'P' then '1' else '0' end) as is_increment,\n" +
                "                lower(temp.data_type) as column_type\n" +
                "           from (\n" +
                "                  select col.column_id, col.column_name,col.nullable, col.data_type, colc.comments, uc.constraint_type\n" +
                "                       , row_number() over (partition by col.column_name order by uc.constraint_type desc) as row_flg\n" +
                "                  from user_tab_columns col\n" +
                "                  left join user_col_comments colc on colc.table_name = col.table_name and colc.column_name = col.column_name\n" +
                "                  left join user_cons_columns ucc on ucc.table_name = col.table_name and ucc.column_name = col.column_name\n" +
                "                  left join user_constraints uc on uc.constraint_name = ucc.constraint_name\n" +
                "                 where col.table_name = upper('"+tableName+"')\n" +
                "                  ) temp\n" +
                "           WHERE temp.row_flg = 1\n" +
                "          ORDER BY temp.column_id";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Object> column = new ArrayList<>();
        if(resultSet !=null){
            while (resultSet.next()){
                column.add(resultSet.getObject("column_name"));
            }
        }
        return column;
    }

    public static void main(String[] args) throws SQLException {
        String a = "c_app_no,t_crt_tm,t_upd_tm,c_pk_id";
        System.out.println("t_crt_tm".indexOf(a));
        System.out.println(a.indexOf("t_crt_tm"));
    }
}
