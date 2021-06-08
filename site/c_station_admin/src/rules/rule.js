export default {

  StaffAddFrom: {
    username: [
      {
        required: true,
        message: '请输入用户名',
        trigger: 'blur'
      },
      {
        min: 3,
        max: 10,
        message: '长度在3~20字符',
        trigger: 'blur'
      }
    ],
    password: [
      {
        required: true,
        message: '请输入密码',
        trigger: 'blur'
      },
      {
        min: 6,
        max: 20,
        message: '密码长度在3~20字符',
        trigger: 'blur'
      }
    ],
    email: [
      {
        required: true,
        message: '请输入邮箱',
        trigger: 'blur'
      },
      {
        pattern: /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/,
        message: '请输入正确的邮箱',
        trigger: 'blur'
      }
    ],
    nickName: [
      {
        required: true,
        message: '请填写昵称',
        trigger: 'blur'
      },
      {
        min: 3,
        max: 20,
        message: '长度在3~20字符',
        trigger: 'blur'
      }
    ]
  }

}
