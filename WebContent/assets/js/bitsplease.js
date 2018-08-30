//Referente ao Login

//Função para deixar a imagem como wallpaper
function checkFullPageBackgroundImage() {
  $page = $('.full-page');
  image_src = $page.data('image');

  if (image_src !== undefined) {
    image_container = '<div class="full-page-background" style="background-image: url(' + image_src + ') "/>';
    $page.append(image_container);
  }
}

$(document).ready(function() {
	checkFullPageBackgroundImage();
	
	$('.nothing').load('includes/error.html');
    $('.Esqueci').load('includes/esquecisenhaModal.html');
	
	//Regras de validação do form de Login
	var formLog = $('.formLogin');
	formLog.validate({
		rules: {
			email: {
				email: true
			},
			senha: {
				minlength: 6
			}
		},
		messages: {
			email: {
				required: "Informe um email para podermos te encontrar aqui",
				email: "Lembrando que e-mails se parecem com: david@dominio.com"
			},
			senha: {
				required: "Por questões de segurança você tem que informar a sua senha, relaxa, ninguém tem acesso a ela",
				minlength: "A senha precisa ter pelo menos 6 caracteres beleza?"
			}
		}
	});
	  
	$("#btn_login").click(function() {
		if(formLog.valid()){
			$(".formLogin").submit();
			alert("Verificando...");
		}
	});
	
	
	//Referente ao cadastro
	
	//Mascáras dos campos
	$('.cpf').mask('000.000.000-00');
	$('.data').mask('00/00/0000');
	
	//Criação do Metódo de senha forte
	$.validator.addMethod("stgpass", function(value) {
		   return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) // Tem algum desses ai
		       && /[a-z]/.test(value) // Tem uma letra minúscula
		       && /[A-Z]/.test(value) // Tem uma letra maiúscula
		       && /\d/.test(value) // Tem um dígito
		},"É necessário pelo menos 1 dígito, 1 letra maiúscula e 1 minúscula!");
	
	//Função para verificar se o Email já existe no banco
    $.validator.addMethod("emailBanco", function(value, element) {
    	
    	var resultado = false;
    	var dados = "&email=" + value;
    	
    	$.ajaxSetup({async: false});
    	
    	$.ajax({
    		type: "POST",
    		url: "../acoes/verificarEmail.jsp",
    		data: dados,
    		success: function(data) {
    			if (data.trim() == "true") {
    				resultado = true;
    			}
    		}
    	});
    	
    	$.ajaxSetup({async: true});
    	
    	return resultado;
    });
    
    //Função para verificar se o CPF já existe no banco
    $.validator.addMethod("cpfBanco", function(value, element) {
    	
    	var resultado = false;
    	var dados = "&cpf=" + value;
    	
    	$.ajaxSetup({async: false});
    	
    	$.ajax({
    		type: "POST",
    		url: "../acoes/verificarCPF.jsp",
    		data: dados,
    		success: function(data) {
    			if (data.trim() == "true") {
    				resultado = true;
    			}
    		}
    	});
    	
    	$.ajaxSetup({async: true});
    	
    	return resultado;
    });
    
	//Regras de validação do form de Cadastro do Paciente
	var formCadPac = $('.formCadastroPaciente');
	formCadPac.validate({
		  rules: {
			  nome: {
				  letterswithbasicpunc: true
			  },
			  sobrenome: {
				  letterswithbasicpunc: true
			  },
			  cpf: {
				  cpfBR: true,
				  cpfBanco: true
			  },
			  data: {
				  dateITA: true
			  },
			  email: {
				  email: true,
				  emailBanco: true
			  },
			  senha: {
				  stgpass: true,
				  minlength: 8
			  }		  
		  },
		  messages: {
			  nome: {
				  required: "Por favor, precisamos saber como vamos chamar você",
				  letterswithbasicpunc: "Acredito que na sua certidão não tenha esses caracteres ai"
			  },
			  sobrenome: {
				  required: "Qualé, você preencheu o anterior, por que não esse?",
				  letterswithbasicpunc: "Acredito que na sua certidão não tenha esses caracteres ai"
			  },
			  cpf: {
					required: "Infelizmente não da pra deixar esse aqui em branco",
					cpfBR: "Tem 11 digítos aqui e cuidado para não errar nenhum",
					cpfBanco: "Já temos um cadastro utilizando esse cpf, contate-nos caso não saiba do que se trata"
			  },
			  data: {
				  required: "A gente precisa saber quando te parabenizar por mais um ano de vida!",
				  dateITA: "Deixando claro que a data precisa ter um formato dd/mm/aaaa beleza?"
			  },
			  email: {
		      	  required: "Precisamos do seu e-mail para entrar em contato contigo",
		      	  email: "Seu e-mail precisa ser parecido com esse: david@dominio.com",
		      	  emailBanco: "Esse e-mail já está sendo usado, se necessário peça uma redefinição de senha"
			  },
			  senha: {
				  required: "A gente não da sua senha pra ninguém, esperamos que faça o mesmo.",
				  stgpass: "É necessário pelo menos 8 caracteres, 1 dígito, 1 letra maiúscula e 1 minúscula!",
				  minlength: jQuery.validator.format("É necessário pelo menos {0} caracteres, 1 dígito, 1 letra maiúscula e 1 minúscula!")
			  }
		  }
	});
	
	//Regras de validação do form de Confirmação de Cadastro do Paciente
	var formConfPac = $('.formConfirmaçãoPaciente');
	formConfPac.validate({
		  rules: {
			  email: {
				  email: true,
				  equalTo: "#emailPac",
			  },
			  senha: {
				  stgpass: true,
				  minlength: 8,
				  equalTo: "#senhaPac"
			  }
		  },
		  messages: {
			  email: {
				  required: "Temos que ter certeza se nenhum engano foi cometido entende?",
		      	  email: "Lembrando que seu e-mail precisa ser parecido com esse: david@dominio.com",
				  equalTo: "Lembrando que tem que ser o mesmo e-mail que você colocou anteriormente"
			  },
			  senha: {
				  required: "Temos que certificar que não aconteceu nenhum engano anteriormente",
				  stgpass: "Lembrando que é necessário pelo menos 8 caracteres, 1 dígito, 1 letra maiúscula e 1 minúscula!",
				  minlength: jQuery.validator.format("Lembrando que é necessário pelo menos {0} caracteres, 1 dígito, 1 letra maiúscula e 1 minúscula!"),
				  equalTo: "Da uma olhada lá atrás, por que parece que as senhas informadas não são as mesmas :c"
			  }
		  }
	});
	
	$('#btn_cadastrar').click(function(){
		  if(formCadPac.valid()){
			$('#ConfirmModal').modal('show');
		  };
	});
	
	$('#btn_confirmar').click(function(){
		  if(formConfPac.valid()){
			if (($("input[name='termos']:checked").length)<=0) {
				alert("Precisamos saber se você chegou a ler nossos termos de uso");
			}else{
		  	  $('.formCadastroPaciente').submit();
		  	  alert('Enviamos um e-mail de confirmação para o seu e-mail, da um olhada lá, please ;)');
			};
		  };
	});
});

