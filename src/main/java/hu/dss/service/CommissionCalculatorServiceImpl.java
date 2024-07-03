package hu.dss.service;

import hu.dss.model.*;
import java.math.BigDecimal;

public class CommissionCalculatorServiceImpl implements CommissionCalculatorService {

    private final CommissionRuleService ruleService;

    public CommissionCalculatorServiceImpl(CommissionRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @Override
    public CommissionItem getCommissionItem(Employee employee, ProductType productType, Integer totalSalesValueOfProductType) {
        CommissionRule rule = ruleService.findRuleByProductTypeAndSalesValue(productType, totalSalesValueOfProductType);

        Integer baseCommissionAmount = BigDecimal.valueOf(totalSalesValueOfProductType)
                .multiply(rule.getPercentage())
                .divide(BigDecimal.valueOf(100))
                .intValue();
        Integer bonusCommissionAmount = rule.getBonusValue();
        Integer totalCommissionAmount = baseCommissionAmount + bonusCommissionAmount;

        return new CommissionItem()
                .employee(employee)
                .productType(productType)
                .salesValue(totalSalesValueOfProductType)
                .baseCommissionAmount(baseCommissionAmount)
                .bonusCommissionAmount(bonusCommissionAmount)
                .totalCommissionAmount(totalCommissionAmount);
    }

}
