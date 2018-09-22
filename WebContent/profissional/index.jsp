<%@include file = "../pages/includes/topo.jsp" %>

  <title>
    Painel
  </title>
</head>
  
<body>
	<%@include file = "../profissional/includes/sidebarup.jsp" %> 
        
        <ul class="nav">
          <li class="active">
            <a id="painel">
              <i class="nc-icon nc-tile-56"></i>
              <p>Painel</p>
            </a>
          </li>
          <li>
            <a id="prontuarios">
              <i class="nc-icon nc-paper"></i>
              <p>Prontuários</p>
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
	$(document).ready(function() {
		
		$('.content').load('menus/painel.jsp');

		$('#painel').click(function(){
			load(this, 'menus/painel.jsp');
		});
		
		$('#prontuarios').click(function(){
			load(this, 'menus/prontuarios.jsp');
		});
	 });
  </script>