export default {

  videoContributeForm: {
    videoTitle: [
      {
        required: true,
        message: '请输入视频标题',
        trigger: 'blur'
      },
      {
        min: 3,
        max: 20,
        message: '长度在3~20字符',
        trigger: 'blur'
      }
    ],
    zoneId: [
      {
        required: true,
        message: '请选择视频分区',
        trigger: 'blur'
      }
    ]
  }

}
