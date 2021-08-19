package com.course.model;

import lombok.Data;

/**
 * Created by win7 on 2021/8/19.
 */
@Data
public class UpdateUserInfoCase {

    private int id;
    private int userId;
    private  String userName;
    private int age;
    private int sex;
    private int permission;
    private int isDelete;
    private String expected;
}
