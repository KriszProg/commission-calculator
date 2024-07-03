package hu.dss.model.xmlwrapper;

import hu.dss.model.CommissionDataByEmployeeDetailed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "commissions")
public class CommissionDataByEmployeeDetailedListWrapper {

    private List<CommissionDataByEmployeeDetailed> commissions;

    @XmlElement(name = "commission")
    public List<CommissionDataByEmployeeDetailed> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionDataByEmployeeDetailed> commissions) {
        this.commissions = commissions;
    }

}
