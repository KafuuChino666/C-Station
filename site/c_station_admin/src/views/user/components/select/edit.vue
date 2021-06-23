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
          <el-input v-model="form.userName" style="float: left" />
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="form.gender" placeholder="请选择性别" style="float: left">
            <el-option
              v-for="item in selectGender"
              :key="item.id"
              :label="item.gender"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="用户分类">
          <el-select v-model="form.selectType" placeholder="请选择类型" style="float: left">
            <el-option
              v-for="item in selectType"
              :key="item.id"
              :label="item.category"
              :value="item.id"
            />
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
import userAdmin from '@/api/userAdmin'

export default {
  data() {
    return {
      dialogVisible: false,
      form: {
        userName: '',
        selectType: '',
        selectGender: ''
      },
      selectType: {},
      selectGender: {}
    }
  },

  created() {
    this.categoryData()
    this.genderData()
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
    },
    categoryData() {
      userAdmin.selectAllCategory().then(res => {
        this.selectType = res.data.category
      })
    },
    genderData() {
      userAdmin.selectAllGender().then(res => {
        this.selectGender = res.data.gender
      })
    }
  }
}
</script>

<style>
/*.el-select {
  width: 110px;
}*/
</style>
