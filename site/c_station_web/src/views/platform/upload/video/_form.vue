<template>
  <div class="uploadform-box">
    <h1 style="display: inline">文件上传 </h1>
    <p class="medium-title">（上传过程和视频文件大小/类型有关，请耐心等待）<p/>
    <el-progress :percentage="loadedPercent" style="margin-top: 10px"></el-progress>
    <el-divider></el-divider>
    <h1>基本信息 </h1>
    <p style="display: inline">视频封面设置</p>
    <p class="medium-title">（格式jpeg、png，文件大小≤5MB，建议尺寸≥1146*717，最低尺寸≥960*600）</p>
    <div style="margin-top: 20px">
      <div class="hoverImg">
        <div class="back">
          <div class="but" @onclick="this.print">上传封面</div>
          <div class="but" style="float: right" @click="dialogVisible = true">剪切修改</div>
        </div>
        <el-image :src="this.coves[0]" style="width: 200px; height: 130px"></el-image>
      </div>
      <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        >
        <CropperElement />
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
        </span>
      </el-dialog>
    </div>
    <el-form :model="ruleForm" ref="ruleForm" label-width="80px" style="padding-top: 10px">
      <el-form-item label="类型" prop="resource">
        <el-radio-group v-model="ruleForm.resource">
          <el-radio label="自制"></el-radio>
          <el-radio label="转载"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="标题" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="分区" prop="region">
        <el-cascader
          :props="{ expandTrigger: 'hover' }"
        ></el-cascader>
      </el-form-item>
      <el-form-item label="标签" prop="name">
        <el-tag
          :key="tag"
          v-for="tag in dynamicTags"
          closable
          :disable-transitions="false"
        >
          {{tag}}
        </el-tag>
      </el-form-item>
      <el-form-item label="推荐标签" prop="name">
        <el-button size="mini" round v-for="item in 17" :key="item">标签{{item}}</el-button>
      </el-form-item>
      <el-form-item label="简介">
        <el-input placeholder="填写更全面的相关信息，让更多的人能找到你的视频吧" type="textarea"></el-input>
      </el-form-item>
      <el-divider></el-divider>
      <el-collapse>
        <el-collapse-item title="更多选项" name="1">

          <el-form ref="form" label-width="80px">
            <el-form-item label="自制声明">
              <el-radio-group>
                <el-radio label="未经作者授权 禁止转载"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="开启专属水印">
              <el-switch></el-switch>
            </el-form-item>
            <el-form-item label="字幕设置">
              <el-select placeholder="请选择活动区域" value>
                <el-option label="区域一" value="shanghai"></el-option>
                <el-option label="区域二" value="beijing"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="商业声明">
              <el-radio-group>
                <el-radio label="不含商业推广信息"></el-radio>
                <el-radio label="含商业推广信息"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="允许观众投稿字幕">
              <el-switch></el-switch>
            </el-form-item>
          </el-form>

        </el-collapse-item>
      </el-collapse>
      <el-divider></el-divider>
      <h1>粉丝动态 </h1>
      <el-input type="textarea"></el-input>
      <el-form-item label="即时配送">
        <el-switch></el-switch>
      </el-form-item>
      <el-button type="primary">立即投稿</el-button>
      <el-button>保存模板</el-button>
    </el-form>
  </div>
</template>

<script>
import CropperElement from './CropperElement'
import Pubsub from 'pubsub-js'
import platform from '../../../../api/platform'

export default {
  name: 'VideoUploadForm',
  components: {CropperElement},
  data () {
    return {
      radio: '1',
      ruleForm: {},
      dynamicTags: ['标签一', '标签二', '标签三'],
      dialogVisible: false,
      imgUrl: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/wallhaven-lq7672.png',
      loadedPercent: 0,
      coves: []
    }
  },
  mounted () {
    Pubsub.subscribe('loadedPercent', (msg, value) => {
      this.loadedPercent = value
      if (value === 100) {
        this.getVideoCove()
        console.log("完成" + value)
      }
    })
  },
  methods: {
    print () {
      alert('111')
    },
    // 获取视频封面this.$parent.
    getVideoCove () {
      alert(this.$parent.videoId)
      if (this.$parent.videoId) {
        platform.getVideoCoveByVideoId(this.$parent.videoId).then(res => {
          this.coves = res.data.cove
        })
      }
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

.uploadform-box .el-collapse-item__header {
  font-weight: bold;
  font-size: 20px;
}

.medium-title {
  font-size: 13px;
  line-height: 20px;
  display: inline;
}

.hoverImg {
  width: 200px;
  height: 130px;
  position: relative;
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
</style>
