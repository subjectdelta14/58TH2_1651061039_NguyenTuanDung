<template>
  <div class="col-md-12 text-center">
    <div class="card">
      <div class="card-header">
        <h5 class="card-title">Cập nhật vật liệu</h5>
      </div>
      <div class="card-body">
        <form>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right"
              >Tên Sản Phẩm</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Tên Sản Phẩm"
                v-model="nameProduct"
                v-on:keyup="messNameProduct"
              />
              <span v-if="!txtNameProduct" style="color: red; font-size: 11px"
                >Tên sản phẩm không đc để trống</span
              >
            </div>
          </div>

          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Chọn loại sản phẩm</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Tên Sản Phẩm"
                v-model="typeProduct"
                v-on:keyup="messTypeProduct"
              />
              <span v-if="!txtTypeProduct" style="color: red; font-size: 11px"
                >Loại sản phẩm không được để trống</span
              >
            </div>
          </div>

          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Giá sản phẩm
            </label>
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Gia san pham"
                v-model="priceProduct"
                v-on:keyup="messPriceProduct"
              />
              <span v-if="!txtPriceProduct" style="color: red; font-size: 11px"
                >Giá sản phẩm không đc để trống</span
              >
            </div>
          </div>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Số lượng
            </label>
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Số lượng"
                v-model="numberProduct"
                v-on:keyup="messNumbProduct"
              />
              <span v-if="!txtNumbProduct" style="color: red; font-size: 11px"
                >Số lượng không đc để trống</span
              >
            </div>
          </div>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Năm sản xuất
            </label>
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="năm"
                v-model="yearProduct"
                v-on:keyup="messYearProduct"
              />
              <span v-if="!txtYearProduct" style="color: red; font-size: 11px"
                >Năm sản xuất đc để trống</span
              >
            </div>
          </div>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Ảnh sản phẩm
            </label>
            <div class="col-sm-7">
              <img :sr="previewImage" class="uploading-image" />
              <input type="file" accept="image/jpeg" @change="uploadImage" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Mô tả sản phẩm
            </label>
            <div class="col-sm-7">
              <textarea
                class="form-control"
                placeholder="Mô tả sản phẩm"
                rows="3"
                v-model="describeProduct"
                v-on:keyup="messDescribeProduct"
              ></textarea>
              <span
                v-if="!txtDescribeProduct"
                style="color: red; font-size: 11px"
                >Mô tả sản phẩm không được để trống</span
              >
            </div>
          </div>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Công dụng sản phẩm
            </label>
            <div class="col-sm-7">
              <textarea
                class="form-control"
                placeholder="Công dụng sản phẩm"
                rows="3"
                v-model="impactProduct"
                v-on:keyup="messImpactProduct"
              ></textarea>
              <span v-if="!txtImpactProduct" style="color: red; font-size: 11px"
                >Công dụng sản phẩm không được để trống</span
              >
            </div>
          </div>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Hãng sản xuất
            </label>
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Hãng sản xuất"
                v-model="locationProduct"
                v-on:keyup="messLocationProduct"
              />
              <span
                v-if="!txtLocationProduct"
                style="color: red; font-size: 11px"
                >Hãng sản xuất không được để trống</span
              >
            </div>
          </div>
          

          <button type="button" class="btn btn-primary" v-on:click="updateProduct(id)">Chấp nhận</button>
           <button type="button" class="btn btn-primary" >Hủy</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import ApiFunction from "@/js/ApiUtils.js";
export default {
  props: ["id"],
  data: function () {
    return {
      oneProduct: [],
     nameProduct: "",

      priceProduct: "",
      numberProduct: "",
      typeProduct: "",
      yearProduct: "",
      describeProduct: "",
      imgProduct: "",
      impactProduct: "",
      locationProduct: "",

      txtNameProduct: true,
      txtTypeProduct: true,

      txtPriceProduct: true,
      txtNumbProduct: true,
    };
  },
  components: {},
  methods: {
    messNameProduct() {
      let self = this;
      if (self.nameProduct == "") {
        self.txtNameProduct = false;
      } else {
        self.txtNameProduct = true;
      }
    },

    messPriceProduct() {
      let self = this;
      if (self.descriptionProduct == "") {
        self.txtPriceProduct = false;
      } else {
        self.txtPriceProduct = true;
      }
    },
    messNumbProduct() {
      let self = this;
      if (self.numberProduct == "") {
        self.txtNumbProduct = false;
      } else {
        self.txtNumbProduct = true;
      }
    },
    messTypeProduct() {
      let self = this;
      if (self.typeProduct == "") {
        self.txtTypeProduct = false;
      } else {
        self.txtTypeProduct = true;
      }
    },
    messYearProduct() {
      let self = this;
      if (self.yearProduct == "") {
        self.txtYearProduct = false;
      } else {
        self.txtYearProduct = true;
      }
    },
    messImgProduct() {
      let self = this;
      if (self.imgProduct == "") {
        self.txtImgProduct = false;
      } else {
        self.txtImgProduct = true;
      }
    },
    messDescribeProduct() {
      let self = this;
      if (self.describeProduct == "") {
        self.txtDescribeProduct = false;
      } else {
        self.txtDescribeProduct = true;
      }
    },
    messLocationProduct() {
      let self = this;
      if (self.locationProduct == "") {
        self.txtLocationProduct = false;
      } else {
        self.txtLocationProduct = true;
      }
    },
    messImpactProduct() {
      let self = this;
      if (self.impactProduct == "") {
        self.txtImpactProduct = false;
      } else {
        self.txtImpactProduct = true;
      }
    },
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
    uploadImage(e) {
      const image = e.target.files[0];
      const reader = new FileReader();
      reader.readAsDataURL(image);
      reader.onload = (e) => {
        this.imgProduct = e.target.result;
       
        
        this.imgProduct=this.imgProduct.replace("data:image/jpeg;base64,", "");
        
        
        
      };
    },
    updateProduct(){
        let self = this;
      if (self.nameProduct == "") {
        alert("ten sp khg dc trong");
        
      } else if (self.typeProduct == "") {
        alert(" loai san pham khong dc de trong ");
      } else if (self.numberProduct == "") {
        alert("so luong sp khg dc de trong");
      } else if (self.priceProduct == "") {
        alert("gia san pham khg duoc de trong");
      } else if (self.describeProduct == "") {
        alert("mieu ta san pham khg duoc de trong");
      } else if (self.impactProduct == "") {
        alert("cong dung san pham khg duoc de trong");
      } else if (self.locationProduct == "") {
        alert("dia diem san xuat pham khg duoc de trong");
      } else if (self.yearProduct == "") {
        alert("nam san xuat san pham khg duoc de trong");
      } else if (self.imgProduct == "") {
        alert("anh san pham khg duoc de trong");
      } 
      else {
        let productModel = {
          name: self.nameProduct,
          type: self.typeProduct,
          price: self.priceProduct,
          quantity: self.numberProduct,
          describepro: self.describeProduct,
          impact: self.impactProduct,
          img: self.imgProduct,
          location: self.locationProduct,
          year: self.yearProduct,
        };
        
        ApiFunction("qlvl/"+self.id, "POST", productModel);
        
      }
    }

  },
  created() {
    this.getProduct();
  },
};
</script>
<style></style>
