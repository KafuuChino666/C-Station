import request from '@/utils/request'
// 视频菜单api

export default {
  getZoneParentNode() {
    return request({
      url: `/api/video/zone/root`,
      method: 'get'
    })
  },
  getZoneChildByParentId(parentId) {
    return request({
      url: `/api/video/zone/child/${parentId}`,
      method: 'get'
    })
  },
  verifyTitle(title) {
    return request({
      url: `/api/video/zone/verify/title/${title}`,
      method: 'get'
    })
  },
  addZone(zone) {
    return request({
      url: `/admin/video/zone/`,
      method: 'post',
      data: zone
    })
  }
}
