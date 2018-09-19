$(document).ready(function() {
	
//Referente aos plugins
	
	//Moment - Tempo
	moment.locale('pt-br');
	
	//Mascáras dos campos
	$('.cpf').mask('000.000.000-00');
	$('.data').mask('00/00/0000');
	$('.celular').mask('(00) 00000-0000');
	$('.cep').mask('00000-000');
	
	//API cep
    function limpa_formulário_cep() {
        // Limpa valores do formulário de cep.
        $('input[name="rua"').val('');
        $('input[name="numero"').val('');
        $('input[name="bairro"').val('');
        $('input[name="cidade"').val('');
        $('input[name="uf"').val('');
    }
    
    //Quando o campo cep perde o foco.
    $(".cep").blur(function() {

        //Nova variável "cep" somente com dígitos.
        var cep = $(this).val().replace(/\D/g, '');

        //Verifica se campo cep possui valor informado.
        if (cep != "") {

            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;

            //Valida o formato do CEP.
            if(validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                $('input[name="rua"').val('...');
                $('input[name="bairro"').val('...');
                $('input[name="cidade"').val('...');
                $('input[name="uf"').val('...');

                //Consulta o webservice viacep.com.br/
                $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                    if (!("erro" in dados)) {
                        //Atualiza os campos com os valores da consulta.
                        $('input[name="rua"').val(dados.logradouro);
                        $('input[name="bairro"').val(dados.bairro);
                        $('input[name="cidade"').val(dados.localidade);
                        $('input[name="uf"').val(dados.uf);
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
    
    bits = {
    		
	  initWizard: function() {
		    // Code for the Validator
		    var $validator = $('.card-wizard form').validate({
		      rules: {
		        firstname: {
		          required: true,
		          minlength: 3
		        },
		        lastname: {
		          required: true,
		          minlength: 3
		        },
		        email: {
		          required: true,
		          minlength: 3,
		        }
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
		        var $valid = $('.card-wizard form').valid();
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
		        var $valid = $('.card-wizard form').valid();

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

		      // if($current == 1 || (mobile_device == true && (index % 2 == 0) )){
		      //     move_distance -= 8;
		      // } else if($current == total_steps || (mobile_device == true && (index % 2 == 1))){
		      //     move_distance += 8;
		      // }

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
	
	//Criação do Metódo de senha forte
	$.validator.addMethod("stgpass", function(value) {
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
    
//Referente ao Login
	
	//Regras de validação do form de Login
	var formLog = $('.formLogin');
	formLog.validate({
		rules: {
			email: {
				required: true,
				email: true
			},
			senha: {
				required: true,
				stgpass: 8
			}
		},
		messages: {
			email: {
				required: "Informe um email para podermos te encontrar aqui",
				email: "Lembrando que e-mails se parecem com: david@dominio.com"
			},
			senha: {
				required: "Por questões de segurança você tem que informar a sua senha, relaxa, ninguém tem acesso a ela",
				stgpass: "A senha tem pelo menos 8 caracteres, sendo pelo menos 1 dígito e 1 letra lembra?"
			}
		}
	});
	  
	$("#btn_login").click(function() {
		if(formLog.valid()){
			$(".formLogin").submit();
		}
	});
	
    
//Referente ao cadastro
    
	//Regras de validação do form de Cadastro do Paciente
	var formCadPac = $('.formCadastroPaciente');
	formCadPac.validate({
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
			  data: {
				  required: true,
				  dateITA: true
			  },
			  email: {
				  required: true,
				  email: true,
				  emailBanco: true
			  },
			  senha: {
				  required: true,
				  stgpass: true
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
			  data: {
				  required: "A gente precisa saber quando te parabenizar por mais um ano de vida!",
				  dateITA: "Deixando claro que a data precisa ter um formato dd/mm/aaaa beleza?"
			  },
			  email: {
		      	  required: "Precisamos do seu e-mail para entrar em contato contigo",
		      	  email: "Seu e-mail precisa ser parecido com esse: david@dominio.com",
		      	  emailBanco: "Esse e-mail já está sendo usado, se necessário peça uma redefinição de senha"
			  },
			  senha: {
				  required: "A gente não da sua senha pra ninguém, esperamos que faça o mesmo."
			  }
		  }
	});
	
	//Regras de validação do form de Confirmação de Cadastro do Paciente
	var formConfPac = $('.formConfirmaçãoPaciente');
	formConfPac.validate({
		  rules: {
			  email: {
				  required: true,
				  email: true,
				  equalTo: "#emailPac",
			  },
			  senha: {
				  required: true,
				  stgpass: true,
				  equalTo: "#senhaPac"
			  }
		  },
		  messages: {
			  email: {
				  required: "Temos que ter certeza se nenhum engano foi cometido entende?",
		      	  email: "Lembrando que seu e-mail precisa ser parecido com esse: david@dominio.com",
				  equalTo: "Lembrando que tem que ser o mesmo e-mail que você colocou anteriormente"
			  },
			  senha: {
				  required: "Temos que certificar que não aconteceu nenhum engano anteriormente",
				  equalTo: "Da uma olhada lá atrás, por que parece que as senhas informadas não são as mesmas :c"
			  }
		  }
	});
	
	$('#btn_cadastrar').click(function(){
		  if(formCadPac.valid()){
			$('#ConfirmModal').modal('show');
		  };
	});
	
	$('#btn_confirmar').click(function(){
		  if(formConfPac.valid()){
			if (($("input[name='termos']:checked").length)<=0) {
				alert("Precisamos saber se você chegou a ler nossos termos de uso");
			}else{
		  	  $('.formCadastroPaciente').submit();
		  	  alert('Enviamos um e-mail de confirmação para o seu e-mail, da um olhada lá, please ;)');
			};
		  };
	});
	
	//Regras de validação do form de Cadastro do Paciente
	var formCadPac = $('#formCadastroProfissional');
	formCadPac.validate({
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
			  cep: {
				  required: true,
				  postalcodeBR: true
			  },
			  rua: {
				  required: true
			  },
			  numero: {
				  required: true,
				  digits: true
			  },
			  bairro: {
				  required: true
			  },
			  cidade: {
				  required: true
			  },
			  uf: {
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
				  stgpass: true,
			  },
			  senhaConf: {
				  required: true,
				  stgpass: true,
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
			  cep: {
				  required: "É esse número que o correio identifica sua casa",
				  postalcodeBR: "Preenche esse aqui que os outros vão automaticamente c:"
			  },
			  rua: {
				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui"
			  },
			  numero: {
				  required: "Informe esse aqui também por favor",
				  digits: "Deixando claro que só pode números aqui"
			  },
			  bairro: {
				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui",
			  },
			  cidade: {
				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui",
			  },
			  uf: {
				  required: "Caso a busca do CEP não funcionar você pode inserir manualmente aqui",
				  lettersonly: "Só as iniciais do estado por favor",
				  minlength : "Acredito que tenha 2 letras"
			  },
			  crm: {
				  required: "SL"
			  },
			  emailConf: {
				  required: "",
				  email: "",
				  equalTo: ""
			  },
			  senha: {
				  required: "A gente não da sua senha pra ninguém, esperamos que faça o mesmo.",
				  stgpass: "",
			  },
			  senhaConf: {
			  	  required: "",
			  	  stgpass: "",
			  	  equalTo: ""
			  }
		  }
	});
});

