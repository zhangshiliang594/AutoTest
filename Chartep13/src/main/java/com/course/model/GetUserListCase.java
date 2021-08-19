package com.course.model;

import lombok.Data;

/**
 * Created by win7 on 2021/8/19.
 */
@Data
public class GetUserListCase {

    private int id;
    private String userName;
    private int age;
    private int sex;
    private String expected;
}
