<template>
  <div class="pater-container">
    <div :span="24" style=" line-height: 23px; margin-bottom: 20px">
      <div class="ico"/>
      妹子：被你看光了，这下嫁不出去了
      <span class="trail">视频详细与分析</span>
    </div>
    <div class="low-container">
      <el-row>
        <el-col :span="5">
          <el-image
            style="width: 238px; height: 134px"
            src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/download.jpg"
            :fit="fit"
          />
          <el-row class="videoinfo">标题：{{ videoInfoForm.videoTitle }}</el-row>
          <el-row class="videoinfo2">简介：{{ videoInfoForm.videoBrief }}</el-row>
        </el-col>
        <el-col :span="5">
          <el-form :label-position="right" label-width="80px" :model="videoInfoForm">
            <el-form-item label="视频id：" class="item">
              {{ videoInfoForm.videoId }}
            </el-form-item>
            <el-form-item label="作者id：" class="item">
              {{ videoInfoForm.authorId }}
            </el-form-item>
            <el-form-item label="作者昵称：" class="item">
              {{ videoInfoForm.userName }}
            </el-form-item>
            <el-form-item label="创建时间：" class="item">
              {{ videoInfoForm.gmtCreate }}
            </el-form-item>
            <el-form-item label="播放数：" class="item">
              {{ videoInfoForm.playNub }}
            </el-form-item>
            <el-form-item label="分享数：" class="item">
              {{ videoInfoForm.videoPnumb }}
            </el-form-item>
            <el-form-item label="投币数：" class="item">
              {{ videoInfoForm.videoCoin }}
            </el-form-item>
            <el-form-item label="点赞数：" class="item">
              {{ videoInfoForm.likeNumber }}
            </el-form-item>
            <el-form-item label="视频分类：" class="item">
              {{ videoInfoForm.zoneType }}
              <el-tag>综合</el-tag>
            </el-form-item>
            <el-form-item label="视频状态：" class="item">
              {{ videoInfoForm.videoStatus }}
            </el-form-item>
          </el-form>
        </el-col>
        <el-col :span="13">
          <div class="prism-player" id="player-con"></div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import video from '@/api/video'

export default {
  name: 'VideoInfo',
  data() {
    return {
      videoInfoForm: {
        videoId: '', // 视频id
        authorId: '', // 作者id
        userName: '', // 作者昵称
        videoTitle: '', // 视频标题
        videoBrief: '', // 视频简介
        gmtCreate: '', // 创建时间
        playNub: 0, // 播放量
        videoPnumb: 0, // 分享数
        videoCoin: 0, // 投币数
        likeNumber: 0, // 点赞数
        zoneType: [], // 类型
        videoStatus: '' // 视频状态
      },
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

<style>
.pater-container {
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
}

.ico {
  border-radius: 0px;
  width: 9px;
  height: 23px;
  background-color: #ffdb36;
  float: left;
  margin-right: 5px;
}

.videoinfo {
  margin-top: 5px;
  font-size: 13px;
  line-height: 23px;
  color: #97a8be;
}

.videoinfo2 {
  margin-top: 5px;
  font-size: 12px;
  line-height: 15px;
  color: #97a8be;
}

.trail {
  margin-left: 10px;
  line-height: 23px;
  color: #99a9bf;
}

.low-container {
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  width: 100%;
  padding: 20px;
}

.item .el-form-item__label {
  color: #555555;
  font-size: 10px;
  font-weight: normal;
  line-height: 23px;
  padding-right: 5px;
}

.el-form-item {
  margin-bottom: 0px;
}

.el-form-item__content {
  line-height: 23px;
  color: #555555;
  font-size: 10px;
  font-weight: normal;
}

.el-tag {
  line-height: 23px;
  height: 23px;
  display: inline;
}

</style>
