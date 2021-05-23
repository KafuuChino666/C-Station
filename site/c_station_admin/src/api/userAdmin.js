import request from '@/utils/request'
// 权限菜单api

export default {
// 按员工编号搜索员工
  selectUserByID(select) {
    return request({
      url: `/views/user/components/select/${page}/${limit}`,
      method: 'get',
      params: {
        select
      }
    })
  },
}
