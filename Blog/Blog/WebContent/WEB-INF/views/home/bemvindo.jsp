<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Bem-vindo!!</title>
	</head>
	
	<body>
		<table width="800px" align="center" border="1">
			<tr>
				<td colspan="5" height="100px"></td>
			</tr>
			<tr>
				<c:forEach items="${assuntoList}" var="assunto">
					<td align="center" ><a href="${assunto.mapeamento}/${assunto.id}">${assunto.descricao}</a></td>
				</c:forEach>
			</tr>
			<tr>
				<td colspan="5" height="400px"></td>
			</tr>
			<tr>
				<td colspan="5" height="50px"></td>
			</tr>
		</table>
	</body>
</html>