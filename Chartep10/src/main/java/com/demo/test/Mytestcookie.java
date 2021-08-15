package com.demo.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;


/**
 * Created by win7 on 2021/8/10.
 */
@RestController
@Api(value = "/",description = "这是全部get方法")
public class Mytestcookie {

    @RequestMapping(value = "/getcookie",method = RequestMethod.GET)
    @ApiOperation(value = "返回cookie",httpMethod = "GET")
    public String getcookie(HttpServletResponse response){
        //HttpServerletRequest装请求
        //HttpServerletResponse响应
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜返回cookie成功。。。";
    }

    @RequestMapping(value = "/get/cookie",method = RequestMethod.GET)
    @ApiOperation(value = "通过cookie访问",httpMethod = "GET")
    public String getlogincookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "必须携带cookies登录";
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "这是必须携带cookies信息才能请求接口";
            }
        }
        return "必须携带cookies登录";
    }
    /*
    * 开发一个需要参数携带才能访问的get请求
    *第一种实现方式url:key=value&key=value
    * 获取商品列表
    * */
    @RequestMapping(value = "/getmylist",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数访问get方法一",httpMethod = "GET")
    public Map<String,Integer> getlist(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> mylist = new Hashtable<String, Integer>();
        mylist.put("老王",26);
        mylist.put("翻车鱼",21);
        mylist.put("王林",18);
        return mylist;
    }

    /**
     * 第二种访问格式
     * url: ip:port/geturl/10/20
     */
    @RequestMapping(value = "/Mygetlist/{satrt}/{end}")
    @ApiOperation(value = "携带参数请求get方法二",httpMethod = "GET")
    public Map myGetlist(@PathVariable Integer satrt,
                         @PathVariable Integer end){
        Map<String,Integer> mylist = new Hashtable<String, Integer>();
        mylist.put("老王",26);
        mylist.put("翻车鱼",21);
        mylist.put("王林",18);
        return mylist;
    }
}
