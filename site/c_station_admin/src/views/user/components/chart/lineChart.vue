<template>
  <div class="panel">
    <div id="myChart" style="width: 100%; height: 300px" />
  </div>
</template>

<script>
import * as echarts from 'echarts'

export default {
  name: 'LineChart',
  data() {
    return {
      id: this.$route.query.id,
      number: '',
      type: []
    }
  },
  mounted() {
    this.lineChart()
  },
  methods: {
    // 准备查询出周一到周日一周内的数据
    queryWeekData() {

    },
    lineChart() {
      // 基于准备好的dom，初始化echarts实例
      const myChart = echarts.init(document.getElementById('myChart'))
      // 绘制图表
      myChart.setOption({
        title: {
          text: '用户一周数据折线图',
          subtext: '数据统计',
          x: 'center'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          bottom: 'bottom'
        },
        grid: {
          left: '0%',
          right: '1%',
          bottom: '10%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '视频',
            type: 'line',
            stack: '总量',
            data: [120, 132, 101, 134, 90, 230, 210]
          }
        ]
      })
    }
  }
}
</script>

<style scoped>
.panel {
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  padding: 20px;
}
</style>
