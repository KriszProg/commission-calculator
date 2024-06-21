package hu.dss.data;

import hu.dss.model.CommissionRule;
import hu.dss.model.ProductType;
import hu.dss.model.SalesData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Database {

    private static Database instance;
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    private final List<SalesData> salesDataList = new ArrayList<>();
    private final List<CommissionRule> commissionRules = new ArrayList<>();

    private Database() {}

    public void saveSalesDataList(List<SalesData> salesDataList) {
        this.salesDataList.addAll(salesDataList);
    }

    public List<SalesData> getSalesDataList() {
        return salesDataList;
    }

    public void saveCommissionRule(CommissionRule rule) {
        commissionRules.add(rule);
    }

    public CommissionRule findRuleByProductTypeAndSalesValue(ProductType productType, Integer salesValue) {
        return findRulesByProductType(productType).stream()
                .filter(rule -> salesValue >= rule.getLowerValue())
                .filter(rule -> !rule.hasUpperValue() || salesValue <= rule.getUpperValue())
                .findFirst()
                .orElse(null);
    }

    private List<CommissionRule> findRulesByProductType(ProductType productType) {
        return commissionRules.stream()
                .filter(rule -> productType.equals(rule.getProductType()))
                .collect(Collectors.toList());
    }

}
