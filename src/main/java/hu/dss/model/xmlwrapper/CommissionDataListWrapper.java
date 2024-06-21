package hu.dss.model.xmlwrapper;

import hu.dss.model.CommissionData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "commissions")
public class CommissionDataListWrapper {

    private List<CommissionData> commissions;

    @XmlElement(name = "commission")
    public List<CommissionData> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionData> commissions) {
        this.commissions = commissions;
    }

}
