$(document).ready(function(){
	
	//Variáveis
	var formulario = -1;
	
    //Máscaras
    
	$(".cpf").mask('000.000.000-00');
	$(".date").mask('00/00/0000');
	$('.cep').mask('00000-000');
	$('.cel').mask('(00) 00000-0000');
	$('.tel').mask('(00) 0000-0000');
	$('.crm').mask('0000000');
	$('.num').mask('00000');
	
    //Validações
    
	var formLogin = $("#modalLogin");
	formLogin.validate({
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
				required: "Informe um email para te identificar",
				email: "Lembrando que e-mails se parecem com: david@dominio.com"
			},
			senha: {
				required: "Por questões de segurança você tem que informar a sua senha, relaxa, ninguém tem acesso a ela"
			}
		}
	})
	
	var formForget = $("#esqueci");
    formForget.validate({
    	rules: {
    		email: {
    			email: true
    		}
    	},
    	messages: {
    		cpf: "Precisamos identificar quem é você",
    		email: {
    			required: "Precisamos do seu e-mail para enviar a redefinição",
    			email: "Lembrando que tem que se parecer com: david@dominio.com"
    		}
    	}
    });
    
	 var formProfissional = $("#modalProfissional");
	 formProfissional.validate({
		 rules:{
			 data: {
				 date: false,
				 dateITA: true
	 			
			 },
			 celular:{
					minlength: 15 
			 },
			 telefone:{
				minlength: 14 
			 },
			 emailPro: {
				 email: true
			 },
			 senhaPro: {
				 minlength: 6
			 }
		 },
		 messages:{
			 nome: "Obrigatório",
			 sobrenome: "Obrigatório",
			 cpf: "Obrigatório",
			 data: "Obrigatório",
			 celular: "Obrigatório",
			 crm: "Obrigatório",
			 uf: "Obrigatório",
			 especializacao: "Obrigatório",
			 telefone: "Obrigatório",
			 cepResi: "Obrigatório",
			 bairroResi: "Obrigatório",
			 cidadeResi: "Obrigatório",
			 ufResi: "Obrigatório",
			 ruaResi: "Obrigatório",
			 numeroResi: "Obrigatório",
			 cepCome: "Obrigatório",
			 bairroCome: "Obrigatório",
			 cidadeCome: "Obrigatório",
			 ufCome: "Obrigatório",
			 ruaCome: "Obrigatório",
			 numeroCome: "Obrigatório",
			 emailPro: {
				 required: "Precisamos do seu e-mail para entrar em contato contigo",
				 email: "Seu e-mail precisa ser parecido com esse: david@dominio.com"
			 },
			 senhaPro: {
				 required: "A gente não da sua senha pra ninguém, esperamos que faça o mesmo.",
				 minlength: jQuery.validator.format("É necessário pelo menos {0} caracteres!")
			 }
		 }
	 })
  
	var formPaciente = $("#modalPaciente");
	formPaciente.validate({
	  rules: {
		data: {
		  date: false,
		  dateITA: true
 		},
		emailPac: {
		  email: true
		},
 		senhaPac: {
 		  minlength: 6
 		}
	  },
	  messages: {
		nome: "Hey, não esquece esse",
		sobrenome: "Esse também é importante",
		cpf: "Vazio aqui não pode hein",
		data: {
		  required: "Faltou esse aqui",
		  dateITA: "Formato dd/mm/aaaa por favor"
		},
		emailPac: {
	      	  required: "Precisamos do seu e-mail para entrar em contato contigo",
	      	  emailPac: "Seu e-mail precisa ser parecido com esse: david@dominio.com"
		},
		senhaPac: {
		  required: "A gente não da sua senha pra ninguém, esperamos que faça o mesmo.",
		  minlength: jQuery.validator.format("É necessário pelo menos {0} caracteres!")
		}
	  }
	});

	 var formConfirm = $("#modalConfirmacao");
	 formConfirm.validate({
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
	       required: "Temos que saber se você digitou certo",
	       email: "Lembra que é parecido com: david@dominio.com"
		 },
		 senha: {
		   required: "Precisamos que você confirme a senha",
		   minlength: jQuery.validator.format("Lembra que são pelo menos {0} caracteres!")
		 }
	   }
	 });
	 
	 function validarForm(){
		 EmailPac = document.getElementById('emailPac').value;
	     SenhaPac = document.getElementById('senhaPac').value;
	     
		 EmailPro = document.getElementById('emailPro').value;
	     SenhaPro = document.getElementById('senhaPro').value;
	     
	     EmailConf = document.getElementById('emailConf').value;
	     SenhaConf = document.getElementById('senhaConf').value;
	     
	     if (((EmailPac == EmailConf) || (EmailPro == EmailConf)) && ((SenhaPac == SenhaConf) || (SenhaPro == SenhaConf))){ 
	    	 return true;
	     }else{
	    	 alert("Dados Divergentes!!");
	    	 return false;
	     }
	 }
	 
	$('div[id="textos"] input').on("input", function(){
	  var regexp = /[^a-záàâãéèêíïóôõöúçñ ]+$/gi;
	  if(this.value.match(regexp)){
	    $(this).val(this.value.replace(regexp,''));
	  }
	});
	
	//Validar campos no Login
	
	$("#btn_login").click(function(){
		if(formLogin.valid()){
		  $("#modalLogin").submit();
    	  $("#modal_login").modal('hide');
          $("#modal_login").on('hidden.bs.modal', function(){
            alert("Entrado xD");
          })
		}
	})
	
    //Validar campos na redefinição
    
    $("#redefinir").click(function(){
    	if(formForget.valid()){
    	  $("#modal_esqueci").modal('hide');
          $("#modal_esqueci").on('hidden.bs.modal', function(){
            alert("Por favor verifique seu e-mail e redefina sua senha! :)");
          })
    	}
    })
    
    
    //Validar Cpf
    
    jQuery.validator.addMethod("cpf", function(value, element) {
    	value = jQuery.trim(value);

    	value = value.replace('.','');
    	value = value.replace('.','');
    	cpf = value.replace('-','');
    	while(cpf.length < 11) cpf = "0"+ cpf;
    	var expReg = /^[\d]{11}$/;
    	var a = [];
    	var b = new Number;
    	var c = 11;
    	for (i=0; i<11; i++){
    		a[i] = cpf.charAt(i);
    		if (i < 9) b += (a[i] * --c);
    	}
    	if ((x = b % 11) < 2) { a[9] = 0 } else { a[9] = 11-x }
    	b = 0;
    	c = 11;
    	for (y=0; y<10; y++) b += (a[y] * c--);
    	if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }

    	var retorno = true;
    	if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10]) || cpf.match(expReg)) retorno = false;

    	return this.optional(element) || retorno;

    }, "Informe um CPF válido");
    
    //Buscar CEP Residencial
    
    function limpa_formulário_cepResi() {
        // Limpa valores do formulário de cep.
        $("#bairroResi").val("");
        $("#cidadeResi").val("");
        $("#ufResi").val("");
        $("#ruaResi").val("");
    }
    
    //Quando o campo cep perde o foco.
    $("#cepResi").blur(function() {

        //Nova variável "cep" somente com dígitos.
        var cep = $(this).val().replace(/\D/g, '');

        //Verifica se campo cep possui valor informado.
        if (cep != "") {

            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;

            //Valida o formato do CEP.
            if(validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                $("#bairroResi").val("...");
                $("#cidadeResi").val("...");
                $("#ufResi").val("...");
                $("#ruaResi").val("...");
                
                //Consulta o webservice viacep.com.br/
                $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                    if (!("erro" in dados)) {
                        //Atualiza os campos com os valores da consulta.
                        $("#bairroResi").val(dados.bairro);
                        $("#cidadeResi").val(dados.localidade);
                        $("#ufResi").val(dados.uf);
                        $("#ruaResi").val(dados.logradouro);
                    } //end if.
                    else {
                        //CEP pesquisado não foi encontrado.
                        limpa_formulário_cep();
                        alert("CEP não encontrado.");
                    }
                });
            } //end if.
            else {
                //cep é inválido.
                limpa_formulário_cepResi();
                alert("Formato de CEP inválido.");
            }
        } //end if.
        else {
            //cep sem valor, limpa formulário.
            limpa_formulário_cepResi();
        }
    });

    //Buscar CEP Comercial
    
    function limpa_formulário_cepCome() {
        // Limpa valores do formulário de cep.
        $("#bairroCome").val("");
        $("#cidadeCome").val("");
        $("#ufCome").val("");
        $("#ruaCome").val("");
    }
    
    //Quando o campo cep perde o foco.
    $("#cepCome").blur(function() {

        //Nova variável "cep" somente com dígitos.
        var cep = $(this).val().replace(/\D/g, '');

        //Verifica se campo cep possui valor informado.
        if (cep != "") {

            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;

            //Valida o formato do CEP.
            if(validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                $("#bairroCome").val("...");
                $("#cidadeCome").val("...");
                $("#ufCome").val("...");
                $("#ruaCome").val("...");
                
                //Consulta o webservice viacep.com.br/
                $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                    if (!("erro" in dados)) {
                        //Atualiza os campos com os valores da consulta.
                        $("#bairroCome").val(dados.bairro);
                        $("#cidadeCome").val(dados.localidade);
                        $("#ufCome").val(dados.uf);
                        $("#ruaCome").val(dados.logradouro);
                    } //end if.
                    else {
                        //CEP pesquisado não foi encontrado.
                        limpa_formulário_cep();
                        alert("CEP não encontrado.");
                    }
                });
            } //end if.
            else {
                //cep é inválido.
                limpa_formulário_cepCome();
                alert("Formato de CEP inválido.");
            }
        } //end if.
        else {
            //cep sem valor, limpa formulário.
            limpa_formulário_cepCome();
        }
    });
    
    //Entrar no modal(popup) de cadastro

    $("#btn_cadastrar").click(function(){
      $("#modal_login").modal("hide");
      $("#modal_cadastrar").modal("show");
      $("#modalPaciente").hide();
      $("#modalProfissional").hide();
	  $("#modalConfirmacao").hide();
	  $("#botoes").hide();
    });
      
    $("#modal_esqueci").on('show.bs.modal', function(){
        $("#modal_login").modal('hide');
    })
    
    //Trocar formulários dependendo da Escolha (Paciente/Profissional)
    
    $('button[name="groups"]').on('click change', function(e) {
      
      $("#botoes").show();
    	
      if(e.currentTarget.id =="paciente") {
        $("#modalPaciente").show();
        $("#modalProfissional").hide();
        $("#dialog").removeClass("modal-lg");
        $("#email").removeClass("col-md-6");
        $("#senha").removeClass("col-md-6");
        formulario = 0;
      }else {
        $("#dialog").addClass("modal-lg");
        $("#email").addClass("col-md-6");
        $("#senha").addClass("col-md-6");
        $("#modalProfissional").show();
        $("#modalPaciente").hide();
        formulario = 1;
      }
    });

    //Validar campos no cadastro e ir para confirmação
    
	$("#btn_proximo").click(function() {
	  
	  if($("#modalPaciente").is(':visible')){
	    if(formPaciente.valid()){
	      $("#modalPaciente").hide();
	      $("small").hide();
	      $("#escolha").hide();
	      $("#botoes").hide();
	      $("#modalConfirmacao").show();
	    }
	  }else if($("#modalProfissional").is(':visible')){
		if(formProfissional.valid()){
	      $("#modalProfissional").hide();
	      $("small").hide();
	      $("#escolha").hide();
	      $("#botoes").hide();
	      $("#dialog").removeClass("modal-lg");
	      $("#modalConfirmacao").show();
	    };
	  }
	});
    
    //Limpar campos no formulário
	  
	$("#btn_limpar").click(function(){
	  $("#modalPaciente")[0].reset();
	  $("#modalProfissional")[0].reset();
	  
	  var form1 = $("#modalPaciente").validate();
	  form1.resetForm();
	  var form2 = $("#modalProfissional").validate();
	  form2.resetForm();
	})
    
    //Validar campos e finalizar o cadastro
    
    $("#btn_finalizar").click(function(){
	  if(formConfirm.valid()){
		if(validarForm()){
	      $("#modal_cadastrar").modal('hide');
	      $("#modal_cadastrar").on('hidden.bs.modal', function(){
	        alert("Por favor verifique seu e-mail e confirme seu cadastro! :)");
	      })
	      if (formulario == 0) {
	    	$("#modalPaciente").submit();
	      } else {
	    	$("#modalProfissional").submit();
	      }
	    }
	  }
	})
    
    //Voltar para a tela de cadastro e limpar o fomrulário

    $("#btn_voltar").focus(function(){
  	  var validator = $("#modalConfirmacao").validate();
  	  validator.resetForm();
  	  
  	  if($("#modalPaciente").is(':visible')){
        $("#modalConfirmacao").hide();
        $("#modalPaciente").show();
        $("small").show();
        $("#escolha").show();
        $("#botoes").show();
        $('#modalConfirmacao').each (function(){
          this.reset();
        });
        $(this).blur();
  	  }else if($("#modalProfissional").is(':visible')){
        $("#modalConfirmacao").hide();
        $("#modalProfissional").show();
        $("small").show();
        $("#escolha").show();
        $("#botoes").show();
        $('#modalConfirmacao').each (function(){
          this.reset();
        });
        $(this).blur();
  	  }
    });
    
    //Resetar todos os modais(popup) caso um modal seja fechado

    $(".modal").on('hidden.bs.modal', function(){
	  
	  $(".modal-body input").val("");
      $("#dialog").removeClass("modal-lg");
	  
	  var validator = $("#modalConfirmacao").validate();
  	  validator.resetForm();
  	  var validator = $("#modalPaciente").validate();
	  validator.resetForm();
	  var validator = $("#modalProfissional").validate();
  	  validator.resetForm();
  	  var validator = $("#esqueci").validate();
	  validator.resetForm();
	  var validator = $("#modalProfissional").validate();
	  validator.resetForm();
  	  
      if($("#modalConfirmacao").show()){
        $("#modalConfirmacao").hide();
        $("small").show();
		$("#escolha").show();
	  }else if(($("#modalPaciente").show()) || ($("#modalProfissional").show())){
        $(this).hide();
      }
    
      $("#modal_cadastrar").off('hidden.bs.modal');
    });
    
    //Adiciona action ao botão de login para efetuar o login
    $("#botao_login").click(function() {
    	
    	$("#modalLogin").submit();
    });
});
