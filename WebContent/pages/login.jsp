<%@include file = "includes/topo.jsp" %>

  <title>
    Login
  </title>
</head>

<body class="login-page" style="overflow:hidden">

  <%@include file="includes/navbar.jsp" %>
    		<button type="button" style="margin-left: 50px" class="btn btn-success btn-round" onclick="location.href='cadastrar.jsp'">Registre-se</button>
      </div>
    </div>
  </nav>
  <!-- End Navbar -->

  <%@include file="includes/fullpage.jsp" %>

   <div class="content">
        <div class="container">
          <div class="col-lg-4 col-md-6 ml-auto mr-auto">
            <form class="formLogin" method="post" action="../../acoes/login.jsp">
              <div class="card card-login">
                <div class="card-header ">
                  <div class="card-header ">
                    <h4 class="header text-center">Como é bom te ver por aqui!! <span><i class="nc-icon nc-satisfied"></i></span></h4>
                  </div>
                </div>
				<div class="card-body">
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="nc-icon nc-single-02"></i>
                      </span>
                    </div>
                    <input type="email" name="email" class="form-control" placeholder="E-mail">
                  </div>
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="nc-icon nc-key-25"></i>
                      </span>
                    </div>
                    <input type="password" name="senha" class="form-control" placeholder="Senha">
                  </div>
                  <small><a href="#esqueci" data-toggle="modal" data-target="#EsqueciModal">Esqueceu sua senha?</a></small>
                  <br>
                  <a href="cadastrar.jsp">Não tem uma conta? Bora fazer! xD</a>
                </div>
                <div class="card-footer text-center">
                  <button type="button" id="btn_login" onclick="checkCookie()" class="btn btn-primary btn-round">Entrar</button>
                </div>
              </div>
            </form>
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
	
	cookies.put("nome", "Nathan");
	cookies.put("tipo", "2");
	cookies.save;
	alert(cookies.load);
  </script>