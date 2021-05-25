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
  },
  // 获取视频类型父节点
  getAllRootNode () {
    return request({
      url: `/api/video/zone/root`,
      method: 'get'
    })
  },
  getChildByParentId (value) {
    return request({
      url: `/api/video/zone/child/${value}`,
      method: 'get'
    })
  },
  // 视频投稿
  videoContribute (video) {
    return request({
      url: `/api/video/platform/`,
      method: 'post',
      data: video
    })
  }
}
