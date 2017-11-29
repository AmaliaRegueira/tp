package pr2048;

public class Cell {
	
	/**
	 * @return : Muestra el valor.
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Modifica el valor.
	 * @param valor
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	private int valor;
	
	public Cell (int valor) {
		super();
		//this.pos = pos;
		this.valor = valor;
	}
	
	/**
	 * Comprueba si el valor de la baldosa es 0.
	 * @return : Devuelve un booleano.
	 */
	public boolean isEmpty(){
		boolean empty = false;
		
		if (this.valor == 0){
			empty = true;
		}
		
		return empty;
	}
	
	/**
	 * Comprueba si se puede hacer la fusion de un baldosa con la baldosa vecina.
	 * Si es posible la fusion de las baldosas. 
	 * @param neighbour
	 * @return : Devuelve un booleano.
	 */
	public boolean doMerge(Cell neighbour) {
		boolean igual = false;
		
		if (neighbour.valor == this.valor){
			igual = true;
			this.setValor(this.getValor() + neighbour.getValor());
			neighbour.setValor(0);
		}
		
		return igual;
	}
	
}
