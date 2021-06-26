<template>
  <div id="banner">
    <div class="page-width clearfix">
      <div class="slider fl">
        <div class="slider-img">
          <a href="#" slider-title="pic1"><img
            src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/18365cb8895650f48662e0d84002b1dd2cf92a58.jpg"
            alt="#"></a>
          <a href="#" slider-title="pic2"><img
            src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/ba7821c4e92a8dc0d60279e684adbda4.jpg" alt="#"></a>
          <a href="#" slider-title="pic3"><img
            src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/d911f6e3e757ce3f606af1f654338530849bbc54.png"
            alt="#"></a>
        </div>
        <div class="slider-title"><p>pic1</p></div>
        <div class="slider-btn">
          <span class="current_span"></span>
          <span></span>
          <span></span>
        </div>
        <a href="#" class="slider-more">More</a>
      </div>
      <div id="video-recommend">
        <div class="box">
          <div class="video-card-reco">
            <div class="info-box">
              <a href="#">
                <img alt="爷 的 女 友 真 可 爱~" src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/e84cf4d5ee0930d8c13e72970d20c98286d72d1c.jpg%40412w_232h_1c.jpg">
                <div class="info">
                  <p title="爷 的 女 友 真 可 爱~" class="title">【爷 的 女 友 真 可 爱~</p>
                  <p class="up"></p>
                  <p class="play">13.6万播放</p>
                </div>
              </a>
            </div>
            <div class="watch-later-video"></div>
          </div>
        </div>
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
  float: left;
  width: 550px;
  height: 242px;
  border-radius: 2px;
}
#banner .slider-img {
  overflow: hidden;
}
#banner .slider-img,
#banner .slider-img a {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
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

#banner .slider-btn span.current_span {
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
  /*background-color: #df5000;*/
  /*z-index: 999;*/
  background: rgba(0, 0, 0, .64) url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/page_icons.png') no-repeat -505px -211px;
}

#banner .slider-more:hover {
  text-shadow: 0 0 3px #fff;
}

#banner .slider:hover .slider-more {
  display: block;
}

#video-recommend {
  position: relative;
  float: left;
}
#video-recommend .box {
  display: -ms-flexbox;
  display: flex;
  width: 638px;
  height: 242px;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  -ms-flex-pack: justify;
  justify-content: space-between;
  -ms-flex-line-pack: justify;
  align-content: space-between;
}
@media screen and (max-width: 1654px) {
  #video-recommend .box {
    width: 638px;
  }
}

