<template>
  <div class="prism-player" id="player-con"></div>
</template>

<script>
import video from '@/api/video'

export default {
  name: 'AliPlayer',
  data() {
    return {
      videoId: -1,
      vid: '30ac017200af4214ab82c02b6644662f',
      playAuth: ''
    }
  },
  // 页面渲染成功后获取数据
  created() {
    this.fetchData()
  },
  mounted() {
    this.d()
  },
  methods: {
    async d() {
      await this.asyncData() // 获取凭证
      this.aliPlayer() // 渲染视频播放器
    },
    async asyncData() {
      console.log('asyncData')
      // const vid = this.$route.query.id
      const vid = '30ac017200af4214ab82c02b6644662f'
      const res = await video.getPlayAuth(vid)
      this.playAuth = res.data.playAuth
    },
    fetchData() {
      this.videoId = this.$route.query.id
      if (this.videoId.length > 0) {
        // 请求数据api
        video.getVideoInfoById(this.videoId).then(res => {
          this.videoInfoForm = res.data.rows
        })
      }
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
