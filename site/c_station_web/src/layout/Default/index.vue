<template>
  <div>
    <!--  公共头  -->
    <Header id="header" />
    <Nav />
    <Promotion />
    <Recommend />
    <!--  广告组件  -->
    <Advertising />
    <Column />
    <Advertising />
    <Footer />
    <RightNav />
  </div>
</template>

<script>
import Header from './components/header'
import Nav from './components/nav'
import Promotion from './components/promotion'
import Advertising from './components/advertising'
import Recommend from './components/recommend'
import Column from './components/column'
import Footer from './components/footer'
import RightNav from './components/right-nav'
export default {
  name: 'DefaultLayout',
  components: {RightNav, Footer, Column, Recommend, Advertising, Nav, Header, Promotion}
}
</script>

<style scoped>
#header{
  background: url('https://mcsql-002.oss-cn-beijing.aliyuncs.com/web/385745243b5ce243f156a43676415584e3dd5c74.png') no-repeat;
  background-size: 100% 100%;
}
</style>
