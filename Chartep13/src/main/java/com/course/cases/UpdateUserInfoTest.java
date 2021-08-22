package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.UpdateUserInfoCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by win7 on 2021/8/21.
 */
public class UpdateUserInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "更新用户信息用例")
    public void UpdateUserInfo() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = session.selectOne("UpdateUserInfo",1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfouri);
    }

    @Test(dependsOnGroups = "loginTrue",description = "更新用户信息删除")
    public void DeleteUserInfo() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = session.selectOne("UpdateUserInfo",2);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfouri);
    }
}
