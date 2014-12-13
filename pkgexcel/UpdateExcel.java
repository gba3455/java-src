package pkgexcel;
import java.io.*;  
import java.util.HashMap;  
  
import jxl.*;  
import jxl.format.Alignment;  
import jxl.format.Border;  
import jxl.format.BorderLineStyle;  
import jxl.format.Colour;  
import jxl.format.VerticalAlignment;  
import jxl.write.Label;  
import jxl.write.WritableCellFormat;  
import jxl.write.WritableFont;  
import jxl.write.WritableSheet;  
import jxl.write.WritableWorkbook;  
import jxl.write.WriteException;  
  
public class UpdateExcel {  
    public static void main(String args[]) {  
        WritableWorkbook book = null;  
        HashMap<String, String> map = new HashMap<String, String>();  
        map = getPCKV();  
        try {  
            // Excel获得文件  
            Workbook wb = Workbook.getWorkbook(new File("update_test.xls"));  
            // 打开一个文件的副本，并且指定数据写回到原文件  
            book = Workbook.createWorkbook(new File("update_test.xls"), wb);  
            Sheet sheet = book.getSheet(0);  
            WritableSheet wsheet = book.getSheet(0);  
            int colunms = sheet.getColumns();  
            // 不读表头  
            for (int i = 1; i < sheet.getRows(); i++) {  
                StringBuffer pcin = new StringBuffer();  
                // 将省市组合起来与HashMap进行匹配  
                String province = sheet.getCell(4, i).getContents().trim();  
                String city = sheet.getCell(5, i).getContents().trim();  
                pcin = pcin.append(province).append("-").append(city);  
                // 如果不匹配，则在该行的最后加入标注信息  
                if (!map.containsValue(pcin.toString())) {  
                    Label label = new Label(colunms, i, "省市选择出错",getDataCellFormat());  
                    wsheet.addCell(label);  
                }  
            }  
            book.write();  
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
            try {  
                book.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            } catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }  
    }  
  
    // 设置标注的格式为黄底红字  
    public static WritableCellFormat getDataCellFormat() {  
        WritableCellFormat wcf = null;  
        try {  
            WritableFont wf = new WritableFont(WritableFont.TIMES, 10,  
                    WritableFont.BOLD, false);  
            // 字体颜色  
            wf.setColour(Colour.RED);  
            wcf = new WritableCellFormat(wf);  
            // 对齐方式  
            wcf.setAlignment(Alignment.CENTRE);  
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE);  
            // 设置上边框  
            wcf.setBorder(Border.TOP, BorderLineStyle.THIN);  
            // 设置下边框  
            wcf.setBorder(Border.BOTTOM, BorderLineStyle.THIN);  
            // 设置左边框  
            wcf.setBorder(Border.LEFT, BorderLineStyle.THIN);  
            // 设置右边框  
            wcf.setBorder(Border.RIGHT, BorderLineStyle.THIN);  
            // 设置背景色  
            wcf.setBackground(Colour.YELLOW);  
            // 自动换行  
            wcf.setWrap(true);  
        } catch (WriteException e) {  
            e.printStackTrace();  
        }  
        return wcf;  
    }  
  
    // 省市对应关系Map  
    public static HashMap<String, String> getPCKV() {  
        HashMap<String, String> map = new HashMap<String, String>();  
        map.put("01", "河北省-石家庄");  
        map.put("02", "河北省-秦皇岛");  
        map.put("03", "河北省-唐山");  
        map.put("04", "四川省-成都");  
        map.put("05", "四川省-绵阳");  
        map.put("06", "四川省-达州");  
        map.put("07", "广西省-桂林");  
        map.put("08", "广西省-南宁");  
        map.put("09", "广西省-柳州");  
        return map;  
    }  
}  