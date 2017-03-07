package com.zhbitzwz.cn;
public class ThreadPriorityDemo extends Thread{
	public void run()
	{
		for(int i = 1; i <= 5;i++){
			System.out.println(getName()+": "+i);}
	}



public static void main(String args[]){
	ThreadPriorityDemo t1 = new ThreadPriorityDemo();
	ThreadPriorityDemo t2 = new ThreadPriorityDemo();
	
	t2.setPriority(Thread.MIN_PRIORITY);
	t1.setPriority(Thread.MAX_PRIORITY);
	
	t1.start();
	t2.start();
}
}