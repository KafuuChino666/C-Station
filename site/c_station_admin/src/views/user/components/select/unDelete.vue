<template>
  <el-button type="danger" size="mini" round @click="open">解除注销</el-button>
</template>

<script>
import userAdmin from '@/api/userAdmin'

export default {
  name: 'UnDelete',
  data() {
    return {
      userId: ''
    }
  },
  methods: {
    open() {
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
