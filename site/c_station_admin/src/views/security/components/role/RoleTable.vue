<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="id"
      label="ID"
      align="center"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="名称"
      align="center"
      width="180">
    </el-table-column>
    <el-table-column
      prop="description"
      align="center"
      label="描述">
    </el-table-column>
    <el-table-column
      prop="status"
      align="center"
      width="80"
      label="启用状态">
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
      prop="gmtModified"
      align="center"
      :formatter="dateFormat"
      label="修改时间">
    </el-table-column>
    <el-table-column
      align="center"
      label="操作">
      <template slot-scope="scope">
        <router-link :to="'/security/role/info/' + scope.row.id">
          <el-button type="text" size="small">编辑</el-button>
        </router-link>
        <router-link :to="{name:'RoleMenuBind', params: {id:scope.row.id, active:1}}">
          <el-button type="text" size="small">绑定菜单</el-button>
        </router-link>
        <router-link :to="{name:'RoleResourceBind', params: {id:scope.row.id, active:2}}">
          <el-button type="text" size="small">绑定资源</el-button>
        </router-link>
        <el-button type="text" size="small" @click="removeRole(scope.row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import moment from 'moment'
import securityAPI from '@/api/securityAPI'

export default {
  name: 'RolesTable',
  props: {
    // eslint-disable-next-line vue/require-default-prop
    tableData: Array
  },
  methods: {
    dateFormat(row, column) {
      const date = row[column.property]
      if (date === undefined) {
        return ''
      }
      return moment(date).format('YYYY-MM-DD HH:mm:ss')
    },
    removeRole(id) {
      // 弹出确认框
      this.$confirm('此操作将永久删除该角色, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 点击确认删除后请求API
        securityAPI.removeRoleById(id).then(res => {
          if (res.status) {
            this.$notify({
              title: '成功',
              message: '角色删除成功！',
              type: 'success'
            })
            // this.$router.push('/security/role/list')
            this.$parent.fetchData()
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    changeStatus(id, status) {
      securityAPI.updateRoleStatusById(id, status).then(res => {
        if (res.status) {
          this.$notify({
            title: '成功',
            message: '角色删除成功！',
            type: 'success'
          })
        } else {
          status = false
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
