import Utils from "../Utils.js";

const container = document.querySelector('.personal-infor-container')

Utils.getHeader()
Utils.protectUser()
container.insertAdjacentHTML("beforeend", Utils.getFooter())

const decreaseButtons = document.querySelectorAll('#decrease');
const increaseButtons = document.querySelectorAll('#increase');

decreaseButtons.forEach(button => {
    button.addEventListener('click', function() {
        let quantityDisplay = this.nextElementSibling;
        let currentQuantity = parseInt(quantityDisplay.textContent);
        if (currentQuantity > 1) {
            quantityDisplay.textContent = currentQuantity - 1;
        }
    });
});

increaseButtons.forEach(button => {
    button.addEventListener('click', function() {
        let quantityDisplay = this.previousElementSibling; 
        let currentQuantity = parseInt(quantityDisplay.textContent); 
        quantityDisplay.textContent = currentQuantity + 1; 
    });
});

const containerOrder = document.querySelector(".order-list")

const canceledOrders = ()=>{
    const html = `
    <div class="order">
        <div class="item-list">
            <div class="item-container">
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
            </div>
            <div class="total-container">
                <div>
                    <label for="">Tổng số</label>
                    <p>8</p>
                </div>
                <div>
                    <label for="">Tổng tiền</label>
                    <p>520.000đ</p>
                </div>
            </div>
        </div>
        <div class="order-detail">
            <div class="info-row status">
                <span class="label">Đơn hàng đã được hủy bởi quý khách lúc</span>
                <span class="value">25/09/2024 12:30:00</span>
            </div>
            <div class="info-row status">
                <span class="label">Lý do hủy đơn hàng</span>
                <span class="value">Thay đổi địa chỉ giao hàng</span>
            </div>
            <div class="order-container">
                <div class="order-header">
                    <div class="dots">
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                    </div>
                    <div class="heading">
                        <span class="title">THÔNG TIN ĐƠN HÀNG</span>
                        <span class="order-id">MÃ ĐƠN <strong>988334</strong></span>    
                    </div>
                </div>
                <h3>Thông tin khách hàng</h3>
                <div class="customer-info">
                    <div class="info-row">
                        <span class="label">Người nhận hàng</span>
                        <span class="value">PHẠM THANH TRƯỜNG</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Số điện thoại</span>
                        <span class="value">0998844432</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Địa chỉ giao hàng</span>
                        <span class="value">41/15, đường số 11, phường Trường Thọ, TP. Thủ Đức, TP.HCM</span>
                    </div>
                </div>
                <h3>Thông tin đơn đặt hàng</h3>
                <div class="customer-info">
                    <div class="info-row">
                        <span class="label">Người nhận hàng</span>
                        <span class="value">PHẠM THANH TRƯỜNG</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Số điện thoại</span>
                        <span class="value">0998844432</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Địa chỉ giao hàng</span>
                        <span class="value">41/15, đường số 11, phường Trường Thọ, TP. Thủ Đức, TP.HCM</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    `
    containerOrder.innerHTML = html
}

const shippedOrders = ()=>{
    const html = `
    <div class="order">
        <div class="item-list">
            <div class="item-container">
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
            </div>
            <div class="total-container">
                <div>
                    <label for="">Tổng số</label>
                    <p>8</p>
                </div>
                <div>
                    <label for="">Tổng tiền</label>
                    <p>520.000đ</p>
                </div>
            </div>
        </div>
        <div class="order-detail">
            <div class="info-row status">
                <span class="label">Đơn hàng đã được giao đến bạn lúc</span>
                <span class="value">25/09/2024 12:30:00</span>
            </div>
            <div class="order-container">
                <div class="order-header">
                    <div class="dots">
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                    </div>
                    <div class="heading">
                        <span class="title">THÔNG TIN ĐƠN HÀNG</span>
                        <span class="order-id">MÃ ĐƠN <strong>988334</strong></span>    
                    </div>
                </div>
                <h3>Thông tin khách hàng</h3>
                <div class="customer-info">
                    <div class="info-row">
                        <span class="label">Người nhận hàng</span>
                        <span class="value">PHẠM THANH TRƯỜNG</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Số điện thoại</span>
                        <span class="value">0998844432</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Địa chỉ giao hàng</span>
                        <span class="value">41/15, đường số 11, phường Trường Thọ, TP. Thủ Đức, TP.HCM</span>
                    </div>
                </div>
                <h3>Thông tin đơn đặt hàng</h3>
                <div class="customer-info">
                    <div class="info-row">
                        <span class="label">Người nhận hàng</span>
                        <span class="value">PHẠM THANH TRƯỜNG</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Số điện thoại</span>
                        <span class="value">0998844432</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Địa chỉ giao hàng</span>
                        <span class="value">41/15, đường số 11, phường Trường Thọ, TP. Thủ Đức, TP.HCM</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    `
    containerOrder.innerHTML = html
}

