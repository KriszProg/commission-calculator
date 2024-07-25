package hu.dss.model.xmlwrapper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import hu.dss.model.CommissionDataByProductType;

import java.util.List;

@JacksonXmlRootElement(localName = "commissions")
public class CommissionDataByProductTypeListWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "commission")
    private List<CommissionDataByProductType> commissions;

    public List<CommissionDataByProductType> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionDataByProductType> commissions) {
        this.commissions = commissions;
    }

}
