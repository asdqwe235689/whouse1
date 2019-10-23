package com.stx.cyber.controller;
import com.stx.cyber.domain.ResultInfo;
import com.stx.cyber.domain.User;
import com.stx.cyber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登陆
     * @param
     * @return
     */
    @RequestMapping(value = "/login",produces = "application/json;charset=UTF-8")
    public  @ResponseBody ResultInfo login( @RequestBody User user){
        System.out.println(user);
        boolean flag = userService.login(user);
        System.out.println(flag);
        ResultInfo info=new ResultInfo();
        info.setFlag(flag);
        return info;
    }

    /**
     * 用户注册
     * @return
     */
    @RequestMapping(value = "/register",produces = "application/json;charset=utf-8")
    public  @ResponseBody ResultInfo register(@RequestBody User user){
        System.out.println(user);
        ResultInfo info=new ResultInfo();
        //校验用户名是否存在
        boolean flag= userService.findUserById();
        if (!flag){
            //不存在，存入用户信息
            userService.register(user);
            info.setFlag(true);
        }else {
            //存在 注册失败
            info.setFlag(false);
        }
        return info;
    }

//    /**
//     * 测试代码
//     * @param user
//     * @return
//     */
//    @RequestMapping("/testLogin")
//    public ModelAndView testLogin( User user){
//        ModelAndView mv=new ModelAndView();
//        System.out.println(user);
//        boolean flag = userService.login(user);
//        mv.setViewName("success");
//        mv.addObject("msg","这是一个测试方法。");
//        return mv;
//
//    }
}
