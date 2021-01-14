function ShowSaveConfirmation(){
	document.getElementById("save-info-message").style.visibility="visible";
}

function HideSaveConfirmation(){
	document.getElementById("save-info-message").style.visibility="hidden";
}

function getCurrentUser()
{
	return document.querySelector("#dropdown-bar ul li a:first-child").textContent;
}

function setCurrentUser(user_id){
	let currentUserElement = document.querySelector("#dropdown-bar ul li a:first-child");
	let oldUser = currentUserElement.textContent; //old user because will be replased with new current user
	let saveBtn = document.getElementById("saveBtn");
	
    let oldUserElement = document.getElementById(user_id);
	let currentUser = oldUserElement.textContent;
	console.log(currentUser);
	console.log(currentUserElement.textContent);
	currentUserElement.innerHTML = currentUser + '<i class="fa fa-angle-down"></i>';
	oldUserElement.innerHTML = oldUser;

	let mainAccountOptions = document.querySelectorAll("#left-section ul li:nth-child(5), #left-section ul li:nth-child(6)");
	let mainAccountSections = document.querySelectorAll("#main-section-div > section > div:nth-child(5), #main-section-div > section > div:nth-child(6)");
	if(!checkIfMainAccount())
		{

			if(mainAccountOptions[0].querySelector("a").classList.contains("activeli") || mainAccountOptions[1].querySelector("a").classList.contains("activeli"))
			{
				saveBtn.style.visibility = 'hidden';
			}
			for(let i=0;i<2;i++)
			{
				console.log(mainAccountOptions[i]);
				mainAccountOptions[i].style.visibility = "hidden";
				mainAccountSections[i].style.visibility = "hidden";
			}
		} else
			{
				for(let i=0;i<2;i++)
					{
						console.log(mainAccountOptions[i]);
						mainAccountOptions[i].style.visibility = "visible";
						mainAccountSections[i].style.visibility = "visible";
					}
			
			}
}
function startFunc()
{
		document.addEventListener('DOMContentLoaded', (event) => {
	let subsectionList= document.querySelectorAll("#manage-profiles-section > div");
	for(let i=0;i<subsectionList.length;i++)
	{
		subsectionList.style.display="none";
	}});
}
