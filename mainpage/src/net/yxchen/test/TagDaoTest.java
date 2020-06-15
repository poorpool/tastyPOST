package net.yxchen.test;

import net.yxchen.dao.TagDao;
import net.yxchen.dao.impl.TagDaoImpl;
import net.yxchen.pojo.Tag;
import net.yxchen.utils.JdbcUtils;
import org.junit.Test;

import java.util.List;

public class TagDaoTest {
    TagDao tagDao = new TagDaoImpl();

    @Test
    public void saveTag() {
        System.out.println(tagDao.saveTag("东一食堂一楼"));
        JdbcUtils.commitAndClose();
    }

    @Test
    public void queryAllTags() {
        List<Tag> list = tagDao.queryAllTags();
        for (Tag tag : list) {
            System.out.println(tag);
        }
    }

    @Test
    public void deleteTag() {
        System.out.println(tagDao.deleteTag(2));
        JdbcUtils.commitAndClose();
    }

    @Test
    public void queryTagByName() {
        System.out.println(tagDao.queryTagByName("ddd"));
    }
}