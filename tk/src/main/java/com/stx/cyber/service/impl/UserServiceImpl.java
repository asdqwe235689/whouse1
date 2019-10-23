package com.stx.cyber.service.impl;
import com.stx.cyber.dao.UserDao;
import com.stx.cyber.domain.User;
import com.stx.cyber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    /**
     * 校验账户和密码是否正确
     * @return
     */
    public boolean login(User user) {
        boolean flag=true;
        User users = userDao.findUser(user);
        if (users==null){
            flag=false;
        }
        return flag;
    }

    /**
     * 注册
     * @param user
     */
    public void register(User user) {
        userDao.saveUser(user);
    }

    /**
     *
     * @return
     */
    public boolean findUserById() {
        return false;
    }

}
