package solar.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Window;

import solar.Util.Constant;
import solar.Util.Gameframe;

public class MyFrame extends Gameframe  {

	public static void main(String[] args) {
		new MyFrame().launchFrame();
	}

	@Override
	public void paint(Graphics g) {
//		super.paint(g);
		
		Solar sun=new Solar(60, Constant.Game_Width/2, 
				Constant.Game_Heigth/2,Color.ORANGE); //draw the solar
		sun.draw(g);
		
		Planet planet1=new Planet(30,Color.BLUE,100,50,0.1,sun,1);
		planet1.draw(g);
//		repaint();
	}
}
