package hu.dss.model.xmlwrapper;

import hu.dss.model.CommissionDataByProductType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "commissions")
public class CommissionDataByProductTypeListWrapper {

    private List<CommissionDataByProductType> commissions;

    @XmlElement(name = "commission")
    public List<CommissionDataByProductType> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionDataByProductType> commissions) {
        this.commissions = commissions;
    }

}
