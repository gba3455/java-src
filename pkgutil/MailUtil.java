package pkgutil;

/**
 * @作者 Goofy
 * @邮件 252878950@qq.com
 * @日期 2014-3-11下午3:57:08
 * @描述 邮件工具类
 */
public class MailUtil {
	
	/**
	 * 请使用Commons Email 包，很方便，方法块里面是示例代码
	 * <a href="http://commons.apache.org/proper/commons-email/">http://commons.apache.org/proper/commons-email/</a>
	 * @param hostName smtp服务器地址
	 * @param sendMailAddress 发送者地址
	 * @param mailPassword 用户名
	 * @param TLS 是否TLS校验
	 * @param getMailAddress 接收者地址
	 * @param mailTitle 邮件标题
	 * @param mailContent 邮件内容
	 */
	public static void sendMail(String hostName,String sendMailAddress,String mailPassword,boolean TLS,String[] getMailAddress,String mailTitle,String mailContent){
		
		/*
		SimpleEmail email = new SimpleEmail();  
        email.setTLS(TLS); //是否TLS校验，，某些邮箱需要TLS安全校验，同理有SSL校验    
        email.setHostName(hostName);  
        try {  
            email.setFrom(sendMailAddress, sendMailAddress);  
            email.setAuthentication(sendMailAddress, mailPassword);  
            email.setCharset("utf-8");//解决中文乱码问题  
            email.setSubject(mailTitle); //标题         
            email.setMsg(mailContent);//内容    
            for(int i = 0; i < getMailAddress.length; ++i){  
                email.addTo(getMailAddress[i]); //接收方  
                email.send();  
            }  
        } catch (EmailException e) {  
          	e.printStackTrace();  
        }
         */
		
	}
}
