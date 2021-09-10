package com.astontech.bo;

public class LoyaltyCompany extends BaseBo{
    //parameters
    private String CompanyName;
    private int LoyaltyCompanyId;
    private EntityType CompanyType;

    //region constructor
    public LoyaltyCompany() {
        this.CompanyType = new EntityType();
    }

    public LoyaltyCompany(String companyName) {
        CompanyName = companyName;
    }

    public LoyaltyCompany(String companyName, int loyaltyCompanyId, EntityType companyType) {
        CompanyName = companyName;
        LoyaltyCompanyId = loyaltyCompanyId;
        CompanyType = companyType;
    }

    //endregion

    //region get and set
    public String getCompanyName() {
        return CompanyName;
    }
    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }
    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public EntityType getCompanyType() {return CompanyType;}
    public void setCompanyType(EntityType companyType) {CompanyType = companyType;}
    //endregion
}
