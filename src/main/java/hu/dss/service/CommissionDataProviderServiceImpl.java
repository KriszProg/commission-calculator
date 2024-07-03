package hu.dss.service;

import hu.dss.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommissionDataProviderServiceImpl implements CommissionDataProviderService {

    private final SalesDataService salesDataService;
    private final CommissionCalculatorService commissionCalculatorService;
    private final List<CommissionItem> commissionItems = new ArrayList<>();

    public CommissionDataProviderServiceImpl(SalesDataService salesDataService, CommissionCalculatorService commissionCalculatorService) {
        this.salesDataService = salesDataService;
        this.commissionCalculatorService = commissionCalculatorService;
    }

    @Override
    public List<CommissionDataByEmployee> getCommissionDataByEmployeeList() {
        initCommissionItemsIfEmpty();
        return getCommissionDataByEmployeeList(commissionItems);
    }

    @Override
    public List<CommissionDataByEmployeeDetailed> getCommissionDataByEmployeeDetailedList() {
        initCommissionItemsIfEmpty();
        return getCommissionDataByEmployeeDetailedList(commissionItems);
    }

    @Override
    public List<CommissionDataByProductType> getCommissionDataByProductTypeList() {
        initCommissionItemsIfEmpty();
        return getCommissionDataByProductTypeList(commissionItems);
    }

    @Override
    public List<CommissionDataByProductTypeDetailed> getCommissionDataByProductTypeDetailedList() {
        initCommissionItemsIfEmpty();
        return getCommissionDataByProductTypeDetailedList(commissionItems);
    }

    private void initCommissionItemsIfEmpty() {
        if (commissionItems.isEmpty()) {
            initCommissionItems();
        }
    }

    private void initCommissionItems() {
        List<SalesData> allSalesData = salesDataService.getAllSalesData();

        for (Employee employee : Employee.values()) {
            List<SalesData> salesDataFilteredByEmployee = getSalesDataFilteredByEmployee(allSalesData, employee);
            for (ProductType productType : ProductType.values()) {
                Integer totalSalesValueOfProductType = getTotalSalesValueOfProductType(salesDataFilteredByEmployee, productType);
                CommissionItem commissionItem = commissionCalculatorService.getCommissionItem(employee, productType, totalSalesValueOfProductType);
                commissionItems.add(commissionItem);
            }
        }
    }

    private List<SalesData> getSalesDataFilteredByEmployee(List<SalesData> allSalesData, Employee employee) {
        return allSalesData.stream()
                .filter(salesData -> employee.equals(salesData.getEmployee()))
                .collect(Collectors.toList());
    }

    private Integer getTotalSalesValueOfProductType(List<SalesData> salesDataFilteredByEmployee, ProductType productType) {
        return salesDataFilteredByEmployee.stream()
                .filter(salesData -> productType.equals(salesData.getProductType()))
                .mapToInt(SalesData::getSalesValue)
                .sum();
    }

    private List<CommissionDataByEmployee> getCommissionDataByEmployeeList(List<CommissionItem> allCommissionItems) {
        List<CommissionDataByEmployee> resultList = new ArrayList<>();

        for (Employee employee : Employee.values()) {
            List<CommissionItem> itemsFilteredByEmployee = getCommissionItemsFilteredByEmployee(allCommissionItems, employee);
            Integer commissionAmount = getSummarizedCommissionAmount(itemsFilteredByEmployee);
            resultList.add(new CommissionDataByEmployee(commissionAmount, employee));
        }
        return resultList;
    }

    private List<CommissionDataByEmployeeDetailed> getCommissionDataByEmployeeDetailedList(List<CommissionItem> allCommissionItems) {
        List<CommissionDataByEmployeeDetailed> resultList = new ArrayList<>();

        for (Employee employee : Employee.values()) {
            List<CommissionItem> itemsFilteredByEmployee = getCommissionItemsFilteredByEmployee(allCommissionItems, employee);
            Integer commissionAmount = getSummarizedCommissionAmount(itemsFilteredByEmployee);
            resultList.add(new CommissionDataByEmployeeDetailed(commissionAmount, employee, itemsFilteredByEmployee));
        }
        return resultList;
    }

    private List<CommissionItem> getCommissionItemsFilteredByEmployee(List<CommissionItem> allCommissionItems, Employee employee) {
        return allCommissionItems.stream()
                .filter(item -> employee.equals(item.getEmployee()))
                .collect(Collectors.toList());
    }

    private List<CommissionDataByProductType> getCommissionDataByProductTypeList(List<CommissionItem> allCommissionItems) {
        List<CommissionDataByProductType> resultList = new ArrayList<>();

        for (ProductType productType : ProductType.values()) {
            List<CommissionItem> itemsFilteredByProductType = getCommissionItemsFilteredByProductType(allCommissionItems, productType);
            Integer commissionAmount = getSummarizedCommissionAmount(itemsFilteredByProductType);
            resultList.add(new CommissionDataByProductType(commissionAmount, productType));
        }
        return resultList;
    }

    private List<CommissionDataByProductTypeDetailed> getCommissionDataByProductTypeDetailedList(List<CommissionItem> allCommissionItems) {
        List<CommissionDataByProductTypeDetailed> resultList = new ArrayList<>();

        for (ProductType productType : ProductType.values()) {
            List<CommissionItem> itemsFilteredByProductType = getCommissionItemsFilteredByProductType(allCommissionItems, productType);
            Integer commissionAmount = getSummarizedCommissionAmount(itemsFilteredByProductType);
            resultList.add(new CommissionDataByProductTypeDetailed(commissionAmount, productType, itemsFilteredByProductType));
        }
        return resultList;
    }

    private List<CommissionItem> getCommissionItemsFilteredByProductType(List<CommissionItem> allCommissionItems, ProductType productType) {
        return allCommissionItems.stream()
                .filter(item -> productType.equals(item.getProductType()))
                .collect(Collectors.toList());
    }

    private Integer getSummarizedCommissionAmount(List<CommissionItem> filteredItems) {
        return filteredItems.stream()
                .mapToInt(CommissionItem::getTotalCommissionAmount)
                .sum();
    }

}
