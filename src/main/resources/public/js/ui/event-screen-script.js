var successfulMessage = document.querySelector("#confirmation-popup .popup-content > p").innerText;
function showPopup(popup_id) {
  var ticketBought = JSON.parse(localStorage.getItem('chosenEventObj'));//when calling getEventById everytime item is clicked, once it is bought it can be retrieved from here
  var currentUserTickets = JSON.parse(localStorage.getItem("userTickets"));

  var flag = false;
  for (let i = 0; i < currentUserTickets.length; i++) {
    if (ticketBought.eventId == currentUserTickets[i].eventId)
      flag = true;
  }
  if (!flag) {
    document.querySelector("#confirmation-popup h1").innerText = "Done";
    document.querySelector("#confirmation-popup .popup-content > p").innerText = successfulMessage;
    currentUserTickets.push(ticketBought);
    localStorage.setItem("userTickets", JSON.stringify(currentUserTickets));
    console.log("tickets reg: ", currentUserTickets);
    console.log("TICKETS LOCALTORAGE: ", JSON.parse(localStorage.getItem("userTickets")));
  }
  if (flag) {
    document.querySelector("#confirmation-popup h1").innerText = "Error";
    document.querySelector("#confirmation-popup .popup-content > p").innerText = "You have already bought ticket for this event. Check your events in \"My collection\" section";
  }

  //show popup
  document.getElementById(popup_id).style.visibility = "visible";
  document.getElementsByClassName("fullscreen-container")[0].style.display = "block";
}
function closePopup(popup_id) {
  document.getElementById(popup_id).style.visibility = "hidden";
  document.getElementsByClassName("fullscreen-container")[0].style.display = "none";
}