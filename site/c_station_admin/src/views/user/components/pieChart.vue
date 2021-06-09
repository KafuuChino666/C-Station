<template>
  <div>
    <div class="pie">
      <div id="pie1">
        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
        <div id="main1" style="float:left;width:100%;height: 300px" />
      </div>

      <div id="pie2">
        <div id="main2" style="float:left;width:100%;height: 300px" />
      </div>
    </div>
  </div>
</template>

<script>
import * as echarts from 'echarts'
export default {
  name: 'PieChart',
  data() {
  },
  mounted() {
    this.initData()
  },
  methods: {
    data() {
      return {
        id: '',
        number: '',
        type: []
      }
    },
    initData() {
      const myChart = echarts.init(document.getElementById('main1'))
      myChart.setOption({
        title: {
          text: '用户访问视频偏好',
          x: 'center'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          bottom: 'bottom',
          data: [
            '直接访问',
            '邮件营销',
            '联盟广告',
            '视频广告',
            '搜索引擎'
            ]
        },
        series: [
          {
            name: '访问来源',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: [
              {
                value: 335,
                name: '直接访问'
              },
              {
                value: 310,
                name: '邮件营销'
              },
              {
                value: 20,
                name: '联盟广告'
              },
              {
                value: 135,
                name: '视频广告'
              },
              {
                value: 100,
                name: '搜索引擎'
              }
            ],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      })
    }
  }
}
</script>

<style>
.pie {
  margin: 10px auto;
}
</style>
