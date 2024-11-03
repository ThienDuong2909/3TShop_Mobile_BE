import Utils from "../Utils.js";
import Api from "../Api.js";

const container = document.querySelector('.cart-container')

Utils.getHeader()
Utils.protectUser()
Api.testApi()

container.insertAdjacentHTML("beforeend", Utils.getFooter())

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
