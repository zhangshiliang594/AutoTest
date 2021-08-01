package com.demo.testng;

import org.testng.annotations.Test;

/**
 * Created by win7 on 2021/8/1.
 */
public class ExceptExsion {

    @Test(expectedExceptions = RuntimeException.class)
    public void test1(){
        System.out.println("测试异常");

    }

    @Test(expectedExceptions = RuntimeException.class)
    public void test2(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();
    }
}
