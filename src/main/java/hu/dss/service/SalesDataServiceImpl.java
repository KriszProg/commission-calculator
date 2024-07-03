package hu.dss.service;

import hu.dss.data.Database;
import hu.dss.model.SalesData;

import java.util.List;

public class SalesDataServiceImpl implements SalesDataService {

    private final Database database = Database.getInstance();

    @Override
    public List<SalesData> getAllSalesData() {
        return database.getSalesDataList();
    }

}
