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
  },

  /**
   * 资源相关API
   */
  // 删除资源
  removeResourceById(id) {
    return request({
      url: '/admin/acl/resource/',
      method: 'delete',
      data: id
    })
  },
  // 更新资源
  updateResource(resource) {
    return request({
      url: '/admin/acl/resource/',
      method: 'put',
      data: resource
    })
  },
  // 分页获取url资源数据
  pageResourceList(page, limit) {
    return request({
      url: `/admin/acl/resource/list/${page}/${limit}`,
      method: 'get'
    })
  },
  // 根据资源id/资源名称获取
  getResourceByText(text) {
    return request({
      url: `/admin/acl/resource/${text}`,
      method: 'get'
    })
  },
  // 添加资源
  addResource(resource) {
    return request({
      url: '/admin/acl/resource/',
      method: 'post',
      data: resource
    })
  },

  /**
   * 菜单列表相关API
   */
  // 修改菜单隐藏状态
  updateMenuStatus(id, status) {
    return request({
      url: '/admin/acl/menu/',
      method: 'put',
      params: {
        'id': id,
        'status': status
      }
    })
  },
  // 根据Menu id获取Roles
  getRolesMenuById(id) {
    return request({
      url: `/admin/acl/role_menu/${id}/`,
      method: 'get'
    })
  }
}
