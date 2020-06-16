package net.yxchen.dao.impl;

import net.yxchen.dao.CardDao;
import net.yxchen.pojo.Card;
import net.yxchen.pojo.Page;
import net.yxchen.utils.WebUtils;

import java.util.List;

public class CardDaoImpl extends BaseDao implements CardDao {
    @Override
    public int createCard(Card card) {
        String sql = "insert into t_card (`title`, `createDate`, `userId`, `content`, `firstTagId`, `imgPath`, `likeNum`, `commentNum`) values (?, ?, ?, ?, ?, ?, ?, ?)";
        int ret = update(sql, card.getTitle(), card.getDate(), card.getUserId(), card.getContent(), card.getFirstTagId(), card.getImgPath(), card.getLikeNum(), card.getCommentNum());
        if (ret < 0) {
            return ret;
        }
        String sql2 = "select @@identity";
        return WebUtils.pasreInt(queryForSingleValue(sql2).toString(), 0);
    }

    @Override
    public List<Card> queryCardsListByPage(int begin, int size) {
        String sql = "select `cardId`, `title`, `createDate` as date, `userId`, `content`, `firstTagId`, `imgPath`, `likeNum`, `commentNum` from t_card order by cardId desc limit ?, ?";
        return queryForList(Card.class, sql, begin, size);
    }

    @Override
    public int queryTotalCount() {
        String sql = "select count(*) from t_card";
        return ((Number) queryForSingleValue(sql)).intValue();
    }

}
