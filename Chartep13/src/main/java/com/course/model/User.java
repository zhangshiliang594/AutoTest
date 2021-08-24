package com.course.model;

import lombok.Data;

/**
 * Created by win7 on 2021/8/19.
 */
@Data
public class User {
    private String id;
    private String userName;
    private String passWd;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;

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
