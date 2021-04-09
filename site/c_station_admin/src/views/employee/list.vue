<template>
  <el-row>
    <el-col :span="24" style="padding-top: 20px">
      <div class="grid-content bg-purple-dark">
        <!--   搜索框   -->
        <div style="margin-top: 15px; width: 30%">
          <el-input v-model="selectContent" placeholder="请输入姓名" class="input-with-select">
            <el-select slot="prepend" v-model="select" placeholder="请选择">
              <el-option label="审核" value="1" />
              <el-option label="管理员" value="2" />
              <el-option label="超管" value="3" />
            </el-select>
            <el-button slot="append" icon="el-icon-search" />
          </el-input>
        </div>
        <!--  搜索框 END  -->

        <!--  员工列表  -->
        <EmList />

        <!--  分页  -->
        <el-row :gutter="20">
          <el-col :span="12" :offset="9">
            <el-pagination
              background
              layout="prev, pager, next"
              :total="1000"
              style="width: 100%"
            />
          </el-col>
        </el-row>
        <!--  分页 END  -->
      </div>
    </el-col>
  </el-row>
</template>

<script>
import EmList from '@/views/employee/components/EmList'

export default {
  name: 'List',
  components: {
    EmList
  },
  data() {
    return {
      selectContent: '',
      select: ''
    }
  }
}
</script>

<style scoped>
.grid-content {
  min-height: 700px;
  margin-right: 20px;
  margin-left: 20px;
  margin-top: 40px;
}
.bg-purple-dark {
  /*background: #e7ecec;*/
}

.el-select {
  width: 130px;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
</style>
