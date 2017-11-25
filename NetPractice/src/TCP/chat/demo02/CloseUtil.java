package TCP.chat.demo02;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author 76500
 * 关闭流的方法
 */
public class CloseUtil {
	public static void closeAll(Closeable ...io) {
		for (Closeable closeable : io) {
			if (null!=closeable) {
				try {
					closeable.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
