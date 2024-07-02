package hu.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "commissionData")
@XmlType(propOrder = { "employee", "commissionAmount" })
public class CommissionData {

    private Employee employee;
    private Integer commissionAmount;
    public CommissionData() {}

    @XmlElement
    public Employee getEmployee() {
        return employee;
    }

    public CommissionData employee(Employee employee) {
        this.employee = employee;
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
                "employee='" + employee + '\'' +
                ", commissionAmount=" + commissionAmount +
                '}';
    }

}
