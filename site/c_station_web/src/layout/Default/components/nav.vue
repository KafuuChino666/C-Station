<template>
  <div>
    <div :class="$attrs.genre === 'on' ? 'header-top on' : 'header-top'" :roll="$attrs.roll" id="header-top">
      <div class="header-nav">
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
          <div class="nav-search">
            <form id="nav_searchform">
              <input type="text" class="but" placeholder="可莉" />
              <div class="search-but">
                <i class="iconfont icon-sousuo1 search-submit"></i>
              </div>
            </form>
          </div>
        </div>
        <div class="header-top_user">
          <div class="user_c">
            <span>
              <div class="header-top_avatar">
                <span>
                  <div class="avatar-ico">登陆</div>
                </span>
              </div>
            </span>
            <span>
              <div class="item">
                <span class="name">大会员</span>
              </div>
            </span>
            <span>
              <div class="item">
                <span class="name">消息</span>
              </div>
            </span>
            <span>
              <div class="item">
                <span class="name">动态</span>
              </div>
            </span>
            <span>
              <div class="item">
                <span class="name">收藏</span>
              </div>
            </span>
            <span>
              <div class="item">
                <span class="name">历史记录</span>
              </div>
            </span>
            <span>
              <div class="item">
                <span class="name">创作中心</span>
              </div>
            </span>
          </div>
        </div>
        <div>
          <span class="upload-but">投稿</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Nav',
  props: ['genre']
}
</script>

<style scoped>


/* 1 */
.header-top {
  position: absolute;
  z-index: 10;
  width: 100%;
  height: 56px;
}
/* 2 */
.header-nav {
  box-sizing: border-box;
  padding: 10px 24px;
  line-height: 30px;
  position: relative;
  margin: 0 auto;
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
}
.header-top_nav {
}
.header-top_nav ul {
  height: 36px;
  display: flex;
  align-items: center;
  list-style: none;
}
.header-top_nav .item {
  margin-right: 12px;
}
.header-top_nav .item a {
  font-size: 14px;
  color: #fff;
  text-shadow: 0 1px 1px rgb(0 0 30%);
  line-height: 32px;
  white-space: nowrap;
  display: flex;
}

.header-top_user {
  display: flex;
  flex-shrink: 0;
}
.header-top_user .user_c {
  display: flex;
  align-items: center;
  line-height: 30px;
}
.header-top_user .user_c .item{
  position: relative;
  display: flex;
  margin-left: 12px;
  cursor: pointer;
}
.header-top_user .user_c .item .name {
  color: #fff;
  text-shadow: 0 1px 1px rgb(0 0  30%);
  white-space: nowrap;
  cursor: pointer;
  font-size: 14px;
}
.header-top_user .user_c .header-top_avatar {
  margin-right: 16px;
  width: 36px;
  height: 36px;
  position: relative;
  display: flex;
  margin-left: 12px;
  cursor: pointer;
}
.header-top_user .user_c .header-top_avatar .avatar-ico{
  width: 36px;
  height: 36px;
  border-radius: 50%;
  line-height: 36px;
  font-size: 12px;
  color: #00a1d6;
  letter-spacing: 0;
  background: #f6f6f6;
  text-align: center;
  font-weight: 600;
}
.upload-but {
  cursor: pointer;
  position: relative;
  color: rgb(255, 255, 255);
  font-size: 14px;
  display: block;
  width: 100px;
  height: 36px;
  line-height: 36px;
  text-align: center;
  background: rgb(251, 114, 153);
  border-radius: 2px;
  margin-left: 14px;
}

#search {
  /*position: absolute;*/
  /*bottom: 22px;*/
  /*right: 0;*/
  margin-top: 5px;
  border-color: rgba(0,0,0,0.12);
}
.search-box {
  margin: 0 10px;
  width: 500px;
  transition: width .3s;
}
.search-box .nav-search {
  position: relative;
}
.search-box .nav-search #nav_searchform{
  display: block;
  padding: 0 38px 0 16px;
  border: 1px solid hsla(0,0%,100%,0);
  border-radius: 2px;
  background-color: #fff;
}
.search-box .nav-search .but{
  overflow: hidden;
  width: 100%;
  height: 34px;
  border: none;
  background-color: transparent;
  box-shadow: none;
  color: #999;
  font-size: 14px;
  line-height: 34px;
  transition: all .2s;
}
.search-box .nav-search .search-but {
  position: absolute;
  top: 0;
  right: 0;
  margin: 0;
  padding: 0;
  width: 48px;
  height: 36px;
  border: none;
  border-radius: 2px;
  background: #e7e7e7;
  line-height: 26px;
  cursor: pointer;
}
.search-box .nav-search .search-submit {
  position: absolute;
  top: 8px;
  right: 16px;
  margin: 0;
  padding: 0;
  border: none;
  background: none;
  color: #505050;
  font-size: 14px;
  line-height: 20px;
  cursor: pointer;
  transition: all .2s;
}
.search-box .nav-search .search-submit:hover {
  color: rgb(0, 161, 214);
}
.header-top.on {
  position: fixed;
  top: 0;
  background-color: #FFFFFF;
  color: #212121;
  height: 56px;
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
  /*line-height: 42px;*/
  font-size: 18px;
  margin-right: 3px;
  color: white;
  /*top: 2px;*/
}
.header-top.on .search-box #nav_searchform {
  background: rgb(244, 244, 244);
  border: 1px solid rgb(231, 231, 231);
}
.header-top.on .header-top_user .user_c .item .name {
  color: #212121;
}
</style>
<script type="text/javascript">
import $ from 'jquery'

$(window).scroll(function () {
  if ($("#header-top").attr("roll") === 'false') {
    return;
  }
  if ($(this).scrollTop() >= 90) {
    $('#header-top').addClass('on')
  } else {
    $('#header-top').removeClass('on')
  }
});

</script>
