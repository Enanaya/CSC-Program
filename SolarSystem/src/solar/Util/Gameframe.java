package solar.Util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Gameframe extends Frame {

	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		setSize(Constant.Game_Width, Constant.Game_Heigth);
		setLocation(100, 100);
		setVisible(true);

		new PaintThread().start();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
/**
 * 定义一个重画窗口的线程，内部类
 */
	class PaintThread extends Thread{
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
