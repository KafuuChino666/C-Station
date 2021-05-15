<template>
  <div class="main">
    <el-container direction="vertical">
      <el-header>
        <Navbar />
      </el-header>
      <el-container>
        <el-aside width="200px">
          <Sidebar />
        </el-aside>
        <el-main>
          <div class="router-main">
            <router-view />
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Navbar from '../Platform/components/Navbar'
import Sidebar from '../Platform/components/Sidebar/index'
export default {
  name: 'PlatformLayout',
  components: {
    Navbar,
    Sidebar
  }
}
</script>

<style scoped>

body,
html {
  height: 100%;
}
.main {
  height: 100%;
  margin: 0;
  padding: 0;
}

.main .el-header {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.6)
}

.aside-but {
  background: white;
}

.router-main {
  width: inherit;
  margin-left: 72px;
  margin-right: 72px;
  /*height: 100%;*/
  /*background: #B500FE;*/
}

#app,html,body,.el-container {
  height: 100%;
  margin: 0;
  padding: 0;
}

.el-header {
  padding: 0;
}
.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-main {
  background-color: #fafafa;
  color: #333;
}

</style>
