<template>
  <el-button type="danger" size="mini" round @click="openDelete">注销用户</el-button>
  <el-button type="danger" size="mini" round @click="openUnDelete">解除注销</el-button>
</template>

<script>
import userAdmin from '@/api/userAdmin'

export default {
  name: 'Delete',
  data() {
    return {
      userId: '',
      stat: null,
    }
  },
  methods: {
    openDelete() {
      this.$confirm('此操作将永久封禁该用户, 是否继续?', '提示', {
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
      this.userId = this.$parent.$parent.$parent.$parent.id
      this.stat = 1
      userAdmin.deleteUserById(this.userId).then(res => {
        console.log('已发送' + this.userInfo.userId)
      })
    },
    unDeleteUserById() {
      this.userId = this.$parent.$parent.$parent.$parent.id
      userAdmin.unDeleteUserById(this.userId).then(res => {
        console.log('已发送' + this.userInfo.userId)
      })
    }
  }
}
</script>

<style>

</style>
