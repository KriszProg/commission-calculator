package hu.dss.exception;

public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof SalesDataProcessingException) {
            handleSalesDataProcessingException((SalesDataProcessingException) e);
        } else {
            handleGenericException(e);
        }
    }

    private void handleSalesDataProcessingException(SalesDataProcessingException e) {
        System.out.println(e.getMessage());
    }

    private void handleGenericException(Throwable e) {
        e.printStackTrace();
    }

}
