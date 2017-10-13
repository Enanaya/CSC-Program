package plane;

import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;
import util.Myframe;

public class plane_gameframe extends Myframe {

	Image bg=GameUtil.getImage("img/bg.jpg");
	Image plane=GameUtil.getImage("img/plane.png");
	
	public void paint(Graphics g) {
		g.drawImage(bg,0,0,null);
		g.drawImage(plane, 50, 50, null);
	}
	
	public static void main(String[] args) {
		new plane_gameframe().launchFrame();
	}
}
