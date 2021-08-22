package com.course.model;

import lombok.Data;

/**
 * Created by win7 on 2021/8/22.
 */
@Data
public class User {

    private int id;
    private String userName;
    private int passWd;
    private int age;
    private int sex;
    private int permission;
    private int isDelete;
}
