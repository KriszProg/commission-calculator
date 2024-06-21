package hu.dss.service;

import hu.dss.model.CommissionRule;
import hu.dss.model.ProductType;

import java.util.List;

public interface CommissionRuleService {

    void createCommissionRules();

    CommissionRule findRuleByProductTypeAndSalesValue(ProductType productType, Integer salesValue);

}

