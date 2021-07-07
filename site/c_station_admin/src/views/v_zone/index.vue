<template>
  <div class="app-main">
    <div class="con-flex">
      <div class="cont-left">
        
      </div>
      <div class="cont-right">right</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Zone'
}
</script>

<style scoped>
.con-flex {
  display: flex;
  align-items: stretch;
  background-color: #f1f1f1;
}
.cont-left {
  background-color: DodgerBlue;
  margin-right: 20px;
  flex-shrink: 0;
  width: 400px;
}
.cont-right {
  width: 100%;
  min-width: 800px;
  background-color: DodgerBlue;
}
</style>
