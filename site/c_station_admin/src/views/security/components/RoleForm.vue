<template>
  <div class="app-container">

    <h2 style="text-align: center;">添加新角色</h2>
    <el-steps :active="active" align-center>
      <el-step title="填写角色相关信息" description="填写角色信息"></el-step>
      <el-step title="分配菜单" description="分配此角色可以访问的菜单"></el-step>
      <el-step title="分配API资源" description="分配此角色可以请求的API接口"></el-step>
    </el-steps>

    <div class="content">
      <!-- 填写角色基本信息 -->
      <RoleInfo v-if="active === 0" />

      <!-- 绑定菜单 -->
      <RoleMenuBind v-if="active === 1" />

      <!-- 绑定API资源 -->
      <RoleResourceBind v-if="active === 2 || active === 3" />
    </div>

  </div>
</template>

<script>
import RoleInfo from '@/views/security/components/RoleInfo'
import RoleMenuBind from '@/views/security/components/RoleMenuBind'
import RoleResourceBind from '@/views/security/components/RoleResourceBind'
import securityAPI from '@/api/securityAPI'

export default {
  name: 'RoleForm',
  components: {
    RoleInfo,
    RoleMenuBind,
    RoleResourceBind
  },
  data() {
    return {
      active: 0,
      id: this.$route.params.id,
      form: {

      }
    }
  },
  mounted() {
    // 加载数据
    this.fetchData()
  },
  methods: {
    fetchData() {
      // 判断id
      if (this.id !== undefined && this.id > 0) {
        // 请求
        securityAPI.getMenuById(this.id).then(reponse => {
          if (reponse.status) {
            reponse.data.row
          }
        })
      }
    }
  }
}
</script>

<style scoped>
.content {
  margin-left: auto;
  margin-right: auto;
}
</style>
