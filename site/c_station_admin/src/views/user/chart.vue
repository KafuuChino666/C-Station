<template>
  <div>
    <div>
      <el-button size="mini" round @click="backInfo">返回</el-button>
      <h3>用户：{{ name }}的统计数据</h3>
    </div>
    <el-row :gutter="40">
      <el-col :span="12">
        <div class="grid-content bg-purple">
          <div class="gid-align bg-pr">
            <PieChart />
          </div>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple">
          <div class="gid-align bg-pr">
            <FChart />
          </div>
        </div>
      </el-col>
    </el-row>
    <div class="gid-align bg-pr">
      <LChart />
    </div>
  </div>
</template>

<script>
import LChart from '@/views/user/components/chart/lineChart'
import PieChart from '@/views/user/components/chart/pieChart'
import FChart from '@/views/user/components/chart/fChart'

export default {
  name: 'UserStat',
  props: ['id'],
  components: {
    PieChart,
    LChart,
    FChart
  },
  data() {
    return {
      userId: null,
      name: ''
    }
  },

  created: {

  },

  methods: {
    backInfo() {
      this.$router.push({ name: 'UserList' })
      // this.$router.go(-1)
    }
  }
}
</script>

<style scoped>
.bg-pr {
  background: #ffffff;
}

.gid-align {
  min-height: 400px;
  min-width: 500px;
  margin-bottom: 30px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}
</style>
