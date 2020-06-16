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

    /**
     * 插入一对卡片和标签
     * @param cardId 卡片的 id
     * @param tagId 标签的 id
     * @return -1 失败，其他成功
     */
    public int insertCardAndTag(int cardId, int tagId);

    /**
     * 通过标签 id 查询标签
     * @param tagId 标签 id
     * @return null 就是不存在，否则就是对应标签对象
     */
    public Tag queryTagById(int tagId);

    /**
     * 根据卡片 id 查询标签（不包括 first tag）
     * @param cardId 卡片 id
     * @return 标签的 list
     */
    public List<Tag> queryTagsByCardId(int cardId);
}
