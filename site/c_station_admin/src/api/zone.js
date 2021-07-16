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
  }
}
