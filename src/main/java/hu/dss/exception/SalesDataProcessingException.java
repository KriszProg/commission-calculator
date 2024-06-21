package hu.dss.exception;

import hu.dss.util.Message;

import java.util.List;
import java.util.Map;

public class SalesDataProcessingException extends /*Exception*/ RuntimeException {

    private static final String LINE_SEPARATOR = "-".repeat(20) + "\n";

    private final Map<Integer, List<String>> errorMap;

    public SalesDataProcessingException(Map<Integer, List<String>> errorMap) {
        this.errorMap = errorMap;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(Message.ERRORS_FOUND_DURING_FILE_PROCESSING.getMessage()).append("\n");
        sb.append(LINE_SEPARATOR);
        for (Map.Entry<Integer, List<String>> entry : errorMap.entrySet()) {
            sb.append("line_").append(entry.getKey()).append(":\n");
            for (String error : entry.getValue()) {
                sb.append(error).append("\n");
            }
            sb.append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

}
