package cn.o0u0o.service.admin.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * userName: '',
 * selectType: '',
 * selectGender: ''
 *
 * @author Caleb Chen
 * @create 2021-06-25 8:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditUserData {

    @TableField(value = "user_name")
    String userName;

    @TableField(value = "category_id")
    Integer selectType;

    @TableField(value = "gender_id")
    Integer selectGender;

}
