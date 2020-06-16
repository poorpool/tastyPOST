package net.yxchen.dao.impl;

import net.yxchen.dao.TagDao;
import net.yxchen.pojo.Card;
import net.yxchen.pojo.CardAndTag;
import net.yxchen.pojo.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagDaoImpl extends BaseDao implements TagDao {
    @Override
    public int saveTag(String name) {
        String sql = "insert into t_tag (`name`) values (?)";
        return update(sql, name);
    }

    @Override
    public List<Tag> queryAllTags() {
        String sql = "select * from t_tag";
        return queryForList(Tag.class, sql);
    }

    @Override
    public Tag queryTagByName(String name) {
        String sql = "select * from t_tag where `name` regexp ?";
        return queryForOne(Tag.class, sql, "^" + name + "$");
    }

    @Override
    public int deleteTag(int tagId) {
        String sql = "delete from t_tag where tagId = ?";
        return update(sql, tagId);
    }

    @Override
    public int insertCardAndTag(int cardId, int tagId) {
        String sql = "insert into t_card_and_tag (`cardId`, `tagId`) values (?, ?)";
        return update(sql, cardId, tagId);
    }

    @Override
    public Tag queryTagById(int tagId) {
        String sql = "select * from t_tag where tagId = ?";
        return queryForOne(Tag.class, sql, tagId);
    }

    @Override
    public List<Tag> queryTagsByCardId(int cardId) {
        String sql = "select * from t_card_and_tag where cardId = ?";
        List<CardAndTag> list = queryForList(CardAndTag.class, sql, cardId);
        List<Tag> ret = new ArrayList<>();
        for (CardAndTag cardAndTag : list) {
            ret.add(queryTagById(cardAndTag.getTagId()));
        }
        return ret;
    }
}
