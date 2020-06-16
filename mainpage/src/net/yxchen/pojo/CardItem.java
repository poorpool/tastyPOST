package net.yxchen.pojo;

import java.util.Date;
import java.util.List;

public class CardItem {
    private Integer cardId;
    private String title;
    private String date;//展示方便
    private Integer userId;//展示方便
    private String username;
    private String content;
    private Tag firstTag;//展示方便
    private List<Tag> otherTags;
    private String imgPath;//从本地磁盘真实路径转化成网络 url
    private Integer likeNum;
    private Integer commentNum;

    public CardItem() {
    }

    public CardItem(Integer cardId, String title, String date, Integer userId, String username, String content, Tag firstTag, List<Tag> otherTags, String imgPath, Integer likeNum, Integer commentNum) {
        this.cardId = cardId;
        this.title = title;
        this.date = date;
        this.userId = userId;
        this.username = username;
        this.content = content;
        this.firstTag = firstTag;
        this.otherTags = otherTags;
        this.imgPath = imgPath;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Tag getFirstTag() {
        return firstTag;
    }

    public void setFirstTag(Tag firstTag) {
        this.firstTag = firstTag;
    }

    public List<Tag> getOtherTags() {
        return otherTags;
    }

    public void setOtherTags(List<Tag> otherTags) {
        this.otherTags = otherTags;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    @Override
    public String toString() {
        return "CardItem{" +
                "cardId=" + cardId +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", firstTag=" + firstTag +
                ", otherTags=" + otherTags +
                ", imgPath='" + imgPath + '\'' +
                ", likeNum=" + likeNum +
                ", commentNum=" + commentNum +
                '}';
    }
}
