<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%"
  >
    <el-table-column
      prop="id"
      label="用户编号"
      width="180"
    />
    <el-table-column
      prop="username"
      label="账号"
      width="180"
    />
    <el-table-column
      prop="nickName"
      label="姓名"
    />
    <el-table-column
      prop="email"
      label="邮箱"
    />
    <el-table-column
      prop="createTime"
      label="创建时间"
    />
    <el-table-column
      prop="status"
      label="是否可用"
    >
      <template slot-scope="scope">
        <el-switch
          v-model="scope.row.status"
          @change="change(scope.row.id, scope.row.status)"
          active-color="#13ce66"
          inactive-color="#ff4949">
        </el-switch>
      </template>
    </el-table-column>
    <el-table-column
      prop="address"
      label="操作"
    >
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row.id)" type="text" size="small">查看</el-button>
        <el-button type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: 'AdminList',
  data() {
    return {
      tableData: [{
        id: '53486865',
        username: '2698422@163.com',
        nickName: '马云',
        email: '2698422@163.com',
        createTime: '2020-03-17 23:12:11',
        status: true
      },
      {
        id: '53486865',
        username: '2698422@163.com',
        nickName: '马云',
        email: '2698422@163.com',
        createTime: '2020-03-17 23:12:11',
        status: false
      },
      {
        id: '53486865',
        username: '2698422@163.com',
        nickName: '马云',
        email: '2698422@163.com',
        createTime: '2020-03-17 23:12:11',
        status: false
      },
      {
        id: '53486865',
        username: '2698422@163.com',
        nickName: '马云',
        email: '2698422@163.com',
        createTime: '2020-03-17 23:12:11',
        status: true
      },
      {
        id: '53486865',
        username: '2698422@163.com',
        nickName: '马云',
        email: '2698422@163.com',
        createTime: '2020-03-17 23:12:11',
        status: true
      },
      {
        id: '53486865',
        username: '2698422@163.com',
        nickName: '马云',
        email: '2698422@163.com',
        createTime: '2020-03-17 23:12:11',
        status: true
      },
      {
        id: '53486865',
        username: '2698422@163.com',
        nickName: '马云',
        email: '2698422@163.com',
        createTime: '2020-03-17 23:12:11',
        status: true
      }]
    }
  },
  methods: {
    change(id, status) {
      alert(id + status)
    },
    handleClick(id) {
      // 1
    }
  }
}
</script>

<style scoped>

</style>
