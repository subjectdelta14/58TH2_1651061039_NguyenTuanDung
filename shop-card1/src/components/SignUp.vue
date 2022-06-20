<template>
  <div class="container container-productlist">
    <div class="card card-container">
      <h1 class="text-center">Đăng kí</h1>

      <form class="form-signin">
        <a>UserName</a>
        <input
          type="text"
          id="inputFullName"
          class="form-control"
          placeholder="Full Name"
          v-model="username"
          required
          autofocus
        />

        <a>Password</a>
        <input
          type="password"
          id="inputPassword"
          class="form-control"
          placeholder="Password"
          v-model="password"
          required
        />

        <button
          class="btn btn-lg btn-primary btn-block btn-signin"
          type="button"
          v-on:click="register()"
        >
          Sign Up
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import ApiFunction from "@/js/ApiUtils.js";
export default {
  data() {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    register() {
      let self = this;
      let object = {
        username: self.username,

        password: self.password,
        role: "user",
      };
      ApiFunction("qlvl/acc/", "POST", object);
    },
  },
};
</script>
<style scoped>
.container-productlist {
  margin-top: 50px;
  align-items: flex-start;
}
.card-container.card {
  max-width: 350px;
  padding: 40px 40px;
}

.btn {
  font-weight: 700;
  height: 36px;
  -moz-user-select: none;
  -webkit-user-select: none;
  user-select: none;
  cursor: default;
}

.card {
  background-color: #f7f7f7;

  padding: 20px 25px 30px;
  margin: 0 auto 25px;
  margin-top: 50px;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-name-card {
  font-size: 16px;
  font-weight: bold;
  text-align: center;
  margin: 10px 0 0;
  min-height: 1em;
}

.reauth-email {
  display: block;
  color: #404040;
  line-height: 2;
  margin-bottom: 10px;
  font-size: 14px;
  text-align: center;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

.form-signin #inputFullName,
.form-signin #inputConfirmPassword,
.form-signin #inputEmail,
.form-signin #inputPhoneNumber,
.form-signin #inputPassword {
  direction: ltr;
  height: 44px;
  font-size: 16px;
}

.form-signin input[type="email"],
.form-signin input[type="password"],
.form-signin input[type="text"],
.form-signin button {
  width: 100%;
  display: block;
  margin-bottom: 10px;
  z-index: 1;
  position: relative;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

.form-signin .form-control:focus {
  border-color: rgb(104, 145, 162);
  outline: 0;
  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075),
    0 0 8px rgb(104, 145, 162);
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgb(104, 145, 162);
}

.btn.btn-signin {
  background-color: rgb(104, 145, 162);

  padding: 0px;
  font-weight: 700;
  font-size: 14px;
  height: 36px;
  -moz-border-radius: 3px;
  -webkit-border-radius: 3px;
  border-radius: 3px;
  border: none;
  -o-transition: all 0.218s;
  -moz-transition: all 0.218s;
  -webkit-transition: all 0.218s;
  transition: all 0.218s;
}

.btn.btn-signin:hover,
.btn.btn-signin:active,
.btn.btn-signin:focus {
  background-color: rgb(12, 97, 33);
}

.forgot-password {
  color: rgb(104, 145, 162);
}

.forgot-password:hover,
.forgot-password:active,
.forgot-password:focus {
  color: rgb(12, 97, 33);
}
</style>
