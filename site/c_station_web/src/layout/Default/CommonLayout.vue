<!--  常用布局  -->
<template>
  <div>
    <!--  头部导航栏  -->
    <Nav genre="on" roll="false"/>
    <!--  路由视图  -->
    <Router-view class="router"/>
    <!--  网站尾部  -->
    <Footer />
  </div>
</template>

<script>
import Nav from './components/nav'
import Footer from './components/footer'
export default {
  name: 'CommonLayout',
  components: {Footer, Nav}
}
</script>

<style scoped>
.router {
  margin-top: 56px;
}
</style>
