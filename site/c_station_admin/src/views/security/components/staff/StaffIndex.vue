<template>
  <div class="pater-container">
    <SearchBox :search-fun="searchFun" title="员工列表" label-text="输入员工编号" icon="tree" :add-fun="addFun" />
    <div class="low-container">
      <StaffList :list="list" />
      <div v-if="list.length >= limit || page !== 1" class="block">
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
import StaffList from '@/views/security/components/staff/StaffList'
import securityAPI from '@/api/securityAPI'
import StaffForm from '@/views/security/components/staff/StaffRoleBind'
import SearchBox from '@/views/security/components/staff/SearchBox'

export default {
  name: 'StaffIndex',
  components: {
    StaffList,
    StaffForm,
    SearchBox
  },
  data() {
    return {
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
    searchFun(text) {
      if (text !== '') {
        securityAPI.getStaffById(text).then(response => {
          this.list = []
          this.total = 0
          this.list.push(response.data.rows)
        })
      }
    },
    changeCurrentPage(page) {
      this.page = page
      this.fetchData()
    },
    addFun() {
      this.$router.push('/security/staff/info/')
    }
  }
}
</script>

<style scoped>
.pater-container{
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
}

.low-container {
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  width: 100%;
  padding: 20px;
  margin-top: 30px;
  background-color: white;

}
.block {
  width: 300px;
  margin-right: auto;
  margin-left: auto;
  margin-top: 10px;
}
</style>
