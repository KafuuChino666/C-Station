<template>
  <div>
    <!-- 阿里云视频播放器样式 -->
    <link rel="stylesheet" href="https://g.alicdn.com/de/prismplayer/2.8.2/skins/default/aliplayer-min.css" >
<!--    &lt;!&ndash; 启用私有加密的防调式：生产环境使用 &ndash;&gt;-->
<!--    <script src="https://g.alicdn.com/de/prismplayer/2.8.0/hls/aliplayer-vod-anti-min.js" />-->
<!--    &lt;!&ndash; 阿里云视频播放器脚本 &ndash;&gt;-->
<!--    <script charset="utf-8" type="text/javascript" src="https://g.alicdn.com/de/prismplayer/2.8.2/aliplayer-min.js" />-->
    <!-- 定义播放器dom -->
    <div id="J_prismPlayer" class="prism-player container"/>

  </div>
</template>

<script>
import video from '@/api/video'

export default {
  async asyncData(page) {
    const vid = page.route.params.vid // 获取视频id
    const response = await video.getPlayAuth(vid) // 请求vod微服务获取视频播放凭证
    return {
      vid: vid, // 视频id
      playAuth: response.data.playAuth
    }
  },

  mounted() {
    /* eslint-disable no-undef */
    new Aliplayer({
      id: 'J_prismPlayer',
      width: '65%',
      height: '500px',
      // 播放方式二：加密视频的播放：首先获取播放凭证
      encryptType: '1', // 如果播放加密视频，则需设置encryptType=1，非加密视频无需设置此项
      vid: this.vid,
      playauth: this.playAuth
    }, function(player) {
      console.log('播放器创建成功')
    })
  }
}
</script>
<style scoped>
.container{
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>
