package com.stx.cyber.dao;

import com.stx.cyber.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    //根据用户名和密码查找用户
    @Select("select * from tk_user where username=#{username} and password=#{password}")
    User findUser(User user);

    //像数据库中存入用户信息
    @Insert("insert into tk_user(username,password,email,name) values(#{username},#{password},#{email},#{name})")
    void saveUser(User user);
}
