
public class TestaCondicional2 {

	public static void main(String[] args) {
		System.out.println("Testando condicionais");
		int idade = 20;
		int quantidadePessoas = 2;
		boolean acompanhado = quantidadePessoas >= 2;
		
		System.out.println("valor de acompanhado = " + acompanhado);
		
		// ou � ||
		if (idade >= 18 && acompanhado) {
			System.out.println("seja bem vindo");
		} else {
			System.out.println("Infelizmente voce nao pode entrar");
		}

	}
}
