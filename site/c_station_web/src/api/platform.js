import request from '@/utils/request'

export default {
  // 获取上传地址和凭证
  getUploadAuth (uuid) {
    return request({
      url: `/api/video/media/get-upload-auth/${uuid}`,
      method: 'get'
    })
  }
}
