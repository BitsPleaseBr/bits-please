<%@include file = "../pages/includes/topo.jsp" %>

  <title>
    Painel
  </title>
</head>
  
<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-active-color="blue">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
    -->
      <div class="logo">
      	<a href="#" class="simple-text logo-mini">
            <img src="../assets/img/logo-small.png">
        </a>
      	<a href="#" class="simple-text logo-normal">
		  <img src="../assets/img/negativebrand.png" atl="S2saúde" style="width: 75%">
		</a>
      </div>
      <div class="sidebar-wrapper">
        <div class="user">
          <div class="photo">
            <img src="../assets/img/faces/eu.jpg" />
          </div>
          <div class="info">
            <a data-toggle="collapse" href="#collapseExample" class="collapsed">
              <span>
                Dr. Fischer
                <b class="caret"></b>
              </span>
            </a>
            <div class="clearfix"></div>
            <div class="collapse" id="collapseExample">
              <ul class="nav">
                <li>
                  <a href="#">
                    <span class="sidebar-mini-icon">MP</span>
                    <span class="sidebar-normal">Meu Perfil</span>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <span class="sidebar-mini-icon">EP</span>
                    <span class="sidebar-normal">Editar Perfil</span>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <span class="sidebar-mini-icon">Cf</span>
                    <span class="sidebar-normal">Configurações</span>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <ul class="nav">
          <li>
            <a data-toggle="collapse" href="#pagesExamples">
              <i class="nc-icon nc-book-bookmark"></i>
              <p>
                Prontuário
                <b class="caret"></b>
              </p>
            </a>
            <div class="collapse show" id="pagesExamples">
              <ul class="nav">              
                <li class="active">
                  <a id="resumo">
                    <span class="sidebar-mini-icon">R</span>
                    <span class="sidebar-normal"> Resumo </span>
                  </a>
                </li>
                <li>
                  <a id="anamnese">
                    <span class="sidebar-mini-icon">A</span>
                    <span class="sidebar-normal">Anamnese</span>
                  </a>
                </li>
                <li>
                  <a id="examefisico">
                    <span class="sidebar-mini-icon">EF</span>
                    <span class="sidebar-normal"> Exame Físico </span>
                  </a>
                </li>
                <li>
                  <a id="hipotese">
                    <span class="sidebar-mini-icon">HD</span>
                    <span class="sidebar-normal"> Hispótese Diagnóstica </span>
                  </a>
                </li>
                <li>
                  <a id="conduta">
                    <span class="sidebar-mini-icon">C</span>
                    <span class="sidebar-normal"> Condutas </span>
                  </a>
                </li>
                <li>
                  <a id="procedimentos">
                    <span class="sidebar-mini-icon">EP</span>
                    <span class="sidebar-normal"> Exames e Procedimentos </span>
                  </a>
                </li>
                <li>
                  <a id="prescricoes">
                    <span class="sidebar-mini-icon">P</span>
                    <span class="sidebar-normal"> Prescrições </span>
                  </a>
                </li>
                <li>
                  <a id="atestados">
                    <span class="sidebar-mini-icon">DA</span>
                    <span class="sidebar-normal"> Documentos e Atestados </span>
                  </a>
                </li>
              </ul>
            </div>
          </li>
		  <li>
            <a class="medicos" data-toggle="collapse">
              <i class="nc-icon nc-ambulance"></i>
              <p>
                Outros
              </p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
    
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-minimize">
              <button id="minimizeSidebar" class="btn btn-icon btn-default btn-round">
                <i class="nc-icon nc-minimal-right text-center visible-on-sidebar-mini"></i>
                <i class="nc-icon nc-minimal-left text-center visible-on-sidebar-regular"></i>
              </button>
            </div>
            <div class="navbar-toggle">
              <button type="button" class="navbar-toggler">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </button>
            </div>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->

      <div class="content">
        
      </div>
      
    <%@include file="../pages/includes/footer.jsp" %>
  	
  <%@include file="../pages/includes/base.jsp" %>
  
  <script> 
  $('.content').load('menus/prontuario/resumo.jsp');
  
  	$('#resumo').click(function(){
      load(this, 'menus/prontuario/resumo.jsp');
   	});
  	
  	$('#anamnese').click(function(){
        load(this, 'menus/prontuario/anamnese.jsp');
    });
  	
  	$('#examefisico').click(function(){
        load(this, 'menus/prontuario/examefisico.jsp');
    });
  	  	
  	$('#hipotese').click(function(){
  		load(this, 'menus/prontuario/hipotese.jsp');
  	})
  	
  	$('#conduta').click(function(){   
    	load(this, 'menus/prontuario/conduta.jsp');
    });
  	
  	$('#procedimentos').click(function(){  
    	load(this, 'menus/prontuario/procedimentos.jsp');
    });
  	
  	$('#prescricoes').click(function(){
        load(this, 'menus/prontuario/prescricoes.jsp');
    });
  	
  	$('#atestados').click(function(){
        load(this, 'menus/prontuario/atestados.jsp');
    });
  </script>