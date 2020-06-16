package net.yxchen.test;

import net.yxchen.dao.CardDao;
import net.yxchen.pojo.Card;
import net.yxchen.service.CardService;
import net.yxchen.service.impl.CardServiceImpl;
import net.yxchen.utils.WebUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CardServiceTest {
    CardService cardService = new CardServiceImpl();
    @Test
    public void createCard() {
        Card card = new Card(null, "测试", new Date(), 9, "测试文本", 3, "", 0, 0);
        List<Integer> list = WebUtils.parseStringToIntListByComma("8, 9");
        cardService.createCard(card, list);
    }

    @Test
    public void queryPage() {
    }
}