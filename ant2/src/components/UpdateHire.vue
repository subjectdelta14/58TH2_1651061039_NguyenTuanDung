<template>
  <div class="col-md-12 text-center">
    <div class="card">
      <div class="card-header">
        <h5 class="card-title">Cập nhật tuyển dụng</h5>
      </div>
      <div class="card-body">
        <form>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right"
              >Tên tuyển dụng</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Tên tuyển dụng"
                v-model="nameHire"
                v-on:keyup="messNameHire"
              />
              <span v-if="!txtnameHire" style="color: red; font-size: 11px"
                >Tên tuyển dụng không được để trống</span
              >
            </div>
          </div>

          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Email</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Email"
                v-model="emailHire"
                v-on:keyup="messEmailHire"
              />
              <span v-if="!txtemailHire" style="color: red; font-size: 11px"
                >Email không được để trống</span
              >
            </div>
          </div>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Vị trí</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Vị trí"
                v-model="positionHire"
                v-on:keyup="messpositionHire"
              />
              <span v-if="!txtpositionHire" style="color: red; font-size: 11px"
                >Vị trí không được để trống</span
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
      nameHire: "",
      emailHire: "",
      positionHire: "",

      txtnameHire: true,
      txtemailHire: true,
      txtpositionHire: true,
    };
  },
  components: {},
  methods: {
    messNameHire() {
      let self = this;
      if (self.nameHire == "") {
        self.txtnameHire = false;
      } else {
        self.txtnameHire = true;
      }
    },

    messEmailHire() {
      let self = this;
      if (self.emailHire == "") {
        self.txtemailHire = false;
      } else {
        self.txtemailHire = true;
      }
    },
    messpositionHire() {
      let self = this;
      if (self.positionHire == "") {
        self.txtpositionHire = false;
      } else {
        self.txtpositionHire = true;
      }
    },
    async getProduct() {
      this.oneProduct = await ApiFunction("qlvl/hire/get/" + this.id, "GET", null);
      this.nameHire = this.oneProduct.name;
      this.emailHire = this.oneProduct.email;
      this.positionHire = this.oneProduct.position;
      
    },
    createProduct() {
      let self = this;
      if (self.nameHire == "") {
        alert("Tên đăng nhâp  không được để trống");
      } else if (self.emailHire == "") {
        alert(" Mật khẩu không được để trống ");
      } else if (self.positionHire == "") {
        alert(" Chức năng không được để trống ");
      } else {
        let newsModel = {
          name: self.nameHire,
          email: self.emailHire,
          position: self.positionHire,
        };

        ApiFunction("qlvl/hire/update/"+this.id, "POST", newsModel);
      }
    },
  },
  created() {
    this.getProduct()
  },
};
</script>
<style></style>
