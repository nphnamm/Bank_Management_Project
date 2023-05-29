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
import javax.swing.JPasswordField;

import model.Bank_Account;
import model.Client;
import model.Login_Account;

public class ChangePasswordForm {
	// client screen to change password of his login id
	RemakeScreenForm gui = new RemakeScreenForm();
	/**
	 * @wbp.parser.entryPoint
	 */
	void open_change_password_form(JFrame frame, Client client, Bank_Account account)
	{
		System.out.println("Control Shifted to Change password form");
		JPanel f = new JPanel();
		f.setBackground(Color.white);
		
		gui.remakeScreen(frame, f);
		
		// Change Password
		JLabel lChgPass = new JLabel("Change Password");
		lChgPass.setFont( lChgPass.getFont().deriveFont(30f) );
		lChgPass.setBounds(250,50,300, 40);
		f.add(lChgPass);
		
		//-------------------------------------------Creating labels-----------------------------------------------		
		JLabel l_curr_pass = new JLabel("Enter Current Password:");
		l_curr_pass.setBounds(150,100,200, 90);
		f.add(l_curr_pass);
		
		JLabel l_new_pass_1 = new JLabel("Enter the new Password:");
		l_new_pass_1.setBounds(150, 150, 200, 90);
		f.add(l_new_pass_1);
		
		JLabel l_new_pass_2 = new JLabel("Confirm the new Password:");
		l_new_pass_2.setBounds(150, 200, 200, 90);
		f.add(l_new_pass_2);
		
		//---------------------------------------------Creating Textfileds------------------------------------------		
		JPasswordField tf_curr_pass = new JPasswordField();
		tf_curr_pass.setBounds(350, 130 ,200, 25);
		f.add(tf_curr_pass);
		
		JPasswordField tf_new_pass_1 = new JPasswordField();
		tf_new_pass_1.setBounds(350,180,200, 25);
		f.add(tf_new_pass_1);
		
		JPasswordField tf_new_pass_2 = new JPasswordField();
		tf_new_pass_2.setBounds(350,230,200, 25);
		f.add(tf_new_pass_2);
		
		//-----------------------------------------------Creating Buttons----------------------------------------		
		JButton btn_change_password = new JButton("Change Password");
		btn_change_password.setBackground( new Color(0, 204, 153) );
		btn_change_password.setForeground(Color.white);
		btn_change_password.setBounds(320,280,170, 40);
		btn_change_password.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\save.png"));

		f.add(btn_change_password);
		
		// Main Menu Button
		JButton btnMM = new JButton("Main Menu");
		btnMM.setBackground( new Color(0, 204, 153) );
		btnMM.setForeground(Color.white);
		btnMM.setBounds(50,400,120, 30);
		btnMM.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));

		f.add(btnMM);
		
		// function to be executed when Main Menu Button is clicked
		btnMM.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				ClientMenuForm clientMenuForm = new ClientMenuForm();
				clientMenuForm.openClientMenu(frame, client, account);
			}
		});
		
		// function to be executed when Change Password Button is clicked
		btn_change_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int change_pwd_status = client.change_password(tf_curr_pass.getText(), tf_new_pass_1.getText(), tf_new_pass_2.getText(), account.getAccountNum());
		
				if (change_pwd_status == -1)
				{
					JOptionPane.showMessageDialog(f, "The system was unable to find the login account");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					open_change_password_form(frame, client, account);
				}
				else if ( change_pwd_status == -2 )
				{
					System.out.println("The current password does not match with the already configured password");
					JOptionPane.showMessageDialog(f, "The current password does not match with the already configured password");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					open_change_password_form(frame, client, account);
				}
				else if (change_pwd_status == -3)
				{
					System.out.println("The new passwords does not match with one another");
					JOptionPane.showMessageDialog(f, "The new passwords does not match with one another");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					open_change_password_form(frame, client, account);
				}
				else
				{
					JOptionPane.showMessageDialog(f, "You have successfully changed your password. You will have to Sign in again to continue");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					Login_Account user = new Login_Account();
					SignForm sf = new SignForm();
					sf.openSignInForm(frame, user);
				}
			}
		});
	}
	
	
	
	//----------------------------------------------------
	//               Manager Related Screen               |
	//----------------------------------------------------
	
}
