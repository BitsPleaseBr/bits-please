function validaLogin(){

	var mensagem = document.getElementById("mensagem");
	var email = document.getElementById("email");
	var senha = document.getElementById("senha");

	if((email.value.length < 8) || (email.value.indexOf("@") == -1) || (email.value.indexOf(".") == -1)){
		
		mensagem.style.display = "block";
		
		mensagem.innerHTML = "Dados inserido de maneira indevida";
		
		email.focus();
		
		return false;
	}
	
	if(senha.value.lenght < 5){
		
		mensagem.style.display = "block";
		
		mensagem.innerHTML = "Dados inserido de maneira indevida";
		
		email.focus();
		
		return false;
	}
}