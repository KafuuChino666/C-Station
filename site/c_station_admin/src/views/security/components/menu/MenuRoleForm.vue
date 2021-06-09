<template>
  <el-dialog title="绑定角色" :visible.sync="dialogFormVisible">
    <el-form :model="form">
      <el-checkbox v-model="checkAll" :indeterminate="isIndeterminate" @change="handleCheckAllChange">全选</el-checkbox>
      <div style="margin: 15px 0;" />
      <el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
        <el-checkbox v-for="city in cities" :key="city.id" :label="city.id">{{ city.name }}</el-checkbox>
      </el-checkbox-group>
      <el-switch
        v-model="batch"
        active-text="(本菜单和子菜单批量绑定角色)">
      </el-switch>
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
import router from '@/router'

export default {
  name: 'MenuRoleForm',
  data() {
    return {
      dialogFormVisible: false,
      form: {},
      formLabelWidth: '120px',
      checkAll: false,
      // 默认选中
      checkedCities: [1, 2],
      menuId: 0,
      // 所有角色
      cities: [],
      isIndeterminate: true,
      batch: false
    }
  },
  mounted() {
    PubSub.subscribe('menuRoleForm', (event, data) => {
      this.dialogFormVisible = true
      this.menuId = data.id

      // 获取所有角色
      securityAPI.getRoleList().then(response => {
        this.cities = response.status ? response.data.list : []
      })

      // 获取此url拥有角色
      securityAPI.getRolesMenuById(data.id).then(response => {
        this.checkedCities = response.status ? response.data.rows : []
      })
    })
  },
  methods: {
    handleCheckAllChange(val) {
      if (val) {
        const data = []
        this.cities.forEach(citie => {
          data.push(citie.id)
        })
        this.checkedCities = data
      } else {
        this.checkedCities = []
      }
      this.isIndeterminate = false
    },
    handleCheckedCitiesChange(value) {
      const checkedCount = value.length // 选定值个数
      this.checkAll = checkedCount === this.cities.length
      this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length
    },
    // 确定函数
    confirmFun() {
      securityAPI.updataMenuRole(this.menuId, this.checkedCities, this.batch).then(response => {
        if (response.status) {
          this.dialogFormVisible = false
          this.$notify({
            title: '成功',
            message: '角色更新成功!',
            type: 'success'
          })
        }
      })
    }
  }
}
</script>

<style scoped>
.el-form{
  margin-left: 50px;
}
.el-checkbox {
  margin-bottom: 10px;
}
</style>
