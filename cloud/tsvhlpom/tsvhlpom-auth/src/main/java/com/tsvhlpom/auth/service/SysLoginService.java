package com.tsvhlpom.auth.service;

import com.alibaba.fastjson.JSONObject;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.system.api.UserCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tsvhlpom.common.core.constant.Constants;
import com.tsvhlpom.common.core.constant.SecurityConstants;
import com.tsvhlpom.common.core.constant.UserConstants;
import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.enums.UserStatus;
import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.ServletUtils;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.common.core.utils.ip.IpUtils;
import com.tsvhlpom.common.security.utils.SecurityUtils;
import com.tsvhlpom.system.api.RemoteLogService;
import com.tsvhlpom.system.api.RemoteUserService;
import com.tsvhlpom.system.api.domain.SysLogininfor;
import com.tsvhlpom.system.api.domain.SysUser;
import com.tsvhlpom.system.api.model.LoginUser;

/**
 * 登录校验方法
 *
 * @author taishanpic
 */
@Component
public class SysLoginService
{
    @Autowired
    private RemoteLogService remoteLogService;

    @Autowired
    private RemoteUserService remoteUserService;

    @Autowired
    private UserCheckService userCheckService;

    /**
     * 登录
     */
    public LoginUser login(String username, String password)
    {
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(username, password))
        {
            recordLogininfor(username, Constants.LOGIN_FAIL, "用户/密码必须填写");
            throw new ServiceException("用户/密码必须填写");
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            recordLogininfor(username, Constants.LOGIN_FAIL, "用户密码不在指定范围");
            throw new ServiceException("用户密码不在指定范围");
        }
        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            recordLogininfor(username, Constants.LOGIN_FAIL, "用户名不在指定范围");
            throw new ServiceException("用户名不在指定范围");
        }
        // 查询用户信息
        R<LoginUser> userResult = remoteUserService.getUserInfo(username, SecurityConstants.INNER);

        if (R.FAIL == userResult.getCode())
        {
            throw new ServiceException(userResult.getMsg());
        }

        if (StringUtils.isNull(userResult) || StringUtils.isNull(userResult.getData()))
        {
            recordLogininfor(username, Constants.LOGIN_FAIL, "登录用户不存在");
            throw new ServiceException("登录用户：" + username + " 不存在");
        }
        LoginUser userInfo = userResult.getData();
        SysUser user = userResult.getData().getSysUser();
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag()))
        {
            recordLogininfor(username, Constants.LOGIN_FAIL, "对不起，您的账号已被删除");
            throw new ServiceException("对不起，您的账号：" + username + " 已被删除");
        }
        if (UserStatus.DISABLE.getCode().equals(user.getStatus()))
        {
            recordLogininfor(username, Constants.LOGIN_FAIL, "用户已停用，请联系管理员");
            throw new ServiceException("对不起，您的账号：" + username + " 已停用");
        }
        if (!SecurityUtils.matchesPassword(password, user.getPassword()))
        {
            recordLogininfor(username, Constants.LOGIN_FAIL, "用户密码错误");
            throw new ServiceException("用户不存在/密码错误");
        }
        //添加强密码校验 start
        JSONObject userJson = new JSONObject();
        userJson.put("sys_name","tsvhlpom");
        userJson.put("user_name",username);
        userJson.put("password",password);
        AjaxResult flagAjax = userCheckService.userCheck(userJson.toString());
        String flag = flagAjax.get("data").toString();
        if("isWeak".equals(flag)){
            recordLogininfor(username, Constants.LOGIN_FAIL, "弱密码");
        } else if("needUpdate".equals(flag)){
            recordLogininfor(username, Constants.LOGIN_SUCCESS, "密码过期");
        }else {
            recordLogininfor(username, Constants.LOGIN_SUCCESS, "登录成功");
        }
        //添加强密码校验 end
        userInfo.setFlag(flag);
        return userInfo;
    }

    public void logout(String loginName)
    {
        recordLogininfor(loginName, Constants.LOGOUT, "退出成功");
    }

    /**
     * 注册
     */
    public void register(String username, String password)
    {
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(username, password))
        {
            throw new ServiceException("用户/密码必须填写");
        }
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            throw new ServiceException("账户长度必须在2到20个字符之间");
        }
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            throw new ServiceException("密码长度必须在5到20个字符之间");
        }

        // 注册用户信息
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        sysUser.setNickName(username);
        sysUser.setPassword(SecurityUtils.encryptPassword(password));
        R<?> registerResult = remoteUserService.registerUserInfo(sysUser, SecurityConstants.INNER);

        if (R.FAIL == registerResult.getCode())
        {
            throw new ServiceException(registerResult.getMsg());
        }
        recordLogininfor(username, Constants.REGISTER, "注册成功");
    }

    /**
     * 记录登录信息
     *
     * @param username 用户名
     * @param status 状态
     * @param message 消息内容
     * @return
     */
    public void recordLogininfor(String username, String status, String message)
    {
        SysLogininfor logininfor = new SysLogininfor();
        logininfor.setUserName(username);
        logininfor.setIpaddr(IpUtils.getIpAddr(ServletUtils.getRequest()));
        logininfor.setMsg(message);
        // 日志状态
        if (StringUtils.equalsAny(status, Constants.LOGIN_SUCCESS, Constants.LOGOUT, Constants.REGISTER))
        {
            logininfor.setStatus("0");
        }
        else if (Constants.LOGIN_FAIL.equals(status))
        {
            logininfor.setStatus("1");
        }
        remoteLogService.saveLogininfor(logininfor, SecurityConstants.INNER);
    }
}
