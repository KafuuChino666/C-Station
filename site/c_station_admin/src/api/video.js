import request from '@/utils/request'
// 视频菜单api

export default {

  // 根据查询表单查询video列表
  selectVideoByTerm(queryForm,page, limit) {
    return request({
      url: `/admin/video/list/${page}/${limit}`,
      method: 'get',
      params: {
        queryForm
      }
    })
  },
  // 查询所有状态
  selectAllVideoStatus() {
    return request({
      url: `/admin/video/status/`,
      method: 'get'
    })
  },
  // 获取video info
  getVideoInfoById(videoId) {
    return request({
      url: `/admin/video/info/${videoId}`,
      method: 'get'
    })
  },
  // 获取播放凭证
  getPlayAuth(videoSourceId) {
    return request({
      url: `/api/video/media/get-play-auth/${videoSourceId}`,
      method: 'get'
    })
  }
}
