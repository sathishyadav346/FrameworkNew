package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataDatabase 
 {public static void main(String[] args) throws SQLException {
	//Step1:create instance for Driver
	Driver dbDriver =new Driver();
	//Step 2: Register driver to JDBC
	DriverManager.registerDriver(dbDriver);
	//Step 3: Establish database connnection
	Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/");
	//Step 4: Create Statement
	Statement statement=connection.createStatement();
	//Step 5: Execute Update Query
	int result=statement.executeUpdate("insert into students(id,name,address) values(102,'Bcd','Chennai');");
	System.out.println(result);
	//Step 6:Close database
	connection.close();

	

}
}
