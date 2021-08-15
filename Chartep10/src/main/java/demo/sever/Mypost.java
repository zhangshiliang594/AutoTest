package demo.sever;

import demo.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by win7 on 2021/8/15.
 */
@RestController
@Api(value = "/",description = "全部post请求方法")
@RequestMapping("V1")
public class Mypost {
    private static Cookie cookie;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "passWord",required = true) String passWord){
        if (userName.equals("zhangshan") && passWord.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "登录成功";
        }
        return "账号或密码错误，登录失败！";
    }

    @RequestMapping(value = "/getMyuserlist",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserlist(HttpServletRequest request,
                                      @RequestBody User u){
        User user;
        //获取cookie
        Cookie[] cookies = request.getCookies();
        //验证
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")
                    && cookie.getValue().equals("true")
                    && u.getUserName().equals("zhanshan")
                    && u.getPassWord().equals("123456")){
                user = new User();
                user.setName("laowang");
                user.setAge("12");
                user.setSex("不男不女");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}
