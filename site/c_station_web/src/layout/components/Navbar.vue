<!-- 导航栏 -->
<template>
  <el-menu
    :default-active="activeIndex"
    class="el-menu-demo menuLeft"
    mode="horizontal"
    @select="handleSelect"
    background-color="rgba(255,255,255,0)"
    text-color="#fff"
    active-text-color="#fff"
  >
    <el-menu-item index="1"><i class="iconfont icon-keaigui6" style="color: white; margin-right: 5px"></i>主站</el-menu-item>
    <el-menu-item index="2">番剧</el-menu-item>
    <el-menu-item index="3">游戏中心</el-menu-item>
    <el-menu-item index="3">直播</el-menu-item>
    <el-menu-item index="3">会员购</el-menu-item>
    <el-menu-item index="3">漫画</el-menu-item>
    <el-menu-item index="3">赛事</el-menu-item>
    <el-menu-item index="3"><i class="iconfont icon-app" style="color: white; margin-right: 5px"></i>下载APP</el-menu-item>
    <el-menu-item index="3">
      <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
        <el-button slot="append" icon="el-icon-search"></el-button>
      </el-input>
    </el-menu-item>
    <el-menu-item index="3">
      <el-avatar :size="37" :src="avatarUrl"></el-avatar>
    </el-menu-item>
    <el-menu-item index="3">大会员</el-menu-item>
    <el-menu-item index="3">消息</el-menu-item>
    <el-menu-item index="3">动态</el-menu-item>
    <el-menu-item index="3">收藏</el-menu-item>
    <el-menu-item index="3">历史</el-menu-item>
    <el-menu-item index="3">创作中心</el-menu-item>
    <el-menu-item index="3">
      <el-button type="primary" style="background-color: #fb7299; width: 100px">投稿</el-button>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: 'Navbar',
  data () {
    return {
      activeIndex: '1',
      activeIndex2: '1',
      avatarUrl: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/www.png'
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style>
.menuLeft {
  width: 1535px;
}
.menuLeft .el-menu-item {
  border-bottom-color: rgb(255, 255, 255, 0);
  padding: 0 6px;
}
.el-menu.el-menu--horizontal {
  border-bottom: solid 0px #e6e6e6;
}
.menuLeft .el-menu-item:hover{
  background: rgba(255,255,255,0) !important;
}
.menuLeft .el-submenu__title:hover {
  background: rgba(255,255,255,0) !important;
}

.menuLeft .el-menu-item.is-active {
  background: rgba(255,255,255,0) !important;
}
.menuLeft .el-submenu__title.is-active {
  background: rgba(255,255,255,0) !important;
}

.input-with-select {
  width: 500px;
}
</style>
