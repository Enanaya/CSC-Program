package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import util.GameUtil;
import util.Myframe;

public class plane_gameframe extends Myframe {

	Image bg = GameUtil.getImage("img/bg.jpg");
	Plane p = new Plane("img/plane.png", 50, 50);
	ArrayList<Bullet> bullets=new ArrayList<Bullet>();

	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		// g.drawImage(plane, 50, 50, null);
		p.draw(g);
		for (Bullet bullet : bullets) {
			bullet.draw(g);
		}
	}

	public static void main(String[] args) {
		new plane_gameframe().launchFrame();
	}

	@Override
	public void launchFrame() {
		super.launchFrame();
		// 增加键盘监听
		addKeyListener(new KetMonitor());

		//create bullets
		for (int i = 0; i < 50; i++) {
			Bullet b=new Bullet();
			bullets.add(b);
		}
	}

	// catch keyboard event
	// inner class to use outside class method or field
	class KetMonitor extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			p.move(e);
			System.out.println("按下：" + e.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			// super.keyReleased(e);
			System.out.println("释放：" + e.getKeyCode());
		}
	}
}
