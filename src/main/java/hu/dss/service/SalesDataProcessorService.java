package hu.dss.service;

import hu.dss.util.Separator;

public interface SalesDataProcessorService {

    void readAndProcessSalesData(String filePath, Separator separator);

}
