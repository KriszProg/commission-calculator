package hu.dss.model;

import java.util.Arrays;

public enum ProductType {
    A("A"),
    B("B"),
    C("C");

    private final String code;


    ProductType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ProductType getProductTypeByCode(String code) {
        return Arrays.stream(ProductType.values())
                .filter(type -> type.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

}
