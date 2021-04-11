<template>
  <div class="pater-container">
    <SearchBox :search-fun="searchFun" title="资源列表" label-text="输入API/资源名称" :add-fun="addFun" icon="el-icon-attract" />
    <div class="low-container">
      <!--   表   -->
      <ResourceTable :list="list" />
      <div class="block" v-if="list.length > limit">
        <el-pagination
          layout="prev, pager, next"
          :current-page="page"
          :total="total"
          :page-size="limit"
          @current-change="changeCurrentPage"
        />
      </div>
    </div>
    <ResourceForm />
  </div>
</template>

<script>
import SearchBox from '@/views/security/components/SearchBox'
import ResourceTable from '@/views/security/components/ResourceTable'
import ResourceForm from '@/views/security/components/ResourceForm'
import securityAPI from '@/api/securityAPI'
import PubSub from 'pubsub-js'

export default {
  name: 'Resource',
  components: {
    SearchBox,
    ResourceTable,
    ResourceForm
  },
  data() {
    return {
      page: 1,
      limit: 7,
      list: [],
      total: 0
    }
  },
  // 页面渲染成功后获取数据
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      // 请求数据
      securityAPI.pageResourceList(this.page, this.limit).then(response => {
        this.list = response.data.rows
        this.total = response.data.total
      })
    },
    searchFun(text) {
      if (text !== '') {
        // 请求数据
        securityAPI.getResourceByText(text).then(response => {
          this.list = []
          this.total = 0
          this.list = response.data.rows
        })
      }
    },
    changeCurrentPage(page) {
      this.page = page
      this.fetchData()
    },
    addFun() {
      // 打开弹窗表单
      PubSub.publish('resourceForm', {
        'row': {},
        formType: 0
      })
    }
  }
}
</script>

<style scoped>
.pater-container{
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
  padding: 30px;
}

.low-container {
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  width: 100%;
  padding: 20px;
  margin-top: 30px;
}
.block {
  width: 300px;
  margin-right: auto;
  margin-left: auto;
  margin-top: 10px;
}
</style>
