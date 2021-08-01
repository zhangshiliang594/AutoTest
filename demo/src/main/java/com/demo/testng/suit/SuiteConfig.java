package com.demo.testng.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Created by win7 on 2021/7/29.
 */
public class SuiteConfig {

    @BeforeSuite
    public void BeforeSiute(){
        System.out.println("BeforeSiute执行测试套件之前");
    }

    @AfterSuite
    public void AfterSiute(){
        System.out.println("AfterSiute执行测试套件之后");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest执行测试用例之前");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest执行测试用例之后");
    }
}
