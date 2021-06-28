<template>
  <div class="fChart">
    <div id="roseChart" style="width: 100%; height: 300px" />
  </div>
</template>

<script>
import * as echarts from 'echarts'

export default {
  name: 'FChart',
  data() {
    return {
      id: '',
      number: '',
      type: []
    }
  },
  mounted() {
    this.lineChart()
  },
  methods: {
    lineChart() {
      // 基于准备好的dom，初始化echarts实例
      const myChart = echarts.init(document.getElementById('roseChart'))
      // 绘制图表
      myChart.setOption({
        title: {
          text: '用户的收藏分区统计',
          x: 'center'
        },
        legend: {
          top: 'bottom'
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true }
          }
        },
        series: [
          {
            name: '面积模式',
            type: 'pie',
            radius: 80,
            center: ['50%', '50%'],
            roseType: 'area',
            itemStyle: {
              borderRadius: 8
            },
            data: [
              {
                value: 30,
                name: 'rose 1'
              }
            ]
          }
        ]
      })
    }
  }
}
</script>

<style scoped>
.fChart {
  margin: 10px auto;
}
</style>
