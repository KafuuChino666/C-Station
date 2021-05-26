<template>
  <div>
    <!-- 搜索框开始 -->
    <div class="select" style="top: 10px ; width: 45%;">
      <el-form :inline="true" :model="select" class="demo-form-inline">
      <el-input v-model="select.selectUserID" placeholder="请输入用户ID" class="input-with-select" >
        <el-select slot="prepend" v-model="select.selectType" placeholder="请选择">
          <el-option
            v-for="item in selectType"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
<!--        <el-button slot="append" icon="el-icon-search" />-->
      </el-input>
      <el-input class="input-select"
        prefix-icon="el-icon-search"
        v-model="select.selectUserName"
        placeholder="请输入用户昵称关键字">
      </el-input>
      <el-button type="primary" icon="el-icon-search" @keyup.enter="selectUserByInfo">搜索</el-button>
      </el-form>
    </div>
          <!-- 搜索框结束 -->
    <user-list/>
    <!--  分页  -->
    <div style="margin: 15px auto;">
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
    </div>
    <!--  分页 END  -->
  </div>
</template>

<script>
import userList from '@/views/user/components/userList'

export default {
  name: 'UserList',
  components: {
    userList
  },
  data() {
    return {
      select: {
        selectUserID: '', // 用户ID
        selectType: '', // 用户类型
        selectUserName: '' // 用户昵称
      },
      selectType: [{
        value: '1',
        label: '普通用户'
      }, {
        value: '2',
        label: '会员'
      }, {
        value: '3',
        label: '大会员'
      }], // 查询数据
      page: 1,
      limit: 6,
    }
  },
  methods: {
    // 查询用户信息
    selectUserByInfo() {
      userList.methods.fetchData(this.select, this.page, this.limit)
    }
  }
}
</script>

<style>
.el-select {
  width: 110px;
}

.select {
  margin:0 auto;
}

.el-input {
  margin:7px auto;
}

.el-button {
  margin:10px auto;
  float: right;
}

.input-select {
  width: 75%;
}

</style>
