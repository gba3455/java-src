package pkgset.pkgmysetinsteadofsetclass;

/**
 * 有一位厨师要从12斤油（A桶）倒出6斤油但现在手里只有8斤（B桶）和5斤的（C桶）桶,怎么取出6斤油
 * 
 * 有错误!!!!
 * @author SQZS
 *
 */
public class OilQuestion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OilQuestion o = new OilQuestion();
		o.t1();
	}
	private void t1(){
		Bucket b1 = new Bucket();
		b1.max = 12;
		b1.now = 12;
		Bucket b2 = new Bucket();
		b2.max = 8;
		b2.now = 0;
		Bucket b3 = new Bucket();
		b3.max = 5;
		b3.now = 0;
		
		Bucket[] bArr = new Bucket[3];
		bArr[0] = b1;
		bArr[1] = b2;
		bArr[2] = b3;
		
		MySet set = new MySet();
		MySet.add(bArr);
		
		stepDaoYou(set);
	}
	int end = 5;
	private void stepDaoYou(MySet setKeNeng){
		for(Object objs : MySet.getAll()){
			Bucket ts[] = (Bucket[])objs;
			
			//1:判断是否已经已完成
			if(ts[0].now==end || ts[1].now==end || ts[2].now==end){
				System.out.println("倒油完成---"+ts[0].now+","+ts[1].now+","+ts[2].now);
				break;
			}
			//2:递归
			stepDaoYou(CanStep(ts));			
		}
		
	}
	MySet yiDao = new MySet();
	private MySet CanStep(Bucket[] ts){
		MySet setKeNeng = new MySet();
		System.out.println("A=="+ts[0].now+",B=="+ts[1].now+",C=="+ts[2].now);
		for(int i = 0; i < ts.length ; i++){
			for(int j = 0; j < ts.length ; j++){
				//1不能给自己倒
				if(i == j){
					continue;
				}
				//2算出能倒多少
				int canDaoYou = ts[i].canOut();
				if(ts[i].canOut() > ts[j].canIn()){
					canDaoYou = ts[j].canIn();
				}
				//3模拟倒
				ts[i].putOut(canDaoYou);
				ts[j].putIn(canDaoYou);
				//4判断这个倒油的步骤是否已经出现过
				if(yiDao.contains("A="+ts[0].now+",B="+ts[1].now+",C="+ts[2].now)){
					//已经出现过了 不能这样倒 否则就死循环了
					//把油倒回去
					ts[j].putIn(canDaoYou);
					ts[i].putOut(canDaoYou);
					continue;
				}
				//5说明可以这样倒
				//5.1先在已倒里面加入新的可能的倒油情况
				MySet.add("A="+ts[0].now+",B="+ts[1].now+",C="+ts[2].now);		
				//5.2添加可能性
				Bucket newTs[] = new Bucket[3];
				Bucket b1 = new Bucket();
				b1.max = ts[0].max;
				b1.now = ts[0].now;
				Bucket b2 = new Bucket();
				b2.max = ts[1].max;
				b2.now = ts[1].now;
				Bucket b3 = new Bucket();
				b3.max = ts[2].max;
				b3.now = ts[2].now;
				
				newTs[0] = b1;
				newTs[1] = b2;
				newTs[2] = b3;
			
				System.out.println("keneng------------------>"+"A="+ts[0].now+",B="+ts[1].now+",C="+ts[2].now);	
				setKeNeng.add(newTs);
				
				//6:把油还回去
				ts[i].putIn(canDaoYou);
				ts[j].putOut(canDaoYou);
			}
		}		
		return setKeNeng;		
	}
}
class Bucket{
	public int max = 0;
	public int now = 0;
	
	void putIn(int oil){
		now += oil;
	}
	void putOut(int oil){
		now -= oil;
	}
	int canIn(){
		return (max - now);
	}
	int canOut(){
		return now;
	}
}
