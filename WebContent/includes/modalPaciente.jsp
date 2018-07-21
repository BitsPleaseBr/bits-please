<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<form id="modalPaciente" method="get">
    <p class="lead" style="font-size: 17px">Beleza, agora você coloca seus dados pessoais:</p>
    <div class="form-row">
        <div class="form-group col-md-6">
            <input type="text" class="form-control" name="nome" placeholder="Nome" required>
        </div>
        <div class="form-group col-md-6">
            <input type="text" class="form-control" name="sobrenome" placeholder="Sobrenome" required>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <input type="text" class="form-control cpf" name="cpf" placeholder="CPF" required>
        </div>
        <div class="form-group col-md-6">
			<input type="datetime" class="form-control date" name="data" placeholder="Data de Nascimento" required>
    	</div>
    </div>
    <p class="lead" style="font-size: 17px">Aqui vão seus dados para realizar o login:</p>
    <div class="form-group">
        <input type="email" class="form-control" name="email" placeholder="E-mail" id="email" required>
    </div>
    <div class="form-group">
        <input type="password" class="form-control" name="senha" placeholder="Senha" id="pswd" required>
    </div>
    <div style="text-align: center">
		<button type="button" class="btn btn-success" id="btn_proximo">Próximo</button>
		<button type="reset" class="btn btn-light" id="btn_limpar">Limpar</button>
    </div>
</form>

<script>
	$(document).ready(function(){

	  var form = $("#modalPaciente");
	  form.validate({
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

	  $("#btn_proximo").click(function() {
	    if(form.valid()){
	      $("#modalPaciente").hide();
	      $("small").hide();
	      $("#escolha").hide();
	      $("#modalConfirmacao").show();
	    };
	  });
	});
</script>