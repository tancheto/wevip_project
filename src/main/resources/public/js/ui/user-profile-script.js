
document.addEventListener("DOMContentLoaded", function(event){
	const allContainers = document.getElementsByClassName("category-content");
	//const container = document.getElementById("favourite-games");
	console.log(allContainers);
	
	const images = ["1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg"];//, "6.jpg", "7.jpg", "8.jpg", "9.jpg", "10.jpg", "11.jpg", "12.jpg", "13.jpg", "14.jpg", "15.jpg", "16.jpg", "17.jpg", "18.jpg", "19.jpg", "20.jpg", "21.jpg", "22.jpg", "23.jpg", "24.jpg", "25.jpg", "26.jpg", "27.jpg", "28.jpg", "29.jpg", "30.jpg"];
	const names=["Borderlands 2", "Draconball Z", "Zelda", "Ghost Recon", "Sims4"];//, "Tearaway", "Age of Empires II", "The Witcher", "Past Cure", "Red Dead Redemption II", "Call of Duty", "Final Fantasy VII", "Doom", "FarmVille", "Jedi", "Persona5", "Bloodhorne", "Daysgone", "Daysgone II", "NBA2K20", "Killzone", "Mortal Kombat II", "Outer Worlds", "Fallout 4", "Rocket League", "Cyberpunk", "Assassins Creed Odyssey", "FIFA20", "Spider-Man", "Final Fantasy V"];
	const times = ["20:59, 08/10/2021", "08:00, 02/01/2021", "18:32, 30/10/2021", "08:31, 10/03/2021", "13:35, 08/04/2021"];
	const prices = ["$34", "$61", "$87", "$72", "$13"];
	function makeRows(rows,cols,container){
		container.style.setProperty('--grid-rows', rows);
		container.style.setProperty('--grid-cols', cols);
	
		for(i = 0; i < (rows*cols); i++){
			let eventA =  document.createElement('a');
			eventA.href ="event-screen.html";
			eventA.classList.add('a-card');

			let eventDiv = document.createElement('div');
			eventDiv.className='event-card';
			let eventImg = document.createElement('img');
			eventImg.src="img/games-logos/" + images[i];
			console.log(eventImg.src);
			eventDiv.appendChild(eventImg);
	
			let eventName = document.createElement('p');
			let text = document.createTextNode(names[i].toUpperCase());
			eventName.appendChild(text);
			eventDiv.appendChild(eventName);

			let eventTime = document.createElement('p');
			let timeText = document.createTextNode(times[i]);
			eventTime.appendChild(timeText);
			eventDiv.appendChild(eventTime);

			let eventPrice = document.createElement('p');
			let price = document.createTextNode(prices[i]);
			eventPrice.appendChild(price);
			eventDiv.appendChild(eventPrice);

			eventA.appendChild(eventDiv);
			container.appendChild(eventA);
		};
	};
	for(let i=0; i<allContainers.length; i++)
	{makeRows(1,4, allContainers[i]);}
});


