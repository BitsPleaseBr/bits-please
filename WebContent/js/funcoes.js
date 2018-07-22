$(document).ready(function(){
	
    //Máscaras
    
	$(".cpf").mask('000.000.000-00');
	$(".date").mask('00/00/0000');
	
    //Validações
    
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
	
	 var formConfirm = $("#modalConfirmacao");
	 formConfirm.validate({
	   rules: {
	     email: {
		   email: true,
	       equalTo: "#email"
		 },
		 pwsd: {
		   minlength: 6,
	       equalTo: "#pswd"
		 }
	   },
	   messages: {
	     email: {
	       required: "Temos que saber se você digitou certo",
	       email: "Lembra que é parecido com: david@dominio.com",
	       equalTo: "Seu e-mail tem que ser igual ao anterior"
		 },
		 pwsd: {
		   required: "Precisamos que você confirme a senha",
		   minlength: jQuery.validator.format("Lembra que são pelo menos {0} caracteres!"),
	       equalTo: "Tem que ser igual a de antes"
		 }
	   }
	 });	 
	    
	var formPaciente = $("#modalPaciente");
	formPaciente.validate({
	  rules: {
		cpf: {
 		  minlength: 11
 		},
		data: {
 		  date: true
 		},
		email: {
		  email: true
		},
 		senha: {
 		  minlength: 6
 		}
	  },
	  messages: {
		nome: "Hey, não esquece esse",
		sobrenome: "Esse também é importante",
		cpf: {
		  required: "Vazio aqui não pode hein",
		  minlength: "Lembrando que tem {0} digitos"
		},
		data: {
		  required: "Faltou esse aqui",
		  date: "Formato mm/dd/aaaa por favor"
		},
		email: {
	      required: "Precisamos do seu e-mail para entrar em contato contigo",
	      email: "Seu e-mail precisa ser parecido com esse: david@dominio.com"
		},
		senha: {
		  required: "A gente não da sua senha pra ninguém, esperamos que faça o mesmo.",
		  minlength: jQuery.validator.format("É necessário pelo menos {0} caracteres!")
		}
	  }
	});
    
    //Validar campos na redefinição
    
    $("#redefinir").click(function(){
    	if(formForget.valid()){
    	  $("#modal_esqueci").modal('hide');
          $("#modal_esqueci").on('hidden.bs.modal', function(){
            alert("Por favor verifique seu e-mail e redefina sua senha! :)");
          })
    	}
    })
    
    //Entrar no modal(popup) de cadastro

    $("#btn_cadastrar").focus(function(){
      $("#modal_login").modal("hide");
      $("#modal_cadastrar").modal("show");
      $("#modalPaciente").hide();
      $("#modalProfissional").hide();
	  $("#modalConfirmacao").hide();
    });
      
    $("#modal_esqueci").on('show.bs.modal', function(){
        $("#modal_login").modal('hide');
    })
    
    //Trocar formulários dependendo da Escolha (Paciente/Profissional)
    
    $('button[name="groups"]').on('click change', function(e) {
      if(e.currentTarget.id =="paciente") {
        $("#modalPaciente").show();
        $("#modalProfissional").hide();
      }else {
        $("#modalProfissional").show();
        $("#modalPaciente").hide();
      }
    });

    //Validar campos no cadastro e ir para confirmação
    
	$("#btn_proximo").click(function() {
	  if(formPaciente.valid()){
	    $("#modalPaciente").hide();
	    $("small").hide();
	    $("#escolha").hide();
	    $("#modalConfirmacao").show();
	  };
	});
    
    //Limpar campos no formulário
	  
	$("#btn_limpar").click(function(){
	  var validator = $("#modalPaciente").validate();
	  validator.resetForm();
	})
    
    //Validar campos e finalizar o cadastro
    
    $("#btn_finalizar").click(function(){
	  if(formConfirm.valid()){
	    $("#modal_cadastrar").modal('hide');
	    $("#modal_cadastrar").on('hidden.bs.modal', function(){
	      alert("Por favor verifique seu e-mail e confirme seu cadastro! :)");
	    })
	  }
	})
    
    //Voltar para a tela de cadastro e limpar o fomrulário

    $("#btn_voltar").focus(function(){
  	  var validator = $("#modalConfirmacao").validate();
  	  validator.resetForm();
  	  
      $("#modalConfirmacao").hide();
      $("#modalPaciente").show();
      $("small").show();
      $("#escolha").show();
      $('#modalConfirmacao').each (function(){
          this.reset();
      });
      $(this).blur();
    });
    
    //Resetar todos os modais(popup) caso um modal seja fechado

    $(".modal").on('hidden.bs.modal', function(){
	  
	  $(".modal-body input").val("");
	  
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
});