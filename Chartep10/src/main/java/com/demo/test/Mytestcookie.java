package com.demo.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by win7 on 2021/8/10.
 */
@RestController
public class Mytestcookie {

    @RequestMapping(value = "/getcookie",method = RequestMethod.GET)
    public String getcookie(HttpServletResponse response){
        //HttpServerletRequest装请求
        //HttpServerletResponse响应
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜返回cookie成功。。。";
    }
}
