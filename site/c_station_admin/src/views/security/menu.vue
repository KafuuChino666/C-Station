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

export default {
  name: 'Menu',
  components: {
    SearchBox,
    MenuTable,
    MenuRoleForm
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
