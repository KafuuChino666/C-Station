import { login, logout, getInfo } from '@/api/user'
// import { logout, getInfo } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import router, { resetRouter } from '@/router'
// import axios from 'axios'

const getDefaultState = () => {
  return {
    token: getToken(),
    name: '',
    avatar: ''
  }
}

const state = getDefaultState()

const mutations = {
  RESET_STATE: (state) => {
    Object.assign(state, getDefaultState())
  },
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  }
}

const actions = {
  // user login
  login({ commit }, userInfo) {
    const { username, password, captcha } = userInfo
    return new Promise((resolve, reject) => {
      login({ username: username.trim(), password: password, captcha: captcha }).then(response => {
        if (response.status) {
          const { data } = response
          commit('SET_TOKEN', data.token)
          setToken(data.token, data.maxAge)

          this.$store.dispatch('permission/generateRoutes', data, { root: true }).then((accessRoutes) => {
            router.addRoutes(accessRoutes)
          })
        }
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
    // eslint-disable-next-line no-unreachable
    // axios.post('/acl/login', { username: username.trim(), password: password }).then(response => {
    //   // 1
    // }).catch(error => {
    //   alert(error)
    // })

    // axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'
    // axios({
    //   method: 'post',
    //   url: 'http://127.0.0.1/acl/login',
    //   data: {
    //     'username': username.trim(),
    //     'password': password
    //   },
    //   headers: {
    //     'Content-Type': 'application/x-www-form-urlencoded'
    //   },
    //   withCredentials: true
    // }).then(response => {
    //   if (response.status) {
    //     const { data } = response
    //     commit('SET_TOKEN', data.token)
    //     setToken(data.token)
    //   }
    //   // resolve()
    // }).catch(error => {
    //   // reject(error)
    //   alert(error)
    // })
  },

  // get user info
  getInfo({ commit, state }) {
    return new Promise((resolve, reject) => {
      getInfo(state.token).then(response => {
        const { data } = response

        if (!data) {
          return reject('Verification failed, please Login again.')
        }

        const { name, avatar } = data

        commit('SET_NAME', name)
        commit('SET_AVATAR', avatar)

        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  // user logout
  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {
        removeToken() // 删除token
        resetRouter() // 重置路由
        commit('RESET_STATE')
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // remove token
  resetToken({ commit }) {
    return new Promise(resolve => {
      removeToken() // must remove  token  first
      commit('RESET_STATE')
      resolve()
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

