<template>
  <div class="frame-box">
    <el-upload
      :auto-upload="false"
      :file-list="this.fileList"
      :on-change="this.upload()"
      :limit="1"
      action="#"
      class="upload-video"
      drag
      @on-success="this.uploadSuccess()"
      multiple>
      <i class="el-icon-upload"></i>
      <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
      <div class="el-upload__tip" slot="tip">当前审核通道
        <el-tag
          style="line-height: 14px; height: 17px"
          type="success"
          effect="dark">
          流畅
        </el-tag>
      </div>
    </el-upload>
  </div>
</template>
<!--  IE需要es6-promise -->
<script src="/src/utils/aliyun-upload-sdk-1.5.2/lib/es6-promise.min.js"></script>
<script src="/src/utils/aliyun-upload-sdk-1.5.2/lib/aliyun-oss-sdk-6.13.0.min.js"></script>
<script src="/src/utils/aliyun-upload-sdk-1.5.2/aliyun-upload-sdk-1.5.2.min.js"></script>
<script>
import platform from '../../../../api/platform'

export default {
  name: 'Frame',
  data () {
    return {
      uuid: '26972871321',
      videoId: '',
      requestId: '',
      uploadAddress: '',
      uploadAuth: '',
      fileList: []
    }
  },
  methods: {
    upload(file, fileList) {
      alert(fileList + '222')
    },
    uploadSuccess (response, file, fileList) {
      alert(fileList)
    },
    getAuth () {
      platform.getUploadAuth().then(res => {
        this.videoId = res.data.auth.videoId
        this.uploadAddress = res.data.auth.uploadAddress
        this.uploadAuth = res.data.auth.uploadAuth
      }).then(error => {
        this.$notify({
          title: '错误',
          message: '服务器好像出差了~请稍后在试' + error,
          type: 'warning'
        })
      })
    }
  }
}
</script>

<style>
.frame-box {
  width: 100%;
  height: 500px;
}

.upload-video {
  text-align: center;
}

.upload-video .el-upload-dragger {
  width: 750px;
  height: 280px;
  margin: 10px auto;
}

.upload-video .el-icon-upload {
  padding-top: 50px;
}
</style>
