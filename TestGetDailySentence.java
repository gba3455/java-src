import java.awt.Dimension;
import java.awt.TextArea;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class TestGetDailySentence extends JFrame{
	static JTextArea textArea = null;
	static int lengh;
	static String webAddress = "",sentence1 = "",sentence2 = "";
	public TestGetDailySentence() {
		this.add(textArea);
		this.setTitle("沪江每日一句");
		this.setSize(new Dimension(lengh * 8,14 * 6));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			textArea = new JTextArea();
			WebPageFetcher wpf = new WebPageFetcher("http://dict.hjenglish.com/jp/");
			String content = wpf.getPageContent();
			getAdd(content);
			lengh = lenghCompare(sentence1.length(), sentence2.length(),webAddress.length());
			new TestGetDailySentence();
			System.out.println(sentence1 + "\n" + sentence2);
			System.out.println(webAddress);
			textArea.append(webAddress + "\n");
			textArea.append(sentence1 + "\n");
			textArea.append(sentence2 + "\n");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static String getAdd(String content){
		String str = content.substring((content.indexOf("<a href=\"http://bulo.hujiang.com/") + 9), content.indexOf("\" class=\"sent f_l noline\" style=\"float:left;\">"));
		webAddress = str.substring(0, str.indexOf("\" rel="));
		sentence1 = str.substring(str.indexOf("title=") + 7, str.indexOf("   "));
		sentence2 = str.substring(str.indexOf("   ") + 3);
		return str;
	}
	private static int lenghCompare(int len1,int len2,int len3){
		if(len1 > len2){
			if(len1 > len3){
				return len1;
			}else{
				return len3;
			}
		}else{
			if(len2 > len3){
				return len2;
			}else{
				return len3;
			}
		}
	}
	private static void log(String result){
		String temp = result.substring(result.indexOf("<font color=#006400>") + "<font color=#006400>".length(), result.indexOf("<br><script"));
		String sen1 = temp.substring(0,temp.indexOf("</font></b>"));
		String sen2 = temp.substring(temp.indexOf("<br>") + "<br>".length());
		System.out.println(sen1);
		System.out.println(sen2);
	}
}




