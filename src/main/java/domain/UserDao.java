package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ConnectionMaker;
import dao.DConnectionMaker;
import dao.SimpleConnectionMaker;

public class UserDao {
	
	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	public void add(User user) throws ClassNotFoundException, SQLException{

//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root", "root");
		
		// 관심사의 분리
//		Connection c = getConnection();
		
		// 클래스의 분리
		Connection c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root", "root");
		
		// 관심사의 분리
//		Connection c = getConnection();
		
		// 클래스의 분리
		Connection c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
//	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
	
//	{
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root", "root");
//		return c;
//	}
	
	
//	public class NUserDao extends UserDao{
//		public Connection getConnection() throws ClassNotFoundException, SQLException {
//			
//			return null;
//		}
//	}
//	
//	public class DUserDao extends UserDao{
//
//		@Override
//		public Connection getConnection() throws ClassNotFoundException, SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//	}
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException{
//		
//		UserDao dao = new UserDao();
//		
//		User user = new User();
//		user.setId("asd");
//		user.setName("asd");
//		user.setPassword("123456");
//		
//		dao.add(user);
//		
//		System.out.println(user.getId() + " 등록 성공");
//		
//		User user2 = dao.get(user.getId());
//		
//		System.out.println(user2.getName());
//		
//		System.out.println(user2.getPassword());
//		
//		System.out.println(user2.getId() + " 조회 성공");
//	}
}
