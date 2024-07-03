package hu.dss.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "commission")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "productType", "commissionAmount" })
public class CommissionDataByProductType extends CommissionDataCore {

    @XmlElement
    protected ProductType productType;

    public CommissionDataByProductType() {}

    public CommissionDataByProductType(Integer commissionAmount, ProductType productType) {
        super(commissionAmount);
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "CommissionDataByProductType{" +
                "productType='" + productType + '\'' +
                ", commissionAmount=" + commissionAmount +
                '}';
    }

}
