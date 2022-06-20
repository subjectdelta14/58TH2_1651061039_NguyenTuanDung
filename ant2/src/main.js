import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios from 'axios'
import VueAxios from 'vue-axios'
import Vuelidate from 'vuelidate';
import Vue from 'vue';

import '@/assets/app.css';

import 'bootstrap/dist/css/bootstrap.min.css';
window.Vue = Vue

createApp(App).use(store).use(router,VueAxios, axios,Vuelidate).mount("#app");

