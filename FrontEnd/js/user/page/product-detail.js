import Utils from "../Utils.js";

const container = document.querySelector('.container')
const closeModalBtn = document.querySelector(".modal-body span")
const openModalBtn = document.querySelector(".guide")
const modal = document.querySelector("#modal-guide-container")

Utils.getHeader()
// Utils.protectUser()
container.insertAdjacentHTML("beforeend", Utils.getFooter())

const btnAddAnimation = document.querySelectorAll(".btn")
btnAddAnimation.forEach((b)=>{
    Utils.addAnimation(b)
})

openModalBtn.addEventListener("click",()=>{
    Utils.openModal(modal)
})

closeModalBtn.addEventListener("click",()=>{
    Utils.closeModal(modal)
})

modal.addEventListener("click",(e)=>{
    if(e.target === modal){
        Utils.closeModal(modal)
    }
})


let currentIndexSameProduct = 0;
const itemsPerPageSameProduct = 4;
const totalSameProduct = document.querySelectorAll('.same-product-list .product').length;
const nextSameProductBtn = document.querySelector(".next-same-product")
const prevSameProductBtn = document.querySelector(".prev-same-product")

function updateCarouselSameProduct() {
    const sameProductList = document.querySelector('.same-product-list')
    const offset = -(currentIndexSameProduct * 25);
    const pixel = currentIndexSameProduct * 14;
    sameProductList.style.transform = `translateX(calc(${offset}% - ${pixel}px))`;
}

function prevSameProduct() {
    if (currentIndexSameProduct > 0) {
        currentIndexSameProduct--;
        updateCarouselSameProduct();
        if(currentIndexSameProduct <= 0){
            prevSameProductBtn.style.display = "none"
        }
        nextSameProductBtn.style.display = "block"
    }
}

function nextSameProduct() {
    if (currentIndexSameProduct < totalSameProduct / itemsPerPageSameProduct) {
        currentIndexSameProduct++;
        updateCarouselSameProduct();
        if(currentIndexSameProduct >= totalSameProduct / itemsPerPageSameProduct){
            nextSameProductBtn.style.display = "none"
        }
        prevSameProductBtn.style.display = "block"
    }
}

prevSameProductBtn.addEventListener("click",()=>{
    prevSameProduct()
})
nextSameProductBtn.addEventListener("click",()=>{
    nextSameProduct()
})

const decreaseButtons = document.querySelectorAll('#decrease');
const increaseButtons = document.querySelectorAll('#increase');

decreaseButtons.forEach(button => {
    button.addEventListener('click', function() {
        let quantityDisplay = this.nextElementSibling;
        let currentQuantity = parseInt(quantityDisplay.value);
        if (currentQuantity > 1) {
            quantityDisplay.value = currentQuantity - 1;
        }
    });
});

increaseButtons.forEach(button => {
    button.addEventListener('click', function() {
        let quantityDisplay = this.previousElementSibling; 
        let currentQuantity = parseInt(quantityDisplay.value); 
        quantityDisplay.value = currentQuantity + 1; 
    });
});
