package net.yxchen.pojo;

public class Tag {
    private Integer tagId;
    private String name;

    public Tag() {
    }

    public Tag(Integer tagId, String name) {
        this.tagId = tagId;
        this.name = name;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", name='" + name + '\'' +
                '}';
    }
}
