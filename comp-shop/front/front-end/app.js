
document.addEventListener('DOMContentLoaded', function () {
    const loggedInUser = localStorage.getItem('loggedInUser');
    const usernameHeader = document.querySelector('.h1');
    const logoutButton = document.querySelector('.btn3');
    if (usernameHeader && loggedInUser) {
        usernameHeader.textContent = `İstifadəçi adı: ${loggedInUser}`;
        logoutButton.style.display = 'inline-block';
        document.querySelector(".button2").innerText = "Kompüter Alis verisine basla";
        document.querySelector(".a1").href = "./komputerler.html";
    }
    if (logoutButton) {
        logoutButton.addEventListener('click', function () {
            localStorage.removeItem('loggedInUser');
            location.reload();
         
            document.querySelector(".button2").innerText = "Hesaba daxil ol";
            document.querySelector(".a1").href = "./daxil.html";
        });
    }
});
