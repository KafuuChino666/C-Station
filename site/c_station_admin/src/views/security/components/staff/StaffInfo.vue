<template>
  <div class="pater-container">
    <el-form ref="form" :model="form" label-width="80px" style="width: 500px">
      <el-form-item label="用户名">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input placeholder="请输入密码" v-model="form.password" show-password></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="form.email"></el-input>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="form.nickName"></el-input>
      </el-form-item>
      <el-form-item label="绑定角色">
        <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
        <div style="margin: 15px 0;"></div>
        <el-checkbox-group v-model="roles" @change="handleCheckedCitiesChange">
          <el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="备注信息">
        <el-input type="textarea" v-model="form.remark"></el-input>
      </el-form-item>
      <el-form-item label="帐号启用状态">
        <el-switch v-model="form.status"></el-switch>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      name: 'StaffInfo',
      form: {
        id: '',
        username: '',
        password: '',
        email: '',
        nickName: '',
        remark: '',
        status: false
      },
      roles: ['角色1']
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!')
    }
  }
}
</script>

<style scoped>
.pater-container{
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
  padding: 30px;
}
</style>
