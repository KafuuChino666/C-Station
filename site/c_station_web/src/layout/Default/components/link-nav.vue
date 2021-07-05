<template>
  <div class="page-width">
    <div class="nav-primary-menu">
      <div class="page-tab">
        <ul class="con">
          <li>
            <a href="#">
              <div class="round">
                <i class="bilifont"></i>
              </div>
              <span>首页</span>
            </a>
          </li>
          <li>
            <a href="#">
              <div class="round">
                <i class="bilifont"></i>
              </div>
              <span>首页</span>
            </a>
          </li>
          <li>
            <a href="#">
              <div class="round">
                <i class="bilifont"></i>
              </div>
              <span>首页</span>
            </a>
          </li>
          <li>
            <a href="#">
              <div class="round">
                <i class="bilifont"></i>
                <div class="dot"><i></i></div>
              </div>
              <span>首页</span>
            </a>
          </li>
        </ul>
      </div>
      <span class="tab-line"></span>
      <div class="nav-list">
        <ul>
          <li class="item" v-for="i in 15" :key="zones[i].id">
            <a href="#" class="link">
              <span>{{ zones[i].title }}<div class="num">999+</div></span>
            </a>
            <ul class="nav-item__hover">
              <li v-for="ch in zones[i].children">
                <a href="#">
                  <em>{{ ch.title }}<i></i></em>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <span class="tab-line"></span>
      <div class="fast-link">
        <span>
          <div class="item">
            <a href="#" class="name">
              <svg aria-hidden="true" class="svg-icon">
                <use xlink:href="#icon-zhuanlan2"></use>
              </svg>
              <span>专栏</span>
            </a>
          </div>
        </span>
        <span>
          <div class="item">
            <a href="#" class="name">
              <svg aria-hidden="true" class="svg-icon">
                <use xlink:href="#icon-ziyuan"></use>
              </svg>
              <span>活动</span>
            </a>
          </div>
        </span>
        <span>
          <div class="item">
            <a href="#" class="name">
              <svg aria-hidden="true" class="svg-icon">
                <use xlink:href="#icon-kongjianzhan"></use>
              </svg>
              <span>空间</span>
            </a>
          </div>
        </span>
        <span>
          <div class="item">
            <a href="#" class="name">
              <svg aria-hidden="true" class="svg-icon">
                <use xlink:href="#icon-fanju"></use>
              </svg>
              <span>番剧</span>
            </a>
          </div>
        </span>
        <span>
          <div class="item">
            <a href="#" class="name">
              <svg aria-hidden="true" class="svg-icon">
                <use xlink:href="#icon-huodong2"></use>
              </svg>
              <span>收藏</span>
            </a>
          </div>
        </span>
        <span>
          <div class="item">
            <a href="#" class="name">
              <svg aria-hidden="true" class="svg-icon">
                <use xlink:href="#icon-kongjian3"></use>
              </svg>
              <span>创意</span>
            </a>
          </div>
        </span>
      </div>
    </div>
  </div>
</template>

<script>
import home from '../../../api/home'
export default {
  name: 'LinkNav',
  data() {
    return {
      zones: []
    }
  },
  mounted () {
    home.getZoneHierarchyStructure().then(res => {
      this.zones = res.data.zone
    })
  }
}
</script>

<style scoped>
.nav-primary-menu {
  display: flex;
  -ms-flex-pack: justify;
  justify-content: space-between;
  -ms-flex-align: center;
  align-items: center;
  padding: 20px 0;
  width: 100%;
}
.page-tab {
  width: 200px;
}
.page-tab li{
  width: 50px;
  float:left;
  text-align: center;
  font-size: 14px;
  white-space: nowrap;
}
.page-tab .con li {
  cursor: pointer;
  height: 68px;
  text-align: center;
  font-size: 14px;
  white-space: nowrap;
  border-radius: 16px;
  transition: all .3s;
}
.page-tab li a{
  color: #212121;
}
.page-tab .con li:hover a {
  color: #00a1d6;
  transition: color .3s;
}
.page-tab li .round {
  position: relative;
  width: 36px;
  height: 36px;
  background: #ff5c7c;
  border-radius: 36px;
  line-height: 36px;
  text-align: center;
  margin: 0 auto 4px;
}
.page-tab li .round .bilifont {
  color: #fff;
  font-size: 28px;
}
.page-tab li .round .dot i {
  position: absolute;
  right: -2px;
  top: -2px;
  width: 10px;
  height: 10px;
  border-radius: 50%;
  background: #fa5a57;
  border: 2px solid #fff;
}

