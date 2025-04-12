document.getElementById('loginForm').addEventListener('submit', function(e) {
  e.preventDefault();

  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;

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
    console.log('Backenddən gələn data:', data);

    const token = data.access_token;
    console.log('Token:', token);

    if (token) {
      localStorage.setItem('jwtToken', token);
      window.location.href = "index.html";
    } else {
      alert("Token əldə edilə bilmədi.");
    }
  })
  .catch(error => {
    console.error('Giriş zamanı xəta:', error);
    alert(error.message || "Bilinməyən xəta baş verdi.");
  });
});
