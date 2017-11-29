package pr2048;

import java.util.Scanner;

public class Controller {
	private Game game;
	private Scanner in;
	
	
	//static  String NEWLINE = System.getProperty ("line.separador");
	static String NEWLINE = "/n";
	
	public Controller(Game game, Scanner in) {
		super();
		this.game = game;
		this.in = in;
	}

	/**
	 * Realiza la simulación del juego.
	 * Mientras la partida no esté finalizada, solicita una orden al usuario
	 *	 y la ejecuta invocando a algún método de la clase Game a través
	 * 	 de su atributo game
	 * Excepto para el comando help que imprime la ayuda del juego.
	 */
	public void run (){
		String movimiento;
		
		
		this.game.toString(); //imprimo score y max
		System.out.println(this.game.get_board().toString());// imprimo tablero		
		System.out.print("Command > ");
		movimiento = in.nextLine();
		movimiento.toLowerCase();
		boolean salir = false;
		
		while (!salir && game.get_board().hayMov() && game.getMaximo() != ganado){
			
			this.game.toString(); //imprimo score y max
							
			
			switch (movimiento){
			case "move right": 
				this.game.move(Direccion.Right);
				if (game.get_board().hayEspacio()) this.game.insertarNum(1);	
				System.out.println(this.game);// imprimo tablero
				System.out.print("Command > "); 
				movimiento = in.nextLine();
				movimiento.toLowerCase();
				
				
			break;
			
			case "move left":
				this.game.move(Direccion.Left);
				if (game.get_board().hayEspacio()) this.game.insertarNum(1);
				System.out.println(this.game.get_board().toString());// imprimo tablero
				System.out.print("Command > "); 
				movimiento = in.nextLine();
				movimiento.toLowerCase();
				
			break;
			
			case "move up":
				this.game.move(Direccion.Up);
				if (game.get_board().hayEspacio()) this.game.insertarNum(1);
				System.out.println(this.game.get_board().toString());// imprimo tablero
				System.out.print("Command > "); 
				movimiento = in.nextLine();
				movimiento.toLowerCase();
				
			break;
			
			case "move down":
				this.game.move(Direccion.Down);
				if (game.get_board().hayEspacio()) this.game.insertarNum(1);
				System.out.println(this.game);// imprimo tablero
				System.out.print("Command > "); 
				movimiento = in.nextLine();
				movimiento.toLowerCase();
				
			break;
		
			case "help":
			    System.out.println ("Move <direction>: execute a move in one of the four directions, up, down, left, right"+ NEWLINE);
				System.out.println ("Reset: start a new game" + NEWLINE);
				System.out.println ("Help: print this help message" + NEWLINE);
				System.out.println ("Exit: terminate the program" + NEWLINE );
				System.out.println ("Command > "); 
				movimiento = in.nextLine();
				movimiento.toLowerCase();
			    
			break;
			case "exit":
				System.err.println("GAME OVER!");
				salir = true;
				break;
			
			case "reset":
				this.game.inicializar();
				System.out.println(this.game.get_board().toString());// imprimo tablero
				System.out.print("Command > "); 
				movimiento = in.nextLine();
				movimiento.toLowerCase();
				
			break;
			
			default :
				System.err.println("WRONG COMMAND!");
				System.out.print("Command > "); 
				movimiento = in.nextLine();
				movimiento.toLowerCase();
			}
			
		}
		
		if(!salir){
			if (game.getMaximo() == ganado){
				System.out.println("You've won!");
			}
			else{
				System.err.println("GAME OVER!");	
			}	
		}
			
	}
	
}
