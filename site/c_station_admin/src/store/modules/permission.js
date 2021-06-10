import { asyncRoutes, constantRoutes } from '@/router'
import { fetchUserMenuList } from '@/api/user'
import Layout from '@/layout'

/**
 * 静态路由懒加载
 * @param view  格式必须为 xxx/xxx 开头不要加斜杠
 * @returns
 */
export const loadView = (view) => {
  return (resolve) => require([`@/views/${view}.vue`], resolve)
}

export function buildMenuTree(menuList, pid) {
  const menus = []
  menuList.forEach(item => {
    // eslint-disable-next-line eqeqeq
    if (pid == item.parentId) {
      const menu = {
        path: item.path,
        component: item.component === 'Layout' ? Layout : loadView(item.component),
        hidden: item.hidden == 1, // 状态为0的隐藏
        redirect: item.redirect,
        children: [],
        name: item.name,
        meta: { title: item.title, icon: item.icon }
      }
      // eslint-disable-next-line eqeqeq
      if (item.hasChildren == 1) {
        menu.children = buildMenuTree(menuList, item.id)
      }
      menus.push(menu)
    }
  })
  return menus
}

/**
 * 把从后端查询的菜单数据拼装成路由格式的数据
 * @param routes
 * @param data 后端返回的菜单数据
 */
export function generaMenu(routes, data) {
  const menuTree = buildMenuTree(data, 0)
  Object.assign(routes, menuTree)
  return routes
}

const state = {
  routes: [],
  addRoutes: []
}

const mutations = {
  SET_ROUTES: (state, routes) => {
    state.addRoutes = routes
    // 拼接静态路由和动态路由
    state.routes = constantRoutes.concat(routes)
  }
}

const actions = {
  generateRoutes({ commit }, token) {
    return new Promise(resolve => {
      // 通过token从后端获取用户菜单，并加入全局状态
      fetchUserMenuList(token).then(res => {
        const menuData = Object.assign([], res.data.menus)
        const tempAsyncRoutes = Object.assign([], asyncRoutes)
        console.log(menuData)
        const accessedRoutes = generaMenu(tempAsyncRoutes, menuData)

        commit('SET_ROUTES', accessedRoutes)
        console.log(accessedRoutes)
        resolve(accessedRoutes)
      }).catch(error => {
        console.log(error)
      })
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
