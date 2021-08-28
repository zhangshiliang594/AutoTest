package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserInfoCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        //请求获取结果
        JSONArray resultJson = getJsonResult(getUserInfoCase);
        User user = session.selectOne(getUserInfoCase.getExpected(),getUserInfoCase);
        //验证
        List<User> userlist = new ArrayList<User>();
        userlist.add(user);
        JSONArray jsonArray = new JSONArray(userlist);
        System.out.println(jsonArray.getJSONObject(0));
        System.out.println(resultJson);
        System.out.println(resultJson.getJSONObject(0));
        Assert.assertEquals(jsonArray.getJSONObject(0).getString("userName"),resultJson.getJSONObject(0).getString("userName"));

    }

    private JSONArray getJsonResult(GetUserInfoCase getUserInfoCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.getUserInfouri);
        JSONObject param = new JSONObject();
        param.put("id",getUserInfoCase.getUserId());
        post.setHeader("Content-Type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        JSONArray array;
        array = new JSONArray(result);
        return array;
    }
}
