package com.shcw.jchat.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * 登录界面测试类
 * 
 * @author Michael 2020年4月18日 下午3:31:45
 */
public class LoginWinTest extends JFrame {

	private static final long serialVersionUID = 5461551565597110674L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				LoginWin frame = new LoginWin();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
