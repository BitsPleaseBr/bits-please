$(document).ready(function() {
	
//Referente aos plugins
	
	//Moment - Tempo
	moment.locale('pt-br');
	
	//Mascáras dos campos
	$('.cpf').mask('000.000.000-00');
	$('.data').mask('00/00/0000');
	$('.celular').mask('(00) 00000-0000');
	$('.telefone').mask('(00) 0000-0000');
	$('.cep').mask('00000-000');
	
	//API cep
    function limpa_formulário_cep() {
        // Limpa valores do formulário de cep.
    	$(campocep).parents('.row').find('input[placeholder="Logradouro..."]').val('');
    	$(campocep).parents('.row').find('input[placeholder="Número..."]').val('');
        $(campocep).parents('.row').find('input[placeholder="Bairro..."]').val('');
        $(campocep).parents('.row').find('input[placeholder="Cidade..."]').val('');
        $(campocep).parents('.row').find('input[placeholder="UF..."]').val('');
    }
    
    //Quando o campo cep perde o foco.
    $(".cep").blur(function() {
    	
    	var campocep = $(this);

        //Nova variável "cep" somente com dígitos.
        var cep = $(this).val().replace(/\D/g, '');

        //Verifica se campo cep possui valor informado.
        if (cep != "") {

            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;

            //Valida o formato do CEP.
            if(validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                $(campocep).parents('.row').find('input[placeholder="Logradouro..."]').val('...');
                $(campocep).parents('.row').find('input[placeholder="Bairro..."]').val('...');
                $(campocep).parents('.row').find('input[placeholder="Cidade..."]').val('...');
                $(campocep).parents('.row').find('input[placeholder="UF..."]').val('...');

                //Consulta o webservice viacep.com.br/
                $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                    if (!("erro" in dados)) {
                        //Atualiza os campos com os valores da consulta.
                    	$(campocep).parents('.row').find('input[placeholder="Logradouro..."]').val(dados.logradouro);
                        $(campocep).parents('.row').find('input[placeholder="Bairro..."]').val(dados.bairro);
                        $(campocep).parents('.row').find('input[placeholder="Cidade..."]').val(dados.localidade);
                        $(campocep).parents('.row').find('input[placeholder="UF..."]').val(dados.uf);
                    } //end if.
                    else {
                        //CEP pesquisado não foi encontrado.
                        limpa_formulário_cep();
                        alert("CEP não encontrado.");
                    }
                });
            } //end if.
            else {
                //cep é inválido.
                limpa_formulário_cep();
                alert("Formato de CEP inválido.");
            }
        } //end if.
        else {
            //cep sem valor, limpa formulário.
            limpa_formulário_cep();
        }
    });
    
   var S3 = {
    		
	  initWizard: function() {
		    // Code for the Validator
		    var $validator = $('.formCadastroProfissional').validate({
		    	rules: {
	  			  nome: {
	  				  required: true,
	  				  letterswithbasicpunc: true
	  			  },
	  			  sobrenome: {
	  				  required: true,
	  				  letterswithbasicpunc: true
	  			  },
	  			  cpf: {
	  				  required: true,
	  				  cpfBR: true,
	  				  cpfBanco: true
	  			  },
	  			  celular: {
	  				  required: true,
	  				  phoneNL: true
	  			  },
	  			  data: {
	  				  required: true,
	  				  dateITA: true
	  			  },
	  			  email: {
	  				  required: true,
	  				  email: true,
	  				  emailBanco: true
	  			  },
	  			  cepResi: {
	  				  required: true,
	  				  postalcodeBR: true
	  			  },
	  			  ruaResi: {
	  				  required: true
	  			  },
	  			  numeroResi: {
	  				  required: true,
	  				  digits: true
	  			  },
	  			  bairroResi: {
	  				  required: true
	  			  },
	  			  cidadeResi: {
	  				  required: true
	  			  },
	  			  ufResi: {
	  				  required: true,
	  				  lettersonly: true,
	  				  minlength : 2
	  			  },
	  			  telefone: {
	  				  required: true,
	  				  phoneNL: true
	  			  },
	  			  cepCome: {
	  				  required: true,
	  				  postalcodeBR: true
	  			  },
	  			  ruaCome: {
	  				  required: true
	  			  },
	  			  numeroCome: {
	  				  required: true,
	  				  digits: true
	  			  },
	  			  bairroCome: {
	  				  required: true
	  			  },
	  			  cidadeCome: {
	  				  required: true
	  			  },
	  			  ufCome: {
	  				  required: true,
	  				  lettersonly: true,
	  				  minlength : 2
	  			  },
	  			  crm: {
	  				  required: true
	  			  },
	  			  emailConf: {
	  				  required: true,
	  				  email: true,
	  				  equalTo: '#email'
	  			  },
	  			  senha: {
	  				  required: true,
	  				  pass: true,
	  			  },
	  			  senhaConf: {
	  				  required: true,
	  				  pass: true,
	  				  equalTo: '#senha'
	  			  }
	  		  },
	  		  messages: {
	  			  nome: {
	  				  required: "Por favor, precisamos saber como vamos chamar você",
	  				  letterswithbasicpunc: "Acredito que na sua certidão não tenha esses caracteres ai"
	  			  },
	  			  sobrenome: {
	  				  required: "Qualé, você preencheu o anterior, por que não esse?",
	  				  letterswithbasicpunc: "Acredito que na sua certidão não tenha esses caracteres ai"
	  			  },
	  			  cpf: {
	  				  required: "Infelizmente não da pra deixar esse aqui em branco",
	  				  cpfBR: "Tem 11 digítos aqui e cuidado para não errar nenhum",
	  				  cpfBanco: "Já temos um cadastro utilizando esse cpf, contate-nos caso não saiba do que se trata"
	  			  },
	  			  celular: {
	  				  required: "Seria bom preencher esse aqui também",
	  				  phoneNL: "Lembrando que é um celular não um telefone, beleza?"
	  			  },
	  			  data: {
	  				  required: "A gente precisa saber quando te parabenizar por mais um ano de vida!",
	  				  dateITA: "Deixando claro que a data precisa ter um formato dd/mm/aaaa beleza?"
	  			  },
	  			  email: {
	  		      	  required: "Precisamos do seu e-mail para entrar em contato contigo",
	  		      	  email: "Seu e-mail precisa ser parecido com esse: david@dominio.com",
	  		      	  emailBanco: "Esse e-mail já está sendo usado, se necessário peça uma redefinição de senha"
	  			  },
	  			  cepResi: {
	  				  required: "É esse número que o correio identifica sua casa",
	  				  postalcodeBR: "Preenche esse aqui que os outros vão automaticamente c:"
	  			  },
	  			  ruaResi: {
	  				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui"
	  			  },
	  			  numeroResi: {
	  				  required: "Informe esse aqui também por favor",
	  				  digits: "Deixando claro que só pode números aqui"
	  			  },
	  			  bairroResi: {
	  				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui",
	  			  },
	  			  cidadeResi: {
	  				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui",
	  			  },
	  			  ufResi: {
	  				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui",
	  				  lettersonly: "Só as iniciais do estado por favor",
	  				  minlength : "Acredito que tenha 2 letras"
	  			  },
	  			  telefone: {
	  				  required: "Seria bom preencher esse aqui também",
	  				  phoneNL: "Lembrando que é um celular não um telefone, beleza?"
	  			  },
	  			  cepCome: {
	  				  required: "É esse número que o correio identifica sua casa",
	  				  postalcodeBR: "Preenche esse aqui que os outros vão automaticamente c:"
	  			  },
	  			  ruaCome: {
	  				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui"
	  			  },
	  			  numeroCome: {
	  				  required: "Informe esse aqui também por favor",
	  				  digits: "Deixando claro que só pode números aqui"
	  			  },
	  			  bairroCome: {
	  				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui",
	  			  },
	  			  cidadeCome: {
	  				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui",
	  			  },
	  			  ufCome: {
	  				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui",
	  				  lettersonly: "Só as iniciais do estado por favor",
	  				  minlength : "Acredito que tenha 2 letras"
	  			  },
	  			  crm: {
	  				  required: "Por favor, precisamos averiguar a verisidade dos dados por questões de privacidade"
	  			  },
	  			  emailConf: {
					  required: "Temos que ter certeza se nenhum engano foi cometido entende?",
			      	  email: "Lembrando que seu e-mail precisa ser parecido com esse: david@dominio.com",
					  equalTo: "Lembrando que tem que ser o mesmo e-mail que você colocou anteriormente"
	  			  },
	  			  senha: {
	  				  required: "A gente não da sua senha pra ninguém, esperamos que faça o mesmo."
	  			  },
	  			  senhaConf: {
					  required: "Temos que certificar que não aconteceu nenhum engano anteriormente",
					  equalTo: "Da uma olhada lá atrás, por que parece que as senhas informadas não são as mesmas :c"
	  			  },
	  		  },
		      highlight: function(element) {
		        $(element).closest('.input-group').removeClass('has-success').addClass('has-danger');
		      },
		      success: function(element) {
		        $(element).closest('.input-group').removeClass('has-danger').addClass('has-success');
		      }
		    });

		    // Wizard Initialization
		    $('.card-wizard').bootstrapWizard({
		      'tabClass': 'nav nav-pills',
		      'nextSelector': '.btn-next',
		      'previousSelector': '.btn-previous',

		      onNext: function(tab, navigation, index) {
		        var $valid = $('.formCadastroProfissional').valid();
		        if (!$valid) {
		          $validator.focusInvalid();
		          return false;
		        }
		      },

		      onInit: function(tab, navigation, index) {
		        //check number of tabs and fill the entire row
		        var $total = navigation.find('li').length;
		        var $wizard = navigation.closest('.card-wizard');

		        first_li = navigation.find('li:first-child a').html();
		        $moving_div = $("<div class='moving-tab'></div>");
		        $moving_div.append(first_li);
		        $('.card-wizard .wizard-navigation').append($moving_div);



		        refreshAnimation($wizard, index);

		        $('.moving-tab').css('transition', 'transform 0s');
		      },

		      onTabClick: function(tab, navigation, index) {
		        var $valid = $('.formCadastroProfissional').valid();

		        if (!$valid) {
		          return false;
		        } else {
		          return true;
		        }
		      },

		      onTabShow: function(tab, navigation, index) {
		        var $total = navigation.find('li').length;
		        var $current = index + 1;

		        var $wizard = navigation.closest('.card-wizard');

		        // If it's the last tab then hide the last button and show the finish instead
		        if ($current >= $total) {
		          $($wizard).find('.btn-next').hide();
		          $($wizard).find('.btn-finish').show();
		        } else {
		          $($wizard).find('.btn-next').show();
		          $($wizard).find('.btn-finish').hide();
		        }

		        button_text = navigation.find('li:nth-child(' + $current + ') a').html();

		        setTimeout(function() {
		          $('.moving-tab').html(button_text);
		        }, 150);

		        var checkbox = $('.footer-checkbox');

		        if (!index == 0) {
		          $(checkbox).css({
		            'opacity': '0',
		            'visibility': 'hidden',
		            'position': 'absolute'
		          });
		        } else {
		          $(checkbox).css({
		            'opacity': '1',
		            'visibility': 'visible'
		          });
		        }

		        refreshAnimation($wizard, index);
		      }
		    });


		    // Prepare the preview for profile picture
		    $("#wizard-picture").change(function() {
		      readURL(this);
		    });

		    $('[data-toggle="wizard-radio"]').click(function() {
		      wizard = $(this).closest('.card-wizard');
		      wizard.find('[data-toggle="wizard-radio"]').removeClass('active');
		      $(this).addClass('active');
		      $(wizard).find('[type="radio"]').removeAttr('checked');
		      $(this).find('[type="radio"]').attr('checked', 'true');
		    });

		    $('[data-toggle="wizard-checkbox"]').click(function() {
		      if ($(this).hasClass('active')) {
		        $(this).removeClass('active');
		        $(this).find('[type="checkbox"]').removeAttr('checked');
		      } else {
		        $(this).addClass('active');
		        $(this).find('[type="checkbox"]').attr('checked', 'true');
		      }
		    });

		    $('.set-full-height').css('height', 'auto');

		    //Function to show image before upload

		    function readURL(input) {
		      if (input.files && input.files[0]) {
		        var reader = new FileReader();

		        reader.onload = function(e) {
		          $('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
		        }
		        reader.readAsDataURL(input.files[0]);
		      }
		    }

		    $(window).resize(function() {
		      $('.card-wizard').each(function() {
		        $wizard = $(this);

		        index = $wizard.bootstrapWizard('currentIndex');
		        refreshAnimation($wizard, index);

		        $('.moving-tab').css({
		          'transition': 'transform 0s'
		        });
		      });
		    });

		    function refreshAnimation($wizard, index) {
		      $total = $wizard.find('.nav li').length;
		      $li_width = 100 / $total;

		      total_steps = $wizard.find('.nav li').length;
		      move_distance = $wizard.width() / total_steps;
		      index_temp = index;
		      vertical_level = 0;

		      mobile_device = $(document).width() < 600 && $total > 3;

		      if (mobile_device) {
		        move_distance = $wizard.width() / 2;
		        index_temp = index % 2;
		        $li_width = 50;
		      }

		      $wizard.find('.nav li').css('width', $li_width + '%');

		      step_width = move_distance;
		      move_distance = move_distance * index_temp;

		      $current = index + 1;

		      if($current == 1 || (mobile_device == true && (index % 2 == 0) )){
		          move_distance -= 8;
		      } else if($current == total_steps || (mobile_device == true && (index % 2 == 1))){
		          move_distance += 8;
		      }

		      if (mobile_device) {
		        vertical_level = parseInt(index / 2);
		        vertical_level = vertical_level * 38;
		      }

		      $wizard.find('.moving-tab').css('width', step_width);
		      $('.moving-tab').css({
		        'transform': 'translate3d(' + move_distance + 'px, ' + vertical_level + 'px, 0)',
		        'transition': 'all 0.5s cubic-bezier(0.29, 1.42, 0.79, 1)'

		      });
		    }
		  },
		  
		  initFullCalendar: function() {
			    $calendar = $('#fullCalendar');

			    today = new Date();
			    y = today.getFullYear();
			    m = today.getMonth();
			    d = today.getDate();

			    $calendar.fullCalendar({
			      locale: 'pt-br',
			      viewRender: function(view, element) {
			        // We make sure that we activate the perfect scrollbar when the view isn't on Month
			        if (view.name != 'month') {
			          $(element).find('.fc-scroller').perfectScrollbar();
			        }
			      },
			      header: {
			        left: 'title',
			        center: 'month,agendaWeek,agendaDay',
			        right: 'prev,next,today'
			      },
			      defaultDate: today,
			      selectable: true,
			      selectHelper: true,
			      views: {
			        month: { // name of view
			          titleFormat: 'MMMM YYYY'
			          // other view-specific options here
			        },
			        week: {
			          titleFormat: " MMMM D YYYY"
			        },
			        day: {
			          titleFormat: 'D MMM, YYYY'
			        }
			      },

			      select: function(start, end) {

			        // on select we show the Sweet Alert modal with an input
			        swal({
			          title: 'Marcar consulta',
			          html: '<div class="form-group">' +
			            '<input class="form-control" placeholder="Nome do Paciente" id="input-field">' +
			            '</div>',
			          showCancelButton: true,
			          confirmButtonClass: 'btn btn-success',
			          cancelButtonClass: 'btn btn-danger',
			          buttonsStyling: false
			        }).then(function(result) {

			          var eventData;
			          event_title = $('#input-field').val();

			          if (event_title) {
			            eventData = {
			              title: event_title,
			              start: start,
			              end: end
			            };
			            $calendar.fullCalendar('renderEvent', eventData, true); // stick? = true
			          }

			          $calendar.fullCalendar('unselect');

			        });
			      },
			      editable: true,
			      eventLimit: true, // allow "more" link when too many events

			    });
			  },
			  
			  showSwal: function(type) {
				    if (type == 'basic') {
				      swal({
				        title: "Here's a message!",
				        buttonsStyling: false,
				        confirmButtonClass: "btn btn-success"
				      }).catch(swal.noop);

				    } else if (type == 'title-and-text') {
				      swal({
				        title: "Here's a message!",
				        text: "It's pretty, isn't it?",
				        buttonsStyling: false,
				        confirmButtonClass: "btn btn-info"
				      }).catch(swal.noop);

				    } else if (type == 'success-message') {
				      swal({
				        title: "Good job!",
				        text: "You clicked the button!",
				        buttonsStyling: false,
				        confirmButtonClass: "btn btn-success",
				        type: "success"
				      }).catch(swal.noop);

				    } else if (type == 'warning-message-and-confirmation') {
				      swal({
				        title: 'Are you sure?',
				        text: "You won't be able to revert this!",
				        type: 'warning',
				        showCancelButton: true,
				        confirmButtonClass: 'btn btn-success',
				        cancelButtonClass: 'btn btn-danger',
				        confirmButtonText: 'Yes, delete it!',
				        buttonsStyling: false
				      }).then(function() {
				        swal({
				          title: 'Deleted!',
				          text: 'Your file has been deleted.',
				          type: 'success',
				          confirmButtonClass: "btn btn-success",
				          buttonsStyling: false
				        });
				      }).catch(swal.noop);
				    } else if (type == 'warning-message-and-cancel') {
				      swal({
				        title: 'Are you sure?',
				        text: 'You will not be able to recover this imaginary file!',
				        type: 'warning',
				        showCancelButton: true,
				        confirmButtonText: 'Yes, delete it!',
				        cancelButtonText: 'No, keep it',
				        confirmButtonClass: "btn btn-success",
				        cancelButtonClass: "btn btn-danger",
				        buttonsStyling: false
				      }).then(function() {
				        swal({
				          title: 'Deleted!',
				          text: 'Your imaginary file has been deleted.',
				          type: 'success',
				          confirmButtonClass: "btn btn-success",
				          buttonsStyling: false
				        }).catch(swal.noop);
				      }, function(dismiss) {
				        // dismiss can be 'overlay', 'cancel', 'close', 'esc', 'timer'
				        if (dismiss === 'cancel') {
				          swal({
				            title: 'Cancelled',
				            text: 'Your imaginary file is safe :)',
				            type: 'error',
				            confirmButtonClass: "btn btn-info",
				            buttonsStyling: false
				          }).catch(swal.noop);
				        }
				      }).catch(swal.noop);

				    } else if (type == 'custom-html') {
				      swal({
				        title: 'HTML example',
				        buttonsStyling: false,
				        confirmButtonClass: "btn btn-success",
				        html: 'You can use <b>bold text</b>, ' +
				          '<a href="http://github.com">links</a> ' +
				          'and other HTML tags'
				      }).catch(swal.noop);

				    } else if (type == 'auto-close') {
				      swal({
				        title: "Auto close alert!",
				        text: "I will close in 2 seconds.",
				        timer: 2000,
				        showConfirmButton: false
				      }).catch(swal.noop);
				    } else if (type == 'input-field') {
				      swal({
				        title: 'Input something',
				        html: '<div class="form-group">' +
				          '<input id="input-field" type="text" class="form-control" />' +
				          '</div>',
				        showCancelButton: true,
				        confirmButtonClass: 'btn btn-success',
				        cancelButtonClass: 'btn btn-danger',
				        buttonsStyling: false
				      }).then(function(result) {
				        swal({
				          type: 'success',
				          html: 'You entered: <strong>' +
				            $('#input-field').val() +
				            '</strong>',
				          confirmButtonClass: 'btn btn-success',
				          buttonsStyling: false

				        }).catch(swal.noop);
				      }).catch(swal.noop);
				    }
				  },
    }
	
	//Criação do Metódo de senha
	$.validator.addMethod("pass", function(value) {
		   return /[a-z]/.test(value) // Tem uma letra minúscula
		       && /\d/.test(value) // Tem um dígito
		       && /[a-zA-Z0-9]{8,}/.test(value) // Minímo 8 caracteres
		},"A senha deve ter pelo menos 8 caracteres, sendo pelo menos 1 dígito e 1 letra beleza?");
	
	//Função para verificar se o Email já existe no banco
    $.validator.addMethod("emailBanco", function(value, element) {
    	
    	var resultado = false;
    	var dados = "&email=" + value;
    	
    	$.ajaxSetup({async: false});
    	
    	$.ajax({
    		type: "POST",
    		url: "../acoes/verificarEmail.jsp",
    		data: dados,
    		success: function(data) {
    			if (data.trim() == "true") {
    				resultado = true;
    			}
    		}
    	});
    	
    	$.ajaxSetup({async: true});
    	
    	return resultado;
    });
    
    //Função para verificar se o CPF já existe no banco
    $.validator.addMethod("cpfBanco", function(value, element) {
    	
    	var resultado = false;
    	var dados = "&cpf=" + value;
    	
    	$.ajaxSetup({async: false});
    	
    	$.ajax({
    		type: "POST",
    		url: "../acoes/verificarCPF.jsp",
    		data: dados,
    		success: function(data) {
    			if (data.trim() == "true") {
    				resultado = true;
    			}
    		}
    	});
    	
    	$.ajaxSetup({async: true});
    	
    	return resultado;
    });

});
