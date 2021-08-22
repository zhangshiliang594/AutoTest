package cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by win7 on 2021/8/8.
 */
public class MyHttpClientPost {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void Beforetest(){
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        url = bundle.getString("test_url");
    }

    @Test
    public void getcookie() throws IOException {
        HttpGet get = new HttpGet(url + bundle.getString("test_uri"));
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        this.store = client.getCookieStore();
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }

    @Test(dependsOnMethods = {"getcookie"})
    public void posttest() throws IOException {
        //post方法
        HttpPost post = new HttpPost(url + bundle.getString("test_post_uri"));
        DefaultHttpClient client = new DefaultHttpClient();
        //设置头信息
        post.setHeader("content-type","application/json");
        //设置传参
        JSONObject data = new JSONObject();
        data.put("name","laowang");
        data.put("age","18");
        //设置cookie
        client.setCookieStore(this.store);
        //添加参数
        StringEntity entity = new StringEntity(data.toString(),"utf-8");
        post.setEntity(entity);
        //执行
        HttpResponse response = client.execute(post);
        //获取结果
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        //检查结果
        JSONObject json = new JSONObject(result);
        Assert.assertEquals("danshengou",json.getString("laowang"));
        Assert.assertEquals("60",json.getString("age"));
    }
}
