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

public class BlockOrUnblockAccountForm {
	// block unblock account screen
	RemakeScreenForm gui = new RemakeScreenForm();
	/**
	 * @wbp.parser.entryPoint
	 */
	void open_block_unblock_account_page(JFrame frame, Manager manager)
	{
		//--------------------------------Clearing screen for new page---------------------------------------		
		JPanel f = new JPanel();
		f.setBackground(Color.white);
		gui.remakeScreen(frame, f);
		
		// Block Unblock Account Label
		JLabel lBUAcc = new JLabel("Block/Unblock Account");
		lBUAcc.setFont( lBUAcc.getFont().deriveFont(30f) );
		lBUAcc.setBounds(200,40,400, 40);
		
		f.add(lBUAcc);
		
		//----------------------------------Creating Labels-----------------------------------------------------				
		JLabel l_account_no = new JLabel("Enter Account No:");
		l_account_no.setBounds(200,110,150, 90);
		f.add(l_account_no);
				
		JLabel l_cnic = new JLabel("Enter CNIC:");
		l_cnic.setBounds(200, 170, 100, 90);
		f.add(l_cnic);

		//-----------------------------------Creating Textfields-----------------------------------------------				
		JTextField tf_account_no = new JTextField();
		tf_account_no.setBounds(400, 140 ,200, 25);
		f.add(tf_account_no);
				
		JTextField tf_cnic = new JTextField();
		tf_cnic.setBounds(400,200,200, 25);
		f.add(tf_cnic);
		
		//------------------------------------Creating buttons---------------------------------------------------				
		JButton btn_block_account = new JButton("Block Account");
		btn_block_account.setBackground( new Color(0, 204, 153) );
		btn_block_account.setForeground(Color.white);
		btn_block_account.setBounds(300,270,160, 40);
		btn_block_account.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\block.png"));

		f.add(btn_block_account);
		
		JButton btn_unblock_account = new JButton("UnBlock Account");
		btn_unblock_account.setBackground( new Color(0, 204, 153) );
		btn_unblock_account.setForeground(Color.white);
		btn_unblock_account.setBounds(300,320,160,40);
		btn_unblock_account.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\unlock.png"));
		f.add(btn_unblock_account);
				
		// function to be executed when Block Account Button is clicked
		btn_block_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Request received of blocking account with acc num:"+acc_num+" and cnic:"+cnic);
				
				int block_status = manager.block_account( Integer.parseInt(tf_account_no.getText()), tf_cnic.getText() );

				if ( block_status == -1 )
				{
					JOptionPane.showMessageDialog(f, "Your entered credentials do not match with any account");
				}
				else if (block_status == -2)
				{
					JOptionPane.showMessageDialog(f, "There is no active account with these details");
				}
				else if (block_status == -3)
				{
					JOptionPane.showMessageDialog(f, "Your entered account is already blocked");
				}
				else
				{
					JOptionPane.showMessageDialog(f, "The selected account has been successfully blocked");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					ManagerMenuForm mangeMenuForm = new ManagerMenuForm();
					mangeMenuForm.openManagerMenu(frame, manager);
				}
			}
		});
				
		// function to be executed when Unblock Account Button is clicked
		btn_unblock_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int unblock_status = manager.unblock_account( Integer.parseInt(tf_account_no.getText()), tf_cnic.getText() );
				
				if ( unblock_status == -1)
				{
					JOptionPane.showMessageDialog(f, "Your entered credentials do not match with any account");
				}
				else if ( unblock_status == -2)
				{
					JOptionPane.showMessageDialog(f, "There is no active account with these details");
				}
				else if (unblock_status == -3)
				{
					JOptionPane.showMessageDialog(f, "Your entered account is already active and working");
				}
				else
				{
					JOptionPane.showMessageDialog(f, "The selected account has been successfully unblocked");
					frame.remove(f);
					frame.repaint();
					frame.validate();
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
		
		// function to be executed when Main Menu Button is clicked
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
	}

	
}
