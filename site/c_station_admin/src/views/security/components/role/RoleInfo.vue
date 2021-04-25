<template>
  <div>
    <el-form :model="form">
      <el-form-item label="角色名称:" :label-width="formLabelWidth">
        <el-input v-model="form.name" size="small" style="width: 300px" />
      </el-form-item>
      <el-form-item label="描述:" :label-width="formLabelWidth">
        <el-input v-model="form.description" type="textarea" style="width: 300px" />
      </el-form-item>
      <el-form-item label="角色状态:" :label-width="formLabelWidth">
        <el-switch
          v-model="form.status"
          active-color="#13ce66"
          inactive-color="#ff4949"
        />
      </el-form-item>
    </el-form>
    <div style="text-align:center">
      <el-button :disabled="saveBtnDisabled" type="primary" @click="saveAndNext()">保存并下一步</el-button>
    </div>
  </div>
</template>

<script>
import securityAPI from '@/api/securityAPI'

export default {
  name: 'RoleInfo',
  data() {
    return {
      saveBtnDisabled: false,
      form: {
        id: this.$route.params.id,
        name: '',
        description: '',
        status: true
      },
      formLabelWidth: '120px'
    }
  },
  mounted() {
    // 加载数据
    this.fetchData()
  },
  methods: {
    // 保存并下一步
    saveAndNext() {
      // 如果id有值，则是编辑角色
      if (this.form.id !== undefined && this.form.id > 0) {
        // 调用接口修改角色
        this.updateRole()
        // 路由跳转->角色列表
        this.$router.push('/security/role/list')
      } else {
        // 添加角色模式...
        // 储存数据
        this.$parent.addRoleForm.roleInfo = this.form
        this.saveBtnDisabled = true
        this.$parent.active = 1
      }
    },
    // 获取数据
    fetchData() {
      // 判断id
      if (this.form.id !== undefined && this.form.id > 0) {
        // 请求
        securityAPI.getMenuById(this.form.id).then(reponse => {
          if (reponse.status) {
            this.form = reponse.data.row
          }
        })
      }
    },
    // 更新角色
    updateRole() {
      securityAPI.updateRoleById(this.form).then(response => {
        if (response.status) {
          // 提示成功消息
          this.$notify({
            title: '成功',
            message: '角色更新成功！',
            type: 'success'
          })
        }
      })
    }
  }
}
</script>

<style scoped>
.el-form {
  margin-left: 15%;
  margin-top: 30px;
}
</style>
