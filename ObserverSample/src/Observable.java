public interface Observable {

	/**
	 * Assinatura para registrar novo Observer
	 * 
	 * @param observer
	 */
	public void registerObserver(Observer observer);

	/**
	 * Assinatura para remover Observer
	 * 
	 * @param observer
	 */
	public void removeObserver(Observer observer);

	/**
	 * Assinatura para notificação dos Observers
	 */
	public void notifyObservers();
}
