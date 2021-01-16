var allEvents;
var top30events;
var eventTypes = new Set();
//menu
document.getElementById("a-events-top30").addEventListener("click", function(e)
{
    console.log("clickeddeded 30");
    document.getElementById("event-screen").style.display="none";
    document.getElementById("all-events").style.display="block";
    localStorage.setItem("active-events", "top30");
    console.log("active tab = ", localStorage.getItem("active-events"));
    getTop30Events();
});
document.getElementById("a-events-all").addEventListener("click", function(e)
{
    document.getElementById("event-screen").style.display="none";
    document.getElementById("all-events").style.display="block";
    localStorage.setItem("active-events", "all");
    console.log("active tab = ", localStorage.getItem("active-events"));
    getAllEvents();
});
// document.getElementById("a-events-top30").addEventListener("click", function(e)
// {
//     getTop30Events();
// });
//
$(document).ready(function () {
    getAllEvents();
    localStorage.setItem("active-events", "all");
    console.log(localStorage.getItem("active-events"));
    // var allDivs = document.getElementsByClassName("event-card");
    // for (let i = 0; i < allDivs.length; i++) {
    //     allDivs[i].addEventListener("click", function (e) {
    //         if (typeof (Storage) !== 'undefined') {
    //             console.log("BEFORE ", e.target.id);
    //             localStorage.setItem("chosenEvent", e.target.id);
    //             console.log("blaaaaaaaaa ", localStorage.getItem("chosenEvent"));
    //         }
    //     });
    // }
    // if (typeof (Storage) !== 'undefined') {

    //     if (localStorage.getItem("chosenEvent") !== null) {
    //         var eventId = localStorage.getItem("chosenEvent");
    //         console.log(eventId);
    //         getEventById(eventId); // returns eventId object - to load in new html page
    //         console.log(JSON.parse(localStorage.getItem("chosenEventObj")));
    //     }
    // }
}
);



function getAllEvents() {
    var deferred = $.Deferred();
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/all",
        success: function (events) {
            allEvents = events;
            displayEvents(events, "All events");
            // events.forEach(event => {
            //     console.log(event.eventId);
            // });
            deferred.resolve();
        },
        error: function (e) {
            allEvents = [];
            console.log("ERROR: ", e);
            deferred.resolve();
        }
    });
    return deferred.promise();
}

function getTop30Events() {
    var deferred = $.Deferred();
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/top30",
        success: function (events) {
            top30events = events;
            displayEvents(events, "Top 30 events");
            deferred.resolve();
            // events.forEach(event => {
            //     console.log(event);
            // });
        },
        error: function (e) {
            top30events = [];
            console.log("ERROR: ", e);
            deferred.resolve();
        }
    });
    return deferred.promise();
}

function getUpcomingEvents() {
    var activeObj = getActiveEventsFunction();    // var title = "";
    var eventsFunction = activeObj["functionName"];
    var title = activeObj["title"];
    var events = activeObj["events"];
    console.log("INSIDE UPCOMING", eventsFunction);
    // if(localStorage.getItem("active-events") == "top30")
    //    { eventsFunction = "getTop30Events";
    //     title = "Top 30 events";
    //    }
    // else
    //    { eventsFunction = "getAllEvents";
    //     title="All events";
    //    }

    $.when(
        window[eventsFunction]()
    ).done(function () {
        var sortedEvenets = events.sort((a, b) => new Date(a.startTime).getTime() - new Date(b.startTime).getTime());
        displayEvents(sortedEvenets, title);
        console.log(sortedEvenets);
    });
}

