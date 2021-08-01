package com.demo.testng.group;

import org.testng.annotations.Test;

/**
 * Created by win7 on 2021/8/1.
 */

@Test(groups = "stu2")
public class Studentclass2 {

    @Test
    public void student1(){
        System.out.println("Studentclass2测试111");
    }

    @Test
    public void student2(){
        System.out.println("Studentclass2测试222");
    }
}
