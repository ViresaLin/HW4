package model;

public class CheckOut {
	private Integer id;
	private String name;
	private String date;
	private String hr;
	private String min;
	
	public CheckOut() {
		super();
	}
	
	public CheckOut(String date,String hr,String min) {
		super();
		//this.name = name;
		this.date = date;
		this.hr = hr;
		this.min = min;
	}
	
	//set&get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHr() {
		return hr;
	}
	public void setHr(String hr) {
		this.hr = hr;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
}
