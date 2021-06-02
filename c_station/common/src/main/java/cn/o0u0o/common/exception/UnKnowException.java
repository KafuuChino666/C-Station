package cn.o0u0o.common.exception;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Caleb Chen
 * @create 2021-06-02 20:20
 */
@Setter
@Getter
public class UnKnowException extends RuntimeException {

    private Integer code;
    private String message;

    public UnKnowException(ResultCodeEnum resultCodeEnum) {
        this.message = resultCodeEnum.getMessage();
        this.code = resultCodeEnum.getCode();
    }

}
