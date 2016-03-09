package actualItems;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class DatabaseManager {
	private static String database_name;

	public DatabaseManager(String database) {
		database_name = database;
	}

	public static String getCurrentDatabase() {
		return database_name;
	}

	public void setCurrentDatabase(String newDatabase) {
		database_name = newDatabase;
	}
	
	public static Connection connectToDatabase() {
		Connection connection = null;
		// Establish connection to the existing database
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + getCurrentDatabase());
			connection.setAutoCommit(false);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// e.printStackTrace();
		}
		return connection;
	}
	public void createEqupimentTable() { 
		Connection DBconnection = connectToDatabase();
		try {
			Statement stmt = DBconnection.createStatement();
			String sql = "CREATE TABLE equipment(" 
			+ "'section'	TEXT		NOT NULL," 
			+ "'box'		INTEGER		NOT NULL,"	
			+ "'name'		TEXT		NOT NULL,"
			+ "'status'		INTEGER		NOT NULL,"
			+ "'repair'		INTEGER		NOT NULL,"
			+ "'type' 		INTEGER		NOT NULL,"
			+"PRIMARY KEY(name))";
			stmt.executeUpdate(sql);
			DBconnection.commit();
			stmt.close();
			DBconnection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getClass().getName() + ":"+ e.getMessage());
			e.printStackTrace();
		}
		
	}
public int addEquipment(Equipment Eq) { 
	
	
	return 0;
	
}
	
	
}
