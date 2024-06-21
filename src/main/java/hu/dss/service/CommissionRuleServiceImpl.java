package hu.dss.service;

import hu.dss.data.Database;
import hu.dss.model.CommissionRule;
import hu.dss.model.ProductType;

import java.math.BigDecimal;

public class CommissionRuleServiceImpl implements CommissionRuleService {

    public static final BigDecimal DEFAULT_PERCENTAGE = new BigDecimal(1);
    private final Database database = Database.getInstance();

    @Override
    public void createCommissionRules() {
        database.saveCommissionRule(new CommissionRule(ProductType.A, 0, 9999999,
                DEFAULT_PERCENTAGE, 0));

        database.saveCommissionRule(new CommissionRule(ProductType.A, 10000000, 19999999,
                DEFAULT_PERCENTAGE, 25000));

        database.saveCommissionRule(new CommissionRule(ProductType.A, 20000000, null,
                DEFAULT_PERCENTAGE, 40000));

        database.saveCommissionRule(new CommissionRule(ProductType.B, 0, 7999999,
                DEFAULT_PERCENTAGE, 0));

        database.saveCommissionRule(new CommissionRule(ProductType.B, 8000000, 15999999,
                DEFAULT_PERCENTAGE, 30000));

        database.saveCommissionRule(new CommissionRule(ProductType.B, 16000000, null,
                DEFAULT_PERCENTAGE, 50000));

        database.saveCommissionRule(new CommissionRule(ProductType.C, 0, 4999999,
                DEFAULT_PERCENTAGE, 0));

        database.saveCommissionRule(new CommissionRule(ProductType.C, 5000000, 9999999,
                DEFAULT_PERCENTAGE, 20000));

        database.saveCommissionRule(new CommissionRule(ProductType.C, 10000000, null,
                DEFAULT_PERCENTAGE, 40000));
    }

    @Override
    public CommissionRule findRuleByProductTypeAndSalesValue(ProductType productType, Integer salesValue) {
        return database.findRuleByProductTypeAndSalesValue(productType, salesValue);
    }

}
