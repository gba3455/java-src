package pkgfinalproject.pkgutils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;

public class StaticTools {

	static public String MACDESKTOP = "/users/sqzs/desktop/";
	static public String WINDESKTOP = "c:/";
    static public Map<String,JButton> jbMap = new HashMap<String, JButton>();
    static public Map<String,String> contentMap = new HashMap<String, String>();
	static public Set<String> charset = MyCharSet.getCharset();
	
	static{
		for(String jbname : charset){
			JButton jb = new JButton("使う");
			jbMap.put(jbname, jb);
		}
	}
}
