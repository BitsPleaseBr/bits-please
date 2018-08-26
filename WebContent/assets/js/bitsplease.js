//Referente ao Login

function checkFullPageBackgroundImage() {
  $page = $('.full-page');
  image_src = $page.data('image');

  if (image_src !== undefined) {
    image_container = '<div class="full-page-background" style="background-image: url(' + image_src + ') "/>';
    $page.append(image_container);
  }
}

$(document).ready(function() {
  checkFullPageBackgroundImage();
  
  var formLog = $('.formLogin');
  formLog.validate({
	  rules: {
		  email: {
			  email: true
		  },
		  senha: {
			  minlength: 6
		  }
	  },
	  messages: {
		  email: {
			  required: "Informe um email para podermos te encontrar aqui",
			  email: "Lembrando que e-mails se parecem com: david@dominio.com"
		  },
		  senha: {
			  required: "Por questões de segurança você tem que informar a sua senha, relaxa, ninguém tem acesso a ela",
			  minlength: "A senha precisa ter pelo menos 6 caracteres beleza?"
		  }
	  }
  })
    	
  $("#btn_login").click(function() {
	  if(formLog.valid()){
		  $(".formLogin").submit();
		  alert("Entrando...");
	  }
  })
});