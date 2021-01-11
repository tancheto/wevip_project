function getAllEvents() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/all",
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