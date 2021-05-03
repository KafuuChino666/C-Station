import request from '@/utils/request'
// 视频菜单api

export default {

  // 根据查询表单查询video列表
  selectVideoByTerm(queryForm) {
    return request({
      url: `/admin/video/query/`,
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
  }
}
