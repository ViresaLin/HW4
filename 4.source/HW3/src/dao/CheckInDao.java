package dao;

import model.CheckIn;

public interface CheckInDao {
	//create
	void addCheckIn(String date, String hr, String min);
	void addCheckIn(CheckIn ci);
	
	//read
	String queryAll2();
	
	String queryCheckin();
	CheckIn queryCheckIn(String hr,String min);
	//Check queryHr(String hr);
	
	//update
	void updateCheckIn(CheckIn ci);
	
	//delete
	void deleteCheckIn(int id);
}
