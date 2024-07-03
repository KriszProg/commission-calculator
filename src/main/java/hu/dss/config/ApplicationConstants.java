package hu.dss.config;

import java.math.BigDecimal;

public final class ApplicationConstants {
    private ApplicationConstants() {}

    // General constants
    public static final String LINE_SEPARATOR = "-".repeat(20) + "\n";

    // CommissionRule related constants
    public static final BigDecimal DEFAULT_PERCENTAGE = new BigDecimal(1);

    // SalesData validation related constants
    public static final long EXCEPTED_NUMBER_OF_DATA_PER_LINE = 3;

    // XML generation related constants
    public static final String XML_BASE_PATH = "C:/commission-report/";
    public static final String COMMISSION_BY_EMPLOYEE_XML_NAME = "commission-by-employee.xml";
    public static final String COMMISSION_BY_EMPLOYEE_DETAILED_XML_NAME = "commission-by-employee-detailed.xml";
    public static final String COMMISSION_BY_PRODUCT_TYPE_XML_NAME = "commission-by-product-type.xml";
    public static final String COMMISSION_BY_PRODUCT_TYPE_DETAILED_XML_NAME = "commission-by-product-type-detailed.xml";
    public static final String COMMISSION_BY_EMPLOYEE_XML_FULL_PATH = XML_BASE_PATH + COMMISSION_BY_EMPLOYEE_XML_NAME;
    public static final String COMMISSION_BY_EMPLOYEE_DETAILED_XML_FULL_PATH = XML_BASE_PATH + COMMISSION_BY_EMPLOYEE_DETAILED_XML_NAME;
    public static final String COMMISSION_BY_PRODUCT_TYPE_XML_FULL_PATH = XML_BASE_PATH + COMMISSION_BY_PRODUCT_TYPE_XML_NAME;
    public static final String COMMISSION_BY_PRODUCT_TYPE_DETAILED_XML_FULL_PATH = XML_BASE_PATH + COMMISSION_BY_PRODUCT_TYPE_DETAILED_XML_NAME;

}

