$(document).ready(function () {

  $(document).on("click", "#login", function (event) {
    event.preventDefault();
    checkUser();
  });

  function checkUser() {

    var username = $("#name").val();
    var password = $("#password").val();

    if ((!username) || (!password)) {
      alert("Всички полета трябва да се попълнят!");
    } else {
      var formData = {
        name: username,
        email: "",
        password: password
      };

      $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/user/loginForm",
        data: JSON.stringify(formData),
        success: function () {
          sessionStorage.setItem("name", username);
          window.location.href = "/main";
        },
        error: function (jqXHR) {
          if (jqXHR.status === 401) {
            alert("Невалидни данни!")
          } else {
            alert(jqXHR.status);
            console.log(jqXHR);
          }
        }
      });
    }
  }
});
