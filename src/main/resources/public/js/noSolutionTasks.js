$(document).ready(function () {
  $("#subj").children().css("display", "none");
  $(".review").css("display", "none");
  if (sessionStorage.getItem('username') === 'admin') {
    $(".review").show();
  } else {
    $(".review").css("display", "none");
  }
});