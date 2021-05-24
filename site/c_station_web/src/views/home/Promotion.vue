<!-- 首页推广组件 -->
<template>
  <div>
    <div class="hurdle-1">
      <el-carousel height="240px" direction="vertical" :autoplay="false" style="width: 550px; float: left;">
        <el-carousel-item v-for="item in carouselImgs" :key="item">
          <el-image :src="item.imgUrl" :fit="scale-down" style="width: 550px; height: 240px"></el-image>
        </el-carousel-item>
      </el-carousel>
      <div style="float: left">
        <div class="hoverImg" :key="item" v-for="item in 3">
          <div class="back">
            <p class="title">20首值得单曲循环的动漫ED！一首听一天！！{{item}}</p>
            <p class="writer">
              <i class="iconfont icon-zuozhegengxinweizhi"></i>
              金枫残雪
            </p>
            <p class="play">5.3万播放
              <el-tooltip class="item" effect="dark" content="稍后在看" placement="top-end">
                <i class="iconfont icon-guankan3"></i>
              </el-tooltip>
            </p>
          </div>
          <el-image :src="url" :fit="scale-down" style="width: 200px; height: 115px"></el-image>
          <span>视频介绍</span>
        </div>
      </div>
      <div style="float: left; margin-top: 10px">
        <div class="hoverImg" :key="item" v-for="item in 3">
          <div class="back">
            <p class="title">20首值得单曲循环的动漫ED！一首听一天！！{{item}}</p>
            <p class="writer">
              <i class="iconfont icon-zuozhegengxinweizhi"></i>
              金枫残雪
            </p>
            <p class="play">5.3万播放
              <el-tooltip class="item" effect="dark" content="稍后在看" placement="top-end">
                <i class="iconfont icon-guankan3"></i>
              </el-tooltip>
            </p>
          </div>
          <el-image :src="url" :fit="scale-down" style="width: 200px; height: 115px"></el-image>
          <span>视频介绍</span>
        </div>
      </div>
    </div>
    <div class="hurdle-2">
      <div class="left-window">
        <div class="l-icon"></div>
        <div class="matter">
          <div class="video-box" v-for="item in 4" :key="item">
            <div class="video-img">
              <a href="#">
                <img :src="url" height="116px" width="206px">
              </a>
              <p>
                <span>111111111111111111111111</span>
              </p>
            </div>
          </div>
        </div>
      </div>
      <div class="right-window">2</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Promotion',
  data () {
    return {
      url: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/wallhaven-2ekjlm.png',
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
.hoverImg {
  position: relative;
  width: 200px;
  height: 115px;
  background-color: #63a35c;
  margin-left: 10px;
  float: left;
}

.hoverImg span {
  bottom: 10px;
  left: 10px;
  position: absolute;
  font-weight: 500;
  font-size: 14px;
  line-height: 18px;
  height: 18px;
  color: #fff
}

.title {
  padding-top: 20px;
  padding-left: 10px;
  line-height: 20px;
  text-align: left;
}

.writer {
  padding-top: 5px;
  text-align: left;
  padding-left: 10px;
  font-size: 12px;
  line-height: 13px;
}

.writer i {
  color: white;
  font-size: 26px;
}

.play {
  text-align: left;
  padding-left: 10px;
  font-size: 12px;
}

.play i {
  padding-left: 110px;
}

.hoverImg .back {
  visibility: hidden;
  text-decoration: none;
}

.hoverImg:hover {
  cursor: pointer;
}

.back {
  height: 0px;
}

.hoverImg:hover .back {
  visibility: visible;
  position: absolute;
  bottom: 0;
  left: 0;
  color: #FFF;
  width: 200px;
  z-index: 10;
  height: 115px;
  line-height: 36px;
  background: #000;
  filter: alpha(opacity=60);
  -moz-opacity: 0.5;
  opacity: 0.7;
  -webkit-transition: all 500ms cubic-bezier(0.390, 0.575, 0.565, 1.000);
  -moz-transition: all 500ms cubic-bezier(0.390, 0.575, 0.565, 1.000);
  -o-transition: all 500ms cubic-bezier(0.390, 0.575, 0.565, 1.000);
  transition: all 500ms cubic-bezier(0.390, 0.575, 0.565, 1.000);

  -webkit-transition-timing-function: cubic-bezier(0.390, 0.575, 0.565, 1.000);
  -moz-transition-timing-function: cubic-bezier(0.390, 0.575, 0.565, 1.000);
  -o-transition-timing-function: cubic-bezier(0.390, 0.575, 0.565, 1.000);
  transition-timing-function: cubic-bezier(0.390, 0.575, 0.565, 1.000);
}

.hurdle-1 {
  width: 100%;
  height: 250px;
  background-color: #3967FF;
  margin-bottom: 40px;
}

.hurdle-2 {
  width: 100%;
  height: 500px;
  background-color: #63a35c;
}

.left-window {
  width: 855px;
  height: 245px;
  float: left;
  background-color: #B500FE;
  margin-right: 25px;
}

.l-icon {
  width: 855px;
  height: 36px;
  margin-bottom: 16px;
  background-color: #b3d4fc;
}

.matter {
  display: flex;
  justify-content: space-between;
  width: 854px;
  height: 192px;
  background-color: #404040;
}

.video-box {
  width: 206px;
  height: 192px;
  background-color: #e7e1cd;
  float: left;
}

.video-img {
  width: 260px;
  height: 116px;
}

.right-window {
  width: 320px;
  height: 245px;
  float: left;
  background-color: #df5000;
}

</style>
