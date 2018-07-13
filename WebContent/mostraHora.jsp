<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Exibe hora pelo JSP</title>
	</head>
	<body>
		<a href="index.html">Página Inicial</a>
		<h1>Hora do Servidor - JSP</h1>
		<%
			out.println(new java.util.Date());
		%>
	</body>
</html>