function offer() {
  if (document.getElementById('solution').value != "" && document.getElementById('theoryOptions').value != "") {
    $("#offer").css("display", "none");
    $("#sol").css("display", "none");
    $("#success").show();
  } else alert("Попълнете всички полета!");
}

$(document).ready(function () {
  $("#sol").css("display", "none");
  $("#success").css("display", "none");
  getAllTheory();
});

$(document).on('click', '#offer', function () {
  $("#offer").css("display", "none");
  $("#sol").show();
  $("#success").css("display", "none");
});

function getAllTheory() {
  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: "/theory/",
    success: function (response) {
      var list = "";
      for (i in response) {
        list += "<option id=" + response[i].theoreticalKnowledgeId + ">" + response[i].name + "</option>";
      }
      $("#theoryOptions").append(list);
    },
    error: function (e) {
      console.log("ERROR: ", e);
    }
  });
}