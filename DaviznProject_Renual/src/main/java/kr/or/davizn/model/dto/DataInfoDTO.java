package kr.or.davizn.model.dto;

public class DataInfoDTO {
	private int data_no;
	private String user_storage;
	private String dataname;
	private String datatype;
	private int chartid;
	public int getData_no() {
		return data_no;
	}
	public void setData_no(int data_no) {
		this.data_no = data_no;
	}
	public String getUser_storage() {
		return user_storage;
	}
	public void setUser_storage(String user_storage) {
		this.user_storage = user_storage;
	}
	public String getDataname() {
		return dataname;
	}
	public void setDataname(String dataname) {
		this.dataname = dataname;
	}
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public int getChartid() {
		return chartid;
	}
	public void setChartid(int chartid) {
		this.chartid = chartid;
	}
	
}
