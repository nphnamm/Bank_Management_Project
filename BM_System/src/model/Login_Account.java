package model;
import controller.DB_Handler;

public class Login_Account {
	private String login_id;
	private String username;
	private String password;
	private String type;

	public Login_Account() {
		this.login_id = "";
		this.username = "";
		this.password = "";
		this.type = "";
	}
	
	public Login_Account(String login_id, String username, String password, String type) {
		this.login_id = login_id;
		this.username = username;
		this.password = password;
		this.type = type;
	}	
	
	public String getLoginId() {
		return this.login_id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	
	//hàm so sánh kiểu login_account
	public String getType() {
		String type_ = "";
		if( type.compareTo("C") == 0 )
			type_ = "Client";
		else if( type.compareTo("M") == 0 )
			type_ = "Manager";
		else if( type.compareTo("A") == 0 ) 
			type_ = "Accountant";
		return type_;
	}
	
	//kiểm tra số tài khoản và căn cước công dân
	public int verify_account(String acc_num, String cnic)
	{
		DB_Handler db = new DB_Handler();
		int temp_client_id = db.get_client_id(Integer.parseInt( acc_num ));
		System.out.println("The client id is: " + temp_client_id);
		
		if (temp_client_id == -1)
		{
			return -1;
			
		}
		else if (db.login_exists(temp_client_id) == false)
		{
			return -2;
		}
		else if (db.verify_cnic(temp_client_id, cnic))
		{
			return -3;
		}
		return 0;
	}
	//Đăng ký tài khoản login_account
	public int signup(String username, String pass_1, String pass_2, String acc_num,String pin)
	{
		DB_Handler db = new DB_Handler();
		int client_id = db.get_client_id(Integer.parseInt(acc_num));
		type = db.get_type_bank_acc(acc_num);
		String tem_type = "Saving";
		if(tem_type.equals(type)) {
			return -3;
			
			
			
		}
		if (pass_1.equals(pass_2) == false)
		{
			return -1;
		}
		else
		{
			
			System.out.println("Two passwords have successfully matched");
			int temp_login = db.create_login(username, pass_1,pin);
			int temp_card_num = db.create_card_num(pin,client_id);
			if (temp_login == -1 && temp_card_num ==-1)
			{
				return -2;
			}
			
			
			db.set_login_id(temp_login, client_id);
			db.set_card_num(temp_card_num, client_id);
			return 0;
		}
	}
	
	public String getName() {
		DB_Handler db = new DB_Handler();
		return db.getName( this.login_id );
	}
	
	// end of class
}
