package pr2048;

import java.util.Random;

public class Game {
	private int _size;
	private int _initCells;
	private Random _myRandom;
	private Board _board;
	private int puntuacion;
	private int maxValue;
	static final int PRC = 10;
	static final int ganado = 2048;
	
	//static String NEWLINE = System.getProperty ("line.separador");
	static String NEWLINE = "/n";

	public Game(int _size, int _initCells, Random _myRandom) {
		super();
		this._size = _size;
		this._initCells = _initCells;
		this._myRandom = _myRandom;
		_board =new Board (_size);
		
		inicializar();
	}
	
	/**
	 * @return : Muestra maxValue.
	 */
	public int getMaximo (){
		return maxValue;
	}
		
	@Override
	/**
	 * Imprime por pantalla.
	 */
	public String toString() {
		return _board.toString()+NEWLINE+ "Score: "+puntuacion + NEWLINE +"Highest: "+ maxValue + NEWLINE ;
	}
		
	/**
	 * @return : Muestra el tamaño.
	 */
	public int get_size() {
		return _size;
	}

	/**
	 * Modifica el tamaño.
	 * @param _size
	 */
	public void set_size(int _size) {
		this._size = _size;
	}

	/**
	 * @return : Muestra el tablero.
	 */
	public Board get_board() {
		return _board;
	}

	/**
	 * Modifica el tablero.
	 * @param _board
	 */
	public void set_board(Board _board) {
		this._board = _board;
	}
		
	/**
	 * Dependiendo de la direccion dir se crea un MoveResult con la informacion del movimiento.
	 * @param dir
	 */
	public void move (Direccion dir){
		int score = 0;			
		int maximo = 0;
		boolean hayMov = false;
				
		MoveResult mov = new MoveResult (hayMov, score, maximo);
		mov = this._board.executeMove(dir);
		puntuacion = puntuacion + mov.getPoints();
		if (maxValue < mov.getMaxToken()){
			maxValue = mov.getMaxToken();
		}
		
	}
		
	/**
	 * Inicializa el tablero "_board" con un valor Random.
	 */
	public void inicializar(){
		this._board.inicializar();
			
		puntuacion =0;
			
		
		insertarNum(this._initCells);	
		//this.maxValue = this._board.maxValor();
	}
	
	public void insertarNum( int celdasOcupar){
		int iniciales =0;
		while (iniciales < celdasOcupar){
			int num1 = this._myRandom.nextInt(this._size);
			int num2 = this._myRandom.nextInt(this._size);
			if (num1 > num2){
				maxValue = num1;
			}
			else {
				maxValue = num2;
			}
			if (this._board.valorCelda(num1,num2)== 0){
				int valor = this._myRandom.nextInt()% PRC;
				Position pos = new Position (num1, num2);
				if (valor == 0){
					this._board.setCell(pos, 4);
				}
				else{
					this._board.setCell(pos, 2);
				}
				iniciales++;
			}
		}	
	}

	/**
	 * Reinicia la partida, llevando al juego a la configuración inicial.
	 */
	public void reset (){
		this.inicializar();
	}
	
	public boolean isFinished (){
		boolean finished = false;
		
		if (this.maxValue== ganado){
			finished = true;
		}
		
		return finished;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
