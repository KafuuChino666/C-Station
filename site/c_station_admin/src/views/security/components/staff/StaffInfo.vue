<template>
  <div class="pater-container">
    <el-form :rules="rules.StaffAddFrom" ref="form" :model="form" label-width="80px" style="width: 500px">
      <el-form-item label="用户名" prop="username">
        <el-input :disabled="isEcho" v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input :disabled="isEcho" placeholder="请输入密码" v-model="form.password" show-password></el-input>
      </el-form-item>
      <el-form-item label="手机号" prop="mobile">
        <el-input v-model="form.mobile"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="form.email"></el-input>
      </el-form-item>
      <el-form-item label="昵称" prop="nickName">
        <el-input v-model="form.nickName"></el-input>
      </el-form-item>
      <el-form-item label="绑定角色">
        <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
        <div style="margin: 15px 0;"></div>
        <el-checkbox-group v-model="checkedRoles" @change="handleCheckedRolesChange">
          <el-checkbox v-for="role in roles" :label="role.id" :key="role.id">{{ role.name }}</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="备注信息">
        <el-input type="textarea" v-model="form.remark"></el-input>
      </el-form-item>
      <el-form-item label="帐号启用状态">
        <el-switch v-model="form.status"></el-switch>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">{{ !isEcho ? '立即创建' : '修改信息' }}</el-button>
        <el-button v-if="!isEcho">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import securityAPI from '@/api/securityAPI'
import rule from '@/rules/rule'

export default {
  data() {
    return {
      name: 'StaffInfo',
      rules: rule,
      isIndeterminate: true,
      checkAll: false,
      staffId: this.$route.query.id, // 如果是表单回显，有值
      isEcho: false,
      form: {
        id: '',
        username: '',
        password: '',
        email: '',
        mobile: '',
        nickName: '',
        remark: '',
        status: false
      },
      roles: [],
      checkedRoles: []
    }
  },
  mounted() {
    // 加载数据
    this.loadData()
    if (this.staffId) {
      // 如果是表单回显
      this.isEcho = true
      // 获取回显数据
      this.getEchoData(this.staffId)
    }
  },
  methods: {
    loadData() {
      securityAPI.getRoleList().then(res => {
        this.roles = res.data.list
      })
    },
    onSubmit() {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          this.form.roles = this.checkedRoles
          securityAPI.addStaff(this.form).then(res => {
            this.$message({
              message: res.data.message,
              type: 'success'
            })
          })
        }
      })
    },
    handleCheckAllChange(val) {
      if (val) {
        const data = []
        this.roles.forEach(role => {
          data.push(role.id)
        })
        this.checkedRoles = data
      } else {
        this.checkedRoles = []
      }
      this.isIndeterminate = false
    },
    handleCheckedRolesChange(value) {
      const checkedCount = value.length // 选定值个数
      this.checkAll = checkedCount === this.roles.length
      this.isIndeterminate = checkedCount > 0 && checkedCount < this.roles.length
    },
    // 根据id获取回显数据
    getEchoData(staffId) {
      securityAPI.getEchoData(staffId).then(res => {
        this.form = res.data.staff
        // 修改角色
        this.checkedRoles = res.data.staff.roles
      })
    }
  }
}
</script>

<style>
.pater-container{
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
  /*padding: 30px;*/
}
</style>
