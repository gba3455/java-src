package pkgshoppingcar;

import java.util.HashMap;
import java.util.Map;

public class Database {
	private Map<Integer,McBean> data = new HashMap<Integer, McBean>();
	public Database(){
		McBean bean = new McBean();
		bean.setNid(1);
		bean.setSname("地瓜");
		bean.setNprice(2.0);
		bean.setSdescription("新鲜的地瓜");
		
		data.put(1, bean);
		
		bean = new McBean();
    	bean.setNid(2);
    	bean.setSname("土豆");
    	bean.setNprice(1.2);
    	bean.setSdescription("又好又大的土豆");
    	
    	data.put(2, bean);
    	
    	bean = new McBean();
    	bean.setNid(3);
    	bean.setSname("丝瓜");
    	bean.setNprice(1.5);
    	bean.setSdescription("本地丝瓜");
    	
    	data.put(3, bean);   	
	}
	public McBean getMcBean(int nid){
		return data.get(nid);
	}
}
