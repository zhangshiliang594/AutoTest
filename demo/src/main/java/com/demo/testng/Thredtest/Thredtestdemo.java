package com.demo.testng.Thredtest;

import org.testng.annotations.Test;

/**
 * Created by win7 on 2021/8/1.
 */
public class Thredtestdemo {

    @Test
    public void test1(){
        System.out.printf("Thread Id:" + Thread.currentThread().getId());
    }

//    @Test
//    public void test2(){
//        System.out.println("Thread Id:" + Thread.currentThread().getId());
//    }
//
//    @Test
//    public void test3(){
//        System.out.println("Thread Id:" + Thread.currentThread().getId());
//    }
//
//    @Test
//    public void test4(){
//        System.out.println("Thread Id:" + Thread.currentThread().getId());
//    }
//
//    @Test
//    public void test5(){
//        System.out.println("Thread Id:" + Thread.currentThread().getId());
//    }
}
