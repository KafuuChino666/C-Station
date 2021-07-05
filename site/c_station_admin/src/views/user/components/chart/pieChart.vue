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
    return {
      id: '',
      value: '',
      userLike: []
    }
  },
  mounted() {
    this.initData()
  },
  methods: {
    queryAWeekClickZone() {

    },
    initData() {
      const myChart = echarts.init(document.getElementById('main1'))
      myChart.setOption({
        title: {
          text: '用户7天点击视频分区统计',
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
            '追番类型',
            '订阅类型',
            '视频分区',
            '专栏类型'
          ]
        },
        series: [
          {
            type: 'pie',
            radius: 60,
            center: ['50%', '60%'],
            data: [
              {
                value: 335,
                name: '追番类型'
              },
              {
                value: 310,
                name: '订阅类型'
              },
              {
                value: 200,
                name: '视频分区'
              },
              {
                value: 135,
                name: '专栏类型'
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

<style scoped>
.pie {
  margin: 10px auto;
}
</style>
