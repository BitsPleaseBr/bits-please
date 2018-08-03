<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!--Formulário de cadastro do Paciente-->

<form id="modalPaciente" method="post" action="_acoes/cadastrarPaciente.jsp">
    <p class="lead" style="font-size: 17px">Beleza, agora você coloca seus dados pessoais:</p>
    <div class="form-row" id="textos">
        <div class="form-group col-md-6">
            <input type="text" class="form-control" name="nome" placeholder="Nome" required>
        </div>
        <div class="form-group col-md-6">
            <input type="text" class="form-control" name="sobrenome" placeholder="Sobrenome" required>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <input type="text" id="cpf" class="form-control cpf" name="cpf" placeholder="CPF" required>
        </div>
        <div class="form-group col-md-6">
			<input type="datetime" class="form-control date" name="data" placeholder="Data de Nascimento" required>
    	</div>
    </div>
    <p class="lead" style="font-size: 17px">Aqui vão seus dados para realizar o login:</p>
    <div class="form-group" id="email">
        <input type="email" class="form-control" name="emailPac" placeholder="E-mail" id="emailPac" required>
    </div>
    <div class="form-group" id="senha">
        <input type="password" class="form-control" name="senhaPac" placeholder="Senha" id="senhaPac" required>
    </div>
</form>