package hu.dss.model.xmlwrapper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import hu.dss.model.CommissionDataByEmployeeDetailed;

import java.util.List;

@JacksonXmlRootElement(localName = "commissions")
public class CommissionDataByEmployeeDetailedListWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "commission")
    private List<CommissionDataByEmployeeDetailed> commissions;

    public List<CommissionDataByEmployeeDetailed> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionDataByEmployeeDetailed> commissions) {
        this.commissions = commissions;
    }

}
