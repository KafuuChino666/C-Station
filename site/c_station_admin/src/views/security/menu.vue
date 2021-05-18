<template>
  <div class="pater-container">
    <SearchBox :search-fun="searchFun" title="菜单列表" label-text="输入菜单名称" :add-fun="addFun" icon="el-icon-menu" />
    <div class="low-container">
      <!--   表   -->
      <MenuTable :table-data="tableData"/>
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
    <MenuRoleForm />
    <MenuForm />
  </div>
</template>

<script>
import SearchBox from '@/views/security/components/staff/SearchBox'
import MenuTable from '@/views/security/components/menu/MenuTable'
import MenuRoleForm from '@/views/security/components/menu/MenuRoleForm'
import securityAPI from '@/api/securityAPI'
import MenuForm from '@/views/security/components/menu/MenuForm'
import PubSub from 'pubsub-js'

export default {
  name: 'Menu',
  components: {
    SearchBox,
    MenuTable,
    MenuRoleForm,
    MenuForm
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
    // 获取数据
    fetchData() {
      securityAPI.pageMenuList(this.page, this.limit).then(response => {
        this.tableData = response.data.rows
        this.total = response.data.total
      })
    },
    searchFun(name) {
      if (name !== '') {
        securityAPI.getMenuByName(name).then(response => {
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
      PubSub.publish('menuForm', {
        'formType': 'add'
      })
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
}
.block {
  width: 300px;
  margin-right: auto;
  margin-left: auto;
  margin-top: 10px;
}
</style>
