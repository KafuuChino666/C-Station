import request from '@/utils/request'

export default {
  // 查询个人收藏分区
  selectCollectZone(id) {
    return request({
      url: `/views/user/components/selectCollectZone/${id}`,
      method: 'post',
    })
  },
  selectCollectNumber() {
    return request({
      url: `/views/user/components/selectNumber`,
      method: 'post',
    })
  },
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
  selectCategoryIDById(id) {
    return request({
      url: `/views/category/select/categoryId/${id}`,
      method: 'get'
    })
  },

  // 根据用户id查询状态
  selectCategoryByID(id) {
    return request({
      url: `/views/category/select/category/${id}`,
      method: 'get'
    })
  },

  // 查询所有性别类型
  selectAllGender() {
    return request({
      url: `/views/gender/sex`,
      method: 'get'
    })
  },

  selectGenderIDById(id) {
    return request({
      url: `/views/gender/select/sexID/${id}`,
      method: 'get'
    })
  },

  // 根据用户id查询性别
  selectGenderByID(id) {
    return request({
      url: `/views/gender/select/sex/${id}`,
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

  // 取消封禁
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
      method: 'get'
    })
  },

  // 编辑用户
  updateUserById(editUserData, id) {
    return request({
      url: `/views/user/update/${id}`,
      method: 'put',
      data: editUserData
    })
  }

}
