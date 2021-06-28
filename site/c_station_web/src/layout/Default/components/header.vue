<template>
  <div>
<!--   style="background-color: #b3d4fc; height: 49px"   -->
    <div class="header-top" id="header-top">
      <div class="header-nav clearfix">
        <div class="header-top_nav">
          <ul>
            <li class="item item-home">
              <a href="#">
                <i class="iconfont icon-bilibilidonghua"></i>
                主站
              </a>
            </li>
            <li class="item"><a href="#">番剧</a></li>
            <li class="item"><a href="#">游戏中心</a></li>
            <li class="item"><a href="#">直播</a></li>
            <li class="item"><a href="#">会员购</a></li>
            <li class="item"><a href="#">漫画</a></li>
            <li class="item"><a href="#">赛事</a></li>
            <li class="item"><a href="#">BML</a></li>
            <li class="item">
              <a href="#">下载APP</a>
            </li>
          </ul>
        </div>
        <div class="search-box">
          <input type="text" class="text" placeholder="男子高校生の日常">
          <a href="#" class="btn"><i></i></a>
          <div class="search-history">
            <div class="title">历史搜索</div>
            <div class="list">
              <a href="#">努巴尼欢乐秀<i></i></a>
              <a href="#">主播真会玩守望篇<i></i></a>
              <a href="#">主播真会玩女神篇<i></i></a>
              <a href="#">暴暴勺暴暴<i></i></a>
              <a href="#">OverWatch<i></i></a>
            </div>
          </div>
        </div>
        <div class="header-top_user">
          <div class="user_c">
            <span></span>
          </div>
        </div>
      </div>
    </div>
    <div id="page-width">
      <a href="#" class="header-logo">
        <img src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/7c997bce21ee896fc2552e56ea783591a6e7ede8.png">
      </a>
    </div>
  </div>
</template>

<script>
export default {
  name: 'header'
}
</script>

<script type="text/javascript">
import $ from 'jquery'

$(window).scroll(function () {
  if ($(this).scrollTop() >= 90) {
    $('#header-top').addClass('on')
  } else {
    $('#header-top').removeClass('on')
  }
});

</script>


<style scoped>

.header-top_user {
  background-color: #212121;
  height: 100%;
  float: left;
  margin-left: 10px;
}
.user_c {
  display: flex;
  align-items: center;
  line-height: 30px;
}




.header-top {
  position: relative;
  z-index: 2;
  width: 100%;
}
.header-nav {
  padding: 3px 24px;
}
.header-top_nav {
  float: left;
  margin-left: -10px;
  font-size: 0;
}
.header-top_nav .item {
  display: inline-block;
  position: relative;
}
.header-top_nav .item > a {
  height: 42px;
  line-height: 42px;
  text-align: center;
  margin-right: 12px;
  color: #fff;
  font-size: 14px;
}
/*.header-top_nav .item > a:hover {*/
/*  background-color: rgba(255, 255, 255, .2);*/
/*}*/
.header-top_nav .item-home {}
.header-top_nav .item-home a {
  width: 53px;
  padding: 0 0 0 20px;
  /*background: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/page_icons.png') no-repeat -845px -74px;*/
}

.header-top_nav .item:hover .header-hover {
  display: block;
}

#search {
  /*position: absolute;*/
  /*bottom: 22px;*/
  /*right: 0;*/
  margin-top: 5px;
  border-color: rgba(0,0,0,0.12);
}
.search-box .text {
  height: 32px;
  line-height: 32px;
  border-radius: 4px;
  background-color: rgba(255, 255, 255, .88);
}
.search-box:hover .text {
  background-color: rgba(255, 255, 255, 1);
}
.search-box {
  float: left;
}
.search-box .text {
  width: 360px;
  padding: 0 36px 0 12px;
}
.search-box .btn {
  position: relative;
  left: 380px;
  bottom: 33px;
  width: 36px;
  height: 32px;
}
.search-box .btn i {
  display: block;
  width: 18px;
  height: 18px;
  margin-top: 8px;
  background: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/page_icons.png') no-repeat -663px -728px;
}
.search-box .btn:hover i {
  background-position: -728px -728px;
}
.search-history {
  display: none;
  position: absolute;
  top: 38px;
  right: 0;
  width: 268px;
  height: 186px;
  border: 1px solid #e5e9ef;
  box-shadow: rgba(0,0,0,0.16) 0 2px 4px;
  border-radius: 4px;
  background-color: #fff;
}
.search-history .title {
  position: relative;
  width: 248px;
  height: 16px;
  margin: 12px auto;
  text-align: center;
  color: #99a2aa;
}
.search-history .title:before,
.search-history .title:after {
  content: "";
  position: absolute;
  top: 8px;
  width: 90px;
  border-top: 1px solid #e5e9ef;
}
.search-history .title:before {
  left: 0;
}
.search-history .title:after {
  right: 0;
}
.search-history .list a {
  position: relative;
  padding-left: 10px;
  line-height: 28px;
}
.search-history .list a:hover {
  background-color: #e5e9ef;
}
.search-history .list i {
  content: "";
  position: absolute;
  right: 23px;
  width: 12px;
  height: 28px;
  background: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/page_icons.png');
  background-repeat: no-repeat;
  background-position: -474px -530px;
}
.search-history .list i:hover {
  background-position: -538px -530px;
}

/* logo */
.header-logo {
  position: absolute;
  left: 160px;
  top: 50px;
  width: 220px;
  height: 50%;
  min-height: 60px;
}

.header-top.on {
  position: fixed;
  top: 0;
  background-color: #FFFFFF;
  color: #212121;
  height: 49px;
  box-shadow: 0 0 12px 0 rgba(0, 0, 0, 0.1)
  /*width: 100%;*/
}
.header-top.on .header-top_nav .item > a {
  color: #212121;
}
.header-top.on .item .iconfont {
  color: rgb(0, 161, 214);
}
.header-top .item .iconfont {
  position: relative;
  line-height: 42px;
  font-size: 18px;
  color: white;
  top: 2px;
}
.header-top.on .search-box .text {
  background: rgb(244, 244, 244);
  border: 1px solid rgb(231, 231, 231);
}
</style>
