public class Teste {

	public static void main(String[] args) {

		BalancaDietaMasculina balancaM = new BalancaDietaMasculina();
		BalancaDietaFeminina balancaF = new BalancaDietaFeminina();

		Dieta dieta = new Dieta();
		dieta.registerObserver(balancaM);
		dieta.registerObserver(balancaF);

		dieta.setPeso(65);

	}
}
