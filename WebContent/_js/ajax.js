function verificarEmail(email) {
	
	var respondido = false;
	var dados = "&email=" + email;
	var resultado = false;
	
	$.ajax({
		
		type: "POST",
		url: "_acoes/verificarEmail.jsp",
		data: dados,
		success: function(data) {
			
			resultado = data;
			respondido = true;
		}
	});
	
	while (!respondido) {}
	
	return resultado;
}

function verificarCPF(cpf) {
	
	var respondido = false;
	var dados = "&cpf=" + cpf;
	var resultado = false;
	
	$.ajax({
		
		type: "POST",
		url: "_acoes/verificarCPF.jsp",
		data: dados,
		success: function(data) {

			resultado = data;
			respondido = true;
		}
	});
	
	while (!respondido) {}
	
	return resultado;
}

$(document).ready(function() {
	
	alert("CPF válido: " + verificarCPF("222.222.222-22"));
});