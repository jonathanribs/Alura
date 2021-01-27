package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Notebook Dell Inspiron");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/61qTUhLexrL._AC_SL1030_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Notebook-Dell-Inspiron-I15-3583-As80P-Gera%C3%A7%C3%A3o/dp/B08HN93WDL?ref_=Oct_s9_apbd_otopr_hd_bw_bHrUqLT&pf_rd_r=68DR93XXMZWW1WTVZT2V&pf_rd_p=ae2a6e14-5e57-57d1-a7c7-38f2deae6a08&pf_rd_s=merchandised-search-10&pf_rd_t=BROWSE&pf_rd_i=16364755011");
		pedido.setDescricao("Notebook Dell com placa de video");
		
		List<Pedido> pedidos = Arrays.asList(pedido, pedido);
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
}
