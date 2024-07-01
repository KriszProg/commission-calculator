package hu.dss.service;

import hu.dss.util.Message;
import hu.dss.model.CommissionData;
import hu.dss.model.xmlwrapper.CommissionDataListWrapper;
import hu.dss.model.CommissionDataDetailed;
import hu.dss.model.xmlwrapper.CommissionDataDetailedListWrapper;
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
    public static final String BASE_FILE_PATH = "C:/commission-report/";
    public static final String COMMISSION_REPORT_FILE_PATH = BASE_FILE_PATH + "commission-report.xml";
    public static final String COMMISSION_REPORT_DETAILED_FILE_PATH = BASE_FILE_PATH + "commission-report-detailed.xml";

    @Override
    public void generateCommissionReportXml(List<CommissionData> commissionList) {
        CommissionDataListWrapper wrapper = new CommissionDataListWrapper();
        wrapper.setCommissions(commissionList);
        generateXml(wrapper, CommissionDataListWrapper.class, COMMISSION_REPORT_FILE_PATH);
    }

    @Override
    public void generateCommissionReportDetailedXml(List<CommissionDataDetailed> commissionListWithDetails) {
        CommissionDataDetailedListWrapper wrapper = new CommissionDataDetailedListWrapper();
        wrapper.setCommissions(commissionListWithDetails);
        generateXml(wrapper, CommissionDataDetailedListWrapper.class, COMMISSION_REPORT_DETAILED_FILE_PATH);
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
