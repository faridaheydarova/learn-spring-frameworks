let form = document.getElementById("registrationForm");


form.querySelectorAll("input").forEach((input) => {
    input.addEventListener("keyup", () => {
        showValidationMessages(input);
    });
});

form.addEventListener("submit", (event) => {
    event.preventDefault();
    if (form.checkValidity()) {
        addNewUser();
        form.reset();
    } else {
     
       
        form.querySelectorAll("input").forEach((input) => {
            showValidationMessages(input);
        });
    }
});

function addNewUser() {
    let newuser = {};
    form.querySelectorAll("input").forEach((input) => {
        newuser[input.name] = input.value;
    });

    let users = checkUserFromLocalStorage();
    users.push(newuser);

    localStorage.setItem("users", JSON.stringify(users));
    console.log("User added", newuser);
}

function checkUserFromLocalStorage() {
    let users = JSON.parse(localStorage.getItem("users")) || [];
    return users;
}

function showValidationMessages(input) {
    let truemessage = input.nextElementSibling.nextElementSibling.nextElementSibling;
    let falsemessage = input.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling;
    if (input.checkValidity()) {
        truemessage.style.display = "block";
        falsemessage.style.display = "none";
        input.nextElementSibling.style.display ="none"
        input.nextElementSibling.nextElementSibling.style.display ="inline"

    } else {
        truemessage.style.display = "none";
        falsemessage.style.display = "block";
        input.nextElementSibling.style.display ="inline"
        input.nextElementSibling.nextElementSibling.style.display ="none"
    }
}
