public class BalancaDietaFeminina implements Observer {

	@Override
	public void update(double peso) {
		if (peso >= 70)
			System.out.println("Mulher acima do peso!");
		else
			System.out.println("Mulher com peso normal!");
	}

	@Override
	public String observerName() {
		return getClass().getName();
	}

}
