package net.yxchen.service;

import net.yxchen.pojo.Card;
import net.yxchen.pojo.CardItem;
import net.yxchen.pojo.Page;

import java.util.List;

public interface CardService {
    /**
     * 创建卡片并且同时插入对应的 tags
     * @param card
     * @param list
     * @return
     */
    public int createCard(Card card, List<Integer> list);

    /**
     * 查询分页
     * @param pageNo 分页号（1 开始）
     * @param pageSize 一页显示多少个
     * @param basePath 基本路径，形如 http://localhost:8080/工程路径（如果有）
     * @return 相应的 page 对象
     */
    public Page<CardItem> queryPage(int pageNo, int pageSize, String basePath);
}
