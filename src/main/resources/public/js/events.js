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