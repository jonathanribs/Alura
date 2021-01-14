package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		//podia ser usado tbm request.getRequestURI() para direcionar usando o nome da URL mesmo, mas pra isso deve-se mudar o mapeamento para / [@WebServlet("/")] e tamb�m todos os arquivos que foram adaptados para enviar o parametro acao
		
		String nome = null;
		
		if(paramAcao.equals("ListaEmpresas")) {			
			System.out.println("listando empresas");			
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);			
		} else if(paramAcao.equals("RemoveEmpresa")) {			
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request, response);		
		} else if(paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.executa(request, response);			
		} else if(paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			nome = acao.executa(request, response);
		} else if(paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request, response);			
		}
		
		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {	
			RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereco[1]);
			rd.forward(request, response);
		} else {		
			response.sendRedirect(tipoEEndereco[1]);
		}
		
	}

}
