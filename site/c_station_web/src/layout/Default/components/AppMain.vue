<!-- 中间内容 -->
<template>
  <div>
    <Menu />
    <div class="main-container">
      <Promotion />
    </div>
  </div>
</template>

<script>
import Promotion from '../../../views/home/Promotion'
import Menu from '../../../views/home/Menu'

export default {
  name: 'AppMain',
  components: {
    Promotion,
    Menu
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
