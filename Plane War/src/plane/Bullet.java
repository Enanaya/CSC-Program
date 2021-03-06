package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import util.Constant;

public class Bullet {
	double x=Constant.Bullet_x_Location
	,y=Constant.Bullet_y_Location;
	int speed=7;
	double degree;
	int width=10,height=10;
	
	public void draw(Graphics g) {
		Color color=g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, width, height);
		
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if (y>Constant.Game_Heigth-height-30 || y<height+30 ) {
			degree=-degree;
		}
		if (x>Constant.Game_Width-width-30 || x<width+30 ) {
			degree=Math.PI-degree;
		}
		
		
		g.setColor(color);
	}
	
	public Rectangle getRect() {
		Rectangle r=new Rectangle((int)x, (int)y, width,height);
		return r;
	}
	
	
	public Bullet() {
		// TODO Auto-generated constructor stub
		degree=Math.random()*Math.PI*2;
	}
	
}
