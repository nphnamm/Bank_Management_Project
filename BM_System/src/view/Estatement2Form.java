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
import model.Bank_Account;
import model.Client;
import model.Login_Account;
import model.Transaction_History;

public class Estatement2Form {
	//	xem báo cáo của khách hang
		void openEstatement2(JFrame frame, Client client, Bank_Account account) {
			JPanel f = new JPanel();
			f.setBackground(Color.white);
			
			// E-Statement Label
			JLabel lEStatement = new JLabel("E-Statement");
			lEStatement.setFont( lEStatement.getFont().deriveFont(30f) );
			lEStatement.setBounds(50,50,250, 40);
			f.add(lEStatement);
			
			// từ ngày ...đến  ngày 
			JLabel lFrom = new JLabel("From   ( DD : MM : YY )");
			lFrom.setBounds(50,100,150, 40);
			f.add(lFrom);
			
			// đén ngày
			JLabel lTo = new JLabel("To   ( DD : MM : YY )");
			lTo.setBounds(450,100,150, 40);
			f.add(lTo);
			
			// ngày tháng năm từ ngày 
			SpinnerModel fromDayValues =  new SpinnerNumberModel(21, 1, 31, 1);  
		    JSpinner fromDaySpinner = new JSpinner(fromDayValues);   
		    fromDaySpinner.setBounds(50,130,40,25);    
		    f.add(fromDaySpinner); 
		    SpinnerModel fromMonthValues =  new SpinnerNumberModel(12, 1, 12, 1);  
		    JSpinner fromMonthSpinner = new JSpinner(fromMonthValues);   
		    fromMonthSpinner.setBounds(100,130,40,25);    
		    f.add(fromMonthSpinner); 
		    SpinnerModel fromYearValues =  new SpinnerNumberModel(2020, 2018, 2021, 1);  
		    JSpinner fromYearSpinner = new JSpinner(fromYearValues);   
		    fromYearSpinner.setBounds(150,130,55,25);    
		    f.add(fromYearSpinner); 
		    
		    // Ngày, tháng và năm cho từ ngày
	 		SpinnerModel toDayValues =  new SpinnerNumberModel(30, 1, 31, 1);  
	 	    JSpinner toDaySpinner = new JSpinner(toDayValues);   
	 	    toDaySpinner.setBounds(450,130,40,25);    
	 	    f.add(toDaySpinner); 
	 	    SpinnerModel toMonthValues =  new SpinnerNumberModel(12, 1, 12, 1);  
	 	    JSpinner toMonthSpinner = new JSpinner( toMonthValues);   
	 	    toMonthSpinner.setBounds(500,130,40,25);    
	 	    f.add(toMonthSpinner); 
	 	    SpinnerModel toYearValues =  new SpinnerNumberModel(2020, 2018, 2050, 1);  
	 	    JSpinner toYearSpinner = new JSpinner(toYearValues);   
	 	    toYearSpinner.setBounds(550,130,55,25);    
	 	    f.add(toYearSpinner); 
	 	    
	 	    // nút báo cáo điện tử 
	 		JButton btnEStatement = new JButton("Get E-Statement");
			btnEStatement.setBackground( new Color(0, 204, 153) );
			btnEStatement.setForeground(Color.white);
			btnEStatement.setBounds(50,180,150, 30);
			btnEStatement.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\get-statement.png"));

			f.add(btnEStatement);
	 	    
			// nút dowload
			JButton btnDownload = new JButton("Download");
			btnDownload.setBackground( new Color(0, 204, 153) );
			btnDownload.setForeground(Color.white);
			btnDownload.setBounds(450,180,100, 30);
			btnDownload.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\download.png"));

			f.add(btnDownload);
			btnDownload.setEnabled(false);
			   
			// tạo bảng dữ liệu từ giao dịch
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
			sp.setBounds(50,230,700,150);  
			f.add(sp);
			sp.setVisible(true);
			
			//chức năng được thực thi khi nhấn vào nút báo cáo điện tử
			btnEStatement.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tableModel.setRowCount(0);
					
					String From = String.valueOf(fromYearSpinner.getValue()) +"-"+ String.valueOf(fromMonthSpinner.getValue()) +"-"+ String.valueOf(fromDaySpinner.getValue());
					String To = String.valueOf(toYearSpinner.getValue()) +"-"+ String.valueOf(toMonthSpinner.getValue()) +"-"+ String.valueOf(toDaySpinner.getValue());
				
					List<Transaction_History> list = client.getTransactions( account.getAccountNum(), From, To);
					if( list.size() > 0 ) {
						for( Transaction_History th: list) {
							tableModel.addRow(new Object[] { th.getSerialNo(), th.getAmount(), th.getType(), th.getDate(), th.getTime(), th.getAccountNumber(), th.getRecvAccNum(), th.getChequeNum() });
						}	
						tableModel.fireTableDataChanged();
						sp.setVisible(true);
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
				}
			});
			
			// nút menu chính
			JButton btnMM = new JButton("Main Menu");
			btnMM.setBackground( new Color(0, 204, 153) );
			btnMM.setForeground(Color.white);
			btnMM.setBounds(50,400,120, 30);
			btnMM.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));

			f.add(btnMM);
			
			// chức năng được thực thi khi nhấn vào nút menu chính.
			btnMM.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.remove(f);
					frame.repaint();
					frame.validate();
					ClientMenuForm clientMenuForm = new ClientMenuForm();
					clientMenuForm.openClientMenu(frame, client, account);
				}
			});
			
			// nút đăng xuất .
			JButton btn_sign_out = new JButton("Sign Out");
			btn_sign_out.setBackground( new Color(0, 204, 153) );
			btn_sign_out.setForeground(Color.white);
			btn_sign_out.setBounds(650,30,130, 30);
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
