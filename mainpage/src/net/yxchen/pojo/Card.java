package net.yxchen.pojo;

import java.util.Date;

public class Card {
    private Integer cardId;
    private String title;
    private Date date;
    private Integer userId;
    private String content;
    private Integer firstTagId;
    private Integer likeNum;
    private Integer commentNum;

    public Card() {
    }

    public Card(Integer cardId, String title, Date date, Integer userId, String content, Integer firstTagId, Integer likeNum, Integer commentNum) {
        this.cardId = cardId;
        this.title = title;
        this.date = date;
        this.userId = userId;
        this.content = content;
        this.firstTagId = firstTagId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFirstTagId() {
        return firstTagId;
    }

    public void setFirstTagId(Integer firstTagId) {
        this.firstTagId = firstTagId;
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
        return "Card{" +
                "cardId=" + cardId +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", firstTagId=" + firstTagId +
                ", likeNum=" + likeNum +
                ", commentNum=" + commentNum +
                '}';
    }
}