/*@media screen and (max-width: 1870px) {*/
/*  #video-recommend .box {*/
/*    width: 854px;*/
/*    height: 242px;*/
/*  }*/
/*}*/
#video-recommend .box .video-card {
  margin-bottom: 10px;
  position: relative;
  width: 206px;
  height: 116px;
}
.video-card-reco {
  position: relative;
  width: 206px;
  height: 116px
}
.video-card-reco .info-box {
  position: relative;
  overflow: hidden;
  background-image: url(data:image/png;
  base64,iVBORw0KGgoAAAANSUhEUgAAAEsAAABHCAMAAAB4UkqjAAAAh1BMVEUAAADd3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d3d0UCIZXAAAALHRSTlMAoJDx4OYL/DcGF+6+JNi4ycSIT2k6LPeWfRzTVPXPszEQrV0hpo12cEZAZFpRNIQAAAJVSURBVFjD7dbZcpswGIbhHwwSi81q8Ib33fnu//oatRIpmliDhQ/aaZ+TKInnjVgkhb4RJMhP9Fzo8PiD+vEA+JPnqS0+1dRHBJhibAzh2HNeekxP9Z8XBSMZM6SmRBYx65QeM6XsY3rKPqanLGMWqeDmOh0b/Io9+YHi3gKtdExgLznSlyjFMGnUphIMlcgY22C4DSPBxTu4IrXDe+yI6IDWbPSqGVoHoohDyip6XZVB4hFN1TgPyUaYQ5rSWQ0nZGcC6UyJukKypa4yIXX3HLLlqCdHX++HLRfS/9bbWvvHLSLNR3N6tRXdFwdxejekiYF4fDnWYa/WqSm2PqRCSy0hrbP5RxAaW8141N17tVbZ+S1fFYbWFF2+1lqg62BoBdAsqWOLroWhxTh+M8vmWuuaxp1WaWjRSn43yl35sHTLUjxiaWlqnYE4LZoJme3v13MibqepFZRL6otV5V+/Hv+xVvi+FsvZG1qh/LQ7uFXnF/HlwcEfYlDktW2r5EARUiXWc1xRWAC8tGwxsdJ9dcRnYrddMdtrjDZyAy3kXrSJ7O89u8zEZAIKxBRnFzbonWD3ZkfCrrmzP+6979nicjAnW3NZ4OS1R6GtVBa8drTek539up3NAgMvcv51WNZQitCiFBZQaqIMSrx1XrWNoWTy/w1r+hk+xjuMSVjGGC6WZ3S1xlDriqTKxzB+Ra3I4bDHne62drqmied57QR9z0D94dHnOEmvJ/pWAMm4ovL2TTcJ5cRyMlHrbkdG5c/5r82fYqt+K/iR89m2JrP9PEZyI80PsPxVT0P3FAEAAAAASUVORK5CYII=);background-repeat: no-repeat;
  background-position: 50%
}
.video-card-reco .info-box,.video-card-reco .info-box:before,.video-card-reco .info-box img {
  width: 100%;
  height: 100%;
  border-radius: 2px
}
.video-card-reco .info-box:before {
  content: "";
  position: absolute;
  left: 0;
  top: 0;
  background: rgba(0,0,0,.7);
  opacity: 0;
  transition: opacity .2s
}
.video-card-reco .info-box .info {
  position: absolute;
  z-index: 2;
  width: 100%;
  top: 64px;
  left: 0;
  transition: top .2s;
  padding: 26px 10px 10px
}
.video-card-reco .info-box .info .title {
  font-size: 14px;
  line-height: 18px;
  height: 18px;
  color: #fff;
  margin-bottom: 6px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-weight: 500
}
.video-card-reco .info-box .info .play,.video-card-reco .info-box .info .up {
  font-size: 12px;
  color: #e0e0e0;
  margin-bottom: 3px
}
.video-card-reco .info-box .info .play .bilifont,.video-card-reco .info-box .info .up .bilifont {
  vertical-align: middle;
  margin-right: 5px
}

.video-card-reco .watch-later-video {
  transition: opacity .2s;
  opacity: 0
}
.video-card-reco:before {
  content: "";
  position: absolute;
  z-index: 1;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 48px;
  background-image: url(data:image/png;
  base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAAwCAYAAAGnNCAXAAAABGdBTUEAALGPC/xhBQAAAENJREFUCB1jYGBgYGICEpIgQgqNBRRi4MMmARYDyXKAWLwgggfOAnMJiIH0soJ0sMEJdlQWWBYshpAAK0ZwwSzS1AEAes8Ckyqvlc0AAAAASUVORK5CYII=);background-size: contain;
  background-repeat: repeat-x;
  border-radius: 0 0 2px 2px
}
.video-card-reco:hover .watch-later-video {
  transition-delay: .2s;
  opacity: 1
}
.video-card-reco:hover .info-box:before {
  opacity: 1
}
.video-card-reco:hover .info-box .info {
  top: 0
}
.video-card-reco:hover .info-box .info .title {
  height: 36px;
  white-space: normal
}
</style>

<script type="text/javascript">
import $ from 'jquery'

$(function () {
  //找到a标签
  var $as = $('.slider-img').find('a')
  //找到a标签所对应的的span标签
  var $slider_btn = $('.slider-btn').find('span')

  var $title = $('.slider-title').find('p')
  //设置轮播图中当前的图片为第一张图片
  var current_index = 0
  var width = $('.slider-img').width()
  //图片位置初始化，将除了第一张图片之外的图片全部移到.slider-img类范围之外进行隐藏
  for (var i = 1; i < $as.length; i++) {
    $($as[i]).css({left: width})
  }

  //开启定时器，每隔3秒钟进行滚动
  var auto_rotation = setInterval(Rotation_auto, 5000)

  //当鼠标移入时停止自动轮播，响应鼠标单击事件
  $('#banner').mouseover(function () {
    clearInterval(auto_rotation)
    $slider_btn.click(Rotation_click)
  })

  //当鼠标移出时开启自动轮播
  $('#banner').mouseout(function () {
    auto_rotation = setInterval(Rotation_auto, 5000)
  })

  //设置右下角小图标的样式
  function index_change (index) {
    $slider_btn.removeClass('current_span')
    $slider_btn.eq(index).addClass('current_span')
  }

  //设置title
  function index_title (index) {
    $title.text($as.eq(index).attr('slider-title'))
  }

  //图片轮播逻辑
  function Rotation (next_index) {
    //如果点击的按钮是当前按钮的话，什么也不做
    if (next_index == current_index) {
      return
    }//如果点击的是处于当前图片的下一张图片，也就是向右边轮播
    else if (next_index > current_index) {
      //将当前图片移出区域
      $as.eq(current_index).animate({left: -width})
      $as.eq(next_index).css({left: width})

    }
    //向左边轮播
    else {
      //将当前图片移出区域
      $as.eq(current_index).animate({left: width})
      $as.eq(next_index).css({left: -width})
    }
    //将下一张图片移入区域
    $as.eq(next_index).animate({left: 0})
  }

  //鼠标单击的轮播时间
  function Rotation_click () {
    var index = $(this).index()
    //改变小图标所在位置
    index_change(index)
    index_title(index)
    //轮播图效果
    Rotation(index)
    current_index = index
  }

  //自动轮播事件
  function Rotation_auto () {
    var index = (current_index + 1) % $slider_btn.length
    index_change(index)
    index_title(index)
    Rotation(index)
    current_index = index
  }
})
</script>
