<template>
  <div class="col-md-12">
    <div class="card">
      <div class="card-header">
        <h5 class="card-title">Danh sách vật liệu</h5>
      </div>
      <table class="table table-striped table-sm">
        <thead>
          <tr>
            <th>Tên sản phẩm</th>
            <th>Loai</th>

            <th>Giá</th>
            <th>Kho hàng</th>
            <th>Năm sản xuất</th>
            <th>Địa điểm</th>
            <th>Công dụng</th>
            <th>Ảnh</th>
            <th>Thao tác</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="data in listProduct" v-bind:key="data.id">
            <td><router-link :to="{ name: 'UpdateProduct', 
           params: { id : data.id }}"> {{ data.name }}</router-link>
             
            </td>

            <td>{{ data.type }}</td>

            <td>
              {{ data.price }}
            </td>
            <td>
              {{ data.quantity }}
            </td>
            <td>
              {{ data.year }}
            </td>
            <td>
              {{ data.location }}
            </td>
            <td>
              {{ data.impact }}
            </td>
            <td>
              <img :src="'data:image/jpeg;base64,'+data.img"  style="width:50px">
            </td>
            <td>
              <button
                type="button"
                class="btn btn-primary"
                v-on:click="deleteProDuct(data.id)"
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
import axios from "axios";
import ApiFunction from "@/js/ApiUtils.js";
export default {
  data() {
    return {
      size: 20,
      page: 0,
      totalPages: 0,
      listProduct: [],
    };
  },
  methods: {
    async getAllProduct() {
      console.log(this.listProduct);
      this.listProduct = await ApiFunction("qlvl/", "GET", null);
    },
    deleteProDuct(id) {
      console.log(id);
      axios
        .delete(` http://localhost:8888/api/qlvl/` + id)
        .then((response) => {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error.response);
        });
    },
  },
  created() {
    this.getAllProduct();
  },
};
</script>
<style scoped></style>
