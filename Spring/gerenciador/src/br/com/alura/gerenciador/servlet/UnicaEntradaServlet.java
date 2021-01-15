package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");

		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); //carrega a classe que tem o nome da String passada
			Object obj = classe.newInstance();
			Acao acao = (Acao)obj; //n�o precisava de usar a classe Object como intermediario, podia ser feito -> Acao acao = (Acao)classe.newInstance(); . Deixei a classe Object para eu me lembrar que ela existe...
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		// Essa parte do c�digo ia abaixo dos coment�rios...
		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {	
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {		
			response.sendRedirect(tipoEEndereco[1]);
		}
		
//		String nome = null;
//		
//		if(paramAcao.equals("ListaEmpresas")) {			
//			System.out.println("listando empresas");			
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);			
//		} else if(paramAcao.equals("RemoveEmpresa")) {			
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);		
//		} else if(paramAcao.equals("MostraEmpresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);			
//		} else if(paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);			
//		}else if(paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);			
//		}
		
	}

}
