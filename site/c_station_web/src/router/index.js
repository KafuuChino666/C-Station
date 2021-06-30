import Vue from 'vue'
import Router from 'vue-router'

// 引入layout
import DefaultLayout from '../layout/Default'
import PlatformLayout from '../layout/Platform'
import CommonLayout from '../layout/Default/CommonLayout'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: DefaultLayout
    },
    {
      path: '/login',
      name: 'Login',
      component: CommonLayout,
      children: [{
        path: '',
        component: () => import('@/views/login/index')
      }]
    },
    {
      path: '/platform',
      component: PlatformLayout,
      redirect: '/platform/home',
      name: 'Platform',
      hidden: true,
      children: [{
        path: 'home',
        component: () => import('@/views/platform/index')
      },
      //  上传内容
      {
        path: 'upload',
        component: () => import('@/views/platform/upload/index'),
        name: 'PlatformUpload',
        hidden: true
      },
      // 内容管理
      {
        path: 'upload-manager',
        component: () => import('@/views/platform/upload-manager/index'),
        name: 'UploadManager',
        hidden: true,
        children: [
          {
            path: 'article',
            component: () => import('@/views/platform/upload-manager/article/index'),
            name: 'article-index',
            hidden: true
          }
        ]
      }
      ]
    }
  ]
})
