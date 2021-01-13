package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa") 
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //criado automaticamente

	//protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e); //catch e re-throw - Como o método "pai" doPost é a sobrescrita de um método por polimorfismo, não se pode mudar nome, parâmetros E NEM EXCEPTIONS
			//Como não é possível fazer o throw direto, pois não se pode declarar nova exception em doPost, usou-se uma exception que já existia recebendo como parâmetro a exceção atual
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		response.sendRedirect("listaEmpresas"); //ATENÇÃO: aqui não tem a "/"
		request.setAttribute("empresa", empresa.getNome()); //esta variavel "pendurada" na requisição, não vai para a listaEmpresas pois desta forma que está feito é chamada uma nova requisição.
															//por isso não imprime a mensagem de nova empresa casatrada...

		
//		//chamar o JSP
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas"); //indicar um local para onde vamos despachar dados
//		request.setAttribute("empresa", empresa.getNome()); //mandar o nome da empresa "em anexo" a Request
//		rd.forward(request, response); //repassar a req e resp para frente, no caso para .jsp 		
		
	}

}
