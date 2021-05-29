<template>
  <div style="width: 80%; margin: auto">
    <el-table
      :data="userData"
      style="width: 100%"
    >
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="用户ID">
              <span>{{ props.row.userId }}</span>
            </el-form-item>
            <el-form-item label="用户昵称">
              <span>{{ props.row.userName }}</span>
            </el-form-item>
            <el-form-item label="真实姓名">
              <span>{{ props.row.realName }}</span>
            </el-form-item>
            <el-form-item label="性别">
              <span>{{ props.row.gender }}</span>
            </el-form-item>
            <el-form-item label="用户分类">
              <span>{{ props.row.category }}</span>
            </el-form-item>
            <el-form-item label="用户手机号">
              <span>{{ props.row.phone }}</span>
            </el-form-item>
            <el-form-item label="邮箱">
              <span>{{ props.row.email }}</span>
            </el-form-item>
            <el-form-item label="身份证号">
              <span>{{ props.row.idNumber }}</span>
            </el-form-item>
            <el-form-item label="充值数">
              <span>{{ props.row.consumed }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="用户ID"
        prop="userId"
      />
      <el-table-column
        align="center"
        label="用户昵称"
        prop="userName"
      />
      <el-table-column
        align="center"
        label="性别"
        prop="gender"
      />
      <el-table-column
        align="center"
        label="邮箱"
        prop="email"
      />
      <el-table-column
        align="center"
        label="查看"
      >
      <!--<template slot-scope="scope">
          <el-row>
            <el-button type="info" size="mini" round @click="userMain()">查看主页</el-button>
            <el-button type="warning" size="mini" round @click="userViolation()">违规记录</el-button>
          </el-row>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="操作"
      >
        <template slot-scope="scope">
          <el-row>
            <el-button type="primary" size="mini" round @click="userRedact()">用户编辑</el-button>
            <el-button type="danger" size="mini" round @click="userBan()">封禁用户</el-button>
          </el-row>
        </template>-->
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import PubSub from 'pubsub-js'

export default {
  name: 'UserList',
  data() {
    return {
      // page: '1',
      // limit: '6'
      userData: [{
        userId: '',
        userName: '',
        realName: '',
        gender: '',
        category: '',
        // status: '在线',
        // address: '陕西省西安市',
        phone: '',
        consumed: '',
        idNumber: '',
        email: ''
      }]
    }
  },
  created() {
    // this.fetchDataAll()
  },

  mounted() {
    PubSub.PubSub.subscribe('userData', (msg, data) => {
      this.userData = data
    })
  },

  methods: {
    // 用户主页跳转
    userMain() {
      this.$router.push('')
    },

    // 违规信息页面跳转
    userViolation() {
      this.$router.push('')
    },

    // 用户编辑
    userRedact() {
      this.$router.push('')
    },

    // 用户封禁
    userBan() {
      this.$router.push('')
    }
  }
}
</script>

<style>
.demo-table-expand {
  font-size: 0;
}

.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}

.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>
