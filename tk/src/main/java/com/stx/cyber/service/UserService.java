package com.stx.cyber.service;

import com.stx.cyber.domain.User;

public interface UserService {

    //登陆认证
    boolean login(User user);

    //注册
    void register(User user);

    //根据id查询用户是否存在
    boolean findUserById();
}
