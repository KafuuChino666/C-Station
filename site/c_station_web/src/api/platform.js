import request from '@/utils/request'

export default {
  // 获取上传地址和凭 证
  getUploadAuth (uuid) {
    return request({
      url: `/api/video/media/get-upload-auth/${uuid}`,
      method: 'get'
    })
  },
  // 获取视频封面
  getVideoCoveByVideoId (videoId) {
    return request({
      url: `/api/video/media/get-video-cove/${videoId}`,
      method: 'get'
    })
  }
}
