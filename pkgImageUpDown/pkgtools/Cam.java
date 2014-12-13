package pkgImageUpDown.pkgtools;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import pkgutil.DateUtil;

public class Cam {
	private String fileName; 
	private String defaultName = "GuiCamera";
	private String imageFormat; 
	private String defaultImageFormat = "png";
	// private int
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	public Cam() {
		fileName = defaultName;
		imageFormat = defaultImageFormat;

	}
	public Cam(String s, String format) {

		fileName = s;
		imageFormat = format;
	}
	public void snapShot() {

		try {
			BufferedImage screenshot = (new Robot())
					.createScreenCapture(new Rectangle(0, 0,
							(int) d.getWidth(), (int) d.getHeight()));
			String name = null;
			if (StaticTools.isFirstPoint) {
				name = StaticTools.imagePath;
				StaticTools.FirstCap = name;
			}else{
				StaticTools.serialNum++;
				// name = fileName+String.valueOf(serialNum) + "sub" +
				// "."+imageFormat;
				name = StaticTools.Path + "[" + StaticTools.serialNum + "]" + DateUtil.getCurrentDate("yyyy-MM-dd HH-mm-ss") + "." + StaticTools.imageFormat;
				StaticTools.imageMap.put(StaticTools.serialNum, name);
			}
			File f = new File(name);
			System.out.print("Save File " + name);
			if (StaticTools.isFirstPoint) {
				ImageIO.write(screenshot, StaticTools.imageFormat, f);
			} else {
				System.out.println(name);
				ImageIO.write(screenshot.getSubimage(StaticTools.x1,
						StaticTools.y1 + 17, Math.abs(StaticTools.x2 - StaticTools.x1),
						Math.abs(StaticTools.y2 - StaticTools.y1) + 2), StaticTools.imageFormat, f);
			}
			System.out.print("..Finished!\n");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
//		 Cam cam = new Cam();//
//		 cam.snapShot();
//		 StaticTools.isFirstPoint = false;
//		 StaticTools.x1 = 100;
//		 StaticTools.y1 = 100;
//		 StaticTools.x2 = 500;
//		 StaticTools.y2 = 500;
//		 cam.snapShot();
		// GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
		// .getDefaultScreenDevice();
		// gd.setFullScreenWindow(rd);
	}
}