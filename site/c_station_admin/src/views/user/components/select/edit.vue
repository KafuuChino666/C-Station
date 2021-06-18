<template>
  <div>
    <el-button type="primary" size="mini" round @click="dialogVisible = true">用户编辑</el-button>
    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose"
    >
      <!-- 表单开始 -->
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="昵称">
          <el-input v-model="form.name" style="float: left" />
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="form.sex" placeholder="性别" style="float: left">
            <el-option label="男" value="m" />
            <el-option label="女" value="w" />
          </el-select>
        </el-form-item>
        <el-form-item label="用户分类">
          <el-select v-model="form.selectType" placeholder="请选择类型" style="float: left">
            <el-option label="普通用户" value="common" />
            <el-option label="会员" value="vip" />
            <el-option label="大会员" value="b_vip" />
          </el-select>
        </el-form-item>
      </el-form>
      <!-- 表单结束 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogVisible: false,
      form: {
        name: '',
        selectType: '',
        sex: ''
      },
      selectType: {}
    }
  },
  methods: {
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    onSubmit() {
      console.log('submit!')
    }
  }
}
</script>

<style>
/*.el-select {
  width: 110px;
}*/
</style>
