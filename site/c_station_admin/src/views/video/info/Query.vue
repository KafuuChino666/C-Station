<template>
  <div class="pater-container">
    <div class="top-container">
      <el-form :inline="true" :model="queryForm" class="demo-form-inline">
        <el-col :span="24">
          <el-form-item label="视频id：">
            <el-input v-model="queryForm.videoId"></el-input>
          </el-form-item>
          <el-form-item label="视频标题：">
            <el-input v-model="queryForm.videoTitle"></el-input>
          </el-form-item>
          <el-form-item label="uuid：">
            <el-input v-model="queryForm.authorId"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="发布时间：">
            <el-date-picker
              v-model="queryForm.date"
              type="daterange"
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            >
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-col :span="15">
            <el-form-item label="播放量：">
              <el-input v-model="queryForm.playNub"></el-input>
            </el-form-item>
            <el-form-item label="视频状态：">
              <el-select v-model="queryForm.videoStatus" placeholder="请选择">
                <el-option
                  v-for="item in videoStatus"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" @click="query(1,5)">查询</el-button>
          </el-form-item>
        </el-col>
      </el-form>
    </div>
    <div class="low-container" v-if="tableData.length !== 0">
      <el-table
        :data="tableData"
        style="width: 100%"
      >
        <el-table-column
          prop="imgLocation"
          label="音/视频"
          width="180"
        >
          <template slot-scope="scope">
            <el-image
              style="width: 120px; height: 68px"
              :src="scope.row.imgLocation"
              :fit="fit"
            />
          </template>
        </el-table-column>
        <el-table-column
          prop="videoTitle"
          label="视频标题"
        >
        </el-table-column>
        <el-table-column
          prop="authorId"
          label="作者id"
        >
        </el-table-column>
        <el-table-column
          prop="zoneType"
          label="分类"
          width="180"
        >
        </el-table-column>
        <el-table-column
          prop="playNub"
          label="播放量"
        >
        </el-table-column>
        <el-table-column
          prop="videoStatus"
          label="状态"
        >
        </el-table-column>
        <el-table-column
          label="操作"
        >
          <template slot-scope="scope">
            <el-button type="text" size="small" @click="info(scope.row)">详细</el-button>
            <el-button type="text" size="small" @click="banned(scope.row)">封禁</el-button>
            <el-button type="text" size="small" @click="coldTreatment(scope.row)">冷处理</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import video from '@/api/video'

export default {
  name: 'Query',
  data() {
    return {
      queryForm: {
        videoId: '', // 视频id
        videoTitle: '', // 视频标题
        authorId: '', // uuid
        date: '', // 时间区间
        playNub: -1, // 播放量
        videoStatus: 1 // 视频状态
      },
      videoStatus: {},
      tableData: [] // 表格数据
    }
  },
  // 页面渲染成功后获取数据
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.query(1, 5)
      // 加载数据
      video.selectAllVideoStatus().then(res => {
        console.log(res.data)
        this.videoStatus = res.data.rows
      }).then(error => {
        console.log(error)
      })
    },
    query(page, limit) {
      // 表单校验
      // 请求查询api
      video.selectVideoByTerm(this.queryForm, page, limit).then(res => {
        console.log(res.data)
        this.tableData = res.data.rows
      }).then(error => {
        console.log(error)
      })
    },
    // 操作相关方法
    info(row) {
      // 跳转 ,this.$route.query.id
      // this.$router.push({ name: 'VideoInfo', query: { id: row.videoId }})
      this.$router.push({ name: 'VideoInfo', query: { id: 1 }})
    },
    banned(row) {
      // 封禁视频
    },
    coldTreatment(row) {
      // 冷处理
    }
  }
}
</script>

<style scoped>
.pater-container {
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
}

.top-container {
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  width: 100%;
  height: 230px;
  padding: 20px;
}

.el-form-item {
  margin-left: 30px;
  margin-bottom: 20px;
}

.low-container {
  width: 100%;
  padding: 20px;
  margin-top: 30px;
}
</style>
