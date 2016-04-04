package actualItems;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class DatabaseManager {
	private static String database_name;

	public DatabaseManager(String database) {
		database_name = database; //equipment
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
			+ "'id'  		INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "'section'	TEXT		NOT NULL," 
			+ "'box'		INTEGER		NOT NULL,"	
			+ "'name'		TEXT		NOT NULL,"
			+ "'status'		INTEGER		NOT NULL,"
			+ "'repair'		INTEGER		NOT NULL,"
			+ "'type' 		INTEGER		NOT NULL,"
			+")";
			stmt.executeUpdate(sql);
			DBconnection.commit();
			stmt.close();
			DBconnection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ":"+ e.getMessage());
			e.printStackTrace();
		}
		
	}
public int addEquipment(Equipment eq) { // 1 if success, -1 if fail
	Connection DBconnection = connectToDatabase();
	try{ 
		Statement stmt = DBconnection.createStatement();
		ResultSet results = stmt.executeQuery("SELECT count(*) FROM equipment WHERE name = "
				+ "'" + eq.getName() + "';");
		if(results.getInt(1)!= 0) { 
			results.close();
			stmt.close();
			DBconnection.close();
			return -1;
		}
		
		else { 
			String sql = "INSERT INTO equipment (section, box, name, status, repair, type)"
					+ "VALUES (" + "'" + eq.getSection() + "', " + "'" + eq.getBox() +"', " + "'" + eq.getName() +"', "
					+ "'" + eq.getStatus() +"'," + "'" + eq.getRepair() + "'," + "'" + eq.getType() + "');";
			stmt.executeUpdate(sql);
			DBconnection.commit();
			stmt.close();
			DBconnection.close();
			return 1;
		}
	}
	catch(Exception e){ 
		System.err.println(e.getClass().getName() + ": " + e.getMessage());
		e.printStackTrace();
		return -1;
	}
}
	
public int deleteEquipment(Equipment doomed){  // 1 if success, -1 if fail
	Connection DBconnection = connectToDatabase();
	try{
		Statement stmt = DBconnection.createStatement();
		String sql = "DELETE FROM equipment WHERE name = " +"'" + doomed.getName() + "';";
		stmt.executeUpdate(sql);
		DBconnection.commit();
		stmt.close();
		DBconnection.close();
		return 1;
	}
	catch(SQLException e) {
		System.err.println(e.getClass().getName() + ": " + e.getMessage());
		e.printStackTrace();
		return -1;
	}
}

public Equipment retrieveEquipment(String name) { 
		Connection DBconnection = connectToDatabase();
		Statement stmt;
		try {
			stmt = DBconnection.createStatement();
		
		String sql = "SELECT * FROM equipment WHERE name = "+"'"+ name+"';";
		ResultSet equipmentInfoSet = stmt.executeQuery(sql);
		if(equipmentInfoSet.isClosed()){ 
			equipmentInfoSet.close();
			stmt.close();
			DBconnection.close();
			return null;
		}
			
			String section = equipmentInfoSet.getString("section");
			int box = equipmentInfoSet.getInt("box");
			int status = equipmentInfoSet.getInt("status");
			int repair = equipmentInfoSet.getInt("repair");
			int type = equipmentInfoSet.getInt("type");
			int id = equipmentInfoSet.getInt("id");
			Equipment equip = new Equipment(id,box,status,repair,type,section,name);
			equipmentInfoSet.close();
			stmt.close();
			DBconnection.close();
			
			return equip; 
			
		
		}
		catch (Exception e) {
			// Auto-generated catch block
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
			try { 
				DBconnection.close();
			}
			catch(Exception e1) { 
				e1.printStackTrace();
				
			}
			return null;
		}
		
	}

public List<String> retrieveEquipmentList(String database) { //MAY BE AN ISSUE 
	List<String> eqNameList = new ArrayList<String>();
	// Connect to the database
	Connection DBconnection = connectToDatabase();
	try {
		// Initialize a statement to execute
		Statement stmt = DBconnection.createStatement();
		// Construct the SQL select statement
		String sql = "SELECT name, box,section from equipment;";
		// Execute SQL statement and retrieve result set
		ResultSet eqNameSet = stmt.executeQuery(sql);
		// Construct list from result set
		while (eqNameSet.next()) {
			String eqName = eqNameSet.getString("name");
			int eqBox = eqNameSet.getInt("box");
			String eqSection = eqNameSet.getString("section");
			eqNameList.add(eqName + "|" + eqBox + "|" + eqSection);
		}
		// Disconnect and close database
		eqNameSet.close();
		stmt.close();
		DBconnection.close();
	}
	catch (SQLException e) {
		System.err.println(e.getClass().getName() + ": " + e.getMessage());
		e.printStackTrace();
	}

	return eqNameList;
}






public void modifyStringEquipment(Equipment eq, String field, String val ){ 
	Connection DBconnection = connectToDatabase();
	try {
		Statement stmt = DBconnection.createStatement();
		String sql = "UPDATE equipment SET " + field + " = '" + val + "' "
				+"WHERE name = '" + eq.getName() + "';";
		stmt.executeQuery(sql);
		DBconnection.commit();
		stmt.close();
		DBconnection.close();
	} catch (Exception e) {
		//  Auto-generated catch block
		System.err.println(e.getClass().getName() + ": " + e.getMessage());
		e.printStackTrace();
	}

	
}

public void modifyIntEquipment(Equipment eq, String field, int val){
	Connection DBconnection = connectToDatabase();
	try {
		Statement stmt = DBconnection.createStatement();
		String sql = "UPDATE equipment SET " + field + " = " + String.valueOf(val) + " "
				+ "WHERE name = '" +eq.getName() + "';";
		stmt.executeQuery(sql);
		DBconnection.commit();
		stmt.close();
		DBconnection.close();
	} catch (Exception e) {
		//  Auto-generated catch block
		System.err.println(e.getClass().getName() + ": " + e.getMessage());
		e.printStackTrace();
	}
}
}
