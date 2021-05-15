<template>
  <div class="frame-box">
    <el-upload
      class="upload-video"
      drag
      action="https://jsonplaceholder.typicode.com/posts/"
      @on-success="uploadSuccess()"
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

<script>
export default {
  name: 'Frame',
  methods: {
    uploadSuccess (response, file, fileList) {
      alert(fileList)
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
  text-align:center;
}
.upload-video .el-upload-dragger{
  width: 750px;
  height: 280px;
  margin: 10px auto;
}

.upload-video .el-icon-upload {
  padding-top: 50px;
}
</style>
