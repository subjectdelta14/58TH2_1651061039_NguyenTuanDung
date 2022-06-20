import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";



import Login from "../components/Login.vue";
import SignUp from "../components/SignUp.vue"

import CreateProduct from "../components/CreateProduct.vue"
import ListProduct from "../components/ListProduct.vue"
import UpdateProduct from "../components/UpdateProduct.vue"
import ListAcc from "../components/ListAccount.vue"
import CreateNews from "../components/CreateNews.vue"
import ListNews from "../components/ListNews.vue"
import ListHire from "../components/ListHire.vue"
import CreateAccount from "../components/CreateAccount.vue"
import UpdateAccount from "../components/UpdateAccount.vue"
import UpdateNews from "../components/UpdateNews.vue"
import CreateHire from "../components/CreateHire.vue"
import UpdateHire from "../components/UpdateHire.vue"
import CreateCustomer from "../components/CreateCustomer.vue"
import ListCustomer from "../components/ListCustomer.vue"
import UpdateCustomer from "../components/UpdateCustomer.vue"
import CreateBill from "../components/CreateBill.vue"
import  ListBill from "../components/ListBill.vue"
import  UpdateBill from "../components/UpdateBill.vue"
import  ListContact from "../components/ListContact.vue"
import  CreateContact from "../components/CreateContact.vue"
import  UpdateContact from "../components/UpdateContact.vue"
const routes = [
  {
    path: "/",
    name: "Login",
    component: Login,
  },
  {
    path: "/SignUp",
    name: "SignUp",
    component: SignUp,
  },
  {
    path: "/HomePage",
    name: "Home",
    component: Home,
    children: [
     
      {
        path: "/UpdateProduct",
        name: "UpdateProduct",
        component: UpdateProduct,
        props: true,
      },
      {
        
        path: "/ListProduct",
        name: "ListProduct",
        component: ListProduct,
        props: true,
       
      },
      {
        path: "/CreateProduct",
        name: "CreateProduct",
        component: CreateProduct,
      },
      {
        path: "/ListAcc",
        name: "ListAcc",
        component: ListAcc,
        props: true,
      },
      {
        path: "/CreateNews",
        name: "CreateNews",
        component: CreateNews,
        props: true,
      },
      {
        path: "/ListNews",
        name: "ListNews",
        component: ListNews,
        props: true,
      },
      {
        path: "/ListHire",
        name: "ListHire",
        component: ListHire,
        props: true,
      },
      {
        path: "/CreateAccount",
        name: "CreateAccount",
        component: CreateAccount,
        props: true,
      },
      {
        path: "/UpdateAccount",
        name: "UpdateAccount",
        component: UpdateAccount,
        props: true,
      },
      {
        path: "/UpdateNews",
        name: "UpdateNews",
        component: UpdateNews,
        props: true,
      },
      {
        path: "/CreateHire",
        name: "CreateHire",
        component: CreateHire,
        props: true,
      },
      {
        path: "/UpdateHire",
        name: "UpdateHire",
        component: UpdateHire,
        props: true,
      },
      {
        path: "/CreateCustomer",
        name: "CreateCustomer",
        component: CreateCustomer,
        props: true,
      },
      {
        path: "/ListCustomer",
        name: "ListCustomer",
        component: ListCustomer,
        props: true,
      },
      {
        path: "/UpdateCustomer",
        name: "UpdateCustomer",
        component: UpdateCustomer,
        props: true,
      },
      {
        path: "/CreateBill",
        name: "CreateBill",
        component: CreateBill,
        props: true,
      },
      {
        path: "/ListBill",
        name: "ListBill",
        component: ListBill,
        props: true,
      },
      {
        path: "/UpdateBill",
        name: "UpdateBill",
        component: UpdateBill,
        props: true,
      },
      {
        path: "/ListContact",
        name: "ListContact",
        component: ListContact,
        props: true,
      },
      {
        path: "/CreateContact",
        name: "CreateContact",
        component: CreateContact,
        props: true,
      },
      {
        path: "/UpdateContact",
        name: "UpdateContact",
        component: UpdateContact,
        props: true,
      },
    ],
  },

  
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
