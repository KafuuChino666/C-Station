<template>
  <div class="pater-container">
    <SearchBox :search-fun="searchFun" title="角色列表" label-text="输入角色名称" icon="el-icon-user-solid" />
    <div class="low-container">
      <!--   表   -->
      <RolesTable :table-data="tableData" />
    </div>
  </div>
</template>

<script>
import SearchBox from '@/views/security/components/SearchBox'
import RolesTable from '@/views/security/components/RolesTable'
import securityAPI from '@/api/securityAPI'

export default {
  name: 'Roles',
  components: {
    SearchBox,
    RolesTable
  },
  data() {
    return {
      page: 1,
      limit: 7,
      tableData: [],
      total: 0
    }
  },

  // 页面渲染成功后获取数据
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      securityAPI.pageRoleList(this.page, this.limit).then(response => {
        this.tableData = response.data.rows
        this.total = response.data.total
      })
    },
    searchFun(text) {
      if (text !== '') {
        securityAPI.getStaffById(text).then(response => {
          this.tableData = []
          this.total = 0
          this.tableData.push(response.data.rows)
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
.pater-container{
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
  padding: 30px;
}
.low-container {
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  width: 100%;
  padding: 20px;
  margin-top: 30px;
}
</style>
