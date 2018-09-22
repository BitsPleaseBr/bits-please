<%@include file = "../pages/includes/topo.jsp" %>

  <title>
    Painel
  </title>
</head>
  
<body>
	<%@include file = "../profissional/includes/sidebarup.jsp" %>

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
    
	<%@include file="../pages/includes/usernavbar.jsp" %>

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