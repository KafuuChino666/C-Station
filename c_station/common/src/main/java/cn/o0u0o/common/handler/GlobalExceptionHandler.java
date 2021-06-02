package cn.o0u0o.common.handler;

import cn.o0u0o.common.exception.OperateException;
import cn.o0u0o.common.exception.OtherException;
import cn.o0u0o.common.exception.UnKnowException;
import cn.o0u0o.common.exception.operate.InsertException;
import cn.o0u0o.common.exception.operate.SelectException;
import cn.o0u0o.common.exception.operate.UpdateException;
import cn.o0u0o.common.exception.other.ControllerException;
import cn.o0u0o.common.exception.other.DaoException;
import cn.o0u0o.common.exception.other.ServiceException;
import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Caleb Chen
 * @create 2021-06-02 17:38
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 统一异常处理
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("系统内部异常，请通知维护人员。异常信息:" + e);
        if(e instanceof OperateException) {
            if(e instanceof SelectException) {
                return Result.err().code(((SelectException) e).getCode()).message(e.getMessage());
            } else if(e instanceof InsertException) {
                return Result.err().code(((InsertException) e).getCode()).message(e.getMessage());
            } else if(e instanceof UpdateException) {
                return Result.err().code(((UpdateException) e).getCode()).message(e.getMessage());
            }
        }
        if(e instanceof OtherException) {
            if(e instanceof ControllerException) {
                return Result.err().code(((ControllerException) e).getCode()).message(e.getMessage());
            } else if(e instanceof DaoException) {
                return Result.err().code(((DaoException) e).getCode()).message(e.getMessage());
            } else if(e instanceof ServiceException) {
                return Result.err().code(((ServiceException) e).getCode()).message(e.getMessage());
            }
        }
        UnKnowException unKnowException = new UnKnowException(ResultCodeEnum.UNKNOWN_REASON);
        return Result.err().code(unKnowException.getCode()).message(unKnowException.getMessage());
    }
}
