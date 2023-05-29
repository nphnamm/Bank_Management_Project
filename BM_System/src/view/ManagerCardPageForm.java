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

public class ManagerCardPageForm {
	//quản lý trang thẻ
	RemakeScreenForm gui = new RemakeScreenForm();
	void open_manage_card_page(JFrame frame, Manager manager)
	{
		JPanel f = new JPanel();
		f.setBackground(Color.white);
		gui.remakeScreen(frame, f);
		
		// Quản lý thẻ tín dụng/thẻ ghi nợ
		JLabel lcard = new JLabel("Manage Credit/Debit Card");
		lcard.setFont( lcard.getFont().deriveFont(30f) );
		lcard.setBounds(200,40,400, 40);
		f.add(lcard);
		
		//Tên Chủ Tài khoản
		JLabel l_acc_num = new JLabel("Enter Account Number");
		l_acc_num.setBounds(400, 90, 150, 90);
		f.add(l_acc_num);
		JTextField tf_acc_num = new JTextField();
		tf_acc_num.setBounds(400, 150 ,200, 25);
		f.add(tf_acc_num);
		
		//Kiểu tải khoản
		JLabel l_card_no = new JLabel("Enter Card Number");
		l_card_no.setBounds(400, 180, 150, 90);
		f.add(l_card_no);
		JTextField tf_card_no = new JTextField();
		tf_card_no.setBounds(400, 240 ,200, 25);
		f.add(tf_card_no);
		
		//Ngày mở tài khoản
		JLabel l_cnic = new JLabel("Enter CNIC of account holder");
		l_cnic.setBounds(400, 270, 200, 90);
		f.add(l_cnic);
		JTextField tf_cnic = new JTextField();
		tf_cnic.setBounds(400, 330 ,200, 25);
		f.add(tf_cnic);

		//-----------------------------------------------Buttons----------------------------------------------------		
		JButton btn_block_card = new JButton("Block Credit/Debit Card");
		btn_block_card.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\block.png"));

		btn_block_card.setBackground( new Color(0, 204, 153) );
		btn_block_card.setForeground(Color.white);
		btn_block_card.setBounds(100,120,200, 35);
		f.add(btn_block_card);
		
		JButton btn_unblock_card = new JButton("Unblock Credit/Debit Card");
		btn_unblock_card.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\unlock.png"));
		btn_unblock_card.setBackground( new Color(0, 204, 153) );
		btn_unblock_card.setForeground(Color.white);
		btn_unblock_card.setBounds(100,170,200,35);
		f.add(btn_unblock_card);
	
		// nút đăng xuất
		JButton btn_sign_out = new JButton("Sign Out");
		btn_sign_out.setBackground( new Color(0, 204, 153) );
		btn_sign_out.setForeground(Color.white);
		btn_sign_out.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));
		btn_sign_out.setBounds(650,30,120, 30);
		f.add(btn_sign_out);
		
		// chức năng được thực thi khi nhấp vào nút Đăng xuất
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
		
		// nút menu chính
		JButton btn_mm = new JButton("Main Menu");
		btn_mm.setBackground( new Color(0, 204, 153) );
		btn_mm.setForeground(Color.white);
		btn_mm.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));
		btn_mm.setBounds(50,400,130, 30);
		f.add(btn_mm);
		
		// chức năng được thực thi khi nhấn nút Menu chính
		btn_mm.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				ManagerMenuForm managerMenuForm = new ManagerMenuForm();
				managerMenuForm.openManagerMenu(frame, manager);
			}
		});
		
		// chức năng được thực thi khi bấm vào nút Chặn thẻ
		btn_block_card.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
			
				int block_status = manager.block_card(Integer.parseInt(tf_acc_num.getText()), tf_cnic.getText(), tf_card_no.getText());
				
				if (block_status == -1)
				{
					JOptionPane.showMessageDialog(f, "No account found with these details");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					open_manage_card_page(frame, manager);
				}
				else if (block_status == -2)
				{
					JOptionPane.showMessageDialog(f, "No card found with these details");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					open_manage_card_page(frame, manager);
				}
				else if (block_status == -3)
				{
					JOptionPane.showMessageDialog(f, "This card is already blocked");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					open_manage_card_page(frame, manager);
				}
				else
				{
					JOptionPane.showMessageDialog(f, "The selected card has been successfully blocked");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					ManagerMenuForm managerMenuForm = new ManagerMenuForm();
					managerMenuForm.openManagerMenu(frame, manager);
				}	
			}
		});
		
		
		// chức năng được thực thi khi nhấp vào nút Mở thẻ
		btn_unblock_card.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
				int unblock_status = manager.unblock_card(Integer.parseInt(tf_acc_num.getText()), tf_cnic.getText(), tf_card_no.getText());
				if (unblock_status == -1)
				{
					JOptionPane.showMessageDialog(f, "No account found with these details");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					open_manage_card_page(frame, manager);
				}
				else if (unblock_status == -2)
				{
					JOptionPane.showMessageDialog(f, "No card found with these details");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					open_manage_card_page(frame, manager);
				}
				else if (unblock_status == -3)
				{
					JOptionPane.showMessageDialog(f, "This card is already active and working");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					open_manage_card_page(frame, manager);
				}
				else
				{
					JOptionPane.showMessageDialog(f, "The selected card has been successfully unblocked");
					frame.remove(f);
					frame.repaint();
					frame.validate();
					ManagerMenuForm managerMenuForm = new ManagerMenuForm();
					managerMenuForm.openManagerMenu(frame, manager);
				}
			}
		});
	}
	
	
	
}
