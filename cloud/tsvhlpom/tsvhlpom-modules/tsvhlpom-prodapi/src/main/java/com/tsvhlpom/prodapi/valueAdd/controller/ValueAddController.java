package com.tsvhlpom.prodapi.valueAdd.controller;

import com.tsvhlpom.prodapi.valueAdd.mapper.ValueAddMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/valueAdd")
@Slf4j
/**
 * 增值服务获取投保确认码controller
 */
public class ValueAddController {

    @Autowired
    private ValueAddMapper valueAddMapper;
    @RequestMapping("/getAffimCode")
    public String getAffimCode(@Param("plyNo") String plyNo){
        String affirmCode = "";
        try{
            log.info("获取投保确认码：plyNo="+plyNo+"************start");
            affirmCode =  valueAddMapper.getAffimCode(plyNo);
            log.info("获取投保确认码：plyNo="+plyNo+"************end, 投保确认码："+affirmCode);
            if(affirmCode ==null || "".equals(affirmCode)){
                affirmCode = "未获取到数据";
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取投保确认码失败。。"+e.getMessage());
        }
        return  affirmCode;
    }

    public static void main(String[] args) {

    }
}
