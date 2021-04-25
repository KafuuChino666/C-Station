<template>
  <div class="top-container">
    <div class="text-con">
      <span style="font-size: 18px"><i :class="icon" />{{ title }}</span>
    </div>
    <div class="search-con">
      {{ labelText }}:<el-input v-model="searchText" placeholder="请输入内容" />
      <el-button type="info" plain @click="searchText = ''"> 清空 </el-button>
      <el-button type="primary" @click="searchFun(searchText)">查询</el-button>
      <el-button type="success" icon="el-icon-plus" @click="addFun">添加</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SearchBox',
  props: {
    // eslint-disable-next-line vue/require-default-prop
    searchFun: Function,
    title: {
      type: String,
      required: false,
      default: '搜索'
    },
    icon: {
      type: String,
      required: false,
      default: 'el-icon-arrow-right'
    },
    labelText: {
      type: String,
      required: false,
      default: '请输入内容搜索'
    },
    addFun: {
      type: Function,
      required: false,
      default: function() {}
    }
  },
  data() {
    return {
      searchText: ''
    }
  }
}
</script>

<style scoped>

.top-container {
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  width: 100%;
  height: 150px;
  padding: 20px;
}
.text-con {
  width: 100%;
  height: 40px;
}
.text-con i {
  margin-right: 5px;
}
.el-icon-search {
  font-size: 16px;
  margin-right: 5px;
}
.search-con {
  width: 100%;
  height: 35px;
  font-weight: 400;
  padding-left: 60px;
}
.el-input {
  width: 180px;
  margin-left: 15px;
  margin-right: 15px;
}
.el-button {
  width: 100px;
}
</style>
