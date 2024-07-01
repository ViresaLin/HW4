package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.CheckNewDao;
import dao.DbConnection;
import model.CheckAll;
import model.CheckNew;

public class CheckNewDaoImpl implements CheckNewDao{
	
	public static void main(String[] args) {
		
		CheckNew e=new CheckNewDaoImpl(). queryCheckNew("t", "2024/06/30");  
		System.out.println(e);
		
		e.setName("test"); //資料更改
		e.setOuthr("test");
		e.setOutmin("test");
		
		new CheckNewDaoImpl().updateCheckNew("t",e); 
		
		/*CheckNew ca=new CheckNew("aaa","2024/06/21","8","30","18","30");
		new CheckNewDaoImpl().addCheckNew("aaa",ca);  */
	}

	@Override
	public void addCheckNew(String name, String date, String inhr, String inmin, String outhr, String outmin) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into check_"+name+"(name,date,inhr,inmin,outhr,outmin) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,name );
			ps.setString(2, date);
			ps.setString(3, inhr);
			ps.setString(4, inmin);
			ps.setString(5, outhr);
			ps.setString(6, outmin);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCheckNew(String name, CheckNew ca) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into check_"+name+"(name,date,inhr,inmin,outhr,outmin) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, ca.getName());
			ps.setString(2, ca.getDate());
			ps.setString(3, ca.getInhr());
			ps.setString(4, ca.getInmin());
			ps.setString(5, ca.getOuthr());
			ps.setString(6, ca.getOutmin());

			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	@Override
	public void addCheckNew(String name, String date, String inhr, String inmin) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into checkin_"+name+"(name,date,inhr,inmin) values(?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,name );
			ps.setString(2, date);
			ps.setString(3, inhr);
			ps.setString(4, inmin);

			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public String queryAll2(String name) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from check_"+name;
		String show="";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("inhr").length()<2) {
				show=show+
						//"id:"+
						rs.getInt("id")+
						"\t姓名:"+rs.getString("name")+
						"\t日期:"+rs.getString("date")+
						"\t上班時間:"+"0"+
						rs.getString("inhr")+"： "
						+rs.getString("inmin")+
						"  下班時間:"+
						rs.getString("outhr")+"： "
						+rs.getString("outmin")+"\n";
				}
				else {
					show=show+
					//"id:"+
					rs.getInt("id")+
					"\t姓名:"+rs.getString("name")+
					"\t日期:"+rs.getString("date")+
					"\t上班時間:"+
					rs.getString("inhr")+"： "
					+rs.getString("inmin")+
					"  下班時間:"+
					rs.getString("outhr")+"： "
					+rs.getString("outmin")+"\n";
				}
				
			}
		}catch (SQLException e) {
			e.printStackTrace(); }
		return show; 
	}

	@Override
	public List<CheckNew> selectByNameDate(String name, String date) {
		// TODO Auto-generated method stub
				return null;
	}

	@Override
	public List<CheckNew> selectByName(String name) {
		// TODO Auto-generated method stub
				return null;
	}

	@Override
	public CheckNew queryCheckNew(String name, String inhr, String inmin, String outhr, String outmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckNew queryCheckNew(String name, String date) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from check_"+name+" where name=? and date=?";
		
		CheckNew c=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, name);
			ps.setString(2, date);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				c=new CheckNew();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDate(rs.getString("date"));
				c.setInhr(rs.getString("inhr"));
				c.setInmin(rs.getString("inmin"));
				c.setOuthr(rs.getString("outhr"));
				c.setOutmin(rs.getString("outmin"));
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return c;
	}

	@Override
	public CheckNew queryCheckName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCheckNew(String name,CheckNew ca) {
		Connection conn=DbConnection.getDb();
		String SQL="update hw3.check_"+name+" set name=?,date=?,inhr=?,inmin=?,outhr=?, outmin=? where id=?"; 
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, ca.getName());
			ps.setString(2, ca.getDate());
			ps.setString(3, ca.getInhr());
			ps.setString(4, ca.getInmin());
			ps.setString(5, ca.getOuthr());
			ps.setString(6, ca.getOutmin());
			
			ps.setInt(7, ca.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException ee) {
			ee.printStackTrace(); 
			}
	}

	@Override
	public void deleteCheckNew(int id) {
	
	}

	@Override
	public String queryIn(String name) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkin_"+name;
		String show="";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("inhr").length()<2) {
				show=show+
						//"id:"+
						//rs.getInt("id")+
						//"\t姓名:"+rs.getString("name")+"\t"+
						"日期:"+rs.getString("date")+
						"    上班時間:"+"0"+
						rs.getString("inhr")+"： "
						+rs.getString("inmin")+
						"\n";
				}
				else {
					show=show+
					//"id:"+
					//rs.getInt("id")+
					//"\t姓名:"+rs.getString("name")+"\t"+
					"日期:"+rs.getString("date")+
					"    上班時間:"+
					rs.getString("inhr")+"： "
					+rs.getString("inmin")+
					"\n";
				}
				
			}
		}catch (SQLException e) {
			e.printStackTrace(); }
		return show; 
	}

	@Override
	public String queryOut(String name) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkout_"+name;
		String show="";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				show=show+
						//"id:"+
						//rs.getInt("id")+
						//"\t姓名:"+rs.getString("name")+"\t"+
						"日期:"+rs.getString("date")+
						"    下班時間:"+
						rs.getString("outhr")+"： "
						+rs.getString("outmin")+"\n";
		
				
			}
		}catch (SQLException e) {
			e.printStackTrace(); }
		return show; 
	}

	@Override
	public void addCheckNewOut(String name, String date, String outhr, String outmin) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into checkout_"+name+"(name,date,outhr,outmin) values(?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,name );
			ps.setString(2, date);
			ps.setString(3, outhr);
			ps.setString(4, outmin);

			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}





	
}
