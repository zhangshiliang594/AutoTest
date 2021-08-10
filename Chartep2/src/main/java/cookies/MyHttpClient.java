package cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by win7 on 2021/8/8.
 */
public class MyHttpClient {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void Beforetest(){
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        url = bundle.getString("test_url");
    }

    @Test
    public void test1() throws IOException {
        String result;
        HttpGet get = new HttpGet(this.url + bundle.getString("test_uri"));
//        HttpClient client = new DefaultHttpClient();
//        HttpResponse response = client.execute(get);
//        result = EntityUtils.toString(response.getEntity(),"utf-8");
//        System.out.println(result);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        this.store = client.getCookieStore();
        List<Cookie> cookieslist = store.getCookies();
        for (Cookie cookie:cookieslist){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = "+ name + "; cookie value = "+ value);
        }
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2() throws IOException {
        HttpGet get = new HttpGet(this.url + bundle.getString("test_get_uri"));
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        int Statuscode = response.getStatusLine().getStatusCode();
        if (Statuscode == 200) {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }
    }
}
