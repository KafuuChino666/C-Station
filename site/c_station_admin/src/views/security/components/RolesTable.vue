<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="id"
      label="ID"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="description"
      label="描述">
    </el-table-column>
    <el-table-column
      prop="status"
      label="启用状态">
    </el-table-column>
    <el-table-column
      prop="gmtModified"
      label="修改时间">
    </el-table-column>
    <el-table-column
      label="操作">
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: 'RolesTable',
  props: {
    // eslint-disable-next-line vue/require-default-prop
    tableData: Array
  }
}
</script>

<style scoped>

</style>
