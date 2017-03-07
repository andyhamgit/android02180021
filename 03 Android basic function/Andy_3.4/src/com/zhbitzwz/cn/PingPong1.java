package com.zhbitzwz.cn;
//public class PingPong1 extends Thread{
public class PingPong1 implements Runnable{
	private int delay;
	
	private String message;
	
	public PingPong1 (String m, int r){
		message = m;
		delay =r;
	}
	
	public void run(){
		try{
			for(int i = 0; i < 3; i++)
			{
				System.out.println(message);
				Thread.sleep(delay);
			}
		}catch(InterruptedException e){
			return;
		}
		
	}
	public static void main(String args[]) 
	{
		//PingPong1 t3= new PingPong1("ping",500);
		//PingPong1 t4 = new PingPong1("pong",500);
		
		//t3.start();
		//t4.start();
		
		PingPong1 pp1 = new PingPong1("ping",500);
		PingPong1 pp2 = new PingPong1("pong",500);
	   Thread t1 = new Thread(pp1);
	   Thread t2 = new Thread(pp2);
		t1.start();
		 t2.start();
		
		
	}

}


	
