<template>
  <div class="home">
    <NavbarSide />
    
 
    <HelloWorld />
   
    <Footer />
  </div>
  
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";
import NavbarSide from "@/components/NavbarSide.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "Home",
  components: {
    HelloWorld,
    NavbarSide,
    Footer,
  },
};
</script>
<style></style>
