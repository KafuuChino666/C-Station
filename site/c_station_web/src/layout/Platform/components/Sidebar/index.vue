<template>
  <el-menu
    default-active="2"
    class="side">
    <div class="upload-btn">
      <el-button @click="uploadFun()" type="primary" class="but" icon="el-icon-upload">投稿</el-button>
    </div>
    <el-menu-item index="1">
      <i class="el-icon-menu"></i>
      <span slot="title">首页</span>
    </el-menu-item>
    <el-submenu index="2">
      <template slot="title">
        <i class="el-icon-box"></i>
        <span>内容管理</span>
      </template>
      <el-menu-item index="2-1">稿件管理</el-menu-item>
      <el-menu-item index="2-2">申诉管理</el-menu-item>
      <el-menu-item index="2-3">字幕管理</el-menu-item>
    </el-submenu>
    <el-menu-item index="3">
      <i class="el-icon-data-analysis"></i>
      <span slot="title">数据中心</span>
    </el-menu-item>
    <el-menu-item index="4" disabled>
      <i class="el-icon-document"></i>
      <span slot="title">粉丝管理</span>
    </el-menu-item>
    <el-menu-item index="5">
      <i class="el-icon-chat-dot-round"></i>
      <span slot="title">互动管理</span>
    </el-menu-item>
    <el-menu-item index="6">
      <i class="el-icon-bank-card"></i>
      <span slot="title">收益管理</span>
    </el-menu-item>
    <div class="nav-line"></div>
    <el-menu-item index="7">
      <i class="el-icon-setting"></i>
      <span slot="title">创作成长</span>
    </el-menu-item>
    <el-menu-item index="8">
      <i class="el-icon-s-flag"></i>
      <span slot="title">创作权益</span>
    </el-menu-item>
    <el-menu-item index="9">
      <i class="el-icon-setting"></i>
      <span slot="title">创作设置</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: 'index',
  methods: {
    uploadFun () {
      this.$router.push({name: 'PlatformUpload'})
    }
  }
}
</script>

<style>
.side {
  height: 100%;
}

.side .el-menu-item {
  padding-left: 30px ! important;
}

.side .el-submenu__title {
  padding-left: 30px ! important;
}

.side .el-menu--inline li {
  padding-left: 64px ! important;
}

.upload-btn {
  text-align: center;
}

.side .but {
  margin: 10px auto;
  padding-right: 40px;
  padding-left: 40px;
  border-radius: 0;
}

.nav-line {
  background: #f4f4f4;
  margin: 0 10px;
  height: 1.5px;
}
</style>
