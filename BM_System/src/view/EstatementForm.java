package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import controller.DB_Handler;
import model.Accountant;
import model.Bank_Account;
import model.Client;
import model.Login_Account;
import model.Transaction_History;

public class EstatementForm {
	//hiển thị sao kê điện tử
	void openEstatement(JFrame frame, Accountant accountant, Client client, Bank_Account account) {
		JPanel f = new JPanel();
		f.setBackground(Color.white);
		
		// sao kê điện tử
		JLabel lEStatement = new JLabel("E-Statement");
		lEStatement.setFont( lEStatement.getFont().deriveFont(30f) );
		lEStatement.setBounds(50,30,250, 40);
		f.add(lEStatement);
		
		// tên
		JLabel lName = new JLabel( "Client Name: " + client.getFName() + " " + client.getLName() );
		lName.setBounds(50,70,150, 40);
		f.add(lName);
			
		// CNIC
		JLabel lCnic = new JLabel( "CNIC: " + client.getCNIC() );
		lCnic.setBounds(50,90,150, 40);
		f.add(lCnic);
		
		// số tài khoản
		JLabel lAccNum = new JLabel( "Account Number: " + account.getAccountNum() );
		lAccNum.setBounds(450,70,150, 40);
		f.add(lAccNum);
		
		// tên
		JLabel lType = new JLabel( "Account Type: " + account.getType() );
		lType.setBounds(450,90,150, 40);
		f.add(lType);
		
		//từ ngày
		JLabel lFrom = new JLabel("From   ( DD : MM : YY )");
		lFrom.setBounds(50,120,150, 40);
		f.add(lFrom);
		
		// đến ngày 
		JLabel lTo = new JLabel("To   ( DD : MM : YY )");
		lTo.setBounds(450,120,150, 40);
		f.add(lTo);

		SpinnerModel fromDayValues =  new SpinnerNumberModel(21, 1, 31, 1);  
	    JSpinner fromDaySpinner = new JSpinner(fromDayValues);   
	    fromDaySpinner.setBounds(50,150,40,25);    
	    f.add(fromDaySpinner); 
	    SpinnerModel fromMonthValues =  new SpinnerNumberModel(12, 1, 12, 1);  
	    JSpinner fromMonthSpinner = new JSpinner(fromMonthValues);   
	    fromMonthSpinner.setBounds(100,150,40,25);    
	    f.add(fromMonthSpinner); 
	    SpinnerModel fromYearValues =  new SpinnerNumberModel(2020, 2018, 2021, 1);  
	    JSpinner fromYearSpinner = new JSpinner(fromYearValues);   
	    fromYearSpinner.setBounds(150,150,55,25);    
	    f.add(fromYearSpinner); 
	    
 		SpinnerModel toDayValues =  new SpinnerNumberModel(30, 1, 31, 1);  
 	    JSpinner toDaySpinner = new JSpinner(toDayValues);   
 	    toDaySpinner.setBounds(450,150,40,25);    
 	    f.add(toDaySpinner); 
 	    SpinnerModel toMonthValues =  new SpinnerNumberModel(12, 1, 12, 1);  
 	    JSpinner toMonthSpinner = new JSpinner( toMonthValues);   
 	    toMonthSpinner.setBounds(500,150,40,25);    
 	    f.add(toMonthSpinner); 
 	    SpinnerModel toYearValues =  new SpinnerNumberModel(2020, 2018, 2050, 1);  
 	    JSpinner toYearSpinner = new JSpinner(toYearValues);   
 	    toYearSpinner.setBounds(550,150,55,25);    
 	    f.add(toYearSpinner); 
 	    
 		JButton btnEStatement = new JButton("Get E-Statement");
		btnEStatement.setBackground( new Color(0, 204, 153) );
		btnEStatement.setForeground(Color.white);
		btnEStatement.setBounds(50,200,150, 30);
		btnEStatement.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\get-statement.png"));

		f.add(btnEStatement);
 	    
		JButton btnDownload = new JButton("Download");
		btnDownload.setBackground( new Color(0, 204, 153) );
		btnDownload.setForeground(Color.white);
		btnDownload.setBounds(450,200,100, 30);
		btnDownload.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\download.png"));

		f.add(btnDownload);
		
		
 	
		btnDownload.setEnabled(false);
		
		// bảng ghi chép lịch sử giao dịch
		DefaultTableModel tableModel = new DefaultTableModel();
		JTable table=new JTable(tableModel);   
		tableModel.addColumn("Serial No");
		tableModel.addColumn("Amount");
		tableModel.addColumn("Type");
		tableModel.addColumn("Date");
		tableModel.addColumn("Time");
		tableModel.addColumn("Account Number");
		tableModel.addColumn("Reciever Account Number");
		tableModel.addColumn("Cheque No");
		table.setEnabled(false);
		JScrollPane sp=new JScrollPane(table);
		sp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		sp.setBounds(50,250,700,150);  
		f.add(sp);
		sp.setVisible(false);
		
		// chức năng được thực thi khi nhấn vào nút báo cáo điện tử
		btnEStatement.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0);
				
