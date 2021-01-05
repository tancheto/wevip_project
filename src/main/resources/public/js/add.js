function offer() {
  var formData = {
    title: document.getElementById("title").value,
    content: document.getElementById("condition").value,
    solutionValue: document.getElementById("solution").value,
    solutionContent: document.getElementById("answer").value,
    difficultyId: $("#difficultyOptions :selected").attr("id"),
    partId: $("#partOptions :selected").attr("id"),
    theoreticalKnowledgeId: $("#theoryOptions :selected").attr("id")
  };

  $.ajax({
    type: "POST",
    url: "/tasks/add",
    contentType: "application/json",
    data: JSON.stringify(formData),
    success: function () {
      window.location.href = "/main";
    },
    error: function (e) {
      console.log("ERROR: ", e);
    }
  });
}

$(document).ready(function () {
  $("#success").css("display", "none");
  $("#publishTask").show();
  getAllParts();
  getDifficulties(1);
  getAllTheory();
});

$('#offer').on('click', function () {
  $("#offer").css("display", "none");
  $("#publishTask").show();
  $("#success").css("display", "none");
});

function getAllParts() {
  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: "/parts/",
    success: function (response) {
      var list = "";
      for (i in response) {
        list += "<option id=" + response[i].partId + ">" + response[i].name + "</option>";
      }
      $("#partOptions").append(list);
    },
    error: function (e) {
      console.log("ERROR: ", e);
    }
  });
}

function getDifficulties(partId) {
  $.ajax({
    type: "POST",
    contentType: "application/json",
    url: "/difficulties/",
    data: "id:" + partId,
    success: function (response) {
      var list = "";
      for (i in response) {
        list += "<option id=" + response[i].difficultyId + ">" + response[i].name + "</option>";
      }
      $("#difficultyOptions").append(list);
    },
    error: function (e) {
      console.log("ERROR: ", e);
    }
  });
}

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