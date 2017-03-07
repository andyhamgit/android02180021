package com.zhbitzwz.cn;
class MyException extends Exception{
	MyException(){
		super("自定义的异常，不符合要求的除数");
	}
}
public class ExceptionDemo5 {
	public static void main(String args[]){
		int n1 = 10;
		int n2 =  0;
		try{
			if(n2 == 0 | n2 ==1){
				throw new MyException();
			}
			int r = n1/n2;
			System.out.println("两户相除的结果是" + r);
		}catch(MyException e ){
			System.out.println(e.getMessage());
		}
	}

}
