<template>
  <div class="cr">
    <div class="cr-left">
      <VueCropper
        ref="cropper"
        :img="option.img"
        :outputSize="option.outputSize"
        :outputType="option.outputType"
        :info="option.info"
        :canScale="option.canScale"
        :autoCrop="option.autoCrop"
        :autoCropWidth="option.autoCropWidth"
        :autoCropHeight="option.autoCropHeight"
        :fixed="option.fixed"
        :fixedNumber="option.fixedNumber"
        :full="option.full"
        :fixedBox="option.fixedBox"
        :canMove="option.canMove"
        :canMoveBox="option.canMoveBox"
        :original="option.original"
        :centerBox="option.centerBox"
        :height="option.height"
        :infoTrue="option.infoTrue"
        :maxImgSize="option.maxImgSize"
        :enlarge="option.enlarge"
        :mode="option.mode"
        @realTime="realTime"
        >
      </VueCropper>
    </div>
    <div class="cr-right">
<!--      <div class="preview">-->
<!--        <img :src="previews.url" :style="previews.img"/>-->
<!--      </div>-->
    </div>
  </div>
</template>

<script>
import {VueCropper} from 'vue-cropper'

export default {
  name: 'CropperElement',
  components: {VueCropper},
  data () {
    return {
      previews: {},
      option: {
        img: '', // 裁剪图片的地址
        outputSize: 1, // 裁剪生成图片的质量(可选0.1 - 1)
        outputType: 'jpeg', // 裁剪生成图片的格式（jpeg || png || webp）
        info: true, // 图片大小信息
        canScale: false, // 图片是否允许滚轮缩放
        autoCrop: true, // 是否默认生成截图框
        autoCropWidth: 230, // 默认生成截图框宽度
        autoCropHeight: 150, // 默认生成截图框高度
        fixed: true, // 是否开启截图框宽高固定比例
        fixedNumber: [1.53, 1], // 截图框的宽高比例
        full: false, // false按原比例裁切图片，不失真
        fixedBox: false, // 固定截图框大小，不允许改变
        canMove: false, // 上传图片是否可以移动
        canMoveBox: true, // 截图框能否拖动
        original: false, // 上传图片按照原始比例渲染
        centerBox: false, // 截图框是否被限制在图片里面
        height: true, // 是否按照设备的dpr 输出等比例图片
        infoTrue: false, // true为展示真实输出图片宽高，false展示看到的截图框宽高
        maxImgSize: 3000, // 限制图片最大宽度和高度
        enlarge: 1 // 图片根据截图框输出比例倍数
      },
      avatarUrl: 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/wallhaven-lq7672.png'
    }
  },
  mounted () {
    let _super = this.$parent.$parent
    console.log(_super.coves)
    this.setAvatarBase64(_super.coves[_super.coverIndex], (base64) => {
      this.option.img = base64
    })
  },
  methods: {
    uploadImg (e, num) {
      // 上传图片
      this.option.img = ''
      var file = e.target.files[0]
      if (!/\.(gif|jpg|jpeg|png|bmp|GIF|JPG|PNG)$/.test(e.target.value)) {
        alert('图片类型必须是.gif,jpeg,jpg,png,bmp中的一种')
        return false
      }
      var reader = new FileReader()
      reader.onload = (e) => {
        let data
        data = e.target.result
        if (typeof e.target.result === 'object') {
          // 把Array Buffer转化为blob 如果是base64不需要
          data = window.URL.createObjectURL(new Blob([e.target.result]))
        } else {
          data = e.target.result
        }
        if (num === 1) {
          this.option.img = data
        } else if (num === 2) {
          this.option.img = data
        }
      }
      // 转化为base64
      reader.readAsDataURL(file)
      // 转化为blobcs
      // reader.readAsArrayBuffer(file)
    },

    // 设置头像base64
    setAvatarBase64 (src, callback) {
      let _this = this
      let image = new Image()
      // 处理缓存
      image.src = src + '&v=' + Math.random()

      // image.src = src
      // 支持跨域图片
      image.crossOrigin = '*'
      // image.setAttribute('crossOrigin', 'anonymous')
      image.onload = function () {
        console.log('setAvatarBase64')
        let base64 = _this.transBase64FromImage(image)
        callback && callback(base64)
      }
    },
    // 将网络图片转换成base64格式
    transBase64FromImage (image) {
      let canvas = document.createElement('canvas')
      canvas.width = image.width
      canvas.height = image.height
      let ctx = canvas.getContext('2d')
      ctx.drawImage(image, 0, 0, image.width, image.height)
      // 可选其他值 image/jpeg
      console.log('transBase64FromImage')
      return canvas.toDataURL('image/png')
    },
    realTime (data) {
      this.previews = data
      console.log(this.previews)
    }
  }
}
</script>

<style scoped>
.cr {
  padding: 0px;
}

.cr-left {
  width: 428px;
  height: 261px;
  background-color: #404040;
  border-radius: 3px;
  float: left;
}

.cr-right {
  width: 230px;
  height: 300px;
  float: right;
}

.cr .el-dialog__body {
  padding: 10px 20px;
}

.preview {
  width: 142px;
  height: 80px;
}
</style>
