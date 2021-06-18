<template>
  <el-button type="danger" size="mini" round @click="open">删除用户</el-button>
</template>

<script>
import userAdmin from '@/api/userAdmin'

export default {
  name: 'Edit',
  data() {
    return {
      userId: ''
    }
  },
  methods: {
    open() {
      this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
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
    deleteUserById() {
      // userAdmin.selectAllCategory().then(res => {
      //   console.log(res.data.rows)
      //   this.selectType = res.data.rows
      // }).catch(error => {
      //   console.log(error)
      // })
      this.userId = this.$parent.$parent.$parent.$parent.id
      userAdmin.updateUserById(this.userId).then(res => {
        console.log('已发送' + this.userInfo.userId)
      })
    }
  }
}
</script>

<style>

</style>
