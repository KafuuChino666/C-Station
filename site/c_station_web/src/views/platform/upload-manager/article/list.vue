<template>
  <div>
    <div>
      <div style="float: left">
        <a href="#">
          <el-image style="height: 96px; width: 154px" :src="src"></el-image>
        </a>
      </div>
      <div class="meta-wrp">
        <div class="meta-title"><a>仁王2柴田胜家手残打法，看了必会</a></div>
        <div class="meta-status">
          <div>21-01-11 11:52:04</div>
        </div>
        <div class="meta-footer">
          <ul>
            <li>
              <i class="el-icon-video-play"></i>
              <span>101</span>
            </li>
            <li>
              <i class="el-icon-video-play"></i>
              <span>101</span>
            </li>
            <li>
              <i class="el-icon-video-play"></i>
              <span>101</span>
            </li>
            <li>
              <i class="el-icon-video-play"></i>
              <span>101</span>
            </li>
            <li>
              <i class="el-icon-video-play"></i>
              <span>101</span>
            </li>
            <li>
              <i class="el-icon-video-play"></i>
              <span>101</span>
            </li>
            <li>
              <i class="el-icon-video-play"></i>
              <span>101</span>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'article-list',
  data () {
    return {
      src: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/wallhaven-lq7672.png'
    }
  }
}
</script>

<style scoped>
.meta-wrp {
  float: left;
  margin-left: 25px;
  font-size: 16px;
  color: #212121;
  line-height: 20px;
  vertical-align: middle;
}

.meta-status {
  padding: 16px 0 20px 0;
  font-size: 14px;
  color: #505050;
  line-height: 16px;
}

.meta-footer span{
  font-size: 12px;
  margin-left: 5px;
}

.meta-footer li {
  float: left;
  list-style-type: none;
  font-size: 16px;
  color: rgb(153, 153, 153);
  margin-right: 25px;
}
</style>
