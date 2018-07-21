<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!--Formulário de cadastro de Confirmação-->

<form id="modalConfirmacao" method="post">
	<p class="lead">Agora da uma confirmada nos dados de login:</p>
    <div class="form-group row">
        <label class="col-sm-1 col-form-label"><img id="icon" src="img/user.png" alt="user_icon"></img></label>
        <div class="col-sm-11">
            <input type="email" class="form-control" placeholder="E-mail" name="email" autocomplete="off" required>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-1 col-form-label"><img id="icon" src="img/key.png" alt="key_icon"></img></label>
        <div class="col-sm-11">
            <input type="password" class="form-control" placeholder="Senha" name="pwsd" required>
        </div>
    </div>
    <div style="text-align: center">
        <button type="button" class="btn btn-success" id="btn_finalizar">Finalizar</button>
		<button type="reset" class="btn btn-light" id="btn_voltar">Voltar</button>
    </div>
</form>