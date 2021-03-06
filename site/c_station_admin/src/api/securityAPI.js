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
  // 分页获取Menu
  pageMenuList(page, limit) {
    return request({
      url: `/admin/acl/menu/list/${page}/${limit}`,
      method: 'get'
    })
  },
  // 修改菜单隐藏状态
  updateMenuStatus(id, status) {
    return request({
      url: '/admin/acl/menu/hidden/',
      method: 'put',
      params: {
        id,
        status
      }
    })
  },
  // 根据Menu id获取Roles
  getRolesMenuById(id) {
    return request({
      url: `/admin/acl/role_menu/${id}/`,
      method: 'get'
    })
  },
  // 修改菜单角色
  updataMenuRole(id, roles, batch) {
    return request({
      url: '/admin/acl/role_menu/',
      method: 'put',
      data: roles,
      params: {
        id,
        batch
      }
    })
  },
  // 获取菜单列表
  getMrnuList() {
    return request({
      url: `/admin/acl/menu/`,
      method: 'get'
    })
  },
  // 添加菜单
  addMrnu(menu) {
    return request({
      url: '/admin/acl/menu/',
      method: 'post',
      data: menu
    })
  },
  // 更新菜单
  updateMenuById(menu) {
    return request({
      url: '/admin/acl/menu/',
      method: 'put',
      data: menu
    })
  },
  // 根据id删除菜单
  reomveMenuById(id) {
    return request({
      url: '/admin/acl/menu/',
      method: 'delete',
      data: id
    })
  },
  // 根据名称搜索菜单
  getMenuByName(name) {
    return request({
      url: `/admin/acl/menu/seek/${name}`,
      method: 'get'
    })
  },
  // 分页获取角色
  pageRoleList(page, limit) {
    return request({
      url: `/admin/acl/role/list/${page}/${limit}`,
      method: 'get'
    })
  },
  // 根据角色名称查询角色
  getRoleByName(name) {
    return request({
      url: `/admin/acl/role/search/${name}`,
      method: 'get'
    })
  },
  // 获取层级菜单结构
  getHierarchyMenu() {
    return request({
      url: `/admin/acl/menu/hierarchy`,
      method: 'get'
    })
  },
  // 根据id获取角色
  getMenuById(id) {
    return request({
      url: `/admin/acl/role/${id}`,
      method: 'get'
    })
  },
  // 根据ID更新角色
  updateRoleById(role) {
    return request({
      url: '/admin/acl/role/',
      method: 'put',
      data: role
    })
  },
  // 根据角色ID获取菜单
  getMenuByRoleId(role_id) {
    return request({
      url: `/admin/acl/role_menu/menu/${role_id}`,
      method: 'get'
    })
  },
  // 根据角色ID更新菜单
  updateMenuByRoleId(roleId, menus) {
    return request({
      url: '/admin/acl/role_menu/role',
      method: 'put',
      params: {
        roleId
      },
      data: menus
    })
  },
  getResourceList() {
    return request({
      url: `/admin/acl/resource/`,
      method: 'get'
    })
  },
  // 更新角色资源
  updateRoleResourceByRoleId(roleId, resources) {
    return request({
      url: `/admin/acl/role-resource/${roleId}`,
      method: 'put',
      data: resources
    })
  },
  // 根据角色Id获取资源列表
  getResourceByRoleId(roleId) {
    return request({
      url: `/admin/acl/role-resource/resource/${roleId}`,
      method: 'get'
    })
  },
  // 根据角色id删除角色
  removeRoleById(id) {
    return request({
      url: '/admin/acl/role/',
      method: 'delete',
      data: id
    })
  },
  // 添加角色
  addRole(addRoleForm) {
    return request({
      url: '/admin/acl/role/',
      method: 'post',
      data: addRoleForm
    })
  },
  updateRoleStatusById(id, status) {
    return request({
      url: '/admin/acl/role/status',
      method: 'put',
      params: {
        id,
        status
      }
    })
  },
  getMenuByParentId(id) {
    return request({
      url: `/admin/acl/menu/parent_id/${id}`,
      method: 'get'
    })
  },
  // 添加用户
  addStaff(staff) {
    return request({
      url: '/admin/acl/staff/',
      method: 'put',
      data: staff
    })
  },
  // 验证用户名
  validateUserName(value) {
    return request({
      url: `/admin/acl/staff/validate/${value}`,
      method: 'get'
    })
  },
  staffBindRoles(id, roles) {
    return request({
      url: '/admin/acl/staff-role/bind',
      method: 'put',
      params: {
        id
      },
      data: roles
    })
  },
  staffCancelRoles(id, roles) {
    return request({
      url: '/admin/acl/staff-role/cancel',
      method: 'delete',
      params: {
        id
      },
      data: roles
    })
  },

  // 根据id删除角色
  removeStaffById(id) {
    return request({
      url: '/admin/acl/staff/',
      method: 'delete',
      data: id
    })
  },
  // 回显数据
  getEchoData(staffId) {
    return request({
      url: `/admin/acl/staff/echo-data/${staffId}`,
      method: 'get'
    })
  },
  getStaffAuthInfo() {
    return request({
      url: `/admin/acl/staff/auth/info/`,
      method: 'get'
    })
  },
  sendAuthCode(authType) {
    return request({
      url: `/admin/acl/staff/auth/code/${authType}`,
      method: 'get'
    })
  }
}
