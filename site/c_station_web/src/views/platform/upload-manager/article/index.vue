<template>
  <div>
    <div class="article-top">
      <ul class="article-tag">
        <li>
          <router-link :to="{name: 'UploadManager'}">
            <span>全部稿件 1</span>
          </router-link>
          <el-divider direction="vertical"></el-divider>
        </li>
        <li>
          <router-link :to="{name: 'UploadManager'}">
            <span>进行中 0</span>
          </router-link>
          <el-divider direction="vertical"></el-divider>
        </li>
        <li>
          <router-link :to="{name: 'UploadManager'}">
            <span>已通过 1</span>
          </router-link>
          <el-divider direction="vertical"></el-divider>
        </li>
        <li>
          <router-link :to="{name: 'UploadManager'}">
            <span>未通过 0</span>
          </router-link>
        </li>
      </ul>
    </div>
    <articleList />
  </div>
</template>

<script>
import articleList from './list'

export default {
  name: 'article-index',
  components: {articleList}
}
</script>

<style scoped>
.article-top {
  height: 40px;
  width: 100%;
}
.article-tag {
  /*text-align: center;*/
  line-height: 32px;
  font-size: 14px;
}

.article-tag li{
  /*width: 100px;*/
  height: 32px;
  float: left;
  list-style-type: none;
}

.article-tag a:link {
  color: #505050;
}
.article-tag a:visited {
  color: #505050;
}
.article-tag a:hover {
  color: #00a1d6;
}

</style>
