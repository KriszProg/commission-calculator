package hu.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "employee", "productType", "salesValue", "baseCommissionAmount", "bonusCommissionAmount", "totalCommissionAmount" })
public class CommissionItem {

    private Employee employee;
    private ProductType productType;
    private Integer salesValue;
    private Integer baseCommissionAmount;
    private Integer bonusCommissionAmount;
    private Integer totalCommissionAmount;

    @XmlElement
    public Employee getEmployee() {
        return employee;
    }

    public CommissionItem employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    @XmlElement
    public ProductType getProductType() {
        return productType;
    }

    public CommissionItem productType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    @XmlElement
    public Integer getSalesValue() {
        return salesValue;
    }

    public CommissionItem salesValue(Integer salesValue) {
        this.salesValue = salesValue;
        return this;
    }

    @XmlElement
    public Integer getBaseCommissionAmount() {
        return baseCommissionAmount;
    }

    public CommissionItem baseCommissionAmount(Integer baseCommissionAmount) {
        this.baseCommissionAmount = baseCommissionAmount;
        return this;
    }

    @XmlElement
    public Integer getBonusCommissionAmount() {
        return bonusCommissionAmount;
    }

    public CommissionItem bonusCommissionAmount(Integer bonusCommissionAmount) {
        this.bonusCommissionAmount = bonusCommissionAmount;
        return this;
    }

    @XmlElement
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
