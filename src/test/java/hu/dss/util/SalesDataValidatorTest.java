package hu.dss.util;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SalesDataValidatorTest {

    private final SalesDataValidator validator = new SalesDataValidator();

    @Test
    @Order(1)
    void testIsLineSeparatorValid_WhenSeparatorNotMatch_ReturnFalse() {
        Separator separator = Separator.PIPE;
        String line = "A;Ü1;10000";
        assertFalse(validator.isLineSeparatorValid(line, separator));
    }

    @Test
    @Order(2)
    void testIsLineSeparatorValid_WhenSeparatorMatch_ReturnTrue() {
        Separator separator = Separator.PIPE;
        String line = "A|Ü1|10000";
        assertTrue(validator.isLineSeparatorValid(line, separator));
    }

    @Test
    @Order(3)
    void testIsLineContentValid_WhenLineContainsLessElementAsExpected_ReturnFalse() {
        Separator separator = Separator.PIPE;
        String line = "A|Ü1";
        assertFalse(validator.isLineContentValid(line, separator));
    }

    @Test
    @Order(4)
    void testIsLineContentValid_WhenLineContainsMoreElementAsExpected_ReturnFalse() {
        Separator separator = Separator.PIPE;
        String line = "A|Ü1|10000|extra";
        assertFalse(validator.isLineContentValid(line, separator));
    }

    @Test
    @Order(5)
    void testIsLineContentValid_WhenLineContainsExpectedNumberOfElement_ReturnTrue() {
        Separator separator = Separator.PIPE;
        String line = "A|Ü1|10000";
        assertTrue(validator.isLineContentValid(line, separator));
    }

    @Test
    @Order(6)
    void testValidateLineDetailsAndGetErrors_WhenAllElementIsInvalid_ReturnErrors() {
        String line = "Q|u1|1e00";
        Separator separator = Separator.PIPE;
        List<String> errors = validator.validateLineDetailsAndGetErrors(line, separator);
        assertEquals(3, errors.size());
        assertTrue(errors.contains(Message.INVALID_PRODUCT_TYPE.getMessage()));
        assertTrue(errors.contains(Message.INVALID_EMPLOYEE_ID.getMessage()));
        assertTrue(errors.contains(Message.INVALID_SALES_VALUE_FORMAT.getMessage()));
    }

    @Test
    @Order(7)
    void testValidateLineDetailsAndGetErrors_WhenEmployeeIdNotMatchWithPattern_ReturnErrors() {
        String line = "A|ü1|100000";
        Separator separator = Separator.PIPE;
        List<String> errors = validator.validateLineDetailsAndGetErrors(line, separator);
        assertEquals(1, errors.size());
        assertTrue(errors.contains(Message.INVALID_EMPLOYEE_ID.getMessage()));
    }

    @Test
    @Order(8)
    void testValidateLineDetailsAndGetErrors_WhenSalesValueEqualsZero_ReturnErrors() {
        String line = "A|Ü1|0";
        Separator separator = Separator.PIPE;
        List<String> errors = validator.validateLineDetailsAndGetErrors(line, separator);
        assertEquals(1, errors.size());
        assertTrue(errors.contains(Message.INVALID_SALES_VALUE.getMessage()));
    }

    @Test
    @Order(9)
    void testValidateLineDetailsAndGetErrors_WhenSalesValueLessThenZero_ReturnErrors() {
        String line = "A|Ü1|-1";
        Separator separator = Separator.PIPE;
        List<String> errors = validator.validateLineDetailsAndGetErrors(line, separator);
        assertEquals(1, errors.size());
        assertTrue(errors.contains(Message.INVALID_SALES_VALUE.getMessage()));
    }

}