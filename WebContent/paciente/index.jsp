<%@include file = "../pages/includes/topo.jsp" %>

  <title>
    Painel
  </title>
</head>
  
<body>
  <div class="wrapper ">
    <div class="sidebar" data-active-color="blue">

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
                Nathan Fischer
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
          <li class="active">
            <a id="prontuarios">
              <i class="nc-icon nc-paper"></i>
              <p>Prontuários</p>
            </a>
          </li>
          <li class="inactive">
            <a id="calendario">
              <i class="nc-icon-other nc-calendar-60"></i>
              <p>Agendamento</p>
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
        
      </div>
      
    <%@include file="../pages/includes/footer.jsp" %>
  	
  <%@include file="../pages/includes/base.jsp" %>
  
<script>

$(document).ready(function(){
	
	$('.content').load('menus/prontuario.jsp');

	$('#prontuarios').click(function(){
		load(this, 'menus/prontuario.jsp');
	});

		$('#calendario').click(function(){
			load(this, 'menus/agendamento.jsp');			
	    });
	});
  </script>