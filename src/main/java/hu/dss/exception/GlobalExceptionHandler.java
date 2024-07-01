package hu.dss.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof SalesDataProcessingException) {
            handleSalesDataProcessingException((SalesDataProcessingException) e);
        } else {
            handleGenericException(e);
        }
    }

    private void handleSalesDataProcessingException(SalesDataProcessingException e) {
        LOGGER.error(e.getMessage());
    }

    private void handleGenericException(Throwable e) {
        e.printStackTrace();
    }

}
