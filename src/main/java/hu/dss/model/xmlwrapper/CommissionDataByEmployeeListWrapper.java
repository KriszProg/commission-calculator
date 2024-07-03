package hu.dss.model.xmlwrapper;

import hu.dss.model.CommissionDataByEmployee;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "commissions")
public class CommissionDataByEmployeeListWrapper {

    private List<CommissionDataByEmployee> commissions;

    @XmlElement(name = "commission")
    public List<CommissionDataByEmployee> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionDataByEmployee> commissions) {
        this.commissions = commissions;
    }

}
