package testreport;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by win7 on 2021/8/2.
 */
public class demo {

    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test2(){
        Assert.assertEquals("a","a");
    }

    @Test
    public void test3(){
        Assert.assertEquals("吴鸡巴","吴鸡巴");
    }

    @Test
    public void LoginTest(){
        Reporter.log("这是我们写的日志");
        throw new RuntimeException("异常信息");
    }
}
