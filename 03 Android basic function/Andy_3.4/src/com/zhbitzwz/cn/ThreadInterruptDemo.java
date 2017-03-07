package com.zhbitzwz.cn;
public class ThreadInterruptDemo extends Thread{
	public void run(){
		System.out.println("休息，勿扰！");
		try{
			sleep(3600000);
		}catch(InterruptedException e){
			System.out.println("啊，谁叫醒我的？" );
		}
	}
	public static void main(String args[]){
		ThreadInterruptDemo t =  new ThreadInterruptDemo();
		t.start();
		t.interrupt();//唤醒线程
	}

}
