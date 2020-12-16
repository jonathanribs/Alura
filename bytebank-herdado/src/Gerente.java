
public class Gerente extends FuncionarioAutenticavel {

	
	public double getBonificacao() {
		System.out.println("Metodo do Gerente");
		return super.getSalario();
	}
		
}
