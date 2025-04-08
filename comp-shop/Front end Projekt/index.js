document.getElementById("logOut").addEventListener("click", () => {
    localStorage.removeItem("username");
    localStorage.removeItem("password");
    window.location.reload();
});

function changeToLoginPage() {
    window.location.href = "./login.html"; 
}


const username = localStorage.getItem("username");
const password = localStorage.getItem("password");

if (username || password) {
    document.getElementById("logIn").style.display = "none";
    document.getElementById("logOut").style.display = "inline";
    document.getElementById("orders-button").style.display = "inline";
    document.getElementById("ps-button").style.display = "inline";
    document.getElementById("reset").style.display = "inline";
} else {
    document.getElementById("logIn").style.display = "inline";
    document.getElementById("logOut").style.display = "none";
    document.getElementById("orders-button").style.display = "none";
    document.getElementById("ps-button").style.display = "none";
    document.getElementById("reset").style.display = "none";
}




if (username !== "null") {
    document.getElementById("seller-label").innerText += username;
} else {
    document.getElementById("seller-label").innerText += 'istifadəçi daxil olmayıb';
}
function changeToLoginPage(){
window.location.href="login.html"
}
function changeToPsPage(){
    window.location.href="my-computers.html"
}
function changeToPsShoppingPage(){
    window.location.href="computers.html"
}
function changeToOrdersPage(){
    window.location.href="orders.html"
}
