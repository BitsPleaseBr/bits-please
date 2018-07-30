<%@ include file="includes/topo.jsp" %>

    <title>Inicio!!</title>
  </head>
  <body>
  
<!--Barra de navegação-->
      
  <nav class="navbar sticky-top navbar-expand navbar-light" style="background-color: #75aef9;">
  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
	  <span class="navbar-toggler-icon"></span>
 	</button>
     
      <!--Imagem Home-->
      
    <a class="navbar-brand" href="index.jsp">
      <img src="_img/icon.png" width="30" height="30" class="d-inline-block align-top" alt="Home">
      Home
    </a>
     
      <!--Conteudo-->
      
    <ul class="navbar-nav mr-auto">
     
     
    </ul>

      <!--Botão Login/Cadastro-->
      
    <form class="form-inline">
	  <button class="btn btn-danger" type="button" data-toggle="modal" data-target="#modal_login">
	    Acesse
	  </button>
    </form>
   </nav>  
      
<!--Modal(PopUp) de Login-->
      
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
      
<!--Modal(PopUp) de Redefinição de Senha-->
    
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
      
<!--Modal(PopUp) de Cadastro-->

    <div class="modal fade" id="modal_cadastrar">
  	  <div class="modal-dialog" id="dialog">
    	<div class="modal-content">
      	  <div class="modal-header">
        	<h5 class="modal-title">Cadastrar</h5>
        	<button type="button" class="close" data-dismiss="modal">
          	  <span aria-hidden="true">&times;</span>
      	    </button>
      	  </div>
      	  <div class="modal-body">
      	  <%@ include file="includes/cadastro/modalConfirmar.jsp" %>
            <p><small class="form-text text-muted">Vamos lá! Preencha o cadastro para começar a utilizar a HealthCore!</small></p>
            <form style="text-align: center" id="escolha">
              <p class="lead">Primeiro, se identifique:</p>
   			  <button type="button" class="btn btn-info" name="groups" id="paciente">Paciente</button>
   			  <button type="button" class="btn btn-info" name="groups">Profissional</button>
            </form>
            <p></p>
            <p></p>
            <%@ include file="includes/cadastro/modalProfissional.jsp" %>
            <%@ include file="includes/cadastro/modalPaciente.jsp" %>
            <div style="text-align: center" id="botoes">
				<button type="button" class="btn btn-success" id="btn_proximo">Próximo</button>
				<button type="reset" class="btn btn-light" id="btn_limpar">Limpar</button>
    		</div>
      	  </div>
        </div>
      </div>
    </div>
    
   <header>
       <img id="logo" alt="logo" src="_img/logo.png">
       
   </header>
    
        
    <main>
	
	
	</main>
	
	<footer>
	
	
	</footer>
          
          
    <script src="_js/funcoes.js" type="text/javascript"></script>
  </body>
</html>