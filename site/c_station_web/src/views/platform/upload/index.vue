<template>
  <div class="upload-box">
    <el-tabs v-model="activeName">
      <el-tab-pane label="视频投稿" name="first"><Frame /></el-tab-pane>
      <el-tab-pane label="专题投稿" name="second">2</el-tab-pane>
      <el-tab-pane label="互动视频投稿" name="third">3</el-tab-pane>
      <el-tab-pane label="音频投稿" name="fourth">4</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import Frame from './video/frame'
export default {
  name: 'index',
  components: {Frame},
  data () {
    return {
      activeName: 'first'
    }
  }
}
</script>

<style scoped>
.upload-box {
  background: white;
  padding: 20px 40px;
}
</style>
