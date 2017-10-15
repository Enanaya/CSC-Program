package plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import util.Constant;
import util.GameUtil;
import util.Myframe;

public class plane_gameframe extends Myframe {

	Image bg = GameUtil.getImage("img/bg.jpg");
	Plane p = new Plane("img/plane.png", 50, 50);
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	Date starttime, endtime;
	Explode explode;

	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		// g.drawImage(plane, 50, 50, null);
		p.draw(g);
		for (Bullet bullet : bullets) {
			bullet.draw(g);

			boolean peng = bullet.getRect().intersects(p.getRect());
			if (peng) {
				p.setLive(false);

				if (explode == null) {
					endtime = new Date();
					explode = new Explode(p.x, p.y);
				}
				explode.draw(g);
			}
			// System.out.println(peng);
			if (p.isLive() == false) {
				printInfo("Game Over", 50, g, Constant.Game_Width / 2 - 100, Constant.Game_Heigth / 2);
				long period = (endtime.getTime() - starttime.getTime()) / 1000;
				printInfo("生存时间:" + period + "s", 20, g, Constant.Game_Width / 2 - 100, Constant.Game_Heigth / 2 + 50);
				// g.dispose();

			}
		}
	}

	// 在窗口打印信息,现在是gameover
	public void printInfo(String str, int size, Graphics g, int x, int y) {
		Color c = g.getColor();
		g.setColor(Color.white);
		Font font = new Font("宋体", Font.BOLD, size);
		g.setFont(font);
		g.drawString(str, x, y);
		g.setColor(c);
	}

	public static void main(String[] args) {
		new plane_gameframe().launchFrame();
	}

	@Override
	public void launchFrame() {
		super.launchFrame();
		// 增加键盘监听
		addKeyListener(new KetMonitor());

		// create bullets
		for (int i = 0; i < 50; i++) {
			Bullet b = new Bullet();
			bullets.add(b);
		}

		starttime = new Date();
	}

	// catch keyboard event
	// inner class to use outside class method or field
	class KetMonitor extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			p.addDirection(e);
			// System.out.println("按下：" + e.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			// super.keyReleased(e);
			 System.out.println("释放：" + e.getKeyCode());
			p.delDirection(e);
		}
	}
}
