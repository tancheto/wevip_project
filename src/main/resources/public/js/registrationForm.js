$(document).ready(function () {

  $(document).on("click", "#register", function (event1) {
    event1.preventDefault();
    registerUser();
  });

  function registerUser() {

    var name = $("#name").val();
    var email = $("#email").val();
    var pass = $("#password").val();
    var retypePass = $("#repeatPassword").val();

    if ((!name) || (!email) || (!pass) || (!retypePass)) {
      alert("Всички полета трябва да са попълнени!");
    } else {

      if (pass === retypePass) {

        // PREPARE FORM DATA
        var formData = {
          name: name,
          email: email,
          password: pass
        };

        $.ajax({
          type: "POST",
          url: "/user/registrationForm",
          contentType: "application/json",
          data: JSON.stringify(formData),
          success: function () {
            window.location.href = "/loginForm";
          },
          error: function (jqXHR) {
            if (jqXHR.status === 406) {
              alert("Невалиден формат на имейла!");
            } else if (jqXHR.status === 409) {
              alert("Потребителят вече съществува!");
            } else {
              alert(jqXHR.status)
            }
            $("#email").val("");
          }
        });
      } else {
        alert("Двете пароли не съвпадат! Въведи ги отново!");
        $("#password").val("");
        $("#retype_password").val("");
      }
    }
  }
});