package com.astontech.bo;

import java.util.Date;

public class Review extends BaseBo{
    //parameters
    private int ReviewId;
    private String ReviewName;
    private Date ReviewDate;
    private Employee ReviewedEmployee;

    //constructors
    public Review() {
        this.ReviewedEmployee = new Employee();
    }

    //region get and set
    public int getReviewId() {
        return ReviewId;
    }
    public void setReviewId(int reviewId) {
        ReviewId = reviewId;
    }

    public String getReviewName() {
        return ReviewName;
    }
    public void setReviewName(String reviewName) {
        ReviewName = reviewName;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }
    public void setReviewDate(Date reviewDate) {
        ReviewDate = reviewDate;
    }

    public Employee getReviewedEmployee() {
        return ReviewedEmployee;
    }
    public void setReviewedEmployee(Employee reviewedEmployee) {
        ReviewedEmployee = reviewedEmployee;
    }
    //endregion
}
