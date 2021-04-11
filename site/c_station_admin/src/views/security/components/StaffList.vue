<template>
  <el-table
    :data="list"
    border
    style="width: 100%"
  >
    <el-table-column
      prop="id"
      align="center"
      label="用户编号"
      width="180"
    />
    <el-table-column
      prop="username"
      label="账号"
      align="center"
      width="180"
    />
    <el-table-column
      prop="nickName"
      align="center"
      label="姓名"
    />
    <el-table-column
      prop="email"
      align="center"
      label="邮箱"
    />
    <el-table-column
      prop="gmtCreate"
      align="center"
      label="创建时间"
      :formatter="dateFormat"
    />
    <el-table-column
      prop="status"
      align="center"
      label="是否可用"
    >
      <template slot-scope="scope">
        <el-switch
          v-model="scope.row.status"
          active-color="#13ce66"
          inactive-color="#ff4949"
          @change="changeStatus(scope.row.id, scope.row.status)"
        />
      </template>
    </el-table-column>
    <el-table-column
      prop="address"
      align="center"
      label="操作"
    >
      <template slot-scope="scope">
        <el-button type="text" size="small" @click="handleClick(scope.row.id)">查看</el-button>
        <el-button type="text" size="small">修改权限</el-button>
        <el-button type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import securityAPI from '@/api/securityAPI'
import moment from 'moment'

import PubSub from 'pubsub-js'

export default {
  name: 'StaffList',
  props: {
    // eslint-disable-next-line vue/require-default-prop
    'list': Array
  },
  methods: {
    // 改变用户状态
    changeStatus(id, status) {
      securityAPI.updateStaffStatusById(id, status).then(response => {
        if (response.status) {
          this.$message({
            message: '成功更新用户状态！',
            type: 'success'
          })
        } else {
          this.$message.error('更新用户状态失败!')
        }
      })
    },
    handleClick(id) {
      PubSub.publish('staffForm', {
        dialogFormVisible: true,
        'id': id
      })
    },
    dateFormat(row, column) {
      const date = row[column.property]
      if (date === undefined) {
        return ''
      }
      return moment(date).format('YYYY-MM-DD HH:mm:ss')
    }
  }
}
</script>

<style scoped>

</style>
