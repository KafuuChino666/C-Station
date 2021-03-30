<template>
  <div id="panelGroup">
    <el-row :gutter="40">
      <el-col :span="6"><div class="grid-content bg-purple">1</div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple">1</div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple">1</div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple">1</div></el-col>
    </el-row>
    <!--  折线统计图  -->
    <LineChart />

    <el-row :gutter="40" style="margin-top: 30px">
      <el-col :span="8">
        <div class="grid-content-1 bg-purple"><RoseGraph /></div>
      </el-col>
      <el-col :span="8"><div class="grid-content-1 bg-purple">1</div></el-col>
      <el-col :span="8"><div class="grid-content-1 bg-purple">1</div></el-col>
    </el-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import LineChart from '@/views/dashboard/components/LineChart'
import RoseGraph from '@/views/dashboard/components/RoseGraph'

export default {
  name: 'Dashboard',
  components: {
    LineChart,
    RoseGraph
  },
  // eslint-disable-next-line vue/order-in-components
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
#panelGroup {
  margin-right: 30px;
  margin-left: 30px;
  margin-top: 40px;
}
.el-row {
  margin-bottom: 20px;
  margin-right: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #ffffff;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  min-height: 108px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}
.grid-content-1 {
  min-height: 300px;
  margin-bottom: 30px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>
