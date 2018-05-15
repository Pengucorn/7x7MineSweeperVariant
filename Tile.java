import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Tile extends JButton implements ActionListener{

	private int x_pos;
	private int y_pos;
	private boolean pressed;
	
	Tile(int x, int y){
		this.x_pos = x;
		this.y_pos = y;
		this.pressed = false;
		
		this.setSize(50, 50);
		this.setLocation(x*50, y*50);
		
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int mine_counter = 0;
		
		if( Game.grid[x_pos][y_pos] == 2) {
			this.setText("X"); //you dead
		}else {
			for( int i = 0; i < 7; i++) {
				for( int j = 0; j < 7; j++) {
					if( i == x_pos || i == x_pos-1 || i == x_pos+1) {
						if(j == y_pos || j == y_pos-1 || j == y_pos+1) {
							if( Game.grid[i][j] == 2) {
								mine_counter++;
							}
						}
					}
				}
			}
			this.setText(Integer.toString(mine_counter));
		}
	}
	
	
}
