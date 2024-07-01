package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao{
	public static void main(String[] args) {
				//實時測試用
		
				//new MemberDaoImpl().deleteMember(9);  //ok
				
				/*Member m=new MemberDaoImpl().queryMemberById(7);  //先抓
				m.setName("23"); //資料更改
				m.setPassword("262");
				m.setPhone("6666");
				m.setAddress("高雄");
				
				new MemberDaoImpl().updateMember(m);*/ //ok
				
				//System.out.println(new MemberDaoImpl().queryMemberById(1));
				
				System.out.println(new MemberDaoImpl().queryAll2());
				
				/*List<Member> l=new MemberDaoImpl().queryAll();
				for(Member m:l)
				{ System.out.println(m.getId()+"\t"+m.getName()+"\t"+m.getUsername());}*/
	}

	
	@Override
	public void addMember(String name, String username, String password, String phone, String address) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into member(name,username,password,phone,address) values(?,?,?,?,?)";
	
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, phone);
			ps.setString(5, address);

			ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void addMember(Member m) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into member(name,username,password,phone,address) values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getPhone());
			ps.setString(5, m.getAddress());
			ps.executeUpdate();
		}catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}	
	}

	
	@Override
	public List<Member> queryAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())  //.rs.next() ⇒ T /F 確認有沒有資料
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				
				l.add(m);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	
	@Override
	public String queryAll2() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member";
		String show="";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{ 	show=show+rs.getInt("id")+
						"\tname:"+rs.getString("name")+
						"\t帳號:"+rs.getString("username")+
						"\t密碼:"+rs.getString("password")+
						"\t地址:"+rs.getString("address")+
						"\t電話:"+rs.getString("phone")+"\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); }
		return show; 
	}

	
	@Override
	public Member queryMemberById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where id=?";
		
		Member m=null;  //如果(rs.next) = F


		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
			}
			
		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		return m;
	}

	
	@Override
	public void updateMember(Member m) {
		Connection conn=DbConnection.getDb();
		String SQL="update hw3.member set name=?,password=?,phone=?,address=? where id=?"; 
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getPhone());
			ps.setString(4, m.getAddress());
			ps.setInt(5, m.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace(); }
	}

	
	@Override
	public void deleteMember(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from member where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
}	

		
	@Override
	public Member queryMember(String username, String password) {
			Connection conn=DbConnection.getDb();
			String SQL="select * from member where username=? and password=?";
			Member m=null;
			try {
				PreparedStatement ps=conn.prepareStatement(SQL);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					m=new Member();
					m.setId(rs.getInt("id"));
					m.setName(rs.getString("name"));
					m.setUsername(rs.getString("username"));
					m.setPassword(rs.getString("password"));
					m.setPhone(rs.getString("phone"));
					m.setAddress(rs.getString("address"));
				}
				
			} catch (SQLException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
			return m;
		}

		
	@Override
	public Member queryUsername(String username) {
			Connection conn=DbConnection.getDb();
			String SQL="select * from member where username=?";
			Member m=null;
			try {
				PreparedStatement ps=conn.prepareStatement(SQL);
				ps.setString(1, username);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					m=new Member();
					m.setId(rs.getInt("id"));
					m.setName(rs.getString("name"));
					m.setUsername(rs.getString("username"));
					m.setPassword(rs.getString("password"));
					m.setPhone(rs.getString("phone"));
					m.setAddress(rs.getString("address"));
				}
			} catch (SQLException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
			return m;
		}


	@Override
	public Member queryPhone(String phone) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where phone=?";
		Member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, phone);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
			}		
		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		return m;
	}
	
}
