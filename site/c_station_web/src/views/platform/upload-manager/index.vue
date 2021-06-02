<template>
  <div class="upload-box">
    <el-tabs v-model="activeName">
      <el-tab-pane label="视频投稿" name="first"><router-view /></el-tab-pane>
      <el-tab-pane label="专题投稿" name="second">2</el-tab-pane>
      <el-tab-pane label="互动视频投稿" name="third">3</el-tab-pane>
      <el-tab-pane label="音频投稿" name="fourth">4</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  name: 'upload-manager-index',
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
