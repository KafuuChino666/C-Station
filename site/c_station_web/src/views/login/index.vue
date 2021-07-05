<template>
  <div>
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
                  <el-input placeholder="填写常用手机号" class="input-with-select">
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

</style>
