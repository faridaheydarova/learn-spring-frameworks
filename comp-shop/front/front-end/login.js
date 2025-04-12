async function loginUser() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const basicAuth = btoa(`${username}:${password}`);

    try {
        const response = await fetch("http://localhost:8024/users/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                 "Authorization": `Basic ${basicAuth}`
            },
            body: JSON.stringify({ username: username, password: password })
        });

        if (response.ok) {
            const data = await response.json();
            console.log(data);

            if (data.username) {
                localStorage.setItem("username", data.username);
                localStorage.setItem("password", data.password);
               
           
               window.location.href = "./seller-computer.html";
            } else {
                console.error("Cavabda 'username' tapılmadı:", data);
                alert("Gözlənilməz server cavabı: " + JSON.stringify(data));
            }
        } else {
            const errorText = await response.text();
            console.error("Server xətası:", errorText);
        
        }
    } catch (error) {
        console.error("Şəbəkə xətası:", error);
        
    }
}

function goBack() {
    window.location.href = "index.html";
}
function goRegister() {
    window.location.href = "register.html";
}
