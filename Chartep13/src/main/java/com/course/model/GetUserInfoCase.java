package com.course.model;

import lombok.Data;

/**
 * Created by win7 on 2021/8/19.
 */
@Data
public class GetUserInfoCase {

    private int id;
    private int userId;
    private String expected;
}