function getCheapestEvents() {
    var activeObj = getActiveEventsFunction();    // var title = "";
    var eventsFunction = activeObj["functionName"];
    var title = activeObj["title"];
    var events = activeObj["events"];
    console.log("INSIDE cheapest: ", eventsFunction);
    $.when(
        window[eventsFunction]()
    ).done(function () {
        var sortedEvenets = events.sort((a, b) => a.ticketPrice - b.ticketPrice);
        displayEvents(sortedEvenets, title);
        console.log(sortedEvenets);
    });
}
function getEventsByPrice(number) {
    // number = 1 - cheapest; 2 - most expensive
    var activeObj = getActiveEventsFunction();    // var title = "";
    var eventsFunction = activeObj["functionName"];
    var title = activeObj["title"];
    var events = activeObj["events"];
    console.log("INSIDE cheapest: ", eventsFunction);
    $.when(
        window[eventsFunction]()
    ).done(function () {
        var sortedEvenets = events.sort((a, b) => a.ticketPrice - b.ticketPrice); // cheapest default
        if(number == 2)
            sortedEvenets = events.sort((a, b) => b.ticketPrice - a.ticketPrice); //most expenisve

        displayEvents(sortedEvenets, title);
        console.log(sortedEvenets);
    });
}
// function getMostExpensiveEvents() {
//     var activeObj = getActiveEventsFunction();    // var title = "";
//     var eventsFunction = activeObj["functionName"];
//     var title = activeObj["title"];
//     console.log("INSIDE expensive: ", eventsFunction);
//     $.when(
//         window[eventsFunction]()
//     ).done(function () {
//         var sortedEvenets = allEvents.sort((a, b) => b.ticketPrice - a.ticketPrice);
//         displayEvents(sortedEvenets, title);
//         console.log(sortedEvenets);
//     });
// }

function getEventTypes() {
    $.when(
        getAllEvents()
    ).done(function () {
        allEvents.forEach(event => {
            eventTypes.add(event.type);
        });
        console.log(eventTypes);
    });
}

// this is used for filtering by type - just pass the type you filter by as an argument
function getEventByType(type) {
    var activeObj = getActiveEventsFunction();    // var title = "";
    var eventsFunction = activeObj["functionName"];
    var title = activeObj["title"];
    var events = activeObj["events"];
    console.log("INSIDE category: ", eventsFunction);
    $.when(
        window[eventsFunction]() //getAllEvents() or getTop30Events()
    ).done(function () {
        var filteredEvents = events.filter(event => event.type === type);
        displayEvents(filteredEvents, title);
        console.log(filteredEvents);
    });
}

function getEventById(id) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/" + id,
        success: function (event) {
            // localStorage.setItem('chosenEventId', id);
            console.log(event);
            localStorage.setItem('chosenEventObj', JSON.stringify(event));
            showEventScreen(event);
            // window.location.href = "/event-screen";

        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}
function showEventScreen(event) {
    currentId = event.eventId;
    console.log("eventid =", currentId)
    document.getElementById("all-events").style.display = "none";
    document.getElementById("event-screen").style.display = "block";
    document.getElementById("event-name").innerText = event.name;
    document.querySelector("#event-screen img").src = event.posterLocation;
    //popup elements
    document.getElementById("popup-event-name").innerHTML = "<b>" + event.name+ "</b>";
    document.getElementById("popup-event-price").innerHTML = "<b>$" + event.ticketPrice + "</b>";
    var type = event.type;

    //document.getElementById("type").innerHTML = type + event.type;
    var startTime = event.startTime;
    var duration = event.durationHours;
    var price = event.ticketPrice;
    getEventPerformers(currentId);
    getEventOrganizers(currentId);

    var ids = ["type", "start-time", "duration", "price"];
    var initialIdValues = [];
    var values = [type, startTime, duration, price];
    for (let i = 0; i < ids.length; i++) {
        initialIdValues[i] = document.getElementById(ids[i]).innerText; //e.g. Type: Performer: etc.
        document.getElementById(ids[i]).innerHTML = "<b>"+initialIdValues[i] + "</b> " + values[i];
        if(ids[i] == "duration")
        document.getElementById(ids[i]).innerHTML += " hours";
    }
}

