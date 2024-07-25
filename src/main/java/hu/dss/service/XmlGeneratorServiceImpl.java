package hu.dss.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import static hu.dss.config.ApplicationConstants.*;

public class XmlGeneratorServiceImpl implements XmlGeneratorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlGeneratorServiceImpl.class);
    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public void generateCommissionByEmployeeXml(List<CommissionDataByEmployee> commissionDataByEmployeeList) {
        CommissionDataByEmployeeListWrapper wrapper = new CommissionDataByEmployeeListWrapper();
        wrapper.setCommissions(commissionDataByEmployeeList);
        generateXml(wrapper, COMMISSION_BY_EMPLOYEE_XML_FULL_PATH);
    }

    @Override
    public void generateCommissionByEmployeeDetailedXml(List<CommissionDataByEmployeeDetailed> commissionDataByEmployeeDetailedList) {
        CommissionDataByEmployeeDetailedListWrapper wrapper = new CommissionDataByEmployeeDetailedListWrapper();
        wrapper.setCommissions(commissionDataByEmployeeDetailedList);
        generateXml(wrapper, COMMISSION_BY_EMPLOYEE_DETAILED_XML_FULL_PATH);
    }

    @Override
    public void generateCommissionByProductTypeXml(List<CommissionDataByProductType> commissionDataByProductTypeList) {
        CommissionDataByProductTypeListWrapper wrapper = new CommissionDataByProductTypeListWrapper();
        wrapper.setCommissions(commissionDataByProductTypeList);
        generateXml(wrapper, COMMISSION_BY_PRODUCT_TYPE_XML_FULL_PATH);
    }

    @Override
    public void generateCommissionByProductTypeDetailedXml(List<CommissionDataByProductTypeDetailed> commissionDataByProductTypeDetailedList) {
        CommissionDataByProductTypeDetailedListWrapper wrapper = new CommissionDataByProductTypeDetailedListWrapper();
        wrapper.setCommissions(commissionDataByProductTypeDetailedList);
        generateXml(wrapper, COMMISSION_BY_PRODUCT_TYPE_DETAILED_XML_FULL_PATH);
    }

    private <T> void generateXml(T wrapper, String filePath) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();

            xmlMapper.writeValue(file, wrapper);

            LOGGER.info(MessageFormat.format(Message.XML_FILE_CREATED_SUCCESSFULLY_AT.getMessage(), file.getAbsolutePath()));
        } catch (IOException e) {
            LOGGER.error("Error generating XML file", e);
        }
    }

}
