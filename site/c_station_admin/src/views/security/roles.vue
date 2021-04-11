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

export default {
  name: 'Roles',
  components: {
    SearchBox,
    RolesTable
  },
  data() {
    return {
      tableData: []
    }
  },
  methods: {
    searchFun(text) {
      // 1
      alert(text)
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
