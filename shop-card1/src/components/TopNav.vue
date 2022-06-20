<template>
  <div class="topnav">
  <router-link to="/ProductList"><a >Sản phẩm</a></router-link>
   <router-link to="/News"><a >Tin tức</a></router-link>
   <router-link to="/Contact"><a >Tuyển dụng và liên hệ</a></router-link>
  
  <router-link to="/Introduce"><a >Giới thiệu</a></router-link>
 
 
</div>
      
    
    
</template>

<script>


export default {
  name: "TopNav",
  data() {
    return {
     
      
    };
  },
  computed: {
    
  }
  ,
  watch: {
    
  },
};
</script>

<style scoped>
.topnav {
  overflow: hidden;
  background-color: #333;
}

/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
</style>
