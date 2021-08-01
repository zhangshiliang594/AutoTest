package com.demo.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by win7 on 2021/8/1.
 */
public class ParamterTest {

    @Test
    @Parameters({"name","age"})
    public void test1(String name, String age){
        System.out.printf("name =" + name + ";" + "age =" + age);
    }
}
