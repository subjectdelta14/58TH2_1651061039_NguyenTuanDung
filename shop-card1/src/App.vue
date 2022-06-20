<template>
  <div id="nav">
  <Header/>
   <TopNav/>
    <router-view/>
  
 <Footer/>
    

  </div>
 
</template>
<script>
import Header from "@/components/Header.vue";
import TopNav from "@/components/TopNav.vue";
import Footer from "@/components/Footer.vue";
export default {
  name: 'App',
  data() {
    return {
        
    }
  },
  components: {
       Header,
  TopNav,
    Footer
  }
}
</script>
<style >
#app {
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  width: 100%;
}

</style>
