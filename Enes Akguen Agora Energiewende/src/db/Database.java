package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.AbstractData;

public class Database {
	
	// attributes
	private String url;
	private String username;
	private String password;
	private String driver;
	private Connection con;
	
	public Database() {
		this.url = "jdbc:mysql://localhost/agora_energiewende";
		this.username = "root";
		this.password = "";
		this.driver = "com.mysql.jdbc.Driver";
		this.connect();
	}
	
	protected void connect()
	{
		try {
			Class.forName(this.driver);
			this.con = DriverManager.getConnection(this.url, this.username, this.password);
		} catch (Exception e) {
			System.out.print("Die Verbindung zur Datenbank konnte nicht hergestellt werden");
		}
	}
	
	public void persistEnergySource(AbstractData abstractData) throws ClassNotFoundException
	{
		this.connect();
		try {			
			Statement statement = this.con.createStatement();
			PreparedStatement selectStatement = this.con.prepareStatement("SELECT * FROM `t_energy_source` WHERE date = ? AND name = ?");
			selectStatement.setString(1, abstractData.getDate());
			selectStatement.setString(2, abstractData.getName());
			ResultSet resultSet = selectStatement.executeQuery();
			
			// execute SQL-Query
			if (!resultSet.isBeforeFirst() ) {
			    // Insert
				PreparedStatement insertStatement = this.con.prepareStatement("INSERT INTO `t_energy_source` (`date`, `name`, `energy`) VALUES (?, ?, ?)");
				insertStatement.setString(1, abstractData.getDate());
				insertStatement.setString(2, abstractData.getName());
				insertStatement.setString(3, abstractData.getEnergy());
				insertStatement.executeUpdate();
			} else {
				// Update
				PreparedStatement updateStatement = this.con.prepareStatement("UPDATE `t_energy_source` SET date=?,name=?,energy=? WHERE date=? AND name = ?");
				updateStatement.setString(1, abstractData.getDate());
				updateStatement.setString(2, abstractData.getName());
				updateStatement.setString(3, abstractData.getEnergy());
				updateStatement.setString(4, abstractData.getDate());
				updateStatement.setString(5, abstractData.getName());
				updateStatement.executeUpdate();
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void persistEmissionFactor(AbstractData abstractData) throws ClassNotFoundException
	{
		if (abstractData.getDate() != null) {
			if (abstractData.getEmissionFactor() != "")
			{
				try {			
					this.connect();
					Statement statement = this.con.createStatement();
					PreparedStatement selectStatement = this.con.prepareStatement("SELECT * FROM `t_emission_factor` WHERE date = ?");
					selectStatement.setString(1, abstractData.getDate());
					ResultSet resultSet = selectStatement.executeQuery();
					
					// execute SQL-Query
					if (!resultSet.isBeforeFirst() ) {
					    // Insert
						PreparedStatement insertStatement = this.con.prepareStatement("INSERT INTO `t_emission_factor` (`date`, `emission_factor`) VALUES (?, ?)");
						insertStatement.setString(1, abstractData.getDate());
						insertStatement.setString(2, abstractData.getEmissionFactor());
						insertStatement.executeUpdate();
					} else {
						// Update
						PreparedStatement updateStatement = this.con.prepareStatement("UPDATE `t_emission_factor` SET date=?, emission_factor=? WHERE date=?");
						updateStatement.setString(1, abstractData.getDate());
						updateStatement.setString(2, abstractData.getEmissionFactor());
						updateStatement.setString(3, abstractData.getDate());
						updateStatement.executeUpdate();
					}
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			if (abstractData.getAbsoluteEmissions() != ""){
				try {			
					this.connect();
					Statement statement = this.con.createStatement();
					PreparedStatement selectStatement = this.con.prepareStatement("SELECT * FROM `t_emission_factor` WHERE date = ?");
					selectStatement.setString(1, abstractData.getDate());
					ResultSet resultSet = selectStatement.executeQuery();
					
					// execute SQL-Query
					if (!resultSet.isBeforeFirst() ) {
					    // Insert
						PreparedStatement insertStatement = this.con.prepareStatement("INSERT INTO `t_emission_factor` (`date`, `absolute_emission`) VALUES ( ?, ?)");
						insertStatement.setString(1, abstractData.getDate());
						insertStatement.setString(2, abstractData.getAbsoluteEmissions());
						insertStatement.executeUpdate();
					} else {
						// Update
						PreparedStatement updateStatement = this.con.prepareStatement("UPDATE `t_emission_factor` SET date=?, absolute_emission=? WHERE date=?");
						updateStatement.setString(1, abstractData.getDate());
						updateStatement.setString(2, abstractData.getAbsoluteEmissions());
						updateStatement.setString(3, abstractData.getDate());
						updateStatement.executeUpdate();
					}
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
