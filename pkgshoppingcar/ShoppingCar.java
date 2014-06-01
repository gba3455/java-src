package pkgshoppingcar;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShoppingCar {
	private double totalPrice;//购物车所有商品总价格
	private int totalAmount;//购物车所有商品数量
	private Map<Integer, OrderItemBean>itemMap;//商品编号与订单项的键值对
	public ShoppingCar(double totalPrice, int totalAmount,
			Map<Integer, OrderItemBean> itemMap) {
		super();
		this.totalPrice = totalPrice;
		this.totalAmount = totalAmount;
		this.itemMap = itemMap;
	}
	private double BigDec(double num) {
		BigDecimal temp = new BigDecimal(num);
		return temp.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public void buy(int nid){
	   //如果该商品是第一次购买，商品的信息从数据库获取，数据库的模拟代          
	   //码见附录。itemMap增加一对键值对。
		double price = 0.0;
		int amount = 0;
		Database data = new Database();
		McBean mb = data.getMcBean(nid);
		price = mb.getNprice();
		if(!itemMap.containsKey(nid)){//第一次购买
			//加入订单
			OrderItemBean oib = new OrderItemBean();
			oib.setSname(mb.Sname);
			amount = 1;
			oib.setAmount(amount);
			itemMap.put(nid, oib);//增加一对键值对
		}else{
			//如果不是第一次购买，则通过商品编号找到对应的定单项，然后更新定
			//单项的商品数量。
			OrderItemBean oib = itemMap.get(nid);
			amount = oib.getAmount() + 1;
			oib.setAmount(amount);
		}
		
		   //不管是否第一次购买，都得更新购物车的总价格和总数量。
		totalPrice += price;
		totalAmount++;
		}
		public void delete(int nid){
			//通过商品编号删除的对应的定单项，然后从更新购物车的总价格和总数量。
			Database data = new Database();
			McBean mb = data.getMcBean(nid);
			double price = mb.getNprice();
			OrderItemBean oib = itemMap.get(nid);
			int amount = oib.getAmount();
			
			//全删
//			totalAmount -= amount;
//			totalPrice -= (price * amount);
//			itemMap.remove(nid);
			
			//一次删一个
			amount--;
			if(amount == 0){
				itemMap.remove(nid);
			}
			else{
			oib.setAmount(amount);
			itemMap.put(nid, oib);
			}
			totalPrice -= price;
			totalAmount--;
		}
		public void update(int nid, int count){
			///通过商品编号找到对应的对应的定单项，修改商品数量。然后从更新购物车的总价格和总数量。
			OrderItemBean oib = itemMap.get(nid);
			Database data = new Database();
			McBean mb = data.getMcBean(nid);
			double price = mb.getNprice();
//			totalPrice -= (price * oib.getAmount());
//			totalAmount -= oib.getAmount();
//			oib.setAmount(count);
//			totalPrice += price * count;
//			totalAmount += count;
			
			if(count > oib.getAmount()){
				totalPrice += (price * (count - oib.getAmount()));
				totalAmount += (count - oib.getAmount());
			}
			else{
				totalPrice -= (price * (oib.getAmount() - count));
				totalAmount -= (oib.getAmount() - count);
			}
			oib.setAmount(count);
			itemMap.put(nid, oib);
		}
		public void clear(){
			//清空定单项，购物车的总价格和总数量清零。
			itemMap.clear();
			totalPrice = 0;
			totalAmount = 0;
			}
		public String show(){
			String temp = "商品编号   商品名称   单价   购买数量   总价\n";
			//显示购物车的商品，格式如下:
//			商品编号   商品名称   单价   购买数量   总价
//			1          地瓜       2.0    2          4.0
//			…
//
//			合计：总数量：5  总价格：20元
//			System.out.println("商品编号   商品名称   单价   购买数量   总价");
			if(itemMap != null){
				Database db = new Database();
				Set<Integer> data = itemMap.keySet();
				for (Integer integer : data) {
					McBean mc = db.getMcBean(integer);
					
					OrderItemBean oib = itemMap.get(integer);
//					System.out.println("" + mc.getNid() + "          " + mc.getSname() + "       " + mc.getNprice() + "       " + oib.getAmount() + "       " + (oib.getAmount() * mc.getNprice()));
					temp += "" + mc.getNid() + "          " + mc.getSname() + "       " + mc.getNprice() + "       " + oib.getAmount() + "       " + (oib.getAmount() * mc.getNprice()) + "\n";
				}
//				System.out.println("合计：总数量：" + totalAmount + "  总价格：" + BigDec(totalPrice) + "元");
				temp += "合计：总数量：" + totalAmount + "  总价格：" + BigDec(totalPrice) + "元";
			}
			else{
//				System.out.println("合计：总数量：" + 0 + "  总价格：" + 0 + "元");
				temp += "合计：总数量：" + 0 + "  总价格：" + 0 + "元";
				}
			return temp;
			}
}
