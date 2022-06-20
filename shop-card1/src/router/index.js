import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import ProductList from"../components/ProductList.vue";
import Introduce from"../components/Introduce.vue";
import News from"../components/News.vue";
import Login from"../components/Login.vue";
import SignUp from"../components/SignUp.vue";
import Contact from"../components/Contact.vue";
import DetailsProduct from"../components/DetailsProduct.vue";
const routes = [
  {
    path: "/ProductList",
    name: "ProductList",
    component: ProductList,
   
    props: true,
     
    
  },
  {
    path: "/DetailsProduct",
    name: "DetailsProduct",
    component: DetailsProduct,
   
     
    props: true,
  },
  {
    path: "/Contact",
    name: "Contact",
    component: Contact,
    props: true,
  },
  {
    path: "/Introduce",
    name: "Introduce",
    component: Introduce,
    props: true,
  },
  {
    path: "/News",
    name: "News",
    component: News,
    props: true,
  },
  {
    path: "/Login",
    name: "Login",
    component: Login,
    props: true,
  },
  {
    path: "/SignUp",
    name: "SignUp",
    component: SignUp,
    props: true,
  },
   {
     path: "/",
     name: "Home",
     component: Home,
     children: [
      

      
    
      
     
      
     ],
     props: true,
   },
  
  
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
