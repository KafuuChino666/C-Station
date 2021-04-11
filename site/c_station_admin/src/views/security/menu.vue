<template>
  <div class="pater-container">
    <SearchBox :search-fun="searchFun" title="菜单列表" label-text="输入菜单名称" :add-fun="addFun" icon="el-icon-menu" />
    <div class="low-container">
      <!--   表   -->
      <MenuTable />
    </div>
    <ResourceForm />
    <MenuRoleForm />
  </div>
</template>

<script>
import SearchBox from '@/views/security/components/SearchBox'
import MenuTable from '@/views/security/components/MenuTable'
import MenuRoleForm from '@/views/security/components/MenuRoleForm'
import securityAPI from '@/api/securityAPI'

export default {
  name: 'Menu',
  components: {
    SearchBox,
    MenuTable,
    MenuRoleForm
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
.block {
  width: 300px;
  margin-right: auto;
  margin-left: auto;
  margin-top: 10px;
}
</style>
