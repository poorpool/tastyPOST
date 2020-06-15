package net.yxchen.dao;

import net.yxchen.pojo.Tag;

import java.util.List;

public interface TagDao {
    /**
     * 保存标签
     * @param name 标签名
     * @return -1 保存失败，其他为成功
     */
    public int saveTag(String name);

    /**
     * 查询所有标签
     * @return 所有标签的 List
     */
    public List<Tag> queryAllTags();

    /**
     * 通过标签名查询标签
     * @param name 标签名
     * @return null 就是不存在，否则就是对应标签对象
     */
    public Tag queryTagByName(String name);

    /**
     * 删除标签
     * @param tagId tag 的编号
     * @return -1 如果删除失败，其他删除成功
     */
    public int deleteTag(int tagId);
}
