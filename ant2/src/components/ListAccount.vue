<template>
  <div class="col-md-12">
    <div class="card">
      <div class="card-header">
        <h5 class="card-title">Danh sách tài khoản</h5>
      </div>
      <table class="table table-striped table-sm">
        <thead>
          <tr>
            <th>Tên đăng nhập</th>
            <th>Mật khẩu</th>
            <th>Chức năng</th>
            <th>Thao tác</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="data in listAcc" v-bind:key="data.id">
            <td>
             <router-link :to="{ name: 'UpdateAccount', 
           params: { id : data.id }}">
              {{ data.username }}</router-link>
            </td>

            <td>{{ data.password }}</td>
            <td>{{ data.role }}</td>
            <td>
              <button
                type="button"
                class="btn btn-primary"
                v-on:click="deleteAcc(data.id)"
              >
                Xóa
              </button>
            </td>
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
import ApiFunction from "@/js/ApiUtils.js";
import axios from "axios";
export default {
  data() {
    return {
      size: 20,
      page: 0,
      totalPages: 0,
      listAcc: [],
    };
  },
  methods: {
    async getAllAcc() {
      console.log(this.listProduct);
      this.listAcc = await ApiFunction("qlvl/acc/", "GET", null);

      
    },
    deleteAcc(id) {
      console.log(id);
      axios
        .delete(` http://localhost:8888/api/qlvl/acc/delete/` + id)
        .then((response) => {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error.response);
        });
    },
  },
  
  created() {
    this.getAllAcc();
  },
};
</script>
<style scoped></style>
