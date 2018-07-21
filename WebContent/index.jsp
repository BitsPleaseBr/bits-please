<%@ include file="includes/topo.jsp" %>

    <title>Inicio!!</title>
  </head>
  <body>
  
  <nav class="navbar sticky-top navbar-expand navbar-light" style="background-color: #75aef9;">
  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
	  <span class="navbar-toggler-icon"></span>
 	</button>
     
    <a class="navbar-brand" href="teste.jsp">
      <img src="img/icon.png" width="30" height="30" class="d-inline-block align-top" alt="Home">
      Home
    </a>
     
    <ul class="navbar-nav mr-auto">
     
     
    </ul>

    <form class="form-inline">
	  <button class="btn btn-danger" type="button" data-toggle="modal" data-target="#modal_login">
	    Acesse
	  </button>
    </form>
   </nav>
      
   <header>
   </header>
    
	<div class="modal fade" id="modal_login" role="dialog">
  	  <div class="modal-dialog">
    	<div class="modal-content">
      	  <div class="modal-header">
        	<h5 class="modal-title">Login</h5>
        	<button type="button" class="close" data-dismiss="modal">
          	  <span>&times;</span>
      	    </button>
      	  </div>
      	  <div class="modal-body">
            <form>
              <div class="form-group">
              	<input type="email" class="form-control email" placeholder="E-mail" required>
              	<small class="form-text text-muted">Não compartilharemos seu e-mail com ninguém.</small>
              </div>
              <div class="form-group">
              	<input type="password" class="form-control" placeholder="Senha" required> 
              </div>
            </form>
            <button type="submit" class="btn btn-primary">Login</button>
			<button type="button" class="btn btn-primary" id="btn_cadastrar">
			Cadastrar-se
			</button>
			<br>
			<a data-target="#modal_esqueci" data-toggle="modal" href="#modal_esqueci">Esqueci minha senha</a>
		  </div>
        </div>
      </div>
    </div>
    
    <div class="modal fade" id="modal_esqueci">
  	  <div class="modal-dialog">
    	<div class="modal-content">
      	  <div class="modal-header">
        	<h5 class="modal-title">Redefinição de Senha</h5>
        	<button type="button" class="close" data-dismiss="modal">
          	  <span>&times;</span>
      	    </button>
      	  </div>
      	  <div class="modal-body">
            <form id="esqueci">
              <div class="form-group">
              	<input type="text" class="form-control cpf" placeholder="CPF" name="cpf" required>
              </div>
              <div class="form-group">
              	<input type="email" class="form-control email" placeholder="E-mail" name="email" required>
              	<small class="form-text text-muted">Você receberá uma mensagem para redefinir a senha.</small>
              </div>
            </form>
            <button type="button" class="btn btn-primary" id="redefinir">Enviar</button>
		  </div>
        </div>
      </div>
    </div>

    <div class="modal fade" id="modal_cadastrar">
  	  <div class="modal-dialog">
    	<div class="modal-content">
      	  <div class="modal-header">
        	<h5 class="modal-title">Cadastrar</h5>
        	<button type="button" class="close" data-dismiss="modal">
          	  <span aria-hidden="true">&times;</span>
      	    </button>
      	  </div>
      	  <div class="modal-body">
      	  <%@ include file="includes/modalConfirmar.jsp" %>
            <p><small class="form-text text-muted">Vamos lá! Preencha o cadastro para começar a utilizar a HealthCore!</small></p>
            <form style="text-align: center" id="escolha">
              <p class="lead">Primeiro, se identifique:</p>
   			  <button type="button" class="btn btn-info" name="groups" id="paciente">Paciente</button>
   			  <button type="button" class="btn btn-info" name="groups">Profissional</button>
            </form>
            <p></p>
            <p></p>
            <%@ include file="includes/modalProfissional.jsp" %>
            <%@ include file="includes/modalPaciente.jsp" %>
      	  </div>
        </div>
      </div>
    </div>
    
    
        
    <main>
	<img id="logo" alt="logo" src="img/logo.png">
	
	</main>
	
	<footer>
	
	
	</footer>
          
	<script>
      $(document).ready(function(){
    	  
    	$(".cpf").mask('000.000.000-00', {reverse: true});
    	$(".date").mask('00/00/0000', {reverse: true})
    	      	  
    	var form = $("#esqueci");
	    form.validate({
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
        
        $("#redefinir").click(function(){
        	if(form.valid()){
        	  $("#modal_esqueci").modal('hide');
              $("#modal_esqueci").on('hidden.bs.modal', function(){
                alert("Por favor verifique seu e-mail e redefina sua senha! :)");
              })
        	}
        })
        
        $('button[name="groups"]').on('click change', function(e) {
        
          if(e.currentTarget.id =="paciente") {
            $("#modalPaciente").show();
            $("#modalProfissional").hide();
          }else {
            $("#modalProfissional").show();
            $("#modalPaciente").hide();
          }
        });
      
        $(".modal").on('hidden.bs.modal', function(){
    	  
    	  $(".modal-body input").val("");
    	  
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
    </script>
  </body>
</html>