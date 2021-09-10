package com.astontech.bo;

import java.util.Date;

public class ReviewData extends BaseBo{
    //parameters
    private int ReviewDataId;
    private Review ReviewId;
    private EntityType ReviewType;
    private String ReviewDataValue;
    private Date CreateDate;

    //constructor
    public ReviewData() {
        this.ReviewId = new Review();
        this.ReviewType = new EntityType();
    }

    //region get and set
    public int getReviewDataId() {
        return ReviewDataId;
    }
    public void setReviewDataId(int reviewDataId) {
        ReviewDataId = reviewDataId;
    }

    public Review getReviewId() {
        return ReviewId;
    }
    public void setReviewId(Review reviewId) {
        ReviewId = reviewId;
    }

    public EntityType getReviewType() {
        return ReviewType;
    }
    public void setReviewType(EntityType reviewType) {
        ReviewType = reviewType;
    }

    public String getReviewDataValue() {
        return ReviewDataValue;
    }
    public void setReviewDataValue(String reviewDataValue) {
        ReviewDataValue = reviewDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }
    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion
}
