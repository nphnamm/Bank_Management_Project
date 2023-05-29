package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Client;
import model.Login_Account;
import model.Manager;

public class CreateAccountFrom {
	
	// hiển thị tạo tài khoản mới
	public void openCreateAccountForm(JFrame frame, Manager manager) {
		JPanel f = new JPanel();
		f.setBackground(Color.white);
		
		// tạo tài khoản
		JLabel l_hcreate = new JLabel("Create Account");
		l_hcreate.setFont( l_hcreate.getFont().deriveFont(30f) );
		l_hcreate.setBounds(300,40,300, 40);
		f.add(l_hcreate);
		
		// các trường tài khoản
		JLabel l_fName = new JLabel("First Name: ");
		l_fName.setBounds(100,100,100, 40);
		f.add(l_fName);
		JLabel l_lName = new JLabel("Last Name: ");
		l_lName.setBounds(400,100,100, 40);
		f.add(l_lName);
		JLabel l_fatherName = new JLabel("Father Name: ");
		l_fatherName.setBounds(100,150,100, 40);
		f.add(l_fatherName);
		JLabel l_motherName = new JLabel("Mother Name: ");
		l_motherName.setBounds(400,150,100, 40);
		f.add(l_motherName);
		JLabel l_cnic = new JLabel("CNIC: ");
		l_cnic.setBounds(100,200,100, 40);
		f.add(l_cnic);
		JLabel l_dob = new JLabel("Date of Birth: ");
		l_dob.setBounds(400,200,100, 40);
		f.add(l_dob);
		JLabel l_phone = new JLabel("Phone: ");
		l_phone.setBounds(100,250,100, 40);
		f.add(l_phone);
		JLabel l_email = new JLabel("Email: ");
		l_email.setBounds(400,250,100, 40);
		f.add(l_email);
		JLabel l_address = new JLabel("Address: ");
		l_address.setBounds(100,300,100, 40);
		f.add(l_address);
		JLabel l_acc_type = new JLabel("Account Type: ");
		l_acc_type.setBounds(400,300,100, 40);
		f.add(l_acc_type);
		
		// nhập vào thông tin
		JTextField tf_fName = new JTextField();
		tf_fName.setBounds(200,100,180, 25);
		f.add(tf_fName);
		JTextField tf_lName = new JTextField();
		tf_lName.setBounds(500,100,180, 25);
		f.add(tf_lName);
		JTextField tf_fatherName = new JTextField();
		tf_fatherName.setBounds(200,150,180, 25);
		f.add(tf_fatherName);
		JTextField tf_motherName = new JTextField();
		tf_motherName.setBounds(500,150,180, 25);
		f.add(tf_motherName);
		JTextField tf_cnic = new JTextField();
		tf_cnic.setBounds(200,200,180, 25);
		f.add(tf_cnic);
		JTextField tf_dob = new JTextField();
		tf_dob.setBounds(500,200,180, 25);
		f.add(tf_dob);
		JTextField tf_phone = new JTextField();
		tf_phone.setBounds(200,250,180, 25);
		f.add(tf_phone);
		JTextField tf_email = new JTextField();
		tf_email.setBounds(500,250,180, 25);
		f.add(tf_email);
		JTextField tf_address = new JTextField();
		tf_address.setBounds(200,300,180, 25);
		f.add(tf_address);
		
		// Loại Tài khoản
		String[] types = {"Current", "Saving" };
		JComboBox jcb_types = new JComboBox(types);
		jcb_types.setBounds(500,300,180, 25);
		f.add(jcb_types);
			
		// Button  Tạo
		JButton btn_create = new JButton("Create");
		btn_create.setBackground( new Color(0, 204, 153) );
		btn_create.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\create.png"));
		btn_create.setForeground(Color.white);
		btn_create.setBounds(350,365,100, 40);
		f.add(btn_create);
	
		// Chức năng được thực thi khi nhấn vào nút Button Tạo
		btn_create.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client newClient = new Client( "",
						tf_fName.getText(), tf_lName.getText(), tf_fatherName.getText(), tf_motherName.getText(),
						tf_cnic.getText(), tf_dob.getText(), tf_phone.getText(), tf_email.getText(),
						tf_address.getText()
						);
				int res =  manager.createAccount(newClient, jcb_types.getSelectedItem().toString());
				if( res == 1 ) {
					String id_ = manager.getAccNum( tf_cnic.getText() );
					String msg = "Account created";
					if( id_.compareTo("") != 0 )
						msg += " with Account Number: "+id_;
					JOptionPane.showMessageDialog(f, msg);
					frame.remove(f);
					frame.repaint();
					frame.validate();
					ManagerMenuForm manageMenu = new ManagerMenuForm();
					manageMenu.openManagerMenu(frame, manager);
				}
				else if( res == 2 )
					JOptionPane.showMessageDialog(f, "Another account with this CNIC number exists");
				else
					JOptionPane.showMessageDialog(f, "Account creation failed");			
			}
		});
		
		// Nút trở lại menu 
		JButton btn_mm = new JButton("Main Menu");
		btn_mm.setBackground( new Color(0, 204, 153) );
		btn_mm.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));

		btn_mm.setForeground(Color.white);
		btn_mm.setBounds(50,400,130, 30);
		f.add(btn_mm);
		
		//Chức năng được thực thi khi nhấn vào nút menu chính.
		btn_mm.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				ManagerMenuForm manageMenu = new ManagerMenuForm();
				manageMenu.openManagerMenu(frame, manager);
			}
		});
		
		// nút đăng xuất
		JButton btn_sign_out = new JButton("Sign Out");
		btn_sign_out.setBackground( new Color(0, 204, 153) );
		btn_sign_out.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));

		btn_sign_out.setForeground(Color.white);
		btn_sign_out.setBounds(650,30,120, 30);
		
		f.add(btn_sign_out);
		
		// Chức năng được thực thi khi nhấn vào nút đăng xuất .
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
