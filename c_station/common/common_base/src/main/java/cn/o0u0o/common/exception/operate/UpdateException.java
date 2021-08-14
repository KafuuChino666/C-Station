package cn.o0u0o.common.exception.operate;

import cn.o0u0o.common.exception.OperateException;
import cn.o0u0o.common.response.Result;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Caleb Chen
 * @create 2021-06-02 19:55
 */
@Getter
@Setter
public class UpdateException extends OperateException {

    private Integer code;
    private String message;

    public UpdateException(Result result) {
        this.message = result.getMessage();
        this.code = result.getCode();
    }

}
