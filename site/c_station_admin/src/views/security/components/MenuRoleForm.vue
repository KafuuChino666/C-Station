<template>
  <el-dialog title="绑定角色" :visible.sync="dialogFormVisible">
    <el-form :model="form">
      <el-checkbox v-model="checkAll" :indeterminate="isIndeterminate" @change="handleCheckAllChange">全选</el-checkbox>
      <div style="margin: 15px 0;" />
      <el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
        <el-checkbox v-for="city in cities" :key="city.id" :label="city.id">{{ city.name }}</el-checkbox>
      </el-checkbox-group>
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
  name: 'MenuRoleForm',
  data() {
    return {
      dialogFormVisible: false,
      form: {},
      formLabelWidth: '120px',
      checkAll: false,
      // 默认选中
      checkedCities: [1, 2],
      // 所有角色
      cities: [{
        id: 1,
        name: '超管'
      },
      {
        id: 2,
        name: '视频审核'
      },
      {
        id: 3,
        name: '内容审核'
      },
      {
        id: 4,
        name: '番剧管理'
      },
      {
        id: 5,
        name: '漫画管理'
      },
      {
        id: 6,
        name: '频道管理'
      },
      {
        id: 7,
        name: '动画管理'
      }
      ],
      isIndeterminate: true
    }
  },
  mounted() {
    PubSub.subscribe('menuRoleForm', (event, data) => {
      this.dialogFormVisible = true

      // 获取所有角色
      securityAPI.getRoleList().then(response => {
        this.cities = response.status ? response.data.list : []
      })

      // 获取此url拥有角色
      securityAPI.getRolesMenuById(data.id).then(response => {
        this.checkedCities = response.status ? response.data : []
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
      this.dialogFormVisible = true
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
