package pkgexcel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelTest {
	private static String MONTH = "四月份";
	private static HashMap<String, Integer> proMap = null;

	public static void main(String[] args) {
		File f = new File("/users/sqzs/downloads/2014年天猫客户成交记录.xls");
		System.out.println(MONTH);
		toMap();
		readExcel(f);
		Iterator it = proMap.entrySet().iterator();
    	while(it.hasNext()){
    		Map.Entry entry = (Map.Entry)it.next();
    		String key = (String)entry.getKey();
    		System.out.println(key + entry.getValue());
    	}
	}

	private static void toMap(){
		proMap = new HashMap<String,Integer>();
    	String[] province = {"北京","天津","上海","重庆","内蒙古自治区","维吾尔自治区","西藏自治区","宁夏回族自治区",
    			"广西壮族自治区","香港特别行政区","澳门特别行政区","黑龙江省","吉林省","辽宁省","河北省","山西省","青海省","山东省",
    			"河南省","江苏省","安徽省","浙江省","福建省","江西省","湖南省","湖北省","广东省","台湾省","海南省","甘肃省",
    			"陕西省","四川省","贵州省","云南省"};
    	for(int i = 0; i < 34; i++){
    		proMap.put(province[i], 0);
    	}
    	
    }

	// 去读Excel的方法readExcel，该方法的入口参数为一个File对象
	private static void readExcel(File f){
    	try {
    		// 创建输入流，读取Excel 
			InputStream is = new FileInputStream(f.getAbsolutePath());//!
			// jxl提供的Workbook类
			Workbook wb = Workbook.getWorkbook(is);
			// Excel的页签数量 
			int sheet_size = wb.getNumberOfSheets();
			System.out.println("Excel的页签数量 :" + sheet_size);
//			for(int index = 0; index < sheet_size; index++){
//				// 每个页签创建一个Sheet对象 
//				Sheet sheet = wb.getSheet(index);
//				// sheet.getRows()返回该页的总行数
//				for(int i = 0; i < sheet.getRows(); i++){
//					// sheet.getColumns()返回该页的总列数
//					for(int j = 0; j < sheet.getColumns(); j++){
//						String cellInfo = sheet.getCell(j, i).getContents();
//						System.out.println(cellInfo);
//					}
//				}
//			}
			Sheet sheet = wb.getSheet(MONTH);
//			for(int i = 0; i < sheet.getRows(); i++){
//				for(int j = 0; j < sheet.getColumns(); j++){
//					String str = sheet.getCell(j, i).getContents();
//					System.out.println("1" + str);
//					if(proMap.containsKey(str)){
//						System.out.println("sheng:" + str + "shu" + proMap.get(str));
//						proMap.put(str, (proMap.get(str) + 1));
//					}
//				}
//			}
			for(int i = 0; i < sheet.getRows(); i++){
				for(int j = 0; j < sheet.getColumns(); j++){
					String str = sheet.getCell(j, i).getContents();
					searchMap(str);
				}
			}
//			System.out.println(PROVINCE + count + "人");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	private static void searchMap(String str){
		Iterator it = proMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			String pro = (String)entry.getKey();
			if(str.indexOf(pro) != -1){
				proMap.put(pro, (proMap.get(pro) + 1));
				break;
			}
		}
	}
}