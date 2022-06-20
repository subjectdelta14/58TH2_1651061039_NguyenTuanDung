<template>
  <div class="container">
    <div class="card card-container">
      <h1 class="text-center">Đăng kí</h1>

      <form class="form-signin">
        <a>Email</a>
        <span id="reauth-email" class="reauth-email"></span>
        <input
          type="email"
          id="inputEmail"
          class="form-control"
          placeholder="Email address"
          v-model="emailRegister"
          required
          autofocus
        />
        <a>Full Name</a>
        <input
          type="text"
          id="inputFullName"
          class="form-control"
          placeholder="Full Name"
          v-model="fullnameRegister"
          required
          autofocus
        />
        <a>Phone Number</a>
        <input
          type="text"
          id="inputPhoneNumber"
          class="form-control"
          placeholder="Phone Number"
          v-model="phoneRegister"
          required
          autofocus
        />
        <a>Password</a>
        <input
          type="password"
          id="inputPassword"
          class="form-control"
          placeholder="Password"
          v-model="passwordRegister"
          required
        />
        <a>Confirm Password</a>
        <input
          type="password"
          id="inputConfirmPassword"
          class="form-control"
          placeholder="Password"
          
          required
        />
        
       
       
          <button
            class="btn btn-lg btn-primary btn-block btn-signin"
            type="button"
            v-on:click="register"
          >
            Nhận Mã kích hoạt
          </button>
          <input
          type="text"
          id="inputVerificationCode"
          class="form-control"
          placeholder="VerificationCode"
          v-model="verificationCode"
          required
        />
        <router-link to="/">
        <button
            class="btn btn-lg btn-primary btn-block btn-signin"
            type="button"
            v-on:click="verification"
          >
            Sign In
          </button></router-link >
        
        
      </form>
      
    </div>
  </div>
</template>

<script>
import ApiFunction from "@/js/ApiUtils.js";
export default {
  data() {
    return {
      fullnameRegister:'',
      emailRegister:'',
      phoneRegister:'',
      passwordRegister:'',
      verificationCode:''
    };
  },
  methods:{
    
    register(){
      let self=this
      let object={
        'email':self.emailRegister,
        'phone':self.phoneRegister,
        'password':self.passwordRegister,

      }
      ApiFunction('api/register','POST',object)
    },
    verification(){
      let self =this
      let email = self.emailRegister
      let code =self.verificationCode
      ApiFunction('api/verification-user?email='+email+'&code='+code,null)

    }

  }
};
</script>
<style scoped>
body,
html {
  height: 100%;
  background-repeat: no-repeat;
  background-image: linear-gradient(rgb(124, 166, 184), rgb(162, 169, 173));
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
