function toggleEyeIcons(inputId) {
  const passwordInput = document.getElementById(inputId);
  const eyeIcon = document.querySelector(
    `.${
      inputId === "password__input" ? "password_eye" : "confirm_password_eye"
    }`
  );
  const eyeSlashIcon = document.querySelector(
    `.${
      inputId === "password__input"
        ? "password_eye_slash"
        : "confirm_password_eye_slash"
    }`
  );

  if (passwordInput.value.length > 0) {
    eyeIcon.style.display = "inline";
    eyeSlashIcon.style.display = "none";
  } else {
    eyeIcon.style.display = "none";
    eyeSlashIcon.style.display = "none";
  }
}

function togglePassword(inputId, eyeClass, eyeSlashClass) {
  const passwordInput = document.getElementById(inputId);
  const eyeIcon = document.querySelector(`.${eyeClass}`);
  const eyeSlashIcon = document.querySelector(`.${eyeSlashClass}`);

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

function checkPasswordsMatch() {
  const passwordInput = document.getElementById("password__input");
  const confirmPasswordInput = document.getElementById(
    "confirm__password__input"
  );
  const statusMessage = document.getElementById("password_match_status");

  if (passwordInput.value && confirmPasswordInput.value) {
    if (passwordInput.value === confirmPasswordInput.value) {
      statusMessage.style.display = "none";
    } else {
      statusMessage.style.display = "block";
      statusMessage.innerText = "Mật khẩu không khớp";
    }
  } else {
    statusMessage.style.display = "none";
  }
}
