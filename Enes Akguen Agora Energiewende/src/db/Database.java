package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	// attributes
	private String url;
	private String username;
	private String password;
	private String driver;
	
	public Database() {
		this.url = "jdbc:mysql://localhost/agora_energiewende";
		this.username = "root";
		this.password = "";
		this.driver = "com.mysql.jdbc.Driver";
	}
	
	public void connect()
	{
		try {
			Class.forName(this.driver);
			Connection con;
			con = DriverManager.getConnection(this.url, this.username, this.password);
			con.close();
		} catch (Exception e) {
			System.out.print("Die Verbindung zur Datenbank konnte nicht hergestellt werden");
		}
	}

}