.tab-line {
  display: inline-block;
  height: 46px;
  border-left: 1px solid #e7e7e7;
  margin: 0 8px;
}

/* list */
.nav-list {
  float: left;
  height: 38px;
  display: flex;
  -ms-flex-direction: column;
  flex-direction: column;
  width: 670px;
  position: relative;
  bottom: 3px;
  /*padding: 12px 0;*/
}
.nav-list .item {
  position: relative;
  float: left;
  padding: 0 11px 10px;
}
.nav-list .link {
  position: relative;
  padding-top: 2px;
  font-size: 14px;
}
.nav-list .link:hover {
  color: #00a1d6;
}
.nav-list .num {
  position: relative;
  height: 14px;
  bottom: 2px;
  font-style: normal;
  font-size: 12px;
  line-height: 14px;
  display: inline-block;
  background: #ffafc9;
  border-radius: 2px;
  color: #fff;
  margin-left: 1px;
  transform: scale(.85);
  width: 32px;
  text-align: center;
}
.nav-list .num i {
  display: block;
  padding: 1px 3px;
  line-height: 12px;
  text-align: center;
  font-family: Calibri,Arial,Helvetica,sans-serifsans-serif;
}
.nav-item__hover {
  z-index: 999;
  display: none;
  position: absolute;
  left: 0;
  box-shadow: rgba(0,0,0,0.16) 0 2px 4px;
  border-radius: 0 0 4px 4px;
  background-color: #fff;
}
.nav-list .item:hover .nav-item__hover {
  display: block;
}
.nav-item__hover li {
  overflow: hidden;
  position: relative;
  min-width: 120px;
  height: 30px;

  transition: all .2s;
}
.nav-item__hover li:hover {
  background-color: #e5e9ef;
}
.nav-item__hover li a {
  overflow: hidden;
  position: relative;
  left: 0;
  padding: 0 25px;
  line-height: 30px;
  background: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/page_icons2.png') no-repeat 12px -1613px;

  transition: all .2s;
}
.nav-item__hover li:hover a {
  left: 5px;
}
.nav-item__hover li em {
  position: relative;
  display: inline-block;
  height: 30px;
  white-space: nowrap;
}
.nav-item__hover li i {
  position: absolute;
  top: 0;
  right: -100px;
  width: 4px;
  height: 30px;
  background: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/page_icons2.png') no-repeat -1px -1576px;
  opacity: 0;

  transition: all .2s;
}
.nav-item__hover li:hover i {
  right: -10px;
  opacity: 1;
}

/* link */
@media screen and (max-width: 1654px){
  .fast-link {
    width: 220px;
  }
}
@media screen and (max-width: 1870px){
  .fast-link {
    width: 242px;
  }
}

.fast-link{
  display: -ms-flexbox;
  display: flex;
  -ms-flex-direction: column;
  flex-direction: column;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  height: 68px;
  width: 289px;
}
@media screen and (max-width: 1654px) {
  .nav-primary-menu .fast-link {
    width: 220px;
  }
}
@media screen and (max-width: 1870px) {
  .nav-primary-menu .fast-link {
    width: 242px;
  }
}
.fast-link .item{
  height: 34px;
  display: -ms-flexbox;
  display: flex;
}
.fast-link .item .name{
  font-size: 14px;
  display: -ms-flexbox;
  display: flex;
  -ms-flex-align: center;
  align-items: center;
  white-space: nowrap;
}
.fast-link .item .svg-icon{
  width: 1.6em;
  height: 1.6em;
  vertical-align: middle;
  fill: currentColor;
  overflow: hidden;
}
</style>
