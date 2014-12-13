package pkgCAPTCHA;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import org.apache.commons.io.IOUtils;

public class Captcha {
	private static int THRESHOLD = 220;
	private static String IMAGEFORMAT = "jpg";
	private static String OUTPUTPATH = "/users/sqzs/desktop/";
	private static String OUTPUTNAME = "newPic.jpg";
	public static int isWhite(int intColor){
		Color color = new Color(intColor);
		if(color.getRed() + color.getBlue() + color.getGreen() > THRESHOLD){
			return 1;
		}
		return 0;
	}
	
	public static int isBlack(int intColor){
		Color color = new Color(intColor);
		if(color.getRed() + color.getGreen() + color.getBlue() < THRESHOLD){
			return 1;
		}
		return 0;
	}
	
	public static BufferedImage removeBackgorund(String picPath) throws IOException{
		BufferedImage img = ImageIO.read(new File(picPath));
		int width = img.getWidth();
		int height = img.getHeight();
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				if(isWhite(img.getRGB(x, y)) == 1){
					img.setRGB(x, y, Color.WHITE.getRGB());
				}else{
					img.setRGB(x, y, Color.BLACK.getRGB());
				}
			}
		}
		return img;
	}
	
	public static List<BufferedImage> splitImage(BufferedImage img){
		List<BufferedImage> imgList = new ArrayList<BufferedImage>();
		imgList.add(img.getSubimage(10, 6, 8, 10));
		imgList.add(img.getSubimage(19, 6, 8, 10));
		imgList.add(img.getSubimage(28, 6, 8, 10));
		imgList.add(img.getSubimage(37, 6, 8, 10));
		return imgList;
	}
	
	public static Map<BufferedImage,String> loadTrainPic() throws IOException{
		File file = new File("/users/sqzs/desktop/images/");
		File[] files = file.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(IMAGEFORMAT)){
					return true;
				}
				return false;
			}
		});
		Map<BufferedImage,String> imgMap = new HashMap<BufferedImage, String>();
		for(File f : files){
			imgMap.put(ImageIO.read(f), f.getName().charAt(0) + "");
		}
		
		return imgMap;
	}
	
	public static String getSingleCharOcr(BufferedImage img,Map<BufferedImage, String> map){
		int width = img.getWidth();
		int height = img.getHeight();
		int min = width * height;
		String result = "";
		Label1: for(BufferedImage bi : map.keySet()){
			int count = 0;
			for(int x = 0; x < width; x++){
				for(int y = 0; y < height; y++){
					if(isWhite(img.getRGB(x, y)) != isWhite(bi.getRGB(x, y))){
						count++;
						if(count >= min){
							break Label1;
						}
					}
				}
			}
			if(count < min){
				min = count;
				result = map.get(bi);
			}
		}
		return result;
	}
	
	public static String getAllOcr(String path){
		String str = "";
		try {
			BufferedImage bufImg = removeBackgorund(path);
			File outPut = new File(OUTPUTPATH + File.separator + OUTPUTNAME);
			boolean b = ImageIO.write(bufImg, IMAGEFORMAT, outPut);
			Map<BufferedImage, String> map = loadTrainPic();
			List<BufferedImage> imgList = splitImage(bufImg);
			int i = 0;
			for(BufferedImage bi : imgList){
				ImageIO.write(bi, IMAGEFORMAT, new File(OUTPUTPATH + File.separator + i + "." + IMAGEFORMAT));
				i++;
				str += getSingleCharOcr(bi,map);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static void downloadImage(){
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod("http://www.puke888.com/authimg.php");
		int statusCode;
		try {
            // 执行getMethod  
			statusCode = httpClient.executeMethod(getMethod);
			if(statusCode != HttpStatus.SC_OK){
				 System.err.println("Method failed: "  
	                     + getMethod.getStatusLine());  
			}
            // 读取内容 
			InputStream inputstream = getMethod.getResponseBodyAsStream();
			OutputStream outputStream = new FileOutputStream(new File("/users/sqzs/desktop/new2.jpg"));
			IOUtils.copy(inputstream, outputStream);
			outputStream.close();
			System.out.println("ok");
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
            // 释放连接  
			getMethod.releaseConnection();
		}
	}
	
	public static void main(String[] args) throws IOException {
		downloadImage();
		System.out.println(getAllOcr(OUTPUTPATH + "new2.jpg"));

	}
}
