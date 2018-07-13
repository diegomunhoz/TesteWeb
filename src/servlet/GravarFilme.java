package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarFilme extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getParameter("nomeDoFilme"));
		System.out.println(req.getParameter("nomeDoFilme"));
		
		// Captura a referencia ao objeto PrintWriter que exites em resp
		PrintWriter gravador = resp.getWriter();
		
		// Escreve o código HTML
		gravador.println("<html>");
		gravador.println("<head><title>Filme Gravado</title></head>");
		gravador.println("<body>");
		gravador.println("<h1>Filme Gravado com sucesso</h1><br/>");
		gravador.println("Nome do Filme:" + req.getParameter("nomeDoFilme")+ "<br/>");
		gravador.println("Valor do Filme:" + req.getParameter("valorDoFilme")+ "<br/>");
		gravador.println("<a href='http://localhost:8080/TesteWeb'>Voltar</a>");
		gravador.println("</body>");
		gravador.println("</body>");
		
	}

}