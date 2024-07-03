package hu.dss.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "commission")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommissionDataByProductTypeDetailed extends CommissionDataByProductType {

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
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
