package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Bank_Account;
import model.Client;
import model.Login_Account;

public class CheckOTPForm {
	private JLabel lCCWithdrawal;
	private JLabel l_temp_otp;
	private JTextField tf_temp_otp;
	private JButton btn_create_cardless_entry;
	RemakeScreenForm gui = new RemakeScreenForm();
	private int check;
	// cardless cash withdrawal screen
		
		
		void open_enter_otp_form(JFrame frame, Client client, Bank_Account account) {
			System.out.println("Nam");
			JPanel f = new JPanel();
			f.setBackground(Color.white);
			gui.remakeScreen(frame, f);
			
			
			// Cardless Cash Withdrawal Label
			lCCWithdrawal = new JLabel("Cardless Cash Withdrawal");
			lCCWithdrawal.setFont( lCCWithdrawal.getFont().deriveFont(30f) );
			lCCWithdrawal.setBounds(200,40,400, 40);
			f.add(lCCWithdrawal);
			
			//-------------------------------------------Creating labels-----------------------------------------------		
		

			l_temp_otp = new JLabel("Enter Your OTP:");
			l_temp_otp.setBounds(150, 100, 180, 90);
			f.add(l_temp_otp);
			
			//---------------------------------------------Creating Textfileds------------------------------------------		
			
			
			tf_temp_otp = new JTextField();
			tf_temp_otp.setBounds(380, 130 ,200, 25);
			f.add(tf_temp_otp);
			
			//-----------------------------------------------Creating Buttons----------------------------------------		
			btn_create_cardless_entry = new JButton("Check");
			btn_create_cardless_entry.setBackground( new Color(0, 204, 153) );
			btn_create_cardless_entry.setForeground(Color.white);
			btn_create_cardless_entry.setBounds(300,300,230, 40);
			btn_create_cardless_entry.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\check.png"));

			f.add(btn_create_cardless_entry);
			check=0;
			JButton btn_SignUp = new JButton("Sign Up");
			btn_SignUp.setFont( btn_SignUp.getFont().deriveFont(18f) );
			btn_SignUp.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\sign-up.png"));

			btn_SignUp.setBackground( new Color(0, 204, 153) );
			btn_SignUp.setForeground(Color.white);
			btn_SignUp.setBounds(650,380,126, 40);
			f.add(btn_SignUp);
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
					ClientMenuForm clientMenuForm = new ClientMenuForm();
					clientMenuForm.openClientMenu(frame, client, account);
				}
			});
				
			//---------------------------------------SignUp functionality----------------------------------------------
			
			JButton btn_sign_out = new JButton("Sign Out");
			btn_sign_out.setBackground( new Color(0, 204, 153) );
			btn_sign_out.setForeground(Color.white);
			btn_sign_out.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));

			btn_sign_out.setBounds(650,30,130, 30);
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
			btn_create_cardless_entry.addActionListener(new ActionListener () {
				
				
				
				public void actionPerformed (ActionEvent e) {
					
					 
					
				}
			});	
			
		}
//		int open_check_otp_form(String otp)
//		{
//			
//			
//			if(tf_temp_otp.getText().equals(otp)) {
//				return 1;
//			}
//		
//			
//			return 0;
//			
//		
//		}
	
		
		
}
