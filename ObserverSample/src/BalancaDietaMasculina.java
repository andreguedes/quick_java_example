public class BalancaDietaMasculina implements Observer {

	@Override
	public void update(double peso) {
		if (peso >= 100)
			System.out.println("Homem acima do peso!!!");
		else
			System.out.println("Homem com peso normal!");
	}

	@Override
	public String observerName() {
		return getClass().getName();
	}

}
