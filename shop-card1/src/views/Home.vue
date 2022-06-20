<template>
  <div class="home">
   
    <ProductList/>
   
    
  </div>
  
</template>

<script>
// @ is an alias to /src
// import Header from "@/components/Header.vue";
// import TopNav from "@/components/TopNav.vue";
// import Footer from "@/components/Footer.vue";
import ProductList from "@/components/ProductList.vue";

export default {
  name: "Home",
  components: {
  //   Header,
  // TopNav,
  //   Footer
  ProductList
  },
};
</script>
<style scoped>
</style>
