package dao;

import java.util.List;

import model.CheckAll;
import model.CheckNew;

public interface CheckNewDao {
	//create
	void addCheckNew(String name, String date, String inhr, String inmin, String outhr, String outmin);
	void addCheckNew(String name,CheckNew ca);
	void addCheckNew(String name, String date, String inhr, String inmin);
	void addCheckNewOut(String name, String date, String inhr, String inmin);
	
	//read
	String queryAll2(String name);
	String queryIn(String name);
	String queryOut(String name);
	List<CheckNew> selectByNameDate(String name,String date);
	List<CheckNew> selectByName(String name);
	
	CheckNew queryCheckNew(String name,String inhr, String inmin, String outhr, String outmin);
	CheckNew queryCheckNew(String name,String date);
	CheckNew queryCheckName(String name);
	
	//update
	void updateCheckNew(String name,CheckNew ca);
	
	//delete
	void deleteCheckNew(int id);
}
