<template>
  <div class="prism-player" id="player-con"></div>
</template>

<script>
import video from '@/api/video'

export default {
  name: 'AliPlayer',
  data() {
    return {
      videoItemId: this.$route.query.videoItemId,
      vid: '30ac017200af4214ab82c02b6644662f', // 阿里云视频id
      playAuth: '' // 播放凭证
    }
  },
  // 页面渲染成功后获取数据
  // created() {
  //   // this.fetchData()
  // },
  mounted() {
    this.fetchData()
  },
  methods: {
    async fetchData() {
      await this.asyncData() // 获取凭证
      this.aliPlayer() // 渲染视频播放器
    },
    async asyncData() {
      const res = await video.getPlayAuth(this.videoItemId)
      this.playAuth = res.data.playAuth
      this.vid = res.data.vid
    },
    aliPlayer() {
      console.log('aliPlayer')
      // eslint-disable-next-line no-undef
      new Aliplayer({
        'id': 'player-con',
        'vid': this.vid,
        'playauth': this.playAuth,
        'qualitySort': 'asc',
        'format': 'mp4',
        'mediaType': 'video',
        'width': '100%',
        'autoplay': true,
        'isLive': false,
        'rePlay': false,
        'playsinline': true,
        'preload': true,
        'controlBarVisibility': 'hover',
        'useH5Prism': true
      }, function(player) {
        console.log('The player is created')
      })
      console.log('aliPlayer end')
    }
  }
}
</script>

<style scoped>

</style>
