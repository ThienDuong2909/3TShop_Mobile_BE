const items = document.getElementsByClassName('manage__items')
for (let i = 0; i < items.length; i++) {
    let position = -1
    items[i].addEventListener('click', ()=> {
        const icon = items[i].querySelector('span')
        const name = items[i].querySelector('h5')
        items[i].style.backgroundColor = 'white'
        icon.style.color = '#222831'
        name.style.color = '#222831'

    })
}