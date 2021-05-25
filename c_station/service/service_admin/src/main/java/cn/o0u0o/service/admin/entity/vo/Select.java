package cn.o0u0o.service.admin.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *         selectUserID: '', // 用户ID
 *         selectType: '', // 用户类型
 *         selectUserName: '' // 用户昵称
 *
 * @author Caleb Chen
 * @create 2021-05-25 16:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Select {
    private Integer selectUserID;
    private Integer selectType;
    private String selectUserName;
}
