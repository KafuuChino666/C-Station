<template>
  <el-dialog title="添加菜单" :visible.sync="dialogFormVisible">
    <el-form :model="form">
      <el-form-item label="组件名称:" :label-width="formLabelWidth">
        <el-input v-model="form.name" size="small" style="width: 300px"/>
      </el-form-item>
      <el-form-item label="前端名称:" :label-width="formLabelWidth">
        <el-input v-model="form.title" size="small" style="width: 300px"/>
      </el-form-item>
      <el-form-item label="前端图标:" :label-width="formLabelWidth">
        <icon-picker v-model="form.icon" style="width: 300px"></icon-picker>
      </el-form-item>
      <el-form-item label="访问路径(path):" :label-width="formLabelWidth">
        <el-input v-model="form.path" size="small" style="width: 300px"/>
      </el-form-item>
      <el-form-item label="redirect:" :label-width="formLabelWidth">
        <el-input v-model="form.redirect" size="small" style="width: 300px"/>
      </el-form-item>
      <el-form-item label="组件路径:" :label-width="formLabelWidth">
        <el-input v-model="form.component" size="small" style="width: 300px"/>
      </el-form-item>
      <el-form-item label="父级ID:" :label-width="formLabelWidth">
        <el-cascader
          v-model="parentId"
          clearable
          :options="menuList"
          placeholder="不选默认为0(跟组件)"
          :props="{
            expandTrigger: 'hover',
            value: 'id',
            label: 'name',
            children: 'children',
            checkStrictly: true
          }" ></el-cascader>
      </el-form-item>
      <el-form-item label="菜单排序:" :label-width="formLabelWidth">
        <el-input v-model="form.sort" size="small" style="width: 300px" />
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
      parentId: [],
      form: {
        parentId: '',
        path: '',
        redirect: '',
        component: '',
        sort: '',
        name: '',
        title: '',
        icon: '',
        hasChildren: 0
      },
      formLabelWidth: '120px',
      parentIdList: [],
      value: '',
      formType: 'add',
      menuList: []
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
      securityAPI.getHierarchyMenu().then(response => {
        if (response.status) {
          this.menuList = response.data.rows
        }
      })
    })
  },
  methods: {
    add() {
      // 添加
      if (this.parentId.length === 1) {
        this.form.parentId = this.parentId[0]
      } else {
        this.form.parentId = this.parentId[1]
      }

      securityAPI.addMrnu(this.form).then(response => {
        this.dialogFormVisible = false
        if (response.status) {
          // 提示成功消息
          this.$notify({
            title: '成功',
            message: '菜单添加成功！',
            type: 'success'
          })
          this.$parent.fetchData()
          // this.$router.push('/security/menu')
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
