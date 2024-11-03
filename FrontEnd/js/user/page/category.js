import Utils from "../Utils.js";

const slider = document.querySelector(".slider")
const carouselContainer = document.querySelector(".carousel-container")
const container = document.querySelector('.container')

container.insertAdjacentHTML("beforeend", Utils.getFooter())

Utils.getHeader()
// Utils.protectUser()
Utils.renderSlide("slide/slide", slider)
Utils.renderCategory(carouselContainer)

const btnAddAnimation = document.querySelectorAll(".btn")
btnAddAnimation.forEach((b)=>{
    Utils.addAnimation(b)
})