package com.demo.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by win7 on 2021/8/1.
 */
public class Dataprovider {

    @DataProvider(name = "testData")
    public Object[][] testdata(){
        Object[][] obj = {
                {"zhangshan", 20},
                {"lisi", 23}
        };
        return obj;
    }

    @Test(dataProvider = "testData")
    public void test1(String name, Integer age){
        System.out.println("name="+ name + ";" + "age=" + age);
    }

    @Test(dataProvider="data")
    public void test2(String name, Integer age){
        System.out.println("name="+ name + ";" + "age=" + age);
    }

    @Test(dataProvider="data")
    public void test3(String name, Integer age){
        System.out.println("name="+ name + ";" + "age=" + age);
    }

    @DataProvider(name = "data")
    public Object[][] data(Method method){
        Object[][] obj = null;
        if (method.getName().equals("test2")) {
            obj = new Object[][]{
                    {"zhangshan", 30},
                    {"lishi", 40}
            };
        }else if (method.getName().equals("test3")) {
            obj = new Object[][]{
                    {"wangwu", 30},
                    {"zhaoliu", 40}
            };
        }
        return obj;
    }
}
