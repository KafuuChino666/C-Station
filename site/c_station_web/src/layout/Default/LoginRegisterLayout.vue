<template>
  <div>
    <!--  头部导航栏  -->
    <Nav genre="on" roll="false"/>
    <div class="router">
      <div class="login-top">
        <img src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/rl_top.35edfde.png">
      </div>
      <!--  路由视图  -->
      <router-view />
    </div>
    <!--  网站尾部  -->
    <Footer />
  </div>
</template>

<script>
import Nav from './components/nav'
import Footer from './components/footer'
export default {
  name: 'LoginRegisterLayout',
  components: {Footer, Nav}
}
</script>

<style scoped>
.router {
  margin-top: 56px;
}
</style>


<style>
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
  width: 415px;
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
