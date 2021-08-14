package cn.o0u0o.common.exception;

/**
 * @author Caleb Chen
 * @create 2021-06-02 20:10
 */
public class OtherException extends Exception {

    public OtherException() {
    }

    public OtherException(String message) {
        super(message);
    }

    public OtherException(String message, Throwable cause) {
        super(message, cause);
    }

    public OtherException(Throwable cause) {
        super(cause);
    }

    protected OtherException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
