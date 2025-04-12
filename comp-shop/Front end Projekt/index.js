document.getElementById("logOut").addEventListener("click", () => {
    localStorage.removeItem("jwtToken");
    window.location.reload();
});

function changeToLoginPage() {
    window.location.href = "./login.html";
}

const token = localStorage.getItem("jwtToken");

if (token) {
    document.getElementById("logIn").style.display = "none";
    document.getElementById("logOut").style.display = "inline";
    document.getElementById("orders-button").style.display = "inline";
    document.getElementById("ps-button").style.display = "inline";
    document.getElementById("reset").style.display = "inline";
    document.getElementById("seller-label").innerText += "istifadəçi daxil olub";
} else {
    document.getElementById("logIn").style.display = "inline";
    document.getElementById("logOut").style.display = "none";
    document.getElementById("orders-button").style.display = "none";
    document.getElementById("ps-button").style.display = "none";
    document.getElementById("reset").style.display = "none";
    document.getElementById("seller-label").innerText += "istifadəçi daxil olmayıb";
}

function changeToPsPage(){
    window.location.href = "my-computers.html";
}
function changeToPsShoppingPage(){
    window.location.href = "computers.html";
}
function changeToOrdersPage(){
    window.location.href = "orders.html";
}
