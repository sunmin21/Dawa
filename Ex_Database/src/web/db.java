package web;


import java.sql.*;

public class db {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Statement stmt;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String dbURL="jdbc:oracle:thin:@dawa-database.czp0k5dvz0h1.us-east-2.rds.amazonaws.com:1521:ORCL";
		String id="admin";
		String pw="dawafood";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(dbURL,id,pw);
			System.out.println(conn.isClosed()?"접속종료":"접속중");

			stmt = conn.createStatement();
			//Insert();
			select();
			
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Insert() throws SQLException {
			System.out.println("Insert");
			String sql = "insert into dawa values('yeonkyu')";
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result + " 데이터 추가 성공함");
		
			stmt.close();		conn.close();
		
	}


private static void select() throws ClassNotFoundException, SQLException {
		System.out.println("select()");
		String sql = "select * from dawa";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String gname = rs.getString("NAME");
			
			System.out.println(gname);
		}
//		rs.close();
//		pstmt.close();
	}
}
