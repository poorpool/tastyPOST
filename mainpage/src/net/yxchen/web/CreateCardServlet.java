package net.yxchen.web;

import net.yxchen.pojo.Card;
import net.yxchen.pojo.User;
import net.yxchen.service.CardService;
import net.yxchen.service.impl.CardServiceImpl;
import net.yxchen.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CreateCardServlet extends HttpServlet {
    CardService cardService = new CardServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/square/pages/createCard.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        DiskFileItemFactory dfif = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(dfif);
        User user = (User) req.getSession().getAttribute("user");
        Card card = new Card();
        List<Integer> otherTagList = null;
        boolean flag = true;
        try {
            List<FileItem> list = upload.parseRequest(req);
            for (FileItem fileItem : list) {
                String fieldName = fileItem.getFieldName();
                if ("title".equals(fieldName)) {
                    String title = fileItem.getString("UTF-8");
                    if (title.length()==0) {
                        flag = false;
                    }
                    card.setTitle(title);
                } else if ("firstTagId".equals(fieldName)) {
                    int firstTagId = WebUtils.pasreInt(fileItem.getString(), 0);
                    if (firstTagId==0) {
                        flag = false;
                    }
                    card.setFirstTagId(firstTagId);
                } else if("otherTags".equals(fieldName)) {
                    String otherTags = fileItem.getString();
                    otherTagList = WebUtils.parseStringToIntListByComma(otherTags);
                } else if("content".equals(fieldName)) {
                    String content = fileItem.getString("UTF-8");
                    card.setContent(content);
                } else if("image".equals(fieldName)) {
                    String filName=fileItem.getName();
                    if (filName.length()==0) {
                        card.setImgPath("");
                        continue;
                    }
                    String uuid= UUID.randomUUID().toString();
                    String suffix=filName.substring(filName.lastIndexOf("."));

                    String uploadPath = req.getSession().getServletContext().getRealPath(File.separator
                            + "upload"
                            + File.separator
                            + user.getUserId()
                            + File.separator
                            + new SimpleDateFormat("yyyy-MM").format(new Date()));
                    File file = new File(uploadPath);
                    file.mkdirs();

                    fileItem.write(new File(file, uuid + suffix));
                    String imgPath = file.getAbsolutePath() + File.separator + uuid + suffix;
                    card.setImgPath(imgPath);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if (!flag) {
            req.setAttribute("title", card.getTitle());
            req.setAttribute("content", card.getContent());
            req.setAttribute("errorMessage", "传输发生错误。请检查必填项目是否填写，图片是否过大。");
            req.getRequestDispatcher("/square/pages/createCard.jsp").forward(req, resp);
            return ;
        }
        card.setDate(new Date());
        card.setUserId(user.getUserId());
        card.setLikeNum(0);
        card.setCommentNum(0);
        cardService.createCard(card, otherTagList);
        resp.sendRedirect("/square/index.jsp");
    }
}