function getEventPosterById(id) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/poster/" + id,
        success: function (response) {
            console.log(response);
            var image = new Image();
            image.src = 'data:image/jpg;base64,' + response.encodedImage;
            document.body.appendChild(image);
        },
        error: function (e) {
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
        success: function (user) {
            console.log(user);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

function getCurrentUserProfilePic() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/user/current/profile-pic/" + sessionStorage.getItem('username'),
        success: function (response) {
            console.log(response);
            var image = new Image();
            image.src = 'data:image/jpg;base64,' + response.encodedImage;
            document.body.appendChild(image);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

function getEventOrganizers(id) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/organizers/" + id,
        success: function (organizers) {
            var organizersStr = "<b>Organizers:</b> ";
            if (organizers.length) {
                for (let i = 0; i < organizers.length; i++) {
                    organizersStr += organizers[i].name;
                    if(i!= organizers.length-1)
                    organizersStr +=", ";
                }
            }
            document.getElementById("organizer").innerHTML = organizersStr;
            
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}

function getEventPerformers(id) {
    var performers = $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/events/performers/" + id,
        success: function (performers) {
            console.log(performers);
            var performersStr = "<b>Performers:</b> ";
            if (performers.length) {
                for (let i = 0; i < performers.length; i++) {
                    performersStr += performers[i].name;
                    if(i!= performers.length-1)
                    performersStr +=", ";
                }
            }
            document.getElementById("performer").innerHTML = performersStr;
        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
    return performers;
}


function displayEvents(events, h1_name) {
    removeExistingEvents();
    document.getElementById("h1_name").innerHTML = h1_name;
    document.getElementById("events-count").innerHTML = events.length + " events shown";
    const container = document.getElementById("events-container");
    const cols = 4;
    const rows = Math.ceil(events.length / cols);
    container.style.setProperty('--grid-rows', rows);
    container.style.setProperty('--grid-cols', cols);

    for (i = 0; i < events.length; i++) {
        let eventA = document.createElement('a');
        //  console.log("blaaa",events[i].eventId);

        //eventA.href = "/event";
        // eventA.addEventListener("click", function(e)
        // {
        //     if(typeof(Storage)!== 'undefined')
        //     {
        //         //localStorage.setItem("chosenEvent", events[i].eventId);
        //         //console.log(localStorage.getItem("chosenEvent"));
        //     }
        // });
        // eventA.classList.add('a-card');

        let eventDiv = document.createElement('div');
        //console.log("ID = ", events[i].eventId);
        eventDiv.id = events[i].eventId;
       // console.log("ID2 = ", eventDiv.id);
        eventDiv.className = 'event-card';
        let eventImg = document.createElement('img');
        eventImg.src = events[i].posterLocation;
       // console.log(eventImg.src);
        eventDiv.appendChild(eventImg);

        let eventName = document.createElement('p');
        let text = document.createTextNode(events[i].name.toUpperCase());
        eventName.appendChild(text);
        eventDiv.appendChild(eventName);

        let eventTime = document.createElement('p');
        let timeText = document.createTextNode(events[i].startTime);
        eventTime.appendChild(timeText);
        eventDiv.appendChild(eventTime);

        let eventPrice = document.createElement('p');
        let price = document.createTextNode("$"+events[i].ticketPrice);
        eventPrice.appendChild(price);
        eventDiv.appendChild(eventPrice);

        //eventA.appendChild(eventDiv);
        //container.appendChild(eventA);
        container.appendChild(eventDiv);

        eventDiv.addEventListener("click", function (e) {
            // if (typeof (Storage) !== 'undefined') {
            //console.log(e.target.id, "BEFORE ",e.target.id);
            //localStorage.setItem("chosenEvent", e.target.id);
            // console.log("blaaaaaaaaa ", localStorage.getItem("chosenEvent"));
            console.log(e.target.id);
            getEventById(e.target.id); // returns eventId object - to load in new html page

            // console.log('IDIDIDI',localStorage.getItem('chosenEventId'));
            //console.log('LOCAL ',JSON.parse(localStorage.getItem('chosenEventObj')));
            // }
        });
    }
    //var allEvents = document.getElementsByTagName('event-card');
    // Array.prototype.forEach.call(allEvents, doSomethingWithEachElement)
    // var allDivs = document.getElementsByClassName("event-card");
    // for (let i = 0; i < allDivs.length; i++) {
    //     var currentId = events[i].eventId;
    //     console.log(currentId," initialize");
    //     allDivs[i].addEventListener("click", function (e) {
    //         if (typeof (Storage) !== 'undefined') {
    //             console.log(currentId, "BEFORE ",e.target.id);
    //             localStorage.setItem("chosenEvent", currentId);
    //             console.log("blaaaaaaaaa ", localStorage.getItem("chosenEvent"));
    //         }
    //     });

    // }
}
function getActiveEventsFunction()
{
    var activeObj = {};
    var activeEvents = localStorage.getItem("active-events");
    if(activeEvents == "top30")
    {
        activeObj["functionName"] = "getTop30Events";
        activeObj["title"] = "Top 30 events";
        activeObj["events"] = top30events;
    } else
    {
        activeObj["functionName"] = "getAllEvents";
        activeObj["title"] = "All events";
        activeObj["events"] = allEvents;
    }

    console.log("active FUNC", activeObj["functionName"] );
    return activeObj;
}

function setCurrentOption(dropdown_id, option_id) {
  var functionName = getActiveEventsFunction()["functionName"];
  var title = getActiveEventsFunction().title;
    let currentOptionElement;
    var optionsArr = [];
    switch (dropdown_id) {
        case 1: {
            currentOptionElement = document.querySelectorAll(".dropdown-bar:nth-child(2) ul li:first-child a")[0];
            //optionsArr = ["Least recent","Most recent"];
            optionsArr = ["time_1"];
            break;
        }
        case 2: {
            currentOptionElement = document.querySelectorAll(".dropdown-bar:nth-child(3) ul li:first-child a")[0];
            //optionsArr = ["Highest to lowest","Lowest to highest"];
            optionsArr = ["price_1", "price_2"];
            break;
        }
        case 3: {
            currentOptionElement = document.querySelectorAll(".dropdown-bar:nth-child(4) ul li:first-child a")[0];
            //optionsArr = ["Least recent","Most recent"];
            optionsArr = ["category_1", "category_2", "category_3", "category_4"];
            break;
        }
    }
    
    //let currentOptionElement = document.querySelector(".dropdown-bar ul li a:first-child");
    let oldOption = currentOptionElement.textContent; //old user because will be replased with new current user
    //let saveBtn = document.getElementById("saveBtn");

    let oldOptionElement = document.getElementById(option_id);
    let currentOption = oldOptionElement.textContent;
    //console.log(currentOption);
    //console.log(currentOptionElement.textContent);
    console.log("filter byyy", currentOption);
    currentOptionElement.innerHTML = currentOption + '<i class="fa fa-angle-down"></i>';
    oldOptionElement.innerHTML = oldOption;
    if(dropdown_id == "1" && currentOption == "Upcoming events") //sorting by Upcoming events
    {
        console.log("time filtering");
        getUpcomingEvents();
    }
    if(dropdown_id == "1" && currentOption == "Time") //unsorting
    {
        console.log("time unfiltering");
        window[functionName](); //calling getTop30Events() or getAllEvents() according to option chosen by user
    }
    if(dropdown_id =="2" & currentOption == "Lowest to highest")
    {
        console.log("Price filtering - cheap");
        getEventsByPrice(1);
    }
    if(dropdown_id =="2" & currentOption == "Highest to lowest")
    {
        console.log("price filtering - expensive");
        getEventsByPrice(2); //calling getTop30Events() or getAllEvents() according to option chosen by user
    }
    if(dropdown_id =="2" & currentOption == "Price")
    {
        console.log("price unfiltering");
        window[functionName]() //calling getTop30Events() or getAllEvents() according to option chosen by user
    }
    switch(dropdown_id+'|'+currentOption)
    {
        case "3|Tech event": {console.log("Tech event filtering"); getEventByType("Tech event"); break;}
        case "3|Seminars": {console.log("Seminars filtering"); getEventByType("Seminars"); break;}
        case "3|Concert": {console.log("Concert filtering"); getEventByType("Concert"); break;}
        case "3|Music Festival": {console.log("Music festival filtering"); getEventByType("Music Festival"); break;}
        case "3|Category": {console.log("unfilter category"); window[functionName]();} //click Category - remove filter
    }
    
    // if(option_id)
}
function removeExistingEvents() {
    const container = document.getElementById("events-container");
    container.textContent = '';

}