<template>
  <div class="navbar"></div>
</template>

<script>
export default {
  name: 'Navbar',
  data () {
    return {
      activeIndex: '1',
      activeIndex2: '1'
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style scoped>
.navbar {
  width: 100%;
  height: 100%;
  background: #fff;
  box-shadow: 0 2px 4px 0 rgb(0 0 0 / 8%);
}
</style>
