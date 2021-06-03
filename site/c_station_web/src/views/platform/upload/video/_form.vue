<template>
  <div class="uploadform-box">
    <h1 style="display: inline">文件上传 </h1>
    <p class="medium-title">（上传过程和视频文件大小/类型有关，请耐心等待）<p/>
    <el-progress :percentage="loadedPercent" style="margin-top: 10px"></el-progress>
    <el-divider></el-divider>
    <h1>基本信息 </h1>
    <p style="display: inline">视频封面设置</p>
    <p class="medium-title">（格式jpeg、png，文件大小≤5MB，建议尺寸≥1146*717，最低尺寸≥960*600）</p>
    <div class="cover">
      <div class="hoverImg">
        <div class="back">
          <div class="but" @onclick="this.print">上传封面</div>
          <div class="but" style="float: right" @click="dialogVisible = true">剪切修改</div>
        </div>
        <el-image :src="coveUrl" style="width: 200px; height: 130px"></el-image>
      </div>
      <el-dialog
        title="视频封面 (建议上传高清封面尺寸≥1146*717)"
        :visible.sync="dialogVisible"
        >
        <CropperElement />
      </el-dialog>
      <div style="float: left">
        <div v-for="(item, index) in 3" :key="index" :class="index !== coverIndex ? 'cover-img' : 'cover-img cover-img-active cover-img-back-active:active'" ref="cover-item" @click="clickCoverItem(index)">
          <div :class="index !== coverIndex ? 'cover-img-back' : 'cover-img-back cover-img-back-active'">
            <i class="el-icon-check"></i>
          </div>
          <el-image :src="coves[index]"  style="width: 160px; height: 100px"></el-image>
        </div>
      </div>
    </div>
    <el-form :rules="rules.videoContributeForm" :model="video" ref="video" label-width="80px" style="padding-top: 10px">

      <el-form-item label="类型" prop="isInnovate">
        <el-radio-group v-model="video.isInnovate">
          <el-radio label="true">自制</el-radio>
          <el-radio label="false">转载</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="标题" prop="videoTitle">
        <el-input v-model="video.videoTitle"></el-input>
      </el-form-item>

      <el-form-item label="分区" prop="zoneId">
        <el-cascader
          v-model="video.zoneId"
          :options="zoneRootNodes"
          :props="props"
        ></el-cascader>
      </el-form-item>

      <el-form-item label="标签" prop="name">
        <el-tag
          :key="index"
          v-for="(tag, index) in dynamicTags"
          closable
          :disable-transitions="false"
          @close="closeTag(tag, index)"
        >
          {{tag.name}}
        </el-tag>
      </el-form-item>

      <el-form-item label="推荐标签" prop="name">
        <el-button @click="addTag(index)" :disabled="item.status === 0" size="mini" round v-for="(item, index) in recommendTags" :key="index">{{item.name}}</el-button>
      </el-form-item>

      <el-form-item label="简介" prop="videoBrief">
        <el-input v-model="video.videoBrief" placeholder="填写更全面的相关信息，让更多的人能找到你的视频吧" type="textarea"></el-input>
      </el-form-item>

      <el-divider></el-divider>
      <el-collapse>
        <el-collapse-item title="更多选项" name="1">

          <el-form-item label="自制声明" prop="isDeclare">
            <el-checkbox v-model="video.isDeclare">未经作者授权 禁止转载</el-checkbox>
          </el-form-item>

          <el-form-item label="开启专属水印">
            <el-switch v-model="video.isWatermark"></el-switch>
          </el-form-item>

          <el-form-item label="字幕设置">
            <el-select placeholder="请选择活动区域" value>
              <el-option label="区域一" value="shanghai"></el-option>
              <el-option label="区域二" value="beijing"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="商业声明">
            <el-radio-group v-model="video.isCommerce">
              <el-radio label="false">不含商业推广信息</el-radio>
              <el-radio label="true">含商业推广信息</el-radio>
            </el-radio-group>
          </el-form-item>

          <el-form-item label="允许观众投稿字幕">
            <el-switch v-model="video.restsCastCaption"></el-switch>
          </el-form-item>

        </el-collapse-item>
      </el-collapse>
      <el-divider></el-divider>

      <h1>粉丝动态 </h1>
      <el-input v-model="video.fanDynamic" type="textarea"></el-input>

      <el-form-item label="即时配送">
        <el-switch v-model="video.isTiming"></el-switch>
      </el-form-item>

      <el-date-picker
        type="date"
        placeholder="选择日期">
      </el-date-picker>

      <el-time-picker
        :picker-options="{
      selectableRange: '18:30:00 - 20:30:00'
    }"
        placeholder="任意时间点">
      </el-time-picker>

      <el-button @click="videoContribute" type="primary">立即投稿</el-button>
      <el-button>保存模板</el-button>
    </el-form>
  </div>
</template>

