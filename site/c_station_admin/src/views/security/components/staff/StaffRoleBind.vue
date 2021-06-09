<template>
  <el-dialog title="分配角色" :visible.sync="dialogFormVisible">
    <el-transfer
      v-model="value"
      filterable
      @change="roleChange"
      :titles="['可选角色', '已有角色']"
      filter-placeholder="搜索"
      :props="{
        key: 'id',
        label: 'name'
      }"
      :data="data">
    </el-transfer>
  </el-dialog>
</template>

<script>
import PubSub from 'pubsub-js'
import securityAPI from '@/api/securityAPI'

export default {
  name: 'StaffRoleBind',
  data() {
    return {
      id: 0,
      dialogFormVisible: false,
      data: [],
      value: []
    }
  },
  mounted() {
    PubSub.subscribe('staffForm', (event, data) => {
      // 获取数据中所有角色
      this.dialogFormVisible = data.dialogFormVisible
      securityAPI.getRoleList().then(response => {
        if (response.status) {
          this.data = response.data.list
        } else {
          this.dialogFormVisible = false // 关闭弹窗
        }
      })

      this.id = data.id
      // 获取当前用户拥有的角色
      securityAPI.getRolesStatusById(this.id).then(response => {
        this.value = response.data.roles
      }).catch(error => {
        console.log(error)
        this.dialogFormVisible = false // 关闭弹窗
      })
    })
  },
  methods: {
    roleChange(old, direction, keys) {
      if (direction === 'right') { // 添加角色
        securityAPI.staffBindRoles(this.id, keys).then(res => {
          this.$message({
            message: res.message,
            type: 'success'
          })
        })
      } else {
        securityAPI.staffCancelRoles(this.id, keys).then(res => {
          this.$message({
            message: res.message,
            type: 'success'
          })
        })
      }
    },
    upData() {
      securityAPI.updateRole(this.id, this.value).then(response => {
        if (response.status) {
          this.dialogFormVisible = false // 关闭弹窗
          // 提示信息
          this.$message({
            message: '用户角色更新成功!',
            type: 'success'
          })
        } else {
          // 提示
          this.$message.error('用户角色更新失败,请稍后在试~')
        }
      })
    }
  }
}
</script>

<style scoped>
.el-transfer {
  width: 590px;
  margin-left: auto;
  margin-right: auto;
}
</style>
