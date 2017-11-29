package pr2048;


public class Board {
	private int _boardSize;
	private Cell  [][] _board = new Cell [_boardSize][_boardSize];


	public Board(int _boardSize) {
		super();
		_board = new Cell [_boardSize][_boardSize];
		this._boardSize = _boardSize;
	}

	/**
	 * @return : Muestra el tamaño del tablero.
	 */
	public int get_boardSize() {
		return _boardSize;
	}

	/**
	 * Modifica el tamaño del tablero.
	 * @param _boardSize
	 */
	public void set_boardSize(int _boardSize) {
		this._boardSize = _boardSize;
	}

	/**
	 * @return : Muestra el tablero.
	 */
	public Cell[][] get_board() {
		return _board;
	}



	/** 
	 * @param a
	 * @param b
	 * @return Muestra el valor de la celda [a][b]
	 */
	public int valorCelda (int a, int b){
		return this._board[a][b].getValor();
	}

	/**
	 * @return : Devuelve el tablero "_board" inicializado.
	 */
	public Cell[][] inicializar(){

		for (int i = 0; i < _boardSize  ; i++){
			for(int j = 0; j< _boardSize; j++){
				_board [i][j]= new Cell (0);
			}
		}
		return _board;
	}

	/**
	 * método usado para modificar el valor de la baldosa de la posición pos con el valor value.
	 * @param pos
	 * @param value
	 */
	public void setCell(Position pos, int value){
		_board [pos.getX()][pos.getY()].setValor(value);

	}

	private MoveResult moverDerecha(){
		boolean movimiento = false;
		int puntos=0;
		int maximo=2;// fuera para la primera vez hay que comprobar que no haya un 4.
		Cell board [][]= this.get_board();
		int size = this.get_boardSize();
		//Cell celda1 = new Cell (0);
		//Cell celda2;
		//int pos = size-1;
		
		for (int j =0; j< size; j++){
			Position p = new Position (size-1,j);
			for(int i= size-2; i >=0; i--){
				Position posV = new Position (p.posicionVecina(Direccion.Right, size).getX(),j);
				if (!board[i][j].isEmpty()){
					if(board[p.getX()][p.getY()].isEmpty()){
						board[p.getX()][p.getY()].setValor(board[i][j].getValor());
						board[i][j].setValor(0);
						movimiento = true;
						
					}
					else if (board[p.getX()][j].doMerge(board[i][j])){
						p=posV;
						movimiento = true;
						puntos = puntos + board [p.getX()][p.getY()].getValor();
					}
					else{
						board [posV.getX()][j].setValor(board[i][j].getValor());
						if (i != posV.getX()){
							movimiento = true;
							board[i][j].setValor (0);

						}
						p=posV;
					}
				}
			}
		}		
		MoveResult infoMov = new MoveResult(movimiento, puntos, maximo);
		return infoMov;
	}
	
	private MoveResult moverIzquierda(){
		boolean movimiento = false;
		int puntos=0;
		int maximo=2;// fuera para la primera vez hay que comprobar que no haya un 4.
		Cell board [][]= this.get_board();
		int size = this.get_boardSize();
		
		for(int j =0; j< size; j++){
			Position p = new Position (0,j);
			for (int i = 1; i < size; i++){
				Position posV = new Position (p.posicionVecina(Direccion.Left, size).getX(), p.posicionVecina(Direccion.Left, size).getY());
				if (!board[i][j].isEmpty()){
					if(board[p.getX()][j].isEmpty()){
						board[p.getX()][j].setValor(board[i][j].getValor());
						board[i][j].setValor(0);
						movimiento = true;
					}
					else if (board[p.getX()][j].doMerge(board[i][j])){
						p=posV;
						movimiento = true;
						puntos = puntos + board [p.getX()][p.getY()].getValor();
						if (board[p.getX()][j].getValor()> maximo){
							maximo = board[p.getX()][j].getValor();
						}
					}
					else{
						board [posV.getX()][j].setValor(board[i][j].getValor());
						if (i != posV.getX()){
							movimiento = true;
							board[i][j].setValor (0);
						}
						p=posV;
					}
				}
			}
		}
		MoveResult infoMov = new MoveResult(movimiento, puntos, maximo);
		return infoMov;
	}
			
