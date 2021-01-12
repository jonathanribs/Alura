package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		System.out.println(banco.getEmpresas().get(0).getNome()); //S� para confirmar que foi executado e a lista criada
		
		PrintWriter out = response.getWriter();
		out.println("<html><body> Empresa " + nomeEmpresa  +  " cadastrada com sucesso </body></http>");				
	}

}
