import request from '@/utils/request'
// 权限菜单api

export default {
  // 按员工编号搜索员工
  getStaffById() {
    return request({
      url: `/acl/login`,
      method: 'post'
    })
  }
}