	private MoveResult moverArriba (){
		boolean movimiento = false;
		int puntos=0;
		int maximo=2;// fuera para la primera vez hay que comprobar que no haya un 4.
		Cell board [][]= this.get_board();
		int size = this.get_boardSize();
		
		for(int i =0; i< size; i++){
			Position p = new Position (i,0);
			for (int j = 1; j <size; j++){
				Position posV = new Position (p.posicionVecina(Direccion.Up, size).getX(), p.posicionVecina(Direccion.Up, size).getY());
				if (!board[i][j].isEmpty()){
					if(board[i][p.getY()].isEmpty()){
						board[p.getX()][p.getY()].setValor(board[i][j].getValor());
						board[i][j].setValor(0);
						movimiento = true;
					}
					else if (board[i][p.getY()].doMerge(board[i][j])){
						p=posV;
						movimiento = true;
						puntos = puntos + board [p.getX()][p.getY()].getValor();
						if (board[i][p.getY()].getValor()> maximo){
							maximo = board[p.getX()][p.getY()].getValor();
						}
					}
					else{
						board [posV.getX()][posV.getY()].setValor(board[i][j].getValor());
						if (j != posV.getY()){
							movimiento = true;
							board[i][j].setValor (0);
						}
						p=posV;
					}
				}
			}
		}
		MoveResult infoMov = new MoveResult(movimiento, puntos, maximo);
		return infoMov;
	}
	
	private MoveResult moverAbajo(){
		boolean movimiento = false;
		int puntos=0;
		int maximo=2;// fuera para la primera vez hay que comprobar que no haya un 4.
		Cell board [][]= this.get_board();
		int size = this.get_boardSize();
		
		for(int i =0; i< size; i++){
			Position p = new Position (i,size-1);
			for (int j = size-2; j >= 0; j--){
				Position posV = new Position (p.posicionVecina(Direccion.Down, size).getX(), p.posicionVecina(Direccion.Down, size).getY());
				if (!board[i][j].isEmpty()){
					if(board[i][p.getY()].isEmpty()){
						board[i][p.getY()].setValor(board[i][j].getValor());
						board[i][j].setValor(0);
						movimiento = true;
					}
					else if (board[i][p.getY()].doMerge(board[i][j])){
						p=posV;
						movimiento = true;
						puntos = puntos + board [p.getX()][p.getY()].getValor();
						if (board[i][p.getY()].getValor()> maximo){
							maximo = board[i][p.getY()].getValor();
						}
					}
					else{
						board [i][posV.getY()].setValor(board[i][j].getValor());
						if (j != posV.getY()){
							movimiento = true;
							board[i][j].setValor (0);
						}
						p=posV;
					}
				}
			}
		}
		
		MoveResult infoMov = new MoveResult(movimiento, puntos, maximo);
		return infoMov;
	}

	
	

	/**
	 * @param dir
	 * @return : Devuelve la información del moviento en función de la direccon dir.
	 */
	public MoveResult executeMove(Direccion dir){
		MoveResult res = new MoveResult (false,0,0);

		if (dir == Direccion.Right)	{
			/*función privada que mueva a la derecha y me devuelva el MoveResult que tengo
			 	 que devolver en esta función.*/

			res = this.moverDerecha();
		}

		else if(dir == Direccion.Left){

			res = this.moverIzquierda();
		}
		else if (dir == Direccion.Up){
			res = this.moverArriba();
		}
		else if (dir == Direccion.Down){
			res = this.moverAbajo();
		}


		return res ; 
	}

