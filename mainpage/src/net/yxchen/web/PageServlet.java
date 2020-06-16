package net.yxchen.web;

import com.google.gson.Gson;
import net.yxchen.pojo.Card;
import net.yxchen.pojo.CardItem;
import net.yxchen.pojo.Page;
import net.yxchen.pojo.Tag;
import net.yxchen.service.CardService;
import net.yxchen.service.TagService;
import net.yxchen.service.impl.CardServiceImpl;
import net.yxchen.service.impl.TagServiceImpl;
import net.yxchen.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PageServlet extends BaseServlet {
    TagService tagService = new TagServiceImpl();
    CardService cardService = new CardServiceImpl();

    protected void ajaxQueryAllTags(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tag> list = tagService.queryAllTags();
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(list));
    }

    /**
     * 要写回去一个 Page 对象，包括展示信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryForPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.pasreInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.pasreInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        String basePath = req.getScheme() + "://" + req.getServerName()
                + ":" + req.getServerPort() + req.getContextPath();
        Page<CardItem> page = cardService.queryPage(pageNo, pageSize, basePath);
        page.setUrl(basePath + "/pageServlet?action=queryForPage");
        System.out.println(page);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/square/pages/index.jsp").forward(req, resp);
    }
}
