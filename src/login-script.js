function showPopup(popup_id)
{
	document.getElementById(popup_id).style.visibility="visible";
	document.getElementsByClassName("fullscreen-container")[0].style.display="block";
}
function closePopup(popup_id){
document.getElementById(popup_id).style.visibility="hidden";
document.getElementsByClassName("fullscreen-container")[0].style.display="none";
}

function loginOptions()
{
    var username = document.getElementById("nickname");
    var password = document.getElementById("password");

    if(username.value=="admin" && password.value == "admin")
    {
        location.href='admin.html';
    }
    else
    {
        location.href='all-events.html';
    }
}
