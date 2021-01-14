package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/oi","/oii"}, loadOnStartup=1) //Pode ser passado um vetor {} de patterns com mapeamento para esta classe. 
								//loadOnStartup é para o Tomcat criar esta classe assim que se inicia, se não tiver esse parametro o Tomcat só inicia a classe quando ela é utitilizada (no caso seria ao buscar a url no navegador)
public class OiMundoServlet extends HttpServlet{
	
	public OiMundoServlet() {
		System.out.println("Criando Oi Mundo Servlet");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("oi mundo, parabens você escreveu o primeiro servlets.  ");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("o servlet OiMundoServlet foi chamado");
	}
}
