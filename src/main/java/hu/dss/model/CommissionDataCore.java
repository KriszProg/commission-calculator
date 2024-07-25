package hu.dss.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public abstract class CommissionDataCore {

    @JacksonXmlProperty(localName = "commissionAmount")
    protected Integer commissionAmount;

    protected CommissionDataCore() {}

    protected CommissionDataCore(Integer commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

}
