package hu.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "commission")
@XmlType(propOrder = { "employee", "totalCommissionAmount", "calculationDetails" })
public class CommissionDataDetailed {

    private Employee employee;
    private Integer totalCommissionAmount;
    private List<CalculationDetails> calculationDetails;

    public CommissionDataDetailed() {}

    @XmlElement
    public Employee getEmployee() {
        return employee;
    }

    public CommissionDataDetailed employee(Employee employee) {
        this.employee = employee;
        return this;
    }

    @XmlElement
    public Integer getTotalCommissionAmount() {
        return totalCommissionAmount;
    }

    public CommissionDataDetailed totalCommissionAmount(Integer totalCommissionAmount) {
        this.totalCommissionAmount = totalCommissionAmount;
        return this;
    }

    @XmlElementWrapper(name = "calculationDetails")
    @XmlElement(name = "calculationDetail")
    public List<CalculationDetails> getCalculationDetails() {
        return calculationDetails;
    }

    public CommissionDataDetailed calculationDetails(List<CalculationDetails> calculationDetails) {
        this.calculationDetails = calculationDetails;
        return this;
    }

    @Override
    public String toString() {
        return "CommissionDataDetailed{" +
                "employee='" + employee + '\'' +
                ", totalCommissionAmount=" + totalCommissionAmount +
                ", calculationDetails=" + calculationDetails +
                '}';
    }

}
