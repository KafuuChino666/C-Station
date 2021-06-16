package cn.o0u0o.service.security.entity.vo;

import cn.o0u0o.service.security.entity.Staff;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author Guo Yangyang
 * @version 1.0
 * @date 2021/6/8 19:17
 */
@Data
public class StaffVo {

    @NotEmpty(message = "参数不能为空")
    @Length(min = 3, max = 10, message = "用户名过长或过短")
    private String username;
    @NotEmpty(message = "参数不能为空")
    @Length(min = 6, max = 20, message = "用户名过长或过短")
    private String password;
    @Email(message="邮箱格式错误")
    private String email;
    @Pattern(regexp = "/^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/", message = "手机号格式不正确")
    private String mobile;
    @NotEmpty(message = "参数不能为空")
    @Length(min = 1, max = 20, message = "昵称过长或过短")
    private String nickName;
    @Length(min = 1, max = 50, message = "备注过长或过短")
    private String remark;
    private Boolean status;
    private List<String> roles;
}