	public String toString(){
		int tamFilas = _boardSize*2;
		int tamCols =  _boardSize*2;
		String tablero = "";
		String space = " ";
		String vDelimiter = "|";
		String hDelimiter = " ";
		for(int h = 0; h < _boardSize*8-1; h++){
			hDelimiter += "-";
		}


		for(int i = 0; i <=  tamFilas; i++){
			if(i % 2 == 0){
				tablero+=hDelimiter;
			}
			else{

				for(int j = 0; j <= tamCols;j++){
					if(j%2 == 0 ){
						tablero += vDelimiter;
					}
					else{
						if(!_board[j/2][i/2].isEmpty()){
							if ( _board[j/2][i/2].getValor()> 512){
								tablero += space+ _board[j/2][i/2].getValor()+ space+space;
							}
							else if ( _board[j/2][i/2].getValor()> 64){
								tablero += space + space + _board[j/2][i/2].getValor()+ space + space;
							}
							else if ( _board[j/2][i/2].getValor()> 8){
								tablero += space + space+  _board[j/2][i/2].getValor()+space+space + space;
							}
							else {
								tablero+= space + space + space + _board[j/2][i/2].getValor() + space + space + space;
							}
						}
						else{
							tablero+= space + space + space + space + space + space + space;
						}
					}

				}
			}

			tablero+= "\n";
		}
		return tablero;

	}



	/**
	 * Comprueba si la posicion [i][j] esta vacia.
	 * @return : Devuelve un booleano 
	 */
	public boolean hayEspacio(){
		boolean espacio = false;
		int i =0;
		int j = 0;

		while( j< _boardSize && !espacio){
			while( i< _boardSize&& !espacio){
				if (_board[i][j].isEmpty()){
					espacio = true;
				}
				i++;
			}
			i=0;
			j++;
		}

		return espacio;
	}

	/**
	 * Comprueba si se puede hacer el movimiento de fusionar dos baldosas.
	 * @return : Devuelve un booleano.
	 */
	public boolean hayDoMerge(){
		boolean merge = false;
		int j =0;
		int i =0;

		while( j< _boardSize && !merge){
			while( i< _boardSize&& !merge){
				Position pos = new Position (i,j);
				if (_board[i][j].getValor() == _board [pos.posicionVecina(Direccion.Down, _boardSize).getX()][pos.posicionVecina(Direccion.Down, _boardSize).getY()].getValor()&& !pos.posicionesIguales(pos.posicionVecina(Direccion.Down, this._boardSize))){
					merge = true;
				}
				else if (_board[i][j].getValor() == _board [pos.posicionVecina(Direccion.Left, _boardSize).getX()][pos.posicionVecina(Direccion.Left, _boardSize).getY()].getValor()&&  !pos.posicionesIguales(pos.posicionVecina(Direccion.Left, this._boardSize))){
					merge = true;
				}
				else if (_board[i][j].getValor() == _board [pos.posicionVecina(Direccion.Right, _boardSize).getX()][pos.posicionVecina(Direccion.Right, _boardSize).getY()].getValor()&&  !pos.posicionesIguales(pos.posicionVecina(Direccion.Right, this._boardSize))){
					merge = true;
				}
				else if (_board[i][j].getValor() == _board [pos.posicionVecina(Direccion.Up, _boardSize).getX()][pos.posicionVecina(Direccion.Up, _boardSize).getY()].getValor()&&  !pos.posicionesIguales(pos.posicionVecina(Direccion.Up, this._boardSize))){
					merge = true;
				}
				i++;
			}
			i=0;
			j++;
		}

		return merge;
	}

	/**
	 * Comprueba si se puede realizar la fusion de baldosas 
	 *     o si hay un espacio en blaco para un posible movimiento.
	 * @return : Devuelve un booleano.
	 */
	public boolean hayMov(){
		boolean mov = false;

		if (hayEspacio() || hayDoMerge()){
			mov = true;
		}

		return mov;
	}


}
