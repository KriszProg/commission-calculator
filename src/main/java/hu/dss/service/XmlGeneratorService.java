package hu.dss.service;

import hu.dss.model.CommissionDataByEmployee;
import hu.dss.model.CommissionDataByEmployeeDetailed;
import hu.dss.model.CommissionDataByProductType;
import hu.dss.model.CommissionDataByProductTypeDetailed;

import java.util.List;

public interface XmlGeneratorService {

    void generateCommissionByEmployeeXml(List<CommissionDataByEmployee> commissionDataByEmployeeList);
    void generateCommissionByEmployeeDetailedXml(List<CommissionDataByEmployeeDetailed> commissionDataByEmployeeDetailedList);
    void generateCommissionByProductTypeXml(List<CommissionDataByProductType> commissionDataByProductTypeList);
    void generateCommissionByProductTypeDetailedXml(List<CommissionDataByProductTypeDetailed> commissionDataByProductTypeDetailedList);

}
