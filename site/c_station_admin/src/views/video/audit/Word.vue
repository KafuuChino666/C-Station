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
        width="150"
      />
      <el-table-column
        width="100"
      >
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.usable == 1 ? 'success' : 'info'"
            size="mini"
            effect="plain"
            @click="upDateUsable(scope.row)"
          >
            {{ scope.row.usable == 1 ? '默认' : '设为默认' }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="id"
        label="流程id"
      />
      <el-table-column
        prop="remark"
        label="备注"
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
    <!--  抽屉  -->
    <el-drawer
      title="创建一个新流程"
      :visible.sync="drawer"
      direction="rtl"
      :before-close="handleClose">
      <el-form :rules="formValidate" ref="form" size="small" label-position="top" label-width="80px" :model="form" style="padding: 0 20px; width: 70%">
        <el-form-item label="流程名称" prop="flowName">
          <el-input v-model="form.flowName"></el-input>
        </el-form-item>
        <el-form-item label="流程类型" prop="sign">
          <el-select v-model="form.sign" placeholder="请选择流程类型">
            <el-option label="视频审核流" value="video_audit_flow"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input type="textarea" v-model="form.remark"></el-input>
        </el-form-item>
        <el-button :loading="loading" type="primary" @click="submitForm()">添加</el-button>
        <el-button>取消</el-button>
        <el-alert
          style="margin-top: 20px"
          title="流程类型"
          type="warning"
          description="流程类型: 业务标识符，在本系统中为硬编码状态; 比如视频视频审核流程标识符为:video_audit_flow"
          show-icon>
        </el-alert>
      </el-form>
    </el-drawer>
    <VerificationFrame :dialog-visible="verificationVisible" />
  </div>
</template>

<script>
import video from '@/api/video'
import rule from '@/rules/rule'
import VerificationFrame from '@/views/common/VerificationFrame'

export default {
  name: 'VideoAuditWord',
  components: { VerificationFrame },
  data() {
    return {
      verificationVisible: false,
      formValidate: rule.WorkFlowAddFrom,
      drawer: false,
      tableData: [],
      loading: false,
      form: {
        flowName: '',
        sign: 'video_audit_flow',
        remark: ''
      },
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
    },
    upDateUsable(row) {
      // eslint-disable-next-line eqeqeq
      if (row.usable == 0) {
        this.$confirm('此操作将会重置未完成的审核任务, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.verificationVisible = true
          // 改变默认
          video.upDateWordUsable(row.id)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
      }
    },
    submitForm() {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          this.loading = true
          video.addWorkFlow(this.form).then(res => {
            this.fetchData()
            this.drawer = false
            this.form = {}
            this.loading = false
            this.$message({
              message: '流程添加成功',
              type: 'success'
            })
          })
        }
      })
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
