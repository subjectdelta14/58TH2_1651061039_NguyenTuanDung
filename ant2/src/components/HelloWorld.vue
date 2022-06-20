<template>
 <div class="row">
	 
    <nav id="sidebar" class="sidebar">
      <div class="sidebar-content js-simplebar">
        <ul class="sidebar-nav">
         
         
        
        
		
		  
        
          <li class="sidebar-item">
            <router-link to="/createProduct" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Tạo sản phẩm</span></router-link
            >
            
          </li>
          <li class="sidebar-item">
            <router-link to="/ListProduct" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Danh sách sản phẩm</span></router-link
            >
            
          </li>
           <li class="sidebar-item">
            <router-link to="/CreateAccount" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Tạo tài khoản</span></router-link
            >
            
          </li>
          <li class="sidebar-item">
            <router-link to="/ListAcc" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Danh sách tài khoản</span></router-link
            >
            
          </li>
            <li class="sidebar-item">
            <router-link to="/CreateNews" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Tạo tin tức</span></router-link
            >
            
          </li>
          <li class="sidebar-item">
            <router-link to="/ListNews" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Danh sách tin tức</span></router-link
            >
            
          </li>
         <li class="sidebar-item">
            <router-link to="/CreateHire" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Tạo tuyển dụng</span></router-link
            >
            
          </li>
        <li class="sidebar-item">
            <router-link to="/ListHire" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Danh sách tuyển dụng</span></router-link
            >
            
          </li>
           <li class="sidebar-item">
            <router-link to="/CreateCustomer" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Tạo khách hàng</span></router-link
            >
            
          </li>
          <li class="sidebar-item">
            <router-link to="/ListCustomer" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Danh sách khách hàng</span></router-link
            >
            
          </li>
          <li class="sidebar-item">
            <router-link to="/CreateBill" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Tạo hóa đơn</span></router-link
            >
            
          </li>
           <li class="sidebar-item">
            <router-link to="/ListBill" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Danh sách hóa đơn</span></router-link
            >
            
          </li>
           <li class="sidebar-item">
            <router-link to="/CreateContact" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Tạo mới liên hệ</span></router-link
            >
            
          </li>
          <li class="sidebar-item">
            <router-link to="/ListContact" class="sidebar-link"
              ><i class="align-middle" data-feather="coffee"></i>
              <span class="align-middle">Danh sách liên hệ</span></router-link
            >
            
          </li>

         
        </ul>
      </div>
    </nav>
	<div class="col-md-9 text-center">
    
      <router-view class="content"></router-view>
    </div>
 </div>
    
  
</template>

<script>
export default {
  
  props: {},
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
