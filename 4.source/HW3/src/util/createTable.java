package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class createTable {
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/hw3";
	public static final String DBUSER = "root";
	public static final String DBPASS = "1234";
	public static String sql2 = null;

		/**
		* @param args
		*/
		public static void main(String[] args) {

			//create("test4");
		}
		
		
		public static void create(String name) {
			Connection conn = null;
			try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw3", "root","1234");
			System.out.println("connected to the database");

			Statement stmt = conn.createStatement();
			System.out.println("Inserting records");

			
			/* 從註冊時存的檔案抓取帳號*///-->從註冊抓(帳號不可重複)or如果重複就跳過
			/*Object o=cal.readFile("newtable.txt");
			Member m=(Member) o;
			System.out.println(m.getName());	*/
			
			
			stmt.executeUpdate("CREATE TABLE "+name+ 
			"(id INT,name VARCHAR(50), date VARCHAR(50),inhr VARCHAR(50),inmin VARCHAR(50),"
			+ "outhr VARCHAR(50),outmin VARCHAR(50))");

			/*String qry1 = "INSERT INTO sells VALUES ('win','wine',123)";
			stmt.executeUpdate(qry1);
			System.out.println("資料已加入");*/

			String qry2 = "SELECT * FROM test2";

			ResultSet rs = stmt.executeQuery(qry2);
			ResultSetMetaData rm = rs.getMetaData();

			int cnum = rm.getColumnCount();

			while(rs.next())
			{
			for(int i=1; i<=cnum; i++)
			{
			System.out.print(rm.getColumnName(i)+":"+rs.getObject(i)+" ");
			}
			System.out.println("");
			}
			rs.close();
			stmt.close();
			conn.close();
			System.out.println("Disconnected from database");


			} catch (InstantiationException e) {
			e.printStackTrace();
			} catch (IllegalAccessException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}catch(Exception e)
			{
			e.printStackTrace();
			}
		}
}
