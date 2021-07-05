<template>
  <div>
    <div class="audit-title">
      <ul>
        <li>审核员ID: 5655255</li>
        <li>审核内容: 政治</li>
        <li>审核通道状态: 流畅</li>
        <li>今日审核数: 56</li>
      </ul>
    </div>
    <div class="audit-main">
      <div class="audit-main-left">
        <AliPlayer />
        <div class="info tb-box">
          <ul class="th">
            <li>视频标题</li>
            <li>{{ videoInfo.videoTitle }}</li>
          </ul>
          <ul>
            <li>作品简介</li>
            <li>{{ videoInfo.videoBrief }}</li>
          </ul>
          <ul>
            <li>视频ID</li>
            <li>{{ videoInfo.videoId }}</li>
          </ul>
          <ul>
            <li>上传时间</li>
            <li>{{ videoInfo.gmtModified }}</li>
          </ul>
          <ul>
            <li>违纪说明</li>
            <li>{{ videoInfo.disciplineInfo }}</li>
          </ul>
          <ul>
            <li>视频状态</li>
            <li>{{ videoInfo.auditStatus }}</li>
          </ul>
          <ul>
            <li>审核时间</li>
            <li>{{ videoInfo.auditTime }}</li>
          </ul>
          <ul>
            <li>审核员</li>
            <li>{{ videoInfo.auditorInfo }}</li>
          </ul>
          <ul>
            <li>作者</li>
            <li>{{ videoInfo.userName }}</li>
          </ul>
        </div>
      </div>
      <div class="audit-main-r">
        <div class="tb-box">
          <ul class="th">
            <li>操作栏</li>
          </ul>
          <ul style="height: 50px;">
            <li style="padding-top: 5px;">
              <el-button @click="pass()" type="primary">通过</el-button>
              <el-button @click="dialogVisible = true" type="info">未通过</el-button>
            </li>
          </ul>
        </div>
        <div class="video-list tb-box">
          <ul class="th">
            <li>视频抽帧列表</li>
          </ul>
          <ul style="height: 455px">
            <li style="text-indent: 0px; width: 100%">
              <div class="page-box">
                <el-pagination
                  style="display: flex;
                  justify-content: space-around"
                  layout="prev, pager, next"
                  :current-page="page"
                  :total="total"
                  :page-size="limit"
                  @current-change="changeCurrentPage"
                />
              </div>
              <div v-for="item in snapshotList" :key="item.Index" class="posterize-img">
                <el-image
                  fit="contain"
                  :preview-src-list="srcList"
                  :src="item.url"
                />
                <span class="demonstration" v-text="formatedDate(item.index * 5)">00:45:15</span>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <el-dialog
      title="请填写未通过信息"
      :visible.sync="dialogVisible"
      width="30%">
      <el-input type="textarea" v-model="disciplineInfo"></el-input>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="notPass()">确 定</el-button>
  </span>
    </el-dialog>
    <!--    <router-view />-->
  </div>
</template>

<script>
import AliPlayer from '@/views/video/components/AliPlayer'
import video from '@/api/video'

export default {
  name: 'AuditVideo',
  components: { AliPlayer },
  data() {
    return {
      videoItemId: this.$route.query.videoItemId,
      snapshotList: [],
      srcList: [],
      page: 1,
      limit: 16,
      total: 0,
      videoInfo: {},
      dialogVisible: false,
      disciplineInfo: ''
    }
  },
  mounted() {
    // 获取页面数据
    this.getSpriteOriginSnapshot(this.page, this.limit, this.videoItemId)
    this.loadVideoInfoByItemId()
  },
  methods: {
    getSpriteOriginSnapshot(page, limit, videoId) {
      video.spriteOriginSnapshot(page, limit, videoId).then(res => {
        if (res.code === 20000) {
          const mediaSnapshot = res.data.mediaSnapshot
          this.total = mediaSnapshot.total
          console.log(mediaSnapshot)
          this.snapshotList = mediaSnapshot.snapshots.snapshot
          this.snapshotList.forEach(res => {
            this.srcList.push(res.url)
          })
        }
      })
    },
    changeCurrentPage(page) {
      this.page = page
      this.getSpriteOriginSnapshot(this.page, this.limit, this.videoItemId)
    },
    formatedDate(s) {
      return Math.floor(s / 3600) + ':' + Math.floor(s / 60) + ':' + s % 60
    },
    loadVideoInfoByItemId() {
      if (this.videoItemId !== null && this.videoItemId !== undefined) {
        video.getVideoInfoByItemId(this.videoItemId).then(res => {
          if (res.code === 20000) {
            this.videoInfo = res.data.info
          }
        })
      }
    },
    // 通过
    pass() {
      this.$confirm('确定要通过此条视频嘛？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 请求服务器 通过视频
        video.videoAuditPass(this.videoItemId).then(res => {
          if (res.code === 20000) {
            this.$message({
              type: 'success',
              message: '通过成功!'
            })
            this.$router.push({ name: 'AuditList' })
          } else {
            this.$message({
              type: 'info',
              message: '操作失败，请刷新重试!'
            })
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消操作'
        })
      })
    },
    // 未通过
    notPass() {
      if (this.disciplineInfo !== null) {
        video.videoAuditNotPass(this.disciplineInfo, this.videoItemId).then(res => {
          this.dialogVisible = false
          if (res.code === 20000) {
            this.$message({
              type: 'success',
              message: '操作成功!'
            })
          }
          // 跳转链表
          this.$router.push({ name: 'AuditList' })
        })
      }
    }
  }
}
</script>

<style scoped>
.audit-title {
  width: 100%;
  background: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  height: 50px;
}

.audit-title ul {
  margin: 0;
}

.audit-title li {
  list-style: none;
  float: left;
  padding: 16px 10px 0;
  margin: 0;
}

.audit-main {
  margin-top: 30px;
}

.audit-main-left {
  width: 600px;
  float: left;
}

.audit-main .info {
  margin-top: 20px;
}

.tb-box ul {
  list-style: none;
  padding: 0px;
  margin: 0px;
  width: 100%;
  height: 30px;
  line-height: 30px;
  border: 1px solid #DFE3EC;
  border-top: 0px;
  font-size: 12px;
}

.tb-box ul li {
  display: block;
  width: 33%;
  float: left;
  text-indent: 2em;
}

.tb-box .th {
  background: #E7EEF6;
  font-weight: bold;
  border-top: 1px;
  line-height: 36px;
  height: 36px;
}
.tb-box li {
  white-space:nowrap;
  text-overflow:ellipsis;
  overflow: hidden;
}
.audit-main-r {
  float: right;
  width: 630px;
}

.video-list {
  margin-top: 20px;
  width: 100%;
}

.video-list .list-box {
  width: 100px;
}

.posterize-img {
  float: left;
  padding: 15px 5px;
  height: 100px;
  width: 157px;
  line-height: 13px;
  text-align:center;
}

.posterize-img .el-image {
  position: relative;
  display: inline-block;
  overflow: hidden;
}
</style>
<style>
.el-dialog__body {
  padding: 5px 20px;
}
</style>
