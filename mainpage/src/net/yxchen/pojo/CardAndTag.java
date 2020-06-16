package net.yxchen.pojo;

public class CardAndTag {
    private Integer cardId;
    private Integer tagId;

    public CardAndTag() {
    }

    public CardAndTag(Integer cardId, Integer tagId) {
        this.cardId = cardId;
        this.tagId = tagId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "CardAndTag{" +
                "cardId=" + cardId +
                ", tagId=" + tagId +
                '}';
    }
}
