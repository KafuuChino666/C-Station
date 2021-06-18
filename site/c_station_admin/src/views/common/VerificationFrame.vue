<template>
  <el-dialog
    class="auth-container"
    :title="title"
    :visible.sync="dialogVisible"
    width="30%"
    :before-close="handleClose">
    <div class="auth_body">
      <el-tag>为了您的账户安全，进行敏感操作前必须先验证身份。<br>若手机已不再使用，点击这里修改手机码。</el-tag>
      <el-form size="mini" label-position="left" label-width="80px">
        <el-form-item label="名称">
          <el-input></el-input>
        </el-form-item>
        <el-form-item label="活动区域">
          <el-input></el-input>
        </el-form-item>
        <el-form-item label="活动形式">
          <el-input></el-input>
        </el-form-item>
      </el-form>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: 'VerificationFrame',
  props: {
    // 弹窗标题
    title: {
      type: String,
      required: false,
      default: '安全验证'
    },
    // 是否现实
    dialogVisible: {
      type: Boolean,
      required: false,
      default: false
    }
  },
  methods: {
    handleClose() {
      this.dialogVisible = false
    }
  }
}
</script>

<style>
.auth-container .el-dialog__header {
  padding-bottom: 15px;
  padding-top: 15px;
}
.auth-container .el-dialog__body {
  padding: 0;
}
.auth-container .el-divider--horizontal {
  margin: 0;
}
.auth-container .el-tag {
  border-radius: 0;
  width: 100%;
}
.auth-container span {
  word-break:normal;
  height: auto;
  line-height: 15px;
  padding: 8px 10px 8px;
}
.auth-container .el-form-item__label {
  font-weight: 100;
  font-size: 10px;
  color: #2a2a2b;
}
.auth_body {
  margin: 0 20px;
}
</style>
