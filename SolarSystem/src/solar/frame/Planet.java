package solar.frame;

import java.awt.Color;
import java.awt.Graphics;

public class Planet extends MyFrame{ //Planet can move with a line,surrounding a star
	private int r, x, y;
	private Color c;
	double longaxis,shortaxis,speed,degree;
	Solar center;
	
	public Planet(int r,  Color c, double longaxis, double shortaxis, 
			double speed, Solar center,double degree) {
		
		this.r=r;
		this.c=c;
		this.longaxis = longaxis;
		this.shortaxis = shortaxis;
		this.speed = speed;
		this.center = center;
		this.x=center.x+(int)longaxis;
		this.y=center.y+(int)shortaxis;
		this.degree=degree;
	}


	public void draw(Graphics g) {
//		while (true) {
//			try {
//				Thread.sleep(50);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
		   
			g.setColor(c);
			x=(int) (center.x+longaxis*Math.cos(degree));
			y=(int) (center.y+shortaxis*Math.sin(degree));
			degree+=speed;
			repaint();
			g.fillOval(x, y, r, r);
//		}
			
		
	}
	
	
}
