<template>
  <div class="pater-container">
    <SearchBox :search-fun="searchFun" title="角色列表" label-text="输入角色名称" icon="el-icon-user-solid" :add-fun="addFun"/>
    <div class="low-container">
      <!--   表   -->
      <RolesTable :table-data="tableData" />
      <div class="block" v-if="tableData.length >= limit || page !== 1">
        <el-pagination
          layout="prev, pager, next"
          :current-page="page"
          :total="total"
          :page-size="limit"
          @current-change="changeCurrentPage"
        />
      </div>
    </div>
  </div>
</template>

<script>
import SearchBox from '@/views/security/components/staff/SearchBox'
import RolesTable from '@/views/security/components/role/RoleTable'
import securityAPI from '@/api/securityAPI'

export default {
  name: 'RoleList',
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
    searchFun(name) {
      if (name !== '') {
        securityAPI.getRoleByName(name).then(response => {
          this.tableData = []
          this.total = 0
          this.tableData = response.data.rows
        })
      }
    },
    changeCurrentPage(page) {
      this.page = page
      this.fetchData()
    },
    addFun() {
      this.$router.push('/security/role/info/')
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
