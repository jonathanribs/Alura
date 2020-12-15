
public class Fatorial {
	
	public static void main(String[] args) {
		
		for(int n = 1; n <= 10; n++) {
			int fatorial = 1;
			for(int auxiliar = n; auxiliar >= 1; auxiliar--) {
				fatorial = fatorial * auxiliar;  
			}
			System.out.println("O fatorial de " + n + " é " + fatorial);
		}
		
		//Implementacao do instrutor
		int fatorial = 1;
        for (int i = 1; i < 11; i++) {
            fatorial *= i;
            System.out.println("Fatorial de " + i + " = " +fatorial);
        }

	}

}
