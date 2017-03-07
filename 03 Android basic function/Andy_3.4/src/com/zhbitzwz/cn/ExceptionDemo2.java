package com.zhbitzwz.cn;
public class ExceptionDemo2 {
	public static void main(String args[]){
		int n1 = 10;
		int n2 = 0;
		try{
			int result = n1/n2;
			System.out.println("两数相除的结果是" + result);
		}catch(ArithmeticException e){
			System.out.println("出现除数为零的异常");
		}finally{
			System.out.println("这是finally板块中的代码，不管是否有异常，此句一定要执行");
		}
		
	}

}
