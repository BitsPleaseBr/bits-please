<%@include file = "includes/topo.jsp" %>

  <title>
    Cadastrar
  </title>
</head>

<body class="register-page">

  <%@include file="includes/navbar.jsp" %>
  		<button type="button" style="margin-left: 50px" class="btn btn-success btn-round" onclick="location.href='login.jsp'">Acesse</button>
      </div>
    </div>
  </nav>
  <!-- End Navbar -->

  <%@include file="includes/fullpage.jsp" %>

	  <div class="content">
        <div class="container">
          <div class="row">
            <div class="col-lg-5 col-md-5 ml-auto">
            
              <div class="info-area info-horizontal mt-5">
                <div class="icon icon-primary">
                  <i class="nc-icon nc-ambulance"></i>
                </div>
                <div class="description">
                  <h5 class="info-title">Sistema de Suporte a Sa�de</h5>
                  <p class="description">
                    A ideia � facilitar sua vida deixando a gest�o da sua sa�de muito mais simples e com alguns cliques voc� conseguir� agendar consultas e observando os seus diagn�sticos.
                  </p>
                </div>
              </div>
              
              <div class="info-area info-horizontal">
                <div class="icon icon-primary">
                  <i class="nc-icon-other nc-lock"></i>
                </div>
                <div class="description">
                  <h5 class="info-title">Seguran�a</h5>
                  <p class="description">
                    Mantemos seus registros o mais seguro cumprindo sempre com a lei de sigilo m�dico - paciente!
                  </p>
                </div>
              </div>
              
              <div class="info-area info-horizontal">
                <div class="icon icon-info">
                  <i class="nc-icon nc-paper"></i>
                  <i class="nc-icon nc-simple-remove"></i>
                </div>
                <div class="description">
                  <h5 class="info-title">Socioambiental</h5>
                  <p class="description">
                    Um dia voc� j� pensou "Por que em pleno s�culo 21 eu tenho que ficar carregando toda essa papelada por ai quando tenho um computador no meu bolso?" estamos aqui para acabar com esse paradigma ;)
                  </p>
                </div>
              </div>
            </div>
            
            <!-- Card do Form de Registrar -->
            <div class="col-lg-4 col-md-6 mr-auto">
              <div class="card card-signup text-center">
                <div class="card-header ">
                  <h4 class="card-title">Cadastre-se</h4>
                </div>
				<small class="text-right" style="margin-right: 5%"><a href="cadastrarprofissional.jsp">Voc� um M�dico? Chega mais</a></small>
                <div class="card-body ">
                  <form class="formCadastroPaciente" method="post" action="../../acoes/cadastrarPaciente.jsp">
                    <div class="input-group">
                    
                      <div class="input-group-prepend">
                        <span class="input-group-text">
                          <i class="nc-icon nc-single-02"></i>
                        </span>
                      </div>
                      <input type="text" name="nome" class="form-control" placeholder="Nome...">
                    </div>
                    
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text">
                          <i class="nc-icon nc-circle-10"></i>
                        </span>
                      </div>
                      <input type="text" name="sobrenome" class="form-control" placeholder="Sobrenome...">
                    </div>
                    
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text">
                          <i class="nc-icon nc-badge"></i>
                        </span>
                      </div>
                      <input type="text" name="cpf" class="form-control cpf" placeholder="CPF..." maxlength="14" autocomplete="off">
                    </div>

                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text">
                          <i class="nc-icon-other nc-gift-2"></i>
                        </span>
                      </div>
                      <input type="text" name="data" class="form-control data" placeholder="Data de Nascimento..." maxlength="10" autocomplete="off">
                    </div>

                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text">
                          <i class="nc-icon nc-email-85"></i>
                        </span>
                      </div>
                      <input type="email" name="email" id="emailPac" class="form-control" placeholder="Email...">
                    </div>
                    
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <span class="input-group-text">
                          <i class="nc-icon nc-key-25"></i>
                        </span>
                      </div>
                      <input type="password" name="senha" id="senhaPac" class="form-control" placeholder="Senha...">
                    </div>
                  </form>
                </div>
				<small class="text-left" style="margin-left: 5%"><a href="#confirma��o" data-toggle="modal" data-target="#EsqueciModal">Esqueceu sua senha?</a></small>
                <div class="card-footer">
                  <button type="button" class="btn btn-primary btn-round" id="btn_cadastrar">Confirmar Dados</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      <div class="modal fade modal-primary" id="ConfirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-login">
	      <div class="modal-content">
	        <div class="card card-login card-plain">
	          <div class="modal-header justify-content-center">
	            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	              <span aria-hidden="true">�</span>
	            </button>
	  
	            <div class="header header-primary text-center">
	              <div class="logo-container">
	                  <img src="../../assets/img/brand.png" alt="S2 sa�de" style="width: 20%;border-radius:0%">
	              </div>
	            </div>
	          </div>
	          <div class="modal-body">
	            <form class="formConfirma��oPaciente" novalidate="novalidate">
	              <div class="card-body">
	  				<h5 style="text-size: 50%; text-align: center">Por favor, confirme seus dados para podermos progredir! <span><i class="nc-icon nc-satisfed"></i></span></h5>
	                <div class="input-group">
	                  <div class="input-group-prepend">
	                    <span class="input-group-text"><i class="nc-icon nc-email-85"></i></span>
	                  </div>
	                  <input type="email" name="email" class="form-control" autocomplete="off" placeholder="Email...">
	                </div>
	  
	                <div class="input-group">
	                  <div class="input-group-prepend">
	                    <span class="input-group-text"><i class="nc-icon nc-key-25"></i></span>
	                  </div>
	                  <input type="password" name="senha" class="form-control" autocomplete="off" placeholder="Senha...">
	                </div>
	              </div>
	  
                  <div class="form-check text-left">
                    <label class="form-check-label">
                      <input type="checkbox" name="termos" class="form-check-input" value="">
                      <span class="form-check-sign"></span>
                      Eu concordo com os
                      <a href="#modalcompdf">termos e condi��es de uso</a>.
                    </label>
                  </div>
	            </form>
	          </div>
	          <div class="modal-footers text-center">
	            <button type="button" class="btn btn-primary btn-round" id="btn_confirmar">Vamos come�ar!</button>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	  
      <%@include file="includes/esqueci.jsp" %>

	<%@include file="includes/footer.jsp" %>
  
  <%@include file="includes/base.jsp" %>
    <script>
	Pace.on("done", function(){
		  $(".content").fadeIn(1500);
		});
    
    $('.nc-paper').css('z-index', '1');
    
    $('.nc-simple-remove').css('position', 'absolute');
    
    $('.nc-simple-remove').css('z-index', '2');
    
    var div = $('.nc-paper');
    
  $(document).ready(function() {
      
      var xisy = div.position();
      
      $('.nc-simple-remove').css('top', xisy.top);
      
      $(window).resize(function() {

          var xisy = div.position();
          
          $('.nc-simple-remove').css('top', xisy.top);
      });
  })
  </script>