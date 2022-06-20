import $ from "jquery";
export  function btnplus(clicked_id) {
    console.log('1')
    var indexNumber = Number($("#amount-" + clicked_id).val());
    let d = $("#stock-" + clicked_id).text();
    if (indexNumber >= d) {
      $("#amount-" + indexNumber).val(d);
    } else {
      indexNumber += 1;
      this.CheckInput(indexNumber, clicked_id);
      this.changeNumber(indexNumber, clicked_id);
      this.Tinhtong();
    }
  }
  export function create(productId ) {
      
     

      
    console.log(1)
          let template_01 = `
      <div class="form-row form-order" id="listSku-${productId.productId}" >
      <div class="form-order-01">
        <img class="img-order--product" src="">
      </div>
      <div id="div2-${productId.productId}" class="form-order-04 flex-row">
        <p class="form-name">
        ${productId.name}
         
        </p>
        <p hidden="hidden">
          <label id="proID-${productId.productId}"></label>
          <label id="attrId-${productId.productId}"></label>
        </p>
        <p class="form-sku">SKU:
          <span id="itemSku-${productId.productId}">
          ${productId.sku}
            
          </span>
        </p>
        <label>
          
        </label>
        <label>
          
        </label>
        <label>
          Số lượng : 
          <span id="stock-${productId.productId}">
          ${productId.qty}
            
          </span>
        </label>
      </div>
    </div>
      `;
          let template_02 = `
      <tr>
      <td colspan="4"></td>
      </tr>
      <tr>
        <td>  </td>
        <td style="text-align: right;">10.000</td>
        <td style="text-align: right;">2</td>
        <td style="text-align: right;">20.000</td>
      </tr>
      `;
          $("#createnode").append(template_01);
          $("#createnodePrint").append(template_02);
    
          if (productId.price == productId.priceNew) {
            let if_01 = `
       <label class="form-price" id="origin-${productId.productId}" value=${productId.price}>
           ${productId.price}
         </label> `;
            $("#div2-" + productId.productId).append(if_01);
          } else if (productId.priceNew == 0) {
            let if_01 = `
         <label class="form-price" id="origin-${productId.productId}" value=${productId.price}>
         ${productId.price}
        </label>  `;
            $("#div2-" + productId.productId).append(if_01);
          } else if (
            productId.price !== productId.priceNew &&
            $("#order-modal").hasClass("show") == false
          ) {
            let if_01 = `
         <label class="form-priceNew" id="sale-${productId.productId}" value=${productId.price}>
           ${productId.price}
         </label>
        <label class="form-price" id="origin-${productId.productId}" value=${productId.priceNew}>
           ${productId.priceNew}
        </label> `;
            $("#div2-" + productId.productId).append(if_01);
          } else {
            let if_01 = `
         <label class="form-priceNew" id="sale-${productId.productId}" value=${productId.price}>
           ${productId.price}
         </label>
         <label class="form-price" id="origin-${productId.productId}" value=${productId.price}>
           ${productId.price}
         </label> `;
            $("#div2-" + productId.productId).append(if_01);
          }
    
          if (productId.priceNew == 0) {
            let div3 = `
       <div class="form-order-02">
         <p id="total-${productId}" class="total-payment" value="${productId.price}">
           ${productId.price}
         </p>
       </div>
       `;
            $("#listSku-" + productId.productId).append(div3);
          } else if (
            productId.price !== productId.priceNew &&
            $("#order-modal").hasClass("show") == false
          ) {
            let div3 = `
        <div class="form-order-02">
           <p id="total-${productId.productId}" class="total-payment" value="${productId.priceNew}">
            ${productId.priceNew}
           </p>
         </div>
         `;
            $("#listSku-" + productId.productId).append(div3);
          } else {
            let div3 = `
         <div class="form-order-02">
           <p id="total-${productId.productId}" class="total-payment" value="${productId.price}">
            ${productId.priceNew}
           </p>
         </div>
         `;
            $("#listSku-" + productId.productId).append(div3);
          }
    
          let div4 = `
       <div class="form-order-03">
         <input id="amount-${productId.productId}" type="text" value="1" style="width:100%;border:none;margin-bottom: 10px;text-align: center;" v-on:keyup="CheckInput(this.value,this.id.substring(7))" v-on:keypress="return event.charCode >= 48 && event.charCode <= 57">
    
       </div> `;
          $("#listSku-" + productId.productId).append(div4);
    
          let div5 = `
      <div class="form-order-05 flex-row">
      <button class="button-noborder--blue btn-align--order" type="button" onclick="btnplus('${productId.productId }')">
        <i class="fa fa-chevron-up" aria-hidden="true"></i>
      </button>
      <button class="button-noborder--red btn-align--order" type="button" @click="btnminus('${productId.productId}')">
        <i class="fa fa-chevron-down" aria-hidden="true"></i>
      </button>
      <button class="button-noborder--red btn-align--order" type="button" @click="showConfirm('${productId.productId}')">
        <i class="fa fa-trash" aria-hidden="true"></i>
      </button>
      </div>
      `;
          $("#listSku-" + productId.productId).append(div5);
    
          $("#createnode").animate(
            { scrollTop: $("#createnode").get(0).scrollHeight },
            2000
          );
          console.log(1)
        }
    