package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by win7 on 2021/8/21.
 */
public class GetUserListTest {

    @Test(dependsOnGroups = "loginTrue",description = "查询用户列表信息")
    public void getUserListInfo() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserListCase getUserListCase = session.selectOne("GetUserListInfo",1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListuri);
    }
}
