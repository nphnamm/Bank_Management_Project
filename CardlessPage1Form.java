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

import model.Bank_Account;
import model.Client;
import model.Login_Account;

public class CardlessPage1Form {
	// cardless cash withdrawal screen
	RemakeScreenForm gui = new RemakeScreenForm();
	/**
	 * @wbp.parser.entryPoint
	 */
	void open_cardless_page_1(JFrame frame, Client client, Bank_Account account)
	{
		System.out.println("Control Shifted to Cardless form_1 page");
		JPanel f = new JPanel();
		f.setBackground(Color.white);
		
		gui.remakeScreen(frame, f);
		
		// Cardless Cash Withdrawal Label
		JLabel lCCWithdrawal = new JLabel("Cardless Cash Withdrawal");
		lCCWithdrawal.setFont( lCCWithdrawal.getFont().deriveFont(30f) );
		lCCWithdrawal.setBounds(200,40,400, 40);
		f.add(lCCWithdrawal);
		
		//-------------------------------------------Creating labels-----------------------------------------------		
		JLabel l_card_no = new JLabel("Enter Your Card No:");
		l_card_no.setBounds(150,100,180, 90);
		f.add(l_card_no);
		
		JLabel l_amount = new JLabel("Enter the amount of withdrawal:");
		l_amount.setBounds(150, 160, 180, 90);
		f.add(l_amount);
		
		JLabel l_temp_pin = new JLabel("Enter the 4-digit temporary pin:");
		l_temp_pin.setBounds(150, 220, 180, 90);
		f.add(l_temp_pin);
		
		//---------------------------------------------Creating Textfileds------------------------------------------		
		JTextField tf_card_no = new JTextField();
		tf_card_no.setBounds(380, 130 ,200, 25);
		f.add(tf_card_no);
		
		JTextField tf_amount = new JTextField();
		tf_amount.setBounds(380,190,200, 25);
		f.add(tf_amount);
		
		JTextField tf_temp_pin = new JTextField();
		tf_temp_pin.setBounds(380,250,200, 25);
		f.add(tf_temp_pin);
		
		//-----------------------------------------------Creating Buttons----------------------------------------		
		JButton btn_create_cardless_entry = new JButton("Generate transaction OTP");
		btn_create_cardless_entry.setBackground( new Color(0, 204, 153) );
		btn_create_cardless_entry.setForeground(Color.white);
		btn_create_cardless_entry.setBounds(300,300,230, 40);
		btn_create_cardless_entry.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\otp.png"));

		f.add(btn_create_cardless_entry);
		
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
		
		// Main Menu Button
		JButton btn_mm = new JButton("Main Menu");
		btn_mm.setBackground( new Color(0, 204, 153) );
		btn_mm.setForeground(Color.white);
		btn_mm.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));

		btn_mm.setBounds(50,400,120, 30);
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
		
		// function to be executed when
		btn_create_cardless_entry.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
	
				if ( account.getCardNum().compareTo(tf_card_no.getText()) != 0 )
				{
					System.out.println("There is no card associated with this account as the card num received is 0");					
					JOptionPane.showMessageDialog(f, "You do not have any associated cards with this account");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					open_cardless_page_1(frame, client, account);
				}
				else {
					String cardless_status = client.do_cardless_cash_withdrawal(account, tf_amount.getText(), tf_temp_pin.getText());
					if ( cardless_status.compareTo("a")==0 )
					{
						JOptionPane.showMessageDialog(f, "Your card is currently blocked");
						frame.remove(f);
						frame.repaint();
						frame.validate();
						open_cardless_page_1(frame, client, account);
					}
					else if( cardless_status.compareTo("b")==0 )
					{
						//					System.out.println("Your card is active because status was either A or a");
						JOptionPane.showMessageDialog(f, "You do not have enough balance to complete this transaction");
						frame.remove(f);
						frame.repaint();
						frame.validate();
						open_cardless_page_1(frame, client, account);
					}
					else if (cardless_status.compareTo("c")==0)
					{
						JOptionPane.showMessageDialog(f, "Your request of cardless withdrawal could not be completed");
						frame.remove(f);
						frame.repaint();
						frame.validate();
						open_cardless_page_1(frame, client, account);
					}
					else 
					{
						//					System.out.println("You have enough balance to carry out this transaction");
						System.out.println("Your request of cardless withdrawal has been successfully completed");
						JOptionPane.showMessageDialog(f, "Your request of cardless withdrawal has been completed and your OTP is "+String.valueOf(cardless_status));
						account.updateBalance();
						frame.remove(f);
						frame.repaint();
						frame.validate();
						ClientMenuForm clientMenuForm = new ClientMenuForm();
						clientMenuForm.openClientMenu(frame, client, account);
					}
				}
			}
		});
	}
	
	
	
}
