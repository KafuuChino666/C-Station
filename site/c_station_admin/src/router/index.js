import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '概览', icon: 'dashboard' }
    }]
  },

  // 员工管理
  {
    path: '/employee',
    component: Layout,
    redirect: '/employee/list',
    name: 'Employee',
    meta: { title: '员工管理', icon: 'el-icon-s-custom' },
    children: [
      {
        path: 'list',
        name: 'EmployeeList',
        component: () => import('@/views/employee/list'),
        meta: { title: '员工列表', icon: 'tree' }
      },
      {
        path: 'create',
        name: 'EmployeeCreate',
        component: () => import('@/views/employee/create'),
        meta: { title: '添加员工', icon: 'el-icon-plus' }
      },
      {
        path: 'edit/:id',
        name: 'EmployeeEdit',
        component: () => import('@/views/employee/edit'),
        meta: { title: '编辑员工', icon: 'el-icon-edit' }
      }
    ]
  },

  // 分类管理
  {
    path: '/subject',
    component: Layout,
    redirect: '/subject/list',
    name: 'Subject',
    meta: { title: '视频分类', icon: 'el-icon-collection-tag' },
    children: [
      {
        path: 'list',
        name: 'SubjectList',
        component: () => import('@/views/404'),
        meta: { title: '分类列表', icon: 'el-icon-document' }
      },
      {
        path: 'create',
        name: 'SubjectCreate',
        component: () => import('@/views/404'),
        meta: { title: '分类添加', icon: 'el-icon-plus' }
      },
      {
        path: 'edit/:id',
        name: 'SubjectEdit',
        component: () => import('@/views/404'),
        meta: { title: '分类编辑', icon: 'el-icon-edit' }
      }
    ]
  },

  // 视频管理
  {
    path: '/video',
    component: Layout,
    redirect: '/video/dashboard/info',
    name: 'Video',
    meta: {
      title: '视频管理',
      icon: 'el-icon-film'
    },
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/404'), // Parent router-view
        name: 'VideoDashboard',
        meta: {
          title: '视频查询',
          icon: 'el-icon-data-analysis'
        },
        children: [
          {
            path: 'info',
            component: () => import('@/views/404'),
            name: 'VideoInfo',
            meta: { title: '视频统计' }
          },
          {
            path: 'query',
            component: () => import('@/views/404'),
            name: 'VideoQuery',
            meta: { title: '视频查询' }
          }
        ]
      },
      {
        path: 'audit',
        component: () => import('@/views/404'),
        name: 'Audit',
        meta: { title: '视频审核', icon: 'el-icon-s-check' }
      }
    ]
  },

  {
    path: 'users',
    component: Layout,
    children: [
      {
        path: '@/views/404',
        meta: { title: '用户管理', icon: 'el-icon-user-solid' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
