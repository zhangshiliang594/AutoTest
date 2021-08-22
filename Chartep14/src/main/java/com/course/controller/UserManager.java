package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;


/**
 * Created by win7 on 2021/8/22.
 */
@Log4j2
@RestController
@Api(value = "v1",description = "用户管理系统")
@RequestMapping("v1")
public class UserManager {

    @Autowired
    private SqlSessionTemplate template;

    /**
     * 登录接口
     * @param response
     * @param user
     * @return
     */
    @ApiOperation(value = "登录接口",httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(HttpServletResponse response, @RequestBody User user){
        int i = template.selectOne("login",user);
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        log.info("查询的结果是:"+i);
        if (i==1){
            log.info("登录信息："+user.getUserName());
            return true;
        }
        return false;
    }

    /**
     * 添加用户接口
     * @param request
     * @param user
     * @return
     */
    @ApiOperation(value = "添加用户",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public boolean addUser(HttpServletRequest request, @RequestBody User user){
        Boolean cookie = verifyCookies(request);
        int result = 0;
        if (cookie != null){
            result = template.insert("addUser",user);
        }
        if (result > 0){
            log.info("添加用户数量:"+result);
            return true;
        }
        return false;
    }

    /**
     * 对比cookie
     * @param request
     * @return
     */
    private Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            log.info("cookie为空");
            return false;
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                log.info("cookie验证通过");
                return true;
            }
        }
        return false;
    }

    /**
     * 查询用户信息
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息",httpMethod = "POST")
    public List<User> getUserInfo(HttpServletRequest request, @RequestBody User user){
        Boolean cookie = verifyCookies(request);
        if (cookie == true){
            List<User> users = template.selectList("getUserInfo",user);
            log.info("获取用户数量:"+users);
            return users;
        }else {
            return null;
        }
    }

    /**
     * 更新用户
     * @param request
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户信息",httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public int updateUserInfo(HttpServletRequest request, @RequestBody User user){
        Boolean cookie = verifyCookies(request);
        int i = 0;
        if (cookie==true){
            i = template.update("updateUserInfo",user);
        }
        log.info("更新数据条目:"+i);
        return i;

    }
}
