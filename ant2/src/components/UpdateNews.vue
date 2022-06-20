<template>
  <div class="col-md-12 text-center">
    <div class="card">
      <div class="card-header">
        <h5 class="card-title">Cập nhật tin mới</h5>
      </div>
      <div class="card-body">
        <form>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right"
              >Miêu tả tin tức</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Miêu tả tin tức"
                v-model="describe"
                v-on:keyup="messDescribe"
              />
              <span v-if="!txtDescribe" style="color: red; font-size: 11px"
                >Miêu tả tin tức không được để trống</span
              >
            </div>
          </div>

          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Link tin tức</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Link tin tức"
                v-model="link"
                v-on:keyup="messLink"
              />
              <span v-if="!txtLink" style="color: red; font-size: 11px"
                >Link tin tức không được để trống</span
              >
            </div>
          </div>

          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Ảnh sản phẩm
            </label>
            <div class="col-sm-7">
              <input type="file" accept="image/jpeg" @change="uploadImage" />
            </div>
          </div>
         
         

          <button
            type="button"
            class="btn btn-primary"
            v-on:click="createProduct"
          >
            Submit
          </button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import ApiFunction from "@/js/ApiUtils.js";
export default {
    props:["id"],
  data: function () {
    return {
      describe: "",

      link: "",
     img:"",

      txtDescribe: true,
      txtLink:true,

     
    };
  },
  components: {},
  methods: {
    messDescribe() {
      let self = this;
      if (self.describe == "") {
        self.txtDescribe = false;
      } else {
        self.txtDescribe = true;
      }
    },

    messLink() {
      let self = this;
      if (self.link == "") {
        self.txtLink = false;
      } else {
        self.txtLink = true;
      }
    },
    async getProduct() {
      this.oneProduct = await ApiFunction("qlvl/news/get/" + this.id, "GET", null);
      this.describe = this.oneProduct.desnews;
      this.link = this.oneProduct.linknews;
      this.img = this.oneProduct.img;
      
    },
    uploadImage(e) {
      const image = e.target.files[0];
      const reader = new FileReader();
      reader.readAsDataURL(image);
      reader.onload = (e) => {
        this.img = e.target.result;
       
        
        this.img=this.img.replace("data:image/jpeg;base64,", "");
        
        
        
      };
    },
    createProduct() {
      let self = this;
      if (self.describe == "") {
        alert("Miêu tả tin tức không được để trống");
      } else if (self.link == "") {
        alert(" Link tin tức không được để trống ");
      } else if (self.img == "") {
        alert(" Ảnh tin tức không được để trống ");}
         else {
        let newsModel = {
          
         desnews : self.describe,
         linknews:self.link,
         img:self.img
         


        };
        
        ApiFunction("qlvl/news/", "POST", newsModel);
        
      }
    },
  },
  created() {
   this.getProduct()
  },
};
</script>
<style></style>
