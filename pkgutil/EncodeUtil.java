package pkgutil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * @作者 Goofy
 * @邮件 252878950@qq.com
 * @日期 2014-3-7下午3:19:43
 * @描述 字符编码工具类
 */
public class EncodeUtil {
	
	/**
	 * 将字符串有某种编码转变成另一种编码
	 * @param string 编码的字符串
	 * @param originCharset 原始编码格式
	 * @param targetCharset 目标编码格式
	 * @return String 编码后的字符串
	 */
	public static String encodeString(String string,Charset originCharset,Charset targetCharset){
		return string=new String(string.getBytes(originCharset),targetCharset);
	}
	
	/**
	 * URL编码
	 * @param string 编码字符串
	 * @param charset 编码格式
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String encodeUrl(String string,String charset){
		if(null!=charset&&!charset.isEmpty()){
			try {
				return URLEncoder.encode(string,charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return URLEncoder.encode(string);
	}
	
	/**
	 * URL编码
	 * @param string 解码字符串
	 * @param charset 解码格式
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String decodeUrl(String string,String charset){
		if(null!=charset&&!charset.isEmpty()){
			try {
				return URLDecoder.decode(string,charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return URLDecoder.decode(string);
	}
}
