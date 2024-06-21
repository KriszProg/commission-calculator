package hu.dss;


import hu.dss.controller.ProcessController;
import hu.dss.exception.GlobalExceptionHandler;
import hu.dss.service.*;
import hu.dss.util.SalesDataValidator;


public class CommissionCalculatorApp {

    public static void main( String[] args ) {

        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

        InputService inputService = new InputServiceImpl();
        CommissionRuleService ruleService = new CommissionRuleServiceImpl();
        SalesDataValidator validator = new SalesDataValidator();
        SalesDataProcessorService salesDataProcessorService = new SalesDataProcessorServiceImpl(validator);
        SalesDataService salesDataService = new SalesDataServiceImpl();
        CommissionCalculatorService commissionCalculatorService = new CommissionCalculatorServiceImpl(ruleService);
        XmlGeneratorService xmlGeneratorService = new XmlGeneratorServiceImpl();
        ProcessController controller = new ProcessController(inputService, ruleService, salesDataProcessorService,
                salesDataService, commissionCalculatorService, xmlGeneratorService);

        controller.executeProcess();

    }

}
