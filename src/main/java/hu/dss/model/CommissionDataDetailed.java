package hu.dss.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "commission")
@XmlType(propOrder = { "employeeId", "totalCommissionAmount", "calculationDetails" })
public class CommissionDataDetailed {

    private String employeeId;
    private Integer totalCommissionAmount;
    private List<CalculationDetails> calculationDetails;

    public CommissionDataDetailed() {}

    @XmlElement
    public String getEmployeeId() {
        return employeeId;
    }

    public CommissionDataDetailed employeeId(String employeeId) {
        this.employeeId = employeeId;
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
                "employeeId='" + employeeId + '\'' +
                ", totalCommissionAmount=" + totalCommissionAmount +
                ", calculationDetails=" + calculationDetails +
                '}';
    }

}
