function toggleEyeIcons() {
  const passwordInput = document.getElementById("password__input");
  const eyeIcon = document.querySelector(".toggle__eye");
  const eyeSlashIcon = document.querySelector(".toggle__eye__slash");

  // Show the eye icon only if there's text in the input
  if (passwordInput.value.length > 0) {
    eyeIcon.style.display = "inline";
    eyeSlashIcon.style.display = "none";
  } else {
    eyeIcon.style.display = "none";
    eyeSlashIcon.style.display = "none";
  }
}

function togglePassword() {
  const passwordInput = document.getElementById("password__input");
  const eyeIcon = document.querySelector(".toggle__eye");
  const eyeSlashIcon = document.querySelector(".toggle__eye__slash");

  if (passwordInput.type === "password") {
    passwordInput.type = "text";
    eyeIcon.style.display = "none";
    eyeSlashIcon.style.display = "inline";
  } else {
    passwordInput.type = "password";
    eyeIcon.style.display = "inline";
    eyeSlashIcon.style.display = "none";
  }
}

async function login() {
  const username = document.getElementById("username__input").value;
  const password = document.getElementById("password__input").value;

  if (!username || !password) {
    alert("Vui lòng nhập tên tài khoản và mật khẩu");
    return;
  }

  const payload = {
    username: username,
    password: password,
  };
  try {
    const response = await fetch(
      "http://localhost:8080/api/v1/auth/authenticate",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(payload),
      }
    );

    const data = await response.json();
    if (response.status === 200) {
      localStorage.setItem("token", data.token);
      try {
        const decoded = jwt_decode(data.token);
        const userRole = decoded.role;
        if (userRole === "[USER]") {
          console.log("role:", userRole);
          // window.location.href = "/product";
        } else if (userRole === "[ADMIN]") {
          console.log("role:", userRole);
          // window.location.href = "/manager";
        }
      } catch (error) {
        console.error("Lỗi khi giải mã JWT:", error);
      }
    } else {
      alert(data.message || "Đăng nhập thất bại!");
    }
  } catch (error) {
    console.error("Đăng nhập lỗi:", error);
    alert("Có lỗi xảy ra khi đăng nhập. Vui lòng thử lại!");
  }
}
