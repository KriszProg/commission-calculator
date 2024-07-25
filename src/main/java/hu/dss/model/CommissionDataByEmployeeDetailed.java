package hu.dss.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "commission")
@JsonPropertyOrder({ "employee", "commissionAmount", "items" })
public class CommissionDataByEmployeeDetailed extends CommissionDataByEmployee {

    @JacksonXmlElementWrapper(localName = "items")
    @JacksonXmlProperty(localName = "item")
    private List<CommissionItem> items;

    public CommissionDataByEmployeeDetailed() {}

    public CommissionDataByEmployeeDetailed(Integer commissionAmount, Employee employee, List<CommissionItem> items) {
        super(commissionAmount, employee);
        this.items = items;
    }

    @Override
    public String toString() {
        return "CommissionDataByEmployeeDetailed{" +
                "employee='" + employee + '\'' +
                ", commissionAmount=" + commissionAmount +
                ", items=" + items +
                '}';
    }

}
