<template>
  <div>
    <!-- 搜索框开始 -->
    <div class="select" style="top: 10px ; width: 45%;">
      <el-form :inline="true" :model="select" class="demo-form-inline">
        <el-input v-model="select.selectUserID" placeholder="请输入用户ID" class="input-with-select">
          <el-select slot="prepend" v-model="select.selectType" placeholder="请选择">
            <el-option
              v-for="item in selectType"
              :key="item.id"
              :label="item.category"
              :value="item.id"
            />
          </el-select>
          <!-- <el-button slot="append" icon="el-icon-search" />-->
        </el-input>
        <el-input
          v-model="select.selectUserName"
          class="input-select"
          prefix-icon="el-icon-search"
          placeholder="请输入用户昵称"
        />
        <el-button class="el-btn" type="primary" icon="el-icon-search" @click="selectUserByInfo">搜索</el-button>
        <el-button class="el-btn" type="success" icon="el-icon-plus" @click="insertUser">新增用户</el-button>
      </el-form>
    </div>
    <!-- 搜索框结束 -->
    <user-list />
    <!--  分页  -->
    <div v-if="users.length >= limit || page !== 1" class="block">
      <el-pagination
        layout="prev, pager, next"
        :current-page="page"
        :total="total"
        :page-size="limit"
        @current-change="changeCurrentPage"
      />
    </div>
    <!--  分页 END  -->
  </div>
</template>

<script>
import userList from '@/views/user/components/select/userList'
import userAdmin from '@/api/userAdmin'
import PubSub from 'pubsub-js'

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
      selectType: {}, // 查询数据
      total: 1,
      page: 1,
      limit: 6,
      users: []
    }
  },

  created() {
    this.fetchData()
    this.fetchDataB()
  },

  methods: {
    // 查询下拉框内所有用户类型
    fetchData() {
      userAdmin.selectAllCategory().then(res => {
        console.log(res.data.rows)
        this.selectType = res.data.rows
      })
    },

    // 查询用户信息
    selectUserByInfo() {
      this.fetchDataB(this.select)
      this.page = 1
    },

    // 新增用户信息
    insertUser(id) {
      console.log(id)
    },

    changeCurrentPage(page) {
      this.page = page
      this.fetchDataB()
    },

    fetchDataB() {
      userAdmin.selectUserBySelect(this.select, this.page, this.limit).then(res => {
        this.total = res.data.total
        this.users = res.data.rows
        PubSub.PubSub.publish('userData', res.data.rows)
      }).catch(error => {
        console.log(error)
      })
    }
  }
}
</script>

<style scoped>
.el-select {
  width: 110px;
}

.select {
  margin: 0 auto;
}

.el-input {
  margin: 7px auto;
}

.el-button {
  margin: 8px 10px 5px 10px;
}

.input-select {
  width: 60%;
}

.block {
  width: 300px;
  margin-right: auto;
  margin-left: auto;
  margin-top: 10px;
}
</style>
