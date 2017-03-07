package com.zhbitzwz.cn;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
* @author  ZWZ 
* @version 2017年3月7日 下午10:48:52 
* @Function
*/
public class MyFrame extends Frame{
	public TextField textField;
	public Button button;
	
	MyFrame() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		
		button = new Button("隐藏");
		textField = new TextField(12);
		button.setActionCommand("button");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("button")) {
					textField.setVisible(false);
				}
			}
		});
		
		add(button);
		add(textField);
		setBounds(100, 100, 200, 200);
		setVisible(true);
		validate();
	}
	
	public static class test {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			MyFrame myFrame = new MyFrame();
		}

	}
}
