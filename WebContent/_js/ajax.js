function verificarEmail(email) {
	
	var dados = "&email=" + email;
	var resultado = false;
	
	alert(dados);
	
	$.ajax({
		
		type: "POST",
		url: "_acoes/verificarEmail.jsp",
		data: dados,
		success: function(data) {
			
			resultado = data;
		}
	});
	
	return resultado;
}

$(document).ready(function() {
	
	alert("teste");
	alert(verificarEmail("teste@teste.teste8"));
});