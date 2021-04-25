<template>
  <div class="content">
    <el-table
      :data="tableData"
      ref="multipleTable"
      height="400"
      border
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        prop="name"
        label="资源名称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="url"
        label="资源URL"
        width="180">
      </el-table-column>
      <el-table-column
        prop="description"
        label="描述">
      </el-table-column>
    </el-table>
    <div style="text-align:center; margin-top: 20px">
      <el-button v-if="this.$route.params.id === undefined" type="primary" @click="prev()">上一步</el-button>
      <el-button v-text="this.$route.params.id === undefined ? '下一步' : '绑定资源'" :disabled="publishBtnDisabled" type="primary" @click="publish()">添加角色</el-button>
    </div>
  </div>
</template>

<script>
import securityAPI from '@/api/securityAPI'
import { Loading } from 'element-ui'

export default {
  name: 'RoleResourceBind',
  data() {
    return {
      publishBtnDisabled: false,
      tableData: [], // 资源列表
      multipleSelection: []
    }
  },
  mounted() {
    this.fetchData()
  },
  methods: {

    // 上一步
    prev() {
      this.$parent.active = 1
    },

    // 下一步
    publish() {
      this.publishBtnDisabled = true
      this.$parent.active = 3
      // 判断id 是否是编辑状态
      const roleId = this.$route.params.id
      if (roleId !== undefined) {
        const list = []
        this.multipleSelection.forEach(d => {
          list.push(d.id)
        })
        // 更新角色资源
        securityAPI.updateRoleResourceByRoleId(roleId, list).then(res => {
          if (res.status) {
            this.$notify({
              title: '成功',
              message: '资源更新成功！',
              type: 'success'
            })
          }
        })
        // 路由跳转->角色列表
        this.$router.push('/security/role/list')
      } else {
        const list = []
        this.multipleSelection.forEach(d => {
          list.push(d.id)
        })
        this.$parent.addRoleForm.resourceList = list
        // 打开等待响应页面
        const loadingInstance = Loading.service({
          text: '正在创建当中请稍后...'
        })
        // 提交addRoleForm表单数据
        securityAPI.addRole(this.$parent.addRoleForm).then(res => {
          if (res.status) {
            // 关闭
            this.$nextTick(() => {
              loadingInstance.close()
            })
            // 跳转
            this.$router.push('/security/role/list')
            // 提示成功消息
            this.$notify({
              title: '成功',
              message: '角色添加成功！',
              type: 'success'
            })
          }
        })
      }
    },

    handleSelectionChange(val) {
      this.multipleSelection = val
    },
    fetchData() {
      // 获取资源列表
      securityAPI.getResourceList().then(res => {
        if (res.status) {
          this.tableData = res.data.rows
        }
      })
      // 判断id 是否是编辑状态
      const id = this.$route.params.id
      if (id !== undefined) {
        // 获取角色所拥有的资源列表
        securityAPI.getResourceByRoleId(id).then(res => {
          if (res.status) {
            this.tableData.forEach(p => {
              res.data.rows.forEach(r => {
                if (r === p.id) {
                  this.$refs.multipleTable.toggleRowSelection(p)
                }
              })
            })
          }
        })
      }
    }
  }
}
</script>

<style scoped>
.content {
  width: 1000px;
  margin-top: 30px;
}
</style>
