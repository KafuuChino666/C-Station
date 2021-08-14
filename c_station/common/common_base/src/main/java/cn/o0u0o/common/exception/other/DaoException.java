package cn.o0u0o.common.exception.other;

import cn.o0u0o.common.exception.OtherException;
import cn.o0u0o.common.response.Result;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Caleb Chen
 * @create 2021-06-02 19:48
 */
@Getter
@Setter
public class DaoException extends OtherException {

    private Integer code;
    private String message;

    public DaoException(Result result) {
        this.message = result.getMessage();
        this.code = result.getCode();
    }

}
