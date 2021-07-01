<template>
  <div>
    <el-button type="primary" size="mini" round @click="this.showEditData">用户编辑</el-button>
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
          <el-select v-model="form.selectGender" placeholder="请选择性别" style="float: left">
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
        <el-button type="primary" @click="confirmEdit">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import userAdmin from '@/api/userAdmin'

export default {
  name: 'Edit',
  props: ['id'],
  data() {
    return {
      dialogVisible: false,
      userId: null,
      form: {
        userName: '',
        selectType: '',
        selectGender: ''
      },
      selectType: {},
      selectGender: {}
    }
  },

  methods: {
    selectCategoryByID() {
      userAdmin.selectCategoryByID(this.id).then(res => {
        this.form.selectType = res.data.categoryByID
      })
    },
    selectGenderByID() {
      this.userId = this.id
      userAdmin.selectGenderByID(this.userId).then(res => {
        this.form.selectGender = res.data.genderByID
      })
    },
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
    },

    showEditData() {
      this.userId = this.id
      userAdmin.showEditUserById(this.userId).then(res => {
        this.dialogVisible = true
        this.form = res.data.editData
        this.genderData()
        this.categoryData()
        this.selectCategoryByID()
        this.selectGenderByID()
      })
    },
    confirmEdit() {
      userAdmin.updateUserById(this.form, this.id).then(res => {
        this.dialogVisible = false
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
