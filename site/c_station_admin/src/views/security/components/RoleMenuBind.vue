<template>
  <div>
    <el-tree
      :data="menuList"
      ref="tree"
      show-checkbox
      default-expand-all
      node-key="id"
      :props="defaultProps">
    </el-tree>
    <div style="text-align:center">
      <el-button v-if="this.$route.params.id === undefined" type="primary" @click="prev()">上一步</el-button>
      <el-button v-text="this.$route.params.id === undefined ? '下一步' : '绑定菜单'" type="primary" @click="next()">下一步</el-button>
    </div>
  </div>
</template>

<script>
import securityAPI from '@/api/securityAPI'

export default {
  name: 'RoleMenuBind',
  data() {
    return {
      menuList: [],
      defaultProps: {
        children: 'children',
        label: 'name'
      }
    }
  },
  mounted() {
    this.fetchData()
  },
  methods: {
    // 上一步
    prev() {
      this.$parent.active = 0
    },

    // 下一步
    next() {
      // console.log(this.$refs.tree.getCheckedKeys())
      // 判断id 是否是编辑状态
      const id = this.$route.params.id
      if (id !== undefined) {
        // eslint-disable-next-line no-undef
        securityAPI.updateMenuByRoleId(id, this.$refs.tree.getCheckedKeys()).then(response => {
          if (response.status) {
            this.$notify({
              title: '成功',
              message: '菜单更新成功！',
              type: 'success'
            })
          }
        })
        // 路由跳转->角色列表
        this.$router.push('/security/role/list')
      } else {
        // 跳转
        this.$parent.addRoleForm.menuList = this.$refs.tree.getCheckedKeys()
        this.$parent.active = 2
      }
    },

    // 数据加载
    fetchData() {
      securityAPI.getHierarchyMenu().then(response => {
        if (response.status) {
          this.menuList = response.data.rows
        }
      })
      // 判断id 是否是编辑状态
      const id = this.$route.params.id
      if (id !== undefined) {
        // 获取角色所拥有的菜单
        securityAPI.getMenuByRoleId(id).then(response => {
          if (response.status) {
            this.$refs.tree.setCheckedKeys(response.data.rows)
          }
        })
      }
    }
  }
}
</script>

<style scoped>
.el-tree {
  margin-left: 20%;
  margin-top: 30px;
  width: 60%;
}
</style>
