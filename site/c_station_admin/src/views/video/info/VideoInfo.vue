<template>
  <div class="pater-container">
    <el-col :span="24" style=" line-height: 23px">
      <div class="ico" />
      妹子：被你看光了，这下嫁不出去了
      <span class="trail">视频详细与分析</span>
    </el-col>
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
              {{ videoInfoForm.playNub  }}
            </el-form-item>
            <el-form-item label="分享数：" class="item">
              {{ videoInfoForm.videoPnumb  }}
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
          <div id="J_prismPlayer" class="prism-player"/>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import video from '@/api/video'

export default {
  name: 'VideoInfo',
  async asyncData(page) {
    const vid = this.$route.query.id
    const response = await video.getPlayAuth(vid)
    return {
      videoId: vid,
      playAuth: response.data.playAuth
    }
  },
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
      playAuth: ''
    }
  },
  // 页面渲染成功后获取数据
  created() {
    this.fetchData()
  },
  mounted() {
    /* eslint-disable no-undef */ // 忽略 no-undef 检测
    /* const player = */ new Aliplayer({
      id: 'J_prismPlayer',
      width: '100%',

      // 播放方式二：加密视频的播放：首先获取播放凭证
      // encryptType: '1', // 如果播放加密视频，则需设置encryptType=1，非加密视频无需设置此项
      vid: this.videoId,
      playauth: this.playAuth
    }, function(player) {
      console.log('播放器创建成功')
    })
  },
  methods: {
    fetchData() {
      this.videoId = this.$route.query.id
      if (this.videoId.length > 0) {
        // 请求数据api
        video.getVideoInfoById(this.videoId).then(res => {
          this.videoInfoForm = res.data.rows
        })
      }
    }
  }
}
</script>

<style>
.pater-container {
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
  padding: 30px;
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
  margin-top: 50px;
}

.item .el-form-item__label{
  color: #555555;
  font-size: 10px;
  font-weight: normal;
  line-height: 23px;
  padding-right: 5px;
}

.el-form-item{
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

/* 测试css 不需要则删除 */
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>
