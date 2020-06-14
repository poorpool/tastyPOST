package net.yxchen.web;

import com.google.gson.Gson;
import net.yxchen.pojo.User;
import net.yxchen.service.UserService;
import net.yxchen.service.impl.UserServiceImpl;
import net.yxchen.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 根据提交的表单登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        User paramUser = WebUtils.copyParamToBean(map, new User());
        User loginUser = userService.login(paramUser);
        if (loginUser == null) {
            req.setAttribute("errorMessage", "用户名或密码错误");
            req.getRequestDispatcher("/user/login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("/user/login_success.jsp").forward(req, resp);
        }
    }


    /**
     * 根据提交的表单创建用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void registerUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        User user = WebUtils.copyParamToBean(map, new User());
        String verify = req.getParameter("verify");
        String actualVerifyCode = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        System.out.println(actualVerifyCode + ", " + verify);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        System.out.println(actualVerifyCode + ", " + verify);
        if (verify != null && verify.equalsIgnoreCase(actualVerifyCode)) {
            if (userService.isExistsUsername(user.getUsername())) {
                req.setAttribute("errorMessage", "用户名已存在");
            } else {
                user.setPrivilege(1);
                user.setRegisterDate(new Date());
                userService.registerUser(user);
                req.getRequestDispatcher("/user/register_success.jsp").forward(req, resp);
                return ;
            }
        } else {
            req.setAttribute("errorMessage", "验证码输入错误");
        }
        req.setAttribute("username", user.getUsername());
        req.setAttribute("email", user.getEmail());
        req.getRequestDispatcher("/user/register.jsp").forward(req, resp);
    }

    /**
     * 登出
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        resp.sendRedirect(req.getHeader("Referer"));
    }


    // 用户名存在吗
    // 注册用户
    // 登出
    //登录
}
