package plane;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import util.GameUtil;
import util.Myframe;

public class Plane extends Myframe{
	Image img;
	double x,y;
	
	
	
	public Plane(String imgpath,double x,double y) {
		// TODO Auto-generated constructor stub
		super();			
		this.img=GameUtil.getImage(imgpath);
		this.x=x;
		this.y=y;
	}
	public void draw(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	}
	public Plane() {
	}
	
	public void move(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37:
			x -= 10;
			break;
		case 38:
			y -= 10;
			break;
		case 39:
			x += 10;
			break;
		case 40:
			y += 10;
			break;
		default:
			break;
		}
	}
}
