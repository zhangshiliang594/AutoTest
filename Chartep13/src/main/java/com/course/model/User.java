package com.course.model;

import lombok.Data;

/**
 * Created by win7 on 2021/8/19.
 */
@Data
public class User {
    private int id;
    private String userName;
    private int passWd;
    private int sex;
    private int age;
    private int permission;
    private int isDelete;

    @Override
    public String toString(){
        return (
            "{id:"+id+","+
            "userName:"+userName+","+
            "passWd:"+passWd+","+
            "sex:"+sex+","+
            "age:"+age+","+
            "permission:"+permission+","+
            "isDelete:"+isDelete+"}"
                );
    }

}
