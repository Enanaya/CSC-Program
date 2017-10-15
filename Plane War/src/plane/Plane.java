package plane;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import util.GameUtil;
import util.Myframe;

public class Plane extends GameObject{
	
	boolean live=true;
	
	boolean left,up,right,down;
	
	public boolean isLive() {
		return live;
	}
	
	public void setLive(boolean live) {
		this.live = live;
	}
	
	public Plane(String imgpath,double x,double y) {
		// TODO Auto-generated constructor stub
		super();			
		this.img=GameUtil.getImage(imgpath);
		this.x=x;
		this.y=y;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
	}
	public void draw(Graphics g) {
		if (live) {
			g.drawImage(img, (int)x, (int)y, null);
			move();
		}
		
	}
	public Plane() {
		
	}
	
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=true;
			break;
		case KeyEvent.VK_UP:
			up=true;
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			break;
		case KeyEvent.VK_DOWN:
			down=true;
			break;
		default:
			break;
	}
		}
	
	public void delDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=false;
			break;
		case KeyEvent.VK_UP:
			up=false;
			break;
		case KeyEvent.VK_RIGHT:
			right=false;
			break;
		case KeyEvent.VK_DOWN:
			down=false;
			break;
		default:
			break;
		}
	}
		
	
	public void move() {
		speed=10;
		if (left) {
			x-=speed;
		}
		if (right) {
			x+=speed;
		}
		if (down) {
			y+=speed;
		}
		if (up) {
			y-=speed;
		}
	}
}
