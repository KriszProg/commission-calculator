package hu.dss.model.xmlwrapper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import hu.dss.model.CommissionDataByEmployee;

import java.util.List;

@JacksonXmlRootElement(localName = "commissions")
public class CommissionDataByEmployeeListWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "commission")
    private List<CommissionDataByEmployee> commissions;

    public List<CommissionDataByEmployee> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionDataByEmployee> commissions) {
        this.commissions = commissions;
    }

}
