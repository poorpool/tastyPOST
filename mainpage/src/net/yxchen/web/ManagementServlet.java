package net.yxchen.web;

import com.google.gson.Gson;
import net.yxchen.pojo.Tag;
import net.yxchen.service.TagService;
import net.yxchen.service.impl.TagServiceImpl;
import net.yxchen.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagementServlet extends BaseServlet {
    TagService tagService = new TagServiceImpl();

    protected void ajaxQueryAllTags(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tag> list = tagService.queryAllTags();
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(list));
    }

    protected void ajaxAddTag(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tagName = req.getParameter("tagName");
        Map<String, Boolean> map = new HashMap<>();
        if (tagService.queryTagByName(tagName) == null) {
            tagService.saveTag(tagName);
            map.put("result", true);
        } else {
            map.put("result", false);
        }
        resp.getWriter().write(new Gson().toJson(map));
    }

    protected void ajaxDeleteTag(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer tagId = WebUtils.pasreInt(req.getParameter("tagId"), 0);
        Map<String, Boolean> map = new HashMap<>();
        if (tagService.deleteTag(tagId)) {
            map.put("result", true);
        } else {
            map.put("result", false);
        }
        resp.getWriter().write(new Gson().toJson(map));
    }
}
