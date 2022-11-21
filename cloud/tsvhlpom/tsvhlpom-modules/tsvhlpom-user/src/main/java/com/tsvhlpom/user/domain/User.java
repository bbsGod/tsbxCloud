package com.tsvhlpom.user.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String pkid;
    private String sys_name;
    private String user_name;
    private String password;
    private Date create_time;
    private String remark;
}
