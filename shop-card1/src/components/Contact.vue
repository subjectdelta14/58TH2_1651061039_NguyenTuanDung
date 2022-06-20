<template>
   <div class="container container-contactform">
                
                <form>
                    <p>Send us a message</p>
                    <div class="contactform-containerform">
                        <div class="contactform-input">
                            <label for="contactname">First and last name*</label><br/>
                            <input type="text" id="contactname" v-model="name" required/>
                        </div>
                        <div class="contactform-input">
                            <label for="contactemail">Email address*</label><br/>
                            <input type="email" id="contactemail" v-model="email" required/>
                        </div>
                       
                        <div class="contactform-input">
                            <label for="contactcontent">Position*</label><br/>
                            <input type="text" id="contactcontent"  v-model="position" required/>
                        </div>      
                    </div>
                    
                    <div class="contactform-button">
                        <button type="button"  v-on:click="createHire">Send</button>
                    </div>
                </form>

            <div class="contactform-information">
                <div class="contactform-information-item">
                    <i class="fa fa-map-marker" aria-hidden="true" />
                    <div class="information-item-content">
                        <h2>Address</h2>
                        <p>Hà Nội</p>
                    </div>
                </div>
                <div class="contactform-information-item">
                    <i class="fa fa-phone" aria-hidden="true" />
                    <div class="information-item-content">
                        <h2>Phone number</h2>
                        <p>0987654322</p>
                    </div>
                </div>
                <div class="contactform-information-item">
                <i class="fa fa-envelope" aria-hidden="true" />
                    <div class="information-item-content">
                        <h2>Email</h2>
                        <p>dungnt621@wru.vn</p>
                    </div>
                </div>
            </div>
        </div>
</template>

<script>
import ApiFunction from "@/js/ApiUtils.js";
export default {
  name: 'ContactForm',
  data() {
    return {
      name:"",
      email:"",
      position:"",
    }
  },
  components: {
   
  },
  computed: {
   
  },
  methods: {
  createHire(){
      let self= this;
      let hireData={
          name : self.name,
          email : self.email,
          position : self.position

      }
      ApiFunction("qlvl/hire/create/","POST",hireData)

  }
  },
  created() {
    
  },
}
</script>

<style scoped>
.container-contactform{
    margin-top: 50px;
    align-items: flex-start;
}

.container-contactform form{
    width: 50%;
}

.contactform-containerform{
    padding: 20px 0;
    text-align: left;
    margin: auto;
    width: 80%;
}
.contactform-input{
    margin-top: 20px;
}
.contactform-input label{
    color: rgb(65, 65, 58);
    font-size: 20px;
}
.contactform-input input{
    height: 30px;
    width: 100%;
}

.container-contactform p{
    font-size: 30px;
}

.contactform-button{
    padding: 20px;
}
.contactform-button button{
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    cursor: pointer;
    font-size: 18px;
    width: 30%;
    height: 40px;
    border: none;
    background: rgb(163, 162, 162);
    color: rgb(27, 27, 26);
}
.contactform-button button:hover{
    background: rgba(23, 90, 95, 0.678);
    color: rgb(255, 255, 255);
    
}


.contactform-information{
    width: 50%;
    text-align: left;
}

.contactform-information-item{
    margin-bottom: 30px;
    display: flex;
    align-items: center;
}
.contactform-information-item i{
    font-size: 50px;
}
.information-item-content{
    margin-left: 10px;
}
.information-item-content p{
    color: rgb(56, 54, 54);
    font-size: 25px;
}




@media (max-width: 575px) {
    .container-contactform{
    margin-top: 50px;
    flex-wrap: wrap;
    justify-content: center;
}

.container-contactform form{
    width: 100%;
    padding: 20px 0;
    background: rgba(228, 229, 226, 0.336);
}
.contactform-information{
    padding: 20px 0;
    width: 80%;
    text-align: left;
}


}


@media (min-width: 576px) and (max-width: 767px){
    .container-contactform{
    margin-top: 50px;
    flex-wrap: wrap;
    justify-content: center;
}

.container-contactform form{
    width: 100%;
    padding: 20px 0;
    background: rgba(228, 229, 226, 0.336);
}
.contactform-information{
    padding: 25px 0;
    width: 80%;
    text-align: left;
}
}


@media (min-width: 768px) {
  .contactform-information-item i{
    font-size: 40px;
}
.information-item-content p{
    font-size: 20px;
}
.contactform-information{
    padding: 93px 0;
}
}


</style>
