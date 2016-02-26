public class CorridaDeSapos {

	final static int NUM_SAPOS = 5;
	final static int DISTANCIA = 500;

	public static void main(String[] args) {
		for (int i = 0; i <= NUM_SAPOS; i++) {
			new SapoCorrendoThread("Sapo " + i, DISTANCIA).start();
		}
	}

}

class SapoCorrendoThread extends Thread {

	String nome;
	int distanciaTotalCorrida;
	int distanciaPercorrida = 0;
	int pulo = 0;
	int pulosDados = 0;

	static int colocacao = 0;
	final static int PULO_MAXIMO_SAPO = 50;

	public SapoCorrendoThread(String nome, int distanciaTotalCorrida) {
		super(nome);
		this.nome = nome;
		this.distanciaTotalCorrida = distanciaTotalCorrida;
	}

	public void imprimeSituacaoSapo() {
		System.out.println("O " + nome + " pulou " + pulo
				+ "cm\t e já percorreu " + distanciaPercorrida + "cm.");
	}

	public void fazSapoPular() {
		pulosDados++;
		pulo = (int) (Math.random() + PULO_MAXIMO_SAPO);
		distanciaPercorrida += pulo;

		if (distanciaPercorrida > distanciaTotalCorrida) {
			distanciaPercorrida = distanciaTotalCorrida;
		}
	}
	
	public void fazSapoDescansar() {
		yield();
	}
	
	public void colocacaoSapo() {
		colocacao++;
		System.out.println(nome + " foi o " + colocacao + "° colocado com " + pulosDados + " pulos.");
	}

	@Override
	public void run() {
		while (distanciaPercorrida < distanciaTotalCorrida) {
			fazSapoPular();
			imprimeSituacaoSapo();
			fazSapoDescansar();
		}
		colocacaoSapo();
	}

}