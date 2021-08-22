package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by win7 on 2021/8/21.
 */
public class LoginTest {

    @BeforeTest(groups = "loginTrue",description="测试准备工作，获取httpClient对象")
    public void BeforeTest(){
        TestConfig.getUserInfouri = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.addUseruri = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.getUserListuri = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.loginuri = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.updateUserInfouri = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);

        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(groups = "loginTrue",description = "登录成功用例")
    public void loginTrue() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("LoginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginuri);
    }

    @Test(groups = "loginFalse",description = "登录失败用例")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("LoginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginuri);
    }
}
