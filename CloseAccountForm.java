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

import model.Login_Account;
import model.Manager;

public class CloseAccountForm {
	// close account screen
	RemakeScreenForm gui = new RemakeScreenForm();
			
	void open_close_account_page(JFrame frame, Manager manager)
	{
		//--------------------------------Clearing screen for new page---------------------------------------		
		JPanel f = new JPanel();
		f.setBackground(Color.white);
		gui.remakeScreen(frame, f);
		
		// Close Account Label
		JLabel lCloseAcc = new JLabel("Close Account");
		lCloseAcc.setFont( lCloseAcc.getFont().deriveFont(30f) );
		lCloseAcc.setBounds(300,40,400, 40);
		f.add(lCloseAcc);
		
		//----------------------------------Creating Labels-----------------------------------------------------				
		JLabel l_account_no = new JLabel("Enter Account No:");
		l_account_no.setBounds(220,110,150, 90);
		f.add(l_account_no);
		
		JLabel l_cnic = new JLabel("Enter CNIC:");
		l_cnic.setBounds(220, 170, 100, 90);
		f.add(l_cnic);
		
		//-----------------------------------Creating Textfields-----------------------------------------------				
		JTextField tf_account_no = new JTextField();
		tf_account_no.setBounds(400, 140 ,200, 25);
		f.add(tf_account_no);
		
		JTextField tf_cnic = new JTextField();
		tf_cnic.setBounds(400,200,200, 25);
		f.add(tf_cnic);

		//------------------------------------Creating buttons---------------------------------------------------				
		JButton btn_close_account = new JButton("Close Account");
		btn_close_account.setBackground( new Color(0, 204, 153) );
		btn_close_account.setForeground(Color.white);
		btn_close_account.setBounds(300,280,150, 40);
		btn_close_account.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\cancel.png"));

		f.add(btn_close_account);

		// hàm của nút close accout
		btn_close_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int close_status = manager.close_account(tf_account_no.getText(), tf_cnic.getText());
				
				if ( close_status == 0 )
				{
					JOptionPane.showMessageDialog(f, "Your account has been successfully closed");
					ManagerMenuForm mangeMenuForm = new ManagerMenuForm();
					mangeMenuForm.openManagerMenu(frame, manager);
				}
				else
				{
					JOptionPane.showMessageDialog(f, "Your entered deatils do not match with any account");
					ManagerMenuForm mangeMenuForm = new ManagerMenuForm();
					mangeMenuForm.openManagerMenu(frame, manager);
				}
			}
		});
		
		// Main Menu Button
		JButton btn_mm = new JButton("Main Menu");
		btn_mm.setBackground( new Color(0, 204, 153) );
		btn_mm.setForeground(Color.white);
		btn_mm.setBounds(50,400,130, 30);
		btn_mm.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));

		f.add(btn_mm);
		
		// hàm của nút main menu
		btn_mm.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				ManagerMenuForm mangeMenuForm = new ManagerMenuForm();
				mangeMenuForm.openManagerMenu(frame, manager);
			}
		});
				
		// Sign Out Button
		JButton btn_sign_out = new JButton("Sign Out");
		btn_sign_out.setBackground( new Color(0, 204, 153) );
		btn_sign_out.setForeground(Color.white);
		btn_sign_out.setBounds(650,30,120, 30);
		btn_sign_out.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));

		f.add(btn_sign_out);
		
		// hàm của nút Sigh Out
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
