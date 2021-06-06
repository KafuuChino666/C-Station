<template>
  <div class="container">
    <div class="con-top">
      <el-button type="primary" icon="el-icon-plus" @click="add()">新增</el-button>
      <div style="float: right">
        <el-input v-model="input" placeholder="请输入内容" style="width: 220px;margin-right: 15px " />
        <el-button type="primary">搜索</el-button>
      </div>
    </div>
    <el-table
      :data="tableData"
      style="width: 100%"
    >
      <el-table-column
        prop="flowNodeName"
        label="节点名"
        width="180"
      />
      <el-table-column
        prop="order"
        label="执行顺序"
        width="180"
      />
      <el-table-column
        prop="id"
        label="节点id"
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
          <el-button size="mini">编辑</el-button>
          <el-divider direction="vertical" />
          <el-popconfirm title="确定删除这条绑定吗？">
            <el-button slot="reference" size="mini" type="danger">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      style="float: right; margin-top: 15px"
      background
      layout="prev, pager, next"
      :total="1000"
    />
    <el-drawer
      title="节点和角色绑定"
      :visible.sync="drawer"
      direction="rtl"
      :before-close="handleClose"
    >
      <div style="padding: 0 30px">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="角色">
            <el-select v-model="value" filterable placeholder="请选择">
              <el-option
                v-for="item in roles"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
          <el-form-item label="绑定节点">
            <el-cascader
              :options="nodes"
              :props="props"
            />
          </el-form-item>
          <el-button type="primary">添加绑定</el-button>
          <el-button @click="drawer = false">取消</el-button>
        </el-form>
        <el-tag type="warning" style="margin-top: 15px; width: 100%">
          注意: 请不要重复绑定; 添加新角色请到(权限—>角色管理)
        </el-tag>
      </div>
    </el-drawer>
  </div>
</template>

<script>
import securityAPI from '@/api/securityAPI'
import video from '@/api/video'

export default {
  name: 'AuditManage',
  data() {
    return {
      drawer: false,
      tableData: [{
        id: '1',
        flowNodeName: '政治审核',
        gmtCreate: '2012-02-13 15:00:00'
      }],
      form: {},
      value: '',
      roles: [],
      nodes: [],
      props: {
        lazy: true, // 开启懒加载
        value: 'id',
        label: 'title',
        lazyLoad(node, resolve) {
          if (node.value !== undefined) {
            let nodes
            video.getChildNodeByWordId(node.value).then(res => {
              nodes = res.data.zones
              console.log(nodes)
              resolve(nodes)
            })
          }
        }
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      const id = this.$route.params.id
      if (id) {
        video.getNodesByFlowId(id).then(res => {
          this.tableData = res.data.list
        })
      }
    },
    add() {
      // 打开右侧抽屉
      this.drawer = true
      // 获取角色列表
      securityAPI.getRoleList().then(res => {
        this.roles = res.data.list
      })
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
