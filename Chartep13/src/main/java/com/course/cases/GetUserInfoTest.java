package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserInfoCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by win7 on 2021/8/21.
 */
public class GetUserInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "查询用户信息用例")
    public void getUserInfo() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = session.selectOne("GetUserInfo",1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfouri);
    }
}
