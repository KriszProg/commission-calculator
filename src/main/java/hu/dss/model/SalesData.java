package hu.dss.model;

public class SalesData {
    private ProductType productType;
    private String employeeId;
    private Integer salesValue;

    public SalesData() {}

    public SalesData(ProductType productType, String employeeId, Integer salesValue) {
        this.productType = productType;
        this.employeeId = employeeId;
        this.salesValue = salesValue;
    }

    public ProductType getProductType() {
        return productType;
    }

    public SalesData productType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public SalesData employeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Integer getSalesValue() {
        return salesValue;
    }

    public SalesData salesValue(Integer salesValue) {
        this.salesValue = salesValue;
        return this;
    }

    @Override
    public String toString() {
        return "SalesData{" +
                "productType=" + productType +
                ", employeeId='" + employeeId + '\'' +
                ", salesValue=" + salesValue +
                '}';
    }

}
