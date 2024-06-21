package hu.dss.util;

import hu.dss.model.ProductType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesDataValidator {

    private static final long EXCEPTED_NUMBER_OF_DATA_PER_LINE = 3;
    private static final String EMPLOYEE_ID_PATTERN = "Ü\\d+";

    public boolean isLineSeparatorValid(String line, Separator separator) {
        return line.contains(separator.getSeparatorString());
    }

    public boolean isLineContentValid(String line, Separator separator) {
        return line.split(separator.getSeparatorRegex()).length == EXCEPTED_NUMBER_OF_DATA_PER_LINE;
    }

    public List<String> validateLineDetailsAndGetErrors(String line, Separator separator) {
        List<String> errors = new ArrayList<>();
        String[] parts = line.split(separator.getSeparatorRegex());

        if (!isProductTypeValid(parts[0])) {
            errors.add(Message.INVALID_PRODUCT_TYPE.getMessage());
        }
        if (!isEmployeeIdValid(parts[1])) {
            errors.add(Message.INVALID_EMPLOYEE_ID.getMessage());
        }

        Message salesValueErrorMessage = validateSalesValueAndGetErrorMessage(parts[2]);
        if (salesValueErrorMessage != null) {
            errors.add(salesValueErrorMessage.getMessage());
        }

        return errors;
    }

    private boolean isProductTypeValid(String productType) {
        return ProductType.getProductTypeByCode(productType) != null;
    }

    private boolean isEmployeeIdValid(String employeeId) {
        Pattern employeeIdPattern = Pattern.compile(EMPLOYEE_ID_PATTERN);
        Matcher matcher = employeeIdPattern.matcher(employeeId);
        return matcher.matches();
    }

    private Message validateSalesValueAndGetErrorMessage(String salesValueString) {
        try {
            Integer salesValue = Integer.parseInt(salesValueString.trim());
            if (salesValue <= 0) {
                return Message.INVALID_SALES_VALUE;
            }
        } catch (NumberFormatException e) {
            return Message.INVALID_SALES_VALUE_FORMAT;
        }
        return null;
    }

}
