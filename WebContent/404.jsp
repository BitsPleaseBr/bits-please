<%@include file = "pages/includes/topo.jsp" %>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
      
  <title>
    Error 404
  </title>
  
	<style>
	@import "lesshat";
	@import url(https://fonts.googleapis.com/css?family=Roboto);

	html { 
	  background:  url(https://38.media.tumblr.com/546c0cd48d71f210f9b67a389003790d/tumblr_neq0yw9rMA1tm16jjo1_500.gif) no-repeat center center fixed; 
	  background-size: cover;
	  font-family: 'bariolregular','roboto';
	
	}
	body{
	  overflow: hidden;
	}
	h1{
	  font-size: 16em;
	  margin: .2em .5em;
	  color: rgba(255,255,255, 0.7);
	  margin-bottom:0px;
	}
	h2{
	  font-size: 1.7em;
	  margin: .2em .5em;
	  color: rgba(255,255,255, 0.6);
		.material-icons {
			font-size: 1.5em;
			position: relative;
			top: 10px;
		}
	}
	div.error{
	  position:absolute;
	  top:30%;
	  margin-top:-8em;
	  width:100%;
	  text-align:center;
	}
	</style>
</head>

<body>

<div class="error">
  <h1>404 </h1>
  <h2>Ahh não, algo deu errado <i class="material-icons">sentiment_very_dissatisfied</i></h2>
</div>

	<%@include file="pages/includes/footer.jsp" %>
  
  <%@include file="pages/includes/base.jsp" %>