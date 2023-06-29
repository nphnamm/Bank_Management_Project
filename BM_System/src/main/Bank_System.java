package main;

import javax.swing.*;
import view.RemakeScreenForm;
import view.SignForm;
import model.Login_Account;
public class Bank_System extends JFrame{	
	
	public static void main(String[] args) {
		JFrame frame= new JFrame("Bank Managment System");
		frame.setIconImage(new ImageIcon(System.getProperty("user.dir") + "\\src\\image\\ddot.png").getImage() );
		
		
		
		SignForm op = new SignForm();
		Login_Account user = new Login_Account();
		op.openSignInForm(frame, user);
		frame.setSize(900,500);  
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	}
}
