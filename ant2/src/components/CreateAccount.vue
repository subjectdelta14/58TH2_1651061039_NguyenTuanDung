<template>
  <div class="col-md-12 text-center">
    <div class="card">
      <div class="card-header">
        <h5 class="card-title">Tạo tài khoản</h5>
      </div>
      <div class="card-body">
        <form>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right"
              >Tên đăng nhập</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Tên đăng nhập"
                v-model="userName"
                v-on:keyup="messUserName"
              />
              <span v-if="!txtuserName" style="color: red; font-size: 11px"
                >Tên đăng nhập không được để trống</span
              >
            </div>
          </div>

          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Mật khẩu</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Mật khẩu"
                v-model="passWord"
                v-on:keyup="messPassWord"
              />
              <span v-if="!txtPassWord" style="color: red; font-size: 11px"
                >Mật khẩu không được để trống</span
              >
            </div>
          </div>
          <div class="form-group row">
            <label class="col-form-label col-sm-3 text-sm-right pt-sm-0"
              >Chức năng</label
            >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control"
                placeholder="Chức năng"
                v-model="role"
                v-on:keyup="messRole"
              />
              <span v-if="!txtRole" style="color: red; font-size: 11px"
                >Chức năng không được để trống</span
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
      userName: "",
      passWord: "",
      role: "",

      txtuserName: false,
      txtPassWord: false,
      txtRole: false,
    };
  },
  components: {},
  methods: {
    messUserName() {
      let self = this;
      if (self.userName == "") {
        self.txtuserName = false;
      } else {
        self.txtuserName = true;
      }
    },

    messPassWord() {
      let self = this;
      if (self.passWord == "") {
        self.txtPassWord = false;
      } else {
        self.txtPassWord = true;
      }
    },
    messRole() {
      let self = this;
      if (self.role == "") {
        self.txtRole = false;
      } else {
        self.txtRole = true;
      }
    },
    createProduct() {
      let self = this;
      if (self.userName == "") {
        alert("Tên đăng nhâp  không được để trống");
      } else if (self.passWord == "") {
        alert(" Mật khẩu không được để trống ");
      } else if (self.role == "") {
        alert(" Chức năng không được để trống ");
      } else {
        let newsModel = {
          username: self.userName,
          password: self.passWord,
          role: self.role,
        };

        ApiFunction("qlvl/acc/", "POST", newsModel);
      }
    },
  },
  created() {},
};
</script>
<style></style>
