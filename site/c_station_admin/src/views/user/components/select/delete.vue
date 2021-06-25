<template>
  <el-button type="danger" size="mini" round v-if="this.stat !== 4" @click="openDelete">注销用户</el-button>
  <el-button type="danger" size="mini" round v-else @click="openUnDelete">解除注销</el-button>
</template>

<script>
import userAdmin from '@/api/userAdmin'

export default {
  name: 'Delete',
  props: ['id', 'stat'],
  data() {
    return {
      userId: ''
    }
  },
  methods: {
    openDelete() {
      this.$confirm('此操作将注销该用户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.deleteUserById()
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
      })
    },
    openUnDelete() {
      this.$confirm('此操作将解除注销该用户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.unDeleteUserById()
        this.$message({
          type: 'success',
          message: '解除成功!'
        })
      })
    },
    deleteUserById() {
      userAdmin.deleteUserById(this.id).then(res => {
      })
    },
    unDeleteUserById() {
      userAdmin.unDeleteUserById(this.id).then(res => {
      })
    }
  }
}
</script>

<style>

</style>
