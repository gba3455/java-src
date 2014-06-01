/**
 * 有一个27 cm的细木杆在第3cm 7 cm 11 cm 17 cm 23 cm这5个位置上各有一只蚂蚁。木杆很细，不能同时
 * 通过一只蚂蚁。开始时，蚂蚁的头朝左还是朝右是任意的，他们只会超前走和调头走，但不会后退，当任意两只蚂蚁碰头时，
 *两只蚂蚁会同时掉头朝反方向走。假设蚂蚁每秒钟可以走1厘米的距离，求所有蚂蚁都离开木杆的小时间和最大时间
 * 
 * @author SQZS
 *
 */
public class AntQuestion {
	public static void methodOne(){
		Ant a1 = new Ant();
		Ant a2 = new Ant();
		Ant a3 = new Ant();
		Ant a4 = new Ant();
		Ant a5 = new Ant();
		
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 2; j++) {
				for (int k = 1; k <= 2; k++) {
					for (int m = 1; m <= 2; m++) {
						for (int n = 1; n <= 2; n++) {
							a1.site = 3;
							a1.direction = i;
							a1.gone = false;
							a2.site = 7;
							a2.direction = j;
							a2.gone = false;
							a3.site = 11;
							a3.direction = k;
							a3.gone = false;
							a4.site = 17;
							a4.direction = m;
							a4.gone = false;
							a5.site = 23;
							a5.direction = n;
							a5.gone = false;
							for(int p = 1; p < 1000 ; p++){
								//1 让蚂蚁走
								if(!a1.gone){
									a1.step();
								}
								if(!a2.gone){
									a2.step();
								}
								if(!a3.gone){
									a3.step();
								}
								if(!a4.gone){
									a4.step();
								}
								if(!a5.gone){
									a5.step();
								}
								//2 判断是否会碰头
								if(a1.site == a2.site && a1.direction == 2 && a2.direction == 1){
									a1.changeDirection();
									a2.changeDirection();
								}
								if(a2.site == a3.site && a2.direction == 2 && a3.direction == 1){
									a2.changeDirection();
									a3.changeDirection();
								}
								if(a3.site == a4.site && a3.direction == 2 && a4.direction == 1){
									a3.changeDirection();
									a4.changeDirection();
								}
								if(a4.site == a5.site && a4.direction == 2 && a5.direction == 1){
									a4.changeDirection();
									a5.changeDirection();
								}
								//3 判断是否全部离开
								if(a1.gone == true && a2.gone == true && a3.gone == true && a4.gone == true && a5.gone == true){
									System.out.println("时间为:" + p);
									break;
								}
							}
						}
					}
				}
			}
		}
	}
	public static void methodTwo(){
		Ant[] ant = new Ant[5];
		for (int i = 0; i < ant.length; i++) {
			ant[i] = new Ant();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 2; j++) {
				for (int k = 1; k <= 2; k++) {
					for (int m = 1; m <= 2; m++) {
						for (int n = 1; n <= 2; n++) {
							for (int z = 0; z < ant.length; z++) {
								ant[z].gone = false;								
							}
							ant[0].direction = i;
							ant[1].direction = j;
							ant[2].direction = k;
							ant[3].direction = m;
							ant[4].direction = n;
							ant[0].site = 3;
							ant[1].site = 7;
							ant[2].site = 11;
							ant[3].site = 17;
							ant[4].site = 23;
							for(int p = 1; p < 100 ; p++){								
								//1 让蚂蚁走
								for (int v = 0; v < ant.length; v++) {
									if(!ant[v].gone){
										ant[v].step();
									}
								}
								//2 判断是否碰头
								for (int x = 0; x < ant.length - 1; x++) {
									if(ant[x].site == ant[x + 1].site && ant[x].direction == 2 && ant[x + 1].direction == 1){
										ant[x].changeDirection();
										ant[x + 1].changeDirection();
									}
								}
								//3 判断是否全部离开
								if(ant[0].gone == true && ant[1].gone == true && ant[2].gone == true && ant[3].gone == true && ant[4].gone == true){
									System.out.println("时间为：" + p);
									break;
								}
							}
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		methodTwo();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
class Ant{
	int site = 0;//位置
	int direction = 1;//方向 1左 2右
	boolean gone = false;//已离开
	
	void step(){
		if(direction == 1){
			site = site - 1;//往左走一步
		}else{
			site = site + 1;//往右走一步
		}
		if(site == 0 || site == 27){
			gone = true;
		}
	}
	void changeDirection(){
		if(direction == 1){
			direction = 2;
		}else{
			direction = 1;			
		}
	}
}