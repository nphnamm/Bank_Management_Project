package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Accountant;
import model.Bank_Account;
import model.Client;
import model.Login_Account;

public class DepositCashForm {
			// Hiển thị trường hợp gửi tiền
		void openDepositCash(JFrame frame, Accountant accountant, Client client, Bank_Account account) {
			JPanel f = new JPanel();
			f.setBackground(Color.white);
			
			// Gửi tiền mặt .
			JLabel lDeposit = new JLabel("Deposit Cash");
			lDeposit.setFont( lDeposit.getFont().deriveFont(30f) );
			lDeposit.setBounds(150,50,250, 40);
			f.add(lDeposit);
			
			// Tên
			JLabel lName = new JLabel( "Client Name: " + client.getFName() + " " + client.getLName() );
			lName.setBounds(150,100,350, 40);
			f.add(lName);
				
			// CNIC 
			JLabel lCnic = new JLabel( "CNIC: " + client.getCNIC() );
			lCnic.setBounds(150,130,150, 40);
			f.add(lCnic);
			
			// Số Tài khoản.
			JLabel lAccNum = new JLabel( "Account Number: " + account.getAccountNum() );
			lAccNum.setBounds(150,160,150, 40);
			f.add(lAccNum);
			
			// Tên
			JLabel lType = new JLabel( "Account Type: " + account.getType() );
			lType.setBounds(150,190,150, 40);
			f.add(lType);
			
			//Số tiền.
			JLabel lAmount = new JLabel("Enter amount:");
			lAmount.setBounds(150,240,150, 40);
			f.add(lAmount);
			
			// nhập vào số tiền gửi
			JTextField tfAmount = new JTextField();
			tfAmount.setBounds(150,280,180, 25);
			f.add(tfAmount);
			
			// nút gửi tiền
			JButton btnDeposit = new JButton("Deposit");
			btnDeposit.setBackground( new Color(0, 204, 153) );
			btnDeposit.setForeground(Color.white);
			btnDeposit.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\verify.png"));

			btnDeposit.setBounds(150,320,100, 30);
			f.add(btnDeposit);
			
			//Chức năng được thực thi khi nhấn vào nút Gửi tiền.
			btnDeposit.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// kiểm tra xem số tiền lơn hơn 0 .
					if( tfAmount.getText().compareTo("") != 0 ) {
						if( Integer.valueOf( tfAmount.getText()) > 0 ) {
							// Thêm tiền vào tài khoản
							int r = account.addAmount( Integer.valueOf( tfAmount.getText()) );
							if( r == 1 ) {
								// hiển thị thông báo nộp tiền thành công
								JOptionPane.showMessageDialog(f, "Amount deposited successfully");
							}
							else {
								JOptionPane.showMessageDialog(f, "Amount deposit failed");
							}
							
							// Quay trở lại menu của nhân viên kế toán.
							frame.remove(f);
							frame.repaint();
							frame.validate();
							AccountMenuForm accountMenuForm = new AccountMenuForm();
							accountMenuForm.openAccountantMenu(frame, accountant);
						}
						// số tiền không hợp lệ .
						else {
							JOptionPane.showMessageDialog(f, "Invalid Amount");
						}
					}
					// số tiền không hợp lệ .
					else {
						JOptionPane.showMessageDialog(f, "Invalid Amount");
					}
				}
			});
			
			// Nút trở lại menu chính
			JButton btn_mm = new JButton("Main Menu");
			btn_mm.setBackground( new Color(0, 204, 153) );
			btn_mm.setForeground(Color.white);
			btn_mm.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));

			btn_mm.setBounds(50,400,120, 30);
			f.add(btn_mm);
			
			// chức năng được thực thi nhấn vào nút menu chính .
			btn_mm.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.remove(f);
					frame.repaint();
					frame.validate();
					AccountMenuForm accountMenuForm = new AccountMenuForm();
					accountMenuForm.openAccountantMenu(frame, accountant);
				}
			});
					
			// nút đăng xuất  hiển thị bảng điều khiển mới trên khung
			JButton btn_sign_out = new JButton("Sign Out");
			btn_sign_out.setBackground( new Color(0, 204, 153) );
			btn_sign_out.setForeground(Color.white);
			btn_sign_out.setBounds(650,30,120, 30);
			btn_sign_out.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));

			f.add(btn_sign_out);
			
			//chức năng được thực thi nhấn vào nút đăng xuất 
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
			
			// hiển thị bảng điều khiển mới trên khung
			f.setLayout(null); 
			frame.setContentPane(f);
			frame.setVisible(true);
		}

		
		
		
}
