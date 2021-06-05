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
        <AliPlayer/>
        <div class="info tb-box">
          <ul class="th">
            <li>视频标题</li>
            <li>谁能拒绝这么可爱的萝莉呢！</li>
          </ul>
          <ul>
            <li>作品简介</li>
            <li>凡是这种涉及可爱、萝莉的</li>
          </ul>
          <ul>
            <li>视频ID</li>
            <li>3254654511</li>
          </ul>
          <ul>
            <li>上传时间</li>
            <li>2021-05-15 12:12:00</li>
          </ul>
          <ul>
            <li>违纪说明</li>
            <li>无</li>
          </ul>
          <ul>
            <li>视频状态</li>
            <li>待审核</li>
          </ul>
          <ul>
            <li>审核时间</li>
            <li>2021-05-15 12:12:00</li>
          </ul>
          <ul>
            <li>审核员</li>
            <li>1052(色情), 1036(政审)</li>
          </ul>
          <ul>
            <li>作者</li>
            <li>风之轻水之净</li>
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
              <el-button type="primary">通过</el-button>
              <el-button type="info">未通过</el-button>
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
                  :total="50"
                >
                </el-pagination>
              </div>
              <div class="posterize-img" v-for="item in 16" :key="item">
                <el-image
                  :fit="contain"
                  :preview-src-list="srcList"
                  src="https://mcsql-002.oss-cn-beijing.aliyuncs.com/download.jpg"
                ></el-image>
                <span class="demonstration">00:45:15</span>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <!--    <router-view />-->
  </div>
</template>

<script>
import AliPlayer from '@/views/video/components/AliPlayer'

export default {
  name: 'AuditVideo',
  components: { AliPlayer },
  data() {
    return {
      srcList: [
        'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
        'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
      ],
      videoInfo: {
        // 视频标题谁能拒绝这么可爱的萝莉呢！
        videoTitle: '',
        // 作品简介凡是这种涉及可爱、萝莉的
        videoBrief: '',
        // 视频ID3254654511
        id: '',
        // 上传时间2021-05-15 12:12:00
        gmtCreate: '',
        // 违纪说明无
        disciplineInfo: '',
        // 视频状态待审核
        auditStatus: '',
        // 审核时间2021-05-15 12:12:00
        gmtModified: '',
        // 审核员1052(色情), 1036(政审)
        auditorInfo: '',
        // 作者风之轻水之净
        userName: ''
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

.audit-title li {
  list-style: none;
  float: left;
  padding: 0 10px;
  padding-top: 16px;
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
