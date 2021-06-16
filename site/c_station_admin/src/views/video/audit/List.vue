<template>
  <div class="list-container">
    <el-form :inline="true" :model="searchData" class="demo-form-inline">
      <el-form-item label="用户id:">
        <el-input v-model="searchData.userId" placeholder="输入用户id"></el-input>
      </el-form-item>
      <el-form-item label="视频状态">
        <el-select v-model="searchData.region" placeholder="状态">
          <el-option label="区域一" value="shanghai"></el-option>
          <el-option label="区域二" value="beijing"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button>重置</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="date"
        label="日期"
        width="150">
      </el-table-column>
      <el-table-column
        prop="name"
        label="作者"
        width="120">
      </el-table-column>
      <el-table-column
        prop="province"
        label="视频标题"
        width="120">
      </el-table-column>
      <el-table-column
        prop="city"
        label="类型"
        width="120">
      </el-table-column>
      <el-table-column
        prop="address"
        label="状态"
        width="300">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import video from '@/api/video'

export default {
  name: 'AuditList',
  data() {
    return {
      searchData: {}
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      video.getAuditListByStaff()
    }
  }
}
</script>

<style scoped>
.list-container {
  width: 100%;
  background-color: white;
  padding: 15px;
  height: 500px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}
</style>
