import Utils from "../Utils.js";

const container = document.querySelector('.personal-infor-container')

container.insertAdjacentHTML("beforeend", Utils.getFooter())

Utils.getHeader()
// Utils.protectUser()
const inputsInforForm = document.querySelectorAll("#personal-infor-form input")
const editBtnInforForm = document.querySelector("#personal-infor-form .edit")
const cancelBtnInforForm = document.querySelector("#personal-infor-form .cancel-edit")
const submitBtnInforForm = document.querySelector("#personal-infor-form .save")
editBtnInforForm.addEventListener('click',(e)=>{
    e.preventDefault()
    cancelBtnInforForm.style.display = "block"
    editBtnInforForm.style.display = "none"
    inputsInforForm.forEach((i)=>{
        i.readOnly = false
    })
    submitBtnInforForm.disabled = false
})

cancelBtnInforForm.addEventListener("click",(e)=>{
    e.preventDefault()
    cancelBtnInforForm.style.display = "none"
    editBtnInforForm.style.display = "block"
    inputsInforForm.forEach((i)=>{
        i.readOnly = true
    })
    //fill lại dữ liệu ban đầu
})

submitBtnInforForm.addEventListener("click",(e)=>{
    e.preventDefault()
    //gửi dữ liệu ok nhó
    inputsInforForm.forEach((i)=>{
        i.readOnly = true
    })
    cancelBtnInforForm.style.display = "none"
    editBtnInforForm.style.display = "block"
})

const newAddressContainer = document.querySelector("#modal-add-address")
const closeNewAddressBtn = document.querySelector("#modal-add-address .close")
const cancelNewAddressBtn = document.querySelector("#modal-add-address .cancel")
const openNewAddFormBtn = document.querySelector(".new-address-btn")
const submitNewAddressBtn = document.querySelector("#modal-add-address .submit")

closeNewAddressBtn.addEventListener("click",()=>{
    Utils.closeModal(newAddressContainer)
})
cancelNewAddressBtn.addEventListener("click",(e)=>{
    e.preventDefault()
    Utils.closeModal(newAddressContainer)
})
openNewAddFormBtn.addEventListener("click",()=>{
    Utils.openModal(newAddressContainer)
})
newAddressContainer.addEventListener("click",(e)=>{
    if(e.target === newAddressContainer){
        Utils.closeModal(newAddressContainer)
    }
})