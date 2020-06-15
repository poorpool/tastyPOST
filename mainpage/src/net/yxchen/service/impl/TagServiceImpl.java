package net.yxchen.service.impl;

import net.yxchen.dao.TagDao;
import net.yxchen.dao.impl.TagDaoImpl;
import net.yxchen.pojo.Tag;
import net.yxchen.service.TagService;

import java.util.List;

public class TagServiceImpl implements TagService {
    TagDao tagDao = new TagDaoImpl();
    @Override
    public boolean saveTag(String name) {
        return tagDao.saveTag(name) > 0;
    }

    @Override
    public List<Tag> queryAllTags() {
        return tagDao.queryAllTags();
    }

    @Override
    public Tag queryTagByName(String name) {
        return tagDao.queryTagByName(name);
    }

    @Override
    public boolean deleteTag(int tagId) {
        return tagDao.deleteTag(tagId) > 0;
    }
}
