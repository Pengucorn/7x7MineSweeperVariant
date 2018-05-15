import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Game {
	static int[][] grid;
	public static void main(String[] args) {
		Game.grid = new int[7][7];
		
		//make the bottom row safe
		for(int i = 0; i < 7; i++) {
			Game.grid[i][6] = 1; //storing 1 as safe
		}
		
		//Generate a path from the bottom row to the top row
		Random rand = new Random();
		int start = rand.nextInt(7); //Random number from 0-6 for the start position
		int next; 
		for( int i = 1; i < 7; i++) {
			if( start == 0 ){
				next = rand.nextInt(2); // Random 0 or 1
			}else if( start == 6){
				next = rand.nextInt(2) - 1; //Random -1 or 0
			}else {
				next = rand.nextInt(3) - 1; //Random -1 0 or 1
			}
			Game.grid[start+next][6-i] = 1;
		}
		
		//Randomly place 7 skulls
		int skull = 7;
		while(skull > 0) {
			int x = rand.nextInt(7);
			int y = rand.nextInt(7);
			if( Game.grid[x][y] != 1 && Game.grid[x][y] != 2) {
				Game.grid[x][y] = 2;
				skull--;
			}
		}
		
		JFrame main = new JFrame("7x7 Minesweeper Variant");
		main.setLayout(null);
		main.setSize(367,397);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for( int i = 0; i < 7; i++) {
			for( int j = 0; j < 7; j++) {
				Tile temp = new Tile(i,j);
				main.add(temp);
			}
		}
		
		main.setVisible(true);
	}
	
}
