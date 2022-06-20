<template>
    <div class="container">
        <div class="row pt-5">
            <div class="col-md-1"></div>
            <img />
            <div class="col-md-4 col-12">
                <img :src="'data:image/jpeg;base64,'+this.imgProduct"  style="width:30%">
            </div>
            <!--            display product details-->
            <div class="col-md-6 col-12 pt-3 pt-md-0">
                <h4>{{this.nameProduct}}</h4>
                <h6 class="catgory font-italic">{{this.priceProduct}} VND</h6>
                
                <p>
                    
                </p>
                <div class="features pt-3">
                    <h5><strong>Mô tả</strong></h5>
                    <ul>
                        <li>Năm sản xuất: {{this.yearProduct}} </li>
                        <li>Miêu tả:{{this.describeProduct}}</li>
                        <li>Nơi sản xuất: {{this.locationProduct}}</li>
                        <li>Loại sản phẩm: {{this.typeProduct}}</li>
                        <li>Công dụng sản phẩm: {{impactProduct}}</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import ApiFunction from '../js/ApiUtils';
    export default {
        data() {
            return {
                oneProduct:[],
                nameProduct: "",

      priceProduct: "",
      numberProduct: "",
      typeProduct: "",
      yearProduct: "",
      describeProduct: "",
      imgProduct: "",
      impactProduct: "",
      locationProduct: "",
            }
        },
        props: ["id"],
        methods:{
            async getProduct() {
      this.oneProduct = await ApiFunction("qlvl/" + this.id, "GET", null);
      this.nameProduct = this.oneProduct.name;
      this.typeProduct = this.oneProduct.type;
      this.priceProduct = this.oneProduct.price;
      this.numberProduct = this.oneProduct.quantity;
      this.yearProduct = this.oneProduct.year;
      this.describeProduct=this.oneProduct.describepro;
      this.locationProduct=this.oneProduct.location;
      this.imgProduct=this.oneProduct.img;
      this.impactProduct=this.oneProduct.impact;
    },

        },
        mounted() {
           
        },
        created(){
            this.getProduct()
        }
    }
</script>
<style>
    .category {
        font-weight: 400;
    }
</style>
