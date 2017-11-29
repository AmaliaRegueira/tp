package pr2048;

import java.util.Scanner;
import java.util.Random;

/**
 * @author Amalia Regueira Fernandez
 * @author Tamara Huertas Smolis
 */

public class Game2048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*int size = Integer.parseInt(args[0]);
		int numInitial = Integer.parseInt(args[1]);*/
		int size = 4;
		int numInitial = 16;
		
		long seed = new Random().nextInt(5);
		//long seed = Long.parseLong(args[2]); // Si hay un tercer argumento 

		Scanner sc = new Scanner (System.in);
		Random rand = new Random(); 
		rand.setSeed(seed);
				
		Game juego = new Game (size, numInitial, rand);
		
		Controller controlador = new Controller (juego, sc);
		controlador.run();	
	}
}
