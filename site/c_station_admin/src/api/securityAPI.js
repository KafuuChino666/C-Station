import request from '@/utils/request'
// 权限菜单api

export default {
  // 按员工编号搜索员工
  getStaffById(id) {
    return request({
      url: `/admin/acl/staff/${id}`,
      method: 'get'
    })
  },

  // 获取员工列表
  staffList() {
    return request({
      url: '/admin/acl/staff/list',
      method: 'get'
    })
  },

  // 分页获取员工列表
  pageStaffList(page, limit) {
    return request({
      url: `/admin/acl/staff/list/${page}/${limit}`,
      method: 'get'
    })
  },

  // 根据id修改员工状态
  updateStaffStatusById(id, status) {
    return request({
      url: '/admin/acl/staff/update/status',
      method: 'put',
      params: {
        'id': id,
        'status': status
      }
    })
  },
  // 获取用户已有角色
  getRolesStatusById(id) {
    return request({
      url: `/admin/acl/staff-role/${id}`,
      method: 'get'
    })
  },

  // 获取角色列表
  getRoleList() {
    return request({
      url: '/admin/acl/role/list',
      method: 'get'
    })
  },
  // 修改用户角色
  updateRole(id, roles) {
    return request({
      url: '/admin/acl/staff-role/',
      method: 'put',
      params: {
        'id': id
      },
      data: roles
    })
  }
}
