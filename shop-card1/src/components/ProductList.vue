<template>
<div class="row">

  <div class="card" v-for="data in list" v-bind:key="data.id" >
  <div class="column"  >
    
      <div>
       
      
       <img :src="'data:image/jpeg;base64,'+data.img"  style="width:100px"/>
      <p><router-link :to="{ name: 'DetailsProduct', 
           params: { id : data.id }}"> {{ data.name }}</router-link></p>
      <p>{{data.price}} VND</p>
      <p><button>Add to Cart</button></p>
      </div>
    </div>
  </div>
  
  </div>

</template>

<script>
import ApiFunction from "@/js/ApiUtils.js";
export default {
  name: "ProductList",
  data() {
    return {
      list: []
    }
  },
  components: {
   
  },
 
  methods: {
   async getAllProduct() {
      console.log(this.list);
      this.list = await ApiFunction("qlvl/", "GET", null);
    },
     
  },

  created() {
    this.getAllProduct();
  },
  
};
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
