<template>
  <el-dialog title="添加菜单" :visible.sync="dialogFormVisible">
    <el-form :model="form">
      <el-form-item label="菜单名称:" :label-width="formLabelWidth">
        <el-input v-model="form.title" size="small" style="width: 300px"/>
      </el-form-item>
      <el-form-item label="前端名称:" :label-width="formLabelWidth">
        <el-input v-model="form.name" size="small" style="width: 300px"/>
      </el-form-item>
      <el-form-item label="父级ID:" :label-width="formLabelWidth">
        <el-select v-model="form.parentId" filterable placeholder="请选择" style="width: 300px">
          <el-option
            v-for="item in parentIdList"
            :key="item.id"
            :label="item.title"
            :value="item.id">
            <span style="float: left">{{ item.title }}</span>
            <span style="float: right; color: #8492a6; font-size: 13px">{{ item.id }}</span>
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="前端图标:" :label-width="formLabelWidth">
        <el-input v-model="form.icon" size="small" style="width: 300px"/>
      </el-form-item>
      <el-form-item label="菜单排序:" :label-width="formLabelWidth">
        <el-input v-model="form.sort" size="small" style="width: 300px"/>
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
  name: 'MenuForm',
  data() {
    return {
      dialogFormVisible: false,
      form: {
        parentId: '',
        title: '',
        sort: '',
        name: '',
        icon: '',
        level: 0
      },
      formLabelWidth: '120px',
      parentIdList: [],
      value: '',
      formType: 'add'
    }
  },
  mounted() {
    PubSub.subscribe('menuForm', (event, data) => {
      this.form = {}
      this.parentIdList = []
      this.dialogFormVisible = true
      this.formType = data.formType
      // 如果不是add则进行表单回显
      if (this.formType !== 'add') {
        this.form = data.row
      }
      securityAPI.getMrnuList().then(response => {
        if (this.formType !== 'add') {
          response.data.rows = response.data.rows.filter(p => p.id !== data.row.id)
        }
        this.parentIdList = response.data.rows
      })
    })
  },
  methods: {
    add() {
      // 添加
      securityAPI.addMrnu(this.form).then(response => {
        this.dialogFormVisible = false
        if (response.status) {
          // 提示成功消息
          this.$notify({
            title: '成功',
            message: '菜单添加成功！',
            type: 'success'
          })
          this.$router.push('/security/menu')
        }
      })
    },
    update() {
      // 更新
      securityAPI.updateMenuById(this.form).then(response => {
        this.dialogFormVisible = false
        if (response.status) {
          // 提示成功消息
          this.$notify({
            title: '成功',
            message: '菜单更新成功！',
            type: 'success'
          })
        }
      })
    },
    confirmFun() {
      this.formType === 'add' ? this.add() : this.update()
    }
  }
}
</script>

<style scoped>

</style>
