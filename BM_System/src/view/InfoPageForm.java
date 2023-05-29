package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Bank_Account;
import model.Client;
import model.Login_Account;

public class InfoPageForm {
	// chức năng này hiển thị chi tiết tài khoản khách hàng trên màn hình
	RemakeScreenForm gui = new RemakeScreenForm ();
	void open_info_page(JFrame frame, Client client, Bank_Account account)
	{
		JPanel f = new JPanel();
		f.setBackground(Color.white);
		gui.remakeScreen(frame, f);
	

		//Thông tin tài khoản
		JLabel lAccInfo = new JLabel("Account Info");
		lAccInfo.setHorizontalAlignment(JLabel.CENTER);
		lAccInfo.setFont( lAccInfo.getFont().deriveFont(30f) );
		lAccInfo.setBounds(300,40,200, 40);
		f.add(lAccInfo);
		
		//Tên Chủ Tài khoản
		JLabel l_name = new JLabel("Account Holder Name");
		l_name.setHorizontalAlignment(JLabel.CENTER);
		l_name.setBounds(300, 70, 200, 90);
		f.add(l_name);
		JTextField tf_name = new JTextField();
		tf_name.setHorizontalAlignment(JTextField.CENTER);
		tf_name.setBounds(300, 130 ,200, 25);
		tf_name.setText(client.getFName() + " " + client.getLName());
		tf_name.setEditable(false);
		f.add(tf_name);
		
		//Số tài khoản
		JLabel l_acc_num = new JLabel("Account Number:");
		l_acc_num.setHorizontalAlignment(JLabel.CENTER);
		l_acc_num.setBounds(150, 160, 200, 90);
		f.add(l_acc_num);
		JTextField tf_acc_num = new JTextField();
		tf_acc_num.setHorizontalAlignment(JTextField.CENTER);
		tf_acc_num.setBounds(150, 220 ,200, 25);
		tf_acc_num.setText( account.getAccountNum() );
		tf_acc_num.setEditable(false);
		f.add(tf_acc_num);

		//Kiểu tài khoản
		JLabel l_acc_type = new JLabel("Account Type");
		l_acc_type.setHorizontalAlignment(JLabel.CENTER);
		l_acc_type.setBounds(400, 160, 200, 90);
		f.add(l_acc_type);
		JTextField tf_acc_type = new JTextField(account.getType() );
		tf_acc_type.setHorizontalAlignment(JTextField.CENTER);
		tf_acc_type.setBounds(400, 220 ,200, 25);
		tf_acc_type.setEditable(false);
		f.add(tf_acc_type);
		
		//Số dư tài khoản hiện tại
		JLabel l_balance = new JLabel("Account Current Balance");
		l_balance.setHorizontalAlignment(JLabel.CENTER);
		l_balance.setBounds(150, 250, 200, 90);
		f.add(l_balance);
		JTextField tf_balance = new JTextField();
		tf_balance.setHorizontalAlignment(JTextField.CENTER);
		tf_balance.setBounds(150, 310 ,200, 25);
		tf_balance.setText( account.getBalance() );
		tf_balance.setEditable(false);;
		f.add(tf_balance);
		
		//Ngày mở tài khoản
		JLabel l_open_date = new JLabel("Account Opening Date");
		l_open_date.setHorizontalAlignment(JLabel.CENTER);
		l_open_date.setBounds(400, 250, 200, 90);
		f.add(l_open_date);
		JTextField tf_open_date = new JTextField();
		tf_open_date.setHorizontalAlignment(JTextField.CENTER);
		tf_open_date.setBounds(400, 310 ,200, 25);
		tf_open_date.setText( account.getOpeningDate() );
		tf_open_date.setEditable(false);
		f.add(tf_open_date);
		//nut menu chinh
		JButton btn_BACK = new JButton("Main Menu");
		btn_BACK.setBackground( new Color(0, 204, 153) );
		btn_BACK.setForeground(Color.white);
		btn_BACK.setBounds(50,400,120, 30);
		btn_BACK.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));

		f.add(btn_BACK);
		
		btn_BACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				ClientMenuForm clientMenuForm = new ClientMenuForm();
				clientMenuForm.openClientMenu(frame, client, account);
			}
		});
		//nút đăng xuất 
		JButton btn_sign_out = new JButton("Sign Out");
		btn_sign_out.setBackground( new Color(0, 204, 153) );
		btn_sign_out.setForeground(Color.white);
		btn_sign_out.setBounds(630,30,130, 30);
		btn_sign_out.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));

		f.add(btn_sign_out);
		
		btn_sign_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				Login_Account user = new Login_Account();
				SignForm sf = new SignForm();
				sf.openSignInForm(frame, user);
			}
		});
	}
	
	
	
}
