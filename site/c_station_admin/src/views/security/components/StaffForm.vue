<template>
  <el-dialog title="分配角色" :visible.sync="dialogFormVisible">
    <el-transfer
      v-model="value"
      filterable
      :titles="['可选角色', '已有角色']"
      filter-placeholder="搜索"
      :props="{
        key: 'id',
        label: 'name'
      }"
      :data="data">
    </el-transfer>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="upData">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
import PubSub from 'pubsub-js'
import securityAPI from '@/api/securityAPI'

export default {
  name: 'StaffForm',
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
        if (response.status) { // 请求成功
          // 加载数据
          this.value = response.data.roles
        } else {
          this.dialogFormVisible = false // 关闭弹窗
        }
      })
    })
  },
  methods: {
    filterMethod(query, item) {
      return item.pinyin.indexOf(query) > -1
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
