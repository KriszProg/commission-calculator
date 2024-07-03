package hu.dss.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "commission")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommissionDataByEmployeeDetailed extends CommissionDataByEmployee {

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
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
