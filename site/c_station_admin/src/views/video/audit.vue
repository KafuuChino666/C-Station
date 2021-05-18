<template>
  <div>
    <div class="audit-title">
      <ul>
        <li>审核员ID: 5655255</li>
        <li>审核内容: 政治</li>
        <li>审核通道状态: 流畅</li>
        <li>今日审核数: 56</li>
      </ul>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'Audit'
}
</script>

<style scoped>
.audit-title {
  width: 100%;
  background: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  height: 30px;
}

.audit-title li {
  list-style:none;
  float:left;
  padding:0;
  margin:0;
}
</style>
