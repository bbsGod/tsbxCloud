package com.tsvhlpom.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.tsvhlpom.common.core.utils.IdUtils;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.user.constants.FlagConstants;
import com.tsvhlpom.user.domain.User;
import com.tsvhlpom.user.mapper.UserMapper;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/userCheck")
@Slf4j
public class UserController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    private final String reg = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$";
    @RequestMapping("/checkUser")
    public AjaxResult checkUser(@RequestBody String userStr){
        log.info("系统校验开始，进来了。。。。");
        try{
            User user = JSONObject.parseObject(userStr,User.class);
            logger.info("系统："+user.getSys_name()+",用户："+user.getUser_name()+"开始请求校验。。。。");
            if("admin".equals(user.getUser_name())){
                return AjaxResult.success("操作成功",FlagConstants.PASS);
            }
            // 校验 是否为强密码
            if(checkPasswordIsStrong(user.getPassword())){
                log.info("是强密码。。。");
                //校验是否已超过90天
                User user_old = userMapper.getUser(user.getUser_name(),user.getSys_name());
                if(user_old ==null){
                    //是强密码，并且库里面没有值，说明是由弱密码修改来的，新增一条记录
                    user.setPkid(IdUtils.fastSimpleUUID());
                    user.setCreate_time(new Date());
                    userMapper.save(user);
                }else{
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(user_old.getCreate_time());
                    cal.add(Calendar.DAY_OF_MONTH,90);
                    Date expirationDate = cal.getTime();
                    //如果库里有数据
                    if(user_old.getPassword().equals(user.getPassword())){
                        //如果旧密码与 密码相同,,如果库里面记录的 创建时间 加上90天 ，在当前日期之前，过期,提示修改
                        if(expirationDate.before(new Date())) {
                           return AjaxResult.success("操作成功",FlagConstants.NEEDUPDATE);
                        }

                    }else {// 如果密码与旧密码不一致，说明为 修改密码，同时更新时间
                        log.info("数据库没有数据，新增记录时间。。");
                        user_old.setPassword(user.getPassword());
                        user_old.setCreate_time(new Date());
                        userMapper.update(user_old);
                    }

                }
            } else {
                log.info("是弱密码。。。。");
                return   AjaxResult.success("操作成功",FlagConstants.ISWEAK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.success("操作成功",FlagConstants.PASS);
    }

    public static boolean checkPasswordIsStrong(String password) {
        if (password == null ||  password.length()<8) {
            return false;
        }
        if (password.matches(".*[a-z]{1,}.*") && password.matches(".*[A-Z]{1,}.*") && password.matches(".*\\d{1,}.*")
                && password.matches(".*[~!@#$%^&*\\.?]{1,}.*")) {
            return true;
        }
        return false;
    }
}
