document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();
  
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const messageBox = document.getElementById('loginMessage');
  
    fetch('http://localhost:8025/auth/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=UTF-8'
      },
      body: JSON.stringify({ email, password })
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Email və ya şifrə yalnışdır!');
      }
      return response.json();
    })
    .then(data => {
      const token = data.token || data?.data?.token;
  
      if (token) {
        localStorage.setItem('jwtToken', token);
        messageBox.textContent = "Giriş uğurlu! Yönləndirilirsiniz...";
        messageBox.style.color = "green";
      
      
        window.location.href="index.html"
      }
      
    })
    .catch(error => {
      messageBox.textContent = error.message;
      messageBox.style.color = "red";
    });
  });
  