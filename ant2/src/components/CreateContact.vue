<template>
  <div class="col-md-12 text-center">
    <div class="card">
      <div class="card-header">
        <h5 class="card-title">Tạo liên hệ</h5>
      </div>
      <div class="card-body">
        <form>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right"
              >Tên liên hệ</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Tên liên hệ"
                v-model="name"
                v-on:keyup="messName"
              />
              <span v-if="!txtname" style="color: red; font-size: 11px"
                >Tên liên hệ không được để trống</span
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
                v-model="email"
                v-on:keyup="messEmail"
              />
              <span v-if="!txtemail" style="color: red; font-size: 11px"
                >Email không được để trống</span
              >
            </div>
          </div>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Điện thoại liên hệ</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Điện thoại"
                v-model="phone"
                v-on:keyup="messPhone"
              />
              <span v-if="!txtphone" style="color: red; font-size: 11px"
                >Điện thoại liên hệ không được để trống</span
              >
            </div>
          </div>
<div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Địa chỉ liên hệ</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Địa chỉ"
                v-model="adress"
                v-on:keyup="messAdress"
              />
              <span v-if="!txtadress" style="color: red; font-size: 11px"
                >Địa chỉ liên hệ không được để trống</span
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
  data: function () {
    return {
      name: "",
      email: "",
      phone: "",
      adress: "",


      txtname: false,
      txtemail: false,
      txtphone: false,
      txtadress: false,
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

    messEmail() {
      let self = this;
      if (self.email == "") {
        self.txtemail = false;
      } else {
        self.txtemail = true;
      }
    },
    messPhone() {
      let self = this;
      if (self.phone == "") {
        self.txtphone = false;
      } else {
        self.txtphone = true;
      }
    },
    messAdress() {
      let self = this;
      if (self.adress == "") {
        self.txtadress = false;
      } else {
        self.txtadress = true;
      }
    },
    createProduct() {
      let self = this;
      if (self.name == "") {
        alert("Tên khách  không được để trống");
      } else if (self.email == "") {
        alert(" Email không được để trống ");
      } else if (self.phone == "") {
        alert(" Điện thoại khách hàng không được để trống ");
      }else if (self.adress == "") {
        alert(" Địa chỉ khách hàng không được để trống ");
      }  
      else {
        let newsModel = {
          name: self.name,
          email: self.email,
          phone: self.phone,
          adress: self.adress
        };

        ApiFunction("qlvl/contact/", "POST", newsModel);
      }
    },
  },
  created() {},
};
</script>
<style></style>
