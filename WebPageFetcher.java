import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;

/**
 * 抓取网页的HTML内容(content)或头部(header)信息
 * @author SQZS
 *
 */
public class WebPageFetcher {
	private static final String HTTP = "http";
	private static final String HEADER = "header";
	private static final String CONTENT = "content";
	private static final String END_OF_INPUT = "\\Z";
	private static final String NEWLINE = System.getProperty("line.separator");
	
	//PRIVATE
	private URL url;
	
	public static void main(String[] args) throws MalformedURLException{
		// TODO Auto-generated method stub
		String url = args[0];
		String option = args[1];
		
//		TargetWebSite[] targets = new TargetWebSite[3];
//		targets[0] = new TargetWebSite("01", "http://www.ifeng.com.cn");
//		targets[1] = new TargetWebSite("02", "http://www.fenby.com");
//		targets[2] = new TargetWebSite("03", "http://www.baidu.com");
//		String option = "content";
		
		
		WebPageFetcher fetcher = null;
		try {
			fetcher = new WebPageFetcher(url);
			if(HEADER.equalsIgnoreCase(option)){
				log(fetcher.getPageHeader());
			}else if(CONTENT.equalsIgnoreCase(option)){
				log(fetcher.getPageContent());
			}else{
				log("无效的选项");
			}
		} catch (IOException e) {
			e.printStackTrace();
			log("IOException" + e.getMessage());
		}	
//		
//		for (TargetWebSite targetWebSite : targets) {
//			fetchWebPage(option, targetWebSite);
//		}
	}
	private static void fetchWebPage(String option, TargetWebSite targetWebSite) {
		WebPageFetcher fetcher;
		try {
			fetcher = new WebPageFetcher(targetWebSite.url);
			if(HEADER.equalsIgnoreCase(option)){
				log(fetcher.getPageHeader());
			}else if(CONTENT.equalsIgnoreCase(option)){
				log(fetcher.getPageContent());
			}else{
				log("无效的选项");
			}
		} catch (IOException e) {
			e.printStackTrace();
			log("IOException" + e.getMessage());
		}
	}
	/**
	 * 
	 * @param urlName URL地址
	 * @throws MalformedURLException
	 */
	public WebPageFetcher(String urlName) throws MalformedURLException{
		this(new URL(urlName));
	}
	/**
	 * 
	 * @param url URL对象
	 */
	public WebPageFetcher(URL url){
		if(!HTTP.equals(url.getProtocol())){
			throw new IllegalArgumentException("非Http协议的URL地址:" + url);
		}
		this.url = url;
	}
	/**
	 * 获取网页内容信息
	 * @return 网页内容信息
	 * @throws IOException
	 */
	public String getPageContent() throws IOException{
		String result = null;
		URLConnection connection = null;
		try {
			connection = url.openConnection();
			Scanner scanner = new Scanner(connection.getInputStream());
			scanner.useDelimiter(END_OF_INPUT);
			result = scanner.next();
			scanner.close();// Resource leak资源泄露
		} catch (IOException e) {
			log("打开URL连接失败:" + url.toString());
			log("错误信息:" + e.getMessage());
			throw e;
		}
		return result;
	}
	/**
	 * 网页头部信息
	 * @return
	 * @throws IOException
	 */
	public String getPageHeader() throws IOException{
		StringBuilder result = new StringBuilder();
		URLConnection connection = null;
		try {
			connection = url.openConnection();
		} catch (IOException e) {
			log("打开URL连接失败:" + url.toString());
			log("错误信息:" + e.getMessage());
			throw e;
		}
		
		//not all headers come in key-value pairs - sometimes the key is
		//null or an empty String
		int headerIdx = 0;
		String headerKey = null;
		String headerValue = null;
		while((headerValue = connection.getHeaderField(headerIdx)) != null){
			headerKey = connection.getHeaderFieldKey(headerIdx);
			if(headerKey != null && headerKey.length() > 0){
				result.append(headerKey);
				result.append(" : ");
			}
			result.append(headerValue);
			result.append(NEWLINE);
			headerIdx++;
		}
		return result.toString();
	}
	private static void log(Object obj){
		System.out.println(obj);
	}
	private static void anotherMethodToGetWebContent(){
		try {
			URL url = new URL("http://tieba.baidu.com/p/2720132008");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String str = null;
			PrintWriter pw = new PrintWriter(new File("/Users/SQZS/Desktop/a.txt"));
			while((str = br.readLine()) != null){
				System.out.println(str);
				pw.println(str);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
class TargetWebSite{
	String id;
	String url;
	public TargetWebSite(String id, String url) {
		super();
		this.id = id;
		this.url = url;
	}
}