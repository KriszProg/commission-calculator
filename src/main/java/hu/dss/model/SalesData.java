package hu.dss.model;

public class SalesData {
    private ProductType productType;
    private Employee employee;
    private Integer salesValue;

    public SalesData() {}

    public SalesData(ProductType productType, Employee employee, Integer salesValue) {
        this.productType = productType;
        this.employee = employee;
        this.salesValue = salesValue;
    }

    public ProductType getProductType() {
        return productType;
    }

    public SalesData productType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public SalesData employee(Employee employee) {
        this.employee = employee;
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
                ", employee='" + employee + '\'' +
                ", salesValue=" + salesValue +
                '}';
    }

}
