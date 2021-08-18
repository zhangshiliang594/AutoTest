package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by win7 on 2021/8/17.
 */
@Log4j
@RestController
@Api(value = "v1",description = "第一个版本")
@RequestMapping(value = "v1")
public class demo {

    //获取执行sql语句
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "新增用户",httpMethod = "POST")
    public int addUser(@RequestBody User user){

        return template.insert("addUser",user);

    }

    @RequestMapping(value = "/updataUser",method = RequestMethod.POST)
    @ApiOperation(value = "更新用户信息",httpMethod = "POST")
    public int updataUser(@RequestBody User user){
        return template.update("updataUser",user);
    }

    @RequestMapping(value = "/deleUser",method = RequestMethod.POST)
    @ApiOperation(value = "更新用户信息",httpMethod = "POST")
    public int deleUser(@RequestParam int id){
        return template.delete("deleUser",id);
    }

}
