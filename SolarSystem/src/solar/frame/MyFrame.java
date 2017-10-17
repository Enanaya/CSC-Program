package solar.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Window;

import solar.Util.Gameframe;

public class MyFrame extends Gameframe {

	public static void main(String[] args) {
		new MyFrame().launchFrame();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Circle circle=new Circle(100, 450, 350);
		circle.draw(g);
	}
	
}
