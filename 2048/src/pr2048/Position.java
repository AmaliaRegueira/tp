package pr2048;


public class Position {
	
	private int x;
	private int y;
	
	/**
	 * Matriz constructora.
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	
	@Override
	/**
	 * Imprime por pantalla.
	 */
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	/**
	 * Comprueba si la posicion del tablro es valida.
	 * @param sizeBoard
	 * @return : Devuelve un buleano.
	 */
	public boolean comprueba (int sizeBoard){
		boolean valida = false;
		
		if (this.getY()>=0 && this.getX()>=0 && this.getX()< sizeBoard && this.getY() < sizeBoard){
			valida = true;
		}
		
		return valida;
	}
	
	/**
	 * Calcula la nueva posición.
	 * @param d
	 * @param sizeBoard
	 * @return : Si se mueve devuelve la nueva posicion, si no se puede mover devuelve la misma posicion.
	 */
	public Position posicionVecina (Direccion d,int sizeBoard){
		Position res = new Position (this.getX(), this.getY());
		
		if (d == Direccion.Left && res.comprueba(sizeBoard)){
			res.setX(x+1);
			if (!res.comprueba(sizeBoard)){
				res.setX(x);
			}
			
		}
		else if (d== Direccion.Right && res.comprueba(sizeBoard)){
			res.setX(x-1);
			if (!res.comprueba(sizeBoard)){
				res.setX(x);
			}
		}
		else if (d == Direccion.Down && res.comprueba(sizeBoard)){
			res.setY(y-1);
			if (!res.comprueba(sizeBoard)){
				res.setY(y);
			}
		}
		else if (res.comprueba(sizeBoard)){
			res.setY(y+1);
			if (!res.comprueba(sizeBoard)){
				res.setY(y);
			}
		}
		return res;
	}
	
	boolean posicionesIguales (Position pos){
		boolean iguales = false;
		
		if (this.getX() == pos.getX()){
			if (this.getY()== pos.getY()){
				iguales = true;
			}
		}
		
		return iguales;
	}


	/**
	 * @return : Muestra la coordenada X.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Modifica la coordenada X.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return : Muestra la coordenada Y.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Modifica la coordenada Y.
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
