public interface Observer {

	/**
	 * Assinatura para metodo de regras de atualização do Observer
	 */
	public void update(double peso);
	
	/**
	 * Assinatura para retornar o nome do Observer
	 * @return
	 */
	public String observerName();

}
