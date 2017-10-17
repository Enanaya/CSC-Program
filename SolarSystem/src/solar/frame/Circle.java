package solar.frame;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends MyFrame{
	
	private int r,x,y;
	
	public Circle(int r,int x,int y) { 
		this.r=r;
		this.x=x;
		this.y=y;
//		paint(super.getGraphics());
	}
	
	
	public void draw(Graphics g) {
		g.drawOval(x, y, r, r);
	}
}