<script>
import CropperElement from './CropperElement'
import Pubsub from 'pubsub-js'
import platform from '../../../../api/platform'
import rule from '../../../../rules/rule'
export default {
  name: 'VideoUploadForm',
  components: {CropperElement},
  data () {
    return {
      rules: rule,
      radio: '1',
      ruleForm: {},
      zoneRootNodes: [],
      props: {
        lazy: true, // 开启懒加载
        value: 'id',
        label: 'title',
        lazyLoad (node, resolve) {
          if (node.value !== undefined) {
            let nodes
            platform.getChildByParentId(node.value).then(res => {
              nodes = res.data.zones
              console.log(nodes)
              resolve(nodes)
            })
          }
        }
      },
      dynamicTags: [],
      recommendTags: [
        {
          id: 1,
          name: '标签1',
          status: 1
        },
        {
          id: 2,
          name: '标签2',
          status: 1
        },
        {
          id: 3,
          name: '标签3',
          status: 1
        }
      ],
      dialogVisible: false,
      imgUrl: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/wallhaven-lq7672.png',
      loadedPercent: 0,
      coves: [],
      coveUrl: this.imgUrl,
      coveFile: {},
      coverIndex: 0,
      video: {
        videoId: '25465451574',
        isInnovate: true,
        videoTitle: '',
        coverUrl: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/wallhaven-lq7672.png',
        zoneId: '',
        tags: '',
        videoBrief: '',
        isDeclare: true,
        isWatermark: true,
        videoCaption: '',
        isCommerce: true,
        restsCastCaption: true,
        fanDynamic: '',
        isTiming: true,
        timingTime: '2031-05-25T14:24:45.346Z'
      },
      getVideoCoveRequestNum: 0
    }
  },
  mounted () {
    // 测试代码
    this.getVideoCove()
    // end
    Pubsub.subscribe('loadedPercent', (msg, value) => {
      this.loadedPercent = value
      // if (value === 100) {
      //   this.getVideoCove()
      // }
    })
    Pubsub.subscribe('onUploadEnd', (msg, value) => {
      this.getVideoCove()
      this.video.videoId = this.$parent.videoId
    })
    this.getZoneRootNode()
  },
  methods: {
    print () {
      alert('111')
    },

    getZoneRootNode () {
      platform.getAllRootNode().then(res => {
        this.zoneRootNodes = res.data.zones
      })
    },
    // 获取视频封面this.$parent.
    getVideoCove () {
      // this.$parent.videoId = '064bb1aed2064f44bb64d21b8b121969'
      if (this.$parent.videoId) {
        console.log(this.$parent.videoId)
        this.getVideoCoveRequestNum++
        platform.getVideoCoveByVideoId(this.$parent.videoId).then(res => {
          if (res.data.cove.length === 0 && this.getVideoCoveRequestNum <= 6) {
            setTimeout(() => {
              this.getVideoCove()
            }, 1500)
          }
          this.coves = res.data.cove
          this.coveUrl = this.coves[0]
        })
      }
      // let videoId = '64e1fa3151ee431fa72551c70560725e'
      // if (videoId) {
      //   platform.getVideoCoveByVideoId(videoId).then(res => {
      //     this.coves = res.data.cove
      //     this.coveUrl = this.coves[0]
      //   })
      // }
    },
    clickCoverItem (index) {
      this.coverIndex = index
      this.coveUrl = this.coves[index]
    },
    addTag (index) {
      if (this.recommendTags[index].status === 1) {
        this.dynamicTags.push(this.recommendTags[index])
        this.recommendTags[index].status = 0
      }
    },
    closeTag (item, index) {
      this.dynamicTags.splice(index, 1)
      this.recommendTags.forEach(it => {
        if (it.id === item.id) {
          it.status = 1
        }
      })
    },
    // 视频投稿
    videoContribute () {
      this.$refs['video'].validate((valid) => {
        if (valid) {
          // 上传图片
          // async function f () {
          //   await
          // }
          let param = new FormData()
          param.append('file', this.coveFile)
          platform.uploadVideoCover(param).then(res => {
            console.log(res.data.coverTemporaryKey)
          })

          // tags
          const tags = []
          this.dynamicTags.forEach(i => {
            tags.push(i.name)
          })
          this.video.tags = tags.toString()

          platform.videoContribute(this.video).then(res => {
            this.$message({
              showClose: true,
              message: '视频投稿成功',
              type: 'success'
            })
          })
        } else {
          this.$message({
            message: '请检查填写信息',
            type: 'warning'
          })
        }
      })
      // 1. 上传视频

      // 2. 上传视频封面

      // 3. 校验表单值

      // 4. 投稿完成
    }
  }
}
</script>

<style scoped>
.uploadform-box {
  padding: 0 140px;
}

.uploadform-box .el-tag {
  margin-right: 10px;
}

.medium-title {
  font-size: 13px;
  line-height: 20px;
  display: inline;
}

.cover {
  margin-top: 20px;
  width: 100%;
  height: 140px;
}

.hoverImg {
  width: 200px;
  height: 130px;
  position: relative;
  float: left;
}

.hoverImg .el-divider--horizontal {
  margin: 10px 0;
}

.back {
  height: 25px;
  width: 200px;
  visibility: visible;
  position: absolute;
  z-index: 10;
  bottom: 0;
  left: 0;
}

.back .but {
  height: 25px;
  width: 98px;
  background-color: rgba(0,0,0,.5);
  float: left;
  font-size: 12px;
  color: #fff;
  text-align: center;
  line-height: 25px;
}

.cover-img {
  width: 160px;
  height: 100px;
  position: relative;
  float: left;
  margin-left: 20px;
  margin-top: 10px;
}

.cover-img-back {
  height: 16px;
  width: 16px;
  visibility: hidden;
  position: absolute;
  background-color: #0070cc;
  bottom: 0;
  z-index: 10;
  right: 0;
  line-height: 16px;
  color: white;
}

.cover-img-active {
  border:1px solid #0070cc;
}

.cover-img-back-active {
  visibility: visible;
}
</style>
