import axios from 'axios'
import {Message} from 'element-ui'
import cookie from 'js-cookie'

const service = axios.create({
  baseURL: 'http://localhost:80',
  timeout: 12000 // 请求超时时间
})

// http request 拦截器
service.interceptors.request.use(
  config => {
    // debugger
    if (cookie.get('jwt_token')) {
      // 则发送后端api请求的时候携带toke
      config.headers['token'] = cookie.get('jwt_token')
    }
    return config
  },
  error => {
    return Promise.reject(error)
  }
)

// response 拦截器
service.interceptors.response.use(
  response => {
    /**
     * code为非20000是抛错 可结合自己业务进行修改
     */
    const res = response.data
    if (res.code !== 20000) {
      Message({
        message: res.message || 'error',
        type: 'error',
        duration: 5 * 1000
      })

      return Promise.reject('error')
    } else if (res.code === 23004) { // 获取用户信息失败
      // 清除cookie
      cookie.set('jwt_token', '', {domain: 'localhost'})
      return response.data // 不显示错误信息
    } else {
      return response.data
    }
  },
  error => {
    console.log('err：' + error) // for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service
