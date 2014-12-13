package pkgutil;

import java.io.File;

/**
 * @作者 Goofy
 * @邮件 252878950@qq.com
 * @日期 2014-3-10下午2:54:27
 * @描述 获取 项目/文件 路径
 */
public class PathUtil {
	
	/**
	 * 获取项目的绝对路径
	 * @return Sting 获取项目的绝对路径
	 */
	public static String getProjectAbsolutelyPath(){
		return System.getProperty("user.dir"); 
	}
	
	/**
	 * 获取所在的盘符
	 * @return String
	 */
	public static String getProjectDrivePath() {
		  return new File("/").getAbsolutePath();
	}
	
	/**
	 * 获取指定类的路径
	 * @param clazz
	 * @return String
	 */
	public static String getClassAbsolutePath(Class<?> clazz) {
		  return clazz.getResource("").getPath().substring(1);
	}

}
