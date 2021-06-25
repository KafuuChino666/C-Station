<template>
  <div>
    <Header id="header" />
    <Nav />
    <Promotion />
  </div>
</template>

<script>
import Header from './components/header'
import Nav from './components/nav'
import Promotion from './components/promotion'
export default {
  name: 'DefaultLayout',
  components: {Nav, Header, Promotion}
}
</script>

<style scoped>
#header{
  background: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/385745243b5ce243f156a43676415584e3dd5c74.png') no-repeat;
  background-size: 100% 100%;
}
</style>
