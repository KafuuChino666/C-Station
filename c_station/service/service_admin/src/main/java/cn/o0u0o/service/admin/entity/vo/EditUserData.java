package cn.o0u0o.service.admin.entity.vo;

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

    String userName;

    Integer category;

    Integer gender;

}
