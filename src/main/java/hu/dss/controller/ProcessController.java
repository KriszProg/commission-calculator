package hu.dss.controller;

import hu.dss.model.CommissionDataByEmployee;
import hu.dss.model.CommissionDataByEmployeeDetailed;
import hu.dss.model.CommissionDataByProductType;
import hu.dss.model.CommissionDataByProductTypeDetailed;
import hu.dss.util.Message;
import hu.dss.service.*;
import hu.dss.util.Separator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.List;

import static hu.dss.config.ApplicationConstants.*;

public class ProcessController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessController.class);

    private final InputService inputService;
    private final SalesDataProcessorService salesDataProcessorService;
    private final CommissionRuleService ruleService;
    private final CommissionDataProviderService commissionDataProviderService;
    private final XmlGeneratorService xmlGeneratorService;

    private String filePath;
    private Separator separator;

    public ProcessController(InputService inputService, SalesDataProcessorService salesDataProcessorService,
                             CommissionRuleService ruleService,
                             CommissionDataProviderService commissionDataProviderService,
                             XmlGeneratorService xmlGeneratorService) {
        this.inputService = inputService;
        this.salesDataProcessorService = salesDataProcessorService;
        this.ruleService = ruleService;
        this.commissionDataProviderService = commissionDataProviderService;
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

        LOGGER.info(MessageFormat.format(Message.COLLECT_COMMISSION_DATA_FOR_XML.getMessage(), COMMISSION_BY_EMPLOYEE_XML_NAME));
        List<CommissionDataByEmployee> commissionDataByEmployeeList = commissionDataProviderService.getCommissionDataByEmployeeList();
        LOGGER.info(MessageFormat.format(Message.START_GENERATING_XML.getMessage(), COMMISSION_BY_EMPLOYEE_XML_NAME));
        xmlGeneratorService.generateCommissionByEmployeeXml(commissionDataByEmployeeList);

        LOGGER.info(MessageFormat.format(Message.COLLECT_COMMISSION_DATA_FOR_XML.getMessage(), COMMISSION_BY_EMPLOYEE_DETAILED_XML_NAME));
        List<CommissionDataByEmployeeDetailed> commissionDataByEmployeeDetailedList = commissionDataProviderService.getCommissionDataByEmployeeDetailedList();
        LOGGER.info(MessageFormat.format(Message.START_GENERATING_XML.getMessage(), COMMISSION_BY_EMPLOYEE_DETAILED_XML_NAME));
        xmlGeneratorService.generateCommissionByEmployeeDetailedXml(commissionDataByEmployeeDetailedList);

        LOGGER.info(MessageFormat.format(Message.COLLECT_COMMISSION_DATA_FOR_XML.getMessage(), COMMISSION_BY_PRODUCT_TYPE_XML_NAME));
        List<CommissionDataByProductType> commissionDataByProductTypeList = commissionDataProviderService.getCommissionDataByProductTypeList();
        LOGGER.info(MessageFormat.format(Message.START_GENERATING_XML.getMessage(), COMMISSION_BY_PRODUCT_TYPE_XML_NAME));
        xmlGeneratorService.generateCommissionByProductTypeXml(commissionDataByProductTypeList);

        LOGGER.info(MessageFormat.format(Message.COLLECT_COMMISSION_DATA_FOR_XML.getMessage(), COMMISSION_BY_PRODUCT_TYPE_DETAILED_XML_NAME));
        List<CommissionDataByProductTypeDetailed> commissionDataByProductTypeDetailedList = commissionDataProviderService.getCommissionDataByProductTypeDetailedList();
        LOGGER.info(MessageFormat.format(Message.START_GENERATING_XML.getMessage(), COMMISSION_BY_PRODUCT_TYPE_DETAILED_XML_NAME));
        xmlGeneratorService.generateCommissionByProductTypeDetailedXml(commissionDataByProductTypeDetailedList);
    }

    private void initFilePath() {
        this.filePath = inputService.getValidFilePathFromUser();
    }

    private void initSeparator() {
        this.separator = inputService.getSeparatorChoiceFromUser();
    }

}
