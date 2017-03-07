package com.zhbitzwz.cn;
import java.io.*;
public class try_catch {
	public static void main(String args[]){
		RandomAccessFile file;
		try{
			file = new RandomAccessFile("abc.txt","r");
			for(int i = 0 ;i < 20; i++)
				System.out.println((char)file.readByte());
			file.close();
		}catch(FileNotFoundException e1){
			e1.printStackTrace();
		}catch(IOException e2){
			e2.printStackTrace();
		}
		System.out.println("try ...catch 代码块后的代码可以执行");
	}

}
