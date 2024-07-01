package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CheckOutDao;
import dao.DbConnection;
import model.CheckOut;

public class CheckOutDaoImpl implements CheckOutDao{

	public static void main(String[] args) {
		//測試用區域

		System.out.println(new CheckOutDaoImpl().queryAll2());
		
		/*CheckOut co=new CheckOut("2024/06/21","18","30");
		new CheckOutDaoImpl().addCheckOut(co); -->OK */
	}
	
	@Override
	public void addCheckOut(String date, String hr, String min) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into checkout(date,hr,min) values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,date );
			ps.setString(2, hr);
			ps.setString(3, min);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCheckOut(CheckOut co) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into checkout(date,hr,min) values(?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, co.getDate());
			ps.setString(2, co.getHr());
			ps.setString(3, co.getMin());

			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public String queryAll2() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkout";
		String show="";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				show=show+
						rs.getInt("id")+
						"\t日期:"+rs.getString("date")+"\t"+
						rs.getString("hr")+"點 "
						+rs.getString("min")+"分\n";
			}
		}catch (SQLException e) {
			e.printStackTrace(); }
		return show; 
	}

	@Override
	public CheckOut queryCheckOut(String hr, String min) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkout where hr=? and min=?";
		CheckOut co=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, hr);
			ps.setString(2, min);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				co=new CheckOut();
				co.setId(rs.getInt("id"));
				co.setName(rs.getString("date"));
				co.setHr(rs.getString("hr"));
				co.setMin(rs.getString("min"));
			}
			
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return co;
	}

	@Override
	public void updateCheckOut(CheckOut co) {
		Connection conn=DbConnection.getDb();
		String SQL="update hw3.checkout set name=?,hr=?,min=? where id=?"; 
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, co.getDate());
			ps.setString(2, co.getHr());
			ps.setString(3, co.getMin());
			ps.setInt(4, co.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException ee) {
			ee.printStackTrace(); 
			}
	}

	@Override
	public void deleteCheckOut(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from checkout where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
