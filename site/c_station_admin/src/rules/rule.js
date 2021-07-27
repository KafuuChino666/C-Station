import securityAPI from '@/api/securityAPI'
import video from '@/api/video'
import zone from '@/api/zone'

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
      },
      {
        validator: function(rule, value, callback) {
          securityAPI.validateUserName(value).then(res => {
            if (!res.data.validate) {
              callback(new Error('用户名不可用！'))
            } else {
              callback()
            }
          }).catch(error => {
            console.log(error)
            callback(new Error('用户名不可用！'))
          })
        },
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
    mobile: [
      {
        required: true,
        message: '请输入手机号',
        trigger: 'blur'
      },
      {
        pattern: /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/,
        message: '请输入正确的手机号',
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
        min: 1,
        max: 20,
        message: '长度在3~20字符',
        trigger: 'blur'
      }
    ]
  },
  zoneForm: {
    title: [
      {
        required: true,
        message: '请输入Title',
        trigger: 'blur'
      },
      {
        max: 10,
        message: '长度在3~20字符',
        trigger: 'blur'
      },
      {
        validator: function(rule, value, callback) {
          zone.verifyTitle(value).then(res => {
            if (!res.data.validate) {
              callback(new Error('Title不可用！'))
            } else {
              callback()
            }
          }).catch(error => {
            console.log(error)
            callback(new Error('Title不可用！'))
          })
        },
        trigger: 'blur'
      }
    ]
  },
  WorkFlowAddFrom: {
    flowName: [
      {
        required: true,
        message: '请输入流程名',
        trigger: 'blur'
      },
      {
        min: 3,
        max: 10,
        message: '长度在3~20字符',
        trigger: 'blur'
      },
      {
        validator: function(rule, value, callback) {
          video.validateWorkFlowName(value).then(res => {
            if (!res.data.validate) {
              callback(new Error('流程名不可用！'))
            } else {
              callback()
            }
          }).catch(error => {
            console.log(error)
            callback(new Error('流程名不可用！'))
          })
        },
        trigger: 'blur'
      }
    ],
    remark: [
      {
        required: true,
        message: '请稍微写一点点备注吧！',
        trigger: 'blur'
      }
    ]
  }

}
