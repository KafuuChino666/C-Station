import axios from 'axios'
import { MessageBox, Message } from 'element-ui'
import store from '@/store'
import { getToken } from '@/utils/auth'

// 创建axios实例
const service = axios.create({
  // api 的 base_url
  // url = base url + request url
  baseURL: process.env.VUE_APP_BASE_API,
  // withCredentials: true, // send cookies when cross-domain requests
  timeout: 5000 // 请求超时时间
})

// request拦截器
service.interceptors.request.use(
  config => {
    // 在发送请求之前做些什么

    if (store.getters.token) {
      // 让每个请求携带令牌—> token
      config.headers['X-Token'] = getToken()
    }
    return config
  },
  error => {
    // 处理请求错误
    console.log(error) // 打印bug
    return Promise.reject(error)
  }
)

// response拦截器
service.interceptors.response.use(
  /**
   * If you want to get http information such as headers or status
   * Please return  response => response
  */

  /**
   * 通过自定义代码确定请求状态
   * 可以通过HTTP状态代码来判断状态
   */
  response => {
    const res = response.data

    // 如果定制代码不是20000，则判定为错误。
    if (res.code !== 20000) {
      Message({
        message: res.message || 'Error',
        type: 'error',
        duration: 5 * 1000
      })

      // 50008:非法的token; 50012:其他客户端登录了;  50014:Token 过期了;
      if (res.code === 50008 || res.code === 50012 || res.code === 50014) {
        // 重新登陆
        MessageBox.confirm('你已被登出，可以取消继续留在该页面，或者重新登录', '确定登出', {
          confirmButtonText: '重新登录',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          store.dispatch('user/resetToken').then(() => {
            location.reload() // 了重新实例化vue-router对象 避免bug
          })
        })
      }
      // return Promise.reject(new Error(res.message || 'Error'))
      return res
    } else {
      return res
    }
  },
  error => {
    console.log('err' + error) // for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service
