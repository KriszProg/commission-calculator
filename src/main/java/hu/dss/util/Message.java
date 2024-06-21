package hu.dss.util;

public enum Message {
    CALCULATE_COMMISSION("[INFO] Calculate commission..."),
    CHOOSE_SEPARATOR("[STEP_2] Choose separator your sales report file contains:"),
    CHOOSE_SEPARATOR_ENTER_CHOICE("Enter your choice (p or s): "),
    CHOOSE_SEPARATOR_INVALID_CHOICE("[ERROR] Invalid choice. Please enter p or s"),
    CHOOSE_SEPARATOR_OPTION_PIPE("[p] pipe ('|')"),
    CHOOSE_SEPARATOR_OPTION_SEMICOLON("[s] semicolon (';')"),
    ENTER_FILE_PATH("[STEP_1] Enter the full filepath of your sales report file (example: C:\\reports\\sales-report.txt) and hit Enter:"),
    ERRORS_FOUND_DURING_FILE_PROCESSING("[ERROR] Errors found during file processing!"),
    INITIALIZE_COMMISSION_RULES("[INFO] Initialize commission rules..."),
    INVALID_EMPLOYEE_ID("[ERROR] Invalid employee id!"),
    INVALID_FILE_PATH("[ERROR] Invalid file path! Please try again."),
    INVALID_LINE_CONTENT("[ERROR] Invalid line content (expected exactly 3 data per line)!"),
    INVALID_PRODUCT_TYPE("[ERROR] Invalid product type!"),
    INVALID_SALES_VALUE("[ERROR] Invalid sales value (sales value should be greater then 0)!"),
    INVALID_SALES_VALUE_FORMAT("[ERROR] Invalid sales value format!"),
    INVALID_SEPARATOR("[ERROR] Invalid separator!"),
    LINE_SEPARATOR("=".repeat(45)),
    LOADING_SALES_DATA_FROM_FILE_PATH("[INFO] Loading SalesData from {0}..."),
    PROVIDE_SETUP("[SETUP] Please provide setups in 2 steps..."),
    SETUPS_COMPLETED("[INFO] Setups completed successfully!"),
    START_EXECUTION("[INFO] Start execution..."),
    START_GENERATING_COMMISSION_REPORT_XML("[INFO] Start generating commission-report.xml..."),
    START_GENERATING_COMMISSION_REPORT_DETAILED_XML("[INFO] Start generating commission-report-detailed.xml..."),
    XML_FILE_CREATED_SUCCESSFULLY_AT("[INFO] XML file created successfully at: {0}");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
