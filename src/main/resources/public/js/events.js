var allEvents;
var eventTypes = new Set();

function getAllEvents() {
    var deferred = $.Deferred();
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/all",
        success: function(events) {
            allEvents = events;
            events.forEach(event => {
                console.log(event);
            });
            deferred.resolve();
        },
        error: function(e) {
            allEvents = [];
            console.log("ERROR: ", e);
            deferred.resolve();
        }
    });
    return deferred.promise();
}

function getTop30Events() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/top30",
        success: function(events) {
            events.forEach(event => {
                console.log(event);
            });
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}

function getUpcomingEvents() {
    $.when(
        getAllEvents()
    ).done(function() {
        var sortedEvenets = allEvents.sort((a, b) => new Date(a.startTime).getTime() - new Date(b.startTime).getTime());
        console.log(sortedEvenets);
    });
}

function getCheapestEvents() {
    $.when(
        getAllEvents()
    ).done(function() {
        var sortedEvenets = allEvents.sort((a, b) => a.ticketPrice - b.ticketPrice);
        console.log(sortedEvenets);
    });
}

function getEventTypes() {
    $.when(
        getAllEvents()
    ).done(function() {
        allEvents.forEach(event => {
            eventTypes.add(event.type);
        });
        console.log(eventTypes);
    });
}

// this is used for filtering by type - just pass the type you filter by as an argument
function getEventByType(type) {
    $.when(
        getAllEvents()
    ).done(function() {
        var filteredEvents = allEvents.filter(event => event.type === type);
        console.log(filteredEvents);
    });
}

function getEventById(id) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/" + id,
        success: function(event) {
            console.log(event);
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}

function getEventPosterById(id) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/poster/" + id,
        success: function(response) {
            console.log(response);
            var image = new Image();
            image.src = 'data:image/jpg;base64,' + response.encodedImage;
            document.body.appendChild(image);
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}

function onFileUploadSubmit() {
    document.getElementById("username").value = sessionStorage.getItem('username');
}

$('#profile_pic_upload')
    .ajaxForm({
        url: '/file/upload',
        type: "POST",
        success: function(response) {
            alert("The server says: " + response);
        }
    });

function getCurrentUser() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/user/current/" + sessionStorage.getItem('username'),
        success: function(user) {
            console.log(user);
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}

function getCurrentUserProfilePic() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/user/current/profile-pic/" + sessionStorage.getItem('username'),
        success: function(response) {
            console.log(response);
            var image = new Image();
            image.src = 'data:image/jpg;base64,' + response.encodedImage;
            document.body.appendChild(image);
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}

function getEventOrganizers(id) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/organizers/" + id,
        success: function(organizers) {
            console.log(organizers);
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}

function getEventPerformers(id) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/performers/" + id,
        success: function(performers) {
            console.log(performers);
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}