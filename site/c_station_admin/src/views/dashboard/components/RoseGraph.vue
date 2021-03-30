<template>
  <div id="roseChart" style="width: 100%; height: 300px" />
</template>

<script>
import * as echarts from 'echarts'

export default {
  name: 'RoseGraph',
  mounted() {
    this.lineChart()
  },
  methods: {
    lineChart() {
      // 基于准备好的dom，初始化echarts实例
      const myChart = echarts.init(document.getElementById('roseChart'))
      // 绘制图表
      myChart.setOption({
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
              { value: 40, name: 'rose 1' },
              { value: 38, name: 'rose 2' },
              { value: 32, name: 'rose 3' },
              { value: 30, name: 'rose 4' },
              { value: 28, name: 'rose 5' },
              { value: 26, name: 'rose 6' },
              { value: 22, name: 'rose 7' },
              { value: 18, name: 'rose 8' }
            ]
          }
        ]
      })
    }
  }
}
</script>

<style scoped>
</style>
