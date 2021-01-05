var minutesLabel = document.getElementById("minutes");
var secondsLabel = document.getElementById("seconds");
var totalSeconds = 0;
setInterval(setTime, 1000);

function setTime() {
  ++totalSeconds;
  $(document).on('click', '#check', function () {
    secondsLabel = sec;
    minutesLabel = min;
  });
  secondsLabel.innerHTML = pad(totalSeconds % 60);
  minutesLabel.innerHTML = pad(parseInt(totalSeconds / 60));
  var sec = pad(totalSeconds % 60);
  var min = pad(parseInt(totalSeconds / 60));
}

function pad(val) {
  var valString = val + "";
  if (valString.length < 2) {
    return "0" + valString;
  } else {
    return valString;
  }
}

function result() {
  if ($("#task-value").text() === document.getElementById("answer").value) {
    $("#wrongAnswer").css("display", "none");
    $("#tryAgain").css("display", "none");
    $("#correctAnswer").show();
    $("#help").css("display", "none");
    $("#helpTheory").css("display", "none");
    $("#check").css("display", "none");
    $("hr").show();
    $("#usedTheory").show();
    $("#submit").show();
  } else {
    $("#solve").css("display", "none");
    $("#correctAnswer").css("display", "none");
    $("#wrongAnswer").show();
    $("#tryAgain").show();
    $("#helpTheory").css("display", "none");
    $("#help").css("display", "none");
    $("#check").css("display", "none");
    $("#answer").css("display", "none");
    $("#retry").show();
    $("#back").show();
  }
}

function theory() {
  if ($("#theoryOptions :selected").attr("id") === document.getElementById("usedTheory").className) {
    $("#wrongTheory").css("display", "none");
    $("#correctTheory").show();
    $("#usedTheory").css("display", "none");
    $("#submit").css("display", "none");
    $("#help").css("display", "none");
    $("#solve").show();
    $("#back").show();
  } else {
    $("#correctTheory").css("display", "none");
    $("#wrongTheory").show();
    $("#usedTheory").css("display", "none");
    $("#helpTheory").show();
    $("#submit").css("display", "none");
    $("#solve").show();
    $("#back").show();
  }
}

$(document).ready(function () {
  $("#helpTheory").css("display", "none");
  $("#solution").css("display", "none");
  $("#task-value").css("display", "none");
  $("#solve").css("display", "none");
  $("#checkAnswer").css("display", "none");
  $("#usedTheory").css("display", "none");
  $("#submit").css("display", "none");
  $("hr").css("display", "none");
  $("#checkTheory").css("display", "none");
  $("#retry").css("display", "none");
  $("#back").css("display", "none");
  getTask();
  getAllTheory();
});

$(document).on('click', '#help', function () {
  $("#helpTheory").show();
});

$(document).on('click', '#check', function () {
  $("#checkAnswer").show();
});

$(document).on('click', '#submit', function () {
  $("#checkTheory").show();
});

$(document).on('click', '#solve', function () {
  $("#solution").show();
  $("#task-value").show();
  $("#help").css("display", "none");
  $("#solve").css("display", "none");
  $("#check").css("display", "none");
  $("#back").show();
});

function getTask() {
  var taskId = window.location.pathname.split('/')[2];

  $.ajax({
    type: "POST",
    contentType: "application/json",
    url: "/tasks/task",
    data: "taskId:" + taskId,
    success: function (response) {
      $("#task").attr("value", response.taskId);
      $("#task-title").text(response.title);
      $("#task-content").text(response.content);
      $("#task-content").append("<input type=" + "text" + " id=" + "answer" + ">");
      $("#usedTheory").attr("class", response.theoreticalKnowledgeId);
      $("#solution").text(response.solutionContent);
      $("#task-value").text(response.solutionValue);
      getTheoryByTask(response.theoreticalKnowledgeId);
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

function getTheoryByTask(theoryId) {
  $.ajax({
    type: "POST",
    contentType: "application/json",
    url: "/theory/task",
    data: "id:" + theoryId,
    success: function (response) {
      $("#helpTheory>span").text(response.name);
    },
    error: function (e) {
      console.log("ERROR: ", e);
    }
  });

}