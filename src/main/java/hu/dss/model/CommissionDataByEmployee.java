package hu.dss.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "commission")
@JsonPropertyOrder({ "employee", "commissionAmount" })
public class CommissionDataByEmployee extends CommissionDataCore {

    @JacksonXmlProperty(localName = "employee")
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
