function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft = "0";
}

$(document).ready(function () {
  $("#subj").children().css("display", "none");
  $("#add").css("display", "none");
  openNav();
  getAllParts();
});

$(document).on('click', '.dropdown-item', function () {
  $("#myCarousel").css("display", "none");
  var target = $(this).attr('rel');
  var partId = $(this).attr('value');
  getDifficulties(partId, target);
  $("#" + target).show().siblings("div").hide();
  if (sessionStorage.getItem('name') === 'admin') {
    $("#add").show();
  } else {
    $("#add").css("display", "none");
  }
  document.getElementById("container-subjects").style.marginLeft = "20px";
});

$(document).on('click', '.taskType', function () {
  var target = $(this).attr('rel');
  var partId = $(this).attr('value');
  var difficultyId = $(this).attr('value');
  $("#" + target).show().siblings("div").hide();
  getTasks(partId, difficultyId, target);
});

function getAllParts() {
  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: "/parts/",
    success: function (response) {
      var list = "";
      var part = "dropdown-item";
      for (i in response) {
        list += "<a class=" + part + " rel= " + response[i].name + " value=" + response[i].partId + ">" + response[i].name + "</a>";
      }
      $("#mySidenav").append(list);
    },
    error: function (e) {
      console.log("ERROR: ", e);
    }
  });
}

function getDifficulties(partId, name) {
  $.ajax({
    type: "POST",
    contentType: "application/json",
    url: "/difficulties/",
    data: "id:" + partId,
    success: function (response) {
      $("#subj").empty();
      $("#subj").prepend("<div id=" + name + ">");
      var list = "<ul>";
      var difficulty = "taskType";
      var tab = "tab";
      for (i in response) {
        list += "<li><a class=" + difficulty + " rel= " + response[i].name + " value=" + response[i].difficultyId + " data-toggle=" + tab + ">" + response[i].name + "</a></li>";
      }
      $("#subj").prepend(list);
      var header = "<h3>" + name + "</h3>";
      $("#subj").prepend(header);
      $("#subj").prepend("</ul>");
      $("#subj").prepend("<hr/>");
      $("#subj").prepend("</div>");
      $("#subj>ul").attr("class", "nav-tabs nav");
    },
    error: function (e) {
      console.log("ERROR: ", e);
    }
  });
}

function getTasks(partId, difficultyId, name) {
  var formData = {
    part: partId,
    difficulty: difficultyId
  };

  $.ajax({
    type: "POST",
    contentType: "application/json",
    url: "/tasks/",
    data: JSON.stringify(formData),
    success: function (response) {
      var thumbnail = "thumbnail";
      for (i in response) {
        $("#tasksHardness").empty();
        var header = "<h3>" + response[i].title + "</h3>";
        var href = "/practice/" + response[i].taskId;
        var role = "button";
        var hidden = "true";
        var line = "<div id=" + name + "><div class=" + thumbnail + ">" + header + "<div><a href=" + href +
          " role=" + role + ">Решаване<i aria-hidden=" + hidden + "></i></a>";
        $("#tasksHardness").append(line);
        $("#tasksHardness").append("</div>");
        $("#tasksHardness").append("</div>");
        $("#tasksHardness").append("</div>");
        $(".thumbnail>div").attr("class", "text-bottom text-right");
        $(".thumbnail>div>a").attr("class", "btn-primary btn");
        $(".thumbnail>div>a>i").attr("class", "fa-arrow-right fa");
      }
    },
    error: function (e) {
      console.log("ERROR: ", e);
    }
  });
}