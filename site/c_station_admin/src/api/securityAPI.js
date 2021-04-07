import request from '@/utils/request'
// 权限菜单api

export default {
  // 按员工编号搜索员工
  getUserById(id) {
    return request({
      url: '/admin/acl/user/${id}',
      method: 'get'
    })
  },

  // 获取员工列表
  userList() {
    return request({
      url: '/admin/acl/user/list',
      method: 'get'
    })
  },

  // 分页获取员工列表
  pageUserList(page, limit, searchObj) {
    return request({
      url: '/admin/acl/user/list/${page}/${limit}',
      method: 'get',
      params: { searchObj }
    })
  },

  // 根据id修改员工状态
  updateUserStatusById(id, status) {
    return request({
      url: '/admin/acl/user/update/status',
      method: 'put',
      params: {
        'id': id,
        'status': status
      }
    })
  }
}
