package solar.frame;

import java.awt.Color;
import java.awt.Graphics;

public class Solar extends MyFrame {

	public int r, x, y;
	private Color c;

	public Solar(int r, int x, int y, Color c) {
		this.r = r;
		this.x = x;
		this.y = y;
		this.c = c;
		// paint(super.getGraphics());
	}
	

	public Solar() {
		super();
	}


	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, r, r);
	}
  
	
}

