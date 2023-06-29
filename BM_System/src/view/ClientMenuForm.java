package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Bank_Account;
import model.Client;
import model.Login_Account;

public class ClientMenuForm {
	void openClientMenu(JFrame frame, Client client, Bank_Account account) {
		JPanel f = new JPanel();
		f.setBackground(Color.white);
		
		// Log Out button
		JButton btnLogOut = new JButton("Sign Out");
		btnLogOut.setFont( btnLogOut.getFont().deriveFont(14f) );
		btnLogOut.setBackground( new Color(0, 204, 153) );
		btnLogOut.setForeground(Color.white);
		//btnLogOut.setBounds(580,58,100, 30);
		btnLogOut.setBounds(630,30,130, 30);
		btnLogOut.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));

		btnLogOut.setFocusPainted(false);
		f.add(btnLogOut);
		
		// function to be executed when Log Out Button is clicked
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				Login_Account user = new Login_Account ();
				SignForm sf = new SignForm();
				sf.openSignInForm(frame, user);
			}
		});
		
		// User Name label
		JLabel lUser =  new JLabel(client.getFName() + " " + client.getLName());
		lUser.setFont( lUser.getFont().deriveFont(40f) );
		lUser.setBounds(100,50,400, 45);
		f.add(lUser);
		
		// Designation label
		JLabel lDesg = new JLabel("User");
		lDesg.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\user.png"));
		lDesg.setFont( lUser.getFont().deriveFont(30f) );
		lDesg.setBounds(100,100,150, 65);
		f.add(lDesg);
		
		// Account Info Button
		JButton btnAccInfo = new JButton("Account Info");
		btnAccInfo.setBounds(100,180,170, 40);
		btnAccInfo.setBackground( new Color(0, 204, 153) );
		btnAccInfo.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\info.png"));

		btnAccInfo.setForeground(Color.white);
		f.add(btnAccInfo);
		
		// function to be executed when Account Info Button is clicked
		btnAccInfo.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				InfoPageForm infoPageForm = new InfoPageForm();
				infoPageForm.open_info_page(frame, client, account);
			}
		});

		// Cardless Cash WithDrawal Button
		JButton btnCCWithdrawal = new JButton("Cardless Cash Withdrawal");
		btnCCWithdrawal.setBounds(320,180,220, 40);
		btnCCWithdrawal.setBackground( new Color(0, 204, 153) );
		btnCCWithdrawal.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\cardless.png"));
		btnCCWithdrawal.setForeground(Color.white);
		f.add(btnCCWithdrawal);
		
		// function to be executed when Cardless Cash Withdrawal Button is clicked
		btnCCWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardlessPage1Form cardlessPage1Form = new CardlessPage1Form();
				cardlessPage1Form.open_cardless_page_1(frame, client, account);
			}
		});
		
		// Transfer Money Button
		JButton btnTransferMoney = new JButton("Transfer Money");
		btnTransferMoney.setBounds(590,180,170, 40);
		btnTransferMoney.setBackground( new Color(0, 204, 153) );
		btnTransferMoney.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\transfer.png"));

		btnTransferMoney.setForeground(Color.white);
		f.add(btnTransferMoney);
	
		// EStatement Button
		JButton btnEStatement = new JButton("View EStatement");
		btnEStatement.setBounds(100,250,170, 40);
		btnEStatement.setBackground( new Color(0, 204, 153) );
		btnEStatement.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\estatement.png"));

		btnEStatement.setForeground(Color.white);
		f.add(btnEStatement);
	
		// function to be executed when transfer money button is clicked
		btnTransferMoney.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				frame.remove(f);
				frame.repaint();
				frame.validate();
				TransferMoneyForm transferMoneyForm = new TransferMoneyForm();
				transferMoneyForm.openTransferMoneyForm(frame, client, account);
			}
		});
		
		// function to be executed when View EStatement Button is clicked
		btnEStatement.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				frame.remove(f);
				frame.repaint();
				frame.validate();
				Estatement2Form estatement2Form = new Estatement2Form();
				estatement2Form.openEstatement2(frame, client, account);
			}
		});
		
		//change password 
		JButton btnChangePass = new JButton("Change Password");
		btnChangePass.setBounds(320, 250, 220, 40);
		btnChangePass.setBackground( new Color(0, 204, 153) );
		btnChangePass.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\change-password.png"));

		btnChangePass.setForeground(Color.white);
		f.add(btnChangePass);
		
		btnChangePass.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				frame.remove(f);
				frame.repaint();
				frame.validate();
				ChangePasswordForm changePasswordForm = new ChangePasswordForm();
				changePasswordForm.open_change_password_form(frame, client, account);
			}
		});	
		
		f.setLayout(null); 
		frame.setContentPane(f);
		frame.setVisible(true);
	}
}
