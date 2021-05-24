<template>
  <div class="menu">
    <ul class="con">
      <li v-for="item in 4" :key="item">
        <a href="#">
          <div class="round">
            <el-avatar :size="36" :src="circleUrl"></el-avatar>
          </div>
          <span>首页</span>
        </a>
      </li>
    </ul>
    <div class="navigation">
      <div><a href="#">动画<em>999</em></a></div>
      <el-popover
        placement="top"
        width="160"
        v-model="visible">
        <span>1111</span>
        <div slot="reference"><a href="#">动画<em>999</em></a></div>
      </el-popover>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Menu',
  data () {
    return {
      circleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'
    }
  }
}
</script>

<style scoped>
.menu {
  margin-top: 20px;
  width: 100%;
  height: 100px;
  background-color: #b3d4fc;
}

.con {
  width: 200px;
  height: 61px;
  list-style-type: none;
  margin: 0;
  padding: 0;
  float: left;
}

.con li {
  width: 50px;
  text-align: center;
  float: left;
}

.con .round {
  width: 36px;
  margin: auto;
}

.navigation {
  font-size: 14px;
}

.navigation em {
  font-style: normal;
  font-size: 12px;
  display: inline-block;
  background: #73c9e5;
  border-radius: 2px;
  color: #fff;
  margin-left: 1px;
  transform: scale(.85);
  width: 32px;
  text-align: center;
}

</style>
