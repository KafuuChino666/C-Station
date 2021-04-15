<template>
  <div class="app-container">

    <h2 style="text-align: center;">添加新角色</h2>
    <el-steps :active="active" finish-status="success" simple style="margin-bottom: 40px">
      <el-step title="填写课程基本信息" />
      <el-step title="创建课程大纲" />
      <el-step title="发布课程" />
    </el-steps>

    <!-- 填写课程基本信息 -->
    <info v-if="active === 0" />

    <!-- 创建课程大纲 -->
    <chapter v-if="active === 1" />

    <!-- 发布课程 -->
    <Publish v-if="active === 2 || active === 3" />

  </div>
</template>

<script>
export default {
  name: 'RoleForm'
}
</script>

<style scoped>

</style>
