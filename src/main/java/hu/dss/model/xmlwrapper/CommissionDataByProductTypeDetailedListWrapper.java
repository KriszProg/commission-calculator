package hu.dss.model.xmlwrapper;

import hu.dss.model.CommissionDataByProductTypeDetailed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "commissions")
public class CommissionDataByProductTypeDetailedListWrapper {

    private List<CommissionDataByProductTypeDetailed> commissions;

    @XmlElement(name = "commission")
    public List<CommissionDataByProductTypeDetailed> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionDataByProductTypeDetailed> commissions) {
        this.commissions = commissions;
    }

}