				String From = String.valueOf(fromYearSpinner.getValue()) +"-"+ String.valueOf(fromMonthSpinner.getValue()) +"-"+ String.valueOf(fromDaySpinner.getValue());
				String To = String.valueOf(toYearSpinner.getValue()) +"-"+ String.valueOf(toMonthSpinner.getValue()) +"-"+ String.valueOf(toDaySpinner.getValue());
			
				List<Transaction_History> list = accountant.getTransactions( account.getAccountNum(), From, To);
				if( list.size() > 0 ) {
					for( Transaction_History th: list) {
						tableModel.addRow(new Object[] { th.getSerialNo(), th.getAmount(), th.getType(), th.getDate(), th.getTime(), th.getAccountNumber(), th.getRecvAccNum(), th.getChequeNum() });
					}	
					tableModel.fireTableDataChanged();
					sp.setVisible(true);
					//btnEStatement.setEnabled(false);
					btnDownload.setEnabled(true);
				}
				else {
					btnDownload.setEnabled(false);
				}
			}
		});

		// chức năng được thực thi khi nhấn vào nút download
		btnDownload.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String From = String.valueOf(fromYearSpinner.getValue()) +"-"+ String.valueOf(fromMonthSpinner.getValue()) +"-"+ String.valueOf(fromDaySpinner.getValue());
				String To = String.valueOf(toYearSpinner.getValue()) +"-"+ String.valueOf(toMonthSpinner.getValue()) +"-"+ String.valueOf(toDaySpinner.getValue());
			
				DB_Handler db = new DB_Handler();
				int r = db.createPDF(client, account, From, To);
				if( r == 1 ) 
					JOptionPane.showMessageDialog(f, "E-Statement is downloaded");
				else
					JOptionPane.showMessageDialog(f, "Error in downloading the e-statement");
				frame.remove(f);
				frame.repaint();
				frame.validate();
				AccountMenuForm accountMenuForm = new AccountMenuForm();
				accountMenuForm.openAccountantMenu(frame, accountant);
			}
		});
		
		// nút menu chính
		JButton btn_mm = new JButton("Main Menu");
		btn_mm.setBackground( new Color(0, 204, 153) );
		btn_mm.setForeground(Color.white);
		btn_mm.setBounds(50,400,120, 30);
		btn_mm.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));

		f.add(btn_mm);
		
		// chức năng được thực thi khi nhấn vào nút menu chính.
		btn_mm.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(f);
				frame.repaint();
				frame.validate();
				AccountMenuForm accountMenuForm = new AccountMenuForm();
				accountMenuForm.openAccountantMenu(frame, accountant);
			}
		});
				
		// nút đăng xuất .
		JButton btn_sign_out = new JButton("Sign Out");
		btn_sign_out.setBackground( new Color(0, 204, 153) );
		btn_sign_out.setForeground(Color.white);
		btn_sign_out.setBounds(650,30,100, 30);
		btn_sign_out.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));

		f.add(btn_sign_out);
		
		// chức năng được thực thi khi nhấn vào nútđăng xuất 
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
		
		//  hiển thị bảng điều khiển mới trên khung
		f.setLayout(null); 
		frame.setContentPane(f);
		frame.setVisible(true);		
	}

	
	
	
}
