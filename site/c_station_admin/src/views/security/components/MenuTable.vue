<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="id"
      label="ID"
      align="center"
      width="50">
    </el-table-column>
    <el-table-column
      prop="parentId"
      label="父级ID"
      align="center"
      width="80">
    </el-table-column>
    <el-table-column
      prop="title"
      align="center"
      label="菜单名称">
    </el-table-column>
    <el-table-column
      prop="level"
      align="center"
      label="菜单级数"
      width="80">
    </el-table-column>
    <el-table-column
      prop="sort"
      align="center"
      label="菜单排序"
      width="80">
    </el-table-column>
    <el-table-column
      prop="name"
      align="center"
      label="前端名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="icon"
      align="center"
      label="前端图标"
      width="80">
      <template slot-scope="scope">
        <i :class="scope.row.icon" />
      </template>
    </el-table-column>
    <el-table-column
      prop="hidden"
      align="center"
      label="前端隐藏"
      width="100">
      <template slot-scope="scope">
        <el-switch
          v-model="scope.row.hidden"
          active-color="#13ce66"
          inactive-color="#909399"
          @change="changeHiddenStatus(scope.row.id, scope.row.status)"
        />
      </template>
    </el-table-column>
    <el-table-column
      prop="gmtModified"
      align="center"
      label="修改时间">
    </el-table-column>
    <el-table-column
      label="操作"
      align="center"
      width="180">
      <template slot-scope="scope">
        <el-button type="text" size="small" @click="edit(scope.row)">编辑</el-button>
        <el-button type="text" size="small" @click="bindingRole(scope.row.id, scope.row.name)">绑定角色</el-button>
        <el-button type="text" size="small" @click="reomveMenu(scope.row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import securityAPI from '@/api/securityAPI'
import PubSub from 'pubsub-js'

export default {
  name: 'MenuTable',
  data() {
    return {
      tableData: [{
        id: '2',
        parentId: '3',
        title: '权限管理',
        level: '0',
        sort: '1',
        name: '权限',
        icon: 'el-icon-unlock',
        hidden: false,
        gmtModified: '2020-03-17 20:25:30'
      }]
    }
  },
  methods: {
    // 修改菜单隐藏状态
    changeHiddenStatus(id, status) {
      // 修改是否显示
      securityAPI.updateMenuStatus(id, status).then(response => {
        if (response.status) {
          this.$notify({
            title: '成功',
            message: '更新菜单隐藏状态成功！',
            type: 'success'
          })
        } else {
          status = !status
          this.$notify.error({
            title: '错误',
            message: '更新菜单隐藏状态失败！'
          })
        }
      })
    },
    edit(row) {
      // 编辑
    },
    // 给菜单绑定角色
    bindingRole(id, name) {
      // 弹出角色选择框
      PubSub.publish('menuRoleForm', {
        id,
        name
      })
    },
    reomveMenu(id) {
      // 删除菜单
    }
  }
}
</script>

<style scoped>

</style>
