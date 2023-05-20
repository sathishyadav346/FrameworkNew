package hardcodedTests;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws SQLException
	{
		//step 1: Create instance for Driver
		Driver dbDriver = new Driver();
		
		//step 2: Register driver to JDBC
		DriverManager.registerDriver(dbDriver);
		
		//step 3: Establish database connection
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");
		
		//step 4 : Create statement
		Statement statement = connection.createStatement();
		
		//step 5: Execute Query to read data from database
		ResultSet result = statement.executeQuery("select * from students;");
		
		while(result.next()){
			System.out.println(result.getInt("id")+"\t"+result.getString("name")+"\t"+result.getString("address"));
			
		}
		//step6: Close database connection
		
		connection.close();

	}

}

