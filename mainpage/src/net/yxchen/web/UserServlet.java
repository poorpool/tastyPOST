package net.yxchen.web;

import net.yxchen.pojo.User;
import net.yxchen.service.UserService;
import net.yxchen.service.impl.UserServiceImpl;
import net.yxchen.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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

    }


    // 用户名存在吗
    // 注册用户
    // 登出
    //登录
}
