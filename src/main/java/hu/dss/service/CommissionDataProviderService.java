package hu.dss.service;

import hu.dss.model.CommissionDataByEmployee;
import hu.dss.model.CommissionDataByEmployeeDetailed;
import hu.dss.model.CommissionDataByProductType;
import hu.dss.model.CommissionDataByProductTypeDetailed;

import java.util.List;

public interface CommissionDataProviderService {

    List<CommissionDataByEmployee> getCommissionDataByEmployeeList();
    List<CommissionDataByEmployeeDetailed> getCommissionDataByEmployeeDetailedList();
    List<CommissionDataByProductType> getCommissionDataByProductTypeList();
    List<CommissionDataByProductTypeDetailed> getCommissionDataByProductTypeDetailedList();

}
