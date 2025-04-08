let ordersString=localStorage.getItem("ps-shopping-orders")
let orders=[]
let basket=[]
let basketString=localStorage.getItem("ps-shopping-basket")
if(ordersString !=null){
orders=JSON.parse(ordersString)

}

if(basketString !=null){
    basket=JSON.parse(basketString)
    
    }

function changeToIndexPage(){
    window.location.href = "index.html"
}


function createOrder(event){
    event.preventDefault()
    let customer={}
    let name=document.getElementById("name").value
    let surname=document.getElementById("surname").value
    let phoneNumber=document.getElementById("phone-number").value
    let address=document.getElementById("address").value
    let notes=document.getElementById("notes").value
let numberRegax="[0-9+-]+"
 if(phoneNumber.match(numberRegax) !=null&& phoneNumber.length>=16){
    customer.name=name
    customer.surname=surname
    customer.phoneNumber=phoneNumber
    customer.address=address
    customer.notes=notes
    

   
     let order={}
     order.id=orders.length+1
     order.customer=customer
     order.details=basket
     orders.push(order)
     console.log(order);
     localStorage.setItem("ps-shopping-orders",JSON.stringify(orders))

setTimeout(()=>{
window.location.href="index.html"
localStorage.removeItem("ps-shopping-basket")
},1000)

 }else{
    alert("Muelumatlar duzgun deyil")
se
 }


}