$(document).ready(function () {

  $(".user-p").text(sessionStorage.getItem('name'));
  if (sessionStorage.getItem('name') !== null) {
    $("#logout").show();
    $("#signin").css("display", "none");
  } else {
    $("#logout").css("display", "none");
    $("#signin").show();
  }
});

$(document).on("click", "#logout", function (event) {
  event.preventDefault();
  sessionStorage.clear();
  $("#logout").css("display", "none");
  $("#signin").show();
  $.ajax({
    type: "POST",
    contentType: "application/json",
    url: "/logout",
    success: function () {
      //redirect
      window.location.href = "/index";
    },
    error: function (e) {
      alert(JSON.stringify(e));
      console.log("ERROR: ", e);
    }
  });
});
