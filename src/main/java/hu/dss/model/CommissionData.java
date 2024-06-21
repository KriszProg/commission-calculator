package hu.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "commissionData")
@XmlType(propOrder = { "employeeId", "commissionAmount" })
public class CommissionData {

    private String employeeId;
    private Integer commissionAmount;
    public CommissionData() {}

    @XmlElement
    public String getEmployeeId() {
        return employeeId;
    }

    public CommissionData employeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    @XmlElement
    public Integer getCommissionAmount() {
        return commissionAmount;
    }

    public CommissionData commissionAmount(Integer commissionAmount) {
        this.commissionAmount = commissionAmount;
        return this;
    }

    @Override
    public String toString() {
        return "CommissionData{" +
                "employeeId='" + employeeId + '\'' +
                ", commissionAmount=" + commissionAmount +
                '}';
    }

}
