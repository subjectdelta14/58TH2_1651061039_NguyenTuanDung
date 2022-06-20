<template>
  <div class="col-md-12">
    <div class="card">
      <div class="card-header">
        <h5 class="card-title">Danh sách hóa đơn</h5>
      </div>
      <table class="table table-striped table-sm">
        <thead>
          <tr>
            <th>Tên hóa đơn</th>
            <th>Số lượng</th>
            <th>Giá</th>
            
            <th>Thao tác</th>

           
          </tr>
        </thead>
        <tbody>
          <tr v-for="data in listNews" v-bind:key="data.id">
            <td><router-link :to="{ name: 'UpdateBill', 
           params: { id : data.id }}"> {{ data.name }}</router-link>
             
            </td>

            <td>{{ data.quantity }}</td>
            <td>{{ data.price }}</td>
            
          
            <td><button
                type="button"
                class="btn btn-primary"
                v-on:click="deleteProDuct(data.id)"
              >
                Xóa
              </button></td>

          
            
          </tr>
        </tbody>
      </table>
      <nav aria-label="Page navigation example">
        <ul class="pagination pagination-md">
          <li class="page-item">
            <a class="page-link"><i class="fas fa-angle-left"></i></a>
          </li>
          <li class="page-item"><a class="page-link">1</a></li>
          <li class="page-item"><a class="page-link">2</a></li>
          <li class="page-item"><a class="page-link">3</a></li>
          <li class="page-item"><a class="page-link">4</a></li>
          <li class="page-item"><a class="page-link">5</a></li>
          <li class="page-item">
            <a class="page-link"><i class="fas fa-angle-right"></i></a>
          </li>
        </ul>
      </nav>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import ApiFunction from "@/js/ApiUtils.js";
export default {
  data() {
    return {
      size: 20,
      page: 0,
      totalPages: 0,
      listNews: [],
    };
  },
  methods: {
    async getAllNews() {
      console.log(this.listNews);
      this.listNews = await ApiFunction("qlvl/bill/get/", "GET", null);
    },
    
    deleteProDuct(id) {
      console.log(id);
      axios
        .delete(` http://localhost:8888/api/qlvl/bill/delete/` + id)
        .then((response) => {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error.response);
        });
    },
  },
  created() {
    this.getAllNews();
  },
};
</script>
<style scoped></style>
