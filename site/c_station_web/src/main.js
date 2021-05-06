// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// 引入Element-ui
import ElementUI from 'element-ui'
// 引入阿里云ico
import './assets/iconfont/iconfont.css'

import 'element-ui/lib/theme-chalk/index.css'

// 消除子组件滑动条
import VueScrollLock from 'vue-scroll-lock'

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueScrollLock)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
