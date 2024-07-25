package hu.dss.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonPropertyOrder({ "employee", "productType", "salesValue", "baseCommissionAmount", "bonusCommissionAmount", "totalCommissionAmount" })
public class CommissionItem {

    @JacksonXmlProperty(localName = "employee")
    private Employee employee;
    @JacksonXmlProperty(localName = "productType")
    private ProductType productType;
    @JacksonXmlProperty(localName = "salesValue")
    private Integer salesValue;
    @JacksonXmlProperty(localName = "baseCommissionAmount")
    private Integer baseCommissionAmount;
    @JacksonXmlProperty(localName = "bonusCommissionAmount")
    private Integer bonusCommissionAmount;
    @JacksonXmlProperty(localName = "totalCommissionAmount")
    private Integer totalCommissionAmount;

    public Employee getEmployee() {
        return employee;
    }

    public CommissionItem employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public ProductType getProductType() {
        return productType;
    }

    public CommissionItem productType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public Integer getSalesValue() {
        return salesValue;
    }

    public CommissionItem salesValue(Integer salesValue) {
        this.salesValue = salesValue;
        return this;
    }

    public Integer getBaseCommissionAmount() {
        return baseCommissionAmount;
    }

    public CommissionItem baseCommissionAmount(Integer baseCommissionAmount) {
        this.baseCommissionAmount = baseCommissionAmount;
        return this;
    }

    public Integer getBonusCommissionAmount() {
        return bonusCommissionAmount;
    }

    public CommissionItem bonusCommissionAmount(Integer bonusCommissionAmount) {
        this.bonusCommissionAmount = bonusCommissionAmount;
        return this;
    }

    public Integer getTotalCommissionAmount() {
        return totalCommissionAmount;
    }

    public CommissionItem totalCommissionAmount(Integer totalCommissionAmount) {
        this.totalCommissionAmount = totalCommissionAmount;
        return this;
    }

    @Override
    public String toString() {
        return "CommissionItem{" +
                "employee='" + employee + '\'' +
                ", productType=" + productType +
                ", salesValue=" + salesValue +
                ", baseCommissionAmount=" + baseCommissionAmount +
                ", bonusCommissionAmount=" + bonusCommissionAmount +
                ", totalCommissionAmount=" + totalCommissionAmount +
                '}';
    }

}
