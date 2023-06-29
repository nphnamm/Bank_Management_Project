package model;

import java.util.List;

import javax.swing.JOptionPane;

import controller.DB_Handler;

public class Client {
	private String client_id;
	private String f_name;
	private String l_name;
	private String father_name;
	private String mother_name;
	private String CNIC;
	private String DOB;
	private String phone;
	private String email;
	private String address;
	
	// Default Constructor
	public Client() {
		client_id = "";
		f_name = "";
		l_name = "";
		father_name = "";
		mother_name = "";
		CNIC = "";
		DOB = "";
		phone = "";
		email = "";
		address = "";
	}

	// Parameterized Constructor
	public Client(String f_name, String l_name, String father_name, String mother_name, String cnic, String dob, String phone, String email, String address) {
		client_id = "";
		this.f_name = f_name;
		this.l_name = l_name;
		this.father_name = father_name;
		this.mother_name = mother_name;
		this.CNIC = cnic;
		this.DOB = dob;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	// Parameterized Constructor
	public Client(String id, String pf_name, String pl_name, String pfather_name, String pmother_name, String pcnic, String pdob, String pphone, String pemail, String paddress) {
		this.client_id = id;
		this.f_name = pf_name;
		this.l_name = pl_name;
		this.father_name = pfather_name;
		this.mother_name = pmother_name;
		this.CNIC = pcnic;
		this.DOB = pdob;
		this.phone = pphone;
		this.email = pemail;
		this.address = paddress;
	}	
	
	void showClientInfo() {
		System.out.println("First Name: "+f_name);
		System.out.println("Last Name: "+l_name);
		System.out.println("Father Name: "+father_name);
		System.out.println("Mother Name: "+mother_name);
		System.out.println("CNIC Name: "+CNIC);
		System.out.println("DOB Name: "+DOB);
		System.out.println("Phone Name: "+phone);
		System.out.println("Email Name: "+email);
		System.out.println("Address Name: "+address);
	}
	
	public String getClientID() {
		return this.client_id;
	}
	
	public String getFName() {
		return f_name;
	}
	
	public String getLName() {
		return l_name;
	}
	
	public String getFatherName() {
		return father_name;
	}
	
	public String getMotherName() {
		return mother_name;
	}
	
	public String getCNIC() {
		return CNIC;
	}
	
	public String getDOB() {
		return DOB;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	//Hàm chuyển tiền 
	public int transferMoney( String recv_acc, int amount,String pin) {
		DB_Handler db = new DB_Handler();
		return db.TransferMoney(this, recv_acc, amount, pin);
	}
	
	// Hàm rút tiền không cần thẻ 
	public String do_cardless_cash_withdrawal(Bank_Account account, String amount, String pin)
	{
		
		DB_Handler db = new DB_Handler();
		
		if (db.is_card_active(Integer.parseInt(account.getCardNum())))
		{
			int curr_balance = Integer.parseInt(account.getBalance());
			int requested_amount = Integer.parseInt(amount);
			if (curr_balance >= requested_amount)
			{
				String temp_num = db.add_cardless_entry(Integer.parseInt(account.getAccountNum()), Integer.parseInt(account.getCardNum()), requested_amount, pin );
				
				
				if (temp_num.compareTo("") != 0) 
				{
					db.reduce_balance(curr_balance-requested_amount, Integer.parseInt(account.getAccountNum()));
					return temp_num;						//0 thực hiện rút thành công
				}
				else
					return "c";						//-3 thực hiện rút không thành công
			}
			else
			{
				return "b";						//-2 số dư không đủ
			}
		}
		else
		{
			return "a";							//-1 có nghĩa là thẻ đã bị khóa 
		}
	}
	
	public int change_password(String curr_pass, String new_pass_1, String new_pass_2, String acc_num)
	{
		DB_Handler db = new DB_Handler();
		int acc_no = Integer.parseInt(acc_num);
		int login_id = db.getLoginID(acc_no);
		if (login_id == -1)
		{
			return -1;			//không tìm thầy tài khoản 
		}
		else if ( !curr_pass.equals(db.get_password(login_id)))
		{
			return -2; //password hiện tại không đúng
		}
		else if (new_pass_1.equals(new_pass_2))
		{
			db.change_password(new_pass_1, login_id); // thay đổi thành công
			return 0;
		}
		else
		{
			return -3;
		}
	}
	// Danh sách lịch sử rút tiền
	public List<Transaction_History> getTransactions( String acc_num, String From, String To) {
		DB_Handler db = new DB_Handler();
		List<Transaction_History> list = db.getTransactions( acc_num, From, To);
		return list;
	}
	
	
	
	// end of class
}
