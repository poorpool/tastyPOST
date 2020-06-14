package net.yxchen.pojo;

import java.util.Date;

public class Comment {
    private Integer commentId;
    private Integer cardId;
    private Integer userId;
    private Date createDate;
    private String content;

    public Comment() {
    }

    public Comment(Integer commentId, Integer cardId, Integer userId, Date createDate, String content) {
        this.commentId = commentId;
        this.cardId = cardId;
        this.userId = userId;
        this.createDate = createDate;
        this.content = content;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", cardId=" + cardId +
                ", userId=" + userId +
                ", createDate=" + createDate +
                ", content='" + content + '\'' +
                '}';
    }
}
