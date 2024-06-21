package hu.dss.model.xmlwrapper;

import hu.dss.model.CommissionDataDetailed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "commissions")
public class CommissionDataDetailedListWrapper {

    private List<CommissionDataDetailed> commissions;

    @XmlElement(name = "commission")
    public List<CommissionDataDetailed> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionDataDetailed> commissions) {
        this.commissions = commissions;
    }

}
