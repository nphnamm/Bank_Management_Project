package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Accountant;
import model.Login_Account;

public class AccountMenuForm {
	//--------------------------------------------------------
	//               Accountant Related Screens               |
	//--------------------------------------------------------
	
	
	// Accountant Menu
	/**
	 * @wbp.parser.entryPoint
	 */
	void openAccountantMenu(JFrame frame, Accountant accountant) {
		JPanel f = new JPanel();
		f.setBackground(Color.white);
				
		// User Name label
		JLabel lUser = new JLabel( accountant.getName() );
		lUser.setFont( lUser.getFont().deriveFont(40f) );
		lUser.setBounds(100,40,300, 40);
		f.add(lUser);
		
		// Designation label
		JLabel lDesg = new JLabel("Accountant");
		lDesg.setFont( lDesg.getFont().deriveFont(30f) );
		lDesg.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\accountant.png"));

		
		lDesg.setBounds(100,100,450, 70);
		f.add(lDesg);
		
		// Deposit Cash button
		JButton btnDeposit = new JButton("Deposit Cash");
		btnDeposit.setBackground( new Color(0, 204, 153) );
		btnDeposit.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\deposit-cash.png"));
		btnDeposit.setForeground(Color.white);
		btnDeposit.setBounds(100,180,200, 50);
		f.add(btnDeposit);
		
		// Withdraw Cash button
		JButton btnWithdraw = new JButton("Withdraw Cash");
		btnWithdraw.setBackground( new Color(0, 204, 153) );
		btnWithdraw.setForeground(Color.white);
		btnWithdraw.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\withdraw-cash.png"));
		btnWithdraw.setBounds(350,180,200, 50);
		f.add(btnWithdraw);
		
		// Cheque Deposit button
		JButton btnChequeDeposit = new JButton("Cheque Deposit");
		btnChequeDeposit.setBackground( new Color(0, 204, 153) );
		btnChequeDeposit.setForeground(Color.white);
		btnChequeDeposit.setBounds(600,180,200, 50);
		btnChequeDeposit.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\cheque-deposit.png"));

		f.add(btnChequeDeposit);
		
		// E-Statement button
		JButton btnEStatement = new JButton("Issue E-Statement");
		btnEStatement.setBackground( new Color(0, 204, 153) );
		btnEStatement.setForeground(Color.white);
		btnEStatement.setBounds(350,250,200, 50);
		btnEStatement.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\estatement.png"));

		f.add(btnEStatement);
		
		// function to be executed when Deposit button is clicked
		btnDeposit.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				SearchForm sF = new SearchForm();
				sF.searchForm(frame, accountant, 1);
			}
		});
		
		// function to be executed when Withdraw Button is clicked
		btnWithdraw.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				SearchForm sF = new SearchForm();
				sF.searchForm(frame, accountant, 2);
			}
		});
		
		// function to be executed when Cheque Deposit Button is clicked
		btnChequeDeposit.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				ChequeDepositForm chequeDepositForm = new ChequeDepositForm();
				chequeDepositForm.openChequeDeposit(frame, accountant);
			}
		});
		
	
		// function to be executed when EStatement Button is clicked
		btnEStatement.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				SearchForm sF = new SearchForm();
				sF.searchForm(frame, accountant, 3);
			}
		});
		
		// Sign Out Button
		JButton btn_sign_out = new JButton("Sign Out");
		btn_sign_out.setBackground( new Color(0, 204, 153) );
		btn_sign_out.setForeground(Color.white);
		btn_sign_out.setBounds(680,30,120, 40);
		btn_sign_out.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));

		f.add(btn_sign_out);
		
		// function to be executed when Sign Out Button is clicked
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
		
		f.setLayout(null); 
		frame.setContentPane(f);
		frame.setVisible(true);
	}
	
	
}
