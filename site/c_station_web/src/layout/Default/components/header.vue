<template>
  <div>
    <div class="header-top">
      <div class="header-nav clearfix">
        <div class="header-top__nav">
          <ul>
            <li class="item item-home"><a href="#">主站</a></li>
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
        <div id="search" class="clearfix">
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
        </div>
        <div class="header-top__user">
          <div class="login-box">
            <a href="#">登录</a>
            <span></span>
            <a href="#">注册</a>
          </div>
          <div class="user-post">
            <a href="#" class="link">投 稿</a>
            <div class="user-post__hover header-hover">
              <a href="#" class="post">视频投稿</a>
              <a href="#" class="manage">投稿管理</a>
              <a href="#" class="create">创作中心</a>
            </div>
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

<style scoped>
.header-top {
  position: relative;
  z-index: 2;
}
.header-nav {
  padding: 3px 24px;
}
.header-top__nav {
  float: left;
  margin-left: -10px;
  font-size: 0;
}
.header-top__nav .item {
  display: inline-block;
  position: relative;
}
.header-top__nav .item > a {
  height: 42px;
  line-height: 42px;
  text-align: center;
  margin-right: 12px;
  color: #fff;
  font-size: 14px;
}
/*.header-top__nav .item > a:hover {*/
/*  background-color: rgba(255, 255, 255, .2);*/
/*}*/
.header-top__nav .item-home {}
.header-top__nav .item-home a {

  width: 50px;
  padding: 0 0 0 20px;
  background: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/page_icons.png') no-repeat -845px -74px;
}
.header-top__user {
  float: right;
}
.header-top__user .login-box {
  float: left;
  margin-right: 10px;
  font-size: 0;
}
.header-top__user .login-box a,
.header-top__user .login-box span {
  display: inline-block;
}
.header-top__user .login-box a {
  display: inline-block;
  padding: 0 10px;
  height: 42px;
  line-height: 42px;
  color: #fff;
  font-size: 12px;
}
.header-top__user .login-box span {
  height: 12px;
  margin-top: 16px;
  border-left: 1px solid #fff;
  vertical-align: top;
}
.header-top__user .login-box a:hover {
  background-color: rgba(255, 255, 255, .2);
}
.header-top__user .user-post {
  position: relative;
  float: left;
}
.header-top__user .user-post .link {
  width: 58px;
  height: 48px;
  text-align: center;
  line-height: 42px;
  color: #fff;
  /*background: url(../images/user_post.png) no-repeat;*/
}
.header-top__user .user-post .link:hover {
  /*background: url(../images/user_post_hover.png) no-repeat;*/
}
.header-hover {
  display: none;
}
.header-top__nav .item:hover .header-hover,
.header-top__user .user-post:hover .header-hover {
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
</style>
