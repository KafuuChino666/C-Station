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
      <router-link :to="'/security/role/info/' + 1">
        <el-button type="text" size="small">编辑</el-button>
      </router-link>
      <el-button type="text" size="small">绑定菜单</el-button>
      <el-button type="text" size="small">绑定资源</el-button>
      <el-button type="text" size="small">删除</el-button>
    </el-table-column>
  </el-table>
</template>

<script>
import moment from 'moment'

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
    }
  }
}
</script>

<style scoped>

</style>
