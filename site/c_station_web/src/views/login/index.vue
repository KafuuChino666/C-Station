<template>
  <div>
    <div class="login-top">
      <img src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/rl_top.35edfde.png">
    </div>
    <div class="login-title-line">
      <span class="title">登陆</span>
    </div>
    <div class="login-body">
      <div class="form-login">
        <div class="input-box">
          <el-tabs v-model="type">
            <el-tab-pane label="密码登陆" name="first">
              <el-form>
                <el-form-item>
                  <el-input placeholder="你的手机号/邮箱" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item>
                  <el-input type="password" placeholder="密码" autocomplete="off"></el-input>
                </el-form-item>
              </el-form>
            </el-tab-pane>
            <el-tab-pane label="短信登陆" name="second">
              <el-form>
                <el-form-item>
                  <el-input placeholder="请输入内容" class="input-with-select">
                    <el-select slot="prepend" placeholder="请选择">
                      <el-option label="手机" value="1"></el-option>
                    </el-select>
                  </el-input>
                </el-form-item>
                <el-form-item>
                  <el-input placeholder="请输入短信验证码" style="width: 295px"></el-input>
                  <el-button type="primary">获取验证码</el-button>
                </el-form-item>
              </el-form>
            </el-tab-pane>
          </el-tabs>
          <div>
            <div class="remember">
              <div class="remember-tool">
                <label>
                  <el-checkbox-group v-model="a">
                    <el-checkbox label="记住我" name="type"></el-checkbox>
                  </el-checkbox-group>
                  <span class="hint">不是自己的电脑上不要勾选此项</span>
                </label>
                <div>
                  <a href="#" class="forget-password">忘记密码?</a>
                  <a href="#" class="not-checkout">无法验证?</a>
                </div>
              </div>
            </div>
            <div class="btn-box">
              <a class="btn-login btn">登录</a>
              <a href="#" class="btn btn-reg">注册</a>
            </div>
            <div class="third-party">
              <a href="#">
                <svg aria-hidden="true" class="svg-icon">
                  <use xlink:href="#icon-umidd17"></use>
                </svg>
                支付宝账号登陆
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      a: [],
      type: 'first'
    }
  }
}
</script>

<style scoped>
.login-top {
  background: #00a0d8;
  height: 86px;
  text-align: center;
  margin-bottom: 20px;
}
.login-title-line {
  width: 980px;
  height: 28px;
  margin: 0 auto;
  border-bottom: 1px solid #ddd;
  margin-bottom: 28px;
  text-align: center;
}
.login-title-line .title{
  height: 56px;
  line-height: 56px;
  margin: 0 auto;
  padding: 0 20px;
  font-size: 38px;
  background: #fff;
  text-align: center;
}
.login-body {
  width: 490px;
  display: flex;
  position: relative;
  margin: 0 auto;
}
.form-login {
  position: relative;
}
.form-login .input-box {
  margin-top: 50px;
  width: 414px;
}
.form-login .input-box .remember {
  margin: 10px 0;
  color: #717171;
  width: 410px;
  font-size: 12px;
}
.form-login .input-box .remember div{
  display: inline;
}
.form-login .input-box .remember .hint {
  margin-left: 10px;
  color:  #bbb;
}
.form-login .input-box .remember .forget-password {
  float: right;
}
.form-login .input-box .remember .not-checkout {
  float: right;
  margin-right: 10px;
}
.form-login .input-box .remember a {
  color: #00a1d6;
  line-height: 19px;
}
.form-login .btn-box {
  display: -webkit-box;
  display: -webkit-flex;
  display: flex;
  -webkit-box-pack: justify;
  -webkit-justify-content: space-between;
  justify-content: space-between;
  -webkit-align-content: center;
  align-content: center;
}
.form-login .input-box .btn-box .btn-login {
  border: 1px solid #0381aa;
  color: #fff;
  background-color: #00a7de;
}
.form-login .input-box .btn-box .btn-login:hover {
  background-color: #06b9f5;
}
.form-login .input-box .btn-box .btn-reg{
  color: #555;
}
.form-login .input-box .btn-box .btn-reg:hover{
  background-color: #f3f2f2;
}
.form-login .input-box .btn-box .btn {
  display: inline-block;
  height: 36px;
  border: 1px solid #ccc;
  border-radius: 2px;
  width: 184px;
  line-height: 38px;
  font-size: 14px;
  text-align: center;
  cursor: pointer;
  -webkit-transition: all .3s;
  transition: all .3s;
}
.form-login .third-party {
  padding: 12px 0;
  font-size: 12px;
}
.form-login .third-party .svg-icon{
  width: 2.2em;
  height: 2.2em;
  vertical-align: middle;
  fill: currentColor;
  overflow: hidden;
}
</style>

<style>
.el-tabs__nav-wrap::after {
  content: "";
  position: relative;
  left: 0;
  bottom: 0;
  width: 100%;
  height: 2px;
  background-color: #E4E7ED;
  z-index: 0;
}
.el-tabs__active-bar {
  z-index: 0;
  height: 0;
}
.el-tabs__header {
  margin: 0 0 10px;
}
.el-tabs__item {
  padding: 0 10px;
}
.el-tabs__item:hover {
  color: #02a7de;
}
.el-checkbox__label {
  display: inline-block;
  padding-left: 10px;
  line-height: 19px;
  font-size: 12px;
}
.el-select {
  width: 130px;
}
.el-input-group__append, .el-input-group__prepend {
  background-color: white;
}
</style>
