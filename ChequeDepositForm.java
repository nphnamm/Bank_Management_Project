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
import model.Login_Account;

public class ChequeDepositForm {
	
	// cheque deposit screen
	void openChequeDeposit(JFrame frame, Accountant accountant) {
		JPanel f = new JPanel();
		f.setBackground(Color.white);
		
		// Cheque Deposit Label
		JLabel lCheque = new JLabel("Cheque Deposit");
		lCheque.setFont( lCheque.getFont().deriveFont(30f) );
		lCheque.setBounds(150,50,250, 40);
		f.add(lCheque);
		
		// Account Number Label
		JLabel lAccNum = new JLabel("Enter account number:");
		lAccNum.setBounds(150,100,150, 40);
		f.add(lAccNum);
		
		// Account Number Text Field
		JTextField tfAccNum = new JTextField();
		tfAccNum.setBounds(150,130,180, 25);
		f.add(tfAccNum);
		
		// Amount Label
		JLabel lAmount = new JLabel("Enter Amount:");
		lAmount.setBounds(150,160,150, 40);
		f.add(lAmount);
		
		// Amount Text Field
		JTextField tfAmount = new JTextField();
		tfAmount.setBounds(150,190,180, 25);
		f.add(tfAmount);
		
		// Cheque Number Label
		JLabel lChequeNum = new JLabel("Enter Cheque number:");
		lChequeNum.setBounds(150,220,150, 40);
		f.add(lChequeNum);
		
		// Cheque Number Text Field
		JTextField tfChequeNum = new JTextField();
		tfChequeNum.setBounds(150,250,180, 25);
		f.add(tfChequeNum);
		
		// Deposit Button
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBackground( new Color(0, 204, 153) );
		btnDeposit.setForeground(Color.white);
		btnDeposit.setBounds(150,320,110, 40);
		btnDeposit.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\verify.png"));
		f.add(btnDeposit);
		
		// function to be executed when Withdraw Button is clicked
		btnDeposit.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( Integer.valueOf( tfAmount.getText() ) > 0 ) {
					int z = accountant.chequeDeposit( tfAccNum.getText(), tfChequeNum.getText(), Integer.valueOf( tfAmount.getText() ) );	
					if( z == 2) 
						JOptionPane.showMessageDialog(f, "Account not found");
					else if( z == 3) 
						JOptionPane.showMessageDialog(f, "Account is blocked");
					else if( z == 4) 
						JOptionPane.showMessageDialog(f, "Account is closed");
					else
					{
						if( z == 1 ) 
							JOptionPane.showMessageDialog(f, "Cheque Deposit Successful");
						else 
							JOptionPane.showMessageDialog(f, "Cheque Deposit Failed");
						frame.remove(f);
						frame.repaint();
						frame.validate();
						AccountMenuForm accountMenuForm = new AccountMenuForm();

						accountMenuForm.openAccountantMenu(frame, accountant);	
					}
				}
				else
					JOptionPane.showMessageDialog(f, "Invalid Amount");
			}
		});
		
		// Main Menu Button
		JButton btn_mm = new JButton("Main Menu");
		btn_mm.setBackground( new Color(0, 204, 153) );
		btn_mm.setForeground(Color.white);
		btn_mm.setBounds(50,400,120, 30);
		btn_mm.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));

		f.add(btn_mm);
		
		// function to be executed when Main Menu Button is clicked
		btn_mm.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				AccountMenuForm accountMenuForm = new AccountMenuForm();

				accountMenuForm.openAccountantMenu(frame, accountant);
			}
		});
				
		// Sign Out Button
		JButton btn_sign_out = new JButton("Sign Out");
		btn_sign_out.setBackground( new Color(0, 204, 153) );
		btn_sign_out.setForeground(Color.white);
		btn_sign_out.setBounds(650,30,130, 30);
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
		
		// displaying the new panel on frame	
		f.setLayout(null); 
		frame.setContentPane(f);
		frame.setVisible(true);
	}
	
	
}
