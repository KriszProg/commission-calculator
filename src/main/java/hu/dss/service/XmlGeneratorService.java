package hu.dss.service;

import hu.dss.model.CommissionData;
import hu.dss.model.CommissionDataDetailed;

import java.util.List;

public interface XmlGeneratorService {

    void generateCommissionReportXml(List<CommissionData> commissionList);
    void generateCommissionReportDetailedXml(List<CommissionDataDetailed> commissionListWithDetails);

}
