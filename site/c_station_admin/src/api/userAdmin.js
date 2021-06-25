import request from '@/utils/request'

export default {
// 按员工编号搜索员工
  selectUserBySelect(select, page, limit) {
    return request({
      url: `/views/user/components/select/${page}/${limit}`,
      method: 'post',
      data: select
    })
  },
  // 分页获取角色
  /* selectUserAll(page, limit) {
    return request({
      url: `/views/user/components/${page}/${limit}`,
      method: 'get'
    })
  },*/
  // 查询所有状态
  selectAllCategory() {
    return request({
      url: `/views/category/vip`,
      method: 'get'
    })
  },

  // 根据用户id查询状态id
  selectCategoryById(id) {
    return request({
      url: `/views/category/select/categoryId/${id}`,
      method: 'get'
    })
  },

  selectAllGender() {
    return request({
      url: `/views/gender/sex`,
      method: 'get'
    })
  },

  // 删除用户
  deleteUserById(id) {
    return request({
      url: `/views/category/remove/${id}`,
      method: 'put'
    })
  },

  unDeleteUserById(id) {
    return request({
      url: `/views/category/unRemove/${id}`,
      method: 'put'
    })
  },

  // 查询用户违规记录
  selectUserViolationByID(id) {
    return request({
      url: `/views/violation/marker/${id}`,
      method: 'get'
    })
  },

  // 回显要编辑的用户数据
  showEditUserById(id) {
    return request({
      url: `/views/user/show/${id}`,
      method: 'put'
    })
  },

  // 编辑用户
  updateUserById(id) {
    return request({
      url: `/views/user/update/${id}`,
      method: 'put'
    })
  }

}
