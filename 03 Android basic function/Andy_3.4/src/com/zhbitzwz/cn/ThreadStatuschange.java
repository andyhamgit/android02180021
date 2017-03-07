package com.zhbitzwz.cn;
public class ThreadStatuschange {
	public static void main(String args[]){
		MyRunner r = new MyRunner();//ÐÂ½¨×´Ì¬
		Thread t = new Thread(r);
		t.start();//Æô¶¯×´Ì¬
	}

}

class MyRunner implements Runnable{
	public void run(){
		for(int i = 0; i < 20; i++ ){
			if(i%5 == 0 && i!= 0){
				try{
					Thread.sleep(3000);//×èÈû×´Ì¬
				}catch(InterruptedException e){
					
				}
			}
			System.out.println("No. " + i);//ÔËÐÐ×´Ì¬
		}
	}
}
