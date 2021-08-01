package com.demo.testng;

import org.testng.annotations.Test;

/**
 * Created by win7 on 2021/8/1.
 */
public class Depentd {

    @Test
    public void test1(){
        System.out.println("测试执行1");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.printf("测试执行2");
    }
}
