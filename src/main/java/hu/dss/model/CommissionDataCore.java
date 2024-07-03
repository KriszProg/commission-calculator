package hu.dss.model;

import javax.xml.bind.annotation.*;

@XmlTransient
public abstract class CommissionDataCore {

    protected Integer commissionAmount;

    protected CommissionDataCore() {}

    protected CommissionDataCore(Integer commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

}
