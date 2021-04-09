<template>
  <div class="chart-container">
    <div class="top-container">
      <div class="text-con">
        <span style="font-size: 18px"><i class="el-icon-search" />搜索员工</span>
      </div>
      <div class="search-con">
        输入员工编号:<el-input v-model="searchText" placeholder="请输入内容" />
        <el-button type="info" plain @click="searchText = ''"> 清空 </el-button>
        <el-button type="primary" @click="search">查询</el-button>
      </div>
    </div>
    <div class="low-container">
      <StaffList :list="list" />
      <div class="block">
        <el-pagination
          layout="prev, pager, next"
          :current-page="page"
          :total="total"
          :page-size="limit"
          @current-change="changeCurrentPage"
        />
      </div>
    </div>
    <StaffForm />
  </div>
</template>

<script>
import StaffList from '@/views/security/components/StaffList'
import securityAPI from '@/api/securityAPI'
import StaffForm from '@/views/security/components/StaffForm'

export default {
  name: 'List',
  components: {
    StaffList,
    StaffForm
  },
  data() {
    return {
      searchText: '',
      page: 1,
      limit: 7,
      list: [],
      total: 0
    }
  },

  // 页面渲染成功后获取数据
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      securityAPI.pageStaffList(this.page, this.limit).then(response => {
        this.list = response.data.rows
        this.total = response.data.total
      })
    },
    search() {
      if (this.searchText.trim() !== '') {
        securityAPI.getStaffById(this.searchText).then(response => {
          this.list = []
          this.total = 0
          this.list.push(response.data.rows)
        })
      }
    },
    changeCurrentPage(page) {
      this.page = page
      this.fetchData()
    }
  }
}
</script>

<style scoped>
.chart-container{
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
  padding: 30px;
}

.top-container {
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  width: 100%;
  height: 150px;
  padding: 20px;
}
.text-con {
  width: 100%;
  height: 40px;
}
.el-icon-search {
  font-size: 16px;
  margin-right: 5px;
}
.search-con {
  width: 100%;
  height: 35px;
  font-weight: 400;
  padding-left: 60px;
}
.el-input {
  width: 180px;
  margin-left: 15px;
  margin-right: 15px;
}
.el-button {
  width: 100px;
}
.low-container {
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  width: 100%;
  padding: 20px;
  margin-top: 30px;
}
.block {
  width: 300px;
  margin-right: auto;
  margin-left: auto;
  margin-top: 10px;
}
</style>
