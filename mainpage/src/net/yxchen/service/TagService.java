package net.yxchen.service;

import net.yxchen.pojo.Tag;

import java.util.List;

public interface TagService {
    /**
     * 保存标签
     * @param name 标签名
     * @return false 保存失败，true 成功
     */
    public boolean saveTag(String name);

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
     * @return false 删除失败，true 删除成功
     */
    public boolean deleteTag(int tagId);
}
