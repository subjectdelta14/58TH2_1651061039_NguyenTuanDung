<template>
  <div class="col-md-12">
    <div class="card">
      <div class="card-header">
        <h5 class="card-title">Danh sách tuyển dụng</h5>
      </div>
      <table class="table table-striped table-sm">
        <thead>
          <tr>
            <th>Tên tuyển dụng</th>
            <th>Email </th>
             <th>Vị trí</th>
             <th>Thao tác</th>

           
          </tr>
        </thead>
        <tbody>
          <tr v-for="data in listHire" v-bind:key="data.id">
            <td>  <router-link :to="{ name: 'UpdateHire', 
           params: { id : data.id }}"> {{ data.name }}</router-link>
             
            </td>

            <td>{{ data.email }}</td>
            <td>{{ data.position }}</td>
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
      listHire: [],
    };
  },
  methods: {
    async getAllHire() {
      console.log(this.listNews);
      this.listHire = await ApiFunction("qlvl/hire/get/", "GET", null);
    },
    deleteProDuct(id) {
      console.log(id);
      axios
        .delete(` http://localhost:8888/api/qlvl/hire/delete/` + id)
        .then((response) => {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error.response);
        });
    },
  },
  created() {
    this.getAllHire();
  },
};
</script>
<style scoped></style>
