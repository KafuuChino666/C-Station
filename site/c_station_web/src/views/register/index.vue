<template>
  <div>
    <div class="login-title-line">
      <span class="title">注册</span>
    </div>
    <div class="login-body">
      <div class="form-login">
        <div class="input-box">
          <el-form>
            <el-form-item>
              <el-input placeholder="昵称" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item>
              <el-input type="password" placeholder="密码（6-16个字符组成，区分大小写）" autocomplete="off"></el-input>
            </el-form-item>
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
          <div>
            <div class="remember">
              <div class="remember-tool">
                <label>
                  <el-checkbox-group v-model="a">
                    <el-checkbox label="我已同意" name="type"></el-checkbox>
                  </el-checkbox-group>
                  <span class="hint">《用户使用协议》《隐私政策》</span>
                </label>
              </div>
            </div>
            <div class="btn-box">
              <a class="btn-login btn">注册</a>
            </div>
            <div class="third-party">
              <a href="#">
                已有账号，直接登录>
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
  name: 'Register',
  data() {
    return {
      a: ''
    }
  }
}
</script>

<style scoped>
.form-login .input-box .btn-box .btn {
   width: 100%;
}
.form-login .input-box .third-party {
  float: right;
}
.form-login .input-box .third-party a {
  color: #00a1d6;
}
</style>
