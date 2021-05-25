package cn.o0u0o.service.admin.entity.vo;

import lombok.Data;

/**
 * userId: '12987122',
 * userName: 'CalebCX',
 * realName: '陈芊浩',
 * gender: '男',
 * category: '大会员',
 * status: '在线',
 * address: '陕西省西安市',
 * consumed: '12',
 * idNumber: '610111111111111111'
 *
 * @author Caleb Chen
 * @create 2021-05-24 17:25
 */
@Data
public class UserData {
    // 用户ID
    private Integer userId;
    // 用户昵称
    private String userName;
    // 真实姓名
    private String realname;
    // 性别
    private char gender;
    // 会员
    private Integer category;
    // 在线状态
//    private Integer status;
//    // 地址
//    private String address;
    //电话号码
    private String phone;
    // 充值数量
    private Integer consumed;
    // 身份证号
    private String idNumber;
    // 邮箱
    private String email;
}
