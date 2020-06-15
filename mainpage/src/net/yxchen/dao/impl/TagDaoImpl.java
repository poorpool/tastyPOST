package net.yxchen.dao.impl;

import net.yxchen.dao.TagDao;
import net.yxchen.pojo.Tag;

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
}
