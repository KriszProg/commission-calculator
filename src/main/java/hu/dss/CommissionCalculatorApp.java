package hu.dss;


import hu.dss.controller.ProcessController;
import hu.dss.exception.GlobalExceptionHandler;
import hu.dss.service.*;
import hu.dss.util.SalesDataValidator;


public class CommissionCalculatorApp {

    public static void main( String[] args ) {

        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

        InputService inputService = new InputServiceImpl();
        SalesDataValidator validator = new SalesDataValidator();
        SalesDataProcessorService salesDataProcessorService = new SalesDataProcessorServiceImpl(validator);
        SalesDataService salesDataService = new SalesDataServiceImpl();
        CommissionRuleService ruleService = new CommissionRuleServiceImpl();
        CommissionCalculatorService commissionCalculatorService = new CommissionCalculatorServiceImpl(ruleService);
        CommissionDataProviderService commissionDataProviderService = new CommissionDataProviderServiceImpl(salesDataService, commissionCalculatorService);
        XmlGeneratorService xmlGeneratorService = new XmlGeneratorServiceImpl();
        ProcessController controller = new ProcessController(inputService, salesDataProcessorService, ruleService,
                commissionDataProviderService, xmlGeneratorService);

        controller.executeProcess();

    }

}
