package dao;

import model.CheckOut;

public interface CheckOutDao {
	//create
	void addCheckOut(String date, String hr, String min);
	void addCheckOut(CheckOut co);
	
	//read
	//List<Check> queryAll();//全部
	String queryAll2();
	//Check queryCheckById(int id);
	
	CheckOut queryCheckOut(String hr,String min);
	//Check queryHr(String hr);
	
	//update
	void updateCheckOut(CheckOut co);
	
	//delete
	void deleteCheckOut(int id);
}
