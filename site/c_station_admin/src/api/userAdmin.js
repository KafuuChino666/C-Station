import request from '@/utils/request'
// 权限菜单api

export default {
// 按员工编号搜索员工
  selectUserByID(select, page, limit) {
    return request({
      url: `/views/user/components/select/${page}/${limit}`,
      method: 'get',
      params: {
        select
      }
    })
  },
  // 分页获取角色
  selectUserAll(page, limit) {
    return request({
      url: `/views/user/components/select/All`,
      method: 'get'
    })
  },
}
