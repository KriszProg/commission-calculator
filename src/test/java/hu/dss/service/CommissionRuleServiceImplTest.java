package hu.dss.service;


import hu.dss.model.CommissionRule;
import hu.dss.model.ProductType;
import org.junit.jupiter.api.*;

import java.util.Map;

import static hu.dss.config.ApplicationConstants.DEFAULT_PERCENTAGE;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CommissionRuleServiceImplTest {

    private CommissionRuleService ruleService;

    private final Map<String, CommissionRule> commissionRuleMap = Map.of(
            "A1", new CommissionRule(ProductType.A, 0, 9999999, DEFAULT_PERCENTAGE, 0),
            "A2", new CommissionRule(ProductType.A, 10000000, 19999999, DEFAULT_PERCENTAGE, 25000),
            "A3", new CommissionRule(ProductType.A, 20000000, null, DEFAULT_PERCENTAGE, 40000),
            "B1", new CommissionRule(ProductType.B, 0, 7999999, DEFAULT_PERCENTAGE, 0),
            "B2", new CommissionRule(ProductType.B, 8000000, 15999999, DEFAULT_PERCENTAGE, 30000),
            "B3", new CommissionRule(ProductType.B, 16000000, null, DEFAULT_PERCENTAGE, 50000),
            "C1", new CommissionRule(ProductType.C, 0, 4999999, DEFAULT_PERCENTAGE, 0),
            "C2", new CommissionRule(ProductType.C, 5000000, 9999999, DEFAULT_PERCENTAGE, 20000),
            "C3", new CommissionRule(ProductType.C, 10000000, null, DEFAULT_PERCENTAGE, 40000)
    );

    @BeforeAll
    void init() {
        this.ruleService = new CommissionRuleServiceImpl();
        ruleService.createCommissionRules();
    }

    @Test
    @Order(1)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualLowerValueOfA1Rule_ReturnA1Rule() {
        ProductType productType = ProductType.A;
        Integer salesValue = 0;

        String expectedRuleMapKey = "A1";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(2)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualUpperValueOfA1Rule_ReturnA1Rule() {
        ProductType productType = ProductType.A;
        Integer salesValue = 9999999;

        String expectedRuleMapKey = "A1";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(3)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualLowerValueOfA2Rule_ReturnA2Rule() {
        ProductType productType = ProductType.A;
        Integer salesValue = 10000000;

        String expectedRuleMapKey = "A2";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(4)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualUpperValueOfA2Rule_ReturnA2Rule() {
        ProductType productType = ProductType.A;
        Integer salesValue = 19999999;

        String expectedRuleMapKey = "A2";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(5)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualLowerValueOfA3Rule_ReturnA3Rule() {
        ProductType productType = ProductType.A;
        Integer salesValue = 20000000;
        String expectedRuleMapKey = "A3";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(6)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsGreaterThanLowerValueOfA3Rule_ReturnA3Rule() {
        ProductType productType = ProductType.A;
        Integer salesValue = 25000000;
        String expectedRuleMapKey = "A3";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(7)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualLowerValueOfB1Rule_ReturnB1Rule() {
        ProductType productType = ProductType.B;
        Integer salesValue = 0;

        String expectedRuleMapKey = "B1";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(8)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualUpperValueOfB1Rule_ReturnB1Rule() {
        ProductType productType = ProductType.B;
        Integer salesValue = 7999999;

        String expectedRuleMapKey = "B1";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(9)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualLowerValueOfB2Rule_ReturnB2Rule() {
        ProductType productType = ProductType.B;
        Integer salesValue = 8000000;

        String expectedRuleMapKey = "B2";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(10)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualUpperValueOfB2Rule_ReturnB2Rule() {
        ProductType productType = ProductType.B;
        Integer salesValue = 15999999;

        String expectedRuleMapKey = "B2";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(11)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualLowerValueOfB3Rule_ReturnB3Rule() {
        ProductType productType = ProductType.B;
        Integer salesValue = 16000000;
        String expectedRuleMapKey = "B3";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(12)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsGreaterThanLowerValueOfB3Rule_ReturnB3Rule() {
        ProductType productType = ProductType.B;
        Integer salesValue = 25000000;
        String expectedRuleMapKey = "B3";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }



    @Test
    @Order(13)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualLowerValueOfC1Rule_ReturnC1Rule() {
        ProductType productType = ProductType.C;
        Integer salesValue = 0;

        String expectedRuleMapKey = "C1";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(14)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualUpperValueOfC1Rule_ReturnC1Rule() {
        ProductType productType = ProductType.C;
        Integer salesValue = 4999999;

        String expectedRuleMapKey = "C1";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(15)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualLowerValueOfC2Rule_ReturnC2Rule() {
        ProductType productType = ProductType.C;
        Integer salesValue = 5000000;

        String expectedRuleMapKey = "C2";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(16)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualUpperValueOfC2Rule_ReturnC2Rule() {
        ProductType productType = ProductType.C;
        Integer salesValue = 9999999;

        String expectedRuleMapKey = "C2";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(17)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsEqualLowerValueOfC3Rule_ReturnC3Rule() {
        ProductType productType = ProductType.C;
        Integer salesValue = 10000000;
        String expectedRuleMapKey = "C3";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

    @Test
    @Order(18)
    void testFindRuleByProductTypeAndSalesValue_WhenSalesValueIsGreaterThanLowerValueOfC3Rule_ReturnC3Rule() {
        ProductType productType = ProductType.C;
        Integer salesValue = 25000000;
        String expectedRuleMapKey = "C3";

        CommissionRule actualCommissionRule = ruleService.findRuleByProductTypeAndSalesValue(productType, salesValue);
        assertEquals(commissionRuleMap.get(expectedRuleMapKey), actualCommissionRule);
    }

}