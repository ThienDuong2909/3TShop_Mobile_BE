export default class Utils{
    static getHeader() {
        const html = `
            <header class="header">
                <div class="logo">
                    <a href = "/"><img src="../../img/utils/logoShop.png" alt=""></a>
                </div>

                <div class="menu-action">
                    <div class="search-container">
                        <i class="material-icons">search</i>
                        <input type="text" placeholder="Tìm kiếm...">
                        <i class="border-left material-symbols-outlined">image_search</i>
                    </div>

                    <div class="menu-icons">
                        <a href = "/cart">
                            <i class="material-symbols-outlined">
                                shopping_cart
                            </i>
                        </a>
                        <div>
                            <i class="material-symbols-outlined menu-btn">
                                account_circle
                            </i>
                            <ul class="nav">
                                <li>
                                    <a href="/personal-infor">
                                        Tài khoản của bạn
                                        <span class="material-symbols-outlined">
                                            shield_person
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="/order">
                                        Đơn hàng
                                        <span class="material-symbols-outlined">
                                            package_2
                                        </span>
                                    </a>
                                </li>
                                <li class="btn-logout">
                                    <a href="#">
                                        Đăng xuất
                                        <span class="material-symbols-outlined">
                                            move_item
                                        </span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div id="toast-container">
                    
                </div>
                <div id="logout">
                    <div class="modal-logout">
                        <span class="close material-symbols-outlined">
                            close
                        </span>
                        <div class="content">
                            <div>
                                <img src="../../img/utils/quit.png" />
                            </div>
                            <h4>ĐĂNG XUẤT</h4>
                            <p>Bạn có chắc chẵn đăng xuất tài khoản không</p>
                            <div class="btn-container">
                                <a class="cancel">Thoát</a>
                                <a href="/login" class="submit">Đăng xuất</a>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
        `
        document.body.insertAdjacentHTML('afterbegin', html) 
        const openMenu = () => {
            const nav = document.querySelector('.nav');
            nav.classList.toggle("active-menu");
        }

        const menuBtn = document.querySelector('.menu-btn');
        if (menuBtn) {
            menuBtn.addEventListener('click', openMenu);
        }
        const logoutContainer = document.querySelector("#logout")
        const close = document.querySelector("#logout .close")
        const cancel = document.querySelector("#logout .cancel")
        const btnLogout = document.querySelector(".btn-logout")
        btnLogout.addEventListener("click",()=>{
            this.openModal(logoutContainer)
        })
        close.addEventListener("click",()=>{
            this.closeModal(logoutContainer)
        })
        cancel.addEventListener("click",()=>{
            this.closeModal(logoutContainer)
        })
        logoutContainer.addEventListener("click",(e)=>{
            if(e.target === logoutContainer){
                this.closeModal(logoutContainer)
            }
        })
    }

    static getToast(type){
        const html = `
            <div class="icon">
                <img src="../../img/toast/${type}.png" alt="">
            </div>
            <div class="toast-body">
                <h4 class="toast-status">THÀNH CÔNG</h4>
                <p class="toast-content">Đã thêm sản phẩm vào giỏ hàng</p>
            </div>
        `;

        const toastContainer = document.querySelector("#toast-container");
        const newToast = document.createElement("div");
        newToast.setAttribute("id","toast")
        newToast.innerHTML = html;
        toastContainer.appendChild(newToast);
        
        const status = newToast.querySelector(".toast-status");
        console.log(status)
        const content = newToast.querySelector(".toast-content");
        
        if (type === "warning") {
            status.textContent = "CẢNH BÁO";
            content.textContent = "Chú ý, đã xảy ra lỗi vui lòng thử lại";
        }
        if (type === "error") {
            status.textContent = "THẤT BẠI";
            content.textContent = "Chú ý, đã xảy ra lỗi vui lòng thử lại";
        }
    
        newToast.addEventListener("click", () => {
            newToast.classList.add('hide');
            setTimeout(() => {
                newToast.remove();
            }, 500);
        });
        
        setTimeout(() => {
            newToast.classList.add('hide');
            setTimeout(() => {
                newToast.remove();
            }, 500);
        }, 4000);
        
    }

    static getFooter(){
        return(
            `<div class="footer">
                <div class="infor">
                    <div class="contract">
                        <div class="footer-logo">
                            <img src="../../img/utils/footer-logo.png" alt="">
                        </div>
                        <div class="content">
                            <h4>THÔNG TIN LIÊN HỆ</h4>
                            <div class="group-paraph">
                                <span class="material-symbols-outlined">
                                    phone
                                </span>
                                <p>0977655231</p>
                            </div>
                            <div class="group-paraph">
                                <span class="material-symbols-outlined">
                                    mail
                                </span>
                                <p>3tshop@business.com</p>
                            </div>
                            <div class="group-paraph">
                                <span class="material-symbols-outlined">
                                    mail
                                </span>
                                <p>3tshop@customer.com</p>
                            </div>
                        </div>
                    </div>
                    <div class="location">
                        <h4>HỆ THỐNG CỬA HÀNG</h4>
                        <div class="group-paraph">
                            <span class="material-symbols-outlined">
                                distance
                            </span> 
                            <p>Chi nhánh 1: 44A Trần Quang Diệu, Quận 3</p>
                        </div>
                        <div class="group-paraph">
                            <span class="material-symbols-outlined">
                                distance
                            </span>
                            <p>Chi nhánh 2: TNP Lý Tự Trọng, Quận 1</p>
                        </div>
                        <div class="group-paraph">
                            <span class="material-symbols-outlined">
                                distance
                            </span>
                            <p>Chi nhánh 3: TNP Lê Lai, Quận 1</p>
                        </div>
                    </div>
                </div>
                <div class="social">
                    <h4>THEO DÕI CHÚNG TÔI TRÊN</h4>
                    <div class="social-list">
                        <a href="">
                            <img src="../../img/utils/fb.png" alt="">
                        </a>
                        <a href="">
                            <img src="../../img/utils/insta.png" alt="">
                        </a>
                        <a href="">
                            <img src="../../img/utils/zalo.png" alt="">
                        </a>
                    </div>
                    <p>Copyrights © 2024 by 3TShop</p>
                </div>
            </div>`
        )
    }

    static renderSlide(url, element) {
        let countSlider = 1;
        const totalSlides = 6;
    
        const html = `
            <img src="../../img/${url}1.png" alt="Slide Image" id="sliderImage1" class="active">
            <img src="../../img/${url}2.png" alt="Slide Image" id="sliderImage2">
            <img src="../../img/${url}3.png" alt="Slide Image" id="sliderImage3">
            <img src="../../img/${url}4.png" alt="Slide Image" id="sliderImage4">
            <img src="../../img/${url}5.png" alt="Slide Image" id="sliderImage5">
            <img src="../../img/${url}6.png" alt="Slide Image" id="sliderImage6">`
        element.innerHTML = html
    
        const images = document.querySelectorAll(".slider img");
        const startSlider = () => {
            setInterval(() => {
                const currentImage = images[countSlider - 1];
    
                countSlider++;
                if (countSlider > totalSlides) {
                    countSlider = 1;
                }
    
                const nextImage = images[countSlider - 1];
    
                currentImage.classList.remove("active");
                currentImage.classList.add("exiting");
    
                setTimeout(() => {
                    currentImage.classList.remove("exiting");
                }, 1000);
    
                nextImage.classList.add("active");
            }, 4000);
        };
    
        startSlider();
    }

    static renderCategory(element){
        const html  = `
        <div class="item-list">
            <div class="item">
                <a href="/hoodie"><img src="../../img/items/Category1.png" alt=""></a>
            </div>
            <div class="item">
                <a href="/t-shirt"><img src="../../img/items/Category2.png" alt=""></a>
            </div>
            <div class="item">
                <a href="/short"><img src="../../img/items/Category3.png" alt=""></a>
                </div>
            <div class="item">
                <a href="/paint"><img src="../../img/items/Category4.png" alt=""></a>
            </div>
            <div class="item">
                <a href="/jean"><img src="../../img/items/Category5.png" alt=""></a>
            </div>
            <div class="item">
                <a href="/tee"><img src="../../img/items/Category6.png" alt=""></a>
            </div>
        </div>
        <button class="prev prev-item">
            <span class="material-symbols-outlined btn">
                arrow_back_ios
            </span>
        </button>
        <button class="next next-item">
            <span class="material-symbols-outlined btn">
                arrow_forward_ios
            </span>
        </button>`
        element.innerHTML = html
        let currentIndex = 0;
        const itemsPerPage = 4;
        const totalItems = document.querySelectorAll('.item-list .item').length;
        const nextBtn = document.querySelector(".next-item")
        const prevBtn = document.querySelector(".prev-item")

        function updateCarousel() {
            const itemList = document.querySelector('.item-list');
            const offset = -(currentIndex * 25);
            const pixel = currentIndex * 15;
            itemList.style.transform = `translateX(calc(${offset}% - ${pixel}px))`;
        }

        function prevSlide() {
            if (currentIndex > 0) {
                currentIndex--;
                updateCarousel();
                if(currentIndex <= 0){
                    prevBtn.style.display = "none"
                }
                nextBtn.style.display = "block"
            }
        }

        function nextSlide() {
            if (currentIndex < totalItems / itemsPerPage) {
                currentIndex++;
                updateCarousel();
                if(currentIndex >= totalItems / itemsPerPage){
                    nextBtn.style.display = "none"
                }
                prevBtn.style.display = "block"
            }
        }

        prevBtn.addEventListener("click",()=>{
            prevSlide()
        })
        nextBtn.addEventListener("click",()=>{
            nextSlide()
        })
    }

    static addAnimation(e) {
        e.addEventListener("mousedown",()=>{
            this.getToast("success")
            e.style.transform = "scale(.9)"
        })
        e.addEventListener("mouseup",()=>{
            e.style.transform = "scale(1)"
        })
    }

    static closeModal = (e)=>{
        e.style.display = "none"
    }
    static openModal = (e)=>{
        e.style.display = "flex"
    }
    static protectUser = ()=>{
        const role = localStorage.getItem("role")
        if(role !== "user"){
            window.location.href = "/login"
        }
    }

    static protectAdmin = ()=>{
        const role = localStorage.getItem("role")
        if(role !== "admin"){
            window.location.href = "/login"
        }
    }
}