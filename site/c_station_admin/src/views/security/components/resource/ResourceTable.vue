<template>
  <el-table
    :data="list"
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
      align="center"
      label="资源名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="url"
      align="center"
      label="资源URL">
    </el-table-column>
    <el-table-column
      prop="description"
      align="center"
      label="描述">
    </el-table-column>
    <el-table-column
      prop="gmtModified"
      align="center"
      :formatter="dateFormat"
      label="修改时间">
    </el-table-column>
    <el-table-column
      align="center"
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button type="text" size="small" @click="edit(scope.row)">编辑</el-button>
        <el-button type="text" size="small" @click="remove(scope.row.id, scope.row.name)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import securityAPI from '@/api/securityAPI'
import PubSub from 'pubsub-js'
import moment from 'moment'

export default {
  name: 'ResourceTable',
  props: {
    list: Array
  },
  data() {
    return {
      dialogFormVisible: false
    }
  },
  methods: {
    edit(row) {
      PubSub.publish('resourceForm', {
        'row': row
      })
    },
    removeResource(id) {
      securityAPI.removeResourceById(id).then(response => {
        return response.status
      })
    },
    remove(id, name) {
      // 弹出确认框
      this.$confirm('此操作将永久删除该  ' + name + '  URL资源, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // eslint-disable-next-line no-undef
        if (this.removeResource(id)) {
          this.$notify({
            title: '成功',
            message: '删除成功!',
            type: 'success'
          })
        } else {
          this.$notify.error({
            title: '错误',
            message: '删除失败! 请稍后在试~'
          })
        }
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
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
