<!-- 首页推广组件 -->
<template>
  <div>
    <el-carousel height="240px" direction="vertical" :autoplay="false" style="width: 550px; float: left;">
      <el-carousel-item v-for="item in carouselImgs" :key="item">
        <el-image :src="item.imgUrl"></el-image>
      </el-carousel-item>
    </el-carousel>
    <div style="float: left">
      <div style="width: 200px; height: 115px; background-color: #63a35c; margin-left: 10px; float: left"></div>
      <div style="width: 200px; height: 115px; background-color: #63a35c; margin-left: 10px; float: left"></div>
      <div style="width: 200px; height: 115px; background-color: #63a35c; margin-left: 10px; float: left"></div>
    </div>
    <div style="float: left; margin-top: 10px">
      <div style="width: 200px; height: 115px; background-color: #63a35c; margin-left: 10px; float: left"></div>
      <div style="width: 200px; height: 115px; background-color: #63a35c; margin-left: 10px; float: left"></div>
      <div style="width: 200px; height: 115px; background-color: #63a35c; margin-left: 10px; float: left"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Promotion',
  data () {
    return {
      carouselImgs: [
        {
          id: '1',
          imgUrl: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/wallhaven-2ekjlm.png'

        },
        {
          id: '2',
          imgUrl: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/wallhaven-lq7672.png'
        },
        {
          id: '3',
          imgUrl: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/download.jpg'

        }
      ]
    }
  }
}
</script>

<style scoped>

</style>
