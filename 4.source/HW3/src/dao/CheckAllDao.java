package dao;

import java.util.List;

import model.CheckAll;
import model.Member;

public interface CheckAllDao {
	//create
	void addCheckAll(String name, String date, String inhr, String inmin, String outhr, String outmin);
	void addCheckAll(CheckAll ca);
	void addCheckAll(String name, String date, String inhr, String inmin);
	
	//read
	String queryAll2();
	List<CheckAll> selectByNameDate(String name,String date);
	List<CheckAll> selectByName(String name);
	
	CheckAll queryCheckAll(String name,String inhr, String inmin, 
			String outhr, String outmin);
	CheckAll queryCheckAll(String name,String date);
	CheckAll queryCheckName(String name);
	CheckAll queryCheckAllById(int id);
	
	//update
	void updateCheckAll(CheckAll ca);

	
	//delete
	void deleteCheckAll(int id);
}
