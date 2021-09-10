package com.astontech.bo;

public class LoyaltyAccount extends BaseBo{

    //parameters
    private int LoyaltyAccountId;
    private LoyaltyCompany CompanyName;
    private Employee EmployeeName;
    private String MemberNumber;

    //constructor
    public LoyaltyAccount() {
        this.CompanyName = new LoyaltyCompany();
        this.EmployeeName = new Employee();
    }

    public LoyaltyAccount(int loyaltyAccountId, LoyaltyCompany companyName, Employee employeeName, String memberNumber) {
        LoyaltyAccountId = loyaltyAccountId;
        CompanyName = companyName;
        EmployeeName = employeeName;
        MemberNumber = memberNumber;
    }

    //region get and set
    public int getLoyaltyAccountId() {
        return LoyaltyAccountId;
    }
    public void setLoyaltyAccountId(int loyaltyAccountId) {
        LoyaltyAccountId = loyaltyAccountId;
    }

    public LoyaltyCompany getCompanyName() {
        return CompanyName;
    }
    public void setCompanyName(LoyaltyCompany companyName) {
        CompanyName = companyName;
    }

    public Employee getEmployeeName() {
        return EmployeeName;
    }
    public void setEmployeeName(Employee employeeName) {
        EmployeeName = employeeName;
    }

    public String getMemberNumber() {
        return MemberNumber;
    }
    public void setMemberNumber(String memberNumber) {
        MemberNumber = memberNumber;
    }

    //endregion
}
