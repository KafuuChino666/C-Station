<template>
  <div id="right-nav" class="right-nav" style="top: 360px">
    <i class="iconfont icon-icon_right-nav-top right-nav-top"></i>
    <div class="list-box">
      <ul>
        <li class="item">直播</li>
        <li class="item">直播</li>
        <li class="item">直播</li>
        <li class="item">直播</li>
        <li class="item">直播</li>
        <li class="item">直播</li>
        <li class="item">直播</li>
        <li class="item">直播</li>
        <li class="item">直播</li>
        <li class="item">直播</li>
        <li class="item">直播</li>
        <li class="item">直播</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Right-nav'
}
</script>

<style scoped>
.right-nav {
  position: fixed;
  left: calc(50% + 3px);
  top: 10px;
  margin-left: 825px;
  z-index: 10;
}
.right-nav .list-box {
  padding-top: 6px;
  position: relative;
  background: #fff;
  border: 1px solid #e7e7e7;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  z-index: 2;
}
.right-nav .list-box .item {
  width: 54px;
  height: 24px;
  line-height: 24px;
  text-align: center;
  cursor: pointer;
  transition: all .2s;
  user-select: none;
  background: #fff;
  font-size: 12px;
}
.right-nav .list-box .item:hover{
  background-color: #00a1d6;
  color: #fff;
}
@media screen and (max-width: 1654px) {
  .right-nav {
    margin-left: 615px;
  }
}
/*@media screen and (max-width: 1870px) {*/
/*  .right-nav {*/
/*    margin-left: 716px;*/
/*  }*/
/*}*/
#right-nav {

}
.right-nav-top {
  position: absolute;
  top: -10px;
  font-size: 12px;
  z-index: 2;
  font-style: normal;
  -webkit-font-smoothing: antialiased;
}
</style>
<script type="text/javascript">
import $ from 'jquery'

var oldSite = 360;
var index = 0;

$(window).scroll(function () {
  var $rightNav = $('#right-nav');

  // 计算单位滑动距离
  index = $(this).scrollTop() - oldSite
  oldSite = $(this).scrollTop()
  // console.log(oldSite)
  // console.log($(this).scrollTop())
  if ((360 - oldSite) >= 20) {
    // $rightNav.css({top: $rightNav.offset().top + index})
    $rightNav.css({top: 360 - oldSite})
  }

});

</script>
