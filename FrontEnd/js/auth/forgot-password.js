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
