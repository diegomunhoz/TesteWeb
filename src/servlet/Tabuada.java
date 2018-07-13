package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tabuada extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter gravador = resp.getWriter();
		gravador.println("<html>");
		gravador.println("<head><title>Tabuada</title></head>");
		gravador.println("<body>");
		gravador.println("<a href=\"index.html\">Página principal</a>");
		gravador.println("<h1>Tabuada</h1>");
			for (int i = 0; i <= 10; i++) {
				gravador.println(i + " x 7 = " + (i*7) + "</br>");
			}
		gravador.println("</body>");
		gravador.println("</html>");
		
	}
}
