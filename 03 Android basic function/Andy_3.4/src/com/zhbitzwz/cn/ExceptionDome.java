package com.zhbitzwz.cn;
class ThrowsDemo {
	public void throwsMethod(int n1, int n2) throws ArithmeticException {
		int result = n1 / n2;
	}
}

public class ExceptionDome {
	public static void main(String[] args) {
		ThrowsDemo td = new ThrowsDemo();
		try {
			td.throwsMethod(10, 0);
		} catch (ArithmeticException e) {
			System.out.println("算术异常：除数为零");
		}
	}

}
