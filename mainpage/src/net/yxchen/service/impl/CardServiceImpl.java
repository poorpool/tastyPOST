package net.yxchen.service.impl;

import net.yxchen.dao.CardDao;
import net.yxchen.dao.TagDao;
import net.yxchen.dao.UserDao;
import net.yxchen.dao.impl.CardDaoImpl;
import net.yxchen.dao.impl.TagDaoImpl;
import net.yxchen.dao.impl.UserDaoImpl;
import net.yxchen.pojo.Card;
import net.yxchen.pojo.CardItem;
import net.yxchen.pojo.Page;
import net.yxchen.pojo.User;
import net.yxchen.service.CardService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CardServiceImpl implements CardService {
    CardDao cardDao = new CardDaoImpl();
    TagDao tagDao = new TagDaoImpl();
    UserDao userDao = new UserDaoImpl();
    @Override
    public int createCard(Card card, List<Integer> list) {
        int cardId = cardDao.createCard(card);
        card.setCardId(cardId);
        if (cardId < 0) {
            return -1;
        }
        boolean flag = true;
        for (Integer tagId : list) {
            flag &= tagDao.insertCardAndTag(cardId, tagId) > 0;
        }
        return flag ? 1 : -1;
    }

    @Override
    public Page<CardItem> queryPage(int pageNo, int pageSize, String basePath) {
        Page<CardItem> page = new Page<>();
        page.setPageSize(pageSize);
        int totalCount = cardDao.queryTotalCount();
        page.setPageTotalCount(totalCount);
        int pageTotal = (totalCount + pageSize - 1) / pageSize;
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        List<Card> list = cardDao.queryCardsListByPage((page.getPageNo()-1)*pageSize, pageSize);
        List<CardItem> cardItems = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Card card : list) {
            String imgPath = card.getImgPath();
            imgPath = basePath + imgPath.substring(imgPath.lastIndexOf("/upload"));
            User user = userDao.queryUserByid(card.getUserId());
            cardItems.add(new CardItem(card.getCardId(), card.getTitle(), sdf.format(card.getDate()), user.getUserId(), user.getUsername(),
                    card.getContent(), tagDao.queryTagById(card.getFirstTagId()), tagDao.queryTagsByCardId(card.getCardId()), imgPath,
                    card.getLikeNum(), card.getCommentNum()));
        }
        page.setItems(cardItems);
        // page 的 url 在 Servlet 中设置
        return page;
    }
}
