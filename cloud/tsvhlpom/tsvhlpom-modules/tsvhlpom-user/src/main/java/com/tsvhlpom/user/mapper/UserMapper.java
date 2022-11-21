package com.tsvhlpom.user.mapper;

import com.tsvhlpom.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUser(@Param("user_name") String user_name,@Param("sys_name") String sys_name);
    void update(User user);
    void save(User user);
}
