package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.AddUserCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by win7 on 2021/8/21.
 */
public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue",description = "增加用户成功用例")
    public void addUser() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = session.selectOne("AddUserInfo",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUseruri);
    }
}
