import Cookies from 'js-cookie'

const TokenKey = 'ACL-Token'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token, maxAge) {
  maxAge = maxAge / (60 * 60 * 24)
  return Cookies.set(TokenKey, token, { expires: maxAge })
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}
