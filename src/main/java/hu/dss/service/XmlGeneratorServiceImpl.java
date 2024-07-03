package hu.dss.service;

import hu.dss.model.CommissionDataByEmployee;
import hu.dss.model.CommissionDataByEmployeeDetailed;
import hu.dss.model.CommissionDataByProductType;
import hu.dss.model.CommissionDataByProductTypeDetailed;
import hu.dss.model.xmlwrapper.CommissionDataByEmployeeDetailedListWrapper;
import hu.dss.model.xmlwrapper.CommissionDataByEmployeeListWrapper;
import hu.dss.model.xmlwrapper.CommissionDataByProductTypeDetailedListWrapper;
import hu.dss.model.xmlwrapper.CommissionDataByProductTypeListWrapper;
import hu.dss.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.MessageFormat;
import java.util.List;

public class XmlGeneratorServiceImpl implements XmlGeneratorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlGeneratorServiceImpl.class);
    private static final String XML_BASE_PATH = "C:/commission-report/";
    public static final String COMMISSION_BY_EMPLOYEE_XML_NAME = "commission-by-employee.xml";
    public static final String COMMISSION_BY_EMPLOYEE_DETAILED_XML_NAME = "commission-by-employee-detailed.xml";
    public static final String COMMISSION_BY_PRODUCT_TYPE_XML_NAME = "commission-by-product-type.xml";
    public static final String COMMISSION_BY_PRODUCT_TYPE_DETAILED_XML_NAME = "commission-by-product-type-detailed.xml";
    private static final String COMMISSION_BY_EMPLOYEE_XML_FULL_PATH = XML_BASE_PATH + COMMISSION_BY_EMPLOYEE_XML_NAME;
    private static final String COMMISSION_BY_EMPLOYEE_DETAILED_XML_FULL_PATH = XML_BASE_PATH + COMMISSION_BY_EMPLOYEE_DETAILED_XML_NAME;
    private static final String COMMISSION_BY_PRODUCT_TYPE_XML_FULL_PATH = XML_BASE_PATH + COMMISSION_BY_PRODUCT_TYPE_XML_NAME;
    private static final String COMMISSION_BY_PRODUCT_TYPE_DETAILED_XML_FULL_PATH = XML_BASE_PATH + COMMISSION_BY_PRODUCT_TYPE_DETAILED_XML_NAME;

    @Override
    public void generateCommissionByEmployeeXml(List<CommissionDataByEmployee> commissionDataByEmployeeList) {
        CommissionDataByEmployeeListWrapper wrapper = new CommissionDataByEmployeeListWrapper();
        wrapper.setCommissions(commissionDataByEmployeeList);
        generateXml(wrapper, CommissionDataByEmployeeListWrapper.class, COMMISSION_BY_EMPLOYEE_XML_FULL_PATH);
    }

    @Override
    public void generateCommissionByEmployeeDetailedXml(List<CommissionDataByEmployeeDetailed> commissionDataByEmployeeDetailedList) {
        CommissionDataByEmployeeDetailedListWrapper wrapper = new CommissionDataByEmployeeDetailedListWrapper();
        wrapper.setCommissions(commissionDataByEmployeeDetailedList);
        generateXml(wrapper, CommissionDataByEmployeeDetailedListWrapper.class, COMMISSION_BY_EMPLOYEE_DETAILED_XML_FULL_PATH);
    }

    @Override
    public void generateCommissionByProductTypeXml(List<CommissionDataByProductType> commissionDataByProductTypeList) {
        CommissionDataByProductTypeListWrapper wrapper = new CommissionDataByProductTypeListWrapper();
        wrapper.setCommissions(commissionDataByProductTypeList);
        generateXml(wrapper, CommissionDataByProductTypeListWrapper.class, COMMISSION_BY_PRODUCT_TYPE_XML_FULL_PATH);
    }

    @Override
    public void generateCommissionByProductTypeDetailedXml(List<CommissionDataByProductTypeDetailed> commissionDataByProductTypeDetailedList) {
        CommissionDataByProductTypeDetailedListWrapper wrapper = new CommissionDataByProductTypeDetailedListWrapper();
        wrapper.setCommissions(commissionDataByProductTypeDetailedList);
        generateXml(wrapper, CommissionDataByProductTypeDetailedListWrapper.class, COMMISSION_BY_PRODUCT_TYPE_DETAILED_XML_FULL_PATH);
    }

    private <T> void generateXml(T wrapper, Class<T> wrapperClass, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(wrapperClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File file = new File(filePath);
            file.getParentFile().mkdirs();

            marshaller.marshal(wrapper, file);

            LOGGER.info(MessageFormat.format(Message.XML_FILE_CREATED_SUCCESSFULLY_AT.getMessage(), file.getAbsolutePath()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
