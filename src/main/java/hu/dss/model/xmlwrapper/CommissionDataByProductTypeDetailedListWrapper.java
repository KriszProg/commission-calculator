package hu.dss.model.xmlwrapper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import hu.dss.model.CommissionDataByProductTypeDetailed;

import java.util.List;

@JacksonXmlRootElement(localName = "commissions")
public class CommissionDataByProductTypeDetailedListWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "commission")
    private List<CommissionDataByProductTypeDetailed> commissions;

    public List<CommissionDataByProductTypeDetailed> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionDataByProductTypeDetailed> commissions) {
        this.commissions = commissions;
    }

}
