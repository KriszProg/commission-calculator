package hu.dss.controller;

import hu.dss.util.Message;
import hu.dss.service.*;
import hu.dss.util.Separator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class ProcessController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessController.class);

    private final InputService inputService;
    private final CommissionRuleService ruleService;
    private final SalesDataProcessorService salesDataProcessorService;
    private final SalesDataService salesDataService;
    private final CommissionCalculatorService commissionCalculatorService;
    private final XmlGeneratorService xmlGeneratorService;

    private String filePath;
    private Separator separator;

    public ProcessController(InputService inputService, CommissionRuleService ruleService,
                             SalesDataProcessorService salesDataProcessorService, SalesDataService salesDataService,
                             CommissionCalculatorService commissionCalculatorService, XmlGeneratorService xmlGeneratorService) {
        this.inputService = inputService;
        this.ruleService = ruleService;
        this.salesDataProcessorService = salesDataProcessorService;
        this.salesDataService = salesDataService;
        this.commissionCalculatorService = commissionCalculatorService;
        this.xmlGeneratorService = xmlGeneratorService;
    }

    public void executeProcess() {
        System.out.println(Message.LINE_SEPARATOR.getMessage());
        System.out.println(Message.PROVIDE_SETUP.getMessage());
        System.out.println(Message.LINE_SEPARATOR.getMessage());
        initFilePath();
        initSeparator();
        System.out.println(Message.LINE_SEPARATOR.getMessage());
        System.out.println(Message.SETUPS_COMPLETED.getMessage());
        System.out.println(Message.LINE_SEPARATOR.getMessage());

        LOGGER.info(Message.START_EXECUTION.getMessage());
        LOGGER.info(MessageFormat.format(Message.LOADING_SALES_DATA_FROM_FILE_PATH.getMessage(), filePath));
        salesDataProcessorService.readAndProcessSalesData(filePath, separator);

        LOGGER.info(Message.INITIALIZE_COMMISSION_RULES.getMessage());
        ruleService.createCommissionRules();

        LOGGER.info(Message.CALCULATE_COMMISSION.getMessage());
        commissionCalculatorService.calculateCommission(salesDataService.getSalesDataList());

        LOGGER.info(Message.START_GENERATING_COMMISSION_REPORT_XML.getMessage());
        xmlGeneratorService.generateCommissionReportXml(commissionCalculatorService.getResultList());

        LOGGER.info(Message.START_GENERATING_COMMISSION_REPORT_DETAILED_XML.getMessage());
        xmlGeneratorService.generateCommissionReportDetailedXml(commissionCalculatorService.getResultListWithDetails());
    }

    private void initFilePath() {
        this.filePath = inputService.getValidFilePathFromUser();
    }

    private void initSeparator() {
        this.separator = inputService.getSeparatorChoiceFromUser();
    }

}
