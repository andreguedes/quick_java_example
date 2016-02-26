import java.util.ArrayList;
import java.util.List;

public class Dieta implements Observable {

	private List<Observer> observers = new ArrayList<Observer>();
	private double peso;

	public void setPeso(double peso) {
		this.peso = peso;
		this.notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			System.out.println("Notificando Observer "
					+ observer.observerName());
			observer.update(this.peso);
		}
	}

}
