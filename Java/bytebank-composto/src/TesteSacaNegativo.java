
public class TesteSacaNegativo {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.deposita(100);
		conta.saca(200);
		System.out.println(conta.saca(101));
		
		//Não funciona mais agora que o atributo "saldo" é privado
		//System.out.println(conta.saldo);
				
		//conta.saldo -= 101;
		//System.out.println(conta.saldo);
		
		conta.saca(101);
		System.out.println(conta.getSaldo());
		
	}

}
