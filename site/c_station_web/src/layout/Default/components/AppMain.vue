<!-- 中间内容 -->
<template>
  <div>
    <div class="main-container">
      <Promotion />
    </div>
  </div>
</template>

<script>
import Promotion from '../../../components/Promotion'

export default {
  name: 'AppMain',
  components: {
    Promotion
  },
  created () {
    this.getWidth()
  },
  methods: {
    getWidth () {
      let w = document.documentElement.offsetWidth || document.body.offsetWidth
      console.log(w)
    }
  }
}
</script>

<style scoped>
.main-container {
  width: 1200px;
}
</style>
