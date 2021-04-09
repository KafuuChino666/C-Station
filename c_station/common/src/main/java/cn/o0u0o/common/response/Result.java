package cn.o0u0o.common.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应体, 响应请求结果给游览器
 */
@Data
public class Result {

    // 是否成功
    private Boolean status;

    // 错误码
    private Integer code;

    // 提示信息
    private String message;

    // 返回数据
    private Map<String, Object> data = new HashMap<String, Object>();

    public Result() {

    }

    public Result(Boolean status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public static Result ok() {
        return Result.setResultCodeEnum(ResultCodeEnum.SUCCESS);
    }

    public static Result setResultCodeEnum(ResultCodeEnum re) {
        return new Result(re.getSuccess(), re.getCode(), re.getMessage());
    }

    public Result success(Boolean success) {
        this.setStatus(success);
        return this;
    }

    public Result message(String message) {
        this.message = message;
        return this;
    }

    public Result code(Integer code) {
        this.code = code;
        return this;
    }

    public Result data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
