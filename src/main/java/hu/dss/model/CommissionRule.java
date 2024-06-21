package hu.dss.model;

import java.math.BigDecimal;
import java.util.Objects;

public class CommissionRule {

    private ProductType productType;
    private Integer lowerValue;
    private Integer upperValue;
    private BigDecimal percentage;
    private Integer bonusValue;

    public CommissionRule(ProductType productType, Integer lowerValue, Integer upperValue,
                          BigDecimal percentage, Integer bonusValue) {
        this.productType = productType;
        this.lowerValue = lowerValue;
        this.upperValue = upperValue;
        this.percentage = percentage;
        this.bonusValue = bonusValue;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Integer getLowerValue() {
        return lowerValue;
    }

    public Integer getUpperValue() {
        return upperValue;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public Integer getBonusValue() {
        return bonusValue;
    }

    public Boolean hasUpperValue() {
        return upperValue != null;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CommissionRule that = (CommissionRule) object;
        return Objects.equals(productType, that.productType)
                && Objects.equals(lowerValue, that.lowerValue)
                && Objects.equals(upperValue, that.upperValue)
                && Objects.equals(percentage, that.percentage)
                && Objects.equals(bonusValue, that.bonusValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, lowerValue, upperValue, percentage, bonusValue);
    }

    @Override
    public String toString() {
        return "CommissionCalculationRule{" +
                "productType=" + productType +
                ", lowerValue=" + lowerValue +
                ", upperValue=" + upperValue +
                ", percentage=" + percentage +
                ", bonusValue=" + bonusValue +
                '}';
    }

}
