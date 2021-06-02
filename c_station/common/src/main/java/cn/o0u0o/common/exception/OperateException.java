package cn.o0u0o.common.exception;

/**
 * @author Caleb Chen
 * @create 2021-06-02 20:08
 */
public class OperateException extends Exception {

    public OperateException() {
    }

    public OperateException(String message) {
        super(message);
    }

    public OperateException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperateException(Throwable cause) {
        super(cause);
    }

    protected OperateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
