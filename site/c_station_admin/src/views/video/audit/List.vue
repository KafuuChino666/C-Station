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
        <el-button type="primary">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button>重置</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="tableData"
      :row-class-name="tableRowClassName"
      :row-style="selectedHighlight"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="gmtModified"
        label="日期"
        width="230">
      </el-table-column>
      <el-table-column
        prop="authorId"
        label="作者"
        width="120">
      </el-table-column>
      <el-table-column
        prop="videoTitle"
        label="视频标题"
        width="300">
      </el-table-column>
      <el-table-column
        prop="zoneTitle"
        label="类型"
        width="120">
      </el-table-column>
      <el-table-column
        prop="auditor"
        label="审核员ID"
        width="100">
      </el-table-column>
      <el-table-column
        prop="disciplineInfo"
        label="违纪信息"
        width="200">
      </el-table-column>
      <el-table-column
        prop="auditorInfo"
        label="审核员列表"
        width="200">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="auditVideo(scope.row)" type="text" size="small">审核</el-button>
          <el-button type="text" size="small">详细</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<style>
.lock-row {
  background-color: #b4fa8e;
}
</style>
<script>
import video from '@/api/video'

export default {
  name: 'AuditList',
  data() {
    return {
      searchData: {},
      tableData: [],
      lockRow: '0',
      lockId: 0
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    async fetchData() {
      await video.getAuditListByStaff().then(res => {
        this.tableData = res.data.rows
      })
      video.getUnfinishedAudit().then(res => {
        this.lockId = res.data.id
        this.tableData.forEach((item, key) => {
          if (item.id === this.lockId) {
            this.lockRow = key
          }
        })
      })
    },
    tableRowClassName({ row, rowIndex }) {
      row.index = rowIndex
    },
    selectedHighlight({ row, rowIndex }) {
      if ((this.lockRow) === rowIndex) {
        return {
          'background-color': '#CAE1FF'
        }
      }
    },
    // 审核视频
    auditVideo(row) {
      // 判断是否有未完成的审核
      if (this.lockId === row.id) {
        this.$router.push({ name: 'AuditVideo', query: { id: row.id, videoId: row.videoId }})
        return null
      }
      // 请求后台
      video.lockAuditVideo(row.id).then(res => {
        // 锁定成功！
        console.log('锁定成功！')
        this.$router.push({ name: 'AuditVideo', query: { id: row.id, videoId: row.videoId }})
        // 跳转到审核页面
      })
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
