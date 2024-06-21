package hu.dss.service;

import hu.dss.model.*;
import java.math.BigDecimal;
import java.util.*;

public class CommissionCalculatorServiceImpl implements CommissionCalculatorService {

    private final CommissionRuleService ruleService;

    /**
     * INFO: Map<String=employeeId, Map<ProductType, Integer=cumulativeSalesValue>>
     */
    private final Map<String, Map<ProductType, Integer>> cumulativeSalesData = new LinkedHashMap<>();

    private List<CalculationDetails> calculationDetailsPerEmployee = new ArrayList<>();
    private final List<CommissionData> resultList = new ArrayList<>();
    private final List<CommissionDataDetailed> resultListWithDetails = new ArrayList<>();

    public CommissionCalculatorServiceImpl(CommissionRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @Override
    public void calculateCommission(List<SalesData> salesDataList) {
        prepareCalculation(salesDataList);
        executeCalculation();
    }

    @Override
    public List<CommissionData> getResultList() {
        return resultList;
    }

    @Override
    public List<CommissionDataDetailed> getResultListWithDetails() {
        return resultListWithDetails;
    }

    private void prepareCalculation(List<SalesData> salesDataList) {
        for (SalesData salesData : salesDataList) {
            String employeeId = salesData.getEmployeeId();
            ProductType productType = salesData.getProductType();
            Integer salesValue = salesData.getSalesValue();

            Map<ProductType, Integer> productTypeAndSalesValueMap = cumulativeSalesData.getOrDefault(employeeId, new LinkedHashMap<>());
            Integer currentValue = productTypeAndSalesValueMap.getOrDefault(productType, 0);

            productTypeAndSalesValueMap.put(productType, currentValue + salesValue);

            cumulativeSalesData.put(employeeId, productTypeAndSalesValueMap);
        }
    }

    private void executeCalculation() {
        for (Map.Entry<String, Map<ProductType, Integer>> entry : cumulativeSalesData.entrySet()) {
            processCumulativeSalesData(entry);
        }
    }

    private void processCumulativeSalesData(Map.Entry<String, Map<ProductType, Integer>> entry) {
        calculationDetailsPerEmployee = new ArrayList<>();
        String employeeId = entry.getKey();
        Integer totalCommissionAmount = 0;

        for (Map.Entry<ProductType, Integer> productTypeAndSalesValueEntry : entry.getValue().entrySet()) {
            CalculationDetails details = calculateCommission(productTypeAndSalesValueEntry);
            totalCommissionAmount += details.getTotalCommissionAmountOfProductType();

            calculationDetailsPerEmployee.add(details);
        }

        addToResultLists(employeeId, totalCommissionAmount);
    }

    private CalculationDetails calculateCommission(Map.Entry<ProductType, Integer> productTypeAndSalesValueEntry) {
        ProductType productType = productTypeAndSalesValueEntry.getKey();
        Integer salesValue = productTypeAndSalesValueEntry.getValue();
        CommissionRule rule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);

        Integer baseCommission = BigDecimal.valueOf(salesValue)
                .multiply(rule.getPercentage())
                .divide(BigDecimal.valueOf(100))
                .intValue();

        Integer bonusCommission = rule.getBonusValue();

        Integer totalCommissionOfProductType = baseCommission + bonusCommission;

        return new CalculationDetails()
                .productType(productType)
                .salesValueOfProductType(salesValue)
                .baseCommissionAmount(baseCommission)
                .bonusCommissionAmount(bonusCommission)
                .totalCommissionAmountOfProductType(totalCommissionOfProductType);
    }

    private void addToResultLists(String employeeId, Integer totalCommissionAmount) {
        resultList.add(new CommissionData()
                .employeeId(employeeId)
                .commissionAmount(totalCommissionAmount));

        resultListWithDetails.add(new CommissionDataDetailed()
                .employeeId(employeeId)
                .totalCommissionAmount(totalCommissionAmount)
                .calculationDetails(calculationDetailsPerEmployee));
    }

}
