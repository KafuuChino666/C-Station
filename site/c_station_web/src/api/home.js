import request from '@/utils/request'

export default {
  getZoneHierarchyStructure () {
    return request({
      url: `/api/video/zone/hierarchy`,
      method: 'get'
    })
  }
}
