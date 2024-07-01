package hu.dss.util;

public enum Message {
    CALCULATE_COMMISSION("Calculate commission..."),
    CHOOSE_SEPARATOR("[STEP_2] Choose separator your sales report file contains:"),
    CHOOSE_SEPARATOR_ENTER_CHOICE("Enter your choice (p or s): "),
    CHOOSE_SEPARATOR_INVALID_CHOICE("Invalid choice. Please enter p or s"),
    CHOOSE_SEPARATOR_OPTION_PIPE("[p] pipe ('|')"),
    CHOOSE_SEPARATOR_OPTION_SEMICOLON("[s] semicolon (';')"),
    ENTER_FILE_PATH("[STEP_1] Enter the full filepath of your sales report file (example: C:\\reports\\sales-report.txt) and hit Enter:"),
    ERROR_INVALID_EMPLOYEE_ID("[ERROR] Invalid employee id!"),
    ERROR_INVALID_LINE_CONTENT("[ERROR] Invalid line content (expected exactly 3 data per line)!"),
    ERROR_INVALID_PRODUCT_TYPE("[ERROR] Invalid product type!"),
    ERROR_INVALID_SALES_VALUE("[ERROR] Invalid sales value (sales value should be greater then 0)!"),
    ERROR_INVALID_SALES_VALUE_FORMAT("[ERROR] Invalid sales value format!"),
    ERROR_INVALID_SEPARATOR("[ERROR] Invalid separator!"),
    ERRORS_FOUND_DURING_FILE_PROCESSING("Errors found during file processing!"),
    INITIALIZE_COMMISSION_RULES("Initialize commission rules..."),
    INVALID_FILE_PATH("Invalid file path! Please try again."),
    LINE_SEPARATOR("=".repeat(45)),
    LOADING_SALES_DATA_FROM_FILE_PATH("Loading SalesData from {0}..."),
    PROVIDE_SETUP("[SETUP] Please provide setups in 2 steps..."),
    SETUPS_COMPLETED("Setups completed successfully!"),
    START_EXECUTION("Start execution..."),
    START_GENERATING_COMMISSION_REPORT_XML("Start generating commission-report.xml..."),
    START_GENERATING_COMMISSION_REPORT_DETAILED_XML("Start generating commission-report-detailed.xml..."),
    XML_FILE_CREATED_SUCCESSFULLY_AT("XML file created successfully at: {0}");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
