<template>
  <el-dialog
    class="auth-container"
    :title="title"
    :visible.sync="dialogVisible"
    width="30%"
    :before-close="handleClose">
    <div class="auth_body">
      <el-tag>为了您的账户安全，进行敏感操作前必须先验证身份。<br>若手机已不再使用，点击这里修改手机码。</el-tag>
      <el-form size="mini" label-position="left" label-width="80px" style="padding: 15px">
        <el-form-item label="验证方式">
          <el-select v-model="authType" @change="chooseAuthType" placeholder="请选择验证方式">
            <el-option v-if="authInfo.mobile !== undefined" :label="'手机  '+ authInfo.mobile" value="mobile"></el-option>
            <el-option v-if="authInfo.email !== undefined" :label="'邮箱  ' + authInfo.email" value="email"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="绑定手机">
          {{ authType == 'email' ? authInfo.email : authInfo.mobile }}
        </el-form-item>
        <el-form-item class="auth_code" label="短信验证码">
          <el-input v-model="authInfo.code"></el-input>
          <el-button :disabled="disabled" @click="getAuthCode()" type="primary" plain>{{captchaButText}}</el-button>
        </el-form-item>
        <el-button @click="affirmFun(authInfo.code)" size="small" type="primary">确定</el-button>
        <el-button size="small">取消</el-button>
      </el-form>
    </div>
  </el-dialog>
</template>

<script>
import securityAPI from '@/api/securityAPI'

export default {
  name: 'VerificationFrame',
  props: {
    // 弹窗标题
    title: {
      type: String,
      required: false,
      default: '安全验证'
    },
    // 是否现实
    dialogVisible: {
      type: Boolean,
      required: false,
      default: false
    },
    affirmFun: {
      type: Function,
      required: false,
      default: function() {}
    }
  },
  data() {
    return {
      authInfo: {},
      authType: 'mobile',
      disabled: false,
      captchaButText: '发送验证码',
      second: 60
    }
  },
  created() {
    securityAPI.getStaffAuthInfo().then(res => {
      this.authInfo = res.data.auth
    })
  },
  methods: {
    handleClose() {
      this.dialogVisible = false
    },
    chooseAuthType(value) {
      this.authType = value
    },
    // 获取验证码
    getAuthCode() {
      this.disabled = true // 禁用按钮
      this.timeDown()
      securityAPI.sendAuthCode(this.authType).then(res => {
        // eslint-disable-next-line eqeqeq
        if (res.code == 28007) {
          this.$message({
            showClose: true,
            message: res.message,
            type: 'warning'
          })
          this.disabled = true
        }
      })
    },
    // 倒计时
    timeDown() {
      const result = setInterval(() => {
        this.second--
        this.captchaButText = '等待短信 ' + this.second + ' s'
        if (this.second < 0 || !this.disabled) {
          clearInterval(result)
          this.disabled = false
          this.second = 60
          this.captchaButText = '获取验证码'
        }
      }, 1000)
    }
  }
}
</script>

<style>
.el-dialog {
  min-width: 462px;
}
.auth-container .el-dialog__header {
  padding-bottom: 15px;
  padding-top: 15px;
}
.auth-container .el-dialog__body {
  padding: 0;
}
.auth-container .el-divider--horizontal {
  margin: 0;
}
.auth-container .el-tag {
  border-radius: 0;
  width: 100%;
}
.auth-container span {
  word-break:normal;
  height: auto;
  line-height: 15px;
  padding: 8px 10px 8px;
}
.auth-container .el-form-item__label {
  font-weight: 100;
  font-size: 10px;
  color: #2a2a2b;
}

.auth-container .el-input__inner {
  border-radius: 0;
}

.auth-container .el-input--mini .el-input__icon {
  line-height: 10px;
}
.auth_body {
  margin: 0 20px;
}
.auth_code .el-input__inner {
  width: 90px;
  border-radius: 0;
}
.auth_code .el-input {
  width: 90px;
}
.auth_code .el-button {
  margin-left: 15px;
}
</style>
