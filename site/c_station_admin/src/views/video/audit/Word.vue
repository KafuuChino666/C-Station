<template>
  <div class="container">
    <div class="con-top">
      <el-button type="primary" icon="el-icon-plus" @click="add()">新增</el-button>
      <div style="float: right">
        <el-input placeholder="请输入内容" style="width: 220px;margin-right: 15px " />
        <el-button type="primary">搜索</el-button>
      </div>
    </div>
    <el-table
      :data="tableData"
      style="width: 100%"
    >
      <el-table-column
        prop="flowName"
        label="流程名"
        width="180"
      />
      <el-table-column
        prop="nodeNum"
        label="节点数"
        width="180"
      />
      <el-table-column
        prop="id"
        label="流程id"
      />
      <el-table-column
        prop="gmtCreate"
        label="创建时间"
      />
      <el-table-column
        align="center"
        label="操作"
      >
        <template slot-scope="scope">
          <el-button size="mini" @click="goto(scope.row.id)">编辑</el-button>
          <el-divider direction="vertical" />
          <el-popconfirm title="确定删除这条绑定吗？" @onConfirm="remove(scope.row.id)">
            <el-button slot="reference" size="mini" type="danger">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      style="float: right; margin-top: 15px"
      background
      layout="prev, pager, next"
      :total="total"
    />
  </div>
</template>

<script>
import video from '@/api/video'

export default {
  name: 'VideoAuditWord',
  data() {
    return {
      drawer: false,
      tableData: [{
        flowName: '1',
        nodeNum: '视频审核',
        id: '1',
        gmtCreate: '2012-02-13 15:00:00'
      }],
      form: {},
      value: '',
      page: 1,
      limit: 7,
      total: 0
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    add() {
      // 打开右侧抽屉
      this.drawer = true
      // 获取角色列表
    },
    // 初始化数据请求
    fetchData() {
      video.getVideoAuditWork(this.page, this.limit).then(res => {
        this.tableData = res.data.rows
        this.total = res.data.total
      })
    },
    remove(id) {
      video.removeVideoAuditWork(id).then(res => {
        this.fetchData()
      })
    },
    goto(id) {
      this.$router.push({ name: 'VideoAuditWordEdit', params: { id: id }})
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    }
  }
}
</script>

<style scoped>
.container {
  width: 100%;
  height: 100vh;
  /*background-color: #20a0ff;*/
}
.con-top {
  width: 100%;
  height: 60px;
}
</style>
