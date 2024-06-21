package hu.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "calculationDetail")
@XmlType(propOrder = { "productType", "salesValueOfProductType", "baseCommissionAmount", "bonusCommissionAmount", "totalCommissionAmountOfProductType" })
public class CalculationDetails {
    private ProductType productType;
    private Integer salesValueOfProductType;
    private Integer baseCommissionAmount;
    private Integer bonusCommissionAmount;

    private Integer totalCommissionAmountOfProductType;

    public CalculationDetails() {}

    @XmlElement
    public ProductType getProductType() {
        return productType;
    }

    public CalculationDetails productType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    @XmlElement
    public Integer getSalesValueOfProductType() {
        return salesValueOfProductType;
    }

    public CalculationDetails salesValueOfProductType(Integer salesValueOfProductType) {
        this.salesValueOfProductType = salesValueOfProductType;
        return this;
    }

    @XmlElement
    public Integer getBaseCommissionAmount() {
        return baseCommissionAmount;
    }

    public CalculationDetails baseCommissionAmount(Integer baseCommissionAmount) {
        this.baseCommissionAmount = baseCommissionAmount;
        return this;
    }

    @XmlElement
    public Integer getBonusCommissionAmount() {
        return bonusCommissionAmount;
    }

    public CalculationDetails bonusCommissionAmount(Integer bonusCommissionAmount) {
        this.bonusCommissionAmount = bonusCommissionAmount;
        return this;
    }

    @XmlElement
    public Integer getTotalCommissionAmountOfProductType() {
        return totalCommissionAmountOfProductType;
    }

    public CalculationDetails totalCommissionAmountOfProductType(Integer totalCommissionAmountOfProductType) {
        this.totalCommissionAmountOfProductType = totalCommissionAmountOfProductType;
        return this;
    }

    @Override
    public String toString() {
        return "CalculationDetail{" +
                "productType=" + productType +
                ", salesValueOfProductType=" + salesValueOfProductType +
                ", baseCommissionAmount=" + baseCommissionAmount +
                ", bonusCommissionAmount=" + bonusCommissionAmount +
                ", totalCommissionAmountOfProductType=" + totalCommissionAmountOfProductType +
                '}';
    }

}
