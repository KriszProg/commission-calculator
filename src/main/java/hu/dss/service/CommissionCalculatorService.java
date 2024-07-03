package hu.dss.service;

import hu.dss.model.*;


public interface CommissionCalculatorService {

    CommissionItem getCommissionItem(Employee employee, ProductType productType, Integer totalSalesValueOfProductType);

}
