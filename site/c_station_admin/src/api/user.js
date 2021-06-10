import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/acl/login',
    method: 'post',
    params: {
      'username': data.username,
      'password': data.password
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/admin/acl/staff/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/acl/logout',
    method: 'post'
  })
}

export function getPublicKey() {
  return request({
    url: '/acl/publickey',
    method: 'get'
  })
}

// 发送验证码
export function sendCode(username, token) {
  return request({
    url: '/acl/send',
    method: 'post',
    params: {
      username,
      token
    }
  })
}

// 获取菜单
export function fetchUserMenuList() {
  return request({
    url: '/admin/acl/staff/menu',
    method: 'get'
  })
}
