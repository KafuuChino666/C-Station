<template>
  <div class="login-container">
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form" auto-complete="on" label-position="left">

      <div class="title-container">
        <h3 class="title">C Station Admin</h3>
      </div>

      <el-form-item prop="username">
        <span class="svg-container">
          <svg-icon icon-class="user" />
        </span>
        <el-input
          ref="username"
          v-model="loginForm.username"
          placeholder="Username"
          name="username"
          type="text"
          tabindex="1"
          auto-complete="on"
        />
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
        <el-input
          :key="passwordType"
          ref="password"
          v-model="loginForm.password"
          :type="passwordType"
          placeholder="Password"
          name="password"
          tabindex="2"
          auto-complete="on"
          @keyup.enter.native="handleLogin"
        />
        <span class="show-pwd" @click="showPwd">
          <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'" />
        </span>
      </el-form-item>

      <el-form-item prop="captcha">
        <span class="svg-container"><svg-icon icon-class="password" /></span>
        <el-input
          placeholder="验证码"
          v-model="loginForm.captcha"
          name="captcha"
          type="text"
        />
        <span class="show-pwd" @click="showCaptcha">
          <el-button :disabled="sendingState" v-text="captchaButText" type="warning"></el-button>
          <div ref="demo" />
        </span>
      </el-form-item>

      <el-button :loading="loading" type="primary" style="width:100%;margin-bottom:30px;" @click.native.prevent="handleLogin">登陆</el-button>
    </el-form>
  </div>
</template>

<script>
import { getPublicKey, sendCode } from '@/api/user'
import { JSEncrypt } from 'jsencrypt'
import { getToken } from '@/utils/auth'

export default {
  name: 'Login',
  data() {
    const validatePassword = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error('密码不能少于6位'))
      } else {
        callback()
      }
    }
    return {
      loginForm: {
        username: '',
        password: '',
        captcha: ''
      },
      loginRules: {
        username: [{ required: true, trigger: 'blur' }],
        password: [{ required: true, trigger: 'blur', validator: validatePassword }]
      },
      loading: false,
      passwordType: 'password',
      redirect: undefined,
      publickey: '',
      fetchDataNum: 0,
      captcha: {},
      sendingState: false,
      captchaButText: '发送验证码',
      second: 20
    }
  },
  // 监听redirect
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }
  },
  created() {
    // 测试需要直接跳过
    if (getToken()) {
      // 跳转到用户首页
      this.$router.push({ path: this.redirect || '/' })
    } else {
      this.fetchData()
    }
  },
  mounted() {
    // eslint-disable-next-line no-undef
    this.captcha = _dx.Captcha(this.$refs.demo, {
      appId: 'f7789efe9697a602b53695a03f16a0ba',
      style: 'popup', // 弹出式
      success: token => {
        // 隐藏验证码
        this.captcha.hide()
        // 获取短信验证码
        this.getCodeFun(token)
      }
    })
  },
  methods: {
    // 现实密码
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
      this.$nextTick(() => {
        this.$refs.password.focus()
      })
    },
    // 登陆请求
    handleLogin(options) {
      // 验证表单
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true
          // 加密明文密码
          // eslint-disable-next-line no-undef
          const jse = new JSEncrypt()
          jse.setPublicKey(this.publickey)
          this.loginForm.password = jse.encrypt(this.loginForm.password)
          // 回调提交表单
          this.$store.dispatch('user/login', this.loginForm).then(() => {
            this.$router.push({ path: this.redirect || '/' })
            this.loading = false
          }).catch(() => {
            this.loading = false
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    fetchData() {
      getPublicKey().then(res => {
        this.publickey = res.data.publicKey
      }).catch(() => {
        // 再次请求
        this.fetchDataNum += 1
        if (this.fetchDataNum < 3) {
          this.fetchData()
        }
      })
    },
    // 显示验证码
    showCaptcha() {
      if (this.sendingState) {
        return
      }
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.captcha.show()
        }
      })
    },
    // 倒计时
    timeDown() {
      const result = setInterval(() => {
        this.second--
        this.captchaButText = '等待短信 ' + this.second + ' s'
        if (this.second < 0) {
          clearInterval(result)
          this.sendingState = false
          this.second = 20
          this.captchaButText = '获取验证码'
        }
      }, 1000)
    },
    // 获取验证码
    getCodeFun(token) {
      if (this.sendingState) {
        return
      }
      this.sendingState = true
      this.timeDown()
      // 请求Api
      sendCode(this.loginForm.username, token).then(res => {

      }).catch(error => {
        console.log(error)
      })
    }
  }
}
</script>

<style lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */
$bg:#283443;
$light_gray:#fff;
$cursor: #fff;

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

/* reset element-ui css */
.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #454545;
  }
}
</style>

<style lang="scss" scoped>
$bg:#2d3a4b;
$dark_gray:#889aa4;
$light_gray:#eee;

.login-container {
  min-height: 100%;
  width: 100%;
  background-color: $bg;
  overflow: hidden;

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 160px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
}
</style>
