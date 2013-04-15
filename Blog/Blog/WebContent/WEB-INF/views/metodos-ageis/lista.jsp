<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Comentários</title>
	</head>
	<body>
	
		<table align="center" width="800px" border="1">
			<tr>
				<td colspan="5" height="100px">
					
				</td>
			</tr>
			<tr>
				<c:forEach items="${assuntoList}" var="assunto">
					<td align="center" ><a href="${assunto.mapeamento}/${assunto.id}">${assunto.descricao}</a></td>
				</c:forEach>
			</tr>
			<tr>
				<td colspan="5" height="500px">
					<c:forEach items="${materiaList}" var="materia">
						${materia.titulo}<br><br>
						${materia.conteudo}<br>
					</c:forEach>
				</td>
				
			</tr>
			<c:forEach items="${comentarioList}" var="comentario">
				<tr>
					<td colspan="1" height="50px">${comentario.email}</td>
					<td colspan="4"><textarea rows="10" cols="80">${comentario.texto}</textarea></td>
				</tr>
			</c:forEach>
			
			<form:form method="post" action="salvar" commandName="comentario">
				<input type="hidden" id="id" name="assunto.id" value="1">
				<tr>
					<td align="center" colspan="1">Contato:</td>
					<td colspan="4"><input id="contato" name="email" size="25" maxlength="100"></td>
				</tr>
				<tr>
					<td colspan="1" width="20%" align="center">Comentário:</td>
					<td colspan="4"><textarea name="texto" rows="10" cols="80"></textarea></td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Salvar" />
					</td>
				</tr>
			</form:form>
			<tr>
				<td colspan="5" height="50px">
				</td>
				
			</tr>
		</table>
		
	</body>
</html>