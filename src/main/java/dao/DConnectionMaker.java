package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		// useUnicode=true&characterEncoding=utf8 를 써주어야 한다.
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/springbook?useUnicode=true&characterEncoding=utf8", "root", "root");
		return c;
	}
	

}
