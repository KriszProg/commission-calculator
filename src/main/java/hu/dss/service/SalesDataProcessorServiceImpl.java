package hu.dss.service;

import hu.dss.data.Database;
import hu.dss.model.Employee;
import hu.dss.util.Message;
import hu.dss.exception.SalesDataProcessingException;
import hu.dss.model.ProductType;
import hu.dss.model.SalesData;
import hu.dss.util.SalesDataValidator;
import hu.dss.util.Separator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SalesDataProcessorServiceImpl implements SalesDataProcessorService {

    private final Database database;
    private final SalesDataValidator validator;
    private Map<Integer, List<String>> errorMap;
    private List<SalesData> salesDataList;

    public SalesDataProcessorServiceImpl(SalesDataValidator validator) {
        this.validator = validator;
        this.database  = Database.getInstance();
    }

    private void init() {
        this.errorMap = new LinkedHashMap<>();
        this.salesDataList = new ArrayList<>();
    }

    @Override
    public void readAndProcessSalesData(String filePath, Separator separator) {
        init();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                if (line.trim().isEmpty()) {
                    continue;
                }

                if (!validator.isLineSeparatorValid(line, separator)) {
                    errorMap.computeIfAbsent(lineNumber, k -> new ArrayList<>())
                            .add(Message.ERROR_INVALID_SEPARATOR.getMessage());
                    continue;
                }

                if (!validator.isLineContentValid(line, separator)) {
                    errorMap.computeIfAbsent(lineNumber, k -> new ArrayList<>())
                            .add(Message.ERROR_INVALID_LINE_CONTENT.getMessage());
                    continue;
                }

                List<String> lineDetailsErrorList = validator.validateLineDetailsAndGetErrors(line, separator);
                if (!lineDetailsErrorList.isEmpty()) {
                    errorMap.put(lineNumber, lineDetailsErrorList);
                    continue;
                }

                createSalesData(line, separator);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!errorMap.isEmpty()) {
            throw new SalesDataProcessingException(errorMap);
        }

        database.saveSalesDataList(salesDataList);
    }

    private void createSalesData(String line, Separator separator) {
        String[] parts = line.split(separator.getSeparatorRegex());
        SalesData salesData = new SalesData(
                ProductType.getProductTypeByCode(parts[0]),
                Employee.getEmployeeById(parts[1]),
                Integer.parseInt(parts[2].trim()));
        salesDataList.add(salesData);
    }

}
