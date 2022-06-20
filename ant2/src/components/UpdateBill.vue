<template>
  <div class="col-md-12 text-center">
    <div class="card">
      <div class="card-header">
        <h5 class="card-title">Cập nhật hóa đơn </h5>
      </div>
      <div class="card-body">
        <form>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right"
              >Tên hóa đơn</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Tên hóa đơn"
                v-model="name"
                v-on:keyup="messName"
              />
              <span v-if="!txtname" style="color: red; font-size: 11px"
                >Tên hóa đơn không được để trống</span
              >
            </div>
          </div>

          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Số lượng</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Số lượng"
                v-model="quantity"
                v-on:keyup="messQuantity"
              />
              <span v-if="!txtquantity" style="color: red; font-size: 11px"
                >Số lượng không được để trống</span
              >
            </div>
          </div>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Giá</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Giá"
                v-model="price"
                v-on:keyup="messPrice"
              />
              <span v-if="!txtprice" style="color: red; font-size: 11px"
                >Giá không được để trống</span
              >
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
      name: "",
      quantity: "",
      price: "",
    


      txtname: true,
      txtquantity: true,
      txtprice: true,
      
    };
  },
  components: {},
  methods: {
    messName() {
      let self = this;
      if (self.name == "") {
        self.txtname = false;
      } else {
        self.txtname = true;
      }
    },

    messQuantity() {
      let self = this;
      if (self.quantity == "") {
        self.txtquantity = false;
      } else {
        self.txtquantity = true;
      }
    },
    messPrice() {
      let self = this;
      if (self.price == "") {
        self.txtprice = false;
      } else {
        self.txtprice = true;
      }
    },
    async getProduct() {
      this.oneProduct = await ApiFunction("qlvl/bill/get/" + this.id, "GET", null);
      this.name = this.oneProduct.name;
      this.quantity = this.oneProduct.quantity;
      this.price = this.oneProduct.price;
      
      
    },
    createProduct() {
      let self = this;
      if (self.name == "") {
        alert("Tên hóa đơn  không được để trống");
      } else if (self.quantity == "") {
        alert(" Số lượng đơn hàng được để trống ");
      } else if (self.price == "") {
        alert(" Giá đơn hàng  không được để trống ");
      }
      else {
        let newsModel = {
          name: self.name,
          quantity: self.quantity,
          price: self.price,
         
        };

        ApiFunction("qlvl/bills/update/"+this.id, "POST", newsModel);
      }
    },
  },
  created() {
    this.getProduct()
  },
};
</script>
<style></style>
