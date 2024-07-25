package hu.dss.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "commission")
@JsonPropertyOrder({ "productType", "commissionAmount" })
public class CommissionDataByProductTypeDetailed extends CommissionDataByProductType {

    @JacksonXmlElementWrapper(localName = "items")
    @JacksonXmlProperty(localName = "item")
    private List<CommissionItem> items;

    public CommissionDataByProductTypeDetailed() {}

    public CommissionDataByProductTypeDetailed(Integer commissionAmount, ProductType productType, List<CommissionItem> items) {
        super(commissionAmount, productType);
        this.items = items;
    }

    @Override
    public String toString() {
        return "CommissionDataByProductTypeDetailed{" +
                "productType='" + productType + '\'' +
                ", commissionAmount=" + commissionAmount +
                ", items=" + items +
                '}';
    }

}
