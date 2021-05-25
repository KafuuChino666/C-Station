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
    ],
    tags: [
      {
        type: 'array',
        required: true,
        message: '请选择视频标签',
        trigger: 'blur'
      },
      {
        min: 1,
        max: 10,
        message: '范围在1~10个标签',
        trigger: 'blur'
      }
    ],
    videoBrief: [
      {
        required: true,
        message: '请填写视频简介',
        trigger: 'blur'
      },
      {
        max: 200,
        message: '最多200个字符',
        trigger: 'blur'
      }
    ]
  }

}
