package com.demo.testng.group;

import org.testng.annotations.Test;

/**
 * Created by win7 on 2021/8/1.
 */

@Test(groups = "ter")
public class Teacherclass {

    @Test
    public void teacher1(){
        System.out.println("Teacherclass测试111");
    }

    @Test
    public void teacher2(){
        System.out.println("Teacherclass测试222");
    }
}
