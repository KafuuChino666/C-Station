<template>
  <el-dialog title="修改资源" :visible.sync="dialogFormVisible">
    <el-form :model="form">
      <el-form-item label="资源名称:" :label-width="formLabelWidth">
        <el-input v-model="form.name" size="small" style="width: 300px" />
      </el-form-item>
      <el-form-item label="资源URL:" :label-width="formLabelWidth">
        <el-input v-model="form.url" placeholder="请使用Ant表达式" style="width: 300px" />
      </el-form-item>
      <el-form-item label="描述:" :label-width="formLabelWidth">
        <el-input v-model="form.description" type="textarea" style="width: 300px" />
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="confirmFun">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
import PubSub from 'pubsub-js'
import securityAPI from '@/api/securityAPI'

export default {
  name: 'ResourceForm',
  data() {
    return {
      dialogFormVisible: false,
      form: {
        name: '',
        url: '',
        description: ''
      },
      row: {},
      formType: 0, // 0=> 创建 1=> 编辑
      formLabelWidth: '120px'
    }
  },
  mounted() {
    PubSub.subscribe('resourceForm', (event, data) => {
      this.dialogFormVisible = true
      this.row = data.row
      this.formType = data.formType
      if (this.row !== {}) {
        this.form = JSON.parse(JSON.stringify(data.row)) // 深拷贝
      }
    })
  },
  methods: {
    update() {
      // 发送数据更新请求
      securityAPI.updateResource(this.form).then(response => {
        if (response.status) { // 更新成功
          this.dialogFormVisible = false
          this.row = this.form // 更新表中数据
          this.$notify({
            title: '成功',
            message: '资源更新成功!',
            type: 'success'
          })
        }
      })
    },
    add() {
      // 发送数据添加请求
      securityAPI.addResource(this.form).then(response => {
        if (response.status) { // 添加成功
          this.dialogFormVisible = false
          this.$notify({
            title: '成功',
            message: '资源添加成功! 手动刷新',
            type: 'success'
          })
        }
      })
    },
    confirmFun() {
      if (this.formType === 0) { // 添加模式
        // 调用添加
        this.add()
      } else { // 更新
        this.update()
      }
    }
  }
}
</script>

<style scoped>

</style>
