package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	
	String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	//não precisa de colocar public abstract, pois isso é automatico para uma interface
}
