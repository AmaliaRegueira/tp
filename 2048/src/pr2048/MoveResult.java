package pr2048;

public class MoveResult {

	private boolean moved;
	private int points;
	private int maxToken;
	private static final String NEWLINE = System.getProperty ("line.separador");
	
	/**
	 * @return : Devuelve un buleano indicando si se movido o no.
	 */
	public boolean isMoved() {
		return moved;
	}

	/**
	 * @return : Muestra la puntuacion.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @return : Muestra el valor maximo.
	 */
	public int getMaxToken() {
		return maxToken;
	}

	public MoveResult(boolean moved, int points, int maxToken) {
		super();
		this.moved = moved;
		this.points = points;
		this.maxToken = maxToken;
	}
	
	@Override
	/**
	 * Imprime por pantalla.
	 */
	public String toString(){
		return "Puntuación: " + this.points + NEWLINE + "Máximo: " + this.maxToken;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
