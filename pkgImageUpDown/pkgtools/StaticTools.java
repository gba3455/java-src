package pkgImageUpDown.pkgtools;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticTools {

	public static String Path = "/users/sqzs/desktop/homework/";
	
	public static String imageName = "img";
	
	public static String imageFormat = "jpg";
	
	public static String subImageName = "sub.png";
	
	public static String imagePath = Path + imageName + "." + imageFormat;
	
	public static String hostName = "server23.mluyuan.cn";
	
	public static String userName = "u539756411";
	
	public static String passWord = "345566";
	
	public static String remotePath = "/public_html/image/";
	
	public static boolean downloadFlag = false;
	
	public static int serialNum = 0;
	
	public static Map<Integer,String> imageMap = new HashMap<Integer, String>();
	
	public static String FirstCap = "";
	

	public static List<String> localfiles;

	public static List<String> tubeDownload = new ArrayList<String>();
	
	public static Map<Integer,String> tubeDownloadMap = new HashMap<Integer, String>();

	
	public static int x1 = 0,y1 = 0,x2 = 0,y2 = 0;
	
	public static Point start,end;
	
//	public static boolean isFirstSnape = true;
	
	public static boolean isFirstPoint=true;
	
	public static String getSubImagePath(int num){
			return imageMap.get(num);
	}
}
