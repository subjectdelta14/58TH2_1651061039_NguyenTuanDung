<template>

        <div class="row">

  <div class="card" v-for="data in listNews" v-bind:key="data.id" >
  <div class="column"  >
    
      <div>
       
      
      <img :src="'data:image/jpeg;base64,'+data.img"  style="width:100%"/>
      <p ><a :href="data.linknews">{{data.desnews}}</a> 
      </p>
      
      
      
      </div>
    </div>
  </div>
  
  </div>
</template>

<script>
import ApiFunction from "@/js/ApiUtils.js";
export default {
  name: 'BlogItem',
 data() {
    return {
      listNews: []
    }
  },
  methods: {
   async getAllNews() {
      console.log(this.listNews);
      this.listNews = await ApiFunction("qlvl/news/get/", "GET", null);
    },
  },
  created() {
    this.getAllNews();
  },
  
}
</script>

<style scoped>
* {
  box-sizing: border-box;
}



/* Float four columns side by side */
.column {
  float: left;
  width: 25%;
  padding: 0 10px;
}

/* Remove extra left and right margins, due to padding */
.row {margin: 0 -5px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}

.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}
</style>
