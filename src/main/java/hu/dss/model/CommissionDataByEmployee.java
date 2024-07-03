package hu.dss.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "commission")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "employee", "commissionAmount" })
public class CommissionDataByEmployee extends CommissionDataCore {

    @XmlElement
    protected Employee employee;

    public CommissionDataByEmployee() {}

    public CommissionDataByEmployee(Integer commissionAmount, Employee employee) {
        super(commissionAmount);
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "CommissionDataByEmployee{" +
                "employee='" + employee + '\'' +
                ", commissionAmount=" + commissionAmount +
                '}';
    }

}
