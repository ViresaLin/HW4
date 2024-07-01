package model;

public class CheckNew {
	private Integer id;
	private String name;
	private String date;
	private String inhr;
	private String inmin;
	private String outhr;
	private String outmin;
	
	public CheckNew() {
		super();
	}
	
	public CheckNew(String name, String date,String inhr,String inmin,
			String outhr,String outmin) {
		super();
		this.name = name;
		this.date = date;
		this.inhr = inhr;
		this.inmin = inmin;
		this.outhr = outhr;
		this.outmin = outmin;
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
	public String getInhr() {
		return inhr;
	}
	public void setInhr(String inhr) {
		this.inhr = inhr;
	}
	public String getInmin() {
		return inmin;
	}
	public void setInmin(String inmin) {
		this.inmin = inmin;
	}
	public String getOuthr() {
		return outhr;
	}
	public void setOuthr(String outhr) {
		this.outhr = outhr;
	}
	public String getOutmin() {
		return outmin;
	}
	public void setOutmin(String outmin) {
		this.outmin = outmin;
	}
}
