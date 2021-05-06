<template>
  <el-container>
    <el-header style="height: 155px">
      <Navbar />
<!--      <img :src="loginUrl" />-->
    </el-header>
    <el-main>
      <AppMain />
    </el-main>
    <el-footer>
      <Foot />
    </el-footer>
  </el-container>
</template>

<script>
import AppMain from './components/AppMain'
import Foot from './components/Foot'
import Navbar from './components/Navbar'

export default {
  name: 'Layout',
  data () {
    return {
      url: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/head_background.png',
      loginUrl: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/c1e19150b5d1e413958d45e0e62f012e3ee200af.png'
    }
  },
  components: {
    Navbar,
    AppMain,
    Foot
  }
}
</script>

<style>
.el-header {
  background-image: url("https://mcsql-002.oss-cn-beijing.aliyuncs.com/head_background.png");
}

.el-header, .el-footer {
  color: #333;
  line-height: 60px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 160px;
  overflow: hidden;
}
.el-footer {
  padding: 0px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
.el-main {
  padding-top: 20px;
  padding-left: 160px;
}

@media only screen and (max-width: 1150px) {
  .el-main {
    padding-left: 0px;
  }
}
</style>
