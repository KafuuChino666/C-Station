<template>
  <div>
    <div id="header">
      <!--  头部导航栏  -->
      <nav />
      <!--  头部底层  -->
      <header />
    </div>
    <!--  连接导航  -->
    <link-nav />

  </div>
</template>

<script>
import Nav from './components/nav'
import Header from './components/header'
import LinkNav from './components/link-nav'
export default {
  name: 'MainLayout',
  components: {LinkNav, Header, Nav}
}
</script>

<style scoped>

</style>
