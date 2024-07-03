package hu.dss.util;

import hu.dss.model.Employee;
import hu.dss.model.ProductType;

import java.util.ArrayList;
import java.util.List;

import static hu.dss.config.ApplicationConstants.EXCEPTED_NUMBER_OF_DATA_PER_LINE;

public class SalesDataValidator {

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
            errors.add(Message.ERROR_INVALID_PRODUCT_TYPE.getMessage());
        }
        if (!isEmployeeIdValid(parts[1])) {
            errors.add(Message.ERROR_INVALID_EMPLOYEE_ID.getMessage());
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
        return Employee.getEmployeeById(employeeId) != null;
    }

    private Message validateSalesValueAndGetErrorMessage(String salesValueString) {
        try {
            Integer salesValue = Integer.parseInt(salesValueString.trim());
            if (salesValue <= 0) {
                return Message.ERROR_INVALID_SALES_VALUE;
            }
        } catch (NumberFormatException e) {
            return Message.ERROR_INVALID_SALES_VALUE_FORMAT;
        }
        return null;
    }

}
