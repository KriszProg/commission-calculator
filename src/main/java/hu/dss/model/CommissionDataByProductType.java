package hu.dss.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "commission")
@JsonPropertyOrder({ "productType", "commissionAmount" })
public class CommissionDataByProductType extends CommissionDataCore {

    @JacksonXmlProperty(localName = "productType")
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
