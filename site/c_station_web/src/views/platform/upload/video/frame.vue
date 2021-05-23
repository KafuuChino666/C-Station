<template>
  <div class="frame-box">
    <el-upload
      v-if="!isShow"
      :auto-upload="true"
      :before-upload="this.beforeAvatarUpload"
      :limit="1"
      action="#"
      class="upload-video"
      drag
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
    <VideoUploadForm v-if="isShow"/>
  </div>
</template>
<!--  IE需要es6-promise -->
<script>
import platform from '../../../../api/platform'
import VideoUploadForm from './_form'
import Pubsub from 'pubsub-js'

export default {
  name: 'Frame',
  components: {VideoUploadForm},
  data () {
    return {
      uuid: '26972871321',
      videoId: '', // 阿里云视频id
      uploadAddress: '',
      uploadAuth: '',
      file: {},
      requestId: '',
      uploader: null,
      isShow: true
    }
  },
  methods: {
    // element 上传组件上传之前  false 表示停止上传
    beforeAvatarUpload (file) {
      this.file = file
      this.uploadAfterPrepare()
      return false
    },
    // 上传之前处理
    uploadAfterPrepare () {
      this.uploader = this.createUploader()
      this.isShow = true // 切换界面
      this.uploader.addFile(this.file, null, null, null, '{"Vod":{}}')
      this.uploader.startUpload() // 开始上传
    },
    // 创建上传对象
    createUploader (type) {
      let cref = this
      // eslint-disable-next-line
      var uploader = new AliyunUpload.Vod({
        // 阿里账号ID，必须有值
        userId: '1863852947442067',
        // 分片大小默认1 MB，不能小于100 KB
        partSize: 1048576,
        // 并行上传分片个数，默认5
        parallel: 5,
        // 网络原因失败时，重新上传次数，默认为3
        retryCount: 3,
        // 网络原因失败时，重新上传间隔时间，默认为2秒
        retryDuration: 2,
        // 是否上报上传日志到视频点播，默认为true
        enableUploadProgress: true,
        // 开始上传
        'onUploadstarted': function (uploadInfo) {
          console.log('onUploadStarted:' + uploadInfo.file.name + ', endpoint:' + uploadInfo.endpoint + ', bucket:' + uploadInfo.bucket + ', object:' + uploadInfo.object)
          // 上传方式1，需要根据uploadInfo.videoId是否有值，调用视频点播的不同接口获取uploadauth和uploadAddress，如果videoId有值，调用刷新视频上传凭证接口，否则调用创建视频上传凭证接口
          if (uploadInfo.videoId) {
            // 如果uploadInfo.videoId存在，调用刷新视频上传凭证接口
          } else {
            // 如果uploadInfo.videoId不存在，调用获取视频上传地址和凭证接口
            // 从视频点播服务获取的uploadAuth、uploadAddress和videoId，设置到SDK里
            platform.getUploadAuth('5541554').then(res => {
              cref.videoId = res.data.auth.videoId
              cref.uploadAddress = res.data.auth.uploadAddress
              cref.uploadAuth = res.data.auth.uploadAuth
              uploader.setUploadAuthAndAddress(uploadInfo, cref.uploadAuth, cref.uploadAddress, cref.videoId)
            }).catch(error => {
              cref.$notify({
                title: '错误',
                message: '服务器好像出差了~请稍后在试' + error,
                type: 'warning'
              })
            })
          }
        },
        // 文件上传成功
        'onUploadSucceed': function (uploadInfo) {
          console.log('onUploadSucceed: ' + uploadInfo.file.name + ', endpoint:' + uploadInfo.endpoint + ', bucket:' + uploadInfo.bucket + ', object:' + uploadInfo.object)
        },
        // 文件上传失败
        'onUploadFailed': function (uploadInfo, code, message) {
          console.log('onUploadFailed: file:' + uploadInfo.file.name + ',code:' + code + ', message:' + message)
        },
        // 文件上传进度，单位：字节
        'onUploadProgress': function (uploadInfo, totalSize, loadedPercent) {
          console.log('onUploadProgress:file:' + uploadInfo.file.name + ', fileSize:' + totalSize + ', percent:' + Math.ceil(loadedPercent * 100) + '%')
          Pubsub.publish('loadedPercent', Math.ceil(loadedPercent * 100))
        },
        // 上传凭证超时
        'onUploadTokenExpired': function (uploadInfo) {
          console.log('onUploadTokenExpired')
          // 实现时，根据uploadInfo.videoId调用刷新视频上传凭证接口重新获取UploadAuth
          // 从点播服务刷新的uploadAuth，设置到SDK里

          uploader.resumeUploadWithAuth(this.uploadAuth)
        },
        // 全部文件上传结束
        'onUploadEnd': function (uploadInfo) {
          console.log('onUploadEnd: uploaded all the files')
        }
      })
      return uploader
    }
  }
}
</script>

<style>
.frame-box {
  width: 100%;
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
