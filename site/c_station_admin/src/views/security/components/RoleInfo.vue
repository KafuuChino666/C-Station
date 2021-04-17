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
export default {
  name: 'RoleInfo',
  data() {
    return {
      saveBtnDisabled: false,
      form: {
        name: '',
        status: true,
        description: ''
      },
      formLabelWidth: '120px'
    }
  },
  methods: {
    // 保存并下一步
    saveAndNext() {
      this.saveBtnDisabled = true
      this.$parent.active = 1
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
