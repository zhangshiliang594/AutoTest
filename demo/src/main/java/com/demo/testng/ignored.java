package com.demo.testng;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * Created by win7 on 2021/8/1.
 */
public class ignored {

    @Test(groups = "test1")
    public void test1(){
        System.out.println("执行测试用例111");
    }

    @Test(groups = "test2")
    public void test2(){
        System.out.println("执行测试用例222");
    }

    @Test(enabled = true)
    public void test3(){
        System.out.println("执行测试用例333");
    }

    @Test(enabled = false)
    public void test4(){
        System.out.println("执行测试用例444");
    }

    @BeforeGroups(groups = "test1")
    public void test5(){
        System.out.println("执行测试用例111");
    }

    @AfterGroups(groups = "test2")
    public void test6(){
        System.out.println("执行测试用例222");
    }
}
