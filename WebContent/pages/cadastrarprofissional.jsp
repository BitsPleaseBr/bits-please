<%@include file = "includes/topo.jsp" %>

  <title>
    Cadastrar Profissional
  </title>
</head>

<body class="register-page" style="overflow:hidden">

  <%@include file="includes/navbar.jsp" %>
  		<button type="button" style="margin-left: 50px" class="btn btn-success btn-round" onclick="location.href='login.jsp'">Acesse</button>
      </div>
    </div>
  </nav>
  <!-- End Navbar -->

  <%@include file="includes/fullpage.jsp" %>

	<div class="content">
        <div class="col-md-7 mr-auto ml-auto">
                    
          <div class="wizard-container">
            <div class="card card-wizard" id="wizardProfile">
              <form class="formCadastroProfissional" method="post" action="../../acoes/login.jsp">
                
                <div class="card-header text-center">
                  <h4 class="card-title">
                    Cadastro de Profissional
                  </h4>
                  
                  <div class="wizard-navigation">
                    <ul>
                      <li class="nav-item">
                        <a class="nav-link active" href="#pessoal" data-toggle="tab" role="tab" aria-controls="pessoal" aria-selected="true">
                          <i class="nc-icon nc-single-02"></i> Pessoal
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#enderecope" data-toggle="tab" role="tab" aria-controls="enderecope" aria-selected="true">
                          <i class="nc-icon nc-pin-3"></i> Endere�o
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#profissional" data-toggle="tab" role="tab" aria-controls="profissional" aria-selected="true">
                          <i class="nc-icon-other nc-badge-13"></i> Profissional
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#enderecopro" data-toggle="tab" role="tab" aria-controls="enderecopro" aria-selected="true">
                          <i class="nc-icon nc-pin-3"></i> Endere�o
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#conta" data-toggle="tab" role="tab" aria-controls="conta" aria-selected="true">
                          <i class="nc-icon nc-touch-id"></i> Conta
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
                
                <div class="card-body">
                  <div class="tab-content">
                  
                    <div class="tab-pane show active" id="pessoal">
                      <h5 class="info-text"> Vamos come�ar com as informa��es b�sicas.</h5>
                      <div class="row justify-content-center">
                        <div class="col-md-5">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-single-02"></i></span>
                            </div>
                            <input type="text" name="nome" class="form-control" placeholder="Nome...">
                          </div>
                        </div>
                        <div class="col-md-5">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-circle-10"></i></span>
                            </div>
                            <input type="text" name="sobrenome" class="form-control" placeholder="Sobrenome...">
                          </div>
                        </div>
                        <div class="col-sm-4 mt-3">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-badge"></i></span>
                            </div>
                            <input type="text" name="cpf" class="form-control cpf"  placeholder="CPF...">
                          </div>
                        </div>
                        <div class="col-sm-3 mt-3">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon-other nc-gift-2"></i></span>
                            </div>
                            <input type="text" placeholder="Nascimento" class="form-control" name="datanascimento" />
                          </div>
                        </div>
                        <div class="col-sm-4 mt-3">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-mobile"></i></span>
                            </div>
                            <input type="text" name="celular" class="form-control celular" placeholder="Celular...">
                          </div>
                        </div>
                        <div class="col-lg-10 mt-3">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-email-85"></i></span>
                            </div>
                            <input type="email" name="email" class="form-control" placeholder="E-mail...">
                          </div>
                        </div>
                      </div>
                    </div>
                    
                    <div class="tab-pane" id="enderecope">
                      <h5 class="info-text"> Por favor informe seu endere�o pessoal </h5>
                      <div class="row justify-content-center">
                        <div class="col-md-3 mt-3">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-box-2"></i></span>
                            </div>
                            <input type="text" name="cep" class="form-control cep" placeholder="CEP...">
                          </div>
                        </div>
                        <div class="col-md-7"></div>
                        <div class="col-md-8">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-map-big"></i></span>
                            </div>
                            <input type="text" name="rua" class="form-control" placeholder="Logradouro...">
                          </div>
                        </div>
                        <div class="col-md-2">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-map-big"></i></span>
                            </div>
                            <input type="text" name="numero" class="form-control" placeholder="N�mero...">
                          </div>
                        </div>
                        <div class="col-md-4">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-map-big"></i></span>
                            </div>
                            <input type="text" name="bairro" class="form-control" placeholder="Bairro...">
                          </div>
                        </div>
                        <div class="col-md-4">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-map-big"></i></span>
                            </div>
                            <input type="text" name="cidade" class="form-control" placeholder="Cidade...">
                          </div>
                        </div>
                        <div class="col-md-2">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-map-big"></i></span>
                            </div>
                            <input type="text" name="uf" class="form-control" placeholder="UF...">
                          </div>
                        </div>
                      </div>
                    </div>
                    
                    <div class="tab-pane" id="profissional">
                      <h5 class="info-text"> Agora vamos levar mais a s�rio </h5>
                      <div class="row justify-content-center">
                        <div class="col-md-5">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon-other nc-badge-13"></i></span>
                            </div>
                            <input type="text" name="crm" class="form-control" placeholder="CRM...">
                          </div>
                        </div>
                        <div class="col-md-2">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-pin-3"></i></span>
                            </div>
                            <input type="text" name="uf" class="form-control" placeholder="SC...">
                          </div>
                        </div>
                        <p class="mt-3">
                        Por favor adicione aqui as especializa��es que voc� possui
                        </p>
						<select class="selectpicker col-sm-7 mt-5" data-style="select-with-transition" title="Especializa��o" data-size="7">
						  <option value="Acunputura">Acunputura</option>
						  <option value="Administra��o em sa�de">Administra��o em sa�de</option>
						  <option value="Administra��o hospitalar">Administra��o hospitalar</option>
						  <option value="Alergia e Imunologia">Alergia e Imunologia</option>
						  <option value="Alergia e Imunopatologia">Alergia e Imunopatologia</option>
						  <option value="Anatomia patol�gica">Anatomia patol�gica</option>
						  <option value="Anestesiologia">Anestesiologia</option>
						  <option value="Angiologia">Angiologia</option>
						  <option value="Angiologia e Cirurgia Vascular">Angiologia e Cirurgia Vascular</option>
						  <option value="Broncoesofagologia">Broncoesofagologia</option>
						  <option value="Cancerologia">Cancerologia</option>
						  <option value="Cancerologia/Cancerologia Cir�rgica">Cancerologia/Cancerologia Cir�rgica</option>
						  <option value="Cancerologia/Cancerologia Pedi�trica">Cancerologia/Cancerologia Pedi�trica</option>
						  <option value="Cardiologia">Cardiologia</option>
						  <option value="Cirurgia Cardiovascular">Cirurgia Cardiovascular</option>
						  <option value="Cirurgia da M�o">Cirurgia da M�o</option>
						  <option value="Cirurgia de Cabe�a e Pesco�o">Cirurgia de Cabe�a e Pesco�o</option>
						  <option value="Cirurgia Digestiva">Cirurgia Digestiva</option>
						  <option value="Cirurgia do Aparelho Digestivo">Cirurgia do Aparelho Digestivo</option>
						  <option value="Cirurgia do Trauma">Cirurgia do Trauma</option>
						  <option value="Cirurgia Gastroenterol�gica">Cirurgia Gastroenterol�gica</option>
						  <option value="Cirurgia Geral">Cirurgia Geral</option>
						  <option value="Cirurgia Oncol�gica">Cirurgia Oncol�gica</option>
						  <option value="Cirurgia Pedi�trica">Cirurgia Pedi�trica</option>
						  <option value="Cirurgia Pl�stica">Cirurgia Pl�stica</option>
						  <option value="Cirurgia Tor�cica">Cirurgia Tor�cica</option>
						  <option value="Cirurgia Tor�xica">Cirurgia Tor�xica</option>
						  <option value="Cirurgia Vascular">Cirurgia Vascular</option>
						  <option value="Cirurgia Vascular Perif�rica">Cirurgia Vascular Perif�rica</option>
						  <option value="Citopatologia">Citopatologia</option>
						  <option value="Cl�nica M�dica">Cl�nica M�dica</option>
						  <option value="Coloproctologia">Coloproctologia</option>
						  <option value="Densitometria �ssea">Densitometria �ssea</option>
						  <option value="Dermatologia">Dermatologia</option>
						  <option value="Diagn�stico por Imagem">Diagn�stico por Imagem</option>
						  <option value="Doen�as Infecciosas e Parasit�rias">Doen�as Infecciosas e Parasit�rias</option>
						  <option value="Eletroencefalografia">Eletroencefalografia</option>
						  <option value="Endocrinologia">Endocrinologia</option>
						  <option value="Endocrinologia e Metabologia">Endocrinologia e Metabologia</option>
						  <option value="Endoscopia">Endoscopia</option>
						  <option value="Endoscopia Digestiva">Endoscopia Digestiva</option>
						  <option value="Endoscopia Peroral">Endoscopia Peroral</option>
						  <option value="Endoscopia Peroral vias A�reas">Endoscopia Peroral vias A�reas</option>
						  <option value="Fisiatria">Fisiatria</option>
						  <option value="Foniatria">Foniatria</option>
						  <option value="Gastroenterologia">Gastroenterologia</option>
						  <option value="Gen�tica Cl�nica">Gen�tica Cl�nica</option>
						  <option value="Gen�tica Laboratorial">Gen�tica Laboratorial</option>
						  <option value="Gen�tica M�dica">Gen�tica M�dica</option>
						  <option value="Geriatria">Geriatria</option>
						  <option value="Geriatria e Gerontologia">Geriatria e Gerontologia</option>
						  <option value="Ginecologia">Ginecologia</option>
						  <option value="Ginecologia e Obstetr�cia">Ginecologia e Obstetr�cia</option>
						  <option value="Hansenologia">Hansenologia</option>
						  <option value="Hematologia">Hematologia</option>
						  <option value="Hematologia e Hemoterapia">Hematologia e Hemoterapia</option>
						  <option value="Hemoterapia">Hemoterapia</option>
						  <option value="Hepatologia">Hepatologia</option>
						  <option value="Homeopatia">Homeopatia</option>
						  <option value="Imunologia Cl�nica">Imunologia Cl�nica</option>
						  <option value="Infectologia">Infectologia</option>
						  <option value="Inform�tica M�dica">Inform�tica M�dica</option>
						  <option value="33">mastologia</option><option value="261">medicina de emerg�ncia</option><option value="74">medicina de fam�lia e comunidade</option><option value="35">medicina de tr�fego</option><option value="93">medicina do adolescente</option><option value="103">medicina do esporte</option><option value="34">medicina do trabalho</option><option value="36">medicina esportiva</option><option value="75">medicina f�sica e reabilita��o</option><option value="37">medicina geral comunit�ria</option><option value="38">medicina intensiva</option><option value="39">medicina interna ou cl�nica m�dica</option><option value="40">medicina legal</option><option value="259">medicina legal e per�cia m�dica</option><option value="41">medicina nuclear</option><option value="76">medicina preventiva e social</option><option value="42">medicina sanit�ria</option><option value="43">nefrologia</option><option value="44">neurocirurgia</option><option value="45">neurofisiologia cl�nica</option><option value="46">neurologia</option><option value="47">neurologia pedi�trica</option><option value="94">neuropediatria</option><option value="104">nutri��o parenteral e enteral</option><option value="48">nutrologia</option><option value="49">obstetr�cia</option><option value="50">oftalmologia</option><option value="95">oncologia</option><option value="79">oncologia cl�nica</option><option value="51">ortopedia e traumatologia</option><option value="52">otorrinolaringologia</option><option value="53">patologia</option><option value="54">patologia cl�nica</option><option value="77">patologia cl�nica/medicina laboratorial</option><option value="55">pediatria</option><option value="56">pneumologia</option><option value="105">pneumologia e tisiologia</option><option value="57">proctologia</option><option value="58">psiquiatria</option><option value="96">psiquiatria infantil</option><option value="106">radiodiagn�stico</option><option value="59">radiologia</option><option value="78">radiologia e diagn�stico por imagem</option><option value="60">radioterapia</option><option value="61">reumatologia</option><option value="62">sexologia</option><option value="63">terapia intensiva</option><option value="257">terapia intensiva pedi�trica</option><option value="64">tisiologia</option><option value="258">toco-ginecologia</option><option value="107">ultrassonografia</option><option value="256">ultrassonografia em ginecologia e obstetr�cia</option><option value="255">ultrassonografia geral</option><option value="65">urologia</option>
						</select>
						<div class="col-sm-8">
						  <input type="text" value="Aqui aparecer� as que voc� escolher, caso erre pode excluir sem problemas xD" class="tagsinput form-control" data-role="tagsinput">
                      	</div>
                      </div>
                    </div>
                    
                    <div class="tab-pane" id="enderecopro">
                      <h5 class="info-text"> Por favor informe seu endere�o profissional </h5>
                      <div class="row justify-content-center">
                        <div class="col-md-3 mt-3">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-box-2"></i></span>
                            </div>
                            <input type="text"  name="cep" class="form-control cep" placeholder="CEP...">
                          </div>
                        </div>
                        <div class="col-md-4"></div>
                        <div class="col-md-3 mt-3">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-mobile"></i></span>
                            </div>
                            <input type="text" name="celular" class="form-control celular" placeholder="Telefone...">
                          </div>
                        </div>
                        <div class="col-md-7"></div>
                        <div class="col-md-8">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-map-big"></i></span>
                            </div>
                            <input type="text" name="rua" class="form-control" placeholder="Logradouro...">
                          </div>
                        </div>
                        <div class="col-md-2">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-map-big"></i></span>
                            </div>
                            <input type="text" name="numero" class="form-control" placeholder="N�mero...">
                          </div>
                        </div>
                        <div class="col-md-4">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-map-big"></i></span>
                            </div>
                            <input type="text" name="bairro" class="form-control" placeholder="Bairro...">
                          </div>
                        </div>
                        <div class="col-md-4">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-map-big"></i></span>
                            </div>
                            <input type="text" name="cidade" class="form-control" placeholder="Cidade...">
                          </div>
                        </div>
                        <div class="col-md-2">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-map-big"></i></span>
                            </div>
                            <input type="text" name="uf" class="form-control" placeholder="UF...">
                          </div>
                        </div>
                      </div>
                    </div>
                    
					<div class="tab-pane" id="conta">
                      <h5 class="info-text"> Por fim vamos criar os dados para usar os nossos servi�os </h5>
                      <div class="row justify-content-center">
                        <p class="col-md-10">
                      	  Confirme o e-mail informado por favor:
                      	</p>
                        <div class="col-md-10 mt-3">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-email-85"></i></span>
                            </div>
                            <input type="text" name="emailConf" class="form-control" placeholder="Confirma��o do E-mail...">
                          </div>
                        </div>
                        <p class="col-md-10">
                      	  Vamos criar uma senha pra entrar na conta:
                      	</p>
                        <div class="col-md-5 mt-3">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-key-25"></i></span>
                            </div>
                            <input type="text" name="senha" class="form-control" placeholder="Senha...">
                          </div>
                        </div>
                        <div class="col-md-5 mt-3">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"><i class="nc-icon nc-key-25"></i></span>
                            </div>
                            <input type="text" name="senhaConf" class="form-control" placeholder="Confirma��o da Senha...">
                          </div>
                        </div>
	                  <div class="form-check text-left mt-3">
	                    <label class="form-check-label" style="color: black">
	                      <input type="checkbox" name="termos" class="form-check-input" value="">
	                      <span class="form-check-sign"></span>
	                      Eu concordo com os
	                      <a href="#modalcompdf">termos e condi��es de uso</a>.
	                    </label>
	                  </div>
	                  <div class="col-md-5"></div>
                      </div>
                    </div>
                  </div>
                </div>
                
                <div class="card-footer">
                  <div class="pull-right">
                    <input type='button' class='btn btn-next btn-fill btn-rose btn-wd' name='proximo' value='Pr�ximo' />
                    <input type='button' class='btn btn-finish btn-fill btn-rose btn-wd' name='pronto' value='Pronto' />
                  </div>
                  <div class="pull-left">
                    <input type='button' class='btn btn-previous btn-fill btn-default btn-wd' name='anterior' value='Anterior' />
                  </div>
                  <div class="clearfix"></div>
                </div>
              </form>
            </div>
          </div>
          
        </div>
      </div>
      
	<%@include file="includes/footer.jsp" %>
  
  <%@include file="includes/base.jsp" %>
  
    <script>
	Pace.on("done", function(){
		  $(".content").fadeIn(1500);
		});
    
    $(document).ready(function() {
      // Initialise the wizard
      bits.initWizard();
      setTimeout(function() {
        $('.card.card-wizard').addClass('active');
      }, 600);
      
      var index = true;
      
      $('.selectpicker').change(function () {
    	  var slecteditem= $(this).find("option:selected").val();
    	      	  
    	  if(index){
    	  	$('.tagsinput').tagsinput('removeAll');
    	  	$('.tagsinput').tagsinput('add', slecteditem);
    	  	index = false;
    	  }else{
    		  $('.tagsinput').tagsinput('add', slecteditem);
    	  }
      });
    });
  </script>