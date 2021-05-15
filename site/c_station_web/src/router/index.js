import Vue from 'vue'
import Router from 'vue-router'

// 引入layout
import DefaultLayout from '../layout/Default'
import PlatformLayout from '../layout/Platform'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: DefaultLayout
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
      }
      ]
    }
  ]
})
