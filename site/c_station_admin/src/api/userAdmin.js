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
  /*selectUserAll(page, limit) {
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
  }
}
