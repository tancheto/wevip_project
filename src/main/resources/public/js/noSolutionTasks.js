$(document).ready(function () {
  $("#subj").children().css("display", "none");
  $(".review").css("display", "none");
  if (sessionStorage.getItem('name') === 'admin') {
    $(".review").show();
  } else {
    $(".review").css("display", "none");
  }
});