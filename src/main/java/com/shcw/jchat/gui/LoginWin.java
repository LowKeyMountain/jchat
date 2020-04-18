package com.shcw.jchat.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

/**
 * 登录界面
 * 
 * @author Michael 2020年4月18日 下午3:31:45
 */
public class LoginWin extends JFrame {

	private static final long serialVersionUID = -2717544901437499083L;

	public LoginWin() {

		int gap = 10;
		final JFrame jf = this;
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setUndecorated(true);

		// 设置标题
		setTitle("登陆");

		// 不设置风格
		setLayout(null);

		// 将登陆框放在屏幕中间
		int x = (int) (width / 2 - DEFAULT_WIDTH * 0.5);
		int y = (int) (height / 2 - DEFAULT_HEIGHT * 0.5);
		setLocation(x, y);

		// 设置窗口大小
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// 添加输入框
		JPanel jp = new JPanel();
		jp.setBounds(gap * 3, (int) (DEFAULT_HEIGHT * 0.2), (int) (DEFAULT_WIDTH * 0.8), (int) (DEFAULT_HEIGHT * 0.3));
		jp.setLayout(new GridLayout(3, 2, gap, gap));

		JLabel userNameLabel = new JLabel("用户名：");
		final JTextField userNameText = new JTextField();

		JLabel passwordLabel = new JLabel("密    码：");
		final JPasswordField passwordText = new JPasswordField();
		jp.add(userNameLabel);
		jp.add(userNameText);
		jp.add(passwordLabel);
		jp.add(passwordText);

		this.add(jp);

		// 添加按钮
		JPanel p_button = new JPanel();
		p_button.setBounds(gap * 3, (int) (DEFAULT_HEIGHT * 0.65), (int) (DEFAULT_WIDTH * 0.8),
				(int) (DEFAULT_HEIGHT * 0.1));
		p_button.setLayout(new GridLayout(1, 2, gap, gap));

		JButton b_Login = new JButton("登陆");
		p_button.add(b_Login);

		JButton b_register = new JButton("注册");
		p_button.add(b_register);

		this.add(p_button);

		// 登陆按钮鼠标监听
		b_Login.addActionListener(new ActionListener() {
			boolean checkedpass = true;

			public void actionPerformed(ActionEvent e) {
				checkedpass = true;
				checkEmpty(userNameText, "用户名");
				checkEmpty(passwordText, "密码");
				// 进行登录后台逻辑验证
				if (!checkedpass) {
					return;
				}
				if (StringUtils.equals(userNameText.getText(), "admin")
						&& StringUtils.equals(new String(passwordText.getPassword()), "123456")) {
					JOptionPane.showMessageDialog(jf, "用户登录成功！");
				} else {
					JOptionPane.showMessageDialog(jf, "用户名或密码错误，请重新填写！");
					userNameText.setText("");
					passwordText.setText("");
				}
			}

			/**
			 * 字段非空验证
			 * 
			 * @param field
			 * @param typeName
			 */
			private void checkEmpty(JTextField field, String typeName) {
				if (!checkedpass) {
					return;
				}
				if (StringUtils.isEmpty(field.getText())) {
					JOptionPane.showMessageDialog(jf, typeName + "不能为空！");
					field.grabFocus();
					checkedpass = false;
				}
			}
		});

		// 注册按钮鼠标监听
		b_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 300;

}
