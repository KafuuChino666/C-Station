<template>
  <div id="banner">
    <div class="page-width clearfix">
      <div class="slider fl">
        <div class="slider-img">
          <a href="#" slider-title="pic1"><img src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/18365cb8895650f48662e0d84002b1dd2cf92a58.jpg" alt="#"></a>
          <a href="#" slider-title="pic2"><img src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/ba7821c4e92a8dc0d60279e684adbda4.jpg" alt="#"></a>
          <a href="#" slider-title="pic3"><img src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/d911f6e3e757ce3f606af1f654338530849bbc54.png" alt="#"></a>
          <a href="#" slider-title="pic4"><img src="images/cont/slider_img4.png" alt="#"></a>
        </div>
        <div class="slider-title"><p>pic1</p></div>
        <div class="slider-btn">
          <span class="cur"></span>
          <span></span>
          <span></span>
          <span></span>
        </div>
        <a href="#" class="slider-more">More</a>
      </div>
      <div class="banner-list fr">
        <ul>
          <li>
            <a href="#">
              <img src="images/cont/main_pic.jpg" alt="#">
              <div class="info">
                <p class="title">【初音ミク】39 TECHNO【八王子P】</p>
                <p class="author">up主：丧尸の桑</p>
                <p class="play">播放：48243</p>
              </div>
            </a>
          </li>
          <li>
            <a href="#">
              <img src="images/cont/main_pic.jpg" alt="#">
              <div class="info">
                <p class="title">【初音ミク】39 TECHNO【八王子P】</p>
                <p class="author">up主：丧尸の桑</p>
                <p class="play">播放：48243</p>
              </div>
            </a>
          </li>
          <li>
            <a href="#">
              <img src="images/cont/main_pic.jpg" alt="#">
              <div class="info">
                <p class="title">【初音ミク】39 TECHNO【八王子P】</p>
                <p class="author">up主：丧尸の桑</p>
                <p class="play">播放：48243</p>
              </div>
            </a>
          </li>
          <li>
            <a href="#">
              <img src="images/cont/main_pic.jpg" alt="#">
              <div class="info">
                <p class="title">【初音ミク】39 TECHNO【八王子P】</p>
                <p class="author">up主：丧尸の桑</p>
                <p class="play">播放：48243</p>
              </div>
            </a>
          </li>
          <li>
            <a href="#">
              <img src="images/cont/main_pic.jpg" alt="#">
              <div class="info">
                <p class="title">【初音ミク】39 TECHNO【八王子P】</p>
                <p class="author">up主：丧尸の桑</p>
                <p class="play">播放：48243</p>
              </div>
            </a>
          </li>
          <li>
            <a href="#">
              <img src="images/cont/main_pic.jpg" alt="#">
              <div class="info">
                <p class="title">【初音ミク】39 TECHNO【八王子P】</p>
                <p class="author">up主：丧尸の桑</p>
                <p class="play">播放：48243</p>
              </div>
            </a>
          </li>
        </ul>
        <a href="#" class="btn btn-prev">昨日</a>
        <a href="#" class="btn btn-next">一周</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Promotion'
}
</script>

<style scoped>
#banner .slider {
  overflow: hidden;
  position: relative;
  width: 440px;
  height: 220px;
  border-radius: 4px;
}
#banner .slider-img,
#banner .slider-img a {
  position: absolute;
  left: 0;
  top: 0;
  width: 440px;
  height: 220px;
}
#banner .slider-img a img {
  width: 100%;
}
#banner .slider-title {
  position: absolute;
  left: 0;
  bottom: 0;
  width: 100%;
  height: 35px;
  background: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/shadow.png') repeat-x;
}
#banner .slider-title p {
  display: inline;
  padding-left: 20px;
  line-height: 35px;
  color: #fff;
  font-size: 14px;
  cursor: pointer;
}
#banner .slider-title p:hover {
  text-shadow: 0 0 3px #fff;
}
#banner .slider-btn {
  position: absolute;
  right: 8px;
  bottom: 9px;
  height: 18px;
  font-size: 0;
}
#banner .slider-btn span {
  display: inline-block;
  width: 18px;
  height: 18px;
  margin: 0 2px;
  background-color: #fff;
  background: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/page_icons.png') no-repeat -855px -790px;
  cursor: pointer;
}
#banner .slider-btn span:hover {
  background-position: -919px -790px;
}
#banner .slider-btn span.cur {
  background-position: -855px -727px;
}
#banner .slider-more {
  display: none;
  position: absolute;
  right: 15px;
  bottom: 35px;
  width: 36px;
  height: 24px;
  text-align: center;
  line-height: 24px;
  padding-right: 14px;
  border-radius: 4px;
  color: #fff;
  background: rgba(0, 0, 0, .64) url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/page_icons.png') no-repeat -505px -211px;
}
#banner .slider-more:hover {
  text-shadow: 0 0 3px #fff;
}
#banner .slider:hover .slider-more {
  display: block;
}
.banner-list {
  position: relative;
  width: 520px;
}
.banner-list ul {
  margin-right: -20px;
}
.banner-list li {
  overflow: hidden;
  float: left;
  width: 160px;
  height: 100px;
  margin: 0 20px 20px 0;
  border-radius: 4px;
}
.banner-list li a {
  position: relative;
  width: 160px;
  height: 100px;
}
.banner-list li a img {
  width: 100%;
}
.banner-list li a .info {
  position: absolute;
  left: 0;
  bottom: 0;
  width: 100%;
  height: 35px;
  color: #99a2aa;
  background: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/shadow.png') repeat-x;
}
.banner-list li a:hover .info {
  height: 100%;
  background: rgba(0, 0, 0, .7);
}
.banner-list li a .info .title {
  overflow: hidden;
  line-height: 45px;
  color: #fff;
  margin: 0 5px;
  word-break: break-all;
}
.banner-list li a:hover .info .title {
  line-height: 18px;
  padding-top: 10px;
}
.banner-list li a .info .author,
.banner-list li a .info .play {
  margin-left: 5px;
}
.banner-list li a .info .author {
  padding: 12px 0 10px;
}
.banner-list li a .info .play {}
.banner-list .btn {
  display: none;
  position: absolute;
  top: 50%;
  width: 20px;
  margin-top: -30px;
  border-radius: 0 2px 2px 0;
  color: #fff;
  background-color: rgba(0, 0, 0, .6);
  background-image: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/page_icons2.png');
  background-repeat: no-repeat;
  text-align: center;
  line-height: 18px;
}
.banner-list:hover .btn {
  display: block;
}
.banner-list .btn-prev {
  left: 0;
  padding: 12px 5px 15px 12px;
  background-position: 4px -1207px;
}
.banner-list .btn-next {
  right: 0;
  padding: 12px 12px 15px 5px;
  background-position: 25px -1258px;
}
</style>
