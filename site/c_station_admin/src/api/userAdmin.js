import request from '@/utils/request'
// 权限菜单api

export default {
// 按员工编号搜索员工
  selectUserByID(userId) {
    return request({
      url: `/views/user/components/select/${userId}`,
      method: 'get'
    })
  },
}
