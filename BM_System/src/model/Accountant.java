package model;

import java.util.List;
import controller.DB_Handler;

public class Accountant {

	public String name;
	
	public Accountant( ) {
		this.name = "";
	}
	
	public Accountant( String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	// Hàm tim kiếm tài khoản
	public Bank_Account searchAccount1(String accountNum, String CNIC) {
		DB_Handler db = new DB_Handler();
		Bank_Account account = db.searchAccount1(accountNum, CNIC);
		db = null;
		System.out.println("Account infoACC: "+account.getType() );
		return account;
	}
	
	// Hàm tìm kiếm tài khoản khách hàng
	public Client searchClient1(String accountNum, String CNIC) {
		DB_Handler db = new DB_Handler();
		Client client = db.searchClient1( accountNum, CNIC );
		db = null;
		return client;
	}
	
	// Danh sách lịch sử giao dịch 
	public List<Transaction_History> getTransactions( String acc_num, String From, String To) {
		DB_Handler db = new DB_Handler();
		List<Transaction_History> list = db.getTransactions( acc_num, From, To);
		return list;
	}
	
	
}
