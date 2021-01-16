var style = document.createElement('style');
style.innerHTML =
	"#users-container a i{"
	+"margin-left: 10px;"
  	+"margin-bottom: 20px;"
	+"float:left;}"
; 

var ref = document.querySelector('script');
document.addEventListener("DOMContentLoaded", function(event){
	const container = document.getElementById("users-container");
	console.log(container);

	const icon_classes= ["far fa-eye", "fas fa-plus", "fas fa-ban","fas fa-exclamation-triangle"];
	const a_text = ["View profile", "Add friend", "Block user", "Report user"];
	function makeRows(rows,cols){
		container.style.setProperty('--grid-rows', rows);
		container.style.setProperty('--grid-cols', cols);
	
		for(i = 0; i < (rows*cols); i++){
			let userA = document.createElement('a');
			userA.href = "user-profile.html";
			let userDiv = document.createElement('div');
			userDiv.className='user-card';
			let userImg = document.createElement('img');
			userImg.src="img/users/" + (i+1) + ".png";
			console.log(userImg.src);
			userDiv.appendChild(userImg);

			let userName = document.createElement('p');
			let userNameText = "user_" + (i+1); 
			let text = document.createTextNode(userNameText);
			userName.appendChild(text);
			userDiv.appendChild(userName);

			//let optionsDiv = document.createElement("div");

			// let button = document.createElement('button');
			// button.innerHTML='<p><i class="far fa-eye fa-2x"></i>View profile</p>';
			// button.className="btn-play";
            // button.id="btn_"+(i+1);
			// button.setAttribute("title", "View profile");
            // button.onclick = function(){location.href="user-profile.html";};
			// userDiv.appendChild(button);
			userA.appendChild(userDiv);
			container.appendChild(userA);
		};
	};

	makeRows(10,4);
});

