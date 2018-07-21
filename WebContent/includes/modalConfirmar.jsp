<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<form id="modalConfirmacao" method="post">
	<p class="lead">Agora da uma confirmada nos dados de login:</p>
    <div class="form-group row">
        <label class="col-sm-1 col-form-label"><img id="icon" src="img/user.png" alt="user_icon"></img></label>
        <div class="col-sm-11">
            <input type="email" class="form-control" placeholder="E-mail" name="email" autocomplete="off" required>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-1 col-form-label"><img id="icon" src="img/key.png" alt="key_icon"></img></label>
        <div class="col-sm-11">
            <input type="password" class="form-control" placeholder="Senha" name="pwsd" required>
        </div>
    </div>
    <div style="text-align: center">
        <button type="button" class="btn btn-success" id="btn_finalizar">Finalizar</button>
		<button type="reset" class="btn btn-light" id="btn_voltar">Voltar</button>
    </div>
</form>

<script>
    $(document).ready(function(){
        
      var form = $("#modalConfirmacao");
	  form.validate({
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
        
      $("#btn_finalizar").click(function(){
        if(form.valid()){
          $("#modal_cadastrar").modal('hide');
          $("#modal_cadastrar").on('hidden.bs.modal', function(){
            alert("Por favor verifique seu e-mail e confirme seu cadastro! :)");
          })
        }
      })

      $("#btn_voltar").focus(function(){
        $("#modalConfirmacao").hide();
        $("#modalPaciente").show();
        $("small").show();
        $("#escolha").show();
        $('#modalConfirmacao').each (function(){
            this.reset();
        });
        $(this).blur();
      });
    });
</script>