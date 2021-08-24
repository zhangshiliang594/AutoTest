package com.course.model;

import lombok.Data;

/**
 * Created by win7 on 2021/8/22.
 */
@Data
public class User {

    private String id;
    private String userName;
    private String passWd;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
}
