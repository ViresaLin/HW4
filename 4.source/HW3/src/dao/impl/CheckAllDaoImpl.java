package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CheckAllDao;
import dao.DbConnection;
import model.CheckAll;
import model.Member;

public class CheckAllDaoImpl implements CheckAllDao{

	public static void main(String[] args) {
		//測試用區域

		/*CheckAll ca=new CheckAll("aaa","2024/06/21","8","30","18","30");
		new CheckAllDaoImpl().addCheckAll(ca);  */
		
		//System.out.println(new CheckAllDaoImpl().queryCheckAll("test", "2024/06/27"));-->OK
		
		System.out.println(new CheckAllDaoImpl().queryAll2());
		
		/*List<CheckAll> l=new CheckAllDaoImpl().selectByNameDate("test","2024/06/16");
		for(CheckAll a:l)
		{ System.out.println(a.getName()+a.getDate()+a.getInhr()+a.getInmin());}*/
		
		
	}
	
	@Override
	public void addCheckAll(String name, String date, String inhr, String inmin, String outhr, String outmin) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into checkall(name,date,inhr,inmin,outhr,outmin) values(?,?,?,?,?,?)";
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
	public void addCheckAll(CheckAll ca) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into checkall(name,date,inhr,inmin,outhr,outmin) values(?,?,?,?,?,?)";
		
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
	public void addCheckAll(String name, String date, String inhr, String inmin) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into checkall(name,date,inhr,inmin) values(?,?,?,?)";
		
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
	public String queryAll2() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkall";
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
	public List<CheckAll> selectByNameDate(String name, String date) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkall where name=? and date=?";
		List<CheckAll> l=new ArrayList();
		PreparedStatement ps;
		try {
			 ps=conn.prepareStatement(SQL);
			ps.setString(1, name);
			ps.setString(2, date);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				CheckAll e=new CheckAll();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setDate(rs.getString("date"));
				e.setInhr(rs.getString("inhr"));
				e.setInmin(rs.getString("inmin"));
				e.setOuthr(rs.getString("outhr"));
				e.setOutmin(rs.getString("outmin"));
				
				l.add(e);
			}
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
		return l;
	}
	

	@Override
	public List<CheckAll> selectByName(String name) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkall where name=? ";
		List<CheckAll> l=new ArrayList();
		PreparedStatement ps;
		try {
			 ps=conn.prepareStatement(SQL);
			ps.setString(1, name);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				CheckAll e=new CheckAll();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setDate(rs.getString("date"));
				e.setInhr(rs.getString("inhr"));
				e.setInmin(rs.getString("inmin"));
				e.setOuthr(rs.getString("outhr"));
				e.setOutmin(rs.getString("outmin"));
				
				l.add(e);
			}
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
		return l;
	}
	

	@Override
	public CheckAll queryCheckAll(String name, String inhr, String inmin, String outhr, String outmin) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkall where name=?,date=?,inhr=?,inmin=?,outhr=? and outmin=?";
		CheckAll ca=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, name);
			ps.setString(2, inhr);
			ps.setString(3, inmin);
			ps.setString(4, outhr);
			ps.setString(5, outmin);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				ca=new CheckAll();
				ca.setId(rs.getInt("id"));
				ca.setName(rs.getString("name"));
				ca.setDate(rs.getString("date"));
				ca.setInhr(rs.getString("inhr"));
				ca.setInmin(rs.getString("inmin"));
				ca.setOuthr(rs.getString("outhr"));
				ca.setOutmin(rs.getString("outmin"));
			}
			
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return ca;
	}
	

	@Override
	public CheckAll queryCheckAll(String name, String date) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkall where name=? and date=?";
		CheckAll c=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, name);
			ps.setString(2, date);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				c=new CheckAll();
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
	public CheckAll queryCheckName(String name) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkall where name=? ";
		CheckAll c=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				c=new CheckAll();
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
	public void updateCheckAll(CheckAll ca) {
		Connection conn=DbConnection.getDb();
		String SQL="update hw3.checkall set name=?,date=?,inhr=?,inmin=?,outhr=?, outmin=? where id=?"; 
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
	public void deleteCheckAll(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from checkall where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public CheckAll queryCheckAllById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from checkall where id=?";
		
		CheckAll c=null;  //如果(rs.next) = F


		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				c=new CheckAll();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDate(rs.getString("date"));
				c.setInhr(rs.getString("inhr"));
				c.setInmin(rs.getString("inmin"));
				c.setOuthr(rs.getString("outhr"));
				c.setOutmin(rs.getString("outmin"));
			}
			
		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		return c;
	}

	
	
}
