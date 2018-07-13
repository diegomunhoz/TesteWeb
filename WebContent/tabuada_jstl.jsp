<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Tabuada JSTL</title>
	</head>
	<body>
	<a href="index.html">Página principal</a>
	<h1>Tabuada</h1>
	<table border="0">
	<c:forEach begin="0" end="10" var="i"> 
		<c:if test="${i%2 == 0}">
			<tr bgcolor="gray">
		</c:if>
		<c:if test="${i%2 != 0}">
			<tr>
		</c:if>
			<td>${i} x 7 = ${i*7}</td>
		</tr>
	</c:forEach>
	</table>
	</body>
</html>