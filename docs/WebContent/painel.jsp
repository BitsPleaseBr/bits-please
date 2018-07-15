<%@page import="br.com.jsp.dao.UsuarioDao"%>
<%@ include file="includes/topo.jsp" %>
		
		<main>
		
			<form action="acoes/cadastrarUsuario.jsp" class="frmCadastrarUsuario">
				<input type="text" placeholder="Nome" name="nome" class="form-control">
				<input type="email" placeholder="E-mail" name="email" class="form-control">
				<input type="password" placeholder="Senha" name="senha" class="form-control">
				<select name="nivel" class="form-control">
					<option value="0">Nível</option>
					<option value="1">Administrador</option>
					<option value="2">Usuário Comum</option>
				</select>
				<input type="submit" value="Cadastrar usuário" class="btn btn-primary">
			</form>
			
			<% out.print(new UsuarioDao().listarUsuario()); %>
			
		</main>		
		
	</body>
</html>