const waitConfirmOrders = ()=>{
    const html = `
    <div class="order">
        <div class="item-list">
            <div class="item-container">
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
            </div>
            <div class="total-container">
                <div>
                    <label for="">Tổng số</label>
                    <p>8</p>
                </div>
                <div>
                    <label for="">Tổng tiền</label>
                    <p>520.000đ</p>
                </div>
            </div>
        </div>
        <div class="order-detail">
            <div class="order-container">
                <div class="order-header">
                    <div class="dots">
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                    </div>
                    <div class="heading">
                        <span class="title">THÔNG TIN ĐƠN HÀNG</span>
                        <span class="order-id">MÃ ĐƠN <strong>988334</strong></span>    
                    </div>
                </div>
                <h3>Thông tin khách hàng</h3>
                <div class="customer-info">
                    <div class="info-row">
                        <span class="label">Người nhận hàng</span>
                        <span class="value">PHẠM THANH TRƯỜNG</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Số điện thoại</span>
                        <span class="value">0998844432</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Địa chỉ giao hàng</span>
                        <span class="value">41/15, đường số 11, phường Trường Thọ, TP. Thủ Đức, TP.HCM</span>
                    </div>
                </div>
                <h3>Thông tin đơn đặt hàng</h3>
                <div class="customer-info">
                    <div class="info-row">
                        <span class="label">Người nhận hàng</span>
                        <span class="value">PHẠM THANH TRƯỜNG</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Số điện thoại</span>
                        <span class="value">0998844432</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Địa chỉ giao hàng</span>
                        <span class="value">41/15, đường số 11, phường Trường Thọ, TP. Thủ Đức, TP.HCM</span>
                    </div>
                </div>
                <button>Hủy đơn hàng</button>
            </div>
        </div>
    </div>
    `
    containerOrder.innerHTML = html
}

const shippingOrders = ()=>{
    const html = `
    <div class="order">
        <div class="item-list">
            <div class="item-container">
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
                <ul class="item">
                    <li>
                        <img src="../../img/product/detail.png" alt="">
                    </li>
                    <li class="product-detail">
                        <a href="" class="name">Basic tee</a>
                        <p class="color">Màu sắc: Xanh đậm</p>
                        <p class="size">Size: XL</p>
                    </li>
                    <li class="quantity"><p>x1</p></li>
                    <li class="price"><p>120.000đ</p></li>
                </ul>
            </div>
            <div class="total-container">
                <div>
                    <label for="">Tổng số</label>
                    <p>8</p>
                </div>
                <div>
                    <label for="">Tổng tiền</label>
                    <p>520.000đ</p>
                </div>
            </div>
        </div>
        <div class="order-detail">
            <div class="order-container">
                <div class="order-header">
                    <div class="dots">
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                    </div>
                    <div class="heading">
                        <span class="title">THÔNG TIN ĐƠN HÀNG</span>
                        <span class="order-id">MÃ ĐƠN <strong>988334</strong></span>    
                    </div>
                </div>
                <h3>Thông tin khách hàng</h3>
                <div class="customer-info">
                    <div class="info-row">
                        <span class="label">Người nhận hàng</span>
                        <span class="value">PHẠM THANH TRƯỜNG</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Số điện thoại</span>
                        <span class="value">0998844432</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Địa chỉ giao hàng</span>
                        <span class="value">41/15, đường số 11, phường Trường Thọ, TP. Thủ Đức, TP.HCM</span>
                    </div>
                </div>
                <h3>Thông tin đơn đặt hàng</h3>
                <div class="customer-info">
                    <div class="info-row">
                        <span class="label">Người nhận hàng</span>
                        <span class="value">PHẠM THANH TRƯỜNG</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Số điện thoại</span>
                        <span class="value">0998844432</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Địa chỉ giao hàng</span>
                        <span class="value">41/15, đường số 11, phường Trường Thọ, TP. Thủ Đức, TP.HCM</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    `
    containerOrder.innerHTML = html
}

const menu = document.querySelectorAll(".menu li")
menu.forEach((e)=>{
    e.addEventListener("click",()=>{
        e.classList.add("active")
        menu.forEach((u)=>{
            if(u !== e){
                u.classList.remove("active")
            }
        })
        switch(e.getAttribute("id")){
            case "waiting":
                containerOrder.innerHTML = ""
                waitConfirmOrders()
                break;
            case "shipping":
                containerOrder.innerHTML = ""
                shippingOrders()
                break;
            case "shipped":
                containerOrder.innerHTML = ""
                shippedOrders()
                break;
            case "canceled":
                containerOrder.innerHTML = ""
                canceledOrders()
                break;
            default:
                containerOrder.innerHTML = ""
                waitConfirmOrders()
        }
    })
})

waitConfirmOrders()

