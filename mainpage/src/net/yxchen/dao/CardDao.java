package net.yxchen.dao;

import net.yxchen.pojo.Card;
import net.yxchen.pojo.Page;
import net.yxchen.pojo.Tag;

import java.util.Date;
import java.util.List;

public interface CardDao {
    /**
     * 保存卡片
     * @param card 要保存的卡片
     * @return -1 为失败，其他为该卡片的 cardId
     */
    public int createCard(Card card);

    /**
     * 倒序查询卡片
     * @param begin 卡片开始的编号（0 为最新的）
     * @param size 查询个数
     * @return 查询结果
     */
    public List<Card> queryCardsListByPage(int begin, int size);

    /**
     * 查询有多少个卡片
     * @return 卡片总数
     */
    public int queryTotalCount();
}
