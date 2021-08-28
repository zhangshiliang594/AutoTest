package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
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

        //发送请求
        String result = getResult(loginCase);
        System.out.println(result);

        //验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }



    @Test(groups = "loginFalse",description = "登录失败用例")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("LoginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginuri);

        //发送请求
        String result = getResult(loginCase);
        System.out.println(result);

        //验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }
    private String getResult(LoginCase loginCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.loginuri);
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("passWd",loginCase.getPassWd());
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setHeader("Content-Type","application/json");
        post.setEntity(entity);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        TestConfig.cookieStore = TestConfig.defaultHttpClient.getCookieStore();
        return result;
    }
}
