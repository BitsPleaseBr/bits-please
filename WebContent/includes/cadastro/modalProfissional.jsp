<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--Formulário de cadastro do Profissional-->

<form id="modalProfissional" method="post" action="_acoes/cadastrarProfissional.jsp">

    <div class="form-row" style="margin-left: -5px;margin-bottom: -65px">
      <div class="form-group col-md-8">
		<p class="lead" style="font-size: 17px">Insira seus dados pessoas aqui:</p>
		<div class="form-row" id="textos">
		  <div class="form-group col-md-6">
            <input type="text" class="form-control" name="nome" placeholder="Nome" required>
          </div>
          <div class="form-group col-md-6">
            <input type="text" class="form-control" name="sobrenome" placeholder="Sobrenome" required>
          </div>
		</div>
    	<div class="form-row">
          <div class="form-group col-sm-4">
            <input type="text" class="form-control cpf" name="cpf" placeholder="CPF" required>
          </div>
          <div class="form-group col-md-4">
			<input type="datetime" class="form-control date" name="data" placeholder="Data de Nascimento" required>
    	  </div>
    	  <div class="form-group col-md-4">
			<input type="tel" class="form-control cel" name="celular" placeholder="Celular" required>
    	  </div>
    	</div>
      </div>
    
	  <div class="form-group col-md-4">
		<p class="lead ml-auto" style="font-size: 17px;">Aqui os profissionais:</p>
		<div class="form-row">
		  <div class="form-group col-md-7">
            <input type="text" class="form-control crm" name="crm" placeholder="CRM" required>
          </div>
          <div class="form-group col-md-4" id="textos">
            <input type="text" class="form-control" name="uf" placeholder="UF" maxlength=2 required>
          </div>
		</div>
		<div class="form-row" id="textos">
          <div class="form-group col-md-11" style="margin-right: 25px">
            <input type="text" class="form-control" name="especializacao" placeholder="Especialização" required>
          </div>
		</div>
   		<div class="form-row">
      	  <div class="form-group col-md-11" style="margin-right: 25px">
	  	    <input type="tel" class="form-control tel" name="telefone" placeholder="Telefone" required>
      	  </div>
   		</div>
   	</div>
   </div>
   
	<p class="lead" style="font-size: 15px">Seu Endereço Residencial:</p>
	<div class="form-row">
      <div class="form-group col-md-2">
        <input type="text" id="cepResi" class="form-control cep" name="cepResi" placeholder="CEP" required>
      </div>
    </div>
    <div class="form-row" id="textos" >
      <div class="form-group col-md-4">
        <input type="text" id="bairroResi" class="form-control" name="bairroResi" placeholder="Bairro" required>
      </div>
      <div class="form-group col-md-4.5">
        <input type="text" id="cidadeResi" class="form-control" name="cidadeResi" placeholder="Cidade" required>
      </div>
      <div class="form-group col-md-1">
        <input type="text" id="ufResi" class="form-control" name="ufResi" placeholder="UF" maxlength=2 required>
      </div>
    </div>
    <div class="form-row">
      <div class="form-group col-md-7" id="textos">
        <input type="text" id="ruaResi" class="form-control" name="ruaResi" placeholder="Logradouro" required>
      </div>
      <div class="form-group col-md-3" id="textos">
        <input type="text" class="form-control" name="complementoResi" placeholder="Complemento">
      </div>
      <div class="form-group col-md-1">
        <input type="text" class="form-control num" name="numeroResi" placeholder="Núº" required>
      </div>
    </div>
	
	<p class="lead" style="font-size: 15px">Seu Endereço Comercial:</p>
	<div class="form-row">
      <div class="form-group col-md-2">
        <input type="text" id="cepCome" class="form-control cep" name="cepCome" placeholder="CEP" required>
      </div>
    </div>
    <div class="form-row" id="textos">
      <div class="form-group col-md-4">
        <input type="text" id="bairroCome" class="form-control" name="bairroCome" placeholder="Bairro" required>
      </div>
      <div class="form-group col-md-4.5">
        <input type="text" id="cidadeCome" class="form-control" name="cidadeCome" placeholder="Cidade" required>
      </div>
      <div class="form-group col-md-1">
        <input type="text" id="ufCome" class="form-control" name="ufCome" placeholder="UF" maxlength=2 required>
      </div>
    </div>
    <div class="form-row">
      <div class="form-group col-md-7" id="textos">
        <input type="text" id="ruaCome" class="form-control" name="ruaCome" placeholder="Logradouro" required>
      </div>
      <div class="form-group col-md-3" id="textos">
        <input type="text" class="form-control" name="complementoCome" placeholder="Complemento">
      </div>
      <div class="form-group col-md-1">
        <input type="text" class="form-control num" name="numeroCome" placeholder="Núº" required>
      </div>
    </div>
    
    <p class="lead" style="font-size: 17px">Insira aqui os dados para login:</p>
  <div class="form-row"> 
    <div class="form-group" id="email">
        <input type="email" class="form-control" name="email" placeholder="E-mail" id="emailPro" required>
    </div>
    <div class="form-group" id="senha">
        <input type="password" class="form-control" name="senha" placeholder="Senha" id="senhaPro" required>
    </div>
  </div>
</form>