function saveStorage(id){
	var a = document.getElementById(id);
	var str = a.value;
	sessionStorage.setItem('message',str);
}
function getStorage(id){
	var message = sessionStorage.getItem('message');
	var a = document.getElementById(id);
	a.value = message;
}
function cleanInput(id){
	var a = document.getElementById(id);
	a.value = '';
}

function saveStorage2(id){
	var a = document.getElementById(id);
	var str = a.value;
	localStorage.setItem('message2',str);
}
function getStorage2(id){
	var message = localStorage.getItem('message2');
	var a = document.getElementById(id);
	a.value = message;
	
}
function cleanInput2(id){
	var a = document.getElementById(id);
	a.value = '';
}