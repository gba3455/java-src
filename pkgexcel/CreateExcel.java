package pkgexcel;
import java.io.File;
import java.util.Date;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
import jxl.write.DateTime;

/*
 * 几个重要对象解析：

 1、WritableWorkbook：用于创建打开Excel文件

 2、WritableSheet：用于创建Excel中的页签

 3、Label：将单元格指定为文本型，并写入字符串

 4、Number：将单元格指定为数字型，并可写入数字

 5、DateTime：将单元格指定为日期型，并可写入日期
 */
public class CreateExcel {
	public static void main(String args[]) {
		try {
			// 打开文件
			WritableWorkbook book = Workbook.createWorkbook(new File("test.xls"));
			// 生成名为“sheet1”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("sheet1", 0);
			// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容为string
			Label label = new Label(0, 0, "string");
			// 将定义好的单元格添加到工作表中
			sheet.addCell(label);
			// 生成一个保存数字的单元格,单元格位置是第二列，第一行，单元格的内容为1234.5
			Number number = new Number(1, 0, 1234.5);
			sheet.addCell(number);
			// 生成一个保存日期的单元格，单元格位置是第三列，第一行，单元格的内容为当前日期
			DateTime dtime = new DateTime(2, 0, new Date());
			sheet.addCell(dtime);
			// 写入数据并关闭文件
			book.write();
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}