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
        <template slot-scope="scope">
          <el-row>
            <el-button type="info" size="mini" round @click="userInfo()">查看信息</el-button>
            <el-popover
              placement="right"
              width="400"
              trigger="click"
            >
              <el-table :data="gridData">
                <el-table-column width="150" property="date" label="日期" />
                <el-table-column width="100" property="name" label="姓名" />
                <el-table-column width="300" property="address" label="地址" />
              </el-table>
              <el-button slot="reference" type="warning" size="mini" round>违规记录</el-button>
            </el-popover>
          </el-row>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="操作"
      >
        <template slot-scope="scope">
          <el-row>
            <Edit />
            <Delete />
          </el-row>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import PubSub from 'pubsub-js'
import Edit from '@/views/user/components/select/edit'
import Delete from '@/views/user/components/select/delete'

export default {
  name: 'UserList',
  components: {
    Edit,
    Delete
  },
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
      }],
      gridData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }]
    }
  },

  mounted() {
    PubSub.PubSub.subscribe('userData', (msg, data) => {
      this.userData = data
    })
  },

  methods: {
    // 用户信息跳转
    userInfo() {
      this.$router.push({ name: 'UserStat', query: { id: 1 }})
    },
    // 用户编辑
    userRedact() {
      this.$router.push('')
    },
  }
}
</script>

<style scoped>
.demo-table-expand {
  font-size: 0;
}

.el-button {
  margin: 8px 15px 5px 15px;
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
