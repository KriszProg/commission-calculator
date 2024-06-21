package hu.dss.service;

import hu.dss.model.CommissionData;
import hu.dss.model.CommissionDataDetailed;
import hu.dss.model.SalesData;

import java.util.List;

public interface CommissionCalculatorService {

    void calculateCommission(List<SalesData> salesDataList);
    List<CommissionData> getResultList();
    List<CommissionDataDetailed> getResultListWithDetails();

}
