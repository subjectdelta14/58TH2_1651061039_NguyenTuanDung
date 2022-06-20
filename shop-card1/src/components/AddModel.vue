
<template>
  <transition name="modal">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-header">
            <slot name="header"> Giỏ hàng </slot>
          </div>

          <div class="modal-body">
            <slot name="body">
              
            </slot>
          </div>

          <div class="modal-footer">
            <slot name="footer">
              <button class="button btn-info col-md-4" @click="submitButton()">
                Thanh toán
              </button>
              <button class="button btn-danger col-md-4" @click="$emit('close')">
                Đóng
              </button>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>
<script>
export default {
  name: "modal",
  props: [""],
  data() {
    return {
      
    };
  },
  methods: {
    
  },
};
</script>
<style scoped>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  width: 300px;
  margin: 0px auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
  font-family: Helvetica, Arial, sans-serif;
}

.modal-body {
  margin: 20px 0;
}
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>