package net.yxchen.filter;

import net.yxchen.pojo.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
