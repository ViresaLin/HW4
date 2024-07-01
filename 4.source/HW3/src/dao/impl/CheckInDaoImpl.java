package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CheckInDao;
import dao.DbConnection;
import model.CheckIn;
import model.Member;
import util.cal;

public class CheckInDaoImpl implements CheckInDao{

	
	public static void main(String[] args) {
		//測試用區域
		
		//System.out.println(new CheckInDaoImpl().queryCheckIn("07", "00"));
		
		System.out.println(new CheckInDaoImpl().queryAll2());
		
		/*CheckIn ci=new CheckIn("2024/06/21","8","30");
		new CheckInDaoImpl().addCheckIn(ci); -->OK */
	}
	
	
	@Override
	public void addCheckIn(String date, String hr, String min) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into checkin(date,hr,min) values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, date );
			ps.setString(2, hr);
			ps.setString(3, min);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCheckIn(CheckIn ci) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into checkin(date,hr,min) values(?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, ci.getDate());
			ps.setString(2, ci.getHr());
			ps.setString(3, ci.getMin());

			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public String queryAll2() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkin";
		String show="";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("hr").length()<2) {
					show=show+
							"id:"+rs.getInt("id")+
							"\t日期:"+rs.getString("date")+"\t"+"0"+
							rs.getString("hr")+"點 "
							+rs.getString("min")+"分\n";
				}
				else {
					show=show+
							"id:"+rs.getInt("id")+
							"\t日期:"+rs.getString("date")+"\t"+
							rs.getString("hr")+"點 "
							+rs.getString("min")+"分\n";
				}
			}
		}catch (SQLException e) {
			e.printStackTrace(); }
		return show; 
	}

	@Override
	public CheckIn queryCheckIn(String hr, String min) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkin where hr=? and min=?";
		CheckIn ci=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, hr);
			ps.setString(2, min);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				ci=new CheckIn();
				ci.setId(rs.getInt("id"));
				ci.setName(rs.getString("date"));
				ci.setHr(rs.getString("hr"));
				ci.setMin(rs.getString("min"));
				
			}
			
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return ci;
	}

	@Override
	public void updateCheckIn(CheckIn ci) {
		Connection conn=DbConnection.getDb();
		String SQL="update hw3.checkin set name=?,hr=?,min=? where id=?"; 
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, ci.getDate());
			ps.setString(2, ci.getHr());
			ps.setString(3, ci.getMin());
			ps.setInt(4, ci.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException ee) {
			ee.printStackTrace(); 
			}
	}

	@Override
	public void deleteCheckIn(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from checkin where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}


	@Override
	public String queryCheckin() {
		Object o=cal.readFile("member.txt");
		Member m=(Member) o;
		
		
		Connection conn=DbConnection.getDb();
		String SQL="select * from check_"+m.getUsername();
		String show="";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("hr").length()<2) {
					show=show+
							"id:"+rs.getInt("id")+
							"\t日期:"+rs.getString("date")+"\t"+"0"+
							rs.getString("hr")+"點 "
							+rs.getString("min")+"分\n";
				}
				else {
					show=show+
							"id:"+rs.getInt("id")+
							"\t日期:"+rs.getString("date")+"\t"+
							rs.getString("hr")+"點 "
							+rs.getString("min")+"分\n";
				}
			}
		}catch (SQLException e) {
			e.printStackTrace(); }
		return show; 
	}






}
