let ordersString = localStorage.getItem("ps-shopping-orders")
let orders = []
let currentSeller = localStorage.getItem("ps-shopping-currentseller")

if (ordersString != null) {
    orders = JSON.parse(ordersString)
}
function changeToIndexPage() {
    window.location.href = "index.html"
}

function loadOrders() {
    let ordersTableContent = document.getElementById("orders-table-content")
    ordersTableContent.innerHTML = ""
    for (let i = 0; i < orders.length; i++) {
        let order = orders[i]
        console.log(order);
        let customer = order.customer
        let details = order.details
        let tr = document.createElement("tr")
        let idTd = document.createElement("td")

        let customerTd = document.createElement("td")
        let detailsTd = document.createElement("td")
        let totalPriceTd = document.createElement("td")
        let notesTd = document.createElement("td")
        let customerUl = document.createElement("ul")
        let nameLi = document.createElement("li")
        let surnameLi = document.createElement("li")
        let phoneNumberLi = document.createElement("li")
        let addressLi = document.createElement("li")
        let notesLi = document.createElement("li")
        console.log(details);
        nameLi.innerText = "Ad:" + customer.name
        surnameLi.innerText = "Soyad:" + customer.surname
        phoneNumberLi.innerText = "Telefon nomresi:" + customer.phoneNumber
        addressLi.innerText = "Unvan:" + customer.address
        let detailsUl = document.createElement("ul")
        let totalPrice = 0

        for (let i = 0; i < details.length; i++) {
            let ps = details[i].ps
            if (ps.seller == currentSeller) {
                console.log(1);
                let quantity = details[i].quantity

                let detailItemLi = document.createElement("li")

                let psUl = document.createElement("ul")
                psUl.innerHTML =
                    `<li>Miqdar: ${quantity}</li>` +
                    `<li> Qiymet: ${ps.price}</li>`;

                detailItemLi.innerHTML += `<li>Komputerin adi: ${ps.category + " " + ps.name}</li>`;
                detailsUl.appendChild(detailItemLi)
                detailItemLi.appendChild(psUl)
                totalPrice += details[i].totalPrice


            }
            //  else {
            //     ordersTableContent.innerHTML = ""
            //     return
            // }

        }
        idTd.innerText = order.id
        totalPriceTd.innerText = totalPrice
        notesTd.innerText = customer.notes
        customerUl.appendChild(nameLi)
        customerUl.appendChild(surnameLi)
        customerUl.appendChild(phoneNumberLi)
        customerUl.appendChild(addressLi)

        customerTd.appendChild(customerUl)
        detailsTd.appendChild(detailsUl)
        tr.appendChild(idTd)
        tr.appendChild(customerTd)
        tr.appendChild(detailsTd)
        tr.appendChild(totalPriceTd)
        tr.appendChild(notesTd)
        ordersTableContent.appendChild(tr)

    }
}
loadOrders()