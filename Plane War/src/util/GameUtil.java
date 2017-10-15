package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameUtil {
	private  GameUtil() {}

	public static Image getImage(String path) {
		BufferedImage img = null;
        URL url = GameUtil.class.getClassLoader().getResource(path);
        //System.out.println(url);
        try {
            img = javax.imageio.ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
	}
}
