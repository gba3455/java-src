package pkdefault;

public class TestVariableArgumentType {
		public static void dealArray1(int... intArray){
			for (int i : intArray)
				System.out.print(i +" ");
			
			System.out.println();
//		public static void dealArray1(int[] intArray){
//			//会有Duplicate method dealArray(int[]) in type TestVarArgus的错误 这两个方法是冲突的，是无法重载的。 
//	        for (int i : intArray)  
//	            System.out.print(i +" ");  
//	          
//	        System.out.println();  
//	    }  
		
		}
		
		
		public static void dealArray2(int[] intArray){  
			for (int i : intArray)  
				System.out.print(i +" ");  
			
			System.out.println();  
		}  
		
		
		public static void dealArray3(int count, int... intArray){  
	          
	    }  
	      
//	    public static void dealArray3(int... intArray, int count){//编译报错，可变参数类型应该作为参数列表的最后一项  
//	          
//	    }  
		
		
		
		public static void dealArray4(int... intArray){  
	        System.out.println("1");  
	    }  
	      
	    public static void dealArray4(int count, int count2){  
	        System.out.println("2");  
	    }  
	    
	    
	    
		public static void main(String ... args){//main方法的参数就是一个数组类型的，那么它其实也是可以改成不定参数类型。
			dealArray1(); //dealArray(int[] intArray{});
			dealArray1(1); //dealArray(int[] intArray{1});
			dealArray1(1, 2, 3); //dealArray(int[] intArray{1, 2, 3});
			
			int[] intArray = {1, 2, 3};  
			dealArray2(intArray);//通过编译，正常运行
//			dealArray2(1,2,3);  //编译错误 
			//从上面这两段代码可以看出来，可变参数是兼容数组类参数的，但是数组类参数却无法兼容可变参数。
			//其实对于第二段代码而言，编译器并不知道什么可变不可变，在它看来，需要定义一个dealArray(int, int, int）类的方法。
			//所以，自然就无法去匹配数组类参数的dealArray方法了。
			
			dealArray4(1, 2); //能匹配定长的方法，那么优先匹配该方法。含有不定参数的那个重载方法是最后被选中的。
			
		}
}